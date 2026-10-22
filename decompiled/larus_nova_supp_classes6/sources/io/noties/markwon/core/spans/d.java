package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import ftc.c;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d implements LeadingMarginSpan {
    public static final boolean i = false;
    public final s a;
    public final Paint b;
    public final RectF c;
    public final Rect d;
    public final int e;
    public final boolean f;
    public final int g;
    public final ListMarginInfo h;

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (24 != r0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        i = r1;
        return;
    L5:
        if (25 == r0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r2) {
        ListMarginInfo r3 = this.h;
        if (r3 == null) goto L5;
        int r4 = r3.getListMargin();
    L7:
        return this.e + r4;
    L5:
        r4 = this.a.c;
        goto L7
    }

    public d(s r2, int r3, int r4, boolean r5) {
        this.b = p.c;
        this.c = p.b;
        this.d = p.a;
        this.e = 0;
        this.f = true;
        this.h = null;
        this.a = r2;
        this.h = null;
        this.g = r3;
        this.e = r4;
        this.f = r5;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (c.a(r9, r8, this) == false) goto L56;
        this.b.set(r2);
        o[] r13 = (o[]) ((Spanned) r8).getSpans(r9, Math.min(r9 + 1, r10), o.class);
        if (r13.length <= 0) goto L12;
        this.b.setAlpha((int) (this.b.getAlpha() * (r13[0].getAlpha() / 255.0f)));
    L12:
        this.a.b(this.b, false);
        int r14 = r1.save();
        ListMarginInfo r15 = this.h;     // Catch: Throwable -> L51
        if (r15 == null) goto L16;
        int r16 = r15.getListMargin();     // Catch: Throwable -> L51
    L17:
        int r17 = (int) ((this.b.descent() - this.b.ascent()) + 0.5f);     // Catch: Throwable -> L51
        ListMarginInfo r18 = this.h;     // Catch: Throwable -> L51
        if (r18 == null) goto L20;
        int r19 = r18.getDotDiameter();     // Catch: Throwable -> L51
    L25:
        int r20 = ((r16 - r19) / 2) + this.e;     // Catch: Throwable -> L51
        ListMarginInfo r110 = this.h;     // Catch: Throwable -> L51
        if (r110 == null) goto L29;
        r20 = r20 + r110.getBulletDotOffset();     // Catch: Throwable -> L51
    L29:
        if (i == false) goto L34;
        if (r4 >= 0) goto L32;
        int r21 = r3 - (r12.getWidth() - (r16 * this.g));     // Catch: Throwable -> L51
    L33:
        int r22 = r3 + (r20 * r4);     // Catch: Throwable -> L51
        int r23 = (r4 * r19) + r22;     // Catch: Throwable -> L51
        int r24 = r4 * r21;     // Catch: Throwable -> L51
        int r111 = Math.min(r22, r23) + r24;     // Catch: Throwable -> L51
        int r25 = Math.max(r22, r23) + r24;     // Catch: Throwable -> L51
    L38:
        int r26 = (r6 + ((int) (((this.b.descent() + this.b.ascent()) / 2.0f) + 0.5f))) - (r19 / 2);     // Catch: Throwable -> L51
        int r27 = r19 + r26;     // Catch: Throwable -> L51
        int r28 = this.g;     // Catch: Throwable -> L51
        if (r28 != 0) goto L41;
    L44:
        this.c.set(r111, r26, r25, r27);     // Catch: Throwable -> L51
        if (this.g != 0) goto L47;
        Paint.Style r29 = Paint.Style.FILL;     // Catch: Throwable -> L51
    L48:
        this.b.setStyle(r29);     // Catch: Throwable -> L51
        r1.drawOval(this.c, this.b);     // Catch: Throwable -> L51
    L49:
        r1.restoreToCount(r14);
        return;
    L47:
        r29 = Paint.Style.STROKE;     // Catch: Throwable -> L51
        goto L48
    L41:
        if (r28 == 1) goto L44;
        this.d.set(r111, r26, r25, r27);     // Catch: Throwable -> L51
        this.b.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L51
        r1.drawRect(this.d, this.b);     // Catch: Throwable -> L51
        goto L49
    L32:
        r21 = (r16 * this.g) - r3;     // Catch: Throwable -> L51
        goto L33
    L34:
        if (r4 > 0) goto L37;
        r3 = r3 - r16;     // Catch: Throwable -> L51
    L37:
        r111 = r3 + r20;     // Catch: Throwable -> L51
        r25 = r111 + r19;     // Catch: Throwable -> L51
        goto L38
    L20:
        s r30 = this.a;     // Catch: Throwable -> L51
        r19 = Math.min(r30.c, r17) / 2;     // Catch: Throwable -> L51
        int r31 = r30.l;     // Catch: Throwable -> L51
        if (r31 == 0) goto L25;
        if (r31 > r19) goto L25;
        r19 = r31;
        goto L25
    L16:
        r16 = this.a.c;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r1.restoreToCount(r14);
        throw th;
    }
}
