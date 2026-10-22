package com.larus.bmhome.chat.outerinput;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements LineBackgroundSpan {
    public final int a;
    public final float b;
    public final float c;
    public final Paint d;
    public float e;
    public float f;

    public a(int r1, int r2, float r3, float r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        Paint r5 = new Paint(1);
        this.d = r5;
        r5.setColor(r2);
        r5.setStrokeWidth(r3);
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r8, ChatDraftItem.TYPE_TEXT);
        boolean r12 = true;
        if (r9 > 0) goto L6;
        if (r10 < 0) goto L6;
        boolean r13 = true;
    L7:
        if (r13 == false) goto L9;
        float r14 = r2.measureText(r8, r9, 0);
    L10:
        this.e = r14;
        if (r9 > 0) goto L14;
        if (r10 < 0) goto L14;
    L15:
        if (r12 == false) goto L17;
        float r15 = r2.measureText(r8, 0, Math.min(this.a, r10));
    L18:
        this.f = r14 + r15;
        float r16 = RangesKt.coerceAtMost(r6 + this.c, r7 - this.b);
        r1.drawLine(this.e, r16, this.f, r16, this.d);
        return;
    L17:
        r15 = r2.measureText(r8, r9, Math.min(this.a, r10));
    L14:
        r12 = false;
        goto L15
    L9:
        r14 = 0.0f;
    L6:
        r13 = false;
        goto L7
    }
}
