package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PagingData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
final class PageFetcher$flow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PagingData<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteMediator<Key, Value> $remoteMediator;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageFetcher<Key, Value> this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", i = {}, l = {63, 63}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<j<? super Boolean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(RemoteMediatorAccessor<Key, Value> r3, Continuation<? super AnonymousClass1> r4) {
            RemoteMediatorAccessor<Key, Value> r5 = (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r3, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$remoteMediatorAccessor = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$remoteMediatorAccessor, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(j<? super Boolean> r3, Continuation<? super Unit> r4) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super Boolean> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            j r2 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L15:
            RemoteMediator.InitializeAction r9 = (RemoteMediator.InitializeAction) ZeusTransformUtils.preCheckCast(r8, RemoteMediator.InitializeAction.class, "com.obric.memorydata.plugin");
        L18:
            if (r9 == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) goto L21;
            r4 = false;
        L21:
            Boolean r10 = Boxing.boxBoolean(r4);
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            if (r2.emit(r10, r5) != r0) goto L25;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            r2 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            RemoteMediatorAccessor<Key, Value> r11 = this.$remoteMediatorAccessor;
            if (r11 == 0) goto L16;
            Continuation<? super RemoteMediator.InitializeAction> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r2;
            this.label = 1;
            r8 = r11.initialize(r6);
            if (r8 != r0) goto L15;
            return r0;
        L16:
            r9 = null;
            goto L18
        }
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "Value", "", "previousGeneration", "triggerRemoteRefresh", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", i = {0, 1, 1}, l = {73, 77}, m = "invokeSuspend", n = {"previousGeneration", "previousGeneration", "pagingSource"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass2<Key> extends SuspendLambda implements Function3<PageFetcher.GenerationInfo<Key, Value>, Boolean, Continuation<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        /* synthetic */ Object L$0;
        Object L$1;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            AnonymousClass1(Object r8) {
                super(0, r8, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PageFetcher) ZeusTransformUtils.preCheckCast(this.receiver, PageFetcher.class, "com.obric.memorydata.plugin")).refresh();
            }
        }

        AnonymousClass2(RemoteMediatorAccessor<Key, Value> r3, PageFetcher<Key, Value> r4, Continuation<? super AnonymousClass2> r5) {
            RemoteMediatorAccessor<Key, Value> r6 = (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r3, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$remoteMediatorAccessor = r6;
            this.this$0 = r4;
            super(3, r7);
        }

        public final Object invoke(PageFetcher.GenerationInfo<Key, Value> r3, boolean r4, Continuation<? super PageFetcher.GenerationInfo<Key, Value>> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.$remoteMediatorAccessor, this.this$0, r6);
            r0.L$0 = r3;
            r0.Z$0 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Boolean r4, Object r5) {
            return invoke((PageFetcher.GenerationInfo) ZeusTransformUtils.preCheckCast(r3, PageFetcher.GenerationInfo.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r17) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            PagingSource r3 = (PagingSource) ZeusTransformUtils.preCheckCast(this.L$1, PagingSource.class, "com.obric.memorydata.plugin");
            PageFetcher.GenerationInfo r4 = (PageFetcher.GenerationInfo) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcher.GenerationInfo.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r17);
            Object r5 = r17;
        L32:
            PagingState<Key, Value> r6 = (PagingState) ZeusTransformUtils.preCheckCast(r5, PagingState.class, "com.obric.memorydata.plugin");
            PagingSource r9 = r3;
        L34:
            if (r6 == null) goto L36;
            List<PagingSource.LoadResult.Page<Key, Value>> r7 = r6.getPages();
        L37:
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
            boolean r10 = false;
            if (r8 != null) goto L40;
        L43:
            boolean r11 = true;
        L44:
            if (r11 == false) goto L56;
            if (r4 == null) goto L53;
            PagingState<Key, Value> r12 = r4.getState();
            if (r12 == null) goto L53;
            List<PagingSource.LoadResult.Page<Key, Value>> r13 = r12.getPages();
            if (r13 == null) goto L53;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L53;
            boolean r14 = true;
        L54:
            if (r14 == false) goto L56;
            r6 = r4.getState();
        L53:
            r14 = false;
        L56:
            if (r6 == null) goto L58;
            Integer r15 = r6.getAnchorPosition();
        L59:
            if (r15 != null) goto L67;
            if (r4 == null) goto L64;
            PagingState<Key, Value> r16 = r4.getState();
            if (r16 == null) goto L64;
            Integer r18 = r16.getAnchorPosition();
        L65:
            if (r18 == null) goto L67;
            r6 = r4.getState();
        L64:
            r18 = null;
        L67:
            if (r6 != null) goto L70;
            Object r19 = PageFetcher.access$getInitialKey$p(this.this$0);
        L69:
            Object r20 = r19;
            if (r4 == null) goto L81;
            PageFetcherSnapshot<Key, Value> r21 = r4.getSnapshot();
            if (r21 == null) goto L81;
            r21.close();
        L81:
            if (r4 == null) goto L86;
            bx r22 = r4.getJob();
            if (r22 == null) goto L86;
            bx.a.a(r22, null, 1, null);
        L86:
            return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(r20, r9, PageFetcher.access$getConfig$p(this.this$0), PageFetcher.access$getRetryEvents$p(this.this$0).getFlow(), (RemoteMediatorConnection) ZeusTransformUtils.preCheckCast(this.$remoteMediatorAccessor, RemoteMediatorConnection.class, "com.obric.memorydata.plugin"), r6, (Function0) ZeusTransformUtils.preCheckCast((KFunction) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), KFunction.class, "com.obric.memorydata.plugin"), Function0.class, "com.obric.memorydata.plugin")), r6, (bx) ZeusTransformUtils.preCheckCast(ca.a(null, 1, null), bx.class, "com.obric.memorydata.plugin"));
        L70:
            r19 = r9.getRefreshKey(r6);
            Logger r110 = LoggerKt.getLOGGER();
            if (r110 != null) goto L73;
        L75:
            if (r10 == false) goto L69;
            r110.log(3, "Refresh key " + r19 + " returned from PagingSource " + r9, null);
            goto L69
        L73:
            if (r110.isLoggable(3) != true) goto L75;
            r10 = true;
            goto L75
        L58:
            r15 = null;
            goto L59
        L40:
            if (r8.isEmpty() == true) goto L43;
            r11 = false;
            goto L44
        L36:
            r7 = null;
            goto L37
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r4 = (PageFetcher.GenerationInfo) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcher.GenerationInfo.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r17);
            Object r23 = r17;
        L24:
            PagingSource r24 = (PagingSource) ZeusTransformUtils.preCheckCast(r23, PagingSource.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L33;
            PageFetcherSnapshot<Key, Value> r25 = r4.getSnapshot();
            if (r25 == null) goto L33;
            Continuation<? super PagingState<Key, Value>> r26 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.L$1 = r24;
            this.label = 2;
            r5 = r25.currentPagingState(r26);
            if (r5 != r1) goto L31;
            return r1;
        L31:
            r3 = r24;
        L33:
            r6 = null;
            r9 = r24;
            goto L34
        L10:
            ResultKt.throwOnFailure(r17);
            r4 = (PageFetcher.GenerationInfo) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcher.GenerationInfo.class, "com.obric.memorydata.plugin");
            if (this.Z$0 == false) goto L15;
            RemoteMediatorAccessor<Key, Value> r27 = this.$remoteMediatorAccessor;
            if (r27 == null) goto L15;
            r27.allowRefresh();
        L15:
            PageFetcher<Key, Value> r28 = this.this$0;
            if (r4 == null) goto L20;
            PageFetcherSnapshot<Key, Value> r29 = r4.getSnapshot();
            if (r29 == null) goto L20;
            PagingSource<Key, Value> r30 = r29.getPagingSource$paging_common();
        L21:
            Continuation r31 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.label = 1;
            r23 = PageFetcher.access$generateNewPagingSource(r28, r30, r31);
            if (r23 != r1) goto L24;
            return r1;
        L20:
            r30 = null;
            goto L21
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$4, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass4 implements FunctionAdapter, j {
        final /* synthetic */ SimpleProducerScope<PagingData<Value>> $tmp0;

        AnonymousClass4(SimpleProducerScope<PagingData<Value>> r3) {
            this.$tmp0 = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        }

        public final Object emit(PagingData<Value> r3, Continuation<? super Unit> r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.$tmp0.send(r3, r5);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return emit((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), r5);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, j.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return (Function) ZeusTransformUtils.preCheckCast(new FunctionReferenceImpl(2, this.$tmp0, SimpleProducerScope.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0), Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    PageFetcher$flow$1(RemoteMediator<Key, Value> r3, PageFetcher<Key, Value> r4, Continuation<? super PageFetcher$flow$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$remoteMediator = r3;
        this.this$0 = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        PageFetcher$flow$1 r0 = new PageFetcher$flow$1(this.$remoteMediator, this.this$0, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final Object invoke(SimpleProducerScope<PagingData<Value>> r3, Continuation<? super Unit> r4) {
        return ((PageFetcher$flow$1) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageFetcher$flow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        SimpleProducerScope r10 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        RemoteMediator<Key, Value> r2 = this.$remoteMediator;
        if (r2 == 0) goto L11;
        RemoteMediatorAccessor r3 = RemoteMediatorAccessorKt.RemoteMediatorAccessor((al) ZeusTransformUtils.preCheckCast(r10, al.class, "com.obric.memorydata.plugin"), r2);
    L12:
        i r4 = FlowExtKt.simpleTransformLatest(k.c(FlowExtKt.simpleScan(k.b(PageFetcher.access$getRefreshEvents$p(this.this$0).getFlow(), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, null), Function2.class, "com.obric.memorydata.plugin")), null, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, this.this$0, null), Function3.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.this$0, r3), Function3.class, "com.obric.memorydata.plugin"));
        j r11 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r10), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r4.collect(r11, r5) != r0) goto L16;
        return r0;
    L11:
        r3 = null;
        goto L12
    }
}
