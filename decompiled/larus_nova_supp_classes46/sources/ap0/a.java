package ap0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ImageSpan {
    public a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super(r2);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = ((((r11.descent + r7) + r7) + r11.ascent) / 2) - (r10.getBounds().bottom / 2);
        r1.save();
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
    }
}
