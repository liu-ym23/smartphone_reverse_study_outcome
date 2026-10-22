package com.obric.aiproactive.ui.entry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u000e\u0010\u001e\u001a\u00020\u001bH\u0094@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u0019J$\u0010&\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00132\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170(H\u0014J\b\u0010)\u001a\u00020\u001bH\u0014J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowFeedViewModel;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "repository", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "timeProvider", "Lcom/obric/aiproactive/ui/model/TimeProvider;", "statsStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;", "<init>", "(Lcom/obric/aiproactive/ui/data/ProactiveRepository;Lcom/obric/aiproactive/ui/model/TimeProvider;Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;)V", "_nowUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/aiproactive/ui/model/FeedPageUiState;", "nowUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getNowUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "pinnedNowIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "nowRecommendations", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "showGuidedPreferenceEntry", "", "onBeforeRefresh", "", "onRecommendationAdoptedFromDetail", "inspirationId", "observeFeed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pinNowAdopted", "onRecommendationDismissedFromSync", "recommendId", "setShowGuidedPreferenceEntry", "show", "forceRebuild", "updateRecommendationInLocalState", "transform", "Lkotlin/Function1;", "rebuildPageItemsAfterLocalMutation", "handleNowRecommendations", "snapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "rebuildNowItems", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NowFeedViewModel extends BaseProactiveFeedViewModel {
    private final kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.g> _nowUiState;
    private List<ProactiveRecommendationDto> nowRecommendations;
    private final ar<com.obric.aiproactive.ui.model.g> nowUiState;
    private final LinkedHashSet<String> pinnedNowIds;
    private boolean showGuidedPreferenceEntry;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedViewModel$observeFeed$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "throwable", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedViewModel$observeFeed$2", f = "NowFeedViewModel.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super List<? extends ProactiveRecommendationDto>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ NowFeedViewModel this$0;

        AnonymousClass2(NowFeedViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(3, r5);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super List<? extends ProactiveRecommendationDto>> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.j<? super List<ProactiveRecommendationDto>> r3, Throwable r4, Continuation<? super Unit> r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r7);
            r0.L$0 = r6;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$1, Throwable.class, "com.obric.memorydata.plugin");
            this.this$0.handleObserverError(PageType.NOW, r2);
            List r3 = CollectionsKt.emptyList();
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 1;
            if (r8.emit(r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedViewModel$observeFeed$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "rows", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedViewModel$observeFeed$3", f = "NowFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<List<? extends ProactiveRecommendationDto>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NowFeedViewModel this$0;

        AnonymousClass3(NowFeedViewModel r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(List<? extends ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
            return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            List r6 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
            ProactiveNowPageSnapshot r0 = new ProactiveNowPageSnapshot(o.a(r6), false, r6);
            NowFeedViewModel.access$handleNowRecommendations(this.this$0, r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public NowFeedViewModel(com.obric.aiproactive.ui.data.b r10, com.obric.aiproactive.ui.model.m r11, com.obric.aiproactive.ui.feedback.g r12) {
        com.obric.aiproactive.ui.data.b r13 = (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.m r14 = (com.obric.aiproactive.ui.model.m) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiproactive.ui.model.m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "repository");
        Intrinsics.checkNotNullParameter(r14, "timeProvider");
        Intrinsics.checkNotNullParameter(r12, "statsStore");
        super(r13, r14, r12);
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.g> r15 = at.a(new com.obric.aiproactive.ui.model.g(0, true, null, false, 5, null));
        this._nowUiState = r15;
        this.nowUiState = kotlinx.coroutines.flow.k.a(r15);
        this.pinnedNowIds = new LinkedHashSet();
        this.nowRecommendations = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ void access$handleNowRecommendations(NowFeedViewModel r0, ProactiveNowPageSnapshot r1) {
        r0.handleNowRecommendations(r1);
    }

    private final void handleNowRecommendations(final ProactiveNowPageSnapshot r13) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r13.getList(), Iterable.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r1.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r6 = false;
    L18:
        final List<ProactiveRecommendationDto> r3 = com.obric.aiproactive.ui.model.i.f6729a.a(r13.getList());
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L21;
    L23:
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L25:
        if (r8.hasNext() == false) goto L34;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r8.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L25;
        r9 = r9 + 1;
        if (r9 >= 0) goto L25;
        CollectionsKt.throwCountOverflow();
        goto L25
    L29:
        r10 = false;
        goto L30
    L34:
        r5 = r9;
    L35:
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r12 = getLogTag();
        StringBuilder r4 = new StringBuilder().append("[NowFeedViewModel] incomingSnapshot batchId=").append(r13.getBatchId()).append(" rawSize=").append(r13.getList().size()).append(" dedupedSize=").append(r3.size()).append(" rawAdopted=").append(r2).append(" dedupedAdopted=").append(r5).append(" recommendIds=");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L37:
        if (r16.hasNext() == false) goto L39;
        r15.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r16.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());
        goto L37
    L39:
        StringBuilder r17 = r4.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).append(" inspirationIds=");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r13.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L41:
        if (r20.hasNext() == false) goto L43;
        r19.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r20.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId());
        goto L41
    L43:
        StringBuilder r21 = r17.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).append(" statuses=");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r13.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L45:
        if (r24.hasNext() == false) goto L47;
        r23.add(Integer.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r24.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus()));
        goto L45
    L47:
        StringBuilder r25 = r21.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).append(" dedupedStatuses=");
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L49:
        if (r28.hasNext() == false) goto L51;
        r27.add(Integer.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r28.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus()));
        goto L49
    L51:
        IRunLog.a.a(r11, r12, r25.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 3)).toString(), false, 4, null);
        if (BaseProactiveFeedViewModel.acceptStrictlyNewerBatch$default((BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(this, BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin"), r13.getBatchId(), PageType.NOW, "snapshotChanged", false, new $$Lambda$NowFeedViewModel$noEJMlcyayeM9HW1ipoWaR4ppyQ(this, r13, r3), 8, null) == false) goto L54;
        this.nowRecommendations = r3;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] applySnapshot batchId=" + r13.getBatchId() + " size=" + this.nowRecommendations.size() + " rebuildNow=true", false, 4, null);
        publishRecommendationIndex(this.nowRecommendations);
        rebuildNowItems();
        return;
    L54:
        if (o.a(((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(this._nowUiState.c(), com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin")).b(), this.nowRecommendations, r3) == false) goto L57;
        this.nowRecommendations = r3;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] applySnapshotWithoutBatchAdvance batchId=" + r13.getBatchId() + " size=" + this.nowRecommendations.size() + " reason=uiLoadingOrContentChanged", false, 4, null);
        publishRecommendationIndex(this.nowRecommendations);
        rebuildNowItems();
        return;
    L57:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] ignoreSnapshot batchId=" + r13.getBatchId() + " size=" + r3.size() + " currentBatchRemains", false, 4, null);
        return;
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        r2 = 0;
        goto L18
    }

    private static final Unit handleNowRecommendations$lambda$8(NowFeedViewModel r7, ProactiveNowPageSnapshot r8, List r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7.getLogTag(), "[NowFeedViewModel] resetForNewBatch batchId=" + r8.getBatchId() + " pageSize=" + ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).size() + " clearPinned=true", false, 4, null);
        r7.pinnedNowIds.clear();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$noEJMlcyayeM9HW1ipoWaR4ppyQ(NowFeedViewModel r0, ProactiveNowPageSnapshot r1, List r2) {
        return handleNowRecommendations$lambda$8(r0, r1, r2);
    }

    private final void rebuildNowItems() {
        List<com.obric.aiproactive.ui.model.j> r1 = com.obric.aiproactive.ui.model.k.f6745a.a(this.nowRecommendations, getTimeProvider().nowMillis(), getZoneId(), (Set) ZeusTransformUtils.preCheckCast(this.pinnedNowIds, Set.class, "com.obric.memorydata.plugin"), 0, string(ZeusTransformUtils.mapRes(R.string.proactive_now_all_processed_message, TypedValues.Custom.S_STRING, "proactive_now_all_processed_message")), string(ZeusTransformUtils.mapRes(R.string.proactive_status_adopted, TypedValues.Custom.S_STRING, "proactive_status_adopted")), string(ZeusTransformUtils.mapRes(R.string.proactive_status_ignored, TypedValues.Custom.S_STRING, "proactive_status_ignored")), string(ZeusTransformUtils.mapRes(R.string.proactive_execute_now, TypedValues.Custom.S_STRING, "proactive_execute_now")), string(ZeusTransformUtils.mapRes(R.string.proactive_known, TypedValues.Custom.S_STRING, "proactive_known")), this.showGuidedPreferenceEntry);
        RunLog r2 = RunLog.INSTANCE;
        String r3 = getLogTag();
        StringBuilder r4 = new StringBuilder().append("[NowFeedViewModel] rebuildNowItems batchId=").append(currentBatchId()).append(" recommendationSize=").append(this.nowRecommendations.size()).append(" resultSize=").append(r1.size()).append(" pinnedSize=").append(this.pinnedNowIds.size()).append(" adoptedCount=");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
        int r8 = 0;
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L9;
        r8 = r8 + 1;
        if (r8 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r9 = false;
        goto L14
    L18:
        r7 = r8;
    L19:
        StringBuilder r10 = r4.append(r7).append(" recommendIds=");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L21:
        if (r13.hasNext() == false) goto L23;
        r12.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r13.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());
        goto L21
    L23:
        StringBuilder r14 = r10.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" inspirationIds=");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        r16.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r17.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId());
        goto L25
    L27:
        StringBuilder r18 = r14.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).append(" statuses=");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L29:
        if (r21.hasNext() == false) goto L31;
        r20.add(Integer.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r21.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus()));
        goto L29
    L31:
        r2.debug(r3, r18.append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 5)).toString());
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.g> r22 = this._nowUiState;
    L32:
        com.obric.aiproactive.ui.model.g r23 = r22.c();
        if (r22.a(r23, com.obric.aiproactive.ui.model.g.a((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(r23, com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin"), currentBatchId(), false, r1, false, 8, null)) == false) goto L32;
        return;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static /* synthetic */ void setShowGuidedPreferenceEntry$default(NowFeedViewModel r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setShowGuidedPreferenceEntry(r1, r2);
    }

    public final ar<com.obric.aiproactive.ui.model.g> getNowUiState() {
        return this.nowUiState;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public Object observeFeed(Continuation<? super Unit> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] observeFeed start", false, 4, null);
        Object r8 = kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.b(getRepository().e(), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function3.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), r10);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void onBeforeRefresh() {
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.g> r10 = this._nowUiState;
    L3:
        com.obric.aiproactive.ui.model.g r0 = r10.c();
        if (r10.a(r0, com.obric.aiproactive.ui.model.g.a((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin"), 0, true, null, false, 13, null)) == false) goto L3;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void onRecommendationAdoptedFromDetail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        pinNowAdopted(r2);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void onRecommendationDismissedFromSync(String r8) {
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        k r0 = c.a(this.nowRecommendations, new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(this.pinnedNowIds, Collection.class, "com.obric.memorydata.plugin")), r8);
        if (r0.a().size() != this.nowRecommendations.size()) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] ignoreDismissedFromSync recommendId=" + r8 + " reason=notFound", false, 4, null);
        return;
    L6:
        this.nowRecommendations = r0.a();
        this.pinnedNowIds.clear();
        this.pinnedNowIds.addAll((Collection) ZeusTransformUtils.preCheckCast(r0.b(), Collection.class, "com.obric.memorydata.plugin"));
        publishRecommendationIndex(this.nowRecommendations);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] onRecommendationDismissedFromSync recommendId=" + r8 + " remaining=" + this.nowRecommendations.size() + " pinnedSize=" + this.pinnedNowIds.size(), false, 4, null);
        rebuildNowItems();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void pinNowAdopted(String r8) {
        Intrinsics.checkNotNullParameter(r8, "inspirationId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        ((Collection) ZeusTransformUtils.preCheckCast(this.pinnedNowIds, Collection.class, "com.obric.memorydata.plugin")).add(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowFeedViewModel] pinNowAdopted inspirationId=" + r8 + " pinnedSize=" + this.pinnedNowIds.size(), false, 4, null);
        rebuildNowItems();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void rebuildPageItemsAfterLocalMutation() {
        rebuildNowItems();
    }

    public final void setShowGuidedPreferenceEntry(boolean r3, boolean r4) {
        if (this.showGuidedPreferenceEntry != r3) goto L11;
        if (r4 == true) goto L6;
        return;
    L6:
        if (((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(this._nowUiState.c(), com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin")).b() == true) goto L8;
    L9:
        rebuildNowItems();
        return;
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L9;
        return;
    L11:
        this.showGuidedPreferenceEntry = r3;
        if (((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(this._nowUiState.c(), com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin")).b() == true) goto L14;
    L15:
        rebuildNowItems();
        return;
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L15;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public boolean updateRecommendationInLocalState(String r8, Function1<? super ProactiveRecommendationDto, ProactiveRecommendationDto> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "inspirationId");
        Intrinsics.checkNotNullParameter(r10, "transform");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.nowRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
        boolean r3 = false;
    L4:
        if (r1.hasNext() == false) goto L11;
        ProactiveRecommendationDto r4 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r1.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(com.obric.aiproactive.ui.model.l.a(r4), r8) == false) goto L10;
        ProactiveRecommendationDto r5 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r10.invoke(r4), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5, r4) == true) goto L10;
        r3 = true;
        r4 = r5;
    L10:
        r2.add(r4);
        goto L4
    L11:
        List<ProactiveRecommendationDto> r11 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        this.nowRecommendations = r11;
        if (r3 == false) goto L14;
        publishRecommendationIndex(r11);
    L14:
        return r3;
    }
}
