package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class DownloaderWorkMonitor {
    private static final int DOWNLOADER_CHECK_CONTINUOUS_COUNT = 5;
    private static final String DOWNLOADER_PACKAGE_NAME = "com.obric.downloadserver";
    private static final int DOWNLOADER_WORK_CHECK_MESSAGE = 1;
    public static final int DOWNLOADER_WORK_STATE_IDLE = 0;
    public static final int DOWNLOADER_WORK_STATE_WORKING = 1;
    private static final int POLL_INTERVAL_MS = 1000;
    private static final String TAG = "DownloaderWorkMonitor";
    private final Context mContext;
    private int mDownloaderUid;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final L4NetEvaluate mL4NetEvaluate;
    private final Object mLock;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final PowerManager mPowerManager;
    private final LinkedList<Integer> mRecvPacketsBuffer;
    private final BroadcastReceiver mScreenReceiver;

    public DownloaderWorkMonitor(Context r8, NetworkPolicyCenter r10) {
        this.mDownloaderUid = -1;
        this.mRecvPacketsBuffer = new LinkedList();
        this.mLock = new Object();
        this.mScreenReceiver = new AnonymousClass2(this);
        this.mContext = r8;
        this.mNetworkPolicyCenter = r10;
        this.mPowerManager = (PowerManager) r8.getSystemService("power");
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        HandlerThread r11 = new HandlerThread("DownloaderWorkMonitorThread");
        this.mHandlerThread = r11;
        r11.start();
        final Looper r12 = r11.getLooper();
        this.mHandler = new AnonymousClass1(this, r12);
        this.mDownloaderUid = getDownloaderUid();
    }

    public static /* synthetic */ Object access$000(DownloaderWorkMonitor r8) {
        return r8.mLock;
    }

    public static /* synthetic */ void access$100(DownloaderWorkMonitor r8) {
        r8.checkDownloaderWork();
    }

    public static /* synthetic */ void access$200(DownloaderWorkMonitor r8) {
        r8.startDownloaderWorkCheck();
    }

    public static /* synthetic */ void access$300(DownloaderWorkMonitor r8) {
        r8.stopDownloaderWorkCheck();
    }

    private void checkDownloaderWork() {
        int r8 = this.mDownloaderUid;
        if (r8 > 0) goto L7;
        CaeLog.w(TAG, "downloader uid invalid: " + this.mDownloaderUid);
        this.mDownloaderUid = getDownloaderUid();
    L5:
        this.mHandler.sendEmptyMessageDelayed(1, 1000);
        return;
    L7:
        L4NetEvaluate.UidNetifRateStats r10 = this.mL4NetEvaluate.getUidNetifRateStats(r8);
        if (r10 != null) goto L12;
        NetworkPolicyCenter r11 = this.mNetworkPolicyCenter;
    L10:
        Message r12 = r11.obtainMessage(20, 0, 0);
    L11:
        this.mNetworkPolicyCenter.sendMessage(r12);
        goto L5
    L12:
        this.mRecvPacketsBuffer.add(Integer.valueOf(r10.totalQosStats.recvPackets));
        if (this.mRecvPacketsBuffer.size() <= 5) goto L16;
        this.mRecvPacketsBuffer.removeFirst();
    L16:
        if (this.mRecvPacketsBuffer.size() < 5) goto L5;
        Iterator<Integer> r13 = this.mRecvPacketsBuffer.iterator();
        int r14 = 0;
    L19:
        if (r13.hasNext() == false) goto L21;
        r14 = r14 + r13.next().intValue();
        goto L19
    L21:
        int r15 = r14 / this.mRecvPacketsBuffer.size();
        r11 = this.mNetworkPolicyCenter;
        if (r15 <= 0) goto L10;
        r12 = r11.obtainMessage(20, 1, 0);
        goto L11
    }

    private int getDownloaderUid() {
        return this.mContext.getPackageManager().getPackageUid("com.obric.downloadserver", 0);
    L4:
        CaeLog.w(TAG, "downloader package not found: com.obric.downloadserver");
        return -1;
    }

    private void startDownloaderWorkCheck() {
        if (this.mHandler.hasMessages(1) == true) goto L6;
        CaeLog.i(TAG, "start downloader work check");
        this.mHandler.sendEmptyMessage(1);
        return;
    }

    private void stopDownloaderWorkCheck() {
        this.mHandler.removeMessages(1);
        this.mRecvPacketsBuffer.clear();
    }

    public void start() {
        CaeLog.i(TAG, "start DownloaderWorkMonitor");
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.SCREEN_ON");
        r8.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenReceiver, r8);
        if (this.mPowerManager.isInteractive() == false) goto L6;
        startDownloaderWorkCheck();
        return;
    }

    public void stop() {
        CaeLog.i(TAG, "stop DownloaderWorkMonitor");
        Object r8 = this.mLock;
        monitor-enter(r8);
        stopDownloaderWorkCheck();     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        this.mContext.unregisterReceiver(this.mScreenReceiver);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
