package com.obric.aiproactive.impl.livecard;

import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\u001a4\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TAG", "", "SAFE_FALLBACK_TITLE", "buildAiProactiveLockScreenSyncPayload", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenSyncPayload;", "rows", "", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "syncAiProactiveLockScreenBatch", "", AILabCheckPermissionTask.KEY_SOURCE, "onSync", "Lkotlin/Function1;", "syncAiProactiveLockScreenPayload", "payload", "normalizedTitleOrFallback", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    public static final g a(List<com.obric.aiproactive.api.t> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "rows");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.impl.c.b(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L11;
        Object r5 = r3.next();
        if (((com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin")).l() == AiProactiveCardStatus.PENDING) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r2.add(r5);
        goto L3
    L11:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r8.add(com.obric.aiproactive.impl.c.a((com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin")));
        goto L13
    L15:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L17:
        if (r13.hasNext() == false) goto L20;
        com.obric.aiproactive.api.t r14 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        Pair r15 = TuplesKt.to(String.valueOf(r14.a()), new d(a(r14.d()), a(r14.e())));
        r12.put(r15.getFirst(), r15.getSecond());
        goto L17
    L20:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        List r16 = r6;
    L23:
        if (r16 == null) goto L25;
        String r17 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("ai_proactive:", CharSequence.class, "com.obric.memorydata.plugin"), null, 0, null, $$Lambda$f$E4vZnF27al8PpGrxjrSWCEhvKqk.INSTANCE, 28, null);
    L26:
        com.obric.aiproactive.api.t r18 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r6), com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L29;
        Long r110 = Long.valueOf(r18.a());
    L31:
        return new g(r10, r10, r12, r17, r110);
    L29:
        r110 = null;
        goto L31
    L25:
        r17 = null;
        goto L26
    L22:
        r16 = null;
        goto L23
    }

    private static final CharSequence a(com.obric.aiproactive.api.t r3) {
        Intrinsics.checkNotNullParameter(r3, "row");
        StringBuilder r0 = new StringBuilder();
        Long r1 = r3.q();
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L7:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(r2).append(':').append(r3.a()).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r2 = 0;
        goto L7
    }

    private static final String a(String r2) {
        if (r2 == null) goto L13;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 == null) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L13;
        return r3;
    L8:
        r0 = false;
    L13:
        return "AI 建议";
    }

    public static final /* synthetic */ void a(g r0) {
        b(r0);
    }

    public static final void a(List<com.obric.aiproactive.api.t> r8, String r9, Function1<? super g, Unit> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "rows");
        Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r12, "onSync");
        g r0 = a(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveLockScreenSync", "sync batch payload source=" + r9 + " rawSize=" + r11.size() + " topRowId=" + r0.e() + " size=" + r0.a().size() + " candidateSetKey=" + r0.d(), false, 4, null);
        r12.invoke(r0);
    }

    public static /* synthetic */ void a(List r1, String r2, Function1 r3, int r4, Object r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 4) == 0) goto L5;
        r7 = $$Lambda$f$AQCu5uFSnamJjhAXggO21woqT4.INSTANCE;
    L5:
        a(r6, r2, r7);
    }

    private static final void b(g r6) {
        n.f6478a.a(r6.a(), r6.b(), r6.c(), r6.d(), r6.e());
    }

    private static final Unit c(g r7) {
        Intrinsics.checkNotNullParameter(r7, "payload");
        n.f6478a.a(r7.a(), r7.b(), r7.c(), r7.d(), r7.e());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$AQCu5uFSnamJ-jhAXggO21woqT4, reason: not valid java name */
    public static /* synthetic */ Unit m234lambda$AQCu5uFSnamJjhAXggO21woqT4(g r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$E4vZnF27al8PpGrxjrSWCEhvKqk(com.obric.aiproactive.api.t r0) {
        return a(r0);
    }
}
