package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.util.NetUtils;
import com.bytedance.bdinstall.util.Singleton;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class InstallDispatcher implements Handler.Callback {
    private static final int MSG_BG_START = 1234;
    private static final int MSG_WORK_ONE = 1235;
    private static final Singleton<NetworkObserver> mObservers = null;
    private Activator mActivator;
    private final AtomicBoolean mActive;
    private final AppStateListener mAppStateListener;
    private CallbackCenter mCallbackCenter;
    private final InstallOptions mConfig;
    private final DeviceManager mDeviceManager;
    private Env mEnv;
    private long mFetchActiveTime;
    private final Handler mHandler;
    private Register mRegisterWorker;

    static class NetworkObserver {
        private final Context mContext;
        private final AtomicBoolean mHasListenNetwork;
        private final Set<WeakReference<OnNetworkReadyListener>> mListeners;

        interface OnNetworkReadyListener {
            void onNetworkReady();
        }

        public NetworkObserver(Context r10) {
            this.mListeners = Collections.synchronizedSet(new HashSet());
            this.mHasListenNetwork = new AtomicBoolean(false);
            this.mContext = r10;
        }

        static /* synthetic */ void access$1000(NetworkObserver r10) {
            r10.notifyObserver();
        }

        static /* synthetic */ Set access$1100(NetworkObserver r10) {
            return r10.mListeners;
        }

        static /* synthetic */ Context access$900(NetworkObserver r10) {
            return r10.mContext;
        }

        private synchronized void notifyObserver() {
            monitor-enter(this);
            ExecutorUtil.runOnFirstHandlerThread(new AnonymousClass2(this));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void tryListenNetChange() {
            if (this.mHasListenNetwork.compareAndSet(false, true) == false) goto L12;
            BroadcastReceiver r10 = new AnonymousClass1(this);
            IntentFilter r11 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            this.mContext.registerReceiver(r10, r11);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public synchronized void observe(OnNetworkReadyListener r10) {
            monitor-enter(this);
            this.mListeners.add(new WeakReference(r10));     // Catch: Throwable -> L6
            tryListenNetChange();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void unObserve(OnNetworkReadyListener r10) {
            monitor-enter(this);
            Iterator<WeakReference<OnNetworkReadyListener>> r11 = this.mListeners.iterator();     // Catch: Throwable -> L14
        L5:
            if (r11.hasNext() == false) goto L12;
            WeakReference<OnNetworkReadyListener> r12 = r11.next();     // Catch: Throwable -> L14
            if (r12 == null) goto L8;
            if (r12.get() != r10) goto L5;
            r11.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r11.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        mObservers = new AnonymousClass1();
    }

    InstallDispatcher(InstallOptions r10, DeviceManager r11, AppStateListener r12, Env r13) {
        this.mActive = new AtomicBoolean(false);
        this.mConfig = r10;
        this.mDeviceManager = r11;
        this.mAppStateListener = r12;
        this.mHandler = new Handler(ExecutorUtil.getLooper(r10.getAidString()), this);
        this.mEnv = r13;
    }

    static /* synthetic */ AtomicBoolean access$000(InstallDispatcher r10) {
        return r10.mActive;
    }

    static /* synthetic */ InstallOptions access$100(InstallDispatcher r10) {
        return r10.mConfig;
    }

    static /* synthetic */ Env access$200(InstallDispatcher r10) {
        return r10.mEnv;
    }

    static /* synthetic */ void access$300(InstallDispatcher r10, Activator r11) {
        r10.activeImmediately(r11);
    }

    static /* synthetic */ AppStateListener access$400(InstallDispatcher r10) {
        return r10.mAppStateListener;
    }

    static /* synthetic */ DeviceManager access$500(InstallDispatcher r10) {
        return r10.mDeviceManager;
    }

    static /* synthetic */ Singleton access$600() {
        return mObservers;
    }

    static /* synthetic */ void access$700(InstallDispatcher r10, BaseWorker.WorkResult r11, BaseWorker r12) {
        r10.doEventTrack(r11, r12);
    }

    static /* synthetic */ Handler access$800(InstallDispatcher r10) {
        return r10.mHandler;
    }

    private void active() {
        if (this.mConfig.isAutoActive() == true) goto L5;
        return;
    L5:
        final Runnable r10 = new AnonymousClass2(this);
        this.mAppStateListener.setOnResumeListener(new AnonymousClass3(this, r10));
        if (this.mConfig.isDirectActive() == false) goto L9;
    L7:
        DrLog.d("dispatcher#active isActive");
        r10.run();
        return;
    L9:
        if (this.mAppStateListener.isActive() == true) goto L7;
    }

    private void activeImmediately(Activator r10) {
        DrLog.d("dispatcher#activeImmediately");
        this.mActive.set(true);
        Activator r11 = this.mActivator;
        if (r11 == null) goto L6;
        if (r10 == null) goto L6;
        r11.stop();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mActivator);
    L6:
        this.mActivator = r10;
        workImmediately(r10);
    }

    private boolean checkSilenceBg(BaseWorker r10) {
        if (this.mConfig.isSilenceInBackground() == true) goto L5;
        return false;
    L5:
        if (this.mAppStateListener.isForeground() == false) goto L7;
        return false;
    L7:
        if (DrLog.debug() == false) goto L9;
        DrLog.d("skip work " + r10 + " cause user set silent in bg.");
    L9:
        Handler r11 = this.mHandler;
        r11.sendMessageDelayed(r11.obtainMessage(MSG_WORK_ONE, r10), r10.silenceCheckInterval());
        return true;
    }

    private void doEventTrack(BaseWorker.WorkResult r10, BaseWorker r11) {
        if (r11 != null) goto L4;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        if (r10.errReason != 4) goto L12;
    L5:
        r11.updateFailCount(r10.retryCount);
        r11.onResult(r10.success);
        r11.doEventTrack();
        return;
    L12:
        return;
    L4:
        if (r10.success == false) goto L6;
        goto L5
    }

    private void register(Env r10, boolean r11) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new AnonymousClass4(this));
        if (this.mDeviceManager.load() == false) goto L16;
        Register r12 = new Register(this.mConfig, this.mDeviceManager, r10, this.mAppStateListener);
        CallbackCenter r13 = this.mCallbackCenter;
        if (r13 == null) goto L7;
        r13.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
    L7:
        if (r11 == false) goto L9;
    L14:
        r12.setImmediately();
    L15:
        workAndPostAgain(r12);
        this.mRegisterWorker = r12;
        return;
    L9:
        if (this.mDeviceManager.isUpgrade() == true) goto L14;
        if (this.mDeviceManager.isDiffChannel() == true) goto L14;
        if (this.mDeviceManager.isDiffAid() == false) goto L15;
    L16:
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r14 = this.mHandler;
        r14.sendMessageDelayed(r14.obtainMessage(MSG_BG_START, Boolean.valueOf(r11)), 1000);
    }

    private void workAndPostAgain(final BaseWorker r10) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new AnonymousClass5(this, r10));
    }

    @AnyThread
    private void workImmediately(BaseWorker r10) {
        workImmediately(r10, false);
    }

    @AnyThread
    private void workImmediately(BaseWorker r10, boolean r11) {
        Handler r12 = this.mHandler;
        if (r12 == null) goto L12;
        if (r10 == null) goto L13;
        r12.removeMessages(MSG_WORK_ONE, r10);
        Message r13 = this.mHandler.obtainMessage(MSG_WORK_ONE, r10.setImmediately());
        if (r11 == true) goto L8;
    L10:
        this.mHandler.sendMessage(r13);
        return;
    L8:
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L10;
        handleMessage(r13);
        return;
    L13:
        return;
    }

    void activeManually() {
        DrLog.d("dispatcher#activeManually");
        long r10 = System.currentTimeMillis();
        if ((r10 - this.mFetchActiveTime) >= 900000) goto L5;
        return;
    L5:
        if (NetUtils.isNetReady(this.mConfig.getContext()) == false) goto L10;
        this.mFetchActiveTime = r10;
        activeImmediately(new Activator(this.mConfig, this.mEnv));
        return;
    }

    boolean changeEnv(Env r10, boolean r11) {
        if (this.mEnv.equals(r10) == false) goto L6;
        return false;
    L6:
        this.mEnv = r10;
        this.mDeviceManager.changeEnv(r10, r11);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r10) {
        int r11 = r10.what;
        if (r11 != MSG_BG_START) goto L5;
        register(this.mEnv, ((Boolean) r10.obj).booleanValue());
        return false;
    L5:
        if (r11 != MSG_WORK_ONE) goto L18;
        BaseWorker r12 = (BaseWorker) r10.obj;
        if (checkSilenceBg(r12) == false) goto L11;
        return false;
    L11:
        if (r12.isStop() == true) goto L16;
        workAndPostAgain(r12);
        return false;
    L16:
        return false;
    L18:
        return false;
    }

    boolean reStart(Env r10, boolean r11, boolean r12) {
        if (changeEnv(r10, r12) == true) goto L7;
        if (r11 == true) goto L7;
        DrLog.e("the env is the same with before,ignore." + r10);
        return false;
    L7:
        this.mHandler.removeMessages(MSG_WORK_ONE);
        if (this.mHandler.hasMessages(MSG_BG_START) == false) goto L10;
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r13 = this.mHandler;
        r13.sendMessage(r13.obtainMessage(MSG_BG_START, Boolean.TRUE));
        return true;
    L10:
        Register r14 = new Register(this.mConfig, this.mDeviceManager, r10, this.mAppStateListener);
        workImmediately(r14);
        this.mRegisterWorker = r14;
        if (this.mConfig.isAutoActive() == true) goto L13;
        return true;
    L13:
        if (this.mActive.get() == false) goto L19;
        activeImmediately(new Activator(this.mConfig, r10));
        return true;
    L19:
        return true;
    }

    @AnyThread
    void redoRegister() {
        Register r10 = this.mRegisterWorker;
        if (r10 == null) goto L6;
        workImmediately(r10, true);
        return;
    }

    public void setCallbackCenter(CallbackCenter r10) {
        this.mCallbackCenter = r10;
    }

    void start(boolean r10) {
        register(this.mEnv, r10);
        active();
    }
}
