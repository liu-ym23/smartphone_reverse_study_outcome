package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.aimedia.a;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.mpflow.MpflowInterface;

/* JADX INFO: loaded from: classes2.dex */
public class AppSockOptManger {
    private static final int SOCKET_OPT_NODELAY = 0;
    private static final String TAG = "AppSockOptManager";
    private static final int TURN_OFF = 0;
    private static final int TURN_ON = 1;
    private static final MpflowInterface mpflowInterface = null;
    private int mLastEnableUid;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.NetworkAccelerate.AppSockOptManger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$ForegroundAppStrategy = null;

        static {
            int[] r8 = new int[L4NetEvaluate.ForegroundAppStrategy.values().length];
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$ForegroundAppStrategy = r8;
            r8[L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$ForegroundAppStrategy[L4NetEvaluate.ForegroundAppStrategy.NETWORK_HANDOVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        mpflowInterface = new MpflowInterface();
    }

    public AppSockOptManger() {
        this.mLastEnableUid = -1;
    }

    private int setSocketOptByUid(int r8, int r10, int r11) {
        return mpflowInterface.setSocketOptByUid(r8, r10, r11);
    }

    public void appSockOptSet(int r8, L4NetEvaluate.ForegroundAppStrategy r10, boolean r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$ForegroundAppStrategy[r10.ordinal()];
        if (r12 != 1) goto L5;
        int r13 = setSocketOptByUid(0, r11 ? 1 : 0, r8);
        StringBuilder r14 = new StringBuilder("set uid: ");
        r14.append(r8);
        r14.append(" nodelay for ticket grabbing, enable: ");
        r14.append(r11);
        r14.append(", ");
        if (r13 != 0) goto L13;
        String r15 = "success";
    L14:
        a.r(r14, r15, TAG);
        return;
    L13:
        r15 = "failed";
        goto L14
    L5:
        if (r12 == 2) goto L8;
        CaeLog.e(TAG, "unsupported app acc type: " + r10);
        return;
    L8:
        CaeLog.i(TAG, "NETWORK_HANDOVER not support now");
    }

    public void disableSockOptNodelay() {
        int r8 = this.mLastEnableUid;
        if (r8 != (-1)) goto L5;
        return;
    L5:
        appSockOptSet(r8, L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING, false);
        this.mLastEnableUid = -1;
    }

    public void enableSockOptNodelay(int r8) {
        int r10 = this.mLastEnableUid;
        if (r10 != r8) goto L6;
        return;
    L6:
        if (r10 == (-1)) goto L8;
        appSockOptSet(r10, L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING, false);
        this.mLastEnableUid = -1;
    L8:
        appSockOptSet(r8, L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING, true);
        this.mLastEnableUid = r8;
    }

    public void foregroundAppManager(L4NetEvaluate.L4NetForegroundApp r8) {
        int r10 = r8.uid;
        int r11 = this.mLastEnableUid;
        if (r11 != r10) goto L6;
        return;
    L6:
        if (r11 == (-1)) goto L8;
        appSockOptSet(r11, L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING, false);
        this.mLastEnableUid = -1;
    L8:
        L4NetEvaluate.ForegroundAppStrategy r12 = r8.strategy;
        if (r12 == L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING) goto L11;
        return;
    L11:
        appSockOptSet(r10, r12, true);
        this.mLastEnableUid = r10;
    }
}
