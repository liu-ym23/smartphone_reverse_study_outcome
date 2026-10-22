package o29;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends Drawable {
    public final float a;
    public final float b;
    public final int[] c;
    public final int[] d;
    public final float e;
    public final Paint f;
    public final Paint g;
    public final RectF h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        if (this.d == null) goto L5;
        RectF r0 = this.h;
        float r1 = this.b;
        r4.drawRoundRect(r0, r1, r1, this.g);
    L5:
        RectF r2 = this.h;
        float r3 = this.b;
        r4.drawRoundRect(r2, r3, r3, this.f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r15) {
        Intrinsics.checkNotNullParameter(r15, "bounds");
        super.onBoundsChange(r15);
        RectF r0 = this.h;
        float r1 = r15.left;
        float r2 = this.a;
        r0.set(r1 + (r2 / 2.0f), r15.top + (r2 / 2.0f), r15.right - (r2 / 2.0f), r15.bottom - (r2 / 2.0f));
        double r3 = Math.toRadians(this.e);
        float r16 = (float) Math.cos(r3);
        float r4 = (float) Math.sin(r3);
        float r5 = this.h.centerX();
        float r6 = this.h.centerY();
        float r17 = r16 * (this.h.width() / 2.0f);
        float r7 = r5 - r17;
        float r8 = r4 * (this.h.height() / 2.0f);
        float r9 = r6 - r8;
        float r18 = r17 + r5;
        float r10 = r8 + r6;
        this.f.setShader(new LinearGradient(r7, r9, r18, r10, this.c, null, Shader.TileMode.CLAMP));
        if (this.d == null) goto L6;
        this.g.setShader(new LinearGradient(r7, r9, r18, r10, this.d, null, Shader.TileMode.CLAMP));
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.f.setAlpha(r2);
        this.g.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.f.setColorFilter(r2);
        this.g.setColorFilter(r2);
        invalidateSelf();
    }

    public a(float r2, float r3, int[] r4, int[] r5) {
        Intrinsics.checkNotNullParameter(r4, "borderColorList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 0.0f;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(r2);
        r6.setDither(true);
        r6.setFilterBitmap(true);
        r6.setStrokeJoin(Paint.Join.ROUND);
        r6.setStrokeCap(Paint.Cap.ROUND);
        this.f = r6;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.FILL);
        r7.setDither(true);
        r7.setFilterBitmap(true);
        r7.setStrokeJoin(Paint.Join.ROUND);
        r7.setStrokeCap(Paint.Cap.ROUND);
        this.g = r7;
        this.h = new RectF();
    }
}
