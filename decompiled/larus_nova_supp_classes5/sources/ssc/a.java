package ssc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends Drawable {
    public final int a;
    public final int b;
    public final Paint c;
    public final RectF d;
    public final Paint e;
    public final Path f;
    public boolean g;

    /* JADX INFO: renamed from: ssc.a$a, reason: collision with other inner class name */
    public static class C0030a {
        public C0030a(float r1, float r2) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    static {
        new C0030a(0.3888889f, 0.6944444f);
        new C0030a(0.8472222f, 0.2638889f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        if (this.g == false) goto L5;
        Paint.Style r0 = Paint.Style.FILL_AND_STROKE;
        int r1 = this.a;
    L6:
        this.c.setStyle(r0);
        this.c.setColor(r1);
        Rect r2 = getBounds();
        float r3 = (r2.width() - this.d.width()) / 2.0f;
        float r4 = (r2.height() - this.d.height()) / 2.0f;
        float r6 = this.d.width() / 8.0f;
        int r7 = r5.save();
        r5.translate(r3, r4);     // Catch: Throwable -> L12
        r5.drawRoundRect(this.d, r6, r6, this.c);     // Catch: Throwable -> L12
        if (this.g == false) goto L10;
        r5.drawPath(this.f, this.e);     // Catch: Throwable -> L12
    L10:
        r5.restoreToCount(r7);
        return;
    L12:
        th = move-exception;
        r5.restoreToCount(r7);
        throw th;
    L5:
        r0 = Paint.Style.STROKE;
        r1 = this.b;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r4) {
        super.onBoundsChange(r4);
        float r5 = Math.min(r4.width(), r4.height());
        float r0 = r5 / 8.0f;
        float r6 = r5 - r0;
        this.d.set(0.0f, 0.0f, r6, r6);
        this.c.setStrokeWidth(r0);
        this.e.setStrokeWidth(r0);
        this.f.reset();
        this.f.moveTo(0.15277778f * r6, 0.45833334f * r6);
        this.f.lineTo(0.3888889f * r6, 0.6944444f * r6);
        this.f.lineTo(0.8472222f * r6, r6 * 0.2638889f);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r7) {
        boolean r0 = false;
        if (r7 == null) goto L5;
        int r1 = r7.length;
    L7:
        if (r1 <= 0) goto L14;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L14;
        if (16842912 == r7[r3]) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        boolean r8 = true;
    L16:
        if (r8 == this.g) goto L18;
        r0 = true;
    L18:
        if (r0 == false) goto L20;
        invalidateSelf();
        this.g = r8;
    L20:
        return r0;
    L14:
        r8 = false;
        goto L16
    L5:
        r1 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.c.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
    }

    public a(int r3, int r4, int r5) {
        this.c = new Paint(1);
        this.d = new RectF();
        Paint r0 = new Paint(1);
        this.e = r0;
        this.f = new Path();
        this.a = r3;
        this.b = r4;
        r0.setColor(r5);
        r0.setStyle(Paint.Style.STROKE);
    }
}
