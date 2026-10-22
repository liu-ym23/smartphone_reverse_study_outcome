package x90;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends ImageSpan implements e90.a {
    public int a;
    public int b;
    public String c;

    @Override // e90.a
    public final int a() {
        return 1;
    }

    @Override // e90.a
    public final /* synthetic */ boolean b() {
        return false;
    }

    @Override // e90.a
    public final String getDesc() {
        return this.c;
    }

    public a(Drawable r1) {
        super(r1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r6 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r7 = r1.getFontMetricsInt();
        int r8 = r7.bottom - r7.top;
        int r9 = (r6.bottom - r6.top) / 2;
        int r11 = r8 / 4;
        int r12 = r9 - r11;
        int r13 = -(r9 + r11);
        r5.ascent = r13;
        r5.top = r13;
        r5.bottom = r12;
        r5.descent = r12;
    L6:
        return (r6.right + this.a) + this.b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        float r11 = r5 + this.a;
        Drawable r12 = getDrawable();
        r1.save();
        Paint.FontMetricsInt r13 = r9.getFontMetricsInt();
        r1.translate(r11, (int) (((((r13.descent + r7) + (r7 + r13.ascent)) / 2) - (r12.getBounds().bottom / 2)) + 0.5f));
        r12.draw(r1);
        r1.restore();
    }
}
