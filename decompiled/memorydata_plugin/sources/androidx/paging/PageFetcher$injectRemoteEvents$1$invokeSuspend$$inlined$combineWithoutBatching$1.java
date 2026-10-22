package androidx.paging;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;", "androidx/paging/FlowExtKt$combineWithoutBatching$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1", f = "PageFetcher.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $otherFlow;
    final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
    final /* synthetic */ i $this_combineWithoutBatching;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u00020\bH\u008a@¨\u0006\t"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "t1", "t2", "updateFrom", "Landroidx/paging/CombineSource;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1", f = "PageFetcher.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<LoadStates, PageEvent<Value>, CombineSource, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass1(SimpleProducerScope r3, Continuation r4, MutableLoadStateCollection r5) {
            SimpleProducerScope<PageEvent<Value>> r6 = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$sourceStates$inlined = r5;
            this.$$this$simpleChannelFlow = r6;
            super(4, r7);
        }

        public final Object invoke(LoadStates r3, PageEvent<Value> r4, CombineSource r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$$this$simpleChannelFlow, r7, this.$sourceStates$inlined);
            r0.L$0 = r3;
            r0.L$1 = r4;
            r0.L$2 = r5;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* synthetic */ Object invoke(LoadStates r3, Object r4, CombineSource r5, Continuation<? super Unit> r6) {
            return invoke(r3, r4, (CombineSource) ZeusTransformUtils.preCheckCast(r5, CombineSource.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r18);
        L31:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            Object r3 = this.L$0;
            Object r4 = this.L$1;
            CombineSource r5 = (CombineSource) ZeusTransformUtils.preCheckCast(this.L$2, CombineSource.class, "com.obric.memorydata.plugin");
            SimpleProducerScope<PageEvent<Value>> r6 = this.$$this$simpleChannelFlow;
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            PageEvent r7 = (PageEvent) ZeusTransformUtils.preCheckCast(r4, PageEvent.class, "com.obric.memorydata.plugin");
            LoadStates r14 = (LoadStates) ZeusTransformUtils.preCheckCast(r3, LoadStates.class, "com.obric.memorydata.plugin");
            if (r5 != CombineSource.RECEIVER) goto L11;
            Object r9 = new PageEvent.LoadStateUpdate(this.$sourceStates$inlined.snapshot(), r14);
        L26:
            r7 = (PageEvent) ZeusTransformUtils.preCheckCast(r9, PageEvent.class, "com.obric.memorydata.plugin");
        L27:
            Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.send(r7, r10) != r1) goto L31;
            return r1;
        L11:
            if (ZeusTransformUtils.instanceOf(r7, PageEvent.Insert.class) == false) goto L14;
            this.$sourceStates$inlined.set(((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r7, PageEvent.Insert.class, "com.obric.memorydata.plugin")).getSourceLoadStates());
            r9 = PageEvent.Insert.copy$default((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r7, PageEvent.Insert.class, "com.obric.memorydata.plugin"), null, null, 0, 0, ((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r7, PageEvent.Insert.class, "com.obric.memorydata.plugin")).getSourceLoadStates(), r14, 15, null);
            goto L26
        L14:
            if (ZeusTransformUtils.instanceOf(r7, PageEvent.Drop.class) == false) goto L17;
            this.$sourceStates$inlined.set(((PageEvent.Drop) ZeusTransformUtils.preCheckCast(r7, PageEvent.Drop.class, "com.obric.memorydata.plugin")).getLoadType(), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
            goto L27
        L17:
            if (ZeusTransformUtils.instanceOf(r7, PageEvent.LoadStateUpdate.class) == false) goto L20;
            this.$sourceStates$inlined.set(((PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r7, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin")).getSource());
            r9 = new PageEvent.LoadStateUpdate(((PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r7, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin")).getSource(), r14);
            goto L26
        L20:
            if (ZeusTransformUtils.instanceOf(r7, PageEvent.StaticList.class) == false) goto L24;
            throw new IllegalStateException("Paging generated an event to display a static list that\n originated from a paginated source. If you see this\n exception, it is most likely a bug in the library.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
        L24:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ i $flow;
        final /* synthetic */ AtomicInteger $incompleteFlows;
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T1", "T2", "R", EventBody.KEY_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {
            final /* synthetic */ int $index;
            final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;

            /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            static final class C00351 extends ContinuationImpl {
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ AnonymousClass1 this$0;

                C00351(AnonymousClass1 r3, Continuation r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    super(r5);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r3) {
                    this.result = r3;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
                }
            }

            public AnonymousClass1(UnbatchedFlowCombiner r1, int r2) {
                this.$unbatchedFlowCombiner = r1;
                this.$index = r2;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation<? super Unit> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, C00351.class) == false) goto L7;
                C00351 r0 = (C00351) ZeusTransformUtils.preCheckCast(r8, C00351.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = r0.label;
                if (r2 == 0) goto L16;
                if (r2 == 1) goto L15;
                if (r2 != 2) goto L14;
                ResultKt.throwOnFailure(r9);
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r9);
            L19:
                r0.label = 2;
                if (dg.a(r0) != r1) goto L23;
                return r1;
            L16:
                ResultKt.throwOnFailure(r9);
                UnbatchedFlowCombiner r10 = this.$unbatchedFlowCombiner;
                int r5 = this.$index;
                r0.label = 1;
                if (r10.onNext(r5, r6, r0) != r1) goto L19;
                return r1;
            L7:
                r0 = new C00351(this, r8);
                goto L8
            }
        }

        public AnonymousClass2(i r3, AtomicInteger r4, SimpleProducerScope r5, UnbatchedFlowCombiner r6, int r7, Continuation r8) {
            i r9 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            SimpleProducerScope<PageEvent<Value>> r10 = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r5, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$flow = r9;
            this.$incompleteFlows = r4;
            this.$unbatchedFlowCombiner = r6;
            this.$index = r7;
            this.$$this$simpleChannelFlow = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
        L15:
            if (this.$incompleteFlows.decrementAndGet() != 0) goto L19;
            z.a.a((z) ZeusTransformUtils.preCheckCast(this.$$this$simpleChannelFlow, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            i r9 = this.$flow;     // Catch: Throwable -> L7
            j r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$unbatchedFlowCombiner, this.$index), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r9.collect(r2, r5) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            if (this.$incompleteFlows.decrementAndGet() != 0) goto L23;
            z.a.a((z) ZeusTransformUtils.preCheckCast(this.$$this$simpleChannelFlow, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        L23:
            throw th;
        }
    }

    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(i r3, i r4, Continuation r5, MutableLoadStateCollection r6) {
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_combineWithoutBatching = r7;
        this.$otherFlow = r8;
        this.$sourceStates$inlined = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 r0 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$this_combineWithoutBatching, this.$otherFlow, r7, this.$sourceStates$inlined);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> r3, Continuation<? super Unit> r4) {
        return ((PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((SimpleProducerScope) ZeusTransformUtils.preCheckCast(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r26);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        SimpleProducerScope r3 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        int r13 = 2;
        AtomicInteger r4 = new AtomicInteger(2);
        UnbatchedFlowCombiner r14 = new UnbatchedFlowCombiner((Function4) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, null, this.$sourceStates$inlined), Function4.class, "com.obric.memorydata.plugin"));
        final kotlinx.coroutines.z r15 = ca.a(null, 1, null);
        i[] r12 = {this.$this_combineWithoutBatching, this.$otherFlow};
        int r11 = 0;
        int r16 = 0;
    L9:
        if (r11 >= r13) goto L11;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r15, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12[r11], r4, r3, r14, r16, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        r11 = r11 + 1;
        r12 = r12;
        r16 = r16 + 1;
        r13 = 2;
        goto L9
    L11:
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r15), Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r3.awaitClose(r5, r6) != r1) goto L15;
        return r1;
    }
}
