package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends j {
    public static final Paint g = null;
    public final Rect b;
    public final NinePatchDrawable c;
    public final String d;
    public final int e;
    public final float f;

    public static final class a {
    }

    static {
        Paint r0 = new Paint();
        r0.setTextAlign(Paint.Align.LEFT);
        r0.setAntiAlias(true);
        r0.setStyle(Paint.Style.FILL_AND_STROKE);
        r0.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        g = r0;
    }

    public f(NinePatchDrawable r4, String r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r4, "drawable");
        Intrinsics.checkNotNullParameter(r5, "content");
        super(r4);
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        Rect r8 = new Rect();
        this.b = r8;
        r4.getPadding(r8);
        Rect r0 = new Rect();
        Paint r1 = g;
        r1.setTextSize(r7);
        r1.getTextBounds(r5, 0, r5.length(), r0);
        r4.getBounds().right += Math.max(0, r0.width() - ((r4.getBounds().width() - r8.left) - r8.right));
    }

    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        super.draw(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r2.save();
        r2.translate(r6, b(r10, r8));
        Paint r11 = g;
        r11.setTextSize(this.f);
        r11.setColor(this.e);
        r2.drawText(this.d, this.b.left, ((this.c.getIntrinsicHeight() / 2) + ((r11.getFontMetrics().descent - r11.getFontMetrics().ascent) / 2)) - r11.getFontMetrics().descent, r11);
        r2.restore();
    }
}
