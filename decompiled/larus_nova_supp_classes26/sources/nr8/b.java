package nr8;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hq9.n3;
import hq9.q3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b extends Dialog {
    public final n3 a;
    public boolean b;
    public float c;
    public boolean d;
    public s e;
    public final a f;

    public abstract void b();

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        FLogger.a.i("NotificationControlManager", "onDetachedFromWindow");
        if (this.d == true) goto L5;
        t0.a.removeCallbacks(this.f);
    L5:
        s r0 = this.e;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        super.onDetachedFromWindow();
    }

    public static void a(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        FLogger.a.i("AbsInnerNotificationDialog", "show");
        b();
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(48);
    L5:
        Window r5 = getWindow();
        if (r5 == null) goto L8;
        WindowManager.LayoutParams r6 = r5.getAttributes();
    L9:
        if (r6 == null) goto L11;
        r6.width = -1;
    L11:
        if (r6 == null) goto L13;
        r6.height = -2;
    L13:
        if (r6 == null) goto L15;
        r6.flags = 8;
    L15:
        Window r0 = getWindow();
        if (r0 == null) goto L18;
        r0.setAttributes(r6);
    L18:
        Window r7 = getWindow();
        if (r7 == null) goto L21;
        r7.setWindowAnimations(2131954374);
    L21:
        setCanceledOnTouchOutside(false);
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        this.c = r3.getY();
        return false;
    L5:
        if (r0 == 1) goto L8;
        return false;
    L8:
        if (this.c <= 0.0f) goto L22;
        float r4 = r3.getY();
        if (Math.abs(this.c - r4) < 15.0f) goto L15;
        q3 r5 = this.a.j;
        if (r5 == null) goto L14;
        r5.a();
    L14:
        a(this);
        return false;
    L15:
        q3 r6 = this.a.j;
        if (r6 == null) goto L18;
        r6.c();
    L18:
        a(this);
        return false;
    L22:
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [nr8.a] */
    public b(final Context r2, n3 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        super(r2, 2131954375);
        this.a = r3;
        this.f = new a(this, r2);
    }
}
