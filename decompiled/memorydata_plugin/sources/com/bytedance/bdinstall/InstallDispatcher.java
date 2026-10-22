package com.bytedance.bdinstall;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.EgdiCallback;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.ticket.TicketInitCallback;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.NetUtils;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class InstallDispatcher implements Handler.Callback, EgdiCallback {
    private static final int MSG_BG_START = 1234;
    private static final int MSG_WORK_ONE = 1235;
    private static final Singleton<NetworkObserver> mObservers = null;
    private final AtomicBoolean isTicketInit;
    private Activator mActivator;
    private final AtomicBoolean mActive;
    private final AppStateListener mAppStateListener;
    private CallbackCenter mCallbackCenter;
    private final InstallOptions mConfig;
    private final DeviceManager mDeviceManager;
    private Env mEnv;
    private long mFetchActiveTime;
    private GWorker mGWorker;
    private final Handler mHandler;
    private Register mRegisterWorker;
    private VerifyTicketWorker mVerifyWorker;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.InstallDispatcher$5, reason: invalid class name */
    class AnonymousClass5 implements TicketInitCallback {
        final /* synthetic */ InstallDispatcher this$0;
        final /* synthetic */ Register val$register;

        AnonymousClass5(InstallDispatcher r1, Register r2) {
            this.this$0 = r1;
            this.val$register = r2;
        }

        @Override // com.bytedance.bdinstall.ticket.TicketInitCallback
        public void onResult(boolean r2) {
            if (r2 == false) goto L4;
            InstallDispatcher.access$600(this.this$0).set(true);
            InstallDispatcher.access$500(this.this$0).getTicketGuardHelper().setTicketParseResultCallback(new AnonymousClass1(this));
        L4:
            InstallDispatcher.access$800(this.this$0, this.val$register);
            InstallDispatcher.access$902(this.this$0, this.val$register);
        }
    }

    static class NetworkObserver {
        private final Context mContext;
        private final AtomicBoolean mHasListenNetwork;
        private final Set<WeakReference<OnNetworkReadyListener>> mListeners;

        interface OnNetworkReadyListener {
            void onNetworkReady();
        }

        public NetworkObserver(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.mListeners = Collections.synchronizedSet(new HashSet());
            this.mHasListenNetwork = new AtomicBoolean(false);
            this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ Context access$1300(NetworkObserver r0) {
            return r0.mContext;
        }

        static /* synthetic */ void access$1400(NetworkObserver r0) {
            r0.notifyObserver();
        }

        static /* synthetic */ Set access$1500(NetworkObserver r0) {
            return r0.mListeners;
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
            PluginBroadcastReceiver r0 = new AnonymousClass1(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            ZeusTransformUtils.registerReceiver(this.mContext, r0, r1, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public synchronized void observe(OnNetworkReadyListener r3) {
            monitor-enter(this);
            OnNetworkReadyListener r4 = (OnNetworkReadyListener) ZeusTransformUtils.wrapperContextForParams(r3, OnNetworkReadyListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            this.mListeners.add(new WeakReference(r4));     // Catch: Throwable -> L6
            tryListenNetChange();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void unObserve(OnNetworkReadyListener r5) {
            monitor-enter(this);
            OnNetworkReadyListener r6 = (OnNetworkReadyListener) ZeusTransformUtils.wrapperContextForParams(r5, OnNetworkReadyListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            Iterator<WeakReference<OnNetworkReadyListener>> r0 = this.mListeners.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (((OnNetworkReadyListener) ZeusTransformUtils.preCheckCast(r1.get(), OnNetworkReadyListener.class, "com.obric.memorydata.plugin")) != r6) goto L5;
            r0.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L14
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

    InstallDispatcher(InstallOptions r3, DeviceManager r4, AppStateListener r5, Env r6) {
        AppStateListener r7 = (AppStateListener) ZeusTransformUtils.wrapperContextForParams(r5, AppStateListener.class, "com.obric.memorydata.plugin");
        this.mActive = new AtomicBoolean(false);
        this.isTicketInit = new AtomicBoolean(false);
        this.mConfig = r3;
        this.mDeviceManager = r4;
        this.mAppStateListener = r7;
        this.mHandler = new Handler(ExecutorUtil.getLooper(r3.getAidString()), this);
        this.mEnv = r6;
    }

    static /* synthetic */ AtomicBoolean access$000(InstallDispatcher r0) {
        return r0.mActive;
    }

    static /* synthetic */ InstallOptions access$100(InstallDispatcher r0) {
        return r0.mConfig;
    }

    static /* synthetic */ Singleton access$1000() {
        return mObservers;
    }

    static /* synthetic */ void access$1100(InstallDispatcher r0, BaseWorker.WorkResult r1, BaseWorker r2) {
        r0.doEventTrack(r1, r2);
    }

    static /* synthetic */ Handler access$1200(InstallDispatcher r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1600(InstallDispatcher r0, GWorker r1) {
        r0.gWokerImmediately(r1);
    }

    static /* synthetic */ Env access$200(InstallDispatcher r0) {
        return r0.mEnv;
    }

    static /* synthetic */ void access$300(InstallDispatcher r0, Activator r1) {
        r0.activeImmediately(r1);
    }

    static /* synthetic */ AppStateListener access$400(InstallDispatcher r0) {
        return r0.mAppStateListener;
    }

    static /* synthetic */ DeviceManager access$500(InstallDispatcher r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ AtomicBoolean access$600(InstallDispatcher r0) {
        return r0.isTicketInit;
    }

    static /* synthetic */ void access$700(InstallDispatcher r0, VerifyTicketWorker r1) {
        r0.verifyImmediately(r1);
    }

    static /* synthetic */ void access$800(InstallDispatcher r0, BaseWorker r1) {
        r0.workAndPostAgain(r1);
    }

    static /* synthetic */ Register access$902(InstallDispatcher r0, Register r1) {
        r0.mRegisterWorker = r1;
        return r1;
    }

    private void active() {
        if (this.mConfig.isAutoActive() == true) goto L5;
        return;
    L5:
        final Runnable r0 = new AnonymousClass2(this);
        this.mAppStateListener.setOnResumeListener(new AnonymousClass3(this, r0));
        if (this.mConfig.isDirectActive() == false) goto L9;
    L7:
        DrLog.d("dispatcher#active isActive");
        r0.run();
        return;
    L9:
        if (this.mAppStateListener.isActive() == true) goto L7;
    }

    private void activeImmediately(Activator r4) {
        DrLog.d("dispatcher#activeImmediately");
        this.mActive.set(true);
        Activator r0 = this.mActivator;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.stop();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mActivator);
    L6:
        this.mActivator = r4;
        workImmediately(r4);
    }

    private boolean checkSilenceBg(BaseWorker r4) {
        if (this.mConfig.isSilenceInBackground() == true) goto L5;
        return false;
    L5:
        if (this.mAppStateListener.isForeground() == false) goto L7;
        return false;
    L7:
        if (DrLog.debug() == false) goto L9;
        DrLog.d("skip work " + r4 + " cause user set silent in bg.");
    L9:
        Handler r3 = this.mHandler;
        r3.sendMessageDelayed(r3.obtainMessage(MSG_WORK_ONE, r4), r4.silenceCheckInterval());
        return true;
    }

    private void doEventTrack(BaseWorker.WorkResult r2, BaseWorker r3) {
        if (r3 != null) goto L4;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r2.errReason != 4) goto L12;
    L5:
        r3.updateFailCount(r2.retryCount);
        r3.onResult(r2.success);
        r3.doEventTrack();
        return;
    L12:
        return;
    L4:
        if (r2.success == false) goto L6;
        goto L5
    }

    private void gWokerImmediately(GWorker r4) {
        DrLog.d("dispatcher# verifyTicketWorker");
        GWorker r0 = this.mGWorker;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.stop();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mGWorker);
    L6:
        this.mGWorker = r4;
        workImmediately(r4);
    }

    private void handleDTrait() {
        if (DTraitConfig.isEnableDTrait() == false) goto L8;
        DTraitService r0 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        r0.getDTraitManager().handleDTrait(this.mDeviceManager.getHeader(), DTraitConstant.BUSINESS_TAG_DEVICE);
        return;
    L9:
        return;
    }

    private boolean handleTicket(Register r4) {
        if (BDInstall.getBDInstallConfig().isEnableDidGuard() == true) goto L5;
    L18:
        return false;
    L5:
        if (this.mDeviceManager.getConstHeader().has("device_id") == true) goto L7;
    L17:
        DrLog.d("TicketGuard#  sp has no did and iid, skip ticket init.");
        goto L18
    L7:
        if (this.mDeviceManager.getConstHeader().has("install_id") == false) goto L17;
        AnonymousClass5 r0 = new AnonymousClass5(this, r4);     // Catch: Exception -> L14
        if (this.isTicketInit.get() == false) goto L12;
        r0.onResult(true);     // Catch: Exception -> L14
    L13:
        return true;
    L12:
        this.mDeviceManager.getTicketGuardHelper().initTicketGuard(this.mConfig, r0);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        DrLog.e(Constants.TAG_TICKET, e);
        return false;
    }

    private void register(Env r5, boolean r6) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new AnonymousClass4(this));
        if (this.mDeviceManager.load() == false) goto L20;
        Register r0 = new Register(this.mConfig, this.mDeviceManager, r5, this.mAppStateListener);
        CallbackCenter r7 = this.mCallbackCenter;
        if (r7 == null) goto L7;
        r7.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
    L7:
        if (r6 == false) goto L9;
    L14:
        r0.setImmediately();
    L16:
        if (handleTicket(r0) == false) goto L19;
        DrLog.d("TicketGuard# handle ticket success");
        return;
    L19:
        workAndPostAgain(r0);
        this.mRegisterWorker = r0;
        return;
    L9:
        if (this.mDeviceManager.isUpgrade() == true) goto L14;
        if (this.mDeviceManager.isDiffChannel() == true) goto L14;
        if (this.mDeviceManager.isDiffAid() == false) goto L16;
    L20:
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r4 = this.mHandler;
        r4.sendMessageDelayed(r4.obtainMessage(MSG_BG_START, Boolean.valueOf(r6)), 1000);
    }

    private void verifyImmediately(VerifyTicketWorker r4) {
        DrLog.d("dispatcher# verifyTicketWorker");
        VerifyTicketWorker r0 = this.mVerifyWorker;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.stop();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mVerifyWorker);
    L6:
        this.mVerifyWorker = r4;
        workImmediately(r4);
    }

    private void workAndPostAgain(final BaseWorker r3) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new AnonymousClass6(this, r3));
    }

    private void workImmediately(BaseWorker r2) {
        workImmediately(r2, false);
    }

    private void workImmediately(BaseWorker r3, boolean r4) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L12;
        if (r3 == null) goto L13;
        r0.removeMessages(MSG_WORK_ONE, r3);
        Message r5 = this.mHandler.obtainMessage(MSG_WORK_ONE, r3.setImmediately());
        if (r4 == true) goto L8;
    L10:
        this.mHandler.sendMessage(r5);
        return;
    L8:
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L10;
        handleMessage(r5);
        return;
    L13:
        return;
    }

    void activeManually() {
        DrLog.d("dispatcher#activeManually");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.mFetchActiveTime) >= 900000) goto L5;
        return;
    L5:
        if (NetUtils.isNetReady((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L10;
        this.mFetchActiveTime = r0;
        activeImmediately(new Activator(this.mConfig, this.mEnv));
        return;
    }

    boolean changeEnv(Env r2, boolean r3) {
        if (this.mEnv.equals(r2) == false) goto L6;
        return false;
    L6:
        this.mEnv = r2;
        this.mDeviceManager.changeEnv(r2, r3);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        int r0 = r4.what;
        if (r0 != MSG_BG_START) goto L5;
        register(this.mEnv, ((Boolean) ZeusTransformUtils.preCheckCast(r4.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return false;
    L5:
        if (r0 != MSG_WORK_ONE) goto L18;
        BaseWorker r5 = (BaseWorker) ZeusTransformUtils.preCheckCast(r4.obj, BaseWorker.class, "com.obric.memorydata.plugin");
        if (checkSilenceBg(r5) == false) goto L11;
        return false;
    L11:
        if (r5.isStop() == true) goto L16;
        workAndPostAgain(r5);
        return false;
    L16:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.bdinstall.callback.EgdiCallback
    public void onEgdiFailed() {
        this.mHandler.postDelayed(new AnonymousClass7(this), BDInstall.getBDInstallConfig().getEgdiRetryInterval());
    }

    boolean reStart(Env r4, boolean r5, boolean r6) {
        if (changeEnv(r4, r6) == true) goto L7;
        if (r5 == true) goto L7;
        DrLog.e("the env is the same with before,ignore." + r4);
        return false;
    L7:
        this.mHandler.removeMessages(MSG_WORK_ONE);
        if (this.mHandler.hasMessages(MSG_BG_START) == false) goto L10;
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(MSG_BG_START, true));
    L15:
        return true;
    L10:
        Register r7 = new Register(this.mConfig, this.mDeviceManager, r4, this.mAppStateListener);
        workImmediately(r7);
        this.mRegisterWorker = r7;
        if (this.mConfig.isAutoActive() == false) goto L15;
        if (this.mActive.get() == false) goto L15;
        activeImmediately(new Activator(this.mConfig, r4));
        goto L15
    }

    void redoRegister() {
        Register r0 = this.mRegisterWorker;
        if (r0 == null) goto L6;
        workImmediately(r0, true);
        return;
    }

    public void setCallbackCenter(CallbackCenter r1) {
        this.mCallbackCenter = r1;
    }

    void start(boolean r2) {
        register(this.mEnv, r2);
        active();
        handleDTrait();
    }
}
