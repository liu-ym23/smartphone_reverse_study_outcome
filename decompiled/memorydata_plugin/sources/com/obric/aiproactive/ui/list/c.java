package com.obric.aiproactive.ui.list;

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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"buildHistoryRecommendationCardUiState", "Lcom/obric/aiproactive/ui/list/HistoryRecommendationCardUiState;", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "MAX_HISTORY_ACTIONS", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    public static final b a(com.obric.aiproactive.ui.model.j.f r18) {
        Intrinsics.checkNotNullParameter(r18, "item");
        String r0 = r18.b().getEmoji();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        n r2 = com.obric.aiproactive.api.c.b(r18.b().getActionCondition());
        if (r18.b().getRecommendStatus() == 2) goto L8;
    L10:
        boolean r4 = false;
    L11:
        Integer r5 = null;
        if (r2 == null) goto L14;
        String r3 = r2.a();
    L15:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.c.a(r3), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
        int r9 = 0;
    L17:
        if (r7.hasNext() == false) goto L27;
        Object r10 = r7.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        com.obric.aiproactive.api.b r12 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r10, com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        boolean r13 = !r12.h();
        if (r12.h() == false) goto L25;
        if (r4 == true) goto L25;
        boolean r14 = true;
    L26:
        r8.add(new a(r9, r12, r13, r14));
        r9 = r11;
    L25:
        r14 = false;
        goto L26
    L27:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L33;
        Object r19 = r17.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.memorydata.plugin")).e(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L29;
        r16.add(r19);
        goto L29
    L33:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        ListIterator r21 = r20.listIterator(r20.size());
    L35:
        if (r21.hasPrevious() == false) goto L39;
        Object r22 = r21.previous();
        if (((a) ZeusTransformUtils.preCheckCast(r22, a.class, "com.obric.memorydata.plugin")).c() == false) goto L35;
    L40:
        a r23 = (a) ZeusTransformUtils.preCheckCast(r22, a.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L43;
        List r24 = CollectionsKt.listOf(a.a(r23, 0, null, false, false, 7, null));
    L53:
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin");
        if (r25.isEmpty() == false) goto L65;
        String r26 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18.f(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L58;
        String r110 = r26;
    L59:
        if (r110 == null) goto L61;
        List r27 = CollectionsKt.listOf(new a(0, new com.obric.aiproactive.api.b(r110, r110, r4 ? 1 : 0, null, null, false, false, 120, null), r4, !r4));
    L62:
        if (r27 != null) goto L64;
        r27 = CollectionsKt.emptyList();
    L64:
        r25 = r27;
        goto L65
    L61:
        r27 = null;
        goto L62
    L58:
        r110 = null;
    L65:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L69;
        r5 = Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_badge_sparkle, "drawable", "ic_proactive_badge_sparkle"));
    L69:
        return new b(r1, r5, r28);
    L43:
        if (r4 == false) goto L52;
        a r29 = (a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r20), a.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L49;
        a r30 = a.a(r29, 0, null, true, false, 3, null);
        if (r30 == null) goto L49;
        r24 = CollectionsKt.listOf(r30);
    L50:
        if (r24 != null) goto L53;
        r24 = CollectionsKt.emptyList();
    L49:
        r24 = null;
        goto L50
    L52:
        r24 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin"), 3);
        goto L53
    L39:
        r22 = null;
        goto L40
    L14:
        r3 = null;
        goto L15
    L8:
        if (StringsKt.equals(r18.b().getInspirationFeedbackAction(), "auto_dismiss", true) == true) goto L10;
        r4 = true;
        goto L11
    }
}
