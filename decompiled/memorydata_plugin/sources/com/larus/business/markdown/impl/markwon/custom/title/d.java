package com.larus.business.markdown.impl.markwon.custom.title;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002Jh\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/TableTitleSpan;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/custom/TypingFreeSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "cornerRadius", "", "titleBgColor", "", "tableTitleStartIndex", "borderColor", "(Lio/noties/markwon/core/MarkwonTheme;FILjava/lang/Integer;I)V", "borderPaint", "Landroid/graphics/Paint;", "paint", "rect", "Landroid/graphics/Rect;", "Ljava/lang/Integer;", "apply", "", "p", "Landroid/text/TextPaint;", "drawLeadingMargin", "c", "Landroid/graphics/Canvas;", "x", "dir", "top", "baseline", "bottom", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "updateDrawState", "tp", "updateMeasureState", "textPaint", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f5236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5237b;
    private final int c;
    private final Integer d;
    private final int e;
    private final Rect f;
    private final Paint g;
    private final Paint h;

    public d(io.noties.markwon.core.c r2, float r3, int r4, Integer r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        this.f5236a = r2;
        this.f5237b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new Rect();
        this.g = new Paint(1);
        this.h = new Paint(1);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r4, Paint r5, int r6, int r7, int r8, int r9, int r10, CharSequence r11, int r12, int r13, boolean r14, Layout r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "c");
        Intrinsics.checkNotNullParameter(r5, "p");
        Intrinsics.checkNotNullParameter(r16, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r15, "layout");
        if (r12 != r13) goto L5;
        return;
    L5:
        this.g.setStyle(Paint.Style.FILL);
        int r17 = r15.getWidth();
        if (r7 <= 0) goto L8;
        r6 = r17;
        int r18 = r6;
    L9:
        int r19 = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(0.5d), Number.class, "com.obric.memorydata.plugin"));
        Integer r20 = this.d;
        if (r20 != null) goto L13;
        return;
    L13:
        if (r12 != r20.intValue()) goto L16;
        Path r21 = new Path();
        float r22 = r6 - r18;
        int r110 = r10 - r8;
        float r111 = this.f5237b;
        float r23 = r18;
        r21.moveTo(r23 + r111, r8);
        float r24 = r22 - (2 * r111);
        r21.rLineTo(r24, 0.0f);
        r21.rQuadTo(r111, 0.0f, r111, r111);
        float r112 = r110 - r111;
        r21.rLineTo(0.0f, r112);
        r21.rLineTo(-r22, 0.0f);
        float r25 = -r112;
        r21.rLineTo(0.0f, r25);
        float r113 = -r111;
        r21.rQuadTo(0.0f, r113, r111, r113);
        r21.close();
        this.g.setColor(this.c);
        r4.drawPath(r21, this.g);
        Path r26 = new Path();
        this.h.setColor(this.e);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(r19);
        r26.moveTo(r23, r10);
        r26.rLineTo(0.0f, r25);
        r26.rQuadTo(0.0f, r113, r111, r113);
        r26.rLineTo(r24, 0.0f);
        r26.rQuadTo(r111, 0.0f, r111, r111);
        r26.rLineTo(0.0f, r112);
        r4.drawPath(r26, this.h);
        return;
    L16:
        return;
    L8:
        r18 = r6 - r17;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return this.f5236a.c();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r1) {
        Intrinsics.checkNotNullParameter(r1, "textPaint");
    }
}
