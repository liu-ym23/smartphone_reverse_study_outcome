package sx1;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.sharedpref.f;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.a("no_wifi_continue");
        c r5 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.d0;
        Long r1 = Long.valueOf(System.currentTimeMillis());
        r6.getClass();
        f.d(r6, r1);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }
}
