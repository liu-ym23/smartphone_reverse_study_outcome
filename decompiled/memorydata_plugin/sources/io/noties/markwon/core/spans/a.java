package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJp\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006&"}, d2 = {"Lio/noties/markwon/core/spans/BgOrderedListItemSpan;", "Lio/noties/markwon/core/spans/OrderedListItemSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "orderNumber", "", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;IILjava/lang/Float;Ljava/lang/Integer;)V", "bgPaint", "Landroid/graphics/Paint;", "Ljava/lang/Float;", "Ljava/lang/Integer;", "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", "p", "x", "dir", "top", "baseline", "bottom", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "getNumberHeight", "number", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends o {
    private final int g;
    private final int h;
    private final Float i;
    private final Integer j;
    private final Paint k;

    public a(io.noties.markwon.core.c r2, String r3, int r4, int r5, Float r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        Intrinsics.checkNotNullParameter(r3, "orderNumber");
        super(r2, r3);
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = new Paint(1);
    }

    private final float a(String r3, Paint r4) {
        Rect r2 = new Rect();
        if (r4 == null) goto L6;
        r4.getTextBounds(r3, 0, r3.length(), r2);
    L6:
        return r2.height();
    }

    @Override // io.noties.markwon.core.spans.o, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L5;
        return;
    L5:
        if (io.noties.markwon.g.d.a(r9, r13, this) == false) goto L26;
        this.c.set(r2);
        this.f16478a.a(this.c, true);
        String r14 = this.f16479b;
        Intrinsics.checkNotNullExpressionValue(r14, "number");
        String r15 = r14.substring(0, this.f16479b.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r15, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int r16 = (int) (this.c.measureText(this.f16479b) + 0.5f);
        int r17 = (int) (this.c.measureText(r15) + 0.5f);
        float r18 = a(r15, r2) + 0.5f;
        if (r16 <= this.f16478a.a()) goto L10;
        this.d = r16;
    L11:
        this.k.setColor(this.g);
        this.k.setStyle(Paint.Style.FILL);
        float r19 = r6;
        int r20 = this.h;
        float r21 = 0.0f;
        RectF r22 = new RectF(0.0f, (r19 - r18) - r20, r17 + (r20 * 2), r20 + r19);
        if (r1 == null) goto L21;
        Float r23 = this.i;
        if (r23 == null) goto L16;
        float r24 = r23.floatValue();
    L17:
        Float r25 = this.i;
        if (r25 == null) goto L20;
        r21 = r25.floatValue();
    L20:
        r1.drawRoundRect(r22, r24, r21, this.k);
        goto L21
    L16:
        r24 = 0.0f;
    L21:
        if (r1 == null) goto L25;
        r1.drawText(this.f16479b, this.h, r19, this.c);
        return;
    L25:
        return;
    L10:
        this.d = 0;
        goto L11
    }

    @Override // io.noties.markwon.core.spans.o, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        Integer r2 = this.j;
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L7:
        return r3 + (this.h * 2);
    L5:
        r3 = 0;
        goto L7
    }
}
