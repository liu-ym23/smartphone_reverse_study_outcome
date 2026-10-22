package com.google.android.material.floatingactionbutton;

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
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;

/* JADX INFO: loaded from: classes2.dex */
class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f3922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f3923b;
    private final Paint c;
    private final Path d;
    private final Rect e;
    private final RectF f;
    private final RectF g;
    private final a h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private l o;
    private ColorStateList p;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3924a;

        private a(c r1) {
            this.f3924a = r1;
        }

        /* synthetic */ a(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return this.f3924a;
        }
    }

    c(l r3) {
        this.f3923b = m.a();
        this.d = new Path();
        this.e = new Rect();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new a(this, null);
        this.n = true;
        this.o = r3;
        Paint r4 = new Paint(1);
        this.c = r4;
        r4.setStyle(Paint.Style.STROKE);
    }

    private Shader b() {
        Rect r0 = this.e;
        copyBounds(r0);
        float r1 = this.f3922a / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{ColorUtils.compositeColors(this.i, this.m), ColorUtils.compositeColors(this.j, this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.j, 0), this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.l, 0), this.m), ColorUtils.compositeColors(this.l, this.m), ColorUtils.compositeColors(this.k, this.m)}, new float[]{0.0f, r1, 0.5f, 0.5f, 1.0f - r1, 1.0f}, Shader.TileMode.CLAMP);
    }

    public RectF a() {
        this.g.set(getBounds());
        return this.g;
    }

    public void a(float r3) {
        if (this.f3922a == r3) goto L6;
        this.f3922a = r3;
        this.c.setStrokeWidth(r3 * 1.3333f);
        this.n = true;
        invalidateSelf();
        return;
    }

    void a(int r1, int r2, int r3, int r4) {
        this.i = r1;
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }

    void a(ColorStateList r3) {
        if (r3 == null) goto L4;
        this.m = r3.getColorForState(getState(), this.m);
    L4:
        this.p = r3;
        this.n = true;
        invalidateSelf();
    }

    public void a(l r1) {
        this.o = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        if (this.n == false) goto L5;
        this.c.setShader(b());
        this.n = false;
    L5:
        float r0 = this.c.getStrokeWidth() / 2.0f;
        copyBounds(this.e);
        this.f.set(this.e);
        float r1 = Math.min(this.o.f().a(a()), this.f.width() / 2.0f);
        if (this.o.a(a()) == false) goto L9;
        this.f.inset(r0, r0);
        r5.drawRoundRect(this.f, r1, r1, this.c);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f3922a <= 0.0f) goto L5;
        return -3;
    L5:
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r6) {
        if (this.o.a(a()) == false) goto L6;
        float r0 = this.o.f().a(a());
        r6.setRoundRect(getBounds(), r0);
        return;
    L6:
        copyBounds(this.e);
        this.f.set(this.e);
        this.f3923b.a(this.o, 1.0f, this.f, this.d);
        if (this.d.isConvex() == false) goto L10;
        r6.setConvexPath(this.d);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r3) {
        if (this.o.a(a()) == false) goto L7;
        int r2 = Math.round(this.f3922a);
        r3.set(r2, r2, r2, r2);
        return true;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r0 = this.p;
        if (r0 == null) goto L7;
        if (r0.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        ColorStateList r0 = this.p;
        if (r0 == null) goto L8;
        int r4 = r0.getColorForState(r3, this.m);
        if (r4 == this.m) goto L8;
        this.n = true;
        this.m = r4;
    L8:
        if (this.n == false) goto L11;
        invalidateSelf();
    L11:
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.c.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
        invalidateSelf();
    }
}
