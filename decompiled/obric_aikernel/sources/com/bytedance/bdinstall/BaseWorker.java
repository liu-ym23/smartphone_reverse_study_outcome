package com.bytedance.bdinstall;

import android.content.Context;
import com.bytedance.bdinstall.util.NetUtils;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseWorker {
    private static final long NEXT_CHECK_NET = 60000;
    private static final long NEXT_CHECK_SILENCE = 60000;
    final Context mApp;
    protected BdInstallInstance mBdInstallInstance;
    private int mFailCount;
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

        @Error
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

    protected BaseWorker(Context r10, InstallOptions r11) {
        this.mFailCount = 0;
        this.mApp = r10;
        this.sOptions = r11;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(r11.getAid()));
    }

    protected BaseWorker(Context r10, InstallOptions r11, long r12) {
        this.mFailCount = 0;
        this.mApp = r10;
        this.sOptions = r11;
        this.mLastTime = r12;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(r11.getAid()));
    }

    protected abstract void doEventTrack();

    protected abstract boolean doWork();

    protected abstract String getName();

    public InstallDispatcher.NetworkObserver.OnNetworkReadyListener getNetObserver() {
        return this.mNetListener;
    }

    protected abstract long[] getRetryIntervals();

    boolean isStop() {
        return this.mStop;
    }

    public abstract boolean needListenNetChange();

    protected abstract boolean needNet();

    protected abstract long nextInterval();

    protected abstract void onResult(boolean r10);

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseWorker> T setImmediately() {
        this.mLastTime = 0;
        return this;
    }

    public void setNetObserver(InstallDispatcher.NetworkObserver.OnNetworkReadyListener r10) {
        this.mNetListener = r10;
    }

    long silenceCheckInterval() {
        return VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
    }

    protected void stop() {
        this.mStop = true;
    }

    protected abstract void updateFailCount(int r10);

    /* JADX WARN: Multi-variable type inference failed */
    final WorkResult work() {
        boolean r10 = true;
        int r11 = 1;
        int r12 = 0;
        boolean r13 = false;
        r13 = false;
        if (needNet() == true) goto L5;
    L8:
        Object[] r14 = true;
    L9:
        WorkResult r15 = new WorkResult();
        if (r14 == true) goto L12;
        long r16 = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        DrLog.e("network not ready. delay " + VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER + " ms do " + getName());
    L26:
        r15.errReason = r11;
        r15.success = r13;
        r15.nextDelay = r16;
        return r15;
    L12:
        long r17 = this.mLastTime + nextInterval();
        long r18 = System.currentTimeMillis();
        if (r17 <= (1000 + r18)) goto L28;
        r16 = r17 - r18;
        r11 = 2;
        DrLog.d("time not ready. need " + r16);
        goto L26
    L28:
        boolean r19 = doWork();     // Catch: Exception -> L16
    L18:
        if (r19 == false) goto L20;
        r15.retryCount = this.mFailCount;
        this.mFailCount = 0;
        this.mLastTime = System.currentTimeMillis();
        r16 = nextInterval();
    L24:
        DrLog.i(getName() + " worked:" + r19 + " " + r16, null);
        int r110 = r12;
        r13 = r10;
        r11 = r110;
        goto L26
    L20:
        long[] r20 = getRetryIntervals();
        int r21 = this.mFailCount;
        int r22 = r21 + 1;
        this.mFailCount = r22;
        int r23 = r21 % r20.length;
        long r24 = r20[r23];
        if (r23 != (r20.length - 1)) goto L23;
        r15.retryCount = r22;
        r16 = r24;
        r12 = 4;
        r10 = false;
        goto L24
    L23:
        r10 = false;
        r16 = r24;
        r12 = 3;
    L16:
        e = move-exception;
        DrLog.ysnp(e);
        r19 = false;
        goto L18
    L5:
        if (NetUtils.isNetReady(this.mApp) == true) goto L8;
        r14 = false;
        goto L9
    }
}
