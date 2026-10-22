package com.obric.aiproactive.ui.entry;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u0014H\u0094@¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0014J\b\u0010$\u001a\u00020\u0014H\u0014J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002J \u0010,\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u00020'H\u0002J\u0012\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a03*\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u00064"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AllFeedViewModel;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "repository", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "timeProvider", "Lcom/obric/aiproactive/ui/model/TimeProvider;", "tipStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveTipStore;", "statsStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;", "<init>", "(Lcom/obric/aiproactive/ui/data/ProactiveRepository;Lcom/obric/aiproactive/ui/model/TimeProvider;Lcom/obric/aiproactive/ui/feedback/ProactiveTipStore;Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;)V", "_allUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "allUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getAllUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onBeforeRefresh", "", "observeFeed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAllPageEntered", "toggleDay", "dayKey", "", "loadNextPageForDay", "onTipKnown", "onCalendarContextChanged", "updateRecommendationInLocalState", "", "inspirationId", "transform", "Lkotlin/Function1;", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "rebuildPageItemsAfterLocalMutation", "handleAllSnapshot", "snapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "loadFirstPageForDay", "requestDayPage", TypedValues.CycleType.S_WAVE_OFFSET, "", "markDayPaging", "loading", "nextOffset", "rebuildAllItems", "currentDayKey", "emptyAllSnapshot", "availableDayKeys", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AllFeedViewModel extends BaseProactiveFeedViewModel {
    private final kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> _allUiState;
    private final ar<com.obric.aiproactive.ui.model.f> allUiState;
    private final com.obric.aiproactive.ui.feedback.g statsStore;
    private final com.obric.aiproactive.ui.feedback.h tipStore;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedViewModel$observeFeed$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "throwable", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedViewModel$observeFeed$2", f = "AllFeedViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super ProactiveAllPageSnapshot>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ AllFeedViewModel this$0;

        AnonymousClass2(AllFeedViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(3, r5);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super ProactiveAllPageSnapshot> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.j<? super ProactiveAllPageSnapshot> r3, Throwable r4, Continuation<? super Unit> r5) {
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
            this.this$0.handleObserverError(PageType.ALL, r2);
            ProactiveAllPageSnapshot r3 = AllFeedViewModel.access$emptyAllSnapshot(this.this$0);
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 1;
            if (r8.emit(r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedViewModel$observeFeed$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "snapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedViewModel$observeFeed$3", f = "AllFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ProactiveAllPageSnapshot, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AllFeedViewModel this$0;

        AnonymousClass3(AllFeedViewModel r3, Continuation<? super AnonymousClass3> r4) {
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

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProactiveAllPageSnapshot r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(ProactiveAllPageSnapshot r3, Continuation<? super Unit> r4) {
            return invoke2((ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(r3, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ProactiveAllPageSnapshot r4 = (ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(this.L$0, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin");
            AllFeedViewModel.access$handleAllSnapshot(this.this$0, r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedViewModel$requestDayPage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedViewModel$requestDayPage$1", f = "AllFeedViewModel.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $dayKey;
        final /* synthetic */ int $offset;
        final /* synthetic */ long $requestBatchId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AllFeedViewModel this$0;

        AnonymousClass1(AllFeedViewModel r3, long r4, String r6, int r7, Continuation<? super AnonymousClass1> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$requestBatchId = r4;
            this.$dayKey = r6;
            this.$offset = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$requestBatchId, this.$dayKey, this.$offset, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r35) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r9 = " limit=";
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r35);     // Catch: Throwable -> L15
            Object r2 = r35;
        L13:
            Object r3 = Result.m1421constructorimpl((ProactiveDayPageResult) ZeusTransformUtils.preCheckCast(r2, ProactiveDayPageResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        L17:
            AllFeedViewModel r4 = this.this$0;
            long r5 = this.$requestBatchId;
            String r6 = this.$dayKey;
            int r7 = this.$offset;
            if (Result.m1428isSuccessimpl(r3) == false) goto L54;
            ProactiveDayPageResult r8 = (ProactiveDayPageResult) ZeusTransformUtils.preCheckCast(r3, ProactiveDayPageResult.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.ui.model.f r14 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(AllFeedViewModel.access$get_allUiState$p(r4).c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
            String r10 = " pageSize=";
            if (r8.getBatchId() == r14.a()) goto L25;
            r9 = " limit=";
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r4.getLogTag(), "[AllFeedViewModel] dropStaleDayPage requestBatchId=" + r5 + " currentBatchId=" + r14.a() + " resultBatchId=" + r8.getBatchId() + " dayKey=" + r6 + " offset=" + r7 + " pageSize=" + r8.getList().size(), null, 4, null);
            AllFeedViewModel.access$markDayPaging(r4, r6, false, r7);
            if (r14.a() != r5) goto L24;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r4.getLogTag(), "[AllFeedViewModel] dropStaleDayPage refreshTriggered requestBatchId=" + r5 + " currentBatchId=" + r14.a() + " dayKey=" + r6, null, 4, null);
            r4.refresh();
        L24:
            r3 = r3;
        L56:
            AllFeedViewModel r11 = this.this$0;
            long r12 = this.$requestBatchId;
            String r13 = this.$dayKey;
            int r15 = this.$offset;
            Throwable r16 = Result.m1424exceptionOrNullimpl(r3);
            if (r16 == null) goto L62;
            RunLog.INSTANCE.error(r11.getLogTag(), "[AllFeedViewModel] loadDayPage failed batchId=" + r12 + " dayKey=" + r13 + " offset=" + r15 + r9 + r11.getAllDayPageLimit(), r16);
            if (((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(AllFeedViewModel.access$get_allUiState$p(r11).c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin")).a() != r12) goto L62;
            AllFeedViewModel.access$markDayPaging(r11, r13, false, r15);
            r11.tryEmitUiEvent((BaseProactiveFeedViewModel.b) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedViewModel.b.c(r11.string(ZeusTransformUtils.mapRes(R.string.proactive_load_failed, TypedValues.Custom.S_STRING, "proactive_load_failed"))), BaseProactiveFeedViewModel.b.class, "com.obric.memorydata.plugin"));
        L62:
            return Unit.INSTANCE;
        L25:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r14.g().get(r6), List.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L28;
            r17 = CollectionsKt.emptyList();
        L28:
            int r18 = r17.size();
            List<ProactiveRecommendationDto> r19 = com.obric.aiproactive.ui.model.i.f6729a.a(r8.getList());
            if (r7 != 0) goto L31;
            String r110 = " pageSize=";
        L49:
            kotlinx.coroutines.flow.ae r20 = AllFeedViewModel.access$get_allUiState$p(r4);
        L50:
            Object r21 = r20.c();
            com.obric.aiproactive.ui.model.f r22 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r21, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
            ProactiveDayPageResult r111 = r8;
            List<ProactiveRecommendationDto> r112 = r19;
            if (r20.a(r21, com.obric.aiproactive.ui.model.f.a(r22, 0, false, null, false, null, null, MapsKt.plus(r22.g(), TuplesKt.to(r6, r19)), MapsKt.plus(r22.h(), TuplesKt.to(r6, new com.obric.aiproactive.ui.model.c(false, r8.getHasNext(), r19.size()))), 63, null)) == true) goto L52;
            r8 = r111;
            r19 = r112;
            goto L50
        L52:
            r4.publishRecommendationIndex(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(AllFeedViewModel.access$get_allUiState$p(r4).c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin")).g().values(), Iterable.class, "com.obric.memorydata.plugin")));
            AllFeedViewModel.access$rebuildAllItems(r4);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r4.getLogTag(), "[AllFeedViewModel] loadDayPage success batchId=" + r5 + " dayKey=" + r6 + " offset=" + r7 + " before=" + r18 + " after=" + r112.size() + r110 + r111.getList().size() + " hasNext=" + r111.getHasNext(), false, 4, null);
            goto L56
        L31:
            List r23 = (List) ZeusTransformUtils.preCheckCast(r14.g().get(r6), List.class, "com.obric.memorydata.plugin");
            if (r23 != null) goto L34;
            r23 = CollectionsKt.emptyList();
        L34:
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r114 = r113.iterator();
        L36:
            if (r114.hasNext() == false) goto L41;
            Iterator r115 = r114;
            String r116 = com.obric.aiproactive.ui.model.l.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r114.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"));
            if (r116 == null) goto L40;
            r24.add(r116);
        L40:
            r114 = r115;
            goto L36
        L41:
            Set r25 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
            Collection r117 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r27 = r26.iterator();
        L43:
            if (r27.hasNext() == false) goto L48;
            Object r118 = r27.next();
            Iterator r119 = r27;
            String r120 = r10;
            if ((!CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.l.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r118, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")))) == false) goto L47;
            r117.add(r118);
        L47:
            r27 = r119;
            r10 = r120;
            goto L43
        L48:
            r110 = r10;
            r19 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            goto L49
        L54:
            r3 = r3;
            goto L56
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r35);
            al r28 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[AllFeedViewModel] loadDayPage start batchId=" + this.$requestBatchId + " dayKey=" + this.$dayKey + " offset=" + this.$offset + " limit=" + this.this$0.getAllDayPageLimit(), false, 4, null);
            AllFeedViewModel r29 = this.this$0;
            long r30 = this.$requestBatchId;
            String r31 = this.$dayKey;
            int r32 = this.$offset;
            Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.data.b r34 = r29.getRepository();     // Catch: Throwable -> L15
            int r36 = r29.getAllDayPageLimit();     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r2 = r34.a(r30, r31, r32, r36, this);     // Catch: Throwable -> L15
            if (r2 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r37 = Result.Companion;
            r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    public AllFeedViewModel(com.obric.aiproactive.ui.data.b r19, com.obric.aiproactive.ui.model.m r20, com.obric.aiproactive.ui.feedback.h r21, com.obric.aiproactive.ui.feedback.g r22) {
        com.obric.aiproactive.ui.data.b r3 = (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.m r4 = (com.obric.aiproactive.ui.model.m) ZeusTransformUtils.wrapperContextForParams(r20, com.obric.aiproactive.ui.model.m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r4, "timeProvider");
        Intrinsics.checkNotNullParameter(r21, "tipStore");
        Intrinsics.checkNotNullParameter(r22, "statsStore");
        super(r3, r4, r22);
        this.tipStore = r21;
        this.statsStore = r22;
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r1 = at.a(new com.obric.aiproactive.ui.model.f(0, true, null, false, null, null, null, null, 245, null));
        this._allUiState = r1;
        this.allUiState = kotlinx.coroutines.flow.k.a(r1);
    }

    public static final /* synthetic */ ProactiveAllPageSnapshot access$emptyAllSnapshot(AllFeedViewModel r0) {
        return r0.emptyAllSnapshot();
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_allUiState$p(AllFeedViewModel r0) {
        return r0._allUiState;
    }

    public static final /* synthetic */ void access$handleAllSnapshot(AllFeedViewModel r0, ProactiveAllPageSnapshot r1) {
        r0.handleAllSnapshot(r1);
    }

    public static final /* synthetic */ void access$markDayPaging(AllFeedViewModel r0, String r1, boolean r2, int r3) {
        r0.markDayPaging(r1, r2, r3);
    }

    public static final /* synthetic */ void access$rebuildAllItems(AllFeedViewModel r0) {
        r0.rebuildAllItems();
    }

    private final Set<String> availableDayKeys(com.obric.aiproactive.ui.model.f r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r4.e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r5.add(((ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r6.next(), ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin")).getDayKey());
        goto L4
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
    }

    private final String currentDayKey() {
        String r1 = currentDate().format(getDayKeyFormatter());
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        return r1;
    }

    private final ProactiveAllPageSnapshot emptyAllSnapshot() {
        return new ProactiveAllPageSnapshot(0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    }

    private final void handleAllSnapshot(final ProactiveAllPageSnapshot r9) {
        String r0 = currentDayKey();
        final List<ProactiveRecommendationDto> r1 = com.obric.aiproactive.ui.model.i.f6729a.a(r9.getTodayFirstPage());
        com.obric.aiproactive.ui.model.e r2 = com.obric.aiproactive.ui.model.d.a((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), r9, r0, r1, acceptBatch(r9.getBatchId(), PageType.ALL, "snapshotChanged", new $$Lambda$AllFeedViewModel$LBXlwHYq6kKMqjSdwZWTSzw4UHE(this, r9, r1)));
        this._allUiState.b(r2.a());
        publishRecommendationIndex(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r2.a().g().values(), Iterable.class, "com.obric.memorydata.plugin")));
        rebuildAllItems();
        if (r2.b() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[AllFeedViewModel] autoReloadTodayForNewBatch batchId=" + r9.getBatchId() + " dayKey=" + r0, false, 4, null);
        requestDayPage(r0, 0);
        return;
    }

    private static final Unit handleAllSnapshot$lambda$7(AllFeedViewModel r7, ProactiveAllPageSnapshot r8, List r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7.getLogTag(), "[AllFeedViewModel] resetForNewBatch batchId=" + r8.getBatchId() + " dayHeaderSize=" + r8.getDayHeaders().size() + " todayFirstPage=" + ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).size(), false, 4, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$LBXlwHYq6kKMqjSdwZWTSzw4UHE(AllFeedViewModel r0, ProactiveAllPageSnapshot r1, List r2) {
        return handleAllSnapshot$lambda$7(r0, r1, r2);
    }

    private final void loadFirstPageForDay(String r2) {
        requestDayPage(r2, 0);
    }

    private final void markDayPaging(String r21, boolean r22, int r23) {
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r2 = this._allUiState;
    L3:
        com.obric.aiproactive.ui.model.f r3 = r2.c();
        com.obric.aiproactive.ui.model.f r6 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.c r4 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r6.h().get(r21), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        r4 = new com.obric.aiproactive.ui.model.c(false, false, 0, 7, null);
    L7:
        if (r2.a(r3, com.obric.aiproactive.ui.model.f.a(r6, 0, false, null, false, null, null, null, MapsKt.plus(r6.h(), TuplesKt.to(r21, com.obric.aiproactive.ui.model.c.a(r4, r22, false, r23, 2, null))), 127, null)) == false) goto L3;
        com.obric.aiproactive.ui.model.c r5 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin")).h().get(r21), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        RunLog r7 = RunLog.INSTANCE;
        String r0 = getLogTag();
        StringBuilder r1 = new StringBuilder().append("[AllFeedViewModel] markDayPaging dayKey=").append(r21).append(" loading=").append(r22).append(" nextOffset=").append(r23).append(" after={loading=");
        Integer r8 = null;
        if (r5 == null) goto L11;
        Boolean r9 = Boolean.valueOf(r5.a());
    L12:
        StringBuilder r10 = r1.append(r9).append(" hasNext=");
        if (r5 == null) goto L15;
        Boolean r11 = Boolean.valueOf(r5.b());
    L16:
        StringBuilder r12 = r10.append(r11).append(" nextOffset=");
        if (r5 == null) goto L19;
        r8 = Integer.valueOf(r5.c());
    L19:
        r7.debug(r0, r12.append(r8).append('}').toString());
        return;
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    }

    private final void rebuildAllItems() {
        long r14 = getTimeProvider().nowMillis();
        com.obric.aiproactive.ui.model.f r1 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        List r2 = com.obric.aiproactive.ui.model.k.a(com.obric.aiproactive.ui.model.k.f6745a, r1, r14, getZoneId(), null, string(ZeusTransformUtils.mapRes(R.string.proactive_day_today, TypedValues.Custom.S_STRING, "proactive_day_today")), string(ZeusTransformUtils.mapRes(R.string.proactive_day_yesterday, TypedValues.Custom.S_STRING, "proactive_day_yesterday")), string(ZeusTransformUtils.mapRes(R.string.proactive_status_adopted, TypedValues.Custom.S_STRING, "proactive_status_adopted")), string(ZeusTransformUtils.mapRes(R.string.proactive_status_ignored, TypedValues.Custom.S_STRING, "proactive_status_ignored")), string(ZeusTransformUtils.mapRes(R.string.proactive_execute_now, TypedValues.Custom.S_STRING, "proactive_execute_now")), string(ZeusTransformUtils.mapRes(R.string.proactive_known, TypedValues.Custom.S_STRING, "proactive_known")), "", 8, null);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r6 = r4.next();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.f.class) == false) goto L4;
        r5.add(r6);
        goto L4
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getInspirationId());
        goto L10
    L12:
        List<String> r10 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        this.statsStore.a(r10, r14);
        RunLog.INSTANCE.debug(getLogTag(), "[AllFeedViewModel] rebuildAllItems batchId=" + r1.a() + " resultSize=" + r2.size() + " expandedDays=" + r1.f().size() + " shownIds=" + r10.size());
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r0 = this._allUiState;
    L13:
        com.obric.aiproactive.ui.model.f r11 = r0.c();
        if (r0.a(r11, com.obric.aiproactive.ui.model.f.a((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r11, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), 0, false, r2, false, null, null, null, null, 249, null)) == false) goto L13;
    }

    private final void requestDayPage(String r14, int r15) {
        com.obric.aiproactive.ui.model.f r0 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        long r5 = r0.a();
        if (r5 > 0) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.model.c r1 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r0.h().get(r14), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        RunLog r3 = RunLog.INSTANCE;
        String r4 = getLogTag();
        StringBuilder r7 = new StringBuilder().append("[AllFeedViewModel] loadDayPage markLoading batchId=").append(r5).append(" dayKey=").append(r14).append(" offset=").append(r15).append(" beforePaging={loading=");
        Integer r8 = null;
        if (r1 == null) goto L8;
        Boolean r9 = Boolean.valueOf(r1.a());
    L9:
        StringBuilder r10 = r7.append(r9).append(" hasNext=");
        if (r1 == null) goto L12;
        Boolean r11 = Boolean.valueOf(r1.b());
    L13:
        StringBuilder r12 = r10.append(r11).append(" nextOffset=");
        if (r1 == null) goto L16;
        r8 = Integer.valueOf(r1.c());
    L16:
        StringBuilder r2 = r12.append(r8).append("} beforeItemsSize=");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r0.g().get(r14), List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L19;
        r6 = CollectionsKt.emptyList();
    L19:
        r3.debug(r4, r2.append(r6.size()).toString());
        markDayPaging(r14, true, r15);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r5, r14, r15, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        r11 = null;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    public final ar<com.obric.aiproactive.ui.model.f> getAllUiState() {
        return this.allUiState;
    }

    public final void loadNextPageForDay(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dayKey");
        com.obric.aiproactive.ui.model.f r0 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.c r1 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r0.h().get(r9), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        r1 = new com.obric.aiproactive.ui.model.c(false, false, 0, 7, null);
    L6:
        if (r0.a() > 0) goto L9;
        return;
    L9:
        if (r0.f().contains(r9) == true) goto L12;
        return;
    L12:
        if (availableDayKeys(r0).contains(r9) == true) goto L15;
        return;
    L15:
        if (r1.a() == false) goto L19;
        RunLog.INSTANCE.debug(getLogTag(), "[AllFeedViewModel] loadNextPageForDay skipped batchId=" + r0.a() + " dayKey=" + r9 + " loading=true");
        return;
    L19:
        if (r1.b() == false) goto L21;
    L24:
        requestDayPage(r9, r1.c());
        return;
    L21:
        if (r1.c() <= 0) goto L24;
        RunLog.INSTANCE.debug(getLogTag(), "[AllFeedViewModel] loadNextPageForDay skipped batchId=" + r0.a() + " dayKey=" + r9 + " hasNext=false nextOffset=" + r1.c());
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public Object observeFeed(Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Object r5 = kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.b(getRepository().a(), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function3.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final void onAllPageEntered() {
        String r1 = currentDayKey();
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r2 = this._allUiState;
    L3:
        com.obric.aiproactive.ui.model.f r3 = r2.c();
        com.obric.aiproactive.ui.model.f r6 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        Set r13 = SetsKt.plus(r6.f(), r1);
        if (availableDayKeys(r6).contains(r1) == false) goto L21;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r6.g().get(r1), Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L21;
        com.obric.aiproactive.ui.model.c r7 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r6.h().get(r1), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == true) goto L21;
        boolean r9 = true;
    L23:
        if (r2.a(r3, com.obric.aiproactive.ui.model.f.a(r6, 0, false, null, false, null, r13, null, null, 223, null)) == false) goto L3;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[AllFeedViewModel] onAllPageEntered dayKey=" + r1 + " shouldLoadToday=" + r9, false, 4, null);
        rebuildAllItems();
        if (r9 == false) goto L30;
        loadFirstPageForDay(r1);
        return;
    L30:
        return;
    L16:
        if (r7.a() != true) goto L18;
        r8 = true;
        goto L19
    L8:
        if (r4.isEmpty() == true) goto L11;
        r5 = false;
    L21:
        r9 = false;
        goto L23
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void onBeforeRefresh() {
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r14 = this._allUiState;
    L3:
        com.obric.aiproactive.ui.model.f r0 = r14.c();
        if (r14.a(r0, com.obric.aiproactive.ui.model.f.a((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), 0, true, null, false, null, null, null, null, 253, null)) == false) goto L3;
    }

    public final void onCalendarContextChanged() {
        com.obric.aiproactive.ui.model.f r0 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        if (r0.e().isEmpty() == true) goto L5;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[AllFeedViewModel] onCalendarContextChanged batchId=" + r0.a() + " headers=" + r0.e().size() + " items=" + r0.c().size(), false, 4, null);
        rebuildAllItems();
        return;
    L5:
        if (r0.c().isEmpty() == false) goto L7;
    }

    public final void onTipKnown() {
        this.tipStore.a(true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[AllFeedViewModel] onTipKnown", false, 4, null);
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r1 = this._allUiState;
    L3:
        com.obric.aiproactive.ui.model.f r2 = r1.c();
        if (r1.a(r2, com.obric.aiproactive.ui.model.f.a((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), 0, false, null, false, null, null, null, null, 247, null)) == false) goto L3;
        rebuildAllItems();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public void rebuildPageItemsAfterLocalMutation() {
        rebuildAllItems();
    }

    public final void toggleDay(String r24) {
        Intrinsics.checkNotNullParameter(r24, "dayKey");
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r2 = this._allUiState;
        boolean r4 = false;
    L3:
        com.obric.aiproactive.ui.model.f r5 = r2.c();
        com.obric.aiproactive.ui.model.f r8 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        if (r8.f().contains(r24) == false) goto L6;
        Set r6 = SetsKt.minus(r8.f(), r24);
    L7:
        if (r4 == true) goto L9;
    L26:
        boolean r14 = false;
    L27:
        boolean r3 = r14;
        if (r2.a(r5, com.obric.aiproactive.ui.model.f.a(r8, 0, false, null, false, null, r6, null, null, 223, null)) == false) goto L3;
        com.obric.aiproactive.ui.model.f r7 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.c r9 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r7.h().get(r24), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[AllFeedViewModel] toggleDay batchId=" + currentBatchId() + " dayKey=" + r24 + " expanded=" + r4 + " shouldLoadFirstPage=" + r3, false, 4, null);
        if (r4 == false) goto L54;
        if (r3 == true) goto L54;
        if (availableDayKeys(r7).contains(r24) == false) goto L54;
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r7.g().get(r24), Collection.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L37;
    L40:
        boolean r21 = true;
    L41:
        if (r21 == false) goto L54;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r12 = getLogTag();
        StringBuilder r13 = new StringBuilder().append("[AllFeedViewModel] toggleDay loadBlocked batchId=").append(r7.a()).append(" dayKey=").append(r24).append(" paging={loading=");
        Integer r15 = null;
        if (r9 == null) goto L45;
        Boolean r16 = Boolean.valueOf(r9.a());
    L46:
        StringBuilder r17 = r13.append(r16).append(" hasNext=");
        if (r9 == null) goto L49;
        Boolean r18 = Boolean.valueOf(r9.b());
    L50:
        StringBuilder r19 = r17.append(r18).append(" nextOffset=");
        if (r9 == null) goto L53;
        r15 = Integer.valueOf(r9.c());
    L53:
        IRunLog.a.a(r11, r12, r19.append(r15).append('}').toString(), null, 4, null);
        goto L54
    L49:
        r18 = null;
        goto L50
    L45:
        r16 = null;
        goto L46
    L37:
        if (r10.isEmpty() == true) goto L40;
        r21 = false;
    L54:
        rebuildAllItems();
        if (r3 == false) goto L60;
        loadFirstPageForDay(r24);
        return;
    L60:
        return;
    L9:
        if (availableDayKeys(r8).contains(r24) == false) goto L26;
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(r8.g().get(r24), Collection.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L13;
    L16:
        boolean r22 = true;
    L17:
        if (r22 == false) goto L26;
        com.obric.aiproactive.ui.model.c r23 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r8.h().get(r24), com.obric.aiproactive.ui.model.c.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L21;
    L23:
        boolean r25 = false;
    L24:
        if (r25 == true) goto L26;
        r14 = true;
        goto L27
    L21:
        if (r23.a() != true) goto L23;
        r25 = true;
        goto L24
    L13:
        if (r20.isEmpty() == true) goto L16;
        r22 = false;
        goto L17
    L6:
        r6 = SetsKt.plus(r8.f(), r24);
        r4 = true;
        goto L7
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel
    public boolean updateRecommendationInLocalState(String r20, Function1<? super ProactiveRecommendationDto, ProactiveRecommendationDto> r21) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "inspirationId");
        Intrinsics.checkNotNullParameter(r2, "transform");
        Map<String, List<ProactiveRecommendationDto>> r4 = ((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this._allUiState.c(), com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin")).g();
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r4.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r18 = false;
    L4:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();
        Object r8 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L14;
        ProactiveRecommendationDto r12 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r11.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(com.obric.aiproactive.ui.model.l.a(r12), r20) == false) goto L13;
        ProactiveRecommendationDto r13 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r2.invoke(r12), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r13, r12) == true) goto L13;
        r18 = true;
        r12 = r13;
    L13:
        r10.add(r12);
        goto L7
    L14:
        r5.put(r8, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"));
        goto L4
    L15:
        if (r18 == false) goto L20;
        kotlinx.coroutines.flow.ae<com.obric.aiproactive.ui.model.f> r1 = this._allUiState;
    L17:
        com.obric.aiproactive.ui.model.f r3 = r1.c();
        if (r1.a(r3, com.obric.aiproactive.ui.model.f.a((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), 0, false, null, false, null, null, r5, null, 191, null)) == false) goto L17;
        publishRecommendationIndex(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r5.values(), Iterable.class, "com.obric.memorydata.plugin")));
    L20:
        return r18;
    }
}
