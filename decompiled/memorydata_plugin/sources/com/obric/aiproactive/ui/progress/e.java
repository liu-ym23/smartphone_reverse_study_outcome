package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0004H\u0000¨\u0006\f"}, d2 = {"decideAgentRunAutomaticExpansion", "Lcom/obric/aiproactive/ui/progress/AgentRunExpansionDecision;", "steps", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "expandedStepIds", "", "", "previous", "Lcom/obric/aiproactive/ui/progress/AgentRunExpansionPolicyState;", "hasExpandableSecondaryContent", "", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final d a(List<n> r13, Set<String> r14, f r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Set r17 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "steps");
        Intrinsics.checkNotNullParameter(r17, "expandedStepIds");
        Intrinsics.checkNotNullParameter(r15, "previous");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((n) ZeusTransformUtils.preCheckCast(r1.next(), n.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin");
        Set r4 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r15.c(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Set r5 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r15.b(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Set r18 = SetsKt.minus(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Object r9 = r8.next();
        r7.put(((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin")).a(), r9);
        goto L8
    L10:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L11:
        Set r19 = null;
        AgentRunUiState r20 = null;
        r19 = null;
        r19 = null;
        boolean r21 = true;
        if (r12.hasNext() == false) goto L19;
        Object r22 = r12.next();
        String r110 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin");
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new AgentRunUiState[]{AgentRunUiState.COMPLETED, AgentRunUiState.CANCELLED}), Iterable.class, "com.obric.memorydata.plugin");
        n r24 = (n) ZeusTransformUtils.preCheckCast(r7.get(r110), n.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L17;
        r20 = r24.d();
    L17:
        if (CollectionsKt.contains(r23, r20) == false) goto L11;
        r11.add(r22);
        goto L11
    L19:
        Set r25 = (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin");
        Set r111 = SetsKt.minus(r18, (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"));
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed(r16), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r112.hasNext() == false) goto L34;
        Object r26 = r112.next();
        n r27 = (n) ZeusTransformUtils.preCheckCast(r26, n.class, "com.obric.memorydata.plugin");
        if (a(r27) == true) goto L25;
    L31:
        Object[] r28 = false;
    L32:
        if (r28 == false) goto L21;
    L35:
        n r113 = (n) ZeusTransformUtils.preCheckCast(r26, n.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L50;
        String r29 = r113.a();
        if (r29 == null) goto L50;
        if (r17.contains(r29) == true) goto L42;
    L45:
        if (r21 == true) goto L48;
        r29 = null;
    L48:
        if (r29 == null) goto L50;
        r19 = SetsKt.setOf(r29);
        goto L50
    L42:
        if (r25.contains(r29) == true) goto L45;
        r21 = false;
    L50:
        if (r19 != null) goto L52;
        r19 = SetsKt.emptySet();
    L52:
        if (r113 == null) goto L59;
        String r114 = r113.a();
        if (r114 == null) goto L59;
        Set r115 = SetsKt.plus(r5, r114);
        if (r115 == null) goto L59;
        r5 = r115;
    L59:
        if (r113 == null) goto L62;
        r111 = SetsKt.plus(r111, r113.a());
    L62:
        return new d(r19, SetsKt.minus(r25, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), new f(r111, r5, r4));
    L25:
        if (SetsKt.setOf(new AgentRunUiState[]{AgentRunUiState.RUNNING, AgentRunUiState.PENDING, AgentRunUiState.FAILED, AgentRunUiState.UNKNOWN}).contains(r27.d()) == false) goto L31;
        if (r4.contains(r27.a()) == true) goto L31;
        if (r5.contains(r27.a()) == true) goto L31;
        r28 = true;
        goto L32
    L34:
        r26 = null;
        goto L35
    }

    public static final boolean a(n r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5.k(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.f(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L25;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5.e(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L9;
    L11:
        Iterator r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L10;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((k) ZeusTransformUtils.preCheckCast(r7.next(), k.class, "com.obric.memorydata.plugin")).c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
        return true;
    L20:
        return false;
    L10:
        r8 = false;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
    L25:
        return true;
    }
}
