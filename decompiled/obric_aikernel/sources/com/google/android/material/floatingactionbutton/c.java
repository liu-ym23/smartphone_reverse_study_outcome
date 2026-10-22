package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f3263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Paint f3264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f3265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f3266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f3267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f3268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f3269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Dimension
    float f3270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColorInt
    private int f3271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    private int f3272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColorInt
    private int f3273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColorInt
    private int f3274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @ColorInt
    private int f3275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private l f3277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private ColorStateList f3278p;

    static /* synthetic */ class a {
    }

    private class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3279a;

        private b(c r10) {
            this.f3279a = r10;
        }

        /* synthetic */ b(c r10, a r11) {
            this(r10);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return this.f3279a;
        }
    }

    c(l r10) {
        this.f3263a = m.k();
        this.f3265c = new Path();
        this.f3266d = new Rect();
        this.f3267e = new RectF();
        this.f3268f = new RectF();
        this.f3269g = new b(this, null);
        this.f3276n = true;
        this.f3277o = r10;
        Paint r11 = new Paint(1);
        this.f3264b = r11;
        r11.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect r10 = this.f3266d;
        copyBounds(r10);
        float r11 = this.f3270h / r10.height();
        return new LinearGradient(0.0f, r10.top, 0.0f, r10.bottom, new int[]{ColorUtils.compositeColors(this.f3271i, this.f3275m), ColorUtils.compositeColors(this.f3272j, this.f3275m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f3272j, 0), this.f3275m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f3274l, 0), this.f3275m), ColorUtils.compositeColors(this.f3274l, this.f3275m), ColorUtils.compositeColors(this.f3273k, this.f3275m)}, new float[]{0.0f, r11, 0.5f, 0.5f, 1.0f - r11, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    protected RectF b() {
        this.f3268f.set(getBounds());
        return this.f3268f;
    }

    void c(@Nullable ColorStateList r10) {
        if (r10 == null) goto L4;
        this.f3275m = r10.getColorForState(getState(), this.f3275m);
    L4:
        this.f3278p = r10;
        this.f3276n = true;
        invalidateSelf();
    }

    public void d(@Dimension float r10) {
        if (this.f3270h == r10) goto L6;
        this.f3270h = r10;
        this.f3264b.setStrokeWidth(r10 * 1.3333f);
        this.f3276n = true;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        if (this.f3276n == false) goto L5;
        this.f3264b.setShader(a());
        this.f3276n = false;
    L5:
        float r11 = this.f3264b.getStrokeWidth() / 2.0f;
        copyBounds(this.f3266d);
        this.f3267e.set(this.f3266d);
        float r12 = Math.min(this.f3277o.r().a(b()), this.f3267e.width() / 2.0f);
        if (this.f3277o.u(b()) == false) goto L9;
        this.f3267e.inset(r11, r11);
        r10.drawRoundRect(this.f3267e, r12, r12, this.f3264b);
        return;
    }

    void e(@ColorInt int r10, @ColorInt int r11, @ColorInt int r12, @ColorInt int r13) {
        this.f3271i = r10;
        this.f3272j = r11;
        this.f3273k = r12;
        this.f3274l = r13;
    }

    public void f(l r10) {
        this.f3277o = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f3269g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f3270h <= 0.0f) goto L5;
        return -3;
    L5:
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.f3277o.u(b()) == false) goto L6;
        float r11 = this.f3277o.r().a(b());
        r10.setRoundRect(getBounds(), r11);
        return;
    L6:
        copyBounds(this.f3266d);
        this.f3267e.set(this.f3266d);
        this.f3263a.d(this.f3277o, 1.0f, this.f3267e, this.f3265c);
        if (this.f3265c.isConvex() == false) goto L10;
        r10.setConvexPath(this.f3265c);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r10) {
        if (this.f3277o.u(b()) == false) goto L7;
        int r11 = Math.round(this.f3270h);
        r10.set(r11, r11, r11, r11);
        return true;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r10 = this.f3278p;
        if (r10 == null) goto L7;
        if (r10.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        this.f3276n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r10) {
        ColorStateList r11 = this.f3278p;
        if (r11 == null) goto L8;
        int r12 = r11.getColorForState(r10, this.f3275m);
        if (r12 == this.f3275m) goto L8;
        this.f3276n = true;
        this.f3275m = r12;
    L8:
        if (this.f3276n == false) goto L11;
        invalidateSelf();
    L11:
        return this.f3276n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r10) {
        this.f3264b.setAlpha(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.f3264b.setColorFilter(r10);
        invalidateSelf();
    }
}
