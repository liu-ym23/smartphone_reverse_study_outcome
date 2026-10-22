package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends f {
    public int g;

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public final an.j a() {
        an.k r5 = new an.k(this.f, this);
        r5.f352m = null;
        return r5;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r12) {
        an.j r5 = this.e;
        if (((an.k) r5).f344a.isEmpty() == true) goto L11;
        RectF r10 = new RectF(getBounds());
        RectF r11 = new RectF(this.f10748c);
        RectF r13 = new RectF(this.d);
        an.k r14 = (an.k) r5;
        if (this.f10746a == null) goto L8;
        boolean r15 = true;
    L9:
        r14.a(r12, r10, r11, r13, r10, null, null, r15);
        return;
    L8:
        r15 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (r5 == this.g) goto L6;
        this.g = r5;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }
}
