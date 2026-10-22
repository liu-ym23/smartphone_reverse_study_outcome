package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0003&'(B\\\u0012(\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\rJ3\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019JB\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 0\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\"\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010%H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R5\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/paging/PageFetcher;", "Key", "", "Value", "pagingSourceFactory", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource;", "initialKey", "config", "Landroidx/paging/PagingConfig;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "refreshEvents", "Landroidx/paging/ConflatedEventBus;", "", "retryEvents", "", "generateNewPagingSource", "previousPagingSource", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "refresh", "injectRemoteEvents", "Landroidx/paging/PageEvent;", "Landroidx/paging/PageFetcherSnapshot;", "job", "Lkotlinx/coroutines/Job;", "accessor", "Landroidx/paging/RemoteMediatorAccessor;", "GenerationInfo", "PagerHintReceiver", "PagerUiReceiver", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PageFetcher<Key, Value> {
    private final PagingConfig config;
    private final i<PagingData<Value>> flow;
    private final Key initialKey;
    private final Function1<Continuation<? super PagingSource<Key, Value>>, Object> pagingSourceFactory;
    private final ConflatedEventBus<Boolean> refreshEvents;
    private final ConflatedEventBus<Unit> retryEvents;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", "state", "Landroidx/paging/PagingState;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getState", "()Landroidx/paging/PagingState;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class GenerationInfo<Key, Value> {
        private final bx job;
        private final PageFetcherSnapshot<Key, Value> snapshot;
        private final PagingState<Key, Value> state;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> r3, PagingState<Key, Value> r4, bx r5) {
            bx r6 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "snapshot");
            Intrinsics.checkNotNullParameter(r6, "job");
            this.snapshot = r3;
            this.state = r4;
            this.job = r6;
        }

        public final bx getJob() {
            return this.job;
        }

        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        public final PagingState<Key, Value> getState() {
            return this.state;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B\u001b\u0012\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/paging/PageFetcher$PagerHintReceiver;", "Key", "", "Value", "Landroidx/paging/HintReceiver;", "pageFetcherSnapshot", "Landroidx/paging/PageFetcherSnapshot;", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;)V", "getPageFetcherSnapshot$paging_common", "()Landroidx/paging/PageFetcherSnapshot;", "accessHint", "", "viewportHint", "Landroidx/paging/ViewportHint;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class PagerHintReceiver<Key, Value> implements HintReceiver {
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerHintReceiver(PageFetcher r2, PageFetcherSnapshot<Key, Value> r3) {
            Intrinsics.checkNotNullParameter(r3, "pageFetcherSnapshot");
            this.this$0 = r2;
            this.pageFetcherSnapshot = r3;
        }

        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint r2) {
            Intrinsics.checkNotNullParameter(r2, "viewportHint");
            this.pageFetcherSnapshot.accessHint(r2);
        }

        public final PageFetcherSnapshot<Key, Value> getPageFetcherSnapshot$paging_common() {
            return this.pageFetcherSnapshot;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Landroidx/paging/UiReceiver;", "retryEventBus", "Landroidx/paging/ConflatedEventBus;", "", "(Landroidx/paging/PageFetcher;Landroidx/paging/ConflatedEventBus;)V", "refresh", "retry", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class PagerUiReceiver implements UiReceiver {
        private final ConflatedEventBus<Unit> retryEventBus;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerUiReceiver(PageFetcher r2, ConflatedEventBus<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "retryEventBus");
            this.this$0 = r2;
            this.retryEventBus = r3;
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            this.this$0.refresh();
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.retryEventBus.send(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher", f = "PageFetcher.kt", i = {0, 0}, l = {210}, m = "generateNewPagingSource", n = {"this", "previousPagingSource"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        AnonymousClass1(PageFetcher<Key, Value> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PageFetcher.access$generateNewPagingSource(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$3, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass3(Object r8) {
            super(0, r8, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PageFetcher.access$invalidate((PageFetcher) ZeusTransformUtils.preCheckCast(this.receiver, PageFetcher.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$generateNewPagingSource$4, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass4(Object r8) {
            super(0, r8, PageFetcher.class, "invalidate", "invalidate()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PageFetcher.access$invalidate((PageFetcher) ZeusTransformUtils.preCheckCast(this.receiver, PageFetcher.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1", f = "PageFetcher.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    static final class C09431 extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $accessor;
        final /* synthetic */ MutableLoadStateCollection $sourceStates;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> $this_injectRemoteEvents;
        private /* synthetic */ Object L$0;
        int label;

        C09431(RemoteMediatorAccessor<Key, Value> r3, PageFetcherSnapshot<Key, Value> r4, MutableLoadStateCollection r5, Continuation<? super C09431> r6) {
            RemoteMediatorAccessor<Key, Value> r7 = (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r3, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$accessor = r7;
            this.$this_injectRemoteEvents = r4;
            this.$sourceStates = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C09431 r0 = new C09431(this.$accessor, this.$this_injectRemoteEvents, this.$sourceStates, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final Object invoke(SimpleProducerScope<PageEvent<Value>> r3, Continuation<? super Unit> r4) {
            return ((C09431) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09431.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((SimpleProducerScope) ZeusTransformUtils.preCheckCast(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            final SimpleProducerScope r10 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            i r2 = SimpleChannelFlowKt.simpleChannelFlow((Function2) ZeusTransformUtils.preCheckCast(new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1((i) ZeusTransformUtils.preCheckCast(this.$accessor.getState(), i.class, "com.obric.memorydata.plugin"), this.$this_injectRemoteEvents.getPageEventFlow(), null, this.$sourceStates), Function2.class, "com.obric.memorydata.plugin"));
            j r11 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r2.collect(r11, r3) != r0) goto L12;
            return r0;
        }
    }

    public PageFetcher(Function1<? super Continuation<? super PagingSource<Key, Value>>, ? extends Object> r3, Key r4, PagingConfig r5, RemoteMediator<Key, Value> r6) {
        Function1<Continuation<? super PagingSource<Key, Value>>, Object> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.pagingSourceFactory = r7;
        this.initialKey = r4;
        this.config = r5;
        this.refreshEvents = new ConflatedEventBus(null, 1, null);
        this.retryEvents = new ConflatedEventBus(null, 1, null);
        this.flow = SimpleChannelFlowKt.simpleChannelFlow((Function2) ZeusTransformUtils.preCheckCast(new PageFetcher$flow$1(r6, this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ PageFetcher(Function1 r2, Object r3, PagingConfig r4, RemoteMediator r5, int r6, DefaultConstructorMarker r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = null;
    L5:
        this(r8, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$generateNewPagingSource(PageFetcher r2, PagingSource r3, Continuation r4) {
        return r2.generateNewPagingSource(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ PagingConfig access$getConfig$p(PageFetcher r0) {
        return r0.config;
    }

    public static final /* synthetic */ Object access$getInitialKey$p(PageFetcher r0) {
        return r0.initialKey;
    }

    public static final /* synthetic */ ConflatedEventBus access$getRefreshEvents$p(PageFetcher r0) {
        return r0.refreshEvents;
    }

    public static final /* synthetic */ ConflatedEventBus access$getRetryEvents$p(PageFetcher r0) {
        return r0.retryEvents;
    }

    public static final /* synthetic */ i access$injectRemoteEvents(PageFetcher r2, PageFetcherSnapshot r3, bx r4, RemoteMediatorAccessor r5) {
        return r2.injectRemoteEvents(r3, (bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin"), (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r5, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$invalidate(PageFetcher r0) {
        r0.invalidate();
    }

    private final Object generateNewPagingSource(PagingSource<Key, Value> r6, Continuation<? super PagingSource<Key, Value>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (PagingSource) ZeusTransformUtils.preCheckCast(r0.L$1, PagingSource.class, "com.obric.memorydata.plugin");
        PageFetcher<Key, Value> this = (PageFetcher) ZeusTransformUtils.preCheckCast(r0.L$0, PageFetcher.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L17:
        PagingSource<Key, Value> r10 = (PagingSource) ZeusTransformUtils.preCheckCast(r9, PagingSource.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, LegacyPagingSource.class) == false) goto L21;
        ((LegacyPagingSource) ZeusTransformUtils.preCheckCast(r10, LegacyPagingSource.class, "com.obric.memorydata.plugin")).setPageSize(this.config.pageSize);
    L21:
        if (r10 == r6) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L40;
        r10.registerInvalidatedCallback((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), Function0.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L28;
        r6.unregisterInvalidatedCallback((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this), Function0.class, "com.obric.memorydata.plugin"));
    L28:
        if (r6 == null) goto L30;
        r6.invalidate();
    L30:
        Logger r1 = LoggerKt.getLOGGER();
        if (r1 != null) goto L33;
    L35:
        r4 = false;
    L36:
        if (r4 == false) goto L38;
        r1.log(3, "Generated new PagingSource " + r10, null);
    L38:
        return r10;
    L33:
        if (r1.isLoggable(3) != true) goto L35;
    L40:
        throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.".toString());
    L23:
        r5 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        Function1<Continuation<? super PagingSource<Key, Value>>, Object> r11 = this.pagingSourceFactory;
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 1;
        r9 = r11.invoke(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    private final i<PageEvent<Value>> injectRemoteEvents(PageFetcherSnapshot<Key, Value> r4, bx r5, RemoteMediatorAccessor<Key, Value> r6) {
        bx r3 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
        RemoteMediatorAccessor r7 = (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r6, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        return r4.getPageEventFlow();
    L7:
        return CancelableChannelFlowKt.cancelableChannelFlow(r3, (Function2) ZeusTransformUtils.preCheckCast(new C09431(r7, r4, new MutableLoadStateCollection(), null), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final void invalidate() {
        this.refreshEvents.send(false);
    }

    public final i<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void refresh() {
        this.refreshEvents.send(true);
    }
}
