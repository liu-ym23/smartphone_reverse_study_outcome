package epc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends ReplacementSpan {
    public final Paint a;
    public final Drawable b;

    public b(a r2) {
        this.a = new Paint();
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        this.a.set(r2);
        if (r6 == null) goto L9;
        this.a.getFontMetricsInt(r6);
        Drawable r7 = this.b;
        if (r7 != null) goto L7;
        Rect r8 = new Rect();
    L8:
        int r9 = r6.descent - r6.ascent;
        int r10 = ((int) 0.0f) / 2;
        int r11 = r6.top;
        r6.ascent = Math.min(r11, ((r9 - r8.bottom) / 2) + r11) - r10;
        int r12 = r6.bottom;
        int r13 = Math.max(r12, ((r8.bottom - r9) / 2) + r12) + r10;
        r6.descent = r13;
        r6.top = r6.ascent;
        r6.bottom = r13;
        goto L9
    L7:
        r8 = r7.getBounds();
    L9:
        Drawable r14 = this.b;
        if (r14 != null) goto L12;
        Rect r15 = new Rect();
    L14:
        return r15.right;
    L12:
        r15 = r14.getBounds();
        goto L14
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        if (this.b == null) goto L6;
        r1.save();
        r1.translate(r5, ((r8 - this.b.getBounds().bottom) + r6) / 2);
        this.b.draw(r1);
        r1.restore();
        return;
    }
}
