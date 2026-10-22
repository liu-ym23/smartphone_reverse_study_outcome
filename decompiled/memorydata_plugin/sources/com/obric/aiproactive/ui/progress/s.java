package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0004H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0004H\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"buildLegacyV3MobileUseSessionIndex", "Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseSessionIndex;", "stages", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "legacyV3MobileUseStageKind", "Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseStageKind;", "toUiStep", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseSession;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "safeLegacyV3MobileUseTitle", "", "toLegacyMobileItemUiState", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class s {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6846a = null;

        static {
            int[] r0 = new int[LegacyV3MobileUseStageKind.values().length];
            r0[LegacyV3MobileUseStageKind.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LegacyV3MobileUseStageKind.ACTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LegacyV3MobileUseStageKind.DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6846a = r0;
        }
    }

    private static final AgentRunUiState a(String r1) {
        switch(r1.hashCode()) {
            case -2146525273: goto L32;
            case -1281977283: goto L28;
            case -896145315: goto L26;
            case -682587753: goto L24;
            case 40661574: goto L21;
            case 476588369: goto L17;
            case 945734241: goto L13;
            case 1116313165: goto L10;
            case 1550783935: goto L6;
            default: goto L36;
        };
    L26:
        r1.equals("outcome_unknown");
        goto L36
    L6:
        if (r1.equals("running") == false) goto L36;
        return AgentRunUiState.RUNNING;
    L10:
        if (r1.equals("waiting") == false) goto L36;
    L41:
        return AgentRunUiState.PENDING;
    L13:
        if (r1.equals("succeeded") == false) goto L36;
        return AgentRunUiState.COMPLETED;
    L17:
        if (r1.equals("cancelled") == false) goto L36;
        return AgentRunUiState.CANCELLED;
    L21:
        if (r1.equals("timed_out") == false) goto L36;
    L40:
        return AgentRunUiState.FAILED;
    L24:
        if (r1.equals("pending") == true) goto L41;
    L28:
        if (r1.equals("failed") == true) goto L40;
    L32:
        if (r1.equals("accepted") == true) goto L41;
    L36:
        return AgentRunUiState.UNKNOWN;
    }

    private static final LegacyV3MobileUseStageKind a(com.obric.aiproactive.api.i r4) {
        if (r4.j() == 3) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r4.m(), "action") == true) goto L7;
        return null;
    L7:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.k(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L33;
        String r5 = r4.f();
        int r0 = r5.hashCode();
        if (r0 == (-467898918)) goto L25;
        if (r0 == 409612768) goto L21;
        if (r0 == 1896311536) goto L17;
        return null;
    L17:
        if (r5.equals("mobile_use__destroy") == true) goto L31;
        return null;
    L31:
        return LegacyV3MobileUseStageKind.DESTROY;
    L21:
        if (r5.equals("mobile_use__do_action") == true) goto L32;
        return null;
    L32:
        return LegacyV3MobileUseStageKind.ACTION;
    L25:
        if (r5.equals("mobile_use__init") == true) goto L28;
        return null;
    L28:
        return LegacyV3MobileUseStageKind.INIT;
    L33:
        return null;
    }

    public static final n a(q r38, com.obric.aiproactive.api.g r39) {
        Intrinsics.checkNotNullParameter(r38, "<this>");
        Intrinsics.checkNotNullParameter(r39, "run");
        int r5 = 0;
        if (r38.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (SetsKt.setOf(new String[]{"running", "waiting"}).contains(r39.c()) == true) goto L11;
    L10:
        String r3 = r39.c();
    L17:
        com.obric.aiproactive.api.i r6 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r38.a()), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L23;
        String r7 = r6.k();
        if (r7 == null) goto L23;
        if (r0 == false) goto L23;
        String r1 = r7;
    L24:
        String r36 = "stage-" + r38.c().k();
        String r2 = r39.a();
        String r37 = r38.c().k();
        String r9 = o.a(com.obric.aiproactive.api.i.a(r38.c(), null, null, null, r3, null, null, 0, 0, 0, 0, null, 0, null, null, null, false, null, null, null, null, null, null, null, null, null, 33554423, null));
        AgentRunUiState r11 = a(r3);
        String r17 = r38.c().k();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r38.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r4.iterator();
    L26:
        if (r10.hasNext() == false) goto L38;
        Object r12 = r10.next();
        int r13 = r5 + 1;
        if (r5 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        com.obric.aiproactive.api.i r14 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r12, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        boolean r23 = Intrinsics.areEqual(r14.k(), r1);
        String r19 = r14.k();
        String r21 = b(r14);
        AgentRunUiState r22 = a(r14.d());
        if (r23 == false) goto L33;
        String r15 = "open_mobile_use_player";
    L34:
        if (r15 != null) goto L36;
        r15 = "";
    L36:
        r8.add(new com.obric.aiproactive.ui.progress.a(r19, r13, r21, r22, r23, r15, null, 64, null));
        r5 = r13;
        goto L26
    L33:
        r15 = null;
        goto L34
    L38:
        return new n(r36, r9, "", r11, null, null, false, r2, r37, r17, (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), AgentRunSecondaryListStyle.ORDERED, 112, null);
    L23:
        r1 = null;
        goto L24
    L11:
        if (r0 == true) goto L10;
        if (a((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r38.a()), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")) != LegacyV3MobileUseStageKind.DESTROY) goto L16;
        r3 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r38.a()), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).d();
        goto L17
    L16:
        r3 = "failed";
        goto L17
    L5:
        if (SetsKt.setOf(new String[]{"running", "waiting"}).contains(r39.c()) == false) goto L7;
        r0 = true;
        goto L9
    }

    public static final r a(List<com.obric.aiproactive.api.i> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "stages");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        List r3 = null;
    L5:
        if (r12.hasNext() == false) goto L26;
        com.obric.aiproactive.api.i r4 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        LegacyV3MobileUseStageKind r6 = a(r4);
        if (r6 != null) goto L9;
        int r7 = -1;
    L10:
        if (r7 == (-1)) goto L5;
        if (r7 != 1) goto L14;
        if (r3 == null) goto L25;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(new q(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), false));
    L25:
        r3 = CollectionsKt.mutableListOf(new com.obric.aiproactive.api.i[]{r4});
        goto L5
    L14:
        if (r7 != 2) goto L16;
        if (r3 == null) goto L5;
        r3.add(r4);
        goto L5
    L16:
        if (r7 != 3) goto L20;
        if (r3 == null) goto L5;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).add(r4);
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(new q(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), false));
        goto L3
    L20:
        throw new NoWhenBranchMatchedException();
    L9:
        r7 = a.f6846a[r6.ordinal()];
        goto L10
    L26:
        if (r3 == null) goto L28;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(new q(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), true));
    L28:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L30:
        if (r14.hasNext() == false) goto L32;
        Object r8 = r14.next();
        r5.put(((q) ZeusTransformUtils.preCheckCast(r8, q.class, "com.obric.memorydata.plugin")).c().k(), r8);
        goto L30
    L32:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L34:
        if (r16.hasNext() == false) goto L41;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(((q) ZeusTransformUtils.preCheckCast(r16.next(), q.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r9.iterator();
    L37:
        if (r18.hasNext() == false) goto L39;
        r17.add(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).k());
        goto L37
    L39:
        CollectionsKt.addAll(r1, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L34
    L41:
        return new r(r5, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }

    private static final String b(com.obric.aiproactive.api.i r3) {
        String r0 = m.b(r3.s());
        if (r0 != null) goto L28;
        LegacyV3MobileUseStageKind r1 = a(r3);
        if (r1 != null) goto L7;
        int r2 = -1;
    L8:
        if (r2 != (-1)) goto L10;
        return "手机操作";
    L10:
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L19;
        if (r2 != 3) goto L17;
        return "已结束手机操作";
    L17:
        throw new NoWhenBranchMatchedException();
    L19:
        if (Intrinsics.areEqual(r3.d(), "running") == false) goto L21;
        return "正在操作手机界面";
    L21:
        return "已完成手机界面操作";
    L23:
        if (Intrinsics.areEqual(r3.d(), "running") == false) goto L25;
        return "正在准备手机操作环境";
    L25:
        return "已准备手机操作环境";
    L7:
        r2 = a.f6846a[r1.ordinal()];
        goto L8
    L28:
        return r0;
    }
}
