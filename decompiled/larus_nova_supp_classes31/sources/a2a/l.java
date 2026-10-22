package a2a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements yhc.l {
    public static final l a = null;
    public static final String b = null;
    public static WeakReference<Dialog> c;
    public static WeakReference<Dialog> d;
    public static final boolean e = false;

    public l() {
    }

    public final void b(boolean r1) {
    }

    static {
        a = new l();
        b = l.class.getSimpleName();
        e = true;
    }

    public static void e() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L18;
        q r1 = new q(r0, e);
        r1.setOnDismissListener(new k());
        d = new WeakReference(r1);
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

    public final boolean d() {
        WeakReference<Dialog> r0 = c;
        if (r0 == null) goto L7;
        Dialog r1 = r0.get();
        if (r1 == null) goto L7;
        boolean r2 = r1.isShowing();
    L8:
        if (r2 == true) goto L15;
        WeakReference<Dialog> r3 = d;
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

    public final void a(boolean r7) {
        FLogger r0 = FLogger.a;
        String r1 = b;
        StringBuilder r2 = new StringBuilder("showMainDialog, ");
        r2.append(r7);
        r2.append(", ");
        r2.append(c);
        r2.append(", ");
        WeakReference<Dialog> r4 = c;
        Boolean r5 = null;
        if (r4 == null) goto L7;
        Dialog r6 = r4.get();
        if (r6 == null) goto L7;
        Boolean r8 = Boolean.valueOf(r6.isShowing());
    L8:
        r2.append(r8);
        r2.append(", ");
        r2.append(d);
        r2.append(", ");
        WeakReference<Dialog> r3 = d;
        if (r3 == null) goto L13;
        Dialog r9 = r3.get();
        if (r9 == null) goto L13;
        r5 = Boolean.valueOf(r9.isShowing());
    L13:
        r2.append(r5);
        r0.d(r1, r2.toString());
        Activity r10 = AppHost.a.a().getCurrentActivity();
        if (r10 != null) goto L16;
        return;
    L16:
        if (r10.isFinishing() == true) goto L39;
        WeakReference<Dialog> r11 = c;
        if (r11 == null) goto L23;
        Dialog r12 = r11.get();
        if (r12 == null) goto L23;
        c(r12);
    L23:
        WeakReference<Dialog> r13 = d;
        if (r13 == null) goto L28;
        Dialog r14 = r13.get();
        if (r14 == null) goto L28;
        c(r14);
    L28:
        i r15 = new i(r10, r7, e);
        r15.setOnDismissListener(new j());
        c = new WeakReference(r15);
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L35;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L35:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L32:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        return;
    L39:
        return;
    L7:
        r8 = null;
        goto L8
    }
}
