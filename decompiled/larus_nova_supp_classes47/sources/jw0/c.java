package jw0;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.n;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;
import com.bytedance.android.live.recharge.order.BusinessType;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import j40.f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CashExchangeDialog a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ zv0.e d;

    public c(CashExchangeDialog r1, long r2, long r4, zv0.e r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        int r0 = h.a;
        long r2 = this.b;
        long r6 = this.c;
        long r4 = r2 + r6;
        CashExchangeDialog r1 = this.a;
        int r8 = r1.k;
        ToggleButton r3 = r1.g;
        if (r3 == null) goto L5;
        Boolean r10 = Boolean.valueOf(r3.isChecked());
    L6:
        h.c(r4, r6, r8, 1, r10);
        ToggleButton r5 = this.a.g;
        if (r5 != null) goto L9;
    L11:
        CashExchangeDialog r7 = this.a;
        long r9 = this.c;
        zv0.e r12 = this.d;
        r7.getClass();
        new com.bytedance.android.live.revenue.common.g("CashExchangeDialog", null).b("buyDiamond begin.");
        n r13 = new n((int) r9, 0, 0);
        com.bytedance.android.live.recharge.order.a r14 = com.bytedance.android.live.recharge.core.f.i(RechargeServices.b());
        j r15 = new j();
        r15.e("gift_sendgift");
        r15.d("");
        r15.c("");
        com.bytedance.android.live.recharge.order.f.b r16 = r14.u1(r13, new k(r15, null, false, 0, false, false, 0, 0, null, null, null, 8190), BusinessType.ExchangeOnly);
        com.bytedance.android.live.revenue.common.reactive.j.a(r16.c, true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new f(r16, r9, r12));
        AppCompatDialog r17 = this.a;
        Handler r18 = DialogLancet.resolveDialogHandler(r17);
        if (r18 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r17);
        r17.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L26:
        DialogLancet.afterDialogDismiss(r17);
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r19 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r19 == null) goto L26;
        com.bytedance.crash.d.d(r19, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r17);
        throw th;
    L14:
        if (Looper.myLooper() == r18.getLooper()) goto L16;
        r18.post(DialogLancet.createDismissRunnable(r17));
        return;
    L9:
        if (r5.isChecked() != true) goto L11;
        com.bytedance.android.livesdk.sharedpref.e r20 = f4.q;
        Boolean r23 = Boolean.TRUE;
        r20.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r20, r23);
        goto L11
    L5:
        r10 = null;
        goto L6
    }
}
