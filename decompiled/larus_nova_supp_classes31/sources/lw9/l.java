package lw9;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;
import mn7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements a {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ Ref.ObjectRef<l0> b;

    public final void a() {
    }

    public final void b() {
    }

    public final void dismiss() {
        l0 r0 = (l0) this.b.element;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public final void show() {
        if (this.a == null) goto L15;
        Ref.ObjectRef<l0> r0 = this.b;
        r0.element = new l0(this.a, 0.0f, false, 6);
        l0 r1 = (l0) this.b.element;
        if (r1 != null) goto L7;
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    }

    public l(Activity r1, Ref.ObjectRef<l0> r2) {
        this.a = r1;
        this.b = r2;
    }
}
