package sw8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements LeadingMarginSpan {
    public final s a;
    public final int b;
    public final int c;
    public final Rect d;
    public final Paint e;
    public final Path f;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r1) {
        int r2 = this.c;
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        return this.a.c;
    }

    public a(s r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Rect();
        this.e = new Paint();
        this.f = new Path();
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        Intrinsics.checkNotNullParameter(r1, "c");
        s r13 = this.a;
        int r14 = r13.d;
        if (r14 != 0) goto L5;
        r14 = (int) ((r13.c * 0.25f) + 0.5f);
    L5:
        this.e.set(r2);
        s r15 = this.a;
        Paint r16 = this.e;
        int r17 = r15.e;
        if (r17 != 0) goto L8;
        r17 = ftc.a.a(r16.getColor(), 25);
    L8:
        r16.setStyle(Paint.Style.FILL);
        r16.setColor(r17);
        int r18 = (r4 * r14) + r3;
        int r19 = RangesKt.coerceAtMost(r3, r18);
        int r20 = RangesKt.coerceAtLeast(r3, r18);
        if (this.b > 0) goto L11;
    L19:
        this.d.set(r19, r5, r20, r7);
        r1.drawRect(this.d, this.e);
        return;
    L11:
        if ((r8 instanceof Spanned) == false) goto L19;
        Spanned r21 = (Spanned) r8;
        if (r21.getSpanStart(this) != r9) goto L16;
        float r22 = r19;
        float r23 = r5;
        float r24 = r20;
        float r25 = r7;
        float r26 = this.b;
        Path r27 = this.f;
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        r27.reset();
        r27.moveTo(r22, r25);
        r27.lineTo(r24, r25);
        float r28 = r23 + r26;
        r27.lineTo(r24, r28);
        r27.arcTo(new RectF(r24 - r26, r23, r24, r28), 0.0f, -90.0f, false);
        float r29 = r26 + r22;
        r27.lineTo(r29, r23);
        r27.arcTo(new RectF(r22, r23, r29, r28), 270.0f, -90.0f, false);
        r27.close();
        r1.drawPath(r27, this.e);
        return;
    L16:
        if (r21.getSpanEnd(this) != r10) goto L18;
        float r30 = r19;
        float r31 = r5;
        float r32 = r20;
        float r33 = r7;
        float r34 = this.b;
        Path r35 = this.f;
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        r35.reset();
        r35.moveTo(r30, r31);
        r35.lineTo(r32, r31);
        float r36 = r33 - r34;
        r35.lineTo(r32, r36);
        r35.arcTo(new RectF(r32 - r34, r36, r32, r33), 0.0f, 90.0f, false);
        float r37 = r34 + r30;
        r35.lineTo(r37, r33);
        r35.arcTo(new RectF(r30, r36, r37, r33), 90.0f, 90.0f, false);
        r35.close();
        r1.drawPath(r35, this.e);
        return;
    L18:
        this.d.set(r19, r5, r20, r7);
        r1.drawRect(this.d, this.e);
    }
}
