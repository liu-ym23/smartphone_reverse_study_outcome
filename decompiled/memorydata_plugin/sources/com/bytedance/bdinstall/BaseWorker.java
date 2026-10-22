package com.bytedance.bdinstall;

import android.content.Context;
import com.bytedance.bdinstall.util.NetUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseWorker {
    private static final long NEXT_CHECK_NET = 60000;
    private static final long NEXT_CHECK_SILENCE = 60000;
    final Context mApp;
    protected BdInstallInstance mBdInstallInstance;
    protected int mFailCount;
    private long mLastTime;
    private InstallDispatcher.NetworkObserver.OnNetworkReadyListener mNetListener;
    private boolean mStop;
    final InstallOptions sOptions;

    @interface Error {
        public static final int ERR_NETWORK = 1;
        public static final int ERR_REQUEST_FAILED = 3;
        public static final int ERR_RETRY_LIMIT_FAILED = 4;
        public static final int ERR_TIME_NOT_READY = 2;
        public static final int UNKNOWN = 0;
    }

    static class WorkResult {
        int errReason;
        long nextDelay;
        int retryCount;
        boolean success;

        WorkResult() {
            this.success = false;
            this.errReason = 0;
            this.nextDelay = 0;
            this.retryCount = 0;
        }
    }

    public BaseWorker(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mFailCount = 0;
        this.mApp = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.sOptions = r4;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(r4.getAid()));
    }

    public BaseWorker(Context r3, InstallOptions r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mFailCount = 0;
        this.mApp = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.sOptions = r4;
        this.mLastTime = r5;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(r4.getAid()));
    }

    public abstract void doEventTrack();

    public abstract boolean doWork();

    public abstract String getName();

    public InstallDispatcher.NetworkObserver.OnNetworkReadyListener getNetObserver() {
        return this.mNetListener;
    }

    public abstract long[] getRetryIntervals();

    boolean isStop() {
        return this.mStop;
    }

    public abstract boolean needListenNetChange();

    public abstract boolean needNet();

    public abstract long nextInterval();

    public abstract void onResult(boolean r1);

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseWorker> T setImmediately() {
        this.mLastTime = 0;
        return this;
    }

    public void setNetObserver(InstallDispatcher.NetworkObserver.OnNetworkReadyListener r3) {
        this.mNetListener = (InstallDispatcher.NetworkObserver.OnNetworkReadyListener) ZeusTransformUtils.wrapperContextForParams(r3, InstallDispatcher.NetworkObserver.OnNetworkReadyListener.class, "com.obric.memorydata.plugin");
    }

    long silenceCheckInterval() {
        return 60000;
    }

    public void stop() {
        this.mStop = true;
    }

    public abstract void updateFailCount(int r1);

    /* JADX WARN: Multi-variable type inference failed */
    final WorkResult work() {
        boolean r1 = true;
        int r2 = 1;
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        if (needNet() == true) goto L5;
    L8:
        Object[] r0 = true;
    L9:
        WorkResult r5 = new WorkResult();
        if (r0 == true) goto L12;
        long r6 = 60000;
        DrLog.e("network not ready. delay 60000 ms do " + getName());
    L26:
        r5.errReason = r2;
        r5.success = r4;
        r5.nextDelay = r6;
        return r5;
    L12:
        long r7 = this.mLastTime + nextInterval();
        long r8 = System.currentTimeMillis();
        if (r7 <= (1000 + r8)) goto L28;
        r6 = r7 - r8;
        r2 = 2;
        DrLog.d(getName() + "time not ready. need " + r6);
        goto L26
    L28:
        boolean r9 = doWork();     // Catch: Exception -> L16
    L18:
        if (r9 == false) goto L20;
        r5.retryCount = this.mFailCount;
        this.mFailCount = 0;
        this.mLastTime = System.currentTimeMillis();
        r6 = nextInterval();
    L24:
        DrLog.i(getName() + " worked:" + r9 + " " + r6, null);
        int r10 = r3;
        r4 = r1;
        r2 = r10;
        goto L26
    L20:
        long[] r11 = getRetryIntervals();
        int r12 = this.mFailCount;
        int r13 = r12 + 1;
        this.mFailCount = r13;
        int r14 = r12 % r11.length;
        long r15 = r11[r14];
        if (r14 != (r11.length - 1)) goto L23;
        r5.retryCount = r13;
        r6 = r15;
        r3 = 4;
        r1 = false;
        goto L24
    L23:
        r1 = false;
        r6 = r15;
        r3 = 3;
    L16:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("worer", e);
        r9 = false;
        goto L18
    L5:
        if (NetUtils.isNetReady(this.mApp) == true) goto L8;
        r0 = false;
        goto L9
    }
}
