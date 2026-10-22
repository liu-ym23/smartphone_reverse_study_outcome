package com.obric.cae.smartNetwork.L4NetEvaluate;

import android.content.Context;
import android.content.IntentFilter;
import com.cae.caed.net.IL4NetInfoUpdateCb;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class L4NetTracker {
    private static final int DEFAULT_INTERVAL = 1000;
    private static final int MIN_INTERVAL = 100;
    public static final int SCREEN_OFF_TIMER_INTERVAL = 10;
    public static final int SCREEN_OFF_TIMER_OUT_THRESHOLD = 3;
    private static final String TAG = "L4NetTracker";
    private static L4NetTracker mNetTracker;
    public static int mScreenOffTimerCnt;
    private final IL4NetInfoUpdateCb getNetInfoCb;
    private Context mContext;
    private int mInterval;
    private volatile boolean mIsRunning;
    private NefidInterface mNefidInterface;
    private L4NetInfoReportCallback mNetInfoCb;
    private final ConcurrentLinkedDeque<ScreenOffEventCallback> mScreenOffEventCbList;
    private final ConcurrentLinkedDeque<ScreenOffPeriodicCallback> mScreenOffPeriodicCbList;
    private int mScreenState;
    private Semaphore mSem;
    private Thread mTrackerThread;

    public interface L4NetInfoReportCallback {
        void onNetInfoReport(L4NetTcpInfo r8);

        void onNetInfoReportFinished();
    }

    public interface ScreenOffEventCallback {
        void onScreenOffEvent();
    }

    public interface ScreenOffPeriodicCallback {
        void onScreenOffPeriodic(int r8);
    }

    private L4NetTracker(Context r8) {
        this.mIsRunning = false;
        this.mInterval = 1000;
        this.mScreenOffPeriodicCbList = new ConcurrentLinkedDeque();
        this.mScreenOffEventCbList = new ConcurrentLinkedDeque();
        this.getNetInfoCb = new AnonymousClass1(this);
        this.mContext = r8.getApplicationContext();
    }

    public static /* synthetic */ void a(L4NetTracker r8) {
        r8.lambda$start$0();
    }

    public static /* synthetic */ L4NetInfoReportCallback access$000(L4NetTracker r8) {
        return r8.mNetInfoCb;
    }

    public static /* synthetic */ int access$102(L4NetTracker r8, int r10) {
        r8.mScreenState = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(L4NetTracker r8) {
        r8.runScreenOffEventCallback();
    }

    public static /* synthetic */ Semaphore access$300(L4NetTracker r8) {
        return r8.mSem;
    }

    private boolean blockAndWaitScreenOn() {
    L13:
        e = move-exception;
        CaeLog.e(TAG, "L4NetTracker mSem.acquire interrupted", e);
        return false;
    L4:
        if (mScreenOffTimerCnt < 3) goto L6;
        CaeLog.i(TAG, "screen off timer out, block and wait screen on");     // Catch: InterruptedException -> L13
        this.mSem.acquire();     // Catch: InterruptedException -> L13
    L9:
        mScreenOffTimerCnt = 0;     // Catch: InterruptedException -> L13
        return true;
    L6:
        if (this.mSem.tryAcquire(10, TimeUnit.SECONDS) == true) goto L9;
        mScreenOffTimerCnt++;     // Catch: InterruptedException -> L13
        runScreenOffPeriodicCallback();     // Catch: InterruptedException -> L13
        return false;
    }

    public static synchronized L4NetTracker getInstance(Context r8) {
        monitor-enter(L4NetTracker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mNetTracker != null) goto L7;
        mNetTracker = new L4NetTracker(r8);     // Catch: Throwable -> L10
    L7:
        L4NetTracker r10 = mNetTracker;     // Catch: Throwable -> L10
        monitor-exit(L4NetTracker.class);
        return r10;
    }

    private void initScreenStateReceiver() {
        this.mScreenState = CaeUtil.getScreenState(this.mContext);
        CaeLog.d(TAG, "initScreenStateReceiver mScreenState = " + this.mScreenState);
        this.mSem = new Semaphore(0);
        IntentFilter r8 = defpackage.a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(new AnonymousClass2(this), r8);
    }

    private /* synthetic */ void lambda$start$0() {
    L3:
        if (this.mIsRunning == false) goto L21;
    L5:
        if (this.mIsRunning == false) goto L11;
        if (this.mScreenState != 0) goto L11;
        if (blockAndWaitScreenOn() == false) goto L5;
    L11:
        if (this.mIsRunning == false) goto L33;
        if (this.mNefidInterface.getL4NetInfo(this.getNetInfoCb) == true) goto L16;
        CaeLog.e(TAG, "getL4NetInfo failed");
    L16:
        this.mNetInfoCb.onNetInfoReportFinished();
        Thread.sleep(this.mInterval);     // Catch: InterruptedException -> L19
    L19:
        e = move-exception;
        CaeLog.e(TAG, "L4NetTracker thread interrupted", e);
        goto L3
    L33:
        return;
    }

    private void runScreenOffEventCallback() {
        Iterator<ScreenOffEventCallback> r8 = this.mScreenOffEventCbList.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onScreenOffEvent();
        goto L4
    }

    private void runScreenOffPeriodicCallback() {
        Iterator<ScreenOffPeriodicCallback> r8 = this.mScreenOffPeriodicCbList.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onScreenOffPeriodic(mScreenOffTimerCnt);
        goto L4
    }

    public int getInterval() {
        return this.mInterval;
    }

    public boolean setInterval(int r8) {
        if (this.mIsRunning == false) goto L6;
        String r10 = "L4NetTracker is Running";
    L8:
        CaeLog.e(TAG, r10);
        return false;
    L6:
        if (r8 >= 100) goto L10;
        r10 = defpackage.a.d("Invalid interval: ", r8);
        goto L8
    L10:
        this.mInterval = r8;
        return true;
    }

    public boolean setNetInfoReportCallback(L4NetInfoReportCallback r8) {
        if (r8 != null) goto L8;
        String r10 = "Invalid callback";
    L5:
        CaeLog.e(TAG, r10);
        return false;
    L8:
        if (this.mIsRunning == false) goto L10;
        r10 = "L4NetTracker is Running";
        goto L5
    L10:
        this.mNetInfoCb = r8;
        return true;
    }

    public void setScreenOffEventCallback(ScreenOffEventCallback r8) {
        if (r8 == null) goto L5;
        this.mScreenOffEventCbList.add(r8);
        return;
    }

    public void setScreenOffPeriodicCallback(ScreenOffPeriodicCallback r8) {
        if (r8 == null) goto L5;
        this.mScreenOffPeriodicCbList.add(r8);
        return;
    }

    public boolean start() {
        if (this.mIsRunning == false) goto L6;
        CaeLog.e(TAG, "Already started");
        return false;
    L6:
        this.mIsRunning = true;
        initScreenStateReceiver();
        this.mNefidInterface = NefidInterface.getInstance(this.mContext);
        Thread r8 = new Thread(new androidx.activity.d(this, 23), "L4NetTrackerThread");
        this.mTrackerThread = r8;
        r8.start();
        return true;
    }

    public void stop() {
        if (this.mIsRunning == true) goto L6;
        CaeLog.e(TAG, "Already stopped");
        return;
    L6:
        this.mIsRunning = false;
        Thread r8 = this.mTrackerThread;
        if (r8 != null) goto L9;
        return;
    L9:
        r8.interrupt();
        this.mTrackerThread.join();     // Catch: InterruptedException -> L12
    L14:
        CaeLog.i(TAG, "L4NetTracker stopped");
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "L4NetTracker thread join interrupted", e);
        goto L14
    }
}
