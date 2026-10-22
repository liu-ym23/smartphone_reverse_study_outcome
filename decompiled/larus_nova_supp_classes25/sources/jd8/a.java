package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends FrameLayout {
    public final ImageView a;
    public final float b;
    public final Paint c;
    public final int d;
    public final Path e;
    public final RectF f;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.a.setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        ImageView r1 = new ImageView(r7);
        r1.setScaleType(ImageView.ScaleType.FIT_XY);
        r1.setImportantForAccessibility(2);
        this.a = r1;
        Resources r3 = getResources();
        this.b = TypedValue.applyDimension(1, 16.0f, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        Paint r4 = new Paint(1);
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(r.a(r7));
        Intrinsics.checkNotNullParameter(r7, "context");
        r4.setColor(ContextCompat.getColor(r7, v19.c.b(2130972087, r7, 2131103162)));
        this.c = r4;
        this.d = Color.alpha(r4.getColor());
        this.e = new Path();
        this.f = new RectF();
        setImportantForAccessibility(2);
        addView(r1, new FrameLayout.LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public final void a(Bitmap r2) {
        this.a.setImageBitmap(r2);
        if (r2 == null) goto L8;
        int r3 = this.c.getAlpha();
        int r0 = this.d;
        if (r3 == r0) goto L9;
        this.c.setAlpha(r0);
        invalidate();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.dispatchDraw(r6);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        float r0 = this.c.getStrokeWidth() / 2.0f;
        this.f.set(r0, r0, getWidth() - r0, getHeight() - r0);
        this.e.reset();
        Path r1 = this.e;
        RectF r2 = this.f;
        float r3 = this.b;
        r1.addRoundRect(r2, new float[]{0.0f, 0.0f, 0.0f, 0.0f, r3, r3, r3, r3}, Path.Direction.CW);
        r6.drawPath(this.e, this.c);
        return;
    }

    public final void setBorderFadeFraction(float r4) {
        int r5 = RangesKt.coerceIn(MathKt.roundToInt(this.d * RangesKt.coerceIn(r4, 0.0f, 1.0f)), 0, 255);
        if (this.c.getAlpha() == r5) goto L6;
        this.c.setAlpha(r5);
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(0, 0, 0, 0);
    }
}
