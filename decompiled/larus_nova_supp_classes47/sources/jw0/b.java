package jw0;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import j40.f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CashExchangeDialog a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ zv0.e d;

    public b(CashExchangeDialog r1, long r2, long r4, zv0.e r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        int r12 = h.a;
        long r0 = this.b;
        long r4 = this.c;
        long r2 = r0 + r4;
        CashExchangeDialog r13 = this.a;
        int r6 = r13.k;
        ToggleButton r14 = r13.g;
        if (r14 == null) goto L5;
        Boolean r15 = Boolean.valueOf(r14.isChecked());
    L6:
        h.c(r2, r4, r6, 2, r15);
        zv0.e r16 = this.d;
        if (r16 == null) goto L9;
        r16.b();
    L9:
        ToggleButton r17 = this.a.g;
        if (r17 != null) goto L12;
    L14:
        AppCompatDialog r18 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r18);
        if (r1 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(r18);
        r18.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(r18);
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r3 == null) goto L28;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r18);
        throw th;
    L17:
        if (Looper.myLooper() == r1.getLooper()) goto L19;
        r1.post(DialogLancet.createDismissRunnable(r18));
        return;
    L12:
        if (r17.isChecked() != true) goto L14;
        com.bytedance.android.livesdk.sharedpref.e r19 = f4.q;
        Boolean r5 = Boolean.TRUE;
        r19.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r19, r5);
        goto L14
    L5:
        r15 = null;
        goto L6
    }
}
