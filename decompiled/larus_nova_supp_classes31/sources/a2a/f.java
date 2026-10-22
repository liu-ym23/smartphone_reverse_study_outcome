package a2a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.UIUtils;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements yhc.h {
    public static final f a = null;
    public static WeakReference<Dialog> b;
    public static WeakReference<Dialog> c;
    public static final boolean d = false;

    public f() {
    }

    static {
        a = new f();
        d = true;
    }

    public static void d() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L18;
        q r1 = new q(r0, d);
        r1.setOnDismissListener(new e());
        c = new WeakReference(r1);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    }

    public final boolean b() {
        WeakReference<Dialog> r0 = b;
        if (r0 == null) goto L7;
        Dialog r1 = r0.get();
        if (r1 == null) goto L7;
        boolean r2 = r1.isShowing();
    L8:
        if (r2 == true) goto L15;
        WeakReference<Dialog> r3 = c;
        if (r3 == null) goto L16;
        Dialog r4 = r3.get();
        if (r4 != null) goto L14;
        return r2;
    L14:
        return r4.isShowing();
    L16:
        return r2;
    L15:
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    public static void c(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void a(int r3) {
        if (r3 != (-2)) goto L5;
        Activity r4 = AppHost.a.a().getCurrentActivity();
        if (r4 != null) goto L38;
        return;
    L38:
        if (r4.isFinishing() == true) goto L54;
        UIUtils.displayToast(r4, 2131909272);
        return;
    L54:
        return;
    L5:
        if (r3 != (-1)) goto L7;
        Activity r5 = AppHost.a.a().getCurrentActivity();
        if (r5 != null) goto L32;
        return;
    L32:
        if (r5.isFinishing() == true) goto L53;
        UIUtils.displayToast(r5, 2131908080);
        return;
    L53:
        return;
    L7:
        if (r3 != 1) goto L51;
        Activity r6 = AppHost.a.a().getCurrentActivity();
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.isFinishing() == true) goto L52;
        WeakReference<Dialog> r0 = b;
        if (r0 == null) goto L19;
        Dialog r1 = r0.get();
        if (r1 == null) goto L19;
        c(r1);
    L19:
        WeakReference<Dialog> r2 = c;
        if (r2 == null) goto L24;
        Dialog r7 = r2.get();
        if (r7 == null) goto L24;
        c(r7);
    L24:
        c r8 = new c(r6, d);
        r8.setOnDismissListener(new d());
        b = new WeakReference(r8);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L28:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        return;
    L52:
        return;
    }
}
