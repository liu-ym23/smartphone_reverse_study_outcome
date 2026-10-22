package com.obric.oui.dialog.alert.view;

import ac.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import he.i;
import kb.b;
import nb.a;

/* JADX INFO: loaded from: classes2.dex */
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f6270b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f6272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f6273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Path f6274p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6275q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6276r;

    public RadiusLayout(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    public final void a(float r8, float r10, float r11, float r12) {
        this.f6272n = new float[]{r8, r8, r10, r10, r12, r12, r11, r11};
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.dispatchDraw(r8);
        if (this.f6271m == true) goto L5;
        return;
    L5:
        if (this.f6269a == false) goto L14;
        Paint r10 = this.f6270b;
        if (r10 == null) goto L15;
        RectF r11 = this.f6273o;
        r11.set(0.0f, 0.0f, getWidth(), getHeight());
        Path r12 = this.f6274p;
        r12.reset();
        b r13 = o.f341a;
        float[] r14 = this.f6272n;
        if (r14 == null) goto L11;
        o.a(r12, r11, r14, Path.Direction.CW);
        r8.drawPath(r12, r10);
        return;
    L11:
        i.j("radiusArray");
        throw null;
    L15:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        RectF r10 = this.f6273o;
        r10.set(0.0f, 0.0f, getWidth(), getHeight());
        Path r11 = this.f6274p;
        r11.reset();
        b r12 = o.f341a;
        float[] r13 = this.f6272n;
        if (r13 == null) goto L6;
        o.a(r11, r10, r13, Path.Direction.CW);
        r8.clipPath(r11);
        super.draw(r8);
        return;
    L6:
        i.j("radiusArray");
        throw null;
    }

    public final int getMaxHeight() {
        return this.f6275q;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f6276r;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r10) {
        if (this.f6276r == false) goto L9;
        super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r11 = getMeasuredHeight();
        int r12 = this.f6275q;
        if (1 > r12) goto L13;
        if (r11 <= r12) goto L11;
        setMeasuredDimension(getMeasuredWidth(), this.f6275q);
        return;
    L11:
        return;
    L13:
        return;
    L9:
        super.onMeasure(r8, r10);
    }

    public final void setMaxHeight(int r8) {
        this.f6275q = r8;
    }

    public final void setMeasureHeightUnspecified(boolean r8) {
        this.f6276r = r8;
    }

    public final void setRadius(float r8) {
        this.f6272n = new float[]{r8, r8, r8, r8, r8, r8, r8, r8};
        invalidate();
    }

    public RadiusLayout(Context r12, AttributeSet r13, int r14) {
        i.f(r12, "context");
        super(r12, r13, r14);
        boolean r8 = true;
        this.f6269a = true;
        this.f6273o = new RectF();
        this.f6274p = new Path();
        TypedArray r15 = r12.obtainStyledAttributes(r13, a.f9503q, r14, 0);
        i.e(r15, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r16 = r15.getDimension(0, 0.0f);
        float r10 = r15.getDimension(2, r16);
        float r11 = r15.getDimension(4, r16);
        float r17 = r15.getDimension(1, r16);
        float r18 = r15.getDimension(3, r16);
        int r19 = r15.getColor(5, -16777216);
        int r20 = r15.getDimensionPixelOffset(8, 0);
        int r21 = r15.getDimensionPixelOffset(7, 0);
        int r110 = r15.getDimensionPixelOffset(6, 0);
        a(r10, r11, r17, r18);
        Paint r111 = new Paint();
        r111.setAntiAlias(true);
        r111.setColor(r19);
        r111.setStyle(Paint.Style.STROKE);
        if (r21 == 0) goto L6;
        if (r110 == 0) goto L6;
        r111.setPathEffect(new DashPathEffect(new float[]{r21, r110}, 0.0f));
    L6:
        r111.setStrokeWidth(r20);
        this.f6270b = r111;
        if ((r19 & (-16777216)) == 0) goto L10;
        if (r20 == 0) goto L10;
    L11:
        this.f6271m = r8;
        invalidate();
        r15.recycle();
        return;
    L10:
        r8 = false;
        goto L11
    }
}
