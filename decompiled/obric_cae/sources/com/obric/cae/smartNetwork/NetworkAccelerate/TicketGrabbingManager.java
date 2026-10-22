package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.aimedia.a;
import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTracker;
import com.obric.cae.utils.AppPerformanceManger;
import com.obric.cae.utils.CaeUtil;
import ha.j;

/* JADX INFO: loaded from: classes2.dex */
public class TicketGrabbingManager {
    private static final String TAG = "TicketGrabbingManager";
    private boolean isAccEnable;
    private final AppPerformanceManger mAppPerformanceManger;
    private final AppSockOptManger mAppSockOptManger;
    private final CellularAccelerate mCellularAccelerate;
    private final Context mContext;
    private final L4NetEvaluateObserver mObserver;

    public TicketGrabbingManager(Context r8, L4NetTracker r10) {
        this.isAccEnable = false;
        this.mContext = r8.getApplicationContext();
        this.mObserver = L4NetEvaluateObserver.getInstance(r8);
        this.mAppPerformanceManger = new AppPerformanceManger(r10);
        this.mAppSockOptManger = new AppSockOptManger();
        this.mCellularAccelerate = new CellularAccelerate(r8);
        CaeLog.i(TAG, "isTicketGrabbingSupported: " + isTicketGrabbingSupported());
        r10.setScreenOffEventCallback(new AnonymousClass1(this));
    }

    public static /* synthetic */ boolean access$000(TicketGrabbingManager r8) {
        return r8.isAccEnable;
    }

    public static /* synthetic */ boolean access$002(TicketGrabbingManager r8, boolean r10) {
        r8.isAccEnable = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(TicketGrabbingManager r8) {
        r8.disableTicketGrabbingAcc();
    }

    private void disableTicketGrabbingAcc() {
        CaeLog.i(TAG, "disableTicketGrabbingAcc");
        this.mAppPerformanceManger.disablePerformanceSchedMode();
        this.mCellularAccelerate.disableCellularAcc();
    }

    private void enableTicketGrabbingAcc(L4NetEvaluate.L4NetForegroundApp r8) {
        if (isTicketGrabbingSupported() == false) goto L8;
        if (r8 == null) goto L9;
        a.r(new StringBuilder("enableTicketGrabbingAcc: "), r8.appPackageName, TAG);
        this.mAppPerformanceManger.enablePerformanceSchedMode(r8.pid);
        this.mAppSockOptManger.enableSockOptNodelay(r8.uid);
        this.mCellularAccelerate.enableCellularAcc(r8.uid);
        return;
    L9:
        return;
    }

    private boolean isAppInTicketGrabbingWhiteList(String r8) {
        String r10 = this.mObserver.getTicketGrabbingWhiteList();
        if (r10 != null) goto L5;
    L15:
        CaeLog.e(TAG, "ticketGrabbingWhiteListStr is null or empty");
        return false;
    L5:
        if (r10.isEmpty() == true) goto L15;
        String[] r11 = (String[]) new j().c(String[].class, r10);
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L14;
        if (r8.equals(r11[r13]) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public boolean isTicketGrabbingSupported() {
        return CaeUtil.isTicketGrabbingSupported(this.mContext);
    }

    public void tryUpdateTicketGrabbingStrategy(L4NetEvaluate.L4NetForegroundApp r8) {
        if (isAppInTicketGrabbingWhiteList(r8.appPackageName) == false) goto L10;
        if (ForegroundActivityTracker.isForegroundActivityTarget(this.mContext, r8.appPackageName) == false) goto L10;
        r8.strategy = L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING;
        if (this.isAccEnable == true) goto L14;
        CaeLog.i(TAG, "enable ticket grabbing acc");
        enableTicketGrabbingAcc(r8);
        boolean r10 = true;
    L12:
        this.isAccEnable = r10;
        return;
    L14:
        return;
    L10:
        if (this.isAccEnable == false) goto L15;
        CaeLog.i(TAG, "disable ticket grabbing acc");
        disableTicketGrabbingAcc();
        r10 = false;
        goto L12
    }
}
