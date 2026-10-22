package com.obric.cae.smartNetwork.L4NetEvaluate;

import com.obric.cae.log.CaeLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SpecificAppEvaluate {
    private static final String TAG = "SpecificAppEvaluate";
    private final ConcurrentHashMap<Integer, L4NetEvaluate.ErrWindowPara> mAppErrWinMap;
    private final LinkedList<L4NetEvaluate.L4NetErrReportCb> mErrReportCbList;
    private final int mErrWinPeriod;
    private final int mErrWinThreshold;
    private final int mTxRxPktNumThreshold;

    public SpecificAppEvaluate(int r8, int r10, int r11) {
        this.mErrReportCbList = new LinkedList();
        this.mAppErrWinMap = new ConcurrentHashMap();
        this.mErrWinPeriod = r8;
        this.mErrWinThreshold = r10;
        this.mTxRxPktNumThreshold = r11;
    }

    private void pushAppErrWindowAndCheck(L4NetEvaluate.L4NetStats r8, L4NetEvaluate.ErrWindowPara r10) {
        if (r8.sendPackets <= this.mTxRxPktNumThreshold) goto L8;
        if (r8.recvPackets != 0) goto L8;
        CaeLog.i(TAG, "warning, UID:" + r8.uid + " ErrorType:" + L4NetEvaluate.ErrorType.FOREGROUND_APP_NO_DOWNLOAD_ERR);
    L8:
        if (r8.sendPackets != 0) goto L10;
    L12:
        boolean r11 = false;
    L13:
        L4NetEvaluate.windowUpdateAndCheck(r11, r10, r8);
        return;
    L10:
        if (r8.recvPackets != 0) goto L12;
        r11 = true;
        goto L13
    }

    public synchronized boolean registerErrReportCb(L4NetEvaluate.L4NetErrReportCb r8) {
        monitor-enter(this);
        if (r8 != null) goto L9;
        CaeLog.e(TAG, "Invalid callback");     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L9:
        if (this.mErrReportCbList.contains(r8) == false) goto L13;
        CaeLog.e(TAG, "L4NetErrReportCb callback already exist");     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L13:
        boolean r10 = this.mErrReportCbList.add(r8);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r10;
    L16:
        th = move-exception;
        throw th;
    }

    public void setSpecificApp(int r12) {
        if (this.mAppErrWinMap.containsKey(Integer.valueOf(r12)) == false) goto L7;
        StringBuilder r11 = new StringBuilder("setSpecificApp: appUid ");
        r11.append(r12);
        r11.append(" has been set.");
    L5:
        CaeLog.i(TAG, r11.toString());
        return;
    L7:
        this.mAppErrWinMap.put(Integer.valueOf(r12), new L4NetEvaluate.ErrWindowPara(L4NetEvaluate.ErrorType.FOREGROUND_APP_NO_DOWNLOAD_ERR, new LinkedList(), 0, this.mErrWinPeriod, this.mErrWinThreshold));
        r11 = new StringBuilder("setSpecificApp: appUid ");
        r11.append(r12);
        goto L5
    }

    public synchronized void specificAppReport(ConcurrentHashMap<Integer, L4NetEvaluate.L4NetStats> r8) {
        monitor-enter(this);
        Iterator<Map.Entry<Integer, L4NetEvaluate.ErrWindowPara>> r10 = this.mAppErrWinMap.entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<Integer, L4NetEvaluate.ErrWindowPara> r11 = r10.next();     // Catch: Throwable -> L17
        int r12 = r11.getKey().intValue();     // Catch: Throwable -> L17
        L4NetEvaluate.ErrWindowPara r13 = r11.getValue();     // Catch: Throwable -> L17
        L4NetEvaluate.L4NetStats r14 = r8.get(Integer.valueOf(r12));     // Catch: Throwable -> L17
        if (r14 == null) goto L4;
        pushAppErrWindowAndCheck(r14, r13);     // Catch: Throwable -> L17
        Iterator<L4NetEvaluate.L4NetErrReportCb> r15 = this.mErrReportCbList.iterator();     // Catch: Throwable -> L17
    L11:
        if (r15.hasNext() == false) goto L13;
        r15.next().errReportCb(new L4NetEvaluate.L4NetStats(r14));     // Catch: Throwable -> L17
        goto L11
    L13:
        CaeLog.i(TAG, "uidStats: " + r14.toString());     // Catch: Throwable -> L17
        L4NetEvaluate.CleanStatsTempParam(r14);     // Catch: Throwable -> L17
        goto L4
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized boolean unregisterErrReportCb(L4NetEvaluate.L4NetErrReportCb r8) {
        monitor-enter(this);
        if (r8 != null) goto L8;
        CaeLog.e(TAG, "L4NetErrReportCb callback is null");     // Catch: Throwable -> L11
        monitor-exit(this);
        return false;
    L8:
        boolean r10 = this.mErrReportCbList.remove(r8);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L11:
        th = move-exception;
        throw th;
    }
}
