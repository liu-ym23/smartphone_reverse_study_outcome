package com.ss.android.lark.keyboard.edittext2.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends ImageSpan {
    public final int a;
    public final int b;
    public WeakReference<Drawable> c;

    public d(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super(r2, 2);
        this.a = UIHelper.dp2px(3.0f);
        this.b = UIHelper.dp2px(3.0f);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        return (this.a + super.getSize(r2, r3, r4, r5, r6)) + this.b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        WeakReference<Drawable> r10 = this.c;
        if (r10 == null) goto L5;
        Drawable r11 = r10.get();
    L6:
        if (r11 != null) goto L8;
        r11 = getDrawable();
        this.c = new WeakReference(r11);
    L8:
        r1.save();
        if (r11 == null) goto L17;
        int r12 = r8 - r11.getBounds().bottom;
        int r13 = ((ImageSpan) this).mVerticalAlignment;
        if (r13 != 1) goto L14;
        r12 = r12 - r9.getFontMetricsInt().descent;
    L16:
        r1.translate(this.a + r5, r12);
        r11.draw(r1);
        goto L17
    L14:
        if (r13 != 2) goto L16;
        Paint.FontMetricsInt r14 = r9.getFontMetricsInt();
        r12 = (r7 + ((r14.descent + r14.ascent) / 2)) - (r11.getBounds().height() / 2);
    L17:
        r1.restore();
        return;
    L5:
        r11 = null;
        goto L6
    }
}
