package com.obric.memorydata.markdown.stream;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "applyLinkUnderlines", "", "Landroid/widget/TextView;", "style", "Lcom/obric/memorydata/markdown/stream/UnderlineStyle;", "setupLinkStyle", "markdown_lite_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class s {
    public static final void a(final TextView r1, final r r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "style");
        r1.post(new $$Lambda$s$zxLz8vuc1QqPcyZEU21hoDv5w6s(r1, r2));
    }

    public static final void b(TextView r1, r r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "style");
        defpackage.g.a(r1);
        a(r1, r2);
    }

    private static final void c(TextView r14, r r15) {
        if (r14.getLayout() == null) goto L59;
        CharSequence r0 = r14.getText();
        if (r0 == null) goto L8;
        String r1 = r0.toString();
        if (r1 == null) goto L8;
    L9:
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "===== 开始处理 - 原始文本：" + r1 + " =====");
        CharSequence r2 = r14.getText();
        if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == false) goto L12;
        Spanned r3 = (Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.memorydata.plugin");
    L13:
        if (r3 != null) goto L16;
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "文本不是 Spanned，直接返回");
        return;
    L16:
        SpannableStringBuilder r4 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Object[] r6 = r4.getSpans(0, r4.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(r6, "getSpans(...)");
        int r8 = r6.length;
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L19;
        URLSpan r10 = (URLSpan) ZeusTransformUtils.preCheckCast(r6[r9], URLSpan.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(Integer.valueOf(r4.getSpanStart(r10)), Integer.valueOf(r4.getSpanEnd(r10))));
        r9 = r9 + 1;
        goto L17
    L19:
        Object[] r7 = r4.getSpans(0, r4.length(), CustomLinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(r7, "getSpans(...)");
        int r11 = r7.length;
        int r12 = 0;
    L20:
        if (r12 >= r11) goto L22;
        CustomLinkSpan r13 = (CustomLinkSpan) ZeusTransformUtils.preCheckCast(r7[r12], CustomLinkSpan.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(Integer.valueOf(r4.getSpanStart(r13)), Integer.valueOf(r4.getSpanEnd(r13))));
        r12 = r12 + 1;
        goto L20
    L22:
        Object[] r16 = r4.getSpans(0, r4.length(), com.obric.memorydata.markdown.custom.b.class);
        Intrinsics.checkNotNullExpressionValue(r16, "getSpans(...)");
        int r17 = r16.length;
        int r18 = 0;
    L23:
        if (r18 >= r17) goto L25;
        com.obric.memorydata.markdown.custom.b r19 = (com.obric.memorydata.markdown.custom.b) ZeusTransformUtils.preCheckCast(r16[r18], com.obric.memorydata.markdown.custom.b.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(Integer.valueOf(r4.getSpanStart(r19)), Integer.valueOf(r4.getSpanEnd(r19))));
        r18 = r18 + 1;
        goto L23
    L25:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r20.hasNext() == false) goto L58;
        Pair r21 = (Pair) ZeusTransformUtils.preCheckCast(r20.next(), Pair.class, "com.obric.memorydata.plugin");
        int r22 = ((Number) ZeusTransformUtils.preCheckCast(r21.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r23 = ((Number) ZeusTransformUtils.preCheckCast(r21.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Object[] r24 = r4.getSpans(r22, r23, com.obric.memorydata.markdown.custom.l.class);
        Intrinsics.checkNotNullExpressionValue(r24, "getSpans(...)");
        com.obric.memorydata.markdown.custom.l r25 = (com.obric.memorydata.markdown.custom.l) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r24), com.obric.memorydata.markdown.custom.l.class, "com.obric.memorydata.plugin");
        Object[] r110 = r4.getSpans(r22, r23, g.class);
        Intrinsics.checkNotNullExpressionValue(r110, "getSpans(...)");
        int r111 = r110.length;
        int r112 = 0;
    L29:
        if (r112 >= r111) goto L31;
        r4.removeSpan(r110[r112]);
        r112 = r112 + 1;
        goto L29
    L31:
        Object[] r113 = r4.getSpans(r22, r23, i.class);
        Intrinsics.checkNotNullExpressionValue(r113, "getSpans(...)");
        int r114 = r113.length;
        int r115 = 0;
    L32:
        if (r115 >= r114) goto L34;
        r4.removeSpan(r113[r115]);
        r115 = r115 + 1;
        goto L32
    L34:
        if (r25 == null) goto L56;
        int r116 = r15.a();
        Integer r117 = Integer.valueOf(r25.a());
        boolean r118 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r117, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L38;
        boolean r119 = true;
    L39:
        if (r119 == true) goto L42;
        r117 = null;
    L42:
        if (r117 == null) goto L44;
        int r120 = r117.intValue();
    L45:
        Integer r26 = Integer.valueOf(r25.b());
        if (((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L49;
        r118 = false;
    L49:
        if (r118 == true) goto L52;
        r26 = null;
    L52:
        if (r26 == null) goto L54;
        int r27 = r26.intValue();
    L55:
        i r121 = new i(r14, r116, r120, r27);
    L57:
        r4.setSpan(new g(r15.a()), r22, r23, 33);
        r4.setSpan(r121, r22, r23, 33);
        goto L27
    L54:
        r27 = r15.c();
        goto L55
    L44:
        r120 = r15.b();
        goto L45
    L38:
        r119 = false;
        goto L39
    L56:
        r121 = new i(r14, r15.a(), r15.b(), r15.c());
        goto L57
    L58:
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "最终文本：" + ((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).subSequence(0, r4.length()).toString());
        r14.invalidate();
        return;
    L12:
        r3 = null;
    L8:
        r1 = "空文本";
        goto L9
    L59:
        RunLog.INSTANCE.debug("LinkUnderlineDebug", "layout 为空，跳过处理");
    }

    public static /* synthetic */ void lambda$zxLz8vuc1QqPcyZEU21hoDv5w6s(TextView r0, r r1) {
        c(r0, r1);
    }
}
