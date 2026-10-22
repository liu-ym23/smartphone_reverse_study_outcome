package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f7873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7875c;
    public float d;
    public final Path e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f7876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f7877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f7878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f7879k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f7880l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f7881m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f7882n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Matrix f7883o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Matrix f7884p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Matrix f7885q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f7886r;
    public final Matrix s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Matrix f7887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f7888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f7890w;

    public RoundedDrawable(Drawable r5) {
        this.f7874b = false;
        this.f7875c = false;
        this.d = 0.0f;
        this.e = new Path();
        this.f = true;
        this.g = 0;
        this.f7876h = new Path();
        this.f7877i = new float[8];
        this.f7878j = new float[8];
        this.f7879k = new RectF();
        this.f7880l = new RectF();
        this.f7881m = new RectF();
        this.f7882n = new RectF();
        this.f7883o = new Matrix();
        this.f7884p = new Matrix();
        this.f7885q = new Matrix();
        this.f7886r = new Matrix();
        this.s = new Matrix();
        this.f7887t = new Matrix();
        this.f7888u = 0.0f;
        this.f7889v = true;
        this.f7873a = r5;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(boolean r5) {
        this.f7874b = r5;
        this.f7889v = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b() {
    }

    public final void c() {
        if (this.f7889v == false) goto L19;
        this.f7876h.reset();
        RectF r5 = this.f7879k;
        float r10 = this.d / 2.0f;
        r5.inset(r10, r10);
        if (this.f7874b == false) goto L7;
        this.f7876h.addCircle(this.f7879k.centerX(), this.f7879k.centerY(), Math.min(this.f7879k.width(), this.f7879k.height()) / 2.0f, Path.Direction.CW);
    L12:
        RectF r11 = this.f7879k;
        float r12 = (-this.d) / 2.0f;
        r11.inset(r12, r12);
        this.e.reset();
        float r13 = this.f7888u + 0.0f;
        this.f7879k.inset(r13, r13);
        if (this.f7874b == false) goto L15;
        this.e.addCircle(this.f7879k.centerX(), this.f7879k.centerY(), Math.min(this.f7879k.width(), this.f7879k.height()) / 2.0f, Path.Direction.CW);
    L16:
        float r14 = -r13;
        this.f7879k.inset(r14, r14);
        this.e.setFillType(Path.FillType.WINDING);
        this.f7889v = false;
        return;
    L15:
        this.e.addRoundRect(this.f7879k, this.f7877i, Path.Direction.CW);
        goto L16
    L7:
        int r15 = 0;
    L8:
        float[] r16 = this.f7878j;
        if (r15 >= r16.length) goto L11;
        r16[r15] = (this.f7877i[r15] + this.f7888u) - (this.d / 2.0f);
        r15 = r15 + 1;
        goto L8
    L11:
        this.f7876h.addRoundRect(this.f7879k, r16, Path.Direction.CW);
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        this.f7873a.clearColorFilter();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void d() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        FrescoSystrace.a().getClass();
        this.f7873a.draw(r5);
        FrescoSystrace.a().getClass();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    public final void e() {
        ?? r5 = this.f7890w;
        if (r5 == 0) goto L5;
        r5.a(this.f7885q);
        this.f7890w.a(this.f7879k);
    L6:
        Drawable r10 = this.f7873a;
        if ((r10 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r11 = (BitmapDrawable) r10;
        this.f7881m.set(0.0f, 0.0f, r11.getBitmap().getWidth(), r11.getBitmap().getHeight());
        this.f7882n.set(r11.getBounds());
    L10:
        this.f7883o.setRectToRect(this.f7881m, this.f7882n, Matrix.ScaleToFit.FILL);
        if (this.f7885q.equals(this.f7886r) == true) goto L13;
    L15:
        this.f = true;
        this.f7885q.invert(this.s);
        this.f7887t.set(this.f7885q);
        this.f7887t.preConcat(this.f7883o);
        this.f7886r.set(this.f7885q);
        this.f7884p.set(this.f7883o);
    L17:
        if (this.f7879k.equals(this.f7880l) == true) goto L20;
        this.f7889v = true;
        this.f7880l.set(this.f7879k);
        return;
    L20:
        return;
    L13:
        if (this.f7883o.equals(this.f7884p) == false) goto L15;
    L9:
        this.f7881m.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.f7882n.set(this.f7873a.getBounds());
        goto L10
    L5:
        this.f7885q.reset();
        this.f7879k.set(getBounds());
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7873a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f7873a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7873a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7873a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f7873a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        this.f7873a.setBounds(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.f7873a.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int r5, PorterDuff.Mode r10) {
        this.f7873a.setColorFilter(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.f7873a.setColorFilter(r5);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a() {
        Arrays.fill(this.f7877i, 0.0f);
        this.f7875c = false;
        this.f7889v = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float[] r10) {
        if (r10 != null) goto L6;
        Arrays.fill(this.f7877i, 0.0f);
        this.f7875c = false;
    L17:
        this.f7889v = true;
        invalidateSelf();
        return;
    L6:
        if (r10.length != 8) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L20;
        System.arraycopy(r10, 0, this.f7877i, 0, 8);
        this.f7875c = false;
        int r11 = 0;
    L11:
        if (r11 >= 8) goto L17;
        boolean r12 = this.f7875c;
        if (r10[r11] <= 0.0f) goto L15;
        boolean r13 = true;
    L16:
        this.f7875c = r12 | r13;
        r11 = r11 + 1;
        goto L11
    L15:
        r13 = false;
        goto L16
    L20:
        throw new IllegalArgumentException("radii should have exactly 8 values");
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(int r5, float r10) {
        if (this.g == r5) goto L5;
    L8:
        this.g = r5;
        this.d = r10;
        this.f7889v = true;
        invalidateSelf();
        return;
    L5:
        if (this.d != r10) goto L8;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float r5) {
        if (this.f7888u == r5) goto L6;
        this.f7888u = r5;
        this.f7889v = true;
        invalidateSelf();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void a(TransformCallback r5) {
        this.f7890w = (Drawable) r5;
    }
}
