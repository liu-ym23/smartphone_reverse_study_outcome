package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n extends FrameLayout {
    public static final /* synthetic */ int n = 0;
    public Function2<? super Float, ? super Boolean, Boolean> a;
    public Function2<? super Float, ? super Float, Boolean> b;
    public Function0<Unit> c;
    public Function1<? super Float, Unit> d;
    public Function2<? super Float, ? super Boolean, Unit> e;
    public final int f;
    public float g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public boolean l;
    public VelocityTracker m;

    public final void b() {
        this.k = false;
        this.l = false;
        VelocityTracker r1 = this.m;
        if (r1 == null) goto L5;
        r1.recycle();
    L5:
        this.m = null;
        ViewParent r2 = getParent();
        if (r2 == null) goto L9;
        r2.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.k == false) goto L5;
        a(true);
    L5:
        b();
        super.onDetachedFromWindow();
    }

    public final Function2<Float, Boolean, Boolean> getCanDrag() {
        return this.a;
    }

    public final Function1<Float, Unit> getOnDragBy() {
        return this.d;
    }

    public final Function2<Float, Boolean, Unit> getOnDragEnd() {
        return this.e;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.c;
    }

    public n(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new i();
        this.b = new j();
        this.c = new k();
        this.d = new l();
        this.e = new m();
        this.f = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public final void a(boolean r4) {
        VelocityTracker r0 = this.m;
        if (r0 == null) goto L5;
        r0.computeCurrentVelocity(1000);
    L5:
        this.k = false;
        Function2<? super Float, ? super Boolean, Unit> r1 = this.e;
        VelocityTracker r2 = this.m;
        if (r2 == null) goto L8;
        float r3 = r2.getYVelocity();
    L9:
        r1.invoke(Float.valueOf(r3), Boolean.valueOf(r4));
        ViewParent r5 = getParent();
        if (r5 == null) goto L13;
        r5.requestDisallowInterceptTouchEvent(false);
        return;
    L13:
        return;
    L8:
        r3 = 0.0f;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        int r0 = r7.getActionMasked();
        boolean r1 = true;
        if (r0 != 0) goto L5;
        b();
        this.g = r7.getRawX();
        float r2 = r7.getRawY();
        this.h = r2;
        this.i = r2;
        this.j = ((Boolean) this.b.invoke(Float.valueOf(r7.getX()), Float.valueOf(r7.getY()))).booleanValue();
        this.m = VelocityTracker.obtain();
    L11:
        MotionEvent r3 = MotionEvent.obtain(r7);
        r3.offsetLocation(r7.getRawX() - r7.getX(), r7.getRawY() - r7.getY());
        VelocityTracker r4 = this.m;
        if (r4 == null) goto L14;
        r4.addMovement(r3);
    L14:
        r3.recycle();
        if (this.l == true) goto L35;
        if (r7.getActionMasked() != 2) goto L35;
        float r5 = r7.getRawY() - this.i;
        if (this.k == true) goto L31;
        if (Math.abs(r7.getRawY() - this.h) <= this.f) goto L31;
        if (Math.abs(r7.getRawY() - this.h) <= Math.abs(r7.getRawX() - this.g)) goto L31;
        if (((Boolean) this.a.invoke(Float.valueOf(r5), Boolean.valueOf(this.j))).booleanValue() == false) goto L31;
        this.k = true;
        MotionEvent r6 = MotionEvent.obtain(r7);
        r6.setAction(3);
        super.dispatchTouchEvent(r6);
        r6.recycle();
        ViewParent r8 = getParent();
        if (r8 == null) goto L29;
        r8.requestDisallowInterceptTouchEvent(true);
    L29:
        this.c.invoke();
    L31:
        if (this.k == false) goto L33;
        this.d.invoke(Float.valueOf(r5));
    L33:
        this.i = r7.getRawY();
    L35:
        if (this.k == false) goto L37;
        boolean r9 = true;
    L39:
        if (r7.getActionMasked() == 1) goto L43;
        if (r7.getActionMasked() == 3) goto L43;
    L50:
        return r9;
    L43:
        if (this.k == true) goto L45;
    L49:
        b();
        goto L50
    L45:
        if (r7.getActionMasked() == 3) goto L48;
        r1 = false;
    L48:
        a(r1);
        goto L49
    L37:
        r9 = super.dispatchTouchEvent(r7);
        goto L39
    L5:
        if (r0 != 5) goto L11;
        this.l = true;
        if (this.k == false) goto L11;
        a(true);
        goto L11
    }

    public final void setCanDrag(Function2<? super Float, ? super Boolean, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setHandleHit(Function2<? super Float, ? super Float, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setOnDragBy(Function1<? super Float, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setOnDragEnd(Function2<? super Float, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setOnDragStart(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }
}
