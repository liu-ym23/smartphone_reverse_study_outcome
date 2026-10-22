package i08;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.crash.d;
import com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static WeakReference<LKUILoadingToastImpl> a;

    static {
        a = new WeakReference(null);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Dialog, com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl, java.lang.Object] */
    @JvmStatic
    public static final void a() {
        if (a.get() != null) goto L5;
        return;
    L5:
        LKUILoadingToastImpl r0 = a.get();
        if (r0 == 0) goto L24;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r0);
        goto L24
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r2 == null) goto L21;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r1.getLooper()) goto L12;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L24:
        a.clear();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [android.app.Dialog, com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl, java.lang.Object] */
    @JvmStatic
    public static final void b(Context r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "text");
        if (a.get() != null) goto L6;
        a = new WeakReference(new LKUILoadingToastImpl(r3));
    L6:
        LKUILoadingToastImpl r5 = a.get();
        Intrinsics.checkNotNull(r5);
        LKUILoadingToastImpl r6 = r5;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        if (r6.isShowing() == false) goto L9;
        r6.e.removeMessages(61441);
    L10:
        r6.e.post(new b(r6, r4));
        r6.e.post(new com.larksuite.component.ui.toast.loading.a(r6));
        return;
    L9:
        Message.obtain(r6.e, 61442).sendToTarget();
        goto L10
    }
}
