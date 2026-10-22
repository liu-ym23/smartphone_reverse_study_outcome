package r19;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends ImageSpan {
    public Drawable a;
    public int b;

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Drawable r1 = super.getDrawable();
        this.a = r1;
        return r1;
    }

    public b(int r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r2);
        this.b = 255;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        Drawable r6 = getDrawable();
        if (r6 == null) goto L7;
        Rect r7 = r6.getBounds();
        if (r7 == null) goto L7;
        int r8 = r7.right;
    L9:
        return r8 + i5.e0();
    L7:
        r8 = 0;
        goto L9
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        if (r10 != null) goto L5;
        return;
    L5:
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = ((((r11.descent + r7) + r7) + r11.ascent) / 2) - (r10.getBounds().bottom / 2);
        r1.save();
        r1.translate(r5 + i5.e0(), r12);
        r10.setAlpha(this.b);
        r10.draw(r1);
        r1.restore();
    }
}
