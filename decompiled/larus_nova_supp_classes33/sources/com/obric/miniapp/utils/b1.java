package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b1 extends OSheet {
    public boolean G;
    public d1 H;
    public boolean I;
    public final /* synthetic */ Context J;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (this.G == false) goto L5;
        return;
    L5:
        this.G = true;
        Window r0 = getWindow();
        IBinder r1 = null;
        if (r0 == null) goto L8;
        View r2 = v(r0);
    L9:
        if (r2 == null) goto L11;
        View r3 = r2.findFocus();
    L12:
        Context r4 = this.J;
        if (r3 != null) goto L15;
        View r5 = r2;
    L16:
        if (r5 == null) goto L18;
        r5.clearFocus();
    L18:
        if (r5 == null) goto L20;
        View r6 = r5.getRootView();
    L21:
        if (r6 == null) goto L25;
        View r7 = r6.findFocus();
        if (r7 == null) goto L25;
        r7.clearFocus();
    L25:
        if (r6 == null) goto L27;
        r6.clearFocus();
    L27:
        Object r8 = r4.getSystemService("input_method");
        if ((r8 instanceof InputMethodManager) == false) goto L30;
        InputMethodManager r9 = (InputMethodManager) r8;
    L31:
        if (r5 == null) goto L36;
        IBinder r10 = r5.getWindowToken();
        if (r10 == null) goto L36;
        r1 = r10;
    L38:
        if (r1 == null) goto L41;
        if (r9 == null) goto L41;
        r9.hideSoftInputFromWindow(r1, 0);
    L41:
        if (r3 == null) goto L44;
        r2 = r3;
    L44:
        if (r2 == null) goto L46;
        r2.post(new z0(this));
        return;
    L46:
        e();
        return;
    L36:
        if (r6 == null) goto L38;
        r1 = r6.getWindowToken();
        goto L38
    L30:
        r9 = null;
        goto L31
    L20:
        r6 = null;
        goto L21
    L15:
        r5 = r3;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L14;
        r0.setSoftInputMode(49);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static View v(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if (this.I == true) goto L5;
        final d1 r0 = this.H;
        final boolean r1 = false;
        EditText r3 = null;
        if (r0 == null) goto L25;
        if (r11.getActionMasked() == 1) goto L13;
        if (r11.getActionMasked() == 3) goto L13;
    L23:
        r1 = true;
    L47:
        if (r1 == false) goto L50;
        return true;
    L50:
        return super/*android.app.Dialog*/.dispatchTouchEvent(r11);
    L13:
        if (r11.getActionMasked() == 1) goto L15;
    L22:
        this.H = null;
        View r4 = r0.a;
        final Context r5 = this.J;
        r4.post(new y0(r5, r0, r1, this));
        goto L23
    L15:
        if (Math.abs(r11.getRawX() - r0.b) < 24.0f) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L22;
        r1 = true;
        goto L22
    L17:
        if (Math.abs(r11.getRawY() - r0.c) >= 24.0f) goto L19;
        r6 = true;
        goto L20
    L25:
        if (r11.getActionMasked() != 0) goto L47;
        Window r2 = getWindow();
        if (r2 == null) goto L47;
        View r7 = v(r2);
        if (r7 == null) goto L47;
        View r8 = r7.findFocus();
        if ((r8 instanceof EditText) == false) goto L35;
        r3 = (EditText) r8;
    L35:
        EditText r9 = r3;
        if (r9 == null) goto L47;
        Rect r10 = new Rect();
        r9.getGlobalVisibleRect(r10);
        if (r10.contains((int) r11.getRawX(), (int) r11.getRawY()) == true) goto L47;
        View r12 = c1.b(r7, r11.getRawX(), r11.getRawY());
        if (r12 != null) goto L44;
    L46:
        r9.clearFocus();
        r7.requestFocus();
        this.H = new d1(r9, r11.getRawX(), r11.getRawY(), r11.getX(), r11.getY());
        goto L23
    L44:
        if ((r12 instanceof EditText) == true) goto L46;
    L5:
        return super/*android.app.Dialog*/.dispatchTouchEvent(r11);
    }

    public b1(Context r3, int r4) {
        this.J = r3;
        super(r3, r4, false, 28);
    }
}
