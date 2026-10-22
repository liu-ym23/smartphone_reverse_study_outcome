package xlb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends ImageSpan {
    public final int a;

    public a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super(r2);
        this.a = -1;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r3, "text");
        Rect r7 = getDrawable().getBounds();
        if (r6 == null) goto L6;
        Paint.FontMetricsInt r8 = r2.getFontMetricsInt();
        int r9 = r8.bottom - r8.top;
        int r10 = RangesKt.coerceAtLeast(r9, r7.bottom - r7.top);
        int r11 = r8.top + (r9 / 2);
        int r12 = r10 / 2;
        int r13 = r11 - r12;
        r6.ascent = r13;
        int r14 = r11 + r12;
        r6.descent = r14;
        r6.top = r13;
        r6.bottom = r14;
    L6:
        return r7.width();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        r1.save();
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = r11.descent;
        r1.translate(r5, (((r7 + r12) - ((r12 - r11.ascent) / 2)) - (r10.getBounds().height() / 2)) + this.a);
        r10.draw(r1);
        r1.restore();
    }
}
