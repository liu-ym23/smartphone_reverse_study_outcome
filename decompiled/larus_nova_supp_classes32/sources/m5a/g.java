package m5a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FlutterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g extends Dialog {
    public final q a;
    public boolean b;
    public int c;
    public final FlutterView d;
    public DialogInterface.OnKeyListener e;

    public final void c() {
        if (this.b == true) goto L5;
        return;
    L5:
        Window r0 = getWindow();
        if (isShowing() == false) goto L11;
        if (r0 == null) goto L12;
        this.b = false;
        r0.clearFlags(8);
        h.e.c();
        return;
    L12:
        return;
    }

    public final void d() {
        Activity r0 = getOwnerActivity();
        if (r0 != null) goto L5;
        r0 = t5a.b.getActivity(getContext());
    L5:
        if (r0 != null) goto L7;
        Window r1 = null;
    L8:
        Window r2 = getWindow();
        if (r1 == null) goto L18;
        if (r2 == null) goto L20;
        View r3 = a(r1);
        View r4 = a(r2);
        if (r3 == null) goto L19;
        if (r4 == null) goto L21;
        r4.setSystemUiVisibility(r3.getSystemUiVisibility());
        r2.setStatusBarColor(r1.getStatusBarColor());
        r2.setNavigationBarColor(r1.getNavigationBarColor());
        return;
    L21:
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L7:
        r1 = r0.getWindow();
        goto L8
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Context r0 = getContext();
        boolean r2 = true;
        if ((r0 instanceof Activity) == false) goto L11;
        Activity r1 = (Activity) r0;
        if (r1.isFinishing() == false) goto L8;
        byte r3 = -1;
    L12:
        if (r3 < 0) goto L15;
        r2 = false;
    L15:
        if (r2 == true) goto L33;
        Handler r4 = DialogLancet.resolveDialogHandler(this);
        if (r4 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(this);
        return;
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r5 == null) goto L30;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
        goto L30
    L19:
        if (Looper.myLooper() == r4.getLooper()) goto L21;
        r4.post(DialogLancet.createDismissRunnable(this));
        return;
    L33:
        return;
    L8:
        if (r1.isDestroyed() == false) goto L10;
        r3 = -2;
        goto L12
    L10:
        r3 = 0;
        goto L12
    L11:
        r3 = 1;
        goto L12
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.e();
    }

    @Override // android.app.Dialog
    public final void show() {
        Context r0 = getContext();
        boolean r3 = true;
        if ((r0 instanceof Activity) == false) goto L11;
        Activity r1 = (Activity) r0;
        if (r1.isFinishing() == false) goto L8;
        byte r2 = -1;
    L12:
        if (r2 >= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        return;
    L17:
        Window r5 = getWindow();
        if (r5 != null) goto L20;
        boolean r6 = false;
    L25:
        if (r5 == null) goto L28;
        if (r6 == true) goto L28;
    L29:
        this.b = r3;
        d();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(this);
    L34:
        Window r7 = getWindow();
        if (r7 == null) goto L37;
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L37:
        d();
        return;
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L33:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    L28:
        r3 = false;
        goto L29
    L20:
        if ((r5.getAttributes().flags & 8) != 8) goto L22;
        r6 = true;
    L23:
        r5.clearFlags(131072);
        r5.setFlags(8, 8);
        goto L25
    L22:
        r6 = false;
        goto L23
    L14:
        r4 = false;
        goto L15
    L8:
        if (r1.isDestroyed() == false) goto L10;
        r2 = -2;
        goto L12
    L10:
        r2 = 0;
        goto L12
    L11:
        r2 = 1;
        goto L12
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void b(final View r2) {
        if (this.b == true) goto L5;
        return;
    L5:
        Window r0 = getWindow();
        if (r0 != null) goto L8;
        return;
    L8:
        View r1 = a(r0);
        if (r2 != null) goto L12;
        r2 = r1;
    L12:
        if (r2 != null) goto L15;
        c();
        return;
    L15:
        r2.postOnAnimation(new e(this, r2));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r4) {
        if (r4.getAction() != 0) goto L8;
        if (r4.getRepeatCount() != 0) goto L8;
        this.a.getKeyDispatcherState().startTracking(r4, this);
    L10:
        DialogInterface.OnKeyListener r0 = this.e;
        if (r0 == null) goto L14;
        r0.onKey(this, r4.getKeyCode(), r4);
    L14:
        if (r4.getKeyCode() == 97) goto L40;
        if (r4.getKeyCode() == 96) goto L40;
        if (r4.getKeyCode() == 99) goto L40;
        if (r4.getKeyCode() == 100) goto L40;
        if (r4.getKeyCode() == 109) goto L40;
        if (r4.getKeyCode() == 108) goto L40;
        if (r4.getKeyCode() == 160) goto L40;
        FlutterView r1 = this.d;
        if (r1 == null) goto L35;
        if (r1.getAndroidKeyProcessor() == null) goto L35;
        if (this.d.getAndroidKeyProcessor().a(r4) == false) goto L35;
        return true;
    L35:
        if (super.dispatchKeyEvent(r4) == true) goto L42;
        return false;
    L42:
        return true;
    L40:
        return super.dispatchKeyEvent(r4);
    L8:
        if (r4.getAction() != 1) goto L10;
        this.a.getKeyDispatcherState().handleUpEvent(r4);
        goto L10
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L6;
        r4.setLayout(-1, -1);
        r4.setBackgroundDrawable(new ColorDrawable(0));
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L6;
        this.a.e();
        return;
    }

    @Override // android.app.Dialog
    public final void setOnKeyListener(DialogInterface.OnKeyListener r1) {
        super.setOnKeyListener(r1);
        this.e = r1;
    }

    public g(Context r2, q r3, FlutterView r4) {
        super(r2, 2130903040);
        this.c = 1;
        this.e = null;
        this.a = r3;
        this.d = r4;
        Activity r5 = t5a.b.getActivity(r2);
        if (r5 == null) goto L6;
        setOwnerActivity(r5);
        return;
    }
}
