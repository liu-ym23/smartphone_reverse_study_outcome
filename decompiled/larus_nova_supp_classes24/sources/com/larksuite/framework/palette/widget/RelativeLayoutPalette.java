package com.larksuite.framework.palette.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096\u0001J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0096\u0001J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/larksuite/framework/palette/widget/RelativeLayoutPalette;", "Landroid/widget/RelativeLayout;", "", "", "Lk28/a;", "getColourList", "Ln28/s;", "param", "", "setGravity", "Ln28/t;", "setHorizontalGravity", "Ln28/u;", "setPadding", "Ln28/v;", "setVerticalGravity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "palette_release"}, k = 1, mv = {1, 4, 0})
public final class RelativeLayoutPalette extends RelativeLayout {
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

    @Override // android.view.View
    public final void computeScroll() {
        b r0 = new b(new AnonymousClass1(this));
        this.a.a(r0);
    }

    public List<k28.a> getColourList() {
        return this.a.a;
    }

    @Override // android.view.View
    public final void onAnimationEnd() {
        d r0 = new d(new C02121(this));
        this.a.d(r0);
    }

    @Override // android.view.View
    public final void onAnimationStart() {
        e r0 = new e(new C02131(this));
        this.a.e(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        f r0 = new f(new C02141(this));
        this.a.f(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h r0 = new h(new C02161(this));
        this.a.i(r0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        j r0 = new j(new C02191(this));
        this.a.l(r0);
    }

    public RelativeLayoutPalette(Context r2) {
        this(r2, null);
    }

    public static final /* synthetic */ void a(RelativeLayoutPalette r0) {
        super.computeScroll();
    }

    public static final /* synthetic */ void d(RelativeLayoutPalette r0) {
        super.onAnimationEnd();
    }

    public static final /* synthetic */ void e(RelativeLayoutPalette r0) {
        super.onAnimationStart();
    }

    public static final /* synthetic */ void f(RelativeLayoutPalette r0) {
        super.onAttachedToWindow();
    }

    public static final /* synthetic */ void h(RelativeLayoutPalette r0) {
        super.onDetachedFromWindow();
    }

    public static final /* synthetic */ void k(RelativeLayoutPalette r0) {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(final Canvas r3) {
        c r0 = new c(r3, new C02101(this, r3));
        this.a.b(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C02111(this, r3);
        return this.a.c(r3, r0).booleanValue();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(final Configuration r3) {
        g r0 = new g(r3, new C02151(this, r3));
        this.a.g(r0);
    }

    @Override // android.view.View
    public final boolean onDragEvent(final DragEvent r3) {
        Function1<DragEvent, Boolean> r0 = new C02171(this, r3);
        return this.a.j(r3, r0).booleanValue();
    }

    @Override // android.view.View
    public final void onDraw(final Canvas r3) {
        i r0 = new i(r3, new C02181(this, r3));
        this.a.k(r0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptHoverEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C02211(this, r3);
        return this.a.n(r3, r0).booleanValue();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C02221(this, r3);
        return this.a.o(r3, r0).booleanValue();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r3) {
        Function1<MotionEvent, Boolean> r0 = new C02291(this, r3);
        return this.a.v(r3, r0).booleanValue();
    }

    public RelativeLayoutPalette(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void b(RelativeLayoutPalette r0, Canvas r1) {
        super.dispatchDraw(r1);
    }

    public static final /* synthetic */ boolean c(RelativeLayoutPalette r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static final /* synthetic */ void g(RelativeLayoutPalette r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public static final /* synthetic */ boolean i(RelativeLayoutPalette r0, DragEvent r1) {
        return super.onDragEvent(r1);
    }

    public static final /* synthetic */ void j(RelativeLayoutPalette r0, Canvas r1) {
        super.onDraw(r1);
    }

    public static final /* synthetic */ boolean m(RelativeLayoutPalette r0, MotionEvent r1) {
        return super.onInterceptHoverEvent(r1);
    }

    public static final /* synthetic */ boolean n(RelativeLayoutPalette r0, MotionEvent r1) {
        return super.onInterceptTouchEvent(r1);
    }

    public static final /* synthetic */ boolean u(RelativeLayoutPalette r0, MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(final int r3, final int r4) {
        m r0 = new m(r3, r4, new C02241(this, r3, r4));
        this.a.q(r0);
    }

    @Override // android.view.View
    public final void scrollBy(final int r3, final int r4) {
        q r0 = new q(r3, r4, new C02301(this, r3, r4));
        this.a.w(r0);
    }

    @Override // android.view.View
    public final void scrollTo(final int r3, final int r4) {
        r r0 = new r(r3, r4, new C02311(this, r3, r4));
        this.a.x(r0);
    }

    public RelativeLayoutPalette(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, 0);
        a r0 = new a();
        this.a = r0;
        r0.h(this, r2, r3, r4);
    }

    public static final /* synthetic */ void p(RelativeLayoutPalette r0, int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public static final /* synthetic */ void v(RelativeLayoutPalette r0, int r1, int r2) {
        super.scrollBy(r1, r2);
    }

    public static final /* synthetic */ void w(RelativeLayoutPalette r0, int r1, int r2) {
        super.scrollTo(r1, r2);
    }

    @Override // android.view.View
    public final void onFocusChanged(final boolean r3, final int r4, final Rect r5) {
        k r0 = new k(r3, r4, r5, new C02201(this, r3, r4, r5));
        this.a.m(r0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(final View r3, final View r4, final int r5) {
        Function3<View, View, Integer, Boolean> r0 = new C02281(this, r3, r4, r5);
        return this.a.u(r3, r4, r5, r0).booleanValue();
    }

    public static final /* synthetic */ void l(RelativeLayoutPalette r0, boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
    }

    public static final /* synthetic */ boolean t(RelativeLayoutPalette r0, View r1, View r2, int r3) {
        return super.onStartNestedScroll(r1, r2, r3);
    }

    @Override // android.view.View
    public final void onScrollChanged(final int r9, final int r10, final int r11, final int r12) {
        o r6 = new o(r9, r10, r11, r12, new C02261(this, r9, r10, r11, r12));
        this.a.s(r6);
    }

    @Override // android.view.View
    public final void onSizeChanged(final int r9, final int r10, final int r11, final int r12) {
        p r6 = new p(r9, r10, r11, r12, new C02271(this, r9, r10, r11, r12));
        this.a.t(r6);
    }

    @Override // android.view.View
    public final void setPadding(final int r9, final int r10, final int r11, final int r12) {
        setPadding(new u(r9, r10, r11, r12, new C02321(this, r9, r10, r11, r12)));
    }

    public static final /* synthetic */ void r(RelativeLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void s(RelativeLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void x(RelativeLayoutPalette r0, int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(final boolean r10, final int r11, final int r12, final int r13, final int r14) {
        l r7 = new l(r10, r11, r12, r13, r14, new C02231(this, r10, r11, r12, r13, r14));
        this.a.p(r7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(final View r10, final int r11, final int r12, final int r13, final int r14) {
        n r7 = new n(r10, r11, r12, r13, r14, new C02251(this, r10, r11, r12, r13, r14));
        this.a.r(r7);
    }

    public static final /* synthetic */ void o(RelativeLayoutPalette r0, boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void q(RelativeLayoutPalette r0, View r1, int r2, int r3, int r4, int r5) {
        super.onNestedScroll(r1, r2, r3, r4, r5);
    }
}
