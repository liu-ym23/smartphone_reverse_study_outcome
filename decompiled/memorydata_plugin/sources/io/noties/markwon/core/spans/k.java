package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class k extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f16473b;
    private final Paint c;
    private final int d;

    public k(io.noties.markwon.core.c r2, int r3) {
        this.f16473b = n.a();
        this.c = n.c();
        this.f16472a = r2;
        this.d = r3;
    }

    private void a(TextPaint r2) {
        this.f16472a.a(r2, this.d);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r2, Paint r3, int r4, int r5, int r6, int r7, int r8, CharSequence r9, int r10, int r11, boolean r12, Layout r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        int r15 = this.d;
        if (r15 == 1) goto L7;
        if (r15 == 2) goto L7;
        return;
    L7:
        if (io.noties.markwon.g.d.b(r11, r14, this) == false) goto L17;
        this.c.set(r3);
        this.f16472a.g(this.c);
        float r16 = this.c.getStrokeWidth();
        if (r16 <= 0.0f) goto L18;
        int r17 = (int) ((r8 - r16) + 0.5f);
        if (r5 <= 0) goto L13;
        int r18 = r2.getWidth();
    L14:
        this.f16473b.set(r4, r17, r18, r8);
        r2.drawRect(this.f16473b, this.c);
        return;
    L13:
        r18 = r4;
        r4 = r4 - r2.getWidth();
        goto L14
    L18:
        return;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        a(r1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r1) {
        a(r1);
    }
}
