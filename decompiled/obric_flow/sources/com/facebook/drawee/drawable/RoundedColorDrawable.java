package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedColorDrawable extends Drawable implements Rounded {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f7854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f7855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f7856c;
    public boolean d;
    public float e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f7857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f7858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f7860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7861l;

    public RoundedColorDrawable(int r5) {
        this.f7854a = new float[8];
        this.f7855b = new float[8];
        this.f7856c = new Paint(1);
        this.d = false;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0;
        this.f7857h = new Path();
        this.f7858i = new Path();
        this.f7859j = 0;
        this.f7860k = new RectF();
        this.f7861l = 255;
        if (r5 == 0) goto L6;
        this.f7859j = r5;
        invalidateSelf();
        return;
    }

    public static RoundedColorDrawable a(ColorDrawable r5) {
        return new RoundedColorDrawable(r5.getColor());
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b() {
    }

    public final void c() {
        this.f7857h.reset();
        this.f7858i.reset();
        this.f7860k.set(getBounds());
        RectF r5 = this.f7860k;
        float r10 = this.e / 2.0f;
        r5.inset(r10, r10);
        if (this.d == false) goto L5;
        float r11 = Math.min(this.f7860k.width(), this.f7860k.height()) / 2.0f;
        this.f7858i.addCircle(this.f7860k.centerX(), this.f7860k.centerY(), r11, Path.Direction.CW);
    L10:
        RectF r12 = this.f7860k;
        float r13 = (-this.e) / 2.0f;
        r12.inset(r13, r13);
        float r14 = this.f + 0.0f;
        this.f7860k.inset(r14, r14);
        if (this.d == false) goto L13;
        float r15 = Math.min(this.f7860k.width(), this.f7860k.height()) / 2.0f;
        this.f7857h.addCircle(this.f7860k.centerX(), this.f7860k.centerY(), r15, Path.Direction.CW);
    L14:
        float r16 = -r14;
        this.f7860k.inset(r16, r16);
        return;
    L13:
        this.f7857h.addRoundRect(this.f7860k, this.f7854a, Path.Direction.CW);
        goto L14
    L5:
        int r17 = 0;
    L6:
        float[] r18 = this.f7855b;
        if (r17 >= r18.length) goto L9;
        r18[r17] = (this.f7854a[r17] + this.f) - (this.e / 2.0f);
        r17 = r17 + 1;
        goto L6
    L9:
        this.f7858i.addRoundRect(this.f7860k, r18, Path.Direction.CW);
        goto L10
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void d() {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        this.f7856c.setColor(DrawableUtils.a(this.f7859j, this.f7861l));
        this.f7856c.setStyle(Paint.Style.FILL);
        this.f7856c.setFilterBitmap(false);
        r5.drawPath(this.f7857h, this.f7856c);
        if (this.e == 0.0f) goto L6;
        this.f7856c.setColor(DrawableUtils.a(this.g, this.f7861l));
        this.f7856c.setStyle(Paint.Style.STROKE);
        this.f7856c.setStrokeWidth(this.e);
        r5.drawPath(this.f7858i, this.f7856c);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7861l;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int r5 = DrawableUtils.a(this.f7859j, this.f7861l) >>> 24;
        if (r5 != 255) goto L6;
        return -1;
    L6:
        if (r5 != 0) goto L9;
        return -2;
    L9:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (r5 == this.f7861l) goto L6;
        this.f7861l = r5;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(boolean r5) {
        this.d = r5;
        c();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float[] r5) {
        if (r5 != null) goto L5;
        Arrays.fill(this.f7854a, 0.0f);
    L10:
        c();
        invalidateSelf();
        return;
    L5:
        if (r5.length != 8) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L13;
        System.arraycopy(r5, 0, this.f7854a, 0, 8);
        goto L10
    L13:
        throw new IllegalArgumentException("radii should have exactly 8 values");
    L7:
        r10 = false;
        goto L8
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a() {
        Arrays.fill(this.f7854a, 0.0f);
        c();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(int r5, float r10) {
        if (this.g == r5) goto L6;
        this.g = r5;
        invalidateSelf();
    L6:
        if (this.e == r10) goto L9;
        this.e = r10;
        c();
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void a(float r5) {
        if (this.f == r5) goto L6;
        this.f = r5;
        c();
        invalidateSelf();
        return;
    }
}
