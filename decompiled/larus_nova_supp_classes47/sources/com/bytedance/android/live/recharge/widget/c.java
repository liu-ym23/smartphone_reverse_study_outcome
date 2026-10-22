package com.bytedance.android.live.recharge.widget;

import com.android.ttcjpaysdk.base.service.IErrorInfo;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements IPayLifecycle {
    public final RechargeDialogContext a;

    public final void onConfirm(IErrorInfo r1) {
    }

    public final void onInitEnd(IErrorInfo r1) {
    }

    public final void onInitStart() {
    }

    public final void onPayMethodChange() {
    }

    public final void onRefreshEnd(IErrorInfo r1) {
    }

    public final void onRefreshStart() {
    }

    public c(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        this.a = r2;
    }

    public final void onPayMsgUpdate(Map<PayMsg, ? extends Object> r6) {
        HashMap r0 = new HashMap();
        PayMsg r1 = PayMsg.BTN_DESC;
        Object r2 = null;
        if (r6 == null) goto L5;
        Object r3 = r6.get(r1);
    L7:
        if ((r3 instanceof String) == true) goto L9;
        r3 = null;
    L9:
        String r4 = (String) r3;
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r0.put(r1, r4);
        PayMsg r7 = PayMsg.PAY_AMOUNT;
        if (r6 == null) goto L15;
        Object r8 = r6.get(r7);
    L17:
        if ((r8 instanceof String) == false) goto L20;
        r2 = r8;
    L20:
        String r9 = (String) r2;
        if (r9 == null) goto L24;
        r5 = r9;
    L24:
        r0.put(r7, r5);
        this.a.getBtnContent().a(r0);
        return;
    L15:
        r8 = null;
        goto L17
    L5:
        r3 = null;
        goto L7
    }
}
