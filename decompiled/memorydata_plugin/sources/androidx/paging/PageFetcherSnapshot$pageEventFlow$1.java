package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.y;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.sync.a;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 1, 2, 2, 2}, l = {645, 168, 657}, m = "invokeSuspend", n = {"$this$cancelableChannelFlow", "it", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$cancelableChannelFlow", "$this$cancelableChannelFlow", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2"})
final class PageFetcherSnapshot$pageEventFlow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/PageEvent;", "emit", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass1<T> implements j {
            final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;

            AnonymousClass1(SimpleProducerScope<PageEvent<Value>> r3) {
                this.$$this$cancelableChannelFlow = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            }

            public final Object emit(PageEvent<Value> r5, Continuation<? super Unit> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r7, PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.class) == false) goto L7;
                PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 r0 = (PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) ZeusTransformUtils.preCheckCast(r7, PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r8 = r0.result;
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = r0.label;
                if (r2 == 0) goto L15;
                if (r2 != 1) goto L14;
                ResultKt.throwOnFailure(r8);     // Catch: ClosedSendChannelException -> L21
            L22:
                goto L20
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r8);
                SimpleProducerScope<PageEvent<Value>> r4 = this.$$this$cancelableChannelFlow;     // Catch: ClosedSendChannelException -> L21
                r0.label = 1;     // Catch: ClosedSendChannelException -> L21
                if (r4.send(r5, r0) != r1) goto L22;
                return r1;
            L20:
                return Unit.INSTANCE;
            L7:
                r0 = new PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1(this, r7);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return emit((PageEvent) ZeusTransformUtils.preCheckCast(r3, PageEvent.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass2(PageFetcherSnapshot<Key, Value> r3, SimpleProducerScope<PageEvent<Value>> r4, Continuation<? super AnonymousClass2> r5) {
            SimpleProducerScope<PageEvent<Value>> r6 = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r4, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$$this$cancelableChannelFlow = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$$this$cancelableChannelFlow, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            i r7 = k.b((y) ZeusTransformUtils.preCheckCast(PageFetcherSnapshot.access$getPageEventCh$p(this.this$0), y.class, "com.obric.memorydata.plugin"));
            j r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$$this$cancelableChannelFlow), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.channels.i<Unit> $retryChannel;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        AnonymousClass3(PageFetcherSnapshot<Key, Value> r3, kotlinx.coroutines.channels.i<Unit> r4, Continuation<? super AnonymousClass3> r5) {
            kotlinx.coroutines.channels.i<Unit> r6 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$retryChannel = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$retryChannel, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            i r7 = PageFetcherSnapshot.access$getRetryFlow$p(this.this$0);
            final kotlinx.coroutines.channels.i<Unit> r3 = this.$retryChannel;
            j r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.channels.i<Unit> $retryChannel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "emit", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass1<T> implements j {
            final /* synthetic */ al $$this$launch;
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1$WhenMappings */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r0 = new int[LoadType.values().length];
                    r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
                L4:
                    $EnumSwitchMapping$0 = r0;
                }
            }

            AnonymousClass1(PageFetcherSnapshot<Key, Value> r3, al r4) {
                al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$$this$launch = r5;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return emit((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), r5);
            }

            public final Object emit(Unit r18, Continuation<? super Unit> r19) {
                AnonymousClass1<T> r0 = this;
                Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r1, PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.class) == false) goto L7;
                PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 r3 = (PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) ZeusTransformUtils.preCheckCast(r1, PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
                r3.label -= Integer.MIN_VALUE;
            L8:
                Object r2 = r3.result;
                Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(r3.label) {
                    case 0: goto L42;
                    case 1: goto L41;
                    case 2: goto L40;
                    case 3: goto L35;
                    case 4: goto L34;
                    case 5: goto L33;
                    case 6: goto L31;
                    case 7: goto L30;
                    case 8: goto L25;
                    case 9: goto L24;
                    case 10: goto L23;
                    case 11: goto L21;
                    case 12: goto L20;
                    case 13: goto L15;
                    case 14: goto L14;
                    case 15: goto L13;
                    case 16: goto L12;
                    default: goto L11;
                };
            L12:
                a r5 = (a) ZeusTransformUtils.preCheckCast(r3.L$3, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r6 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                al r7 = (al) ZeusTransformUtils.preCheckCast(r3.L$1, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r8 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                a r9 = r5;
            L208:
                LoadState r10 = PageFetcherSnapshotState.Holder.access$getState$p(r6).getSourceLoadStates$paging_common().get(LoadType.REFRESH);     // Catch: Throwable -> L187
                r9.b(null);
                if (ZeusTransformUtils.instanceOf(r10, LoadState.Error.class) == true) goto L194;
                PageFetcherSnapshot.access$startConsumingHints(r8, r7);
            L194:
                return Unit.INSTANCE;
            L187:
                th = move-exception;
                r9.b(null);
                throw th;
            L13:
                LoadType r11 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
                r7 = (al) ZeusTransformUtils.preCheckCast(r3.L$1, al.class, "com.obric.memorydata.plugin");
                r8 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L178:
                if (r11 != LoadType.REFRESH) goto L194;
                PageFetcherSnapshotState.Holder r12 = PageFetcherSnapshot.access$getStateHolder$p(r8);
                r9 = PageFetcherSnapshotState.Holder.access$getLock$p(r12);
                r3.L$0 = r8;
                r3.L$1 = r7;
                r3.L$2 = r12;
                r3.L$3 = r9;
                r3.label = 16;
                if (r9.a(null, r3) != r4) goto L182;
                return r4;
            L182:
                r6 = r12;
                goto L208
            L14:
                PageFetcherSnapshot r13 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$6, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadType r14 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$5, LoadType.class, "com.obric.memorydata.plugin");
                a r15 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r16 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$3, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r17 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
                al r110 = (al) ZeusTransformUtils.preCheckCast(r3.L$1, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r111 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L222:
                ViewportHint r20 = (ViewportHint) ZeusTransformUtils.preCheckCast(PageFetcherSnapshotState.Holder.access$getState$p(r16).getFailedHintsByLoadType$paging_common().get(r17), ViewportHint.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L190
                r15.b(null);
                ViewportHint r21 = r20;
                LoadType r22 = r14;
                r14 = r17;
                PageFetcherSnapshot r23 = r13;
                r13 = r111;
            L173:
                r3.L$0 = r13;
                r3.L$1 = r110;
                r3.L$2 = r14;
                r3.L$3 = null;
                r3.L$4 = null;
                r3.L$5 = null;
                r3.L$6 = null;
                r3.label = 15;
                if (PageFetcherSnapshot.access$retryLoadError(r23, r22, r21, r3) != r4) goto L176;
                return r4;
            L176:
                r8 = r13;
                r11 = r14;
                r7 = r110;
            L190:
                th = move-exception;
                r15.b(null);
                throw th;
            L15:
                a r24 = (a) ZeusTransformUtils.preCheckCast(r3.L$3, a.class, "com.obric.memorydata.plugin");
                LoadType r25 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
                al r26 = (al) ZeusTransformUtils.preCheckCast(r3.L$1, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r27 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L18
            L157:
                Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L18
                r24.b(null);
                r14 = r25;
                r110 = r26;
                r13 = r27;
            L165:
                if (WhenMappings.$EnumSwitchMapping$0[r14.ordinal()] != 1) goto L167;
                r23 = r13;
                r22 = r14;
                r21 = null;
                goto L173
            L167:
                r16 = PageFetcherSnapshot.access$getStateHolder$p(r13);
                r15 = PageFetcherSnapshotState.Holder.access$getLock$p(r16);
                r3.L$0 = r13;
                r3.L$1 = r110;
                r3.L$2 = r14;
                r3.L$3 = r16;
                r3.L$4 = r15;
                r3.L$5 = r14;
                r3.L$6 = r13;
                r3.label = 14;
                if (r15.a(null, r3) != r4) goto L170;
                return r4;
            L170:
                r111 = r13;
                r17 = r14;
            L18:
                th = th;
            L161:
                r24.b(null);
                throw th;
            L20:
                a r29 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r30 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$3, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r31 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
                al r32 = (al) ZeusTransformUtils.preCheckCast(r3.L$1, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r112 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                a r33 = r29;
                r25 = r31;
                r26 = r32;
            L212:
                PageFetcherSnapshotState r34 = PageFetcherSnapshotState.Holder.access$getState$p(r30);     // Catch: Throwable -> L159
                r3.L$0 = r112;     // Catch: Throwable -> L159
                r3.L$1 = r26;     // Catch: Throwable -> L159
                r3.L$2 = r25;     // Catch: Throwable -> L159
                r3.L$3 = r33;     // Catch: Throwable -> L159
                r3.L$4 = null;     // Catch: Throwable -> L159
                r3.label = 13;     // Catch: Throwable -> L159
                if (PageFetcherSnapshot.access$setLoading(r112, r34, r25, r3) != r4) goto L156;
                return r4;
            L156:
                r24 = r33;
                r27 = r112;
            L159:
                th = th;
                r24 = r33;
                goto L161
            L21:
                a r35 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r36 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$3, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                al r37 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r38 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r113 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L22:
                a r39 = r35;
                LoadState r40 = PageFetcherSnapshotState.Holder.access$getState$p(r36).getSourceLoadStates$paging_common().get(LoadType.REFRESH);     // Catch: Throwable -> L138
                r39.b(null);
                if (ZeusTransformUtils.instanceOf(r40, LoadState.Error.class) == true) goto L141;
                PageFetcherSnapshot.access$startConsumingHints(r38, r37);
            L141:
                al r41 = r37;
                PageFetcherSnapshot r42 = r38;
                LoadStates r43 = r113;
            L145:
                LoadType r44 = LoadType.APPEND;
                if (ZeusTransformUtils.instanceOf(r43.getAppend(), LoadState.Error.class) == false) goto L194;
                if (r44 == LoadType.REFRESH) goto L163;
                PageFetcherSnapshotState.Holder r45 = PageFetcherSnapshot.access$getStateHolder$p(r42);
                r33 = PageFetcherSnapshotState.Holder.access$getLock$p(r45);
                r3.L$0 = r42;
                r3.L$1 = r41;
                r3.L$2 = r44;
                r3.L$3 = r45;
                r3.L$4 = r33;
                r3.label = 12;
                if (r33.a(null, r3) != r4) goto L152;
                return r4;
            L152:
                r112 = r42;
                r30 = r45;
                r26 = r41;
                r25 = r44;
                goto L212
            L163:
                r110 = r41;
                r13 = r42;
                r14 = r44;
            L138:
                th = move-exception;
                r39.b(null);
                throw th;
            L23:
                LoadType r46 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r47 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r48 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r49 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                r113 = r49;
                r38 = r48;
                r37 = r47;
            L130:
                if (r46 != LoadType.REFRESH) goto L141;
                r36 = PageFetcherSnapshot.access$getStateHolder$p(r38);
                r35 = PageFetcherSnapshotState.Holder.access$getLock$p(r36);
                r3.L$0 = r113;
                r3.L$1 = r38;
                r3.L$2 = r37;
                r3.L$3 = r36;
                r3.L$4 = r35;
                r3.label = 11;
                if (r35.a(null, r3) != r4) goto L22;
                return r4;
            L24:
                PageFetcherSnapshot r50 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$7, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadType r51 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$6, LoadType.class, "com.obric.memorydata.plugin");
                a r52 = (a) ZeusTransformUtils.preCheckCast(r3.L$5, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r53 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r114 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r115 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r116 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r117 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L214:
                ViewportHint r54 = (ViewportHint) ZeusTransformUtils.preCheckCast(PageFetcherSnapshotState.Holder.access$getState$p(r53).getFailedHintsByLoadType$paging_common().get(r114), ViewportHint.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L142
                r52.b(null);
                ViewportHint r55 = r54;
                LoadType r56 = r51;
                r51 = r114;
                PageFetcherSnapshot r57 = r50;
                r50 = r116;
            L125:
                r3.L$0 = r117;
                r3.L$1 = r50;
                r3.L$2 = r115;
                r3.L$3 = r51;
                r3.L$4 = null;
                r3.L$5 = null;
                r3.L$6 = null;
                r3.L$7 = null;
                r3.label = 10;
                if (PageFetcherSnapshot.access$retryLoadError(r57, r56, r55, r3) != r4) goto L128;
                return r4;
            L128:
                r38 = r50;
                r46 = r51;
                r37 = r115;
                r113 = r117;
            L142:
                th = move-exception;
                r52.b(null);
                throw th;
            L25:
                a r58 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                LoadType r59 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r60 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r61 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r118 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L28
            L109:
                Unit r62 = Unit.INSTANCE;     // Catch: Throwable -> L28
                r58.b(null);
                r51 = r59;
                r115 = r60;
                r50 = r61;
                r117 = r118;
            L117:
                if (WhenMappings.$EnumSwitchMapping$0[r51.ordinal()] != 1) goto L119;
                r57 = r50;
                r56 = r51;
                r55 = null;
                goto L125
            L119:
                r53 = PageFetcherSnapshot.access$getStateHolder$p(r50);
                r52 = PageFetcherSnapshotState.Holder.access$getLock$p(r53);
                r3.L$0 = r117;
                r3.L$1 = r50;
                r3.L$2 = r115;
                r3.L$3 = r51;
                r3.L$4 = r53;
                r3.L$5 = r52;
                r3.L$6 = r51;
                r3.L$7 = r50;
                r3.label = 9;
                if (r52.a(null, r3) != r4) goto L122;
                return r4;
            L122:
                r116 = r50;
                r114 = r51;
            L28:
                th = th;
            L113:
                r58.b(null);
                throw th;
            L30:
                a r63 = (a) ZeusTransformUtils.preCheckCast(r3.L$5, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r64 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r65 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r66 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r119 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r120 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                r43 = r120;
                a r121 = r63;
                r59 = r65;
                r60 = r66;
                r61 = r119;
            L218:
                PageFetcherSnapshotState r67 = PageFetcherSnapshotState.Holder.access$getState$p(r64);     // Catch: Throwable -> L111
                r3.L$0 = r43;     // Catch: Throwable -> L111
                r3.L$1 = r61;     // Catch: Throwable -> L111
                r3.L$2 = r60;     // Catch: Throwable -> L111
                r3.L$3 = r59;     // Catch: Throwable -> L111
                r3.L$4 = r121;     // Catch: Throwable -> L111
                r3.L$5 = null;     // Catch: Throwable -> L111
                r3.label = 8;     // Catch: Throwable -> L111
                if (PageFetcherSnapshot.access$setLoading(r61, r67, r59, r3) != r4) goto L108;
                return r4;
            L108:
                r58 = r121;
                r118 = r43;
            L111:
                th = th;
                r58 = r121;
                goto L113
            L31:
                a r68 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r69 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$3, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                al r70 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r71 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r122 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L32:
                a r72 = r68;
                LoadState r73 = PageFetcherSnapshotState.Holder.access$getState$p(r69).getSourceLoadStates$paging_common().get(LoadType.REFRESH);     // Catch: Throwable -> L90
                r72.b(null);
                if (ZeusTransformUtils.instanceOf(r73, LoadState.Error.class) == true) goto L93;
                PageFetcherSnapshot.access$startConsumingHints(r71, r70);
            L93:
                r41 = r70;
                r42 = r71;
                r43 = r122;
            L97:
                LoadType r74 = LoadType.PREPEND;
                if (ZeusTransformUtils.instanceOf(r43.getPrepend(), LoadState.Error.class) == false) goto L145;
                if (r74 == LoadType.REFRESH) goto L115;
                PageFetcherSnapshotState.Holder r75 = PageFetcherSnapshot.access$getStateHolder$p(r42);
                r121 = PageFetcherSnapshotState.Holder.access$getLock$p(r75);
                r3.L$0 = r43;
                r3.L$1 = r42;
                r3.L$2 = r41;
                r3.L$3 = r74;
                r3.L$4 = r75;
                r3.L$5 = r121;
                r3.label = 7;
                if (r121.a(null, r3) != r4) goto L104;
                return r4;
            L104:
                r60 = r41;
                r59 = r74;
                r61 = r42;
                r64 = r75;
                goto L218
            L115:
                r115 = r41;
                r117 = r43;
                r50 = r42;
                r51 = r74;
            L90:
                th = move-exception;
                r72.b(null);
                throw th;
            L33:
                LoadType r76 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r77 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r78 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r79 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                r122 = r79;
                r71 = r78;
                r70 = r77;
            L82:
                if (r76 != LoadType.REFRESH) goto L93;
                r69 = PageFetcherSnapshot.access$getStateHolder$p(r71);
                r68 = PageFetcherSnapshotState.Holder.access$getLock$p(r69);
                r3.L$0 = r122;
                r3.L$1 = r71;
                r3.L$2 = r70;
                r3.L$3 = r69;
                r3.L$4 = r68;
                r3.label = 6;
                if (r68.a(null, r3) != r4) goto L32;
                return r4;
            L34:
                PageFetcherSnapshot r80 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$7, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadType r81 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$6, LoadType.class, "com.obric.memorydata.plugin");
                a r82 = (a) ZeusTransformUtils.preCheckCast(r3.L$5, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r83 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r123 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r124 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r125 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r126 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
            L210:
                ViewportHint r84 = (ViewportHint) ZeusTransformUtils.preCheckCast(PageFetcherSnapshotState.Holder.access$getState$p(r83).getFailedHintsByLoadType$paging_common().get(r123), ViewportHint.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94
                r82.b(null);
                ViewportHint r85 = r84;
                LoadType r86 = r81;
                r81 = r123;
                PageFetcherSnapshot r87 = r80;
                r80 = r125;
            L77:
                r3.L$0 = r126;
                r3.L$1 = r80;
                r3.L$2 = r124;
                r3.L$3 = r81;
                r3.L$4 = null;
                r3.L$5 = null;
                r3.L$6 = null;
                r3.L$7 = null;
                r3.label = 5;
                if (PageFetcherSnapshot.access$retryLoadError(r87, r86, r85, r3) != r4) goto L80;
                return r4;
            L80:
                r71 = r80;
                r76 = r81;
                r70 = r124;
                r122 = r126;
            L94:
                th = move-exception;
                r82.b(null);
                throw th;
            L35:
                a r88 = (a) ZeusTransformUtils.preCheckCast(r3.L$4, a.class, "com.obric.memorydata.plugin");
                LoadType r89 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r90 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r91 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r127 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L38
            L61:
                Unit r92 = Unit.INSTANCE;     // Catch: Throwable -> L38
                r88.b(null);
                r81 = r89;
                r124 = r90;
                r80 = r91;
                r126 = r127;
            L69:
                if (WhenMappings.$EnumSwitchMapping$0[r81.ordinal()] != 1) goto L71;
                r87 = r80;
                r86 = r81;
                r85 = null;
                goto L77
            L71:
                r83 = PageFetcherSnapshot.access$getStateHolder$p(r80);
                r82 = PageFetcherSnapshotState.Holder.access$getLock$p(r83);
                r3.L$0 = r126;
                r3.L$1 = r80;
                r3.L$2 = r124;
                r3.L$3 = r81;
                r3.L$4 = r83;
                r3.L$5 = r82;
                r3.L$6 = r81;
                r3.L$7 = r80;
                r3.label = 4;
                if (r82.a(null, r3) != r4) goto L74;
                return r4;
            L74:
                r125 = r80;
                r123 = r81;
            L38:
                th = th;
            L65:
                r88.b(null);
                throw th;
            L40:
                a r93 = (a) ZeusTransformUtils.preCheckCast(r3.L$5, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r94 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                LoadType r95 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$3, LoadType.class, "com.obric.memorydata.plugin");
                al r96 = (al) ZeusTransformUtils.preCheckCast(r3.L$2, al.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r128 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                LoadStates r129 = (LoadStates) ZeusTransformUtils.preCheckCast(r3.L$0, LoadStates.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                r43 = r129;
                a r130 = r93;
                r89 = r95;
                r90 = r96;
                r91 = r128;
            L216:
                PageFetcherSnapshotState r97 = PageFetcherSnapshotState.Holder.access$getState$p(r94);     // Catch: Throwable -> L63
                r3.L$0 = r43;     // Catch: Throwable -> L63
                r3.L$1 = r91;     // Catch: Throwable -> L63
                r3.L$2 = r90;     // Catch: Throwable -> L63
                r3.L$3 = r89;     // Catch: Throwable -> L63
                r3.L$4 = r130;     // Catch: Throwable -> L63
                r3.L$5 = null;     // Catch: Throwable -> L63
                r3.label = 3;     // Catch: Throwable -> L63
                if (PageFetcherSnapshot.access$setLoading(r91, r97, r89, r3) != r4) goto L60;
                return r4;
            L60:
                r88 = r130;
                r127 = r43;
            L63:
                th = th;
                r88 = r130;
                goto L65
            L41:
                a r98 = (a) ZeusTransformUtils.preCheckCast(r3.L$3, a.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshot r99 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r3.L$2, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
                PageFetcherSnapshotState.Holder r100 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r3.L$1, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
                AnonymousClass1<T> r101 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r3.L$0, AnonymousClass1.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r2);
                a r102 = r98;
                r0 = r101;
            L206:
                PageFetcherSnapshotState r103 = PageFetcherSnapshotState.Holder.access$getState$p(r100);     // Catch: Throwable -> L195
                Pair r104 = TuplesKt.to(r103.getSourceLoadStates$paging_common().snapshot(), r103.currentPagingState$paging_common(PageFetcherSnapshot.access$getHintHandler$p(r99).getLastAccessHint()));     // Catch: Throwable -> L195
                r102.b(null);
                r43 = (LoadStates) ZeusTransformUtils.preCheckCast(r104.component1(), LoadStates.class, "com.obric.memorydata.plugin");
                PagingState r105 = (PagingState) ZeusTransformUtils.preCheckCast(r104.component2(), PagingState.class, "com.obric.memorydata.plugin");
                RemoteMediatorConnection r106 = r0.this$0.getRemoteMediatorConnection();
                if (r106 == null) goto L49;
                r106.retryFailed(r105);
                Unit r107 = Unit.INSTANCE;
            L49:
                r42 = r0.this$0;
                r41 = r0.$$this$launch;
                LoadType r108 = LoadType.REFRESH;
                if (ZeusTransformUtils.instanceOf(r43.getRefresh(), LoadState.Error.class) == false) goto L97;
                if (r108 == LoadType.REFRESH) goto L67;
                PageFetcherSnapshotState.Holder r109 = PageFetcherSnapshot.access$getStateHolder$p(r42);
                r130 = PageFetcherSnapshotState.Holder.access$getLock$p(r109);
                r3.L$0 = r43;
                r3.L$1 = r42;
                r3.L$2 = r41;
                r3.L$3 = r108;
                r3.L$4 = r109;
                r3.L$5 = r130;
                r3.label = 2;
                if (r130.a(null, r3) != r4) goto L56;
                return r4;
            L56:
                r90 = r41;
                r89 = r108;
                r91 = r42;
                r94 = r109;
                goto L216
            L67:
                r124 = r41;
                r126 = r43;
                r80 = r42;
                r81 = r108;
            L195:
                th = move-exception;
                r102.b(null);
                throw th;
            L42:
                ResultKt.throwOnFailure(r2);
                r100 = PageFetcherSnapshot.access$getStateHolder$p(r0.this$0);
                r99 = r0.this$0;
                r102 = PageFetcherSnapshotState.Holder.access$getLock$p(r100);
                r3.L$0 = r0;
                r3.L$1 = r100;
                r3.L$2 = r99;
                r3.L$3 = r102;
                r3.label = 1;
                if (r102.a(null, r3) != r4) goto L206;
                return r4;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L7:
                r3 = new PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(r0, r1);
                goto L8
            }
        }

        AnonymousClass4(kotlinx.coroutines.channels.i<Unit> r3, PageFetcherSnapshot<Key, Value> r4, Continuation<? super AnonymousClass4> r5) {
            kotlinx.coroutines.channels.i<Unit> r6 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$retryChannel = r6;
            this.this$0 = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass4 r0 = new AnonymousClass4(this.$retryChannel, this.this$0, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            al r8 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            i r2 = k.b((y) ZeusTransformUtils.preCheckCast(this.$retryChannel, y.class, "com.obric.memorydata.plugin"));
            j r9 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r8), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r2.collect(r9, r3) != r0) goto L12;
            return r0;
        }
    }

    PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot<Key, Value> r3, Continuation<? super PageFetcherSnapshot$pageEventFlow$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot$pageEventFlow$1 r0 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> r3, Continuation<? super Unit> r4) {
        return ((PageFetcherSnapshot$pageEventFlow$1) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageFetcherSnapshot$pageEventFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((SimpleProducerScope) ZeusTransformUtils.preCheckCast(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$2, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder r4 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$1, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        SimpleProducerScope r5 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L49:
        LoadState r6 = PageFetcherSnapshotState.Holder.access$getState$p(r4).getSourceLoadStates$paging_common().get(LoadType.REFRESH);     // Catch: Throwable -> L42
        r3.b(null);
        if (ZeusTransformUtils.instanceOf(r6, LoadState.Error.class) == true) goto L41;
        PageFetcherSnapshot.access$startConsumingHints(this.this$0, (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.memorydata.plugin"));
    L41:
        return Unit.INSTANCE;
    L42:
        th = move-exception;
        r3.b(null);
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        SimpleProducerScope r7 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L32:
        PageFetcherSnapshotState.Holder r8 = PageFetcherSnapshot.access$getStateHolder$p(this.this$0);
        a r9 = PageFetcherSnapshotState.Holder.access$getLock$p(r8);
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r7;
        this.L$1 = r8;
        this.L$2 = r9;
        this.label = 3;
        if (r9.a(null, r10) != r1) goto L35;
        return r1;
    L35:
        r5 = r7;
        r4 = r8;
        r3 = r9;
        goto L49
    L11:
        a r11 = (a) ZeusTransformUtils.preCheckCast(this.L$3, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder r12 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        RemoteMediatorConnection r13 = (RemoteMediatorConnection) ZeusTransformUtils.preCheckCast(this.L$1, RemoteMediatorConnection.class, "com.obric.memorydata.plugin");
        SimpleProducerScope r14 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L47:
        PagingState r15 = PageFetcherSnapshotState.Holder.access$getState$p(r12).currentPagingState$paging_common(null);     // Catch: Throwable -> L24
        r11.b(null);
    L27:
        r13.requestRefreshIfAllowed(r15);
    L28:
        PageFetcherSnapshot<Key, Value> r16 = this.this$0;
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r14;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (PageFetcherSnapshot.access$doInitialLoad(r16, r18) != r1) goto L31;
        return r1;
    L31:
        r7 = r14;
    L24:
        th = move-exception;
        r11.b(null);
        throw th;
    L12:
        ResultKt.throwOnFailure(r17);
        r14 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        if (PageFetcherSnapshot.access$getPageEventChCollected$p(this.this$0).compareAndSet(false, true) == false) goto L46;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r14, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.channels.i r19 = l.a(0, null, null, 6, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r14, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r19, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r14, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r19, this.this$0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r13 = this.this$0.getRemoteMediatorConnection();
        if (r13 == null) goto L28;
        PageFetcherSnapshot<Key, Value> r20 = this.this$0;
        r15 = PageFetcherSnapshot.access$getPreviousPagingState$p(r20);
        if (r15 != null) goto L27;
        PageFetcherSnapshotState.Holder r21 = PageFetcherSnapshot.access$getStateHolder$p(r20);
        a r110 = PageFetcherSnapshotState.Holder.access$getLock$p(r21);
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r21;
        this.L$3 = r110;
        this.label = 1;
        if (r110.a(null, this) != r1) goto L21;
        return r1;
    L21:
        r12 = r21;
        r11 = r110;
        goto L47
    L46:
        throw new IllegalStateException("Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?".toString());
    }
}
