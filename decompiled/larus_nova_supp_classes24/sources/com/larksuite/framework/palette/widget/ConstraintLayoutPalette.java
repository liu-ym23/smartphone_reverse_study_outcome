package com.larksuite.framework.palette.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import l28.a;
import n28.b;
import n28.c;
import n28.d;
import n28.e;
import n28.f;
import n28.g;
import n28.h;
import n28.i;
import n28.j;
import n28.k;
import n28.l;
import n28.m;
import n28.n;
import n28.o;
import n28.p;
import n28.q;
import n28.r;
import n28.s;
import n28.t;
import n28.u;
import n28.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096\u0001J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0096\u0001J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/larksuite/framework/palette/widget/ConstraintLayoutPalette;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "Lk28/a;", "getColourList", "Ln28/s;", "param", "", "setGravity", "Ln28/t;", "setHorizontalGravity", "Ln28/u;", "setPadding", "Ln28/v;", "setVerticalGravity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "palette_release"}, k = 1, mv = {1, 4, 0})
public final class ConstraintLayoutPalette extends ConstraintLayout {
    public final /* synthetic */ a a;

    public void setGravity(s r1) {
        this.a.y();
        throw null;
    }

    public void setHorizontalGravity(t r1) {
        this.a.z();
        throw null;
    }

    public void setPadding(u r2) {
        this.a.A(r2);
    }

    public void setVerticalGravity(v r1) {
        this.a.B();
        throw null;
    }

    public final void computeScroll() {
        b r0 = new b(new AnonymousClass1(this));
        this.a.a(r0);
    }

    public List<k28.a> getColourList() {
        return this.a.a;
    }

    public final void onAnimationEnd() {
        d r0 = new d(new C01431(this));
        this.a.d(r0);
    }

    public final void onAnimationStart() {
        e r0 = new e(new C01441(this));
        this.a.e(r0);
    }

    public final void onAttachedToWindow() {
        f r0 = new f(new C01451(this));
        this.a.f(r0);
    }

    public final void onDetachedFromWindow() {
        h r0 = new h(new C01471(this));
        this.a.i(r0);
    }

    public final void onFinishInflate() {
        j r0 = new j(new C01501(this));
        this.a.l(r0);
    }

