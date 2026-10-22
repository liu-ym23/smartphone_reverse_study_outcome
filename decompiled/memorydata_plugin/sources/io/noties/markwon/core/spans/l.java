package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002Jp\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/noties/markwon/core/spans/HeadingSpan2;", "Lio/noties/markwon/core/spans/HeadingSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "level", "", "diffDp", "headingColor", "(Lio/noties/markwon/core/MarkwonTheme;IILjava/lang/Integer;)V", "Ljava/lang/Integer;", "apply2", "", "paint", "Landroid/text/TextPaint;", "drawLeadingMargin", "c", "Landroid/graphics/Canvas;", "p", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "first", "", "layout", "Landroid/text/Layout;", "updateDrawState", "tp", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16475b;
    private final Integer c;

    public l(io.noties.markwon.core.c r2, int r3, int r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        super(r2, r3);
        this.f16474a = r3;
        this.f16475b = r4;
        this.c = r5;
    }

    private final void a(TextPaint r5) {
        switch(this.f16474a) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
    L9:
        if (r0 == null) goto L11;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        r5.setFakeBoldText(true);
        r5.setTextSize(r1 + com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(this.f16475b), Number.class, "com.obric.memorydata.plugin")));
    L11:
        Integer r4 = this.c;
        if (r4 == null) goto L15;
        r5.setColor(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L15:
        return;
    L5:
        int r2 = com.larus.business.markdown.impl.common.utils.c.g();
    L8:
        r0 = Integer.valueOf(r2);
        goto L9
    L6:
        r2 = com.larus.business.markdown.impl.common.utils.c.h();
        goto L8
    L7:
        r2 = com.larus.business.markdown.impl.common.utils.c.i();
        goto L8
    }

    @Override // io.noties.markwon.core.spans.k, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.core.spans.k, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "tp");
        a(r2);
    }

    @Override // io.noties.markwon.core.spans.k, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        a(r2);
    }
}
