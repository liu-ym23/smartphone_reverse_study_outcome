package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001lB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J(\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J(\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J0\u0010E\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020(2\u0006\u0010B\u001a\u00020\bH\u0016J@\u0010I\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010H\u001a\u00020(H\u0016J8\u0010I\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J\u0018\u0010N\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010B\u001a\u00020\bH\u0016J \u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u0002032\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 H\u0016J(\u0010R\u001a\u00020\u00122\u0006\u0010@\u001a\u0002032\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0012H\u0016J\b\u0010S\u001a\u00020\bH\u0016J\u0006\u0010T\u001a\u00020DJ\u0006\u0010U\u001a\u00020DJ\u0006\u0010V\u001a\u00020DJ\u0018\u0010W\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u0018\u0010Y\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u0018\u0010Z\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u000f\u0010[\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u00020D2\b\u0010^\u001a\u0004\u0018\u000103H\u0002J\u0010\u0010_\u001a\u00020 2\u0006\u0010`\u001a\u00020 H\u0002J\u0018\u0010a\u001a\u00020D2\u0006\u0010Q\u001a\u00020 2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0012\u0010c\u001a\u00020D2\b\u0010?\u001a\u0004\u0018\u000103H\u0002J\u0010\u0010d\u001a\u00020D2\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 H\u0002J\f\u0010h\u001a\u00020\u0012*\u000203H\u0002J \u0010i\u001a\u0002032\u0006\u0010j\u001a\u00020k2\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 H\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020305X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u00108¨\u0006m"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;", "getDelegate", "()Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;", "setDelegate", "(Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;)V", "isInteractionEnabled", "", "()Z", "setInteractionEnabled", "(Z)V", "value", "isScrollInteractionBlocked", "setScrollInteractionBlocked", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "activePointerId", "initialX", "", "initialY", "lastY", "downOnNestedScrollingChild", "isTouchSequenceInProgress", "isDirectDragging", "hasInterceptedCurrentSequence", "locationOnScreen", "", "currentScreenY", "hasCurrentScreenY", "nestedDragLastScreenY", "hasNestedDragLastScreenY", "isBlockedTouchActive", "isPanelDragActive", "panelDragTranslationY", "lastTouchVelocityY", "lastTouchCancelled", "panelDragNestedTarget", "Landroid/view/View;", "blockedNestedTargets", "", "frozenScrollChild", "frozenScrollChildOverScrollMode", "Ljava/lang/Integer;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "onStartNestedScroll", "child", "target", "axes", "type", "onNestedScrollAccepted", "", "onNestedPreScroll", "dx", "dy", "consumed", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStopNestedScroll", "onNestedPreFling", "velocityX", "velocityY", "onNestedFling", "getNestedScrollAxes", "cancelActiveInteraction", "resetInteractionState", "releaseFrozenScrollChild", "tryBeginDirectDrag", "pointerIndex", "screenY", "screenX", "nestedDragDeltaY", "()Ljava/lang/Float;", "beginPanelDrag", "scrollChild", "dispatchPanelDrag", "deltaY", "finishPanelDrag", "cancelled", "freezeScrollChild", "trackVelocity", "hasNestedScrollingChildAt", "x", "y", "isVerticalNestedScrollingChild", "deepestVisibleChildAt", "parent", "Landroid/view/ViewGroup;", "Delegate", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxPanelDragLayout extends FrameLayout implements NestedScrollingParent3 {
    public View A;
    public Integer B;
    public a a;
    public boolean b;
    public boolean c;
    public final NestedScrollingParentHelper d;
    public final int e;
    public VelocityTracker f;
    public int g;
    public float h;
    public float i;
    public float j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final int[] o;
    public float p;
    public boolean q;
    public float r;
    public boolean s;
    public boolean t;
    public boolean u;
    public float v;
    public float w;
    public boolean x;
    public View y;
    public final Set<View> z;

    public interface a {
        float a(float r1);

        boolean b(float r1);

        void c();

        boolean d(float r1, float r2, boolean r3);
    }

    public DbxPanelDragLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DbxPanelDragLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Float f() {
        if (this.q == true) goto L7;
        return null;
    L7:
        if (this.s == true) goto L10;
        this.r = this.p;
        this.s = true;
        return Float.valueOf(0.0f);
    L10:
        float r0 = this.p;
        float r1 = r0 - this.r;
        this.r = r0;
        return Float.valueOf(r1);
    }

    public final void g() {
        View r0 = this.A;
        Integer r1 = this.B;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r0.setOverScrollMode(r1.intValue());
    L6:
        this.A = null;
        this.B = null;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.d.getNestedScrollAxes();
    }

    public final a getDelegate() {
        return this.a;
    }

    public final void a(View r2) {
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        this.y = r2;
        this.v = 0.0f;
        this.s = false;
        if (r2 != null) goto L8;
    L11:
        a r3 = this.a;
        if (r3 == null) goto L15;
        r3.c();
        return;
    L15:
        return;
    L8:
        if (this.A == r2) goto L11;
        g();
        this.A = r2;
        this.B = Integer.valueOf(r2.getOverScrollMode());
        r2.setOverScrollMode(2);
        goto L11
    }

    public final void c(float r3) {
        if (this.u == false) goto L15;
        float r0 = 0.0f;
        if (r3 != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L16;
        a r2 = this.a;
        if (r2 == null) goto L13;
        r0 = r2.a(r3);
    L13:
        this.v += r0;
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r7.getActionMasked() != 0) goto L5;
        this.l = true;
    L5:
        int r0 = r7.getActionMasked();
        float r3 = 0.0f;
        if (r0 != 0) goto L8;
        VelocityTracker r1 = this.f;
        if (r1 == null) goto L23;
        r1.recycle();
    L23:
        this.f = VelocityTracker.obtain();
        this.g = r7.getPointerId(0);
        this.w = 0.0f;
        this.x = false;
    L24:
        VelocityTracker r2 = this.f;
        if (r2 == null) goto L28;
        r2.addMovement(r7);
    L28:
        if (r7.getActionMasked() != 1) goto L30;
    L31:
        VelocityTracker r4 = this.f;
        if (r4 == null) goto L34;
        r4.computeCurrentVelocity(1000);
    L34:
        VelocityTracker r5 = this.f;
        if (r5 == null) goto L37;
        r3 = r5.getYVelocity(this.g);
    L37:
        this.w = r3;
        if (r7.getActionMasked() != 3) goto L40;
        boolean r6 = true;
    L41:
        this.x = r6;
    L43:
        if (r7.getActionMasked() != 2) goto L47;
        int r8 = r7.findPointerIndex(this.g);
        if (r8 < 0) goto L47;
        this.p = i(r7, r8);
        this.q = true;
    L47:
        boolean r9 = super.dispatchTouchEvent(r7);
        if (r7.getActionMasked() != 1) goto L50;
    L51:
        this.l = false;
        this.t = false;
        this.q = false;
        VelocityTracker r10 = this.f;
        if (r10 == null) goto L54;
        r10.recycle();
    L54:
        this.f = null;
        this.g = -1;
    L55:
        return r9;
    L50:
        if (r7.getActionMasked() != 3) goto L55;
    L40:
        r6 = false;
        goto L41
    L30:
        if (r7.getActionMasked() != 3) goto L43;
    L8:
        if (r0 != 6) goto L24;
        int r11 = r7.getActionIndex();
        if (r7.getPointerId(r11) != this.g) goto L24;
        if (r11 != 0) goto L14;
        int r12 = 1;
    L16:
        if (r12 >= r7.getPointerCount()) goto L24;
        this.g = r7.getPointerId(r12);
        this.j = i(r7, r12);
        if (this.m == true) goto L24;
        this.h = h(r7, r12);
        this.i = i(r7, r12);
        goto L24
    L14:
        r12 = 0;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getActionMasked() != 0) goto L6;
        this.t = false;
    L6:
        if (this.t == false) goto L9;
        return true;
    L9:
        if (this.c == false) goto L13;
        this.t = true;
        return true;
    L13:
        if (this.b == true) goto L16;
        return false;
    L16:
        if (this.m == true) goto L18;
    L20:
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L23;
        this.g = r5.getPointerId(0);
        this.h = h(r5, 0);
        float r1 = i(r5, 0);
        this.i = r1;
        this.j = r1;
        this.m = false;
        this.n = false;
        this.k = e(r5.getX(), r5.getY());
    L40:
        return false;
    L23:
        if (r0 != 2) goto L40;
        if (this.k == true) goto L38;
        if (this.m == true) goto L38;
        int r2 = r5.findPointerIndex(this.g);
        if (r2 >= 0) goto L34;
        return false;
    L34:
        if (j(r5, r2) == false) goto L40;
        this.n = true;
        return true;
    L38:
        return this.m;
    L18:
        if (r5.getActionMasked() == 0) goto L20;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        int r2 = 0;
        if (this.t == true) goto L5;
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L49;
        if (r0 == 1) goto L41;
        if (r0 == 2) goto L28;
        if (r0 == 3) goto L41;
        if (r0 != 6) goto L19;
        int r1 = r6.getActionIndex();
        if (r6.getPointerId(r1) != this.g) goto L27;
        if (r1 != 0) goto L25;
        r2 = 1;
    L25:
        if (r2 >= r6.getPointerCount()) goto L27;
        this.g = r6.getPointerId(r2);
        this.j = i(r6, r2);
    L27:
        return true;
    L19:
        return super.onTouchEvent(r6);
    L28:
        int r3 = r6.findPointerIndex(this.g);
        if (r3 >= 0) goto L32;
        return true;
    L32:
        if (this.m == false) goto L34;
    L38:
        float r7 = i(r6, r3);
        c(r7 - this.j);
        this.j = r7;
        return true;
    L34:
        if (this.n == false) goto L36;
    L37:
        return true;
    L36:
        if (j(r6, r3) == true) goto L38;
    L41:
        if (this.m == false) goto L47;
        float r4 = this.w;
        if (r6.getActionMasked() != 3) goto L45;
        boolean r8 = true;
    L46:
        d(r4, r8);
        goto L47
    L45:
        r8 = false;
    L47:
        this.m = false;
        return true;
    L49:
        this.g = r6.getPointerId(0);
        this.h = h(r6, 0);
        float r5 = i(r6, 0);
        this.i = r5;
        this.j = r5;
        this.m = false;
        this.n = false;
        this.k = e(r6.getX(), r6.getY());
        return true;
    L5:
        if (r6.getActionMasked() != 1) goto L7;
    L8:
        this.t = false;
    L9:
        return true;
    L7:
        if (r6.getActionMasked() != 3) goto L9;
        goto L8
    }

    public final void setDelegate(a r1) {
        this.a = r1;
    }

    public final void setInteractionEnabled(boolean r1) {
        this.b = r1;
    }

    public final void setScrollInteractionBlocked(boolean r1) {
        this.c = r1;
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.l == false) goto L7;
        this.t = true;
    L7:
        requestDisallowInterceptTouchEvent(false);
    }

    public final void d(float r4, boolean r5) {
        if (this.u == true) goto L5;
        return;
    L5:
        float r0 = this.v;
        boolean r1 = false;
        this.u = false;
        this.y = null;
        this.v = 0.0f;
        this.s = false;
        a r2 = this.a;
        if (r2 != null) goto L8;
    L10:
        if (r1 == true) goto L13;
        g();
        return;
    L13:
        return;
    L8:
        if (r2.d(r0, r4, r5) != true) goto L10;
        r1 = true;
        goto L10
    }

    public final boolean e(float r3, float r4) {
        View r5 = b(this, r3, r4);
    L3:
        boolean r6 = false;
        if (r5 == null) goto L19;
        if (r5 == this) goto L19;
        if (ViewCompat.isNestedScrollingEnabled(r5) == true) goto L9;
    L13:
        if (r6 == true) goto L14;
        Object r7 = r5.getParent();
        if ((r7 instanceof View) == true) goto L17;
        r5 = null;
        goto L3
    L17:
        r5 = (View) r7;
        goto L3
    L14:
        return true;
    L9:
        if (r5.canScrollVertically(-1) == false) goto L11;
    L12:
        r6 = true;
        goto L13
    L11:
        if (r5.canScrollVertically(1) == false) goto L13;
    L19:
        return false;
    }

    public final float h(MotionEvent r2, int r3) {
        getLocationOnScreen(this.o);
        return r2.getX(r3) + this.o[0];
    }

    public final float i(MotionEvent r2, int r3) {
        getLocationOnScreen(this.o);
        return r2.getY(r3) + this.o[1];
    }

    public final boolean j(MotionEvent r7, int r8) {
        if (this.m == false) goto L6;
        return true;
    L6:
        if (this.b == true) goto L8;
    L29:
        return false;
    L8:
        if (this.c == true) goto L29;
        if (this.k == false) goto L13;
        return false;
    L13:
        float r0 = h(r7, r8) - this.h;
        float r3 = i(r7, r8) - this.i;
        if (Math.abs(r3) <= this.e) goto L29;
        if (Math.abs(r3) <= Math.abs(r0)) goto L29;
        a r1 = this.a;
        if (r1 != null) goto L20;
    L22:
        boolean r2 = false;
    L23:
        if (r2 == false) goto L29;
        this.m = true;
        this.j = i(r7, r8);
        a(null);
        ViewParent r9 = getParent();
        if (r9 == null) goto L28;
        r9.requestDisallowInterceptTouchEvent(true);
    L28:
        return true;
    L20:
        if (r1.b(r3) != true) goto L22;
        r2 = true;
        goto L23
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.d.onStopNestedScroll(r2, r3);
        if (r3 != 0) goto L5;
        this.z.remove(r2);
    L5:
        if (r3 == 0) goto L7;
        return;
    L7:
        if (this.y == r2) goto L9;
        return;
    L9:
        if (this.u == false) goto L11;
        d(this.w, this.x);
    L11:
        this.y = null;
    }

    public DbxPanelDragLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new NestedScrollingParentHelper(this);
        this.e = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.g = -1;
        this.o = new int[2];
        this.z = new LinkedHashSet();
        setClickable(true);
    }

    public static View b(ViewGroup r7, float r8, float r9) {
        int r0 = r7.getChildCount() - 1;
    L3:
        if ((-1) >= r0) goto L21;
        View r2 = r7.getChildAt(r0);
        if (r2.getVisibility() != 0) goto L20;
        float r3 = ((r7.getScrollX() + r8) - r2.getLeft()) - r2.getTranslationX();
        float r4 = ((r7.getScrollY() + r9) - r2.getTop()) - r2.getTranslationY();
        if (r3 < 0.0f) goto L20;
        if (r4 < 0.0f) goto L20;
        if (r3 >= r2.getWidth()) goto L20;
        if (r4 >= r2.getHeight()) goto L20;
        if ((r2 instanceof ViewGroup) == true) goto L29;
        Intrinsics.checkNotNull(r2);
        return r2;
    L29:
        return b((ViewGroup) r2, r3, r4);
    L20:
        r0 = r0 - 1;
        goto L3
    L21:
        return r7;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "target");
        if (this.u == false) goto L8;
        if (this.y != r1) goto L8;
        this.w = -r3;
    L8:
        if (this.c == false) goto L10;
    L17:
        return true;
    L10:
        if (this.z.contains(r1) == true) goto L17;
        if (this.u == true) goto L14;
    L16:
        return false;
    L14:
        if (this.y != r1) goto L16;
        goto L16
    }

    public /* synthetic */ DbxPanelDragLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "target");
        if (this.c == false) goto L5;
    L12:
        return true;
    L5:
        if (this.z.contains(r1) == true) goto L12;
        if (this.u == true) goto L9;
    L11:
        return false;
    L9:
        if (this.y != r1) goto L11;
        goto L11
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        this.d.onNestedScrollAccepted(r2, r3, r4, r5);
        if (r5 == 0) goto L5;
        return;
    L5:
        if (this.c == false) goto L9;
        this.z.add(r3);
        return;
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (this.b == false) goto L5;
    L8:
        if (r5 == 0) goto L10;
    L12:
        return false;
    L10:
        if ((r4 & 2) == 0) goto L12;
        return true;
    L5:
        if (this.c == true) goto L8;
        if (this.z.contains(r3) == false) goto L12;
        goto L8
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
        if (r5 == 0) goto L6;
        return;
    L6:
        if (this.c == false) goto L9;
        this.z.add(r1);
    L9:
        if (this.z.contains(r1) == false) goto L13;
        r4[1] = r4[1] + r3;
        return;
    L13:
        if (this.u == true) goto L15;
        return;
    L15:
        if (this.y != r1) goto L25;
        if (r3 <= 0) goto L26;
        Float r6 = f();
        if (r6 == null) goto L21;
        float r7 = r6.floatValue();
    L22:
        c(r7);
        r4[1] = r4[1] + r3;
        return;
    L21:
        r7 = -r3;
        goto L22
    L26:
        return;
    }

    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "target");
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        if (r6 == 0) goto L6;
        return;
    L6:
        if (this.c == false) goto L9;
        this.z.add(r1);
    L9:
        if (this.z.contains(r1) == false) goto L12;
        r7[1] = r7[1] + r5;
        return;
    L12:
        if (r5 < 0) goto L14;
        return;
    L14:
        if (this.b == false) goto L38;
        boolean r8 = this.u;
        if (r8 == true) goto L19;
    L21:
        if (r8 == true) goto L31;
        a r9 = this.a;
        if (r9 != null) goto L25;
    L27:
        boolean r10 = false;
    L28:
        if (r10 == true) goto L30;
        return;
    L30:
        a(r1);
        goto L31
    L25:
        if (r9.b(-r5) != true) goto L27;
        r10 = true;
    L31:
        Float r11 = f();
        if (r11 == null) goto L34;
        float r12 = r11.floatValue();
    L35:
        c(r12);
        r7[1] = r7[1] + r5;
        return;
    L34:
        r12 = -r5;
        goto L35
    L19:
        if (this.y == r1) goto L21;
        return;
    }
}
