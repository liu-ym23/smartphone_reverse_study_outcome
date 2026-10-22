package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends j {
    public float b;

    public final float a(float r1) {
        return r1;
    }

    public c(Drawable r1) {
        super(r1);
        this.b = 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float b(Paint r4, int r5) {
        Paint.FontMetricsInt r6 = r4.getFontMetricsInt();
        return (((r6.descent + r6.ascent) / 2.0f) - ((getDrawable().getBounds().bottom * this.b) / 2.0f)) + r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Rect r7 = getDrawable().getBounds();
        if (r6 == null) goto L6;
        Paint.FontMetricsInt r8 = r2.getFontMetricsInt();
        int r9 = r8.bottom - r8.top;
        int r10 = r7.bottom - r7.top;
        this.b = r2.getTextSize() / r10;
        int r11 = r10 / 2;
        int r13 = r9 / 4;
        int r14 = r11 - r13;
        int r15 = -(r11 + r13);
        r6.ascent = r15;
        r6.top = r15;
        r6.bottom = r14;
        r6.descent = r14;
    L6:
        return (int) ((r7.right * this.b) + 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = getDrawable();
        r1.save();
        r1.translate(r5, 0.0f);
        float r11 = this.b;
        r1.scale(r11, r11);
        r1.translate(0.0f, b(r9, r7));
        r10.draw(r1);
        r1.restore();
    }
}
