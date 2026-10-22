package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class o implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.noties.markwon.core.c f16478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f16479b;
    final Paint c;
    int d;
    final int e;
    boolean f;
    private ListMarginInfo g;

    public o(io.noties.markwon.core.c r2, ListMarginInfo r3, String r4, int r5, boolean r6) {
        this.c = n.c();
        this.f = true;
        this.g = null;
        this.f16478a = r2;
        this.g = r3;
        this.f16479b = r4;
        this.e = r5;
        this.f = r6;
    }

    public o(io.noties.markwon.core.c r2, String r3) {
        this.c = n.c();
        this.f = true;
        this.g = null;
        this.f16478a = r2;
        this.f16479b = r3;
        this.e = 0;
    }

    public static void a(TextView r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Spanned.class) == true) goto L5;
        return;
    L5:
        int r3 = 0;
        o[] r8 = (o[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r7, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r7.length(), o.class), o[].class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L10;
        TextPaint r9 = r5.getPaint();
        int r0 = r8.length;
    L8:
        if (r3 >= r0) goto L12;
        o r1 = r8[r3];
        r1.d = (int) (r9.measureText(r1.f16479b) + 0.5f);
        r3 = r3 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L5;
        return;
    L5:
        if (io.noties.markwon.g.d.a(r9, r13, this) == false) goto L27;
        this.c.set(r2);
        m[] r14 = (m[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r9, Math.min(r9 + 1, r10), m.class), m[].class, "com.obric.memorydata.plugin");
        if (r14.length <= 0) goto L10;
        this.c.setAlpha((int) (this.c.getAlpha() * (r14[0].a() / 255.0f)));
    L10:
        this.f16478a.a(this.c, true);
        if (this.f == true) goto L13;
        return;
    L13:
        int r15 = (int) (this.c.measureText(this.f16479b) + 0.5f);
        ListMarginInfo r16 = this.g;
        if (r16 == null) goto L16;
        int r17 = r16.getListMargin();
    L17:
        if (r15 <= r17) goto L19;
        this.d = r15;
        r17 = r15;
    L20:
        int r18 = r17 + this.e;
        if (r4 <= 0) goto L23;
        int r19 = (r3 + (r18 * r4)) - r15;
    L24:
        r1.drawText(this.f16479b, r19, r6, this.c);
        return;
    L23:
        r19 = (r3 + (r4 * r18)) + (r18 - r15);
        goto L24
    L19:
        this.d = 0;
        goto L20
    L16:
        r17 = this.f16478a.a();
        goto L17
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r2) {
        ListMarginInfo r3 = this.g;
        if (r3 == null) goto L5;
        int r4 = r3.getListMargin();
    L7:
        return Math.max(this.d, r4) + this.e;
    L5:
        r4 = this.f16478a.a();
        goto L7
    }
}
