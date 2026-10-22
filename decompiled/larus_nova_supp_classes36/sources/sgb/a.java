package sgb;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends Drawable {
    public final float a;
    public final float b;
    public final float c;
    public final Paint d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public a() {
        this.a = 145.36f;
        this.b = 0.6018f;
        this.c = 1.2244f;
        this.d = new Paint(1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r3.drawRect(getBounds(), this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r25) {
        Intrinsics.checkNotNullParameter(r25, "bounds");
        Paint r1 = this.d;
        int r3 = r25.width();
        int r2 = r25.height();
        float r4 = this.a;
        float r5 = this.b;
        float r6 = this.c;
        float r7 = r3;
        float r8 = r2;
        double r9 = Math.toRadians(r4);
        float r10 = (float) Math.sin(r9);
        float r11 = (float) (-Math.cos(r9));
        float r12 = RangesKt.coerceAtLeast((float) Math.hypot(r10, r11), 1.0E-6f);
        float r13 = r10 / r12;
        float r14 = r11 / r12;
        int r15 = 4;
        Float r16 = Float.valueOf(0.0f);
        Pair[] r17 = {TuplesKt.to(r16, r16), TuplesKt.to(Float.valueOf(r7), r16), TuplesKt.to(r16, Float.valueOf(r8)), TuplesKt.to(Float.valueOf(r7), Float.valueOf(r8))};
        float r18 = Float.POSITIVE_INFINITY;
        float r19 = Float.NEGATIVE_INFINITY;
        int r110 = 0;
    L3:
        if (r110 >= r15) goto L5;
        Pair r111 = r17[r110];
        float r20 = (((Number) r111.component1()).floatValue() * r13) + (((Number) r111.component2()).floatValue() * r14);
        r18 = Math.min(r18, r20);
        r19 = Math.max(r19, r20);
        r110 = r110 + 1;
        r15 = 4;
        goto L3
    L5:
        float r112 = r13 * r18;
        float r113 = r14 * r18;
        r1.setShader(new LinearGradient(r112, r113, r112 + (((r13 * r19) - r112) * r6), r113 + (((r14 * r19) - r113) * r6), new int[]{0, 0, Color.argb(MathKt.roundToInt(38.25f), 0, 0, 0)}, new float[]{0.0f, RangesKt.coerceIn(r5 / r6, 0.0f, 1.0f), 1.0f}, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.d.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.d.setColorFilter(r2);
    }
}
