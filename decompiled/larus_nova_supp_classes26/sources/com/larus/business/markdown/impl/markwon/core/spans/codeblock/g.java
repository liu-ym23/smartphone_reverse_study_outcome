package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g extends ReplacementSpan {
    public final Context a;
    public final int b;
    public final int c;
    public final float d;
    public final int e;

    public g(Context r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        Resources r6 = r2.getResources();
        this.d = TypedValue.applyDimension(0, r4, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()));
        this.e = com.larus.business.markdown.impl.common.utils.d.a(7);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        if (r5 == null) goto L7;
        int r6 = r5.descent;
        int r7 = r5.ascent;
        float r8 = this.d;
        int r9 = r7 + ((r6 - r7) - ((int) r8));
        r5.ascent = r9;
        r5.top = r9;
        int r10 = r9 + ((int) (r8 + this.e));
        r5.descent = r10;
        r5.bottom = r10;
        return 0;
    L7:
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r7, CharSequence r8, int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        int r16 = r15.getColor();
        r15.setColor(this.c);
        r15.setStrokeWidth(this.d);
        boolean r17 = true;
        if (this.a.getResources().getConfiguration().getLayoutDirection() == 1) goto L6;
        r17 = false;
    L6:
        if (r17 == false) goto L8;
        float r18 = r7.getWidth();
        int r19 = this.b;
    L9:
        float r4 = r12;
        r7.drawLine(r18, r4, r19, r4, r15);
        r15.setColor(r16);
        return;
    L8:
        r18 = r11 - this.b;
        r19 = r7.getWidth();
        goto L9
    }
}
