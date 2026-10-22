package com.obric.aiproactive.ui.model;

import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"reduceAllPageState", "Lcom/obric/aiproactive/ui/model/AllPageStateTransition;", "currentState", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "snapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "todayDayKey", "", "todayItems", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "acceptedNewBatch", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    public static final e a(f r19, ProactiveAllPageSnapshot r20, String r21, List<ProactiveRecommendationDto> r22, boolean r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "currentState");
        Intrinsics.checkNotNullParameter(r20, "snapshot");
        Intrinsics.checkNotNullParameter(r21, "todayDayKey");
        Intrinsics.checkNotNullParameter(r1, "todayItems");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r20.getDayHeaders(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r6.add(((ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r4.next(), ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin")).getDayKey());
        goto L4
    L6:
        LinkedHashSet r5 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r6, LinkedHashSet.class, "com.obric.memorydata.plugin");
        boolean r16 = r19.f().contains(r21);
        Set r11 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r19.f(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
        Map r12 = MapsKt.toMutableMap(r19.g());
        r12.keySet().retainAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        if (r5.contains(r21) == false) goto L9;
        r12.put(r21, r1);
    L10:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r20.getDayHeaders(), Iterable.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L11:
        boolean r15 = true;
        if (r8.hasNext() == false) goto L35;
        ProactiveDayHeaderDto r9 = (ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r8.next(), ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin");
        c r10 = (c) ZeusTransformUtils.preCheckCast(r19.h().get(r9.getDayKey()), c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.getDayKey(), r21) == false) goto L16;
        int r14 = r1.size();
    L20:
        if (Intrinsics.areEqual(r9.getDayKey(), r21) == false) goto L22;
        boolean r17 = r20.getTodayHasNext();
    L28:
        String r18 = r9.getDayKey();
        if (r23 == false) goto L31;
    L30:
        r15 = false;
    L34:
        Pair r24 = TuplesKt.to(r18, new c(r15, r17, r14));
        r13.put(r24.getFirst(), r24.getSecond());
        goto L11
    L31:
        if (r10 == null) goto L30;
        if (r10.a() != true) goto L30;
    L22:
        if (r10 == null) goto L25;
        r17 = r10.b();
        goto L28
    L25:
        if (r9.getCount() <= 0) goto L27;
        r17 = true;
        goto L28
    L27:
        r17 = false;
        goto L28
    L16:
        if (r10 == null) goto L18;
        r14 = r10.c();
        goto L20
    L18:
        r14 = 0;
        goto L20
    L35:
        f r25 = f.a(r19, r20.getBatchId(), false, null, false, r20.getDayHeaders(), r11, r12, r13, 12, null);
        if (r23 == false) goto L41;
        if (r16 == false) goto L41;
        if (r5.contains(r21) == false) goto L41;
        boolean r110 = true;
    L43:
        return new e(r25, r110);
    L41:
        r110 = false;
        goto L43
    L9:
        r12.remove(r21);
        goto L10
    }
}
