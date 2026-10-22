package com.obric.aiproactive.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiproactive.api.n;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"resolveNowActionTextColorRes", "", "adoptiveStyleEnabled", "", "buildNowRecommendationCardUiState", "Lcom/obric/aiproactive/ui/list/NowRecommendationCardUiState;", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "resolveSummaryActions", "", "Lcom/obric/aiproactive/ui/list/NowSummaryActionUiState;", "hasSelectedSummaryAction", "MAX_SUMMARY_ACTIONS", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final int a(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = R.color.ai_proactive_demo_text_disabled;
        String r1 = "ai_proactive_demo_text_disabled";
    L7:
        return ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_COLOR, r1);
    L5:
        r3 = R.color.ai_proactive_demo_text_primary;
        r1 = "ai_proactive_demo_text_primary";
        goto L7
    }

    public static final d a(com.obric.aiproactive.ui.model.j.f r19) {
        Intrinsics.checkNotNullParameter(r19, "item");
        String r0 = r19.b().getEmoji();
        String r2 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r1 = r19.e();
        if (r1 == null) goto L9;
        r2 = r1;
    L9:
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r19.b().getRecommendStatus() != 2) goto L12;
        boolean r3 = true;
    L13:
        boolean r4 = c(r19);
        if (r3 == true) goto L18;
        if (r4 == true) goto L18;
        boolean r16 = false;
    L19:
        List<f> r12 = b(r19);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        Integer r5 = Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_badge_sparkle, "drawable", "ic_proactive_badge_sparkle"));
    L24:
        return new d(r6, r5, r10, !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")), r10, false, r12, false, false, !r16, r16, null, false);
    L22:
        r5 = null;
    L18:
        r16 = true;
        goto L19
    L12:
        r3 = false;
        goto L13
    }

    private static final List<f> b(com.obric.aiproactive.ui.model.j.f r15) {
        n r0 = com.obric.aiproactive.api.c.b(r15.b().getActionCondition());
        if (r15.b().getRecommendStatus() != 2) goto L5;
        int r8 = 1;
    L6:
        List<f> r1 = null;
        if (r0 == null) goto L9;
        String r2 = r0.a();
    L10:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.c.a(r2), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
        int r6 = 0;
    L12:
        if (r5.hasNext() == false) goto L17;
        Object r7 = r5.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r4.add(new f(r6, (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")));
        r6 = r9;
        goto L12
    L17:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L19:
        if (r12.hasNext() == false) goto L29;
        Object r13 = r12.next();
        com.obric.aiproactive.api.b r14 = ((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.memorydata.plugin")).b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
    L26:
        boolean r16 = true;
    L27:
        if (r16 == false) goto L19;
        r11.add(r13);
        goto L19
    L23:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        r16 = false;
        goto L27
    L29:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        ListIterator r18 = r17.listIterator(r17.size());
    L31:
        if (r18.hasPrevious() == false) goto L35;
        Object r19 = r18.previous();
        if ((!((f) ZeusTransformUtils.preCheckCast(r19, f.class, "com.obric.memorydata.plugin")).b().h()) == false) goto L31;
    L36:
        f r20 = (f) ZeusTransformUtils.preCheckCast(r19, f.class, "com.obric.memorydata.plugin");
        if (r8 != 0) goto L47;
        if (r20 != null) goto L47;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L42:
        if (r23.hasNext() == false) goto L46;
        Object r24 = r23.next();
        if (((f) ZeusTransformUtils.preCheckCast(r24, f.class, "com.obric.memorydata.plugin")).b().h() == false) goto L42;
        r22.add(r24);
        goto L42
    L46:
        List<f> r25 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3);
    L53:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L55;
        return r25;
    L55:
        String r26 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15.f(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L59;
        return CollectionsKt.listOf(new f(0, new com.obric.aiproactive.api.b(r26, r26, r8, null, null, false, false, 120, null)));
    L59:
        return CollectionsKt.emptyList();
    L47:
        if (r20 == null) goto L49;
        r1 = CollectionsKt.listOf(r20);
    L49:
        if (r1 != null) goto L51;
        r25 = CollectionsKt.emptyList();
        goto L53
    L51:
        r25 = r1;
        goto L53
    L35:
        r19 = null;
        goto L36
    L9:
        r2 = null;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }

    private static final boolean c(com.obric.aiproactive.ui.model.j.f r5) {
        n r6 = com.obric.aiproactive.api.c.b(r5.b().getActionCondition());
        if (r6 == null) goto L5;
        String r7 = r6.a();
    L6:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.c.a(r7), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L9;
    L11:
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        if ((!((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).h()) == false) goto L13;
        return true;
    L16:
        return false;
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
    L5:
        r7 = null;
        goto L6
    }
}
