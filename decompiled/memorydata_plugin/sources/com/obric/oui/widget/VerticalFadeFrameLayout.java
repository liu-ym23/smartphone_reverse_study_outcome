package com.obric.oui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class VerticalFadeFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f14873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f14874b;
    private final PorterDuffXfermode c;
    private final Matrix d;
    private final Matrix e;
    private final ViewTreeObserver.OnScrollChangedListener f;
    private LinearGradient g;
    private LinearGradient h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private ValueAnimator r;
    private float s;
    private View t;
    private ViewTreeObserver u;

    static {
        f14873a = new float[]{0.0f, 1.0f};
    }

    public VerticalFadeFrameLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public VerticalFadeFrameLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public VerticalFadeFrameLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f14874b = new Paint(1);
        this.c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new AnonymousClass1(this);
        this.i = -1;
        this.j = -1;
        this.k = -1.0f;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.s = d();
        a(r7, r5);
        setWillNotDraw(false);
    }

    private static float a(float r1) {
        return Math.max(0.0f, Math.min(1.0f, r1));
    }

    private float a(RectF r1) {
        return Math.min(this.s, r1.height());
    }

    static /* synthetic */ float a(VerticalFadeFrameLayout r0, float r1) {
        r0.n = r1;
        return r1;
    }

    private RectF a(View r4) {
        float r3 = r4.getLeft();
        float r0 = r4.getTop();
        float r1 = r4.getRight();
        float r5 = r4.getBottom();
        if (r1 > r3) goto L5;
        return null;
    L5:
        if (r5 > r0) goto L8;
        return null;
    L8:
        return new RectF(r3, r0, r1, r5);
    }

    private void a(final float r9, final float r10) {
        final float r2 = this.n;
        final float r4 = this.o;
        if (r2 == r9) goto L5;
    L7:
        ValueAnimator r0 = this.r;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.r = r1;
        r1.setDuration(120);
        this.r.addUpdateListener(new AnonymousClass2(this, r2, r9, r4, r10));
        this.r.start();
        return;
    L5:
        if (r4 != r10) goto L7;
    }

    private void a(int r20, int r21, float r22, float r23) {
        this.i = r20;
        this.j = r21;
        this.k = this.s;
        this.l = r22;
        this.m = r23;
        float r5 = a(new RectF(0.0f, 0.0f, r20, r21));
        if (r20 <= 0) goto L17;
        if (r21 <= 0) goto L17;
        if (r5 <= 0.0f) goto L17;
        int r1 = Math.max(0, Math.min(255, (int) ((1.0f - a(r22)) * 255.0f)));
        int r2 = Math.max(0, Math.min(255, (int) ((1.0f - a(r23)) * 255.0f)));
        if (r22 <= 0.0f) goto L11;
        this.g = new LinearGradient(0.0f, 0.0f, 0.0f, r5, new int[]{Color.argb(r1, 0, 0, 0), ViewCompat.MEASURED_STATE_MASK}, f14873a, Shader.TileMode.CLAMP);
    L13:
        if (r23 <= 0.0f) goto L15;
        this.h = new LinearGradient(0.0f, r5, 0.0f, 0.0f, new int[]{Color.argb(r2, 0, 0, 0), ViewCompat.MEASURED_STATE_MASK}, f14873a, Shader.TileMode.CLAMP);
        return;
    L15:
        this.h = null;
        return;
    L11:
        this.g = null;
    L17:
        this.g = null;
        this.h = null;
    }

    private void a(Canvas r11, RectF r12) {
        float r0 = a(r12);
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r1 = this.g;
        if (r1 != null) goto L8;
        return;
    L8:
        this.d.reset();
        this.d.setTranslate(r12.left, r12.top);
        r1.setLocalMatrix(this.d);
        this.f14874b.setShader(r1);
        View r2 = this.t;
        int r3 = 0;
        if (r2 == null) goto L11;
        int r4 = r2.getPaddingLeft();
    L12:
        if (r2 == null) goto L14;
        r3 = r2.getPaddingRight();
    L14:
        r11.drawRect(r12.left + r4, r12.top, r12.right - r3, r12.top + r0, this.f14874b);
        return;
    L11:
        r4 = 0;
        goto L12
    }

    private void a(RectF r4, float r5, float r6) {
        int r0 = (int) r4.width();
        int r7 = (int) r4.height();
        if (this.i == r0) goto L5;
    L9:
        a(r0, r7, r5, r6);
        return;
    L5:
        if (this.j != r7) goto L9;
        if (this.k != this.s) goto L9;
    }

    private void a(AttributeSet r4, int r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.VerticalFadeFrameLayout, r5, 0);
        setFadeLength(r7.getDimension(ZeusTransformUtils.mapRes(R.styleable.VerticalFadeFrameLayout_fadeLength, "styleable", "VerticalFadeFrameLayout_fadeLength"), this.s));     // Catch: Throwable -> L9
        r7.recycle();
        return;
    L9:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    static /* synthetic */ void a(VerticalFadeFrameLayout r0) {
        r0.c();
    }

    static /* synthetic */ float b(VerticalFadeFrameLayout r0, float r1) {
        r0.o = r1;
        return r1;
    }

    private void b(Canvas r10, RectF r11) {
        float r0 = a(r11);
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        float r5 = Math.max(r11.bottom - r0, r11.top);
        this.e.reset();
        this.e.setTranslate(r11.left, r5);
        r1.setLocalMatrix(this.e);
        this.f14874b.setShader(r1);
        View r2 = this.t;
        int r3 = 0;
        if (r2 == null) goto L11;
        int r4 = r2.getPaddingLeft();
    L12:
        if (r2 == null) goto L14;
        r3 = r2.getPaddingRight();
    L14:
        r10.drawRect(r11.left + r4, r5, r11.right - r3, r11.bottom, this.f14874b);
        return;
    L11:
        r4 = 0;
        goto L12
    }

    private void b(View r3) {
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        ViewTreeObserver r0 = this.u;
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        r4.addOnScrollChangedListener(this.f);
        this.u = r4;
        return;
    L7:
        if (r0.isAlive() == false) goto L9;
        this.u.removeOnScrollChangedListener(this.f);
        goto L9
    }

    private boolean b() {
        View r0 = this.t;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.s > 0.0f) goto L8;
        return false;
    L8:
        if (r0.getWidth() > 0) goto L10;
        return false;
    L10:
        if (r0.getHeight() > 0) goto L13;
        return false;
    L13:
        if (this.n <= 0.0f) goto L15;
    L16:
        return true;
    L15:
        if (this.o > 0.0f) goto L16;
        return false;
    }

    private void c() {
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = -1;
        this.k = -1.0f;
        this.l = Float.NaN;
        this.m = Float.NaN;
        invalidate();
    }

    private void c(View r2) {
        ViewTreeObserver r0 = this.u;
        if (r0 != null) goto L6;
        r0 = r2.getViewTreeObserver();
    L6:
        if (r0 == null) goto L11;
        if (r0.isAlive() == false) goto L11;
        r0.removeOnScrollChangedListener(this.f);
    L11:
        if (this.u != r0) goto L14;
        this.u = null;
        return;
    }

    private float d() {
        return TypedValue.applyDimension(1, 24.0f, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    public void a() {
        a(false);
    }

    public void a(boolean r6) {
        View r0 = this.t;
        float r1 = 1.0f;
        if (r0 != null) goto L5;
    L7:
        float r3 = 0.0f;
    L8:
        if (r0 != null) goto L10;
    L12:
        r1 = 0.0f;
    L13:
        if (r6 == true) goto L15;
        ValueAnimator r7 = this.r;
        if (r7 == null) goto L24;
        r7.cancel();
    L24:
        this.p = r3;
        this.q = r1;
        this.n = r3;
        this.o = r1;
        c();
        return;
    L15:
        if (this.p == r3) goto L17;
    L19:
        this.p = r3;
        this.q = r1;
        a(r3, r1);
        return;
    L17:
        if (this.q != r1) goto L19;
        return;
    L10:
        if (r0.canScrollVertically(1) == false) goto L12;
    L5:
        if (r0.canScrollVertically(-1) == false) goto L7;
        r3 = 1.0f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r11) {
        if (b() == true) goto L6;
        super.dispatchDraw(r11);
        return;
    L6:
        View r0 = this.t;
        if (r0 != null) goto L10;
        super.dispatchDraw(r11);
        return;
    L10:
        RectF r1 = a(r0);
        if (r1 != null) goto L14;
        super.dispatchDraw(r11);
        return;
    L14:
        float r2 = this.n;
        if (r2 <= 0.0f) goto L17;
    L20:
        a(r1, r2, this.o);
        int r3 = r11.saveLayer(r1.left, r1.top, r1.right, r1.bottom, null);
        super.dispatchDraw(r11);
        this.f14874b.setXfermode(this.c);
        if (this.n <= 0.0f) goto L24;
        a(r11, r1);
    L24:
        if (this.o <= 0.0f) goto L26;
        b(r11, r1);
    L26:
        this.f14874b.setXfermode(null);
        this.f14874b.setShader(null);
        r11.restoreToCount(r3);
        return;
    L17:
        if (this.o > 0.0f) goto L20;
        super.dispatchDraw(r11);
    }

    public float getFadeLength() {
        return this.s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = this.t;
        if (r0 == null) goto L6;
        b(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View r0 = this.t;
        if (r0 == null) goto L6;
        c(r0);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View r1 = getChildAt(0);
        this.t = r1;
        if (r1 == null) goto L5;
        b(r1);
    L5:
        a(false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        a(false);
        return;
    }

    public void setFadeLength(float r2) {
        float r3 = Math.max(0.0f, r2);
        if (this.s != r3) goto L5;
        return;
    L5:
        this.s = r3;
        c();
    }
}
