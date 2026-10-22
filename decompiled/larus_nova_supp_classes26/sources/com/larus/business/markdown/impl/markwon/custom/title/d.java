package com.larus.business.markdown.impl.markwon.custom.title;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends MetricAffectingSpan implements LeadingMarginSpan {
    public final s a;
    public final float b;
    public final int c;
    public final Integer d;
    public final int e;
    public final Paint f;
    public final Paint g;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r1) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "textPaint");
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r1) {
        return this.a.q;
    }

    public d(s r2, float r3, int r4, Integer r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        new Rect();
        this.f = new Paint(1);
        this.g = new Paint(1);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r3, Paint r4, int r5, int r6, int r7, int r8, int r9, CharSequence r10, int r11, int r12, boolean r13, Layout r14) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "p");
        Intrinsics.checkNotNullParameter(r10, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r14, "layout");
        if (r11 != r12) goto L5;
        return;
    L5:
        this.f.setStyle(Paint.Style.FILL);
        int r15 = r14.getWidth();
        if (r6 <= 0) goto L8;
        r5 = r15;
        int r16 = r5;
    L9:
        int r17 = com.larus.business.markdown.impl.common.utils.d.a(Double.valueOf(0.5d));
        Integer r18 = this.d;
        if (r18 != null) goto L13;
        return;
    L13:
        if (r11 != r18.intValue()) goto L16;
        Path r19 = new Path();
        float r20 = r5 - r16;
        int r110 = r9 - r7;
        float r111 = this.b;
        float r21 = r16;
        r19.moveTo(r21 + r111, r7);
        float r22 = r20 - (2 * r111);
        r19.rLineTo(r22, 0.0f);
        r19.rQuadTo(r111, 0.0f, r111, r111);
        float r112 = r110 - r111;
        r19.rLineTo(0.0f, r112);
        r19.rLineTo(-r20, 0.0f);
        float r23 = -r112;
        r19.rLineTo(0.0f, r23);
        float r113 = -r111;
        r19.rQuadTo(0.0f, r113, r111, r113);
        r19.close();
        this.f.setColor(this.c);
        r3.drawPath(r19, this.f);
        Path r24 = new Path();
        this.g.setColor(this.e);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(r17);
        r24.moveTo(r21, r9);
        r24.rLineTo(0.0f, r23);
        r24.rQuadTo(0.0f, r113, r111, r113);
        r24.rLineTo(r22, 0.0f);
        r24.rQuadTo(r111, 0.0f, r111, r111);
        r24.rLineTo(0.0f, r112);
        r3.drawPath(r24, this.g);
        return;
    L16:
        return;
    L8:
        r16 = r5 - r15;
        goto L9
    }
}