    public ConstraintLayoutPalette(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void R5(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.computeScroll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void U5(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.onAnimationEnd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void V5(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.onAnimationStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void Y5(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void b6(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void k6(ConstraintLayoutPalette r0) {
        super/*android.view.ViewGroup*/.onFinishInflate();
    }

    public final void dispatchDraw(final Canvas r3) {
        c r0 = new c(r3, new C01411(this, r3));
        this.a.b(r0);
    }

    public final boolean dispatchTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C01421(this, r3);
        return this.a.c(r3, r0).booleanValue();
    }

    public final void onConfigurationChanged(final Configuration r3) {
        g r0 = new g(r3, new C01461(this, r3));
        this.a.g(r0);
    }

    public final boolean onDragEvent(final DragEvent r3) {
        Function1<DragEvent, Boolean> r0 = new C01481(this, r3);
        return this.a.j(r3, r0).booleanValue();
    }

    public final void onDraw(final Canvas r3) {
        i r0 = new i(r3, new C01491(this, r3));
        this.a.k(r0);
    }

    public final boolean onInterceptHoverEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C01521(this, r3);
        return this.a.n(r3, r0).booleanValue();
    }

    public final boolean onInterceptTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C01531(this, r3);
        return this.a.o(r3, r0).booleanValue();
    }

    public final boolean onTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C01601(this, r3);
        return this.a.v(r3, r0).booleanValue();
    }

    public ConstraintLayoutPalette(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void S5(ConstraintLayoutPalette r0, Canvas r1) {
        super.dispatchDraw(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean T5(ConstraintLayoutPalette r0, MotionEvent r1) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void Z5(ConstraintLayoutPalette r0, Configuration r1) {
        super/*android.view.ViewGroup*/.onConfigurationChanged(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean c6(ConstraintLayoutPalette r0, DragEvent r1) {
        return super/*android.view.ViewGroup*/.onDragEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean f7(ConstraintLayoutPalette r0, MotionEvent r1) {
        return super/*android.view.ViewGroup*/.onTouchEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void i6(ConstraintLayoutPalette r0, Canvas r1) {
        super/*android.view.ViewGroup*/.onDraw(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean o6(ConstraintLayoutPalette r0, MotionEvent r1) {
        return super/*android.view.ViewGroup*/.onInterceptHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean s6(ConstraintLayoutPalette r0, MotionEvent r1) {
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r1);
    }

    public final void onMeasure(final int r3, final int r4) {
        m r0 = new m(r3, r4, new C01551(this, r3, r4));
        this.a.q(r0);
    }

    public final void scrollBy(final int r3, final int r4) {
        q r0 = new q(r3, r4, new C01611(this, r3, r4));
        this.a.w(r0);
    }

    public final void scrollTo(final int r3, final int r4) {
        r r0 = new r(r3, r4, new C01621(this, r3, r4));
        this.a.x(r0);
    }

    public ConstraintLayoutPalette(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public static final /* synthetic */ void C6(ConstraintLayoutPalette r0, int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void l7(ConstraintLayoutPalette r0, int r1, int r2) {
        super/*android.view.ViewGroup*/.scrollBy(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void o7(ConstraintLayoutPalette r0, int r1, int r2) {
        super/*android.view.ViewGroup*/.scrollTo(r1, r2);
    }

    public final void onFocusChanged(final boolean r3, final int r4, final Rect r5) {
        k r0 = new k(r3, r4, r5, new C01511(this, r3, r4, r5));
        this.a.m(r0);
    }

    public final boolean onStartNestedScroll(final View r3, final View r4, final int r5) {
        Function3<View, View, Integer, Boolean> r0 = new C01591(this, r3, r4, r5);
        return this.a.u(r3, r4, r5, r0).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConstraintLayoutPalette(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, 0);
        a r5 = new a();
        this.a = r5;
        r5.h(this, r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean W6(ConstraintLayoutPalette r0, View r1, View r2, int r3) {
        return super/*android.view.ViewGroup*/.onStartNestedScroll(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void n6(ConstraintLayoutPalette r0, boolean r1, int r2, Rect r3) {
        super/*android.view.ViewGroup*/.onFocusChanged(r1, r2, r3);
    }

    public final void onScrollChanged(final int r9, final int r10, final int r11, final int r12) {
        o r6 = new o(r9, r10, r11, r12, new C01571(this, r9, r10, r11, r12));
        this.a.s(r6);
    }

    public final void onSizeChanged(final int r9, final int r10, final int r11, final int r12) {
        p r6 = new p(r9, r10, r11, r12, new C01581(this, r9, r10, r11, r12));
        this.a.t(r6);
    }

    public final void setPadding(final int r9, final int r10, final int r11, final int r12) {
        setPadding(new u(r9, r10, r11, r12, new C01631(this, r9, r10, r11, r12)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void N6(ConstraintLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onScrollChanged(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void V6(ConstraintLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void r7(ConstraintLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.setPadding(r1, r2, r3, r4);
    }

    public final void onLayout(final boolean r10, final int r11, final int r12, final int r13, final int r14) {
        l r7 = new l(r10, r11, r12, r13, r14, new C01541(this, r10, r11, r12, r13, r14));
        this.a.p(r7);
    }

    public final void onNestedScroll(final View r10, final int r11, final int r12, final int r13, final int r14) {
        n r7 = new n(r10, r11, r12, r13, r14, new C01561(this, r10, r11, r12, r13, r14));
        this.a.r(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void H6(ConstraintLayoutPalette r0, View r1, int r2, int r3, int r4, int r5) {
        super/*android.view.ViewGroup*/.onNestedScroll(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void u6(ConstraintLayoutPalette r0, boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
