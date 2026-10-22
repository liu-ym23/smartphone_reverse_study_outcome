package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f16458a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private io.noties.markwon.core.c f16459b;
    private final Paint c;
    private final RectF d;
    private final Rect e;
    private int f;
    private boolean g;
    private final int h;
    private ListMarginInfo i;

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (24 != r0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        f16458a = r1;
        return;
    L5:
        if (25 == r0) goto L8;
        r1 = false;
        goto L9
    }

    public c(io.noties.markwon.core.c r2, ListMarginInfo r3, int r4, int r5, boolean r6) {
        this.c = n.c();
        this.d = n.b();
        this.e = n.a();
        this.f = 0;
        this.g = true;
        this.i = null;
        this.f16459b = r2;
        this.i = r3;
        this.h = r4;
        this.f = r5;
        this.g = r6;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.g == true) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (io.noties.markwon.g.d.a(r9, r13, this) == false) goto L52;
        this.c.set(r2);
        m[] r14 = (m[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r9, Math.min(r9 + 1, r10), m.class), m[].class, "com.obric.memorydata.plugin");
        if (r14.length <= 0) goto L12;
        this.c.setAlpha((int) (this.c.getAlpha() * (r14[0].a() / 255.0f)));
    L12:
        this.f16459b.a(this.c, false);
        int r15 = r1.save();
        ListMarginInfo r16 = this.i;     // Catch: Throwable -> L47
        if (r16 == null) goto L16;
        int r17 = r16.getListMargin();     // Catch: Throwable -> L47
    L17:
        int r18 = (int) ((this.c.descent() - this.c.ascent()) + 0.5f);     // Catch: Throwable -> L47
        ListMarginInfo r19 = this.i;     // Catch: Throwable -> L47
        if (r19 == null) goto L20;
        int r20 = r19.getDotDiameter();     // Catch: Throwable -> L47
    L21:
        int r21 = ((r17 - r20) / 2) + this.f;     // Catch: Throwable -> L47
        ListMarginInfo r110 = this.i;     // Catch: Throwable -> L47
        if (r110 == null) goto L25;
        r21 = r21 + r110.getBulletDotOffset();     // Catch: Throwable -> L47
    L25:
        if (f16458a == false) goto L30;
        if (r4 >= 0) goto L28;
        int r22 = r3 - (r12.getWidth() - (r17 * this.h));     // Catch: Throwable -> L47
    L29:
        int r23 = r3 + (r21 * r4);     // Catch: Throwable -> L47
        int r24 = (r4 * r20) + r23;     // Catch: Throwable -> L47
        int r25 = r4 * r22;     // Catch: Throwable -> L47
        int r111 = Math.min(r23, r24) + r25;     // Catch: Throwable -> L47
        int r26 = Math.max(r23, r24) + r25;     // Catch: Throwable -> L47
    L34:
        int r27 = (r6 + ((int) (((this.c.descent() + this.c.ascent()) / 2.0f) + 0.5f))) - (r20 / 2);     // Catch: Throwable -> L47
        int r28 = r20 + r27;     // Catch: Throwable -> L47
        int r29 = this.h;     // Catch: Throwable -> L47
        if (r29 != 0) goto L37;
    L40:
        this.d.set(r111, r27, r26, r28);     // Catch: Throwable -> L47
        if (this.h != 0) goto L43;
        Paint.Style r30 = Paint.Style.FILL;     // Catch: Throwable -> L47
    L44:
        this.c.setStyle(r30);     // Catch: Throwable -> L47
        r1.drawOval(this.d, this.c);     // Catch: Throwable -> L47
    L45:
        r1.restoreToCount(r15);
        return;
    L43:
        r30 = Paint.Style.STROKE;     // Catch: Throwable -> L47
        goto L44
    L37:
        if (r29 == 1) goto L40;
        this.e.set(r111, r27, r26, r28);     // Catch: Throwable -> L47
        this.c.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L47
        r1.drawRect(this.e, this.c);     // Catch: Throwable -> L47
        goto L45
    L28:
        r22 = (r17 * this.h) - r3;     // Catch: Throwable -> L47
        goto L29
    L30:
        if (r4 > 0) goto L33;
        r3 = r3 - r17;     // Catch: Throwable -> L47
    L33:
        r111 = r3 + r21;     // Catch: Throwable -> L47
        r26 = r111 + r20;     // Catch: Throwable -> L47
        goto L34
    L20:
        r20 = this.f16459b.a(r18);     // Catch: Throwable -> L47
        goto L21
    L16:
        r17 = this.f16459b.a();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r1.restoreToCount(r15);
        throw th;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        ListMarginInfo r2 = this.i;
        if (r2 == null) goto L5;
        int r3 = r2.getListMargin();
    L7:
        return this.f + r3;
    L5:
        r3 = this.f16459b.a();
        goto L7
    }
}
