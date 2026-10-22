package sqb;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends Drawable {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final Paint e;
    public final Paint f;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in the Android SDK")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Paint.FontMetricsInt r0 = this.f.getFontMetricsInt();
        return (r0.bottom - r0.top) + (this.c * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return MathKt.roundToInt(this.f.measureText(this.a)) + (this.b * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        r5.drawRect(getBounds(), this.e);
        r5.drawText(this.a, getBounds().left + this.b, (getBounds().top + this.c) - this.f.getFontMetricsInt().top, this.f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r3) {
        this.f.setAlpha(r3);
        this.e.setAlpha((Color.alpha(1157508181) * r3) / 255);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.f.setColorFilter(r2);
        this.e.setColorFilter(r2);
        invalidateSelf();
    }

    public b(LynxView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a = r3;
        Resources r4 = r2.getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density;
        this.b = MathKt.roundToInt(3.0f * r5);
        this.c = MathKt.roundToInt(1.0f * r5);
        this.d = MathKt.roundToInt(10.0f * r5);
        Paint r6 = new Paint();
        r6.setColor(1157508181);
        r6.setStyle(Paint.Style.FILL);
        this.e = r6;
        Paint r7 = new Paint(1);
        r7.setColor(-1);
        r7.setTextSize(r5 * 12.0f);
        this.f = r7;
    }
}
