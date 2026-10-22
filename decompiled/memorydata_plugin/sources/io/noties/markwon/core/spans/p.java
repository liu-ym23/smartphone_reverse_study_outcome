package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class p extends o {
    public String g;
    private ListMarginInfo h;
    private int i;

    public p(io.noties.markwon.core.c r1, ListMarginInfo r2, String r3, int r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
        this.i = 0;
        this.g = r3;
        this.h = r2;
    }

    public void a(int r1) {
        this.i = r1;
    }

    @Override // io.noties.markwon.core.spans.o, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L5;
        return;
    L5:
        if (io.noties.markwon.g.d.a(r9, r13, this) == false) goto L31;
        this.c.set(r2);
        m[] r14 = (m[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r9, Math.min(r9 + 1, r10), m.class), m[].class, "com.obric.memorydata.plugin");
        if (r14.length <= 0) goto L10;
        this.c.setAlpha((int) (this.c.getAlpha() * (r14[0].a() / 255.0f)));
    L10:
        int r15 = this.i;
        if (r15 == 0) goto L13;
        io.noties.markwon.core.c r16 = io.noties.markwon.core.c.a(this.f16478a).g(r15).a();
    L14:
        r16.a(this.c, true);
        if (this.f == true) goto L17;
        return;
    L17:
        int r17 = (int) (this.c.measureText(this.f16479b) + 0.5f);
        ListMarginInfo r18 = this.h;
        if (r18 == null) goto L20;
        int r19 = r18.getListMargin();
    L21:
        if (r17 <= r19) goto L23;
        this.d = r17;
        r19 = r17;
    L24:
        int r20 = r19 + this.e;
        if (r4 <= 0) goto L27;
        int r21 = (r3 + (r20 * r4)) - r17;
    L28:
        r1.drawText(this.f16479b, r21, r6, this.c);
        return;
    L27:
        r21 = (r3 + (r4 * r20)) + (r20 - r17);
        goto L28
    L23:
        this.d = 0;
        goto L24
    L20:
        r19 = this.f16478a.a();
        goto L21
    L13:
        r16 = this.f16478a;
        goto L14
    }
}
