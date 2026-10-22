package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class OrientedDrawable extends ForwardingDrawable {
    public final Matrix d;
    public final int e;
    public final int f;
    public final Matrix g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f7850h;

    public OrientedDrawable(BitmapDrawable r5, int r10, int r11) {
        super(r5);
        this.g = new Matrix();
        this.f7850h = new RectF();
        this.d = new Matrix();
        this.e = r10 - (r10 % 90);
        if (r11 >= 0) goto L5;
    L7:
        r11 = 0;
    L8:
        this.f = r11;
        return;
    L5:
        if (r11 > 8) goto L7;
        goto L7
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public final void a(Matrix r5) {
        b(r5);
        if (this.d.isIdentity() == true) goto L6;
        r5.preConcat(this.d);
        return;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        if (this.e > 0) goto L12;
        int r10 = this.f;
        if (r10 != 0) goto L7;
    L8:
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L17;
        r11.draw(r5);
        return;
    L17:
        return;
    L7:
        if (r10 == 1) goto L8;
    L12:
        int r12 = r5.save();
        r5.concat(this.d);
        Drawable r13 = this.f7847a;
        if (r13 == null) goto L15;
        r13.draw(r5);
    L15:
        r5.restoreToCount(r12);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        int r5 = this.f;
        if (r5 == 5) goto L12;
        if (r5 == 7) goto L12;
        if ((this.e % 180) != 0) goto L12;
        return super.getIntrinsicHeight();
    L12:
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        int r5 = this.f;
        if (r5 == 5) goto L12;
        if (r5 == 7) goto L12;
        if ((this.e % 180) != 0) goto L12;
        return super.getIntrinsicWidth();
    L12:
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r10) {
        Drawable r5 = this.f7847a;
        int r11 = this.e;
        if (r11 > 0) goto L11;
        int r12 = this.f;
        if (r12 != 0) goto L7;
    L9:
        r5.setBounds(r10);
        return;
    L7:
        if (r12 == 1) goto L9;
    L11:
        int r13 = this.f;
        if (r13 != 2) goto L14;
        this.d.setScale(-1.0f, 1.0f);
    L24:
        this.g.reset();
        this.d.invert(this.g);
        this.f7850h.set(r10);
        this.g.mapRect(this.f7850h);
        RectF r14 = this.f7850h;
        r5.setBounds((int) r14.left, (int) r14.top, (int) r14.right, (int) r14.bottom);
        return;
    L14:
        if (r13 != 7) goto L16;
        this.d.setRotate(270.0f, r10.centerX(), r10.centerY());
        this.d.postScale(-1.0f, 1.0f);
        goto L24
    L16:
        if (r13 != 4) goto L18;
        this.d.setScale(1.0f, -1.0f);
        goto L24
    L18:
        if (r13 == 5) goto L20;
        this.d.setRotate(r11, r10.centerX(), r10.centerY());
        goto L24
    L20:
        this.d.setRotate(270.0f, r10.centerX(), r10.centerY());
        this.d.postScale(1.0f, -1.0f);
        goto L24
    }
}
