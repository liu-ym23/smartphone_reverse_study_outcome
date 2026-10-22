package ea2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;
import wb2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends j {
    public static final Paint e = null;
    public final String b;
    public final int c;
    public final boolean d;

    public static final class a {
    }

    static {
        e = new Paint();
    }

    public b(String r2, int r3, boolean r4, Drawable r5) {
        Intrinsics.checkNotNullParameter(r2, "contentText");
        Intrinsics.checkNotNullParameter(r5, "drawable");
        super(r5);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        Paint r6 = e;
        r6.setStyle(Paint.Style.FILL_AND_STROKE);
        r6.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r3, CharSequence r4, int r5, int r6, float r7, int r8, int r9, int r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r11, "paint");
        super.draw(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        int r13 = getDrawable().getBounds().width();
        int r14 = getDrawable().getBounds().height();
        Paint r15 = e;
        float r16 = r14;
        if (this.d == false) goto L5;
        float r17 = 0.54f;
    L6:
        r15.setTextSize(r17 * r16);
        r15.setColor(this.c);
        float r18 = r15.measureText(this.b);
        if (this.d == false) goto L9;
        int r19 = (int) s1.e(30.0f);
    L10:
        float r20 = r19;
        if (r18 <= r20) goto L14;
        r18 = r20;
    L14:
        if (this.d == false) goto L16;
        float r21 = (((r9 + r11.getFontMetricsInt().ascent) + ((r14 - (r15.getFontMetricsInt().descent - r15.getFontMetricsInt().ascent)) * 0.5f)) - r15.getFontMetricsInt().ascent) - 0.5f;
        float r23 = (r7 + s1.e(17.0f)) + ((r20 - r18) * 0.5f);
    L20:
        r3.drawText(this.b, r23, r21, r15);
        return;
    L16:
        float r24 = ((((((r11.getFontMetricsInt().descent + r9) + r9) + r11.getFontMetricsInt().ascent) / 2) - (r14 / 2)) + (((r14 - r15.getFontMetricsInt().descent) + r15.getFontMetricsInt().ascent) * 0.5f)) - r15.getFontMetricsInt().ascent;
        r23 = (r7 + r16) + ((r20 - r18) * 0.5f);
        float r25 = r23 - r16;
        float r26 = 4;
        if (r25 < r26) goto L19;
        r23 = r23 - r26;
    L19:
        r21 = r24;
        goto L20
    L9:
        r19 = r13 - r14;
        goto L10
    L5:
        r17 = 0.57f;
        goto L6
    }
}
