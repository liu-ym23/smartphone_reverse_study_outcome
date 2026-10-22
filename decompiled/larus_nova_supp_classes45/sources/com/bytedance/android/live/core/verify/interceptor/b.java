package com.bytedance.android.live.core.verify.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements t80.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ t80.a b;
    public final /* synthetic */ Activity c;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    @Override // t80.a
    public final void onVerifyResult(int r7) {
        ALogger.i("MinorInterceptor", "verify with old live certification，verifyTypes: " + this.a + ", resultCode：" + r7);
        t80.a r0 = this.b;
        if (r0 == null) goto L7;
        r0.onVerifyResult(r7);
        return;
    L7:
        if (r7 != 3) goto L9;
    L18:
        int r1 = do0.a.a;
        do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT, r7, "", "", "");
        return;
    L9:
        if (r7 != 2) goto L18;
        Activity r2 = this.c;
        String r3 = s1.B(2131920460);
        String r4 = s1.B(2131914411);
        a r5 = a.a;
        x0.d r6 = new x0.d();
        r6.b = r2;
        r6.a = 0;
        r6.d = r3;
        x0.c[] r8 = r6.g;
        x0.c r9 = r8[0];
        if (r9 != null) goto L13;
        r9 = new x0.c();
        r8[0] = r9;
    L13:
        r9.a = r4;
        r9.b = r5;
        x0 r11 = new x0(r6.b, r6);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r11);
        goto L18
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L18
    }

    public b(int r1, t80.a r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
