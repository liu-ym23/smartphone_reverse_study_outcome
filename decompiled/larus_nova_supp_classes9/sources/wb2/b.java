package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends j {
    public float b;

    public final float a(float r1) {
        return r1;
    }

    public final float b(Paint r1, int r2) {
        return 0.0f;
    }

    public b(Drawable r1) {
        super(r1);
        this.b = 1.0f;
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
        float r11 = (r10.getBounds().bottom - r10.getBounds().top) * this.b;
        r1.save();
        r1.translate(r5, (r6 + ((r8 - r6) / 2.0f)) - (r11 / 2.0f));
        float r13 = this.b;
        r1.scale(r13, r13);
        r10.draw(r1);
        r1.restore();
    }
}
