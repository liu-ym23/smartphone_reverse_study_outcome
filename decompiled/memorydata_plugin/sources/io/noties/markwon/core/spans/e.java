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
public class e extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f16464b;
    private final Paint c;

    public e(io.noties.markwon.core.c r2) {
        this.f16464b = n.a();
        this.c = n.c();
        this.f16463a = r2;
    }

    private void a(TextPaint r1) {
        this.f16463a.d(r1);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r2, Paint r3, int r4, int r5, int r6, int r7, int r8, CharSequence r9, int r10, int r11, boolean r12, Layout r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(this.f16463a.f(r3));
        int r15 = r2.getWidth();
        if (r5 > 0) goto L6;
        r4 = r4 - r15;
        r15 = r4;
    L6:
        this.f16464b.set(r4, r6, r15, r8);
        r2.drawRect(this.f16464b, this.c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return this.f16463a.c();
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
