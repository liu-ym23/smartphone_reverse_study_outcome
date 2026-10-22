package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleTypeDrawable extends ForwardingDrawable {
    public ScalingUtils.ScaleType d;
    public final PointF e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Matrix f7891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f7892i;

    public ScaleTypeDrawable(Drawable r5, ScalingUtils.ScaleType r10) {
        r5.getClass();
        super(r5);
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.f7892i = new Matrix();
        this.d = r10;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public final void a(Matrix r5) {
        b(r5);
        if (this.f == this.f7847a.getIntrinsicWidth()) goto L5;
    L6:
        e();
    L7:
        Matrix r10 = this.f7891h;
        if (r10 == null) goto L11;
        r5.preConcat(r10);
        return;
    L11:
        return;
    L5:
        if (this.g == this.f7847a.getIntrinsicHeight()) goto L7;
        goto L6
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public final Drawable b(Drawable r5) {
        Drawable r10 = super.b(r5);
        e();
        return r10;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        if (this.f == this.f7847a.getIntrinsicWidth()) goto L5;
    L6:
        e();
    L8:
        if (this.f7891h == null) goto L14;
        int r10 = r5.save();
        r5.clipRect(getBounds());
        r5.concat(this.f7891h);
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L12;
        r11.draw(r5);
    L12:
        r5.restoreToCount(r10);
        return;
    L14:
        Drawable r12 = this.f7847a;
        if (r12 == null) goto L18;
        r12.draw(r5);
        return;
    L18:
        return;
    L5:
        if (this.g == this.f7847a.getIntrinsicHeight()) goto L8;
        goto L6
    }

    public final void e() {
        Drawable r5 = this.f7847a;
        Rect r10 = getBounds();
        int r11 = r10.width();
        int r12 = r10.height();
        int r13 = r5.getIntrinsicWidth();
        this.f = r13;
        int r14 = r5.getIntrinsicHeight();
        this.g = r14;
        if (r13 <= 0) goto L23;
        if (r14 <= 0) goto L23;
        if (r13 != r11) goto L10;
        if (r14 != r12) goto L10;
        r5.setBounds(r10);
        this.f7891h = null;
        return;
    L10:
        ScalingUtils.ScaleType r15 = this.d;
        ScalingUtils.ScaleType r16 = ScalingUtils.ScaleType.f7893a;
        if (r15 != ScalingUtils.ScaleTypeFitXY.f7905j) goto L14;
        r5.setBounds(r10);
        this.f7891h = null;
        return;
    L14:
        r5.setBounds(0, 0, r13, r14);
        ScalingUtils.ScaleType r17 = this.d;
        Matrix r18 = this.f7892i;
        PointF r19 = this.e;
        if (r19 == null) goto L17;
        float r20 = r19.x;
    L18:
        if (r19 == null) goto L20;
        float r21 = r19.y;
    L21:
        r17.a(r18, r10, r13, r14, r20, r21);
        this.f7891h = this.f7892i;
        return;
    L20:
        r21 = 0.5f;
        goto L21
    L17:
        r20 = 0.5f;
    L23:
        r5.setBounds(r10);
        this.f7891h = null;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        e();
    }
}
