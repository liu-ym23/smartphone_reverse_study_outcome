package io.noties.markwon.ext.tasklist;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes6.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0864a f16529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0864a f16530b = null;
    private static final C0864a c = null;
    private final int d;
    private final int e;
    private final Paint f;
    private final RectF g;
    private final Paint h;
    private final Path i;
    private boolean j;

    /* JADX INFO: renamed from: io.noties.markwon.ext.tasklist.a$a, reason: collision with other inner class name */
    private static class C0864a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f16531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f16532b;

        C0864a(float r1, float r2) {
            this.f16531a = r1;
            this.f16532b = r2;
        }

        void a(Path r2, float r3) {
            r2.moveTo(this.f16531a * r3, r3 * this.f16532b);
        }

        void b(Path r2, float r3) {
            r2.lineTo(this.f16531a * r3, r3 * this.f16532b);
        }
    }

    static {
        f16529a = new C0864a(0.15277778f, 0.45833334f);
        f16530b = new C0864a(0.3888889f, 0.6944444f);
        c = new C0864a(0.8472222f, 0.2638889f);
    }

    public a(int r3, int r4, int r5) {
        this.f = new Paint(1);
        this.g = new RectF();
        Paint r0 = new Paint(1);
        this.h = r0;
        this.i = new Path();
        this.d = r3;
        this.e = r4;
        r0.setColor(r5);
        r0.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        if (this.j == false) goto L5;
        Paint.Style r0 = Paint.Style.FILL_AND_STROKE;
        int r1 = this.d;
    L6:
        this.f.setStyle(r0);
        this.f.setColor(r1);
        Rect r2 = getBounds();
        float r3 = (r2.width() - this.g.width()) / 2.0f;
        float r4 = (r2.height() - this.g.height()) / 2.0f;
        float r6 = this.g.width() / 8.0f;
        int r7 = r5.save();
        r5.translate(r3, r4);     // Catch: Throwable -> L12
        r5.drawRoundRect(this.g, r6, r6, this.f);     // Catch: Throwable -> L12
        if (this.j == false) goto L10;
        r5.drawPath(this.i, this.h);     // Catch: Throwable -> L12
    L10:
        r5.restoreToCount(r7);
        return;
    L12:
        th = move-exception;
        r5.restoreToCount(r7);
        throw th;
    L5:
        r0 = Paint.Style.STROKE;
        r1 = this.e;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r4) {
        super.onBoundsChange(r4);
        float r5 = Math.min(r4.width(), r4.height());
        float r0 = r5 / 8.0f;
        float r6 = r5 - r0;
        this.g.set(0.0f, 0.0f, r6, r6);
        this.f.setStrokeWidth(r0);
        this.h.setStrokeWidth(r0);
        this.i.reset();
        f16529a.a(this.i, r6);
        f16530b.b(this.i, r6);
        c.b(this.i, r6);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r7) {
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
        if (r8 == this.j) goto L18;
        r0 = true;
    L18:
        if (r0 == false) goto L20;
        invalidateSelf();
        this.j = r8;
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
    public void setAlpha(int r1) {
        this.f.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.f.setColorFilter(r1);
    }
}
