package com.bytedance.android.live.network.impl.interceptor;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements DialogInterface.OnClickListener {
    public final /* synthetic */ u.a a;

    public s(u.a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        t80.a r5 = this.a.b;
        if (r5 == null) goto L5;
        r5.onVerifyResult(0);
    L5:
        int r6 = do0.a.a;
        do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_CANCEL_CLICK, this.a.c, "", "", "");
        r3.dismiss();
    }
}
