package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {
    public final int d;
    public final boolean e;
    public float f;
    public boolean g;

    public AutoRotateDrawable(Drawable r5, int r10) {
        r5.getClass();
        super(r5);
        this.f = 0.0f;
        this.g = false;
        this.d = r10;
        this.e = true;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        int r5 = r10.save();
        Rect r11 = getBounds();
        int r12 = r11.right;
        int r13 = r11.left;
        int r14 = r12 - r13;
        int r15 = r11.bottom;
        int r16 = r11.top;
        int r17 = r15 - r16;
        float r18 = this.f;
        if (this.e == true) goto L5;
        r18 = 360.0f - r18;
    L5:
        r10.rotate(r18, (r14 / 2) + r13, (r17 / 2) + r16);
        Drawable r19 = this.f7847a;
        if (r19 == null) goto L8;
        r19.draw(r10);
    L8:
        r10.restoreToCount(r5);
        if (this.g == true) goto L12;
        this.g = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.g = false;
        this.f += (int) ((20.0f / this.d) * 360.0f);
        invalidateSelf();
    }
}
