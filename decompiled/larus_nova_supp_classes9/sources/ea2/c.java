package ea2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import wb2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends j {
    public static final Paint d = null;
    public final String b;
    public final int c;

    public static final class a {
    }

    static {
        d = new Paint();
    }

    public c(String r2, int r3, Drawable r4) {
        Intrinsics.checkNotNullParameter(r2, "contentText");
        Intrinsics.checkNotNullParameter(r4, "drawable");
        super(r4);
        this.b = r2;
        this.c = r3;
        Paint r5 = d;
        r5.setStyle(Paint.Style.FILL_AND_STROKE);
        r5.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        super.draw(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        int r11 = getDrawable().getBounds().width();
        int r13 = getDrawable().getBounds().height();
        Paint r14 = d;
        float r15 = r13;
        r14.setTextSize(0.47f * r15);
        r14.setColor(this.c);
        float r16 = r14.measureText(this.b);
        float r17 = r11 - r13;
        if (r16 <= r17) goto L5;
        r16 = r17;
    L5:
        float r18 = (r6 + r15) + ((r17 - r16) * 0.4f);
        r2.drawText(this.b, r18, ((((((r10.getFontMetricsInt().descent + r8) + r8) + r10.getFontMetricsInt().ascent) / 2) - (r13 / 2)) + (((r13 - r14.getFontMetricsInt().descent) + r14.getFontMetricsInt().ascent) * 0.65f)) - r14.getFontMetricsInt().ascent, r14);
    }
}
