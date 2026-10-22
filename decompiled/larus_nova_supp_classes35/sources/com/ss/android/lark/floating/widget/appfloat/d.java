package com.ss.android.lark.floating.widget.appfloat;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends FrameLayout {
    public final vfb.a a;
    public wfb.e b;
    public a c;
    public boolean d;

    public interface a {
        void a();

        void onConfigurationChanged(Configuration r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.getClass();
        wfb.a r0 = this.a.B;
        if (r0 == null) goto L10;
        wfb.a.C0318a r1 = r0.a();
        if (r1 == null) goto L11;
        Function0<Unit> r2 = r1.b;
        if (r2 == null) goto L12;
        r2.invoke();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final a getLayoutListener() {
        return this.c;
    }

    public final wfb.e getTouchListener() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent r4) {
        if (this.a.l == false) goto L19;
        if (r4 != null) goto L6;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L19;
        if (r4.getKeyCode() != 4) goto L19;
        c r1 = c.a;
        String r2 = this.a.d;
        if (r2 != null) goto L15;
        r2 = "default";
    L15:
        int r3 = xfb.f.a;
        AppFloatManager r5 = c.a(r2);
        if (r5 == null) goto L19;
        ((WindowManager.LayoutParams) r5.e().a).flags = 40;
        r5.f().updateViewLayout(r5.e, r5.e().a);
        Unit r6 = Unit.INSTANCE;
        goto L19
    L6:
        if (r4.getAction() != 0) goto L8;
        r0 = true;
    L19:
        return super.dispatchKeyEventPreIme(r4);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        a r0 = this.c;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r2);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L7;
        wfb.e r0 = this.b;
        if (r0 == null) goto L7;
        r0.onTouch(r2);
    L7:
        if (this.a.i == false) goto L9;
    L12:
        return true;
    L9:
        if (super.onInterceptTouchEvent(r2) == true) goto L12;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L7;
        wfb.e r0 = this.b;
        if (r0 == null) goto L7;
        r0.onTouch(r2);
    L7:
        if (this.a.i == false) goto L9;
    L12:
        return true;
    L9:
        if (super.onTouchEvent(r2) == true) goto L12;
        return false;
    }

    public final void setLayoutListener(a r1) {
        this.c = r1;
    }

    public final void setTouchListener(wfb.e r1) {
        this.b = r1;
    }

    public d(Context r3, vfb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        super(r3, null, 0);
        this.a = r4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.d == true) goto L8;
        this.d = true;
        a r6 = this.c;
        if (r6 == null) goto L9;
        r6.a();
        return;
    L9:
        return;
    }
}
