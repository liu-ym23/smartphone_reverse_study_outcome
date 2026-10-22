package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedBitmapDrawable extends RoundedDrawable {
    public WeakReference A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f7851x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f7852y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Bitmap f7853z;

    public RoundedBitmapDrawable(Resources r5, Bitmap r10, Paint r11) {
        super(new BitmapDrawable(r5, r10));
        Paint r12 = new Paint();
        this.f7851x = r12;
        Paint r13 = new Paint(1);
        this.f7852y = r13;
        this.f7853z = r10;
        if ((this.f7873a instanceof BitmapDrawable) == false) goto L8;
        if (r10 == null) goto L8;
        int r14 = r10.getDensity();
        int r15 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (r14 != r15) goto L8;
        ((BitmapDrawable) this.f7873a).setTargetDensity(r15);
    L8:
        if (r11 == null) goto L10;
        r12.set(r11);
    L10:
        r12.setFlags(1);
        r13.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        FrescoSystrace.a().getClass();
        if (f() == true) goto L6;
        super.draw(r10);
        FrescoSystrace.a().getClass();
        return;
    L6:
        e();
        c();
        WeakReference r5 = this.A;
        if (r5 != null) goto L9;
    L10:
        this.A = new WeakReference(this.f7853z);
        this.f7851x.setFilterBitmap(true);
        Paint r11 = this.f7851x;
        Bitmap r12 = this.f7853z;
        Shader.TileMode r13 = Shader.TileMode.CLAMP;
        r11.setShader(new BitmapShader(r12, r13, r13));
        this.f = true;
    L12:
        if (this.f == false) goto L14;
        this.f7851x.getShader().setLocalMatrix(this.f7887t);
        this.f = false;
    L14:
        this.f7851x.setFilterBitmap(false);
        int r14 = r10.save();
        r10.concat(this.s);
        r10.drawPath(this.e, this.f7851x);
        float r15 = this.d;
        if (r15 <= 0.0f) goto L17;
        this.f7852y.setStrokeWidth(r15);
        this.f7852y.setColor(DrawableUtils.a(this.g, this.f7851x.getAlpha()));
        r10.drawPath(this.f7876h, this.f7852y);
    L17:
        r10.restoreToCount(r14);
        FrescoSystrace.a().getClass();
        return;
    L9:
        if (r5.get() == this.f7853z) goto L12;
        goto L10
    }

    public final boolean f() {
        if (this.f7874b == true) goto L9;
        if (this.f7875c == true) goto L9;
        if (this.d > 0.0f) goto L9;
        return false;
    L9:
        if (this.f7853z == null) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Bitmap r5 = this.f7853z;
        if (r5 == null) goto L7;
        return r5.getHeight();
    L7:
        return this.f7873a.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Bitmap r5 = this.f7853z;
        if (r5 == null) goto L7;
        return r5.getWidth();
    L7:
        return this.f7873a.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f7873a.setAlpha(r5);
        if (r5 == this.f7851x.getAlpha()) goto L6;
        this.f7851x.setAlpha(r5);
        this.f7873a.setAlpha(r5);
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        this.f7873a.setColorFilter(r5);
        this.f7851x.setColorFilter(r5);
    }
}
