package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class ClearCacheDynamicDrawableSpan extends ReplacementSpan {
    public final int a;
    public WeakReference<Drawable> b;

    public @interface AlignmentType {
    }

    public abstract Drawable b();

    public final Drawable a() {
        WeakReference<Drawable> r0 = this.b;
        if (r0 == null) goto L5;
        Drawable r1 = r0.get();
    L6:
        if (r1 != null) goto L9;
        Drawable r2 = b();
        this.b = new WeakReference(r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public ClearCacheDynamicDrawableSpan(int r1) {
        this.a = r1;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r6 = a().getBounds();
        if (r5 == null) goto L6;
        int r7 = -r6.bottom;
        r5.ascent = r7;
        r5.descent = 0;
        r5.top = r7;
        r5.bottom = 0;
    L6:
        return r6.right;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r10 = a();
        r1.save();
        int r11 = r8 - r10.getBounds().bottom;
        int r12 = this.a;
        if (r12 != 1) goto L6;
        r11 = r11 - r9.getFontMetricsInt().descent;
    L8:
        r1.translate(r5, r11);
        r10.draw(r1);
        r1.restore();
        return;
    L6:
        if (r12 != 2) goto L8;
        r11 = (r6 + ((r8 - r6) / 2)) - (r10.getBounds().height() / 2);
        goto L8
    }
}
