package com.larus.business.markdown.api;

import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"getLeadingMargin", "", "Landroid/text/Spanned;", "index", "orDefault", "Landroid/graphics/Bitmap$Config;", "defaultConfig", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class c {
    public static final int a(Spanned r9, int r10) {
        Spanned r11 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r9, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Object[] r0 = r11.getSpans(0, r11.length(), LeadingMarginSpan.class);
        Intrinsics.checkNotNullExpressionValue(r0, "getSpans(0, length, LeadingMarginSpan::class.java)");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r0.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L13;
        Object r6 = r0[r5];
        LeadingMarginSpan r7 = (LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r6, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
        if (r11.getSpanStart(r7) <= r10) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        r2.add(r6);
    L12:
        r5 = r5 + 1;
        goto L3
    L7:
        if (r10 > r11.getSpanEnd(r7)) goto L9;
        r8 = true;
        goto L10
    L13:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r13 = 0;
    L15:
        if (r12.hasNext() == false) goto L17;
        r13 = r13 + ((LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r12.next(), LeadingMarginSpan.class, "com.obric.memorydata.plugin")).getLeadingMargin(false);
        goto L15
    L17:
        return r13;
    }
}
