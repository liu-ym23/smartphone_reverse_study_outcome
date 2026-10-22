package com.obric.aiproactive.impl.livecard;

import android.app.PendingIntent;
import android.content.Context;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.livecard.api.entity.ISceneEntity;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.SuggestionSceneEntity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$syncToLockScreen$1", f = "ProactiveLiveCardManager.kt", i = {0}, l = {1478}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ProactiveLiveCardManager$syncToLockScreen$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $candidateSetKey;
    final /* synthetic */ List<ProactiveRecommendationDto> $dismissRecommendations;
    final /* synthetic */ Map<String, d> $displayTextByRecommendId;
    final /* synthetic */ List<ProactiveRecommendationDto> $recommendations;
    final /* synthetic */ Long $topRowId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    ProactiveLiveCardManager$syncToLockScreen$1(List<ProactiveRecommendationDto> r3, List<ProactiveRecommendationDto> r4, String r5, Long r6, Map<String, d> r7, Continuation<? super ProactiveLiveCardManager$syncToLockScreen$1> r8) {
        List<ProactiveRecommendationDto> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map<String, d> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendations = r9;
        this.$dismissRecommendations = r10;
        this.$candidateSetKey = r5;
        this.$topRowId = r6;
        this.$displayTextByRecommendId = r11;
        super(2, r12);
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$10(ProactiveRecommendationDto r8) {
        r.f6485a.a(r8, "ignore");
        kotlinx.coroutines.i.a(n.e(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$1$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$11(ProactiveRecommendationDto r9, boolean r10, Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        r r0 = r.f6485a;
        if (r10 == false) goto L5;
        String r2 = "execute_now";
    L6:
        r0.a(r9, r2);
        kotlinx.coroutines.i.a(n.e(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1(r9, r10, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    L5:
        r2 = "get";
        goto L6
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$12(ProactiveRecommendationDto r9, Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        r.f6485a.a(r9, MemoryListActivity.JUMP_FROM_DETAIL);
        kotlinx.coroutines.i.a(n.e(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$3$1(r9, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$13(ProactiveRecommendationDto r6) {
        kotlinx.coroutines.i.a(n.e(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$4$1(r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$14(ProactiveRecommendationDto r1) {
        r.f6485a.a(r1);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$17$lambda$16$lambda$15(ProactiveRecommendationDto r6, Integer r7) {
        kotlinx.coroutines.i.a(n.e(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$6$1(r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$EP42SdGVLDo9YSCpR4ofpBenIRk(ProactiveRecommendationDto r0, Integer r1) {
        return invokeSuspend$lambda$17$lambda$16$lambda$15(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Qb1CODeJ-c1qvfjdMVEcGqHjGPo, reason: not valid java name */
    public static /* synthetic */ Unit m230lambda$Qb1CODeJc1qvfjdMVEcGqHjGPo(ProactiveRecommendationDto r0) {
        return invokeSuspend$lambda$17$lambda$16$lambda$10(r0);
    }

    public static /* synthetic */ Unit lambda$VbgBnZxObmpsAF8_LGEKOm_mzR8(ProactiveRecommendationDto r0, boolean r1, Context r2) {
        return invokeSuspend$lambda$17$lambda$16$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$W_Klhy3h2qV0UhKvwHBL7KCMkN0(ProactiveRecommendationDto r0, Context r1) {
        return invokeSuspend$lambda$17$lambda$16$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$YtQEAK9kFFPK9LRNoRZPFZIYHCs(ProactiveRecommendationDto r0) {
        return invokeSuspend$lambda$17$lambda$16$lambda$13(r0);
    }

    public static /* synthetic */ Unit lambda$tl_U4mJIVvKyFhjAOdnTZEFWZos(ProactiveRecommendationDto r0) {
        return invokeSuspend$lambda$17$lambda$16$lambda$14(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1(this.$recommendations, this.$dismissRecommendations, this.$candidateSetKey, this.$topRowId, this.$displayTextByRecommendId, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$syncToLockScreen$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$syncToLockScreen$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r41) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L8;
        if (r4 != 1) goto L7;
        Map<String, d> r5 = (Map) ZeusTransformUtils.preCheckCast(this.L$5, Map.class, "com.obric.memorydata.plugin");
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(this.L$4, Long.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r9 = (List) ZeusTransformUtils.preCheckCast(this.L$2, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r10 = (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r41);
    L269:
        final Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L246 Exception -> L248
        int r15 = ProactiveLiveCardDisplayTool.INSTANCE.getLiveCardVersion(r11);     // Catch: Throwable -> L246 Exception -> L248
        boolean r19 = m.a(r15);     // Catch: Throwable -> L246 Exception -> L248
        List<ProactiveRecommendationDto> r12 = o.a(r10, r15);     // Catch: Throwable -> L246 Exception -> L248
        n.a(n.f6478a, r9);     // Catch: Throwable -> L246 Exception -> L248
        if (r8 != null) goto L15;
    L17:
        r8 = null;
    L18:
        String r13 = n.a(n.f6478a);     // Catch: Throwable -> L246 Exception -> L248
        Long r14 = n.b(n.f6478a);     // Catch: Throwable -> L246 Exception -> L248
        if (o.b(r8, r13) == false) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip lock-screen replay for consumed candidate set key=" + r8, false, 4, null);     // Catch: Throwable -> L244 Exception -> L248
    L22:
        List<ProactiveRecommendationDto> r7 = CollectionsKt.emptyList();     // Catch: Throwable -> L244 Exception -> L248
    L27:
        n r16 = n.f6478a;     // Catch: Throwable -> L244 Exception -> L248
        if (r8 != null) goto L30;
    L32:
        String r17 = null;
    L33:
        n.a(r17);     // Catch: Throwable -> L244 Exception -> L248
        n r18 = n.f6478a;     // Catch: Throwable -> L244 Exception -> L248
        if (r6 == null) goto L38;
        ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L244 Exception -> L248
        boolean r20 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L39;
        Long r110 = r6;
    L40:
        n.a(r110);     // Catch: Throwable -> L244 Exception -> L248
        n r111 = n.f6478a;     // Catch: Throwable -> L244 Exception -> L248
        kotlinx.coroutines.sync.a r21 = r1;
        ProactiveRecommendationDto r2 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (r2 == null) goto L45;
        String r22 = r2.getRecommendId();     // Catch: Throwable -> L239 Exception -> L242
    L46:
        n.b(r22);     // Catch: Throwable -> L239 Exception -> L242
        IRunLog r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        StringBuilder r24 = new StringBuilder().append("Start syncToLockScreen, requestedSize=").append(r10.size()).append(" compatibleSize=").append(r12.size()).append(" effectiveSize=").append(r7.size()).append(" liveCardVersion=").append(r15).append(" supportsMultiButton=");     // Catch: Throwable -> L239 Exception -> L242
        if (r19 == false) goto L49;
        boolean r112 = r20;
    L50:
        IRunLog.a.a(r23, "ProactiveLiveCardManager", r24.append(r112).append(" candidateSetKey=").append(r8).append(" consumedCandidateSetKey=").append(r13).append(" topRowId=").append(r6).append(" consumedTopRowId=").append(r14).toString(), false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        RunLog r25 = RunLog.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
        StringBuilder r26 = new StringBuilder().append("Recommendations: ");     // Catch: Throwable -> L239 Exception -> L242
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L239 Exception -> L242
    L52:
        if (r29.hasNext() == false) goto L54;
        r28.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r29.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());     // Catch: Throwable -> L239 Exception -> L242
        goto L52
    L54:
        r25.debug("ProactiveLiveCardManager", r26.append((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin")).toString());     // Catch: Throwable -> L239 Exception -> L242
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        Iterator r32 = r30.iterator();     // Catch: Throwable -> L239 Exception -> L242
    L56:
        if (r32.hasNext() == false) goto L58;
        r31.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r32.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());     // Catch: Throwable -> L239 Exception -> L242
        goto L56
    L58:
        Set r33 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r31, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L239 Exception -> L242
        Iterator r34 = n.b().entrySet().iterator();     // Catch: Throwable -> L239 Exception -> L242
    L59:
        int r35 = 2;
        if (r34.hasNext() == false) goto L86;
        Map.Entry r36 = (Map.Entry) ZeusTransformUtils.preCheckCast(r34.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        String r37 = (String) ZeusTransformUtils.preCheckCast(r36.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L239 Exception -> L242
    L63:
        if (r113.hasNext() == false) goto L67;
        Object r114 = r113.next();     // Catch: Throwable -> L239 Exception -> L242
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r114, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId(), r37) == false) goto L63;
    L68:
        ProactiveRecommendationDto r115 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r114, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (r115 != null) goto L71;
    L73:
        boolean r116 = false;
    L75:
        if (n.c().contains(r37) == false) goto L76;
        if (r115 != null) goto L59;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Destroying processed session because it fell out of active list: " + r37, false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        l.f6475a.a(r37);     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession((IslandSession) ZeusTransformUtils.preCheckCast(r36.getValue(), IslandSession.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L239 Exception -> L242
        r34.remove();     // Catch: Throwable -> L239 Exception -> L242
        n.c().remove(r37);     // Catch: Throwable -> L239 Exception -> L242
        goto L59
    L76:
        if (r116 == true) goto L77;
        if (r115 != null) goto L59;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Destroying session for recommendId: " + r37, false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        l.f6475a.a(r37);     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession((IslandSession) ZeusTransformUtils.preCheckCast(r36.getValue(), IslandSession.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L239 Exception -> L242
        r34.remove();     // Catch: Throwable -> L239 Exception -> L242
        goto L59
    L77:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Recommendation " + r37 + " became ADOPTED from sync, marking as processed.", false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        n r38 = n.f6478a;     // Catch: Throwable -> L239 Exception -> L242
        if (r115 == null) goto L80;
        String r39 = r115.getInspirationFeedbackAction();     // Catch: Throwable -> L239 Exception -> L242
    L81:
        r38.a(r37, r39);     // Catch: Throwable -> L239 Exception -> L242
        goto L59
    L80:
        r39 = null;
        goto L81
    L71:
        if (r115.getRecommendStatus() != 2) goto L73;
        r116 = r20;
        goto L75
    L67:
        r114 = null;
        goto L68
    L86:
        Iterator r40 = n.c().iterator();     // Catch: Throwable -> L239 Exception -> L242
    L88:
        if (r40.hasNext() == false) goto L94;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r40.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (n.b().containsKey(r42) == true) goto L88;
        if (r33.contains(r42) == true) goto L88;
        r40.remove();     // Catch: Throwable -> L239 Exception -> L242
        goto L88
    L94:
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(o.b(r7, r15), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L239 Exception -> L242
    L95:
        if (r43.hasNext() == false) goto L252;
        final ProactiveRecommendationDto r44 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r43.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (n.c().contains(r44.getRecommendId()) == false) goto L100;
    L99:
        Iterator r117 = r43;
        r5 = r5;
        int r118 = r15;
    L238:
        r15 = r118;
        r43 = r117;
        r5 = r5;
        r35 = 2;
        goto L95
    L100:
        IslandSession r45 = (IslandSession) ZeusTransformUtils.preCheckCast(n.b().get(r44.getRecommendId()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        CharSequence r46 = (CharSequence) ZeusTransformUtils.preCheckCast(r44.getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        CharSequence r119 = "这是一条AI建议";
        if (StringsKt.isBlank(r46) == false) goto L104;
        r46 = "这是一条AI建议";
    L104:
        CharSequence r47 = (CharSequence) ZeusTransformUtils.preCheckCast(b.f6457a.a((String) ZeusTransformUtils.preCheckCast(r46, String.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (StringsKt.isBlank(r47) == true) goto L108;
        r119 = r47;
    L108:
        String r48 = (String) ZeusTransformUtils.preCheckCast(r119, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        d r49 = (d) ZeusTransformUtils.preCheckCast(r5.get(r44.getRecommendId()), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        b r120 = b.f6457a;     // Catch: Throwable -> L239 Exception -> L242
        if (r49 == null) goto L112;
        String r121 = r49.a();     // Catch: Throwable -> L239 Exception -> L242
        if (r121 == null) goto L112;
    L113:
        CharSequence r122 = (CharSequence) ZeusTransformUtils.preCheckCast(r120.a(r121), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        CharSequence r123 = "AI 建议";
        if (StringsKt.isBlank(r122) == false) goto L117;
        r122 = "AI 建议";
    L117:
        String r124 = (String) ZeusTransformUtils.preCheckCast(r122, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        b r125 = b.f6457a;     // Catch: Throwable -> L239 Exception -> L242
        if (r49 == null) goto L123;
        String r126 = r49.b();     // Catch: Throwable -> L239 Exception -> L242
        if (r126 == null) goto L123;
        String r127 = r126;
    L124:
        CharSequence r128 = (CharSequence) ZeusTransformUtils.preCheckCast(r125.a(r127), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        if (StringsKt.isBlank(r128) == true) goto L128;
        r123 = r128;
    L128:
        String r210 = (String) ZeusTransformUtils.preCheckCast(r123, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool r129 = ProactiveLiveCardDisplayTool.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
        if (r49 == null) goto L131;
        boolean r130 = r20;
    L132:
        String r211 = r129.resolveExpandedContent$ai_proactive_impl_obricRelease(r48, r124, r130);     // Catch: Throwable -> L239 Exception -> L242
        RunLog r50 = RunLog.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
        StringBuilder r131 = new StringBuilder().append("Processing recommendation: id=").append(r44.getRecommendId()).append(", titlePresent=");     // Catch: Throwable -> L239 Exception -> L242
        if (r49 == null) goto L135;
        boolean r51 = r20;
    L136:
        r50.debug("ProactiveLiveCardManager", r131.append(r51).append(" titleLength=").append(r124.length()).append(" maskedTitleLength=").append(r210.length()).append(" contentLength=").append(r211.length()).toString());     // Catch: Throwable -> L239 Exception -> L242
        if (r44.getRecommendStatus() == r35) goto L99;
        if (r45 != null) goto L174;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Syncing new recommendation to lock screen: " + r44.getRecommendId(), false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        boolean r52 = m.a(r44.getActionExecuteInstruction());     // Catch: Throwable -> L239 Exception -> L242
        if (r19 == false) goto L143;
        List<h> r53 = o.a(o.a(r44));     // Catch: Throwable -> L239 Exception -> L242
    L144:
        List<h> r132 = r53;
        IRunLog r212 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
        StringBuilder r54 = new StringBuilder().append("Resolved LiveCard capability recommendId=").append(r44.getRecommendId()).append(" version=").append(r15).append(" required=8 supportsMultiButton=");     // Catch: Throwable -> L239 Exception -> L242
        if (r19 == false) goto L147;
        boolean r55 = r20;
    L148:
        IRunLog.a.a(r212, "ProactiveLiveCardManager", r54.append(r55).append(" actionCount=").append(r132.size()).toString(), false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        String r56 = r11.getPackageName();     // Catch: Throwable -> L239 Exception -> L242
        Intrinsics.checkNotNullExpressionValue(r56, "getPackageName(...)");     // Catch: Throwable -> L239 Exception -> L242
        PendingIntent r310 = PendingIntent.getActivity(r11, r44.getRecommendId().hashCode(), o.a(o.a(r56, r44.getInspirationId())), 201326592);     // Catch: Throwable -> L239 Exception -> L242
        i r57 = new i();     // Catch: Throwable -> L239 Exception -> L242
        String r213 = r44.getRecommendId();     // Catch: Throwable -> L239 Exception -> L242
        if (r52 == false) goto L151;
        String r58 = "立即执行";
    L152:
        String r214 = r58;
        n r133 = n.f6478a;     // Catch: Throwable -> L239 Exception -> L242
        if (r52 == false) goto L155;
        boolean r134 = r20;
    L156:
        r118 = r15;
        List r311 = n.a(r133, r11, r44, r211, r132, r134, r57);     // Catch: Throwable -> L239 Exception -> L242
        Function0 r135 = new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$Qb1CODeJc1qvfjdMVEcGqHjGPo(r44);     // Catch: Throwable -> L172 Exception -> L242
        if (r52 == false) goto L160;
        final boolean r136 = r20;
    L161:
        Function0 r137 = new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$VbgBnZxObmpsAF8_LGEKOm_mzR8(r44, r136, r11);     // Catch: Throwable -> L172 Exception -> L242
        if (r52 == false) goto L164;
        boolean r312 = r20;
    L165:
        r117 = r43;
        IslandSession r59 = ProactiveLiveCardDisplayTool.INSTANCE.buildSession(r11, new ProactiveLiveCardDisplayTool.CardConfig(r213, r124, r210, r211, r135, r137, r214, r312, new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$W_Klhy3h2qV0UhKvwHBL7KCMkN0(r44, r11), r310, new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$YtQEAK9kFFPK9LRNoRZPFZIYHCs(r44), new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$tl_U4mJIVvKyFhjAOdnTZEFWZos(r44), new $$Lambda$ProactiveLiveCardManager$syncToLockScreen$1$EP42SdGVLDo9YSCpR4ofpBenIRk(r44), r311));     // Catch: Throwable -> L239 Exception -> L242
        r57.a(r59);     // Catch: Throwable -> L239 Exception -> L242
        if (ProactiveLiveCardDisplayTool.INSTANCE.showSession(r11, r59) == true) goto L171;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip tracking lock-screen session because createSession failed for recommendId=" + r44.getRecommendId(), null, 4, null);     // Catch: Throwable -> L239 Exception -> L242
    L170:
        r5 = r5;
        goto L238
    L171:
        n.b().put(r44.getRecommendId(), r59);     // Catch: Throwable -> L239 Exception -> L242
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Successfully requested session for: " + r44.getRecommendId(), false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        goto L170
    L164:
        r312 = false;
        goto L165
    L160:
        r136 = false;
    L172:
        th = move-exception;
        Throwable r60 = th;
    L241:
        r1 = r21;
    L258:
        Object r61 = null;
    L259:
        r1.b(r61);
        throw r60;
    L155:
        r134 = false;
        goto L156
    L151:
        r58 = "知道了";
        goto L152
    L147:
        r55 = false;
        goto L148
    L143:
        r53 = CollectionsKt.emptyList();     // Catch: Throwable -> L239 Exception -> L242
        goto L144
    L174:
        r117 = r43;
        r118 = r15;
        ISceneEntity r62 = r45.getSceneEntity();     // Catch: Throwable -> L239 Exception -> L242
        if (ZeusTransformUtils.instanceOf(r62, SuggestionSceneEntity.class) == false) goto L177;
        SuggestionSceneEntity r63 = (SuggestionSceneEntity) ZeusTransformUtils.preCheckCast(r62, SuggestionSceneEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
    L178:
        IslandWidget r64 = r45.getExpandWidget();     // Catch: Throwable -> L239 Exception -> L242
        if (r64 == null) goto L181;
        Object r65 = r64.getTemplateData();     // Catch: Throwable -> L239 Exception -> L242
    L183:
        if (ZeusTransformUtils.instanceOf(r65, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class) == false) goto L185;
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r66 = (ProactiveLiveCardDisplayTool.AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r65, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
    L186:
        IslandWidget r67 = r45.getNotificationWidget();     // Catch: Throwable -> L239 Exception -> L242
        if (r67 == null) goto L189;
        Object r68 = r67.getTemplateData();     // Catch: Throwable -> L239 Exception -> L242
    L191:
        if (ZeusTransformUtils.instanceOf(r68, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class) == false) goto L193;
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r69 = (ProactiveLiveCardDisplayTool.AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r68, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L239 Exception -> L242
    L194:
        ProactiveLiveCardDisplayTool.CardConfig r138 = new ProactiveLiveCardDisplayTool.CardConfig(r44.getRecommendId(), r124, r210, r211, null, null, null, false, null, null, null, null, null, null, 16368, null);     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool.d r70 = ProactiveLiveCardDisplayTool.INSTANCE.resolveHostColors$ai_proactive_impl_obricRelease();     // Catch: Throwable -> L239 Exception -> L242
        String r139 = ProactiveLiveCardDisplayTool.INSTANCE.resolveSceneContent$ai_proactive_impl_obricRelease(r138);     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool r140 = ProactiveLiveCardDisplayTool.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
        if (r66 == null) goto L200;
        ProactiveLiveCardDisplayTool.AiNotifyIcon r141 = r66.getLeftIcon();     // Catch: Throwable -> L239 Exception -> L242
        if (r141 == null) goto L200;
        String r142 = r141.getIcon();     // Catch: Throwable -> L239 Exception -> L242
    L202:
        if (r142 != null) goto L204;
        r142 = "";
    L204:
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r143 = ProactiveLiveCardDisplayTool.preserveCompatibleButtonLists$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool.INSTANCE, r140.buildExpandedIslandTemplateData$ai_proactive_impl_obricRelease(r138, r142, r70), r66, null, r70, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        ProactiveLiveCardDisplayTool r144 = ProactiveLiveCardDisplayTool.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
        if (r69 == null) goto L210;
        ProactiveLiveCardDisplayTool.AiNotifyIcon r145 = r69.getLeftIcon();     // Catch: Throwable -> L239 Exception -> L242
        if (r145 == null) goto L210;
        String r146 = r145.getIcon();     // Catch: Throwable -> L239 Exception -> L242
        if (r146 == null) goto L210;
    L217:
        String r71 = r146;
    L218:
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r72 = ProactiveLiveCardDisplayTool.INSTANCE.preserveCompatibleButtonLists$ai_proactive_impl_obricRelease(r144.buildAiNotifyTemplateData$ai_proactive_impl_obricRelease(r138, r71, r70), r69, r66, r70);     // Catch: Throwable -> L239 Exception -> L242
        if (r63 == null) goto L221;
        String r73 = r63.getContent();     // Catch: Throwable -> L239 Exception -> L242
    L223:
        if (Intrinsics.areEqual(r73, r139) == true) goto L225;
    L228:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Refreshing recommendation on lock screen: " + r44.getRecommendId(), false, 4, null);     // Catch: Throwable -> L239 Exception -> L242
        if (r63 == null) goto L231;
        r63.setContent(r139);     // Catch: Throwable -> L239 Exception -> L242
        Unit r74 = Unit.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
    L231:
        IslandWidget r75 = r45.getExpandWidget();     // Catch: Throwable -> L239 Exception -> L242
        if (r75 == null) goto L234;
        r75.setTemplateData(r143);     // Catch: Throwable -> L239 Exception -> L242
        Unit r76 = Unit.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
    L234:
        IslandWidget r77 = r45.getNotificationWidget();     // Catch: Throwable -> L239 Exception -> L242
        if (r77 == null) goto L237;
        r77.setTemplateData(r72);     // Catch: Throwable -> L239 Exception -> L242
        Unit r78 = Unit.INSTANCE;     // Catch: Throwable -> L239 Exception -> L242
    L237:
        ProactiveLiveCardDisplayTool.INSTANCE.refreshSession(r45);     // Catch: Throwable -> L239 Exception -> L242
        goto L238
    L225:
        if (Intrinsics.areEqual(r66, r143) == false) goto L228;
        if (Intrinsics.areEqual(r69, r72) == true) goto L238;
    L221:
        r73 = null;
    L210:
        if (r66 == null) goto L214;
        ProactiveLiveCardDisplayTool.AiNotifyIcon r147 = r66.getLeftIcon();     // Catch: Throwable -> L239 Exception -> L242
        if (r147 == null) goto L214;
        r146 = r147.getIcon();     // Catch: Throwable -> L239 Exception -> L242
    L215:
        if (r146 != null) goto L217;
        r71 = "";
    L214:
        r146 = null;
    L200:
        r142 = null;
        goto L202
    L193:
        r69 = null;
        goto L194
    L189:
        r68 = null;
        goto L191
    L185:
        r66 = null;
        goto L186
    L181:
        r65 = null;
        goto L183
    L177:
        r63 = null;
        goto L178
    L135:
        r51 = false;
        goto L136
    L131:
        r130 = false;
    L123:
        r127 = "AI 建议";
    L112:
        r121 = r48;
    L252:
        Unit r79 = Unit.INSTANCE;     // Catch: Throwable -> L255
        r21.b(null);
        return Unit.INSTANCE;
    L255:
        Throwable th = th;
        r1 = r21;
    L257:
        r60 = th;
        goto L258
    L49:
        r112 = false;
        goto L50
    L45:
        r22 = null;
    L239:
        th = move-exception;
        r60 = th;
    L242:
        e = e;
    L250:
        Exception r80 = e;
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Error syncing to lock screen: " + r80.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(r80, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L255
        goto L252
    L39:
        r110 = null;
        goto L40
    L38:
        r20 = true;
        goto L39
    L30:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r17 = r8;
        goto L33
    L24:
        if (o.a(r8, r13, r6, r14) == false) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip lock-screen replay for consumed topRowId=" + r6 + " consumedTopRowId=" + r14, false, 4, null);     // Catch: Throwable -> L244 Exception -> L248
        goto L22
    L26:
        r7 = r12;
    L244:
        th = th;
        goto L257
    L15:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
    L248:
        e = e;
        r21 = r1;
    L246:
        th = move-exception;
        r60 = th;
        r61 = null;
        goto L259
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r41);
        kotlinx.coroutines.sync.a r81 = n.a();
        r10 = this.$recommendations;
        r9 = this.$dismissRecommendations;
        r8 = this.$candidateSetKey;
        Long r148 = this.$topRowId;
        Map<String, d> r149 = this.$displayTextByRecommendId;
        Continuation<? super Unit> r150 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r81;
        this.L$1 = r10;
        this.L$2 = r9;
        this.L$3 = r8;
        this.L$4 = r148;
        this.L$5 = r149;
        this.label = 1;
        if (r81.a(null, r150) != r3) goto L11;
        return r3;
    L11:
        r1 = r81;
        r6 = r148;
        r5 = r149;
        goto L269
    }
}
