package foc;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;

    public b(c r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        e r5 = this.a.c;
        if (r5 == null) goto L6;
        r5.a(this.b);
    L6:
        if (this.a.getMAutoDismiss() == false) goto L26;
        UDDialog r6 = this.a.getMDialog();
        if (r6 == null) goto L30;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L23;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L12:
        if (Looper.myLooper() == r0.getLooper()) goto L14;
        r0.post(DialogLancet.createDismissRunnable(r6));
        return;
    L30:
        return;
    }
}
