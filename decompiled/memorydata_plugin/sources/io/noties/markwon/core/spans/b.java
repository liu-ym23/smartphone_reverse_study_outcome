package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f16457b;
    private final Paint c;
    private final Path d;
    private final int e;
    private final int f;

    public b(io.noties.markwon.core.c r2, int r3, int r4) {
        this.f16457b = n.a();
        this.c = n.c();
        this.d = new Path();
        this.f16456a = r2;
        this.e = r3;
        this.f = r4;
    }

    private void a(Canvas r6, float r7, float r8, float r9, float r10, float r11, Path r12) {
        RectF r0 = n.b();
        r12.reset();
        r12.moveTo(r7, r8 + r11);
        float r1 = 2.0f * r11;
        float r3 = r8 + r1;
        r0.set(r7, r8, r7 + r1, r3);
        r12.arcTo(r0, 180.0f, 90.0f);
        r12.lineTo(r9 - r11, r8);
        r0.set(r9 - r1, r8, r9, r3);
        r12.arcTo(r0, 270.0f, 90.0f);
        r12.lineTo(r9, r10);
        r12.lineTo(r7, r10);
        r12.close();
        r6.drawPath(r12, this.c);
    }

    private void b(Canvas r4, float r5, float r6, float r7, float r8, float r9, Path r10) {
        RectF r0 = n.b();
        r10.reset();
        r10.moveTo(r5, r6);
        r10.lineTo(r7, r6);
        r10.lineTo(r7, r8 - r9);
        float r11 = 2.0f * r9;
        float r2 = r8 - r11;
        r0.set(r7 - r11, r2, r7, r8);
        r10.arcTo(r0, 0.0f, 90.0f);
        r10.lineTo(r9 + r5, r8);
        r0.set(r5, r2, r11 + r5, r8);
        r10.arcTo(r0, 90.0f, 90.0f);
        r10.close();
        r4.drawPath(r10, this.c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r11, Paint r12, int r13, int r14, int r15, int r16, int r17, CharSequence r18, int r19, int r20, boolean r21, Layout r22) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.memorydata.plugin");
        int r6 = this.f16456a.b();
        this.c.set(r12);
        this.f16456a.b(this.c);
        int r7 = r6 * r14;
        int r8 = r13 + r7;
        int r9 = r7 + r8;
        int r10 = Math.min(r8, r9);
        int r23 = Math.max(r8, r9);
        if (this.e > 0) goto L5;
    L12:
        this.f16457b.set(r10, r15, r23, r17);
        r11.drawRect(this.f16457b, this.c);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Spanned.class) == false) goto L12;
        if (((Spanned) ZeusTransformUtils.preCheckCast(r4, Spanned.class, "com.obric.memorydata.plugin")).getSpanStart(this) != r19) goto L10;
        a(r11, r10, r15, r23, r17, this.e, this.d);
        return;
    L10:
        if (((Spanned) ZeusTransformUtils.preCheckCast(r4, Spanned.class, "com.obric.memorydata.plugin")).getSpanEnd(this) != r20) goto L12;
        b(r11, r10, r15, r23, r17, this.e, this.d);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        int r2 = this.f;
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        return this.f16456a.a();
    }
}
