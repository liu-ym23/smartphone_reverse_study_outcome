package com.lynx.xelement.overlay;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxOverlayDialog extends Dialog {
    public final LynxOverlayView a;
    public b b;
    public boolean c;
    public String d;
    public Number e;
    public final Lazy f;

    public static final class a {
    }

    public interface b {
        boolean dispatchTouchEvent(MotionEvent r1);
    }

    static {
    }

    public final int c() {
        LynxOverlayView r0 = this.a;
        if (r0.d == false) goto L9;
        if (r0.e == false) goto L9;
        return 0;
    L9:
        return -((Number) this.f.getValue()).intValue();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (a(getContext()) >= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L24;
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r2 == null) goto L21;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r1.getLooper()) goto L12;
        r1.post(DialogLancet.createDismissRunnable(this));
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static int a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1 instanceof Activity) == false) goto L14;
        Activity r2 = (Activity) r1;
        if (r2.isFinishing() == false) goto L9;
        return -1;
    L9:
        if (r2.isDestroyed() == false) goto L12;
        return -2;
    L12:
        return 0;
    L14:
        return 1;
    }

    public final boolean d(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        boolean r1 = false;
        if (this.a.W(r6.getX(), r6.getY()) == false) goto L10;
        float r0 = this.a.getLeft();
        float r2 = this.a.getTop();
        r6.offsetLocation(-r0, -r2);
        LynxOverlayView r3 = this.a;
        b1 r4 = r3.C;
        if (r4 != null) goto L7;
    L9:
        r6.offsetLocation(r0, r2);
        goto L10
    L7:
        if (r4.x(r6, r3) != true) goto L9;
        r1 = true;
    L10:
        return r1;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (r6.getActionMasked() != 0) goto L63;
        this.c = false;
    L63:
        b r3 = this.b;     // Catch: Throwable -> L56
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L20;
        d(r6);     // Catch: Throwable -> L56
        if (r6.getActionMasked() != 1) goto L17;
    L18:
        this.c = false;
    L19:
        return false;
    L17:
        if (r6.getActionMasked() != 3) goto L19;
    L20:
        boolean r5 = d(r6);     // Catch: Throwable -> L56
        if (r5 == false) goto L23;
    L30:
        if (r5 == true) goto L32;
        boolean r7 = com.lynx.xelement.overlay.a.b(r6, this);     // Catch: Throwable -> L56
        if (r6.getActionMasked() != 1) goto L53;
    L54:
        this.c = false;
    L55:
        return r7;
    L53:
        if (r6.getActionMasked() != 3) goto L55;
    L32:
        if (r6.getActionMasked() != 0) goto L35;
        this.c = e(r6);     // Catch: Throwable -> L56
    L35:
        if (this.c == true) goto L37;
        boolean r8 = super.dispatchTouchEvent(r6);     // Catch: Throwable -> L56
        if (r6.getActionMasked() != 1) goto L46;
    L47:
        this.c = false;
    L48:
        return r8;
    L46:
        if (r6.getActionMasked() != 3) goto L48;
    L37:
        if (r6.getActionMasked() != 1) goto L39;
    L40:
        this.c = false;
    L41:
        return true;
    L39:
        if (r6.getActionMasked() != 3) goto L41;
    L23:
        if (this.c == false) goto L30;
        if (r6.getActionMasked() != 1) goto L27;
    L28:
        this.c = false;
    L29:
        return true;
    L27:
        if (r6.getActionMasked() != 3) goto L29;
    L9:
        if (r3.dispatchTouchEvent(r6) != true) goto L11;
        r4 = true;
    L56:
        th = move-exception;
        if (r6.getActionMasked() != 1) goto L60;
    L61:
        this.c = false;
    L62:
        throw th;
    L60:
        if (r6.getActionMasked() != 3) goto L62;
        goto L61
    }

    public final boolean e(MotionEvent r4) {
        EventTarget r5 = this.a.hitTest(r4.getX() - this.a.getLeft(), r4.getY() - this.a.getTop());
        if (r5.ignoreFocus() == false) goto L19;
    L4:
        if (r5 == null) goto L9;
        if ((r5 instanceof LynxUI) == true) goto L9;
        r5 = r5.parent();
    L9:
        if ((r5 instanceof LynxUI) == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L20;
        return true;
    L20:
        return false;
    L11:
        if ((((LynxUI) r5).getView() instanceof EditText) == false) goto L13;
        r6 = true;
        goto L14
    L19:
        return false;
    }

    public final boolean f(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r3 = getWindow();
        if (r3 == null) goto L6;
        r3.setLayout(-1, -1);
        return;
    }

    public LynxOverlayDialog(Context r2, LynxOverlayView r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "overlay");
        super(r2, 2131953337);
        this.a = r3;
        this.e = 1;
        this.f = LazyKt.lazy(new LynxOverlayDialog$statusBarHeight$2(this));
    }

    public static Fragment b(FragmentManager r9, String r10, PointF r11) {
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        Iterator r12 = CollectionsKt.reversed(r9.getFragments()).iterator();
    L14:
        if (r12.hasNext() == false) goto L41;
        Fragment r3 = (Fragment) r12.next();
        if (r3.isAdded() == false) goto L14;
        Fragment r4 = b(r3.getChildFragmentManager(), r10, r11);
        if (r4 != null) goto L20;
        if (Intrinsics.areEqual(r3.getTag(), r10) == false) goto L14;
        if ((r3 instanceof DialogFragment) == true) goto L37;
        View r5 = r3.getView();
        if (r5 == null) goto L38;
        int[] r6 = new int[2];
        r5.getLocationOnScreen(r6);
        float r7 = r6[0];
        float r8 = r6[1];
        float r13 = r11.x;
        if (r13 < r7) goto L38;
        if (r13 > (r7 + r5.getWidth())) goto L38;
        float r14 = r11.y;
        if (r14 < r8) goto L38;
        if (r14 <= (r8 + r5.getHeight())) goto L37;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == false) goto L14;
        return r3;
    L37:
        r15 = true;
        goto L39
    L20:
        return r4;
    L41:
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
