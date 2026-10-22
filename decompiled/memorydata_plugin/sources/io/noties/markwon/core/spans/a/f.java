package io.noties.markwon.core.spans.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJP\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J2\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/TitleMiddleSpacePaddingSpan;", "Landroid/text/style/ReplacementSpan;", "titleStr", "", "contentMaxWidth", "", "toDeleteSpaceList", "", "Lkotlin/Pair;", "horizontalExtraSpace", "verticalPadding", "(Ljava/lang/CharSequence;ILjava/util/List;II)V", "fixChCenter", "draw", "", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f16454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16455b;
    private final List<Pair<Integer, Integer>> c;
    private final int d;
    private final int e;
    private final int f;

    public f(CharSequence r3, int r4, List<Pair<Integer, Integer>> r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        List<Pair<Integer, Integer>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "titleStr");
        Intrinsics.checkNotNullParameter(r9, "toDeleteSpaceList");
        this.f16454a = r8;
        this.f16455b = r4;
        this.c = r9;
        this.d = r6;
        this.e = r7;
        this.f = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(2, Number.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r9, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r17, "paint");
        r9.drawText(r2, r11, r12, r13, r15, r17);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r7, CharSequence r8, int r9, int r10, Paint.FontMetricsInt r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "paint");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (r11 == null) goto L5;
        r11.ascent -= this.e + this.f;
        r11.top -= this.e + this.f;
        r11.descent += this.e - this.f;
        r11.bottom += this.e - this.f;
    L5:
        float r13 = this.d;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        r13 = r13 + r7.measureText(this.f16454a, ((Number) ZeusTransformUtils.preCheckCast(r2.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    L10:
        if (ZeusTransformUtils.instanceOf(r12, SpannableString.class) == false) goto L12;
        SpannableString r14 = (SpannableString) ZeusTransformUtils.preCheckCast(r12, SpannableString.class, "com.obric.memorydata.plugin");
    L13:
        if (r14 == null) goto L33;
        Object[] r15 = r14.getSpans(r9, r10, LeadingMarginSpan.class);
        Intrinsics.checkNotNullExpressionValue(r15, "sb.getSpans(start, end, …ngMarginSpan::class.java)");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r17 = r15.length;
        int r1 = 0;
    L15:
        if (r1 >= r17) goto L27;
        Object r3 = r15[r1];
        LeadingMarginSpan r4 = (LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r3, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, io.noties.markwon.core.spans.e.class) == false) goto L19;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L26;
        r16.add(r3);
    L26:
        r1 = r1 + 1;
        goto L15
    L19:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, com.larus.business.markdown.impl.markwon.custom.title.d.class) == true) goto L23;
        r5 = true;
        goto L24
    L27:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r19 = 0;
    L29:
        if (r18.hasNext() == false) goto L31;
        r19 = r19 + ((LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r18.next(), LeadingMarginSpan.class, "com.obric.memorydata.plugin")).getLeadingMargin(false);
        goto L29
    L31:
        r13 = r13 + r19;
    L33:
        return (int) RangesKt.coerceAtLeast(this.f16455b - r13, 0.0f);
    L12:
        r14 = null;
        goto L13
    }
}
