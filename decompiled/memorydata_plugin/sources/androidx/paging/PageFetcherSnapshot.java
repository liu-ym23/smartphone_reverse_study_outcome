package androidx.paging;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002By\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u000bJ\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0011\u0010.\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J!\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J%\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00100\u001a\u0002012\b\u00107\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u00108J5\u00109\u001a\u00020:2\u0006\u00100\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00018\u00002\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010=H\u0002¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u000bH\u0002J#\u0010@\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\b\u0010)\u001a\u0004\u0018\u00010*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ#\u0010B\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020C0\n2\u0006\u00100\u001a\u000201H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010DJ7\u0010E\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F2\u0006\u00100\u001a\u0002012\u0006\u0010G\u001a\u00020C2\u0006\u0010H\u001a\u00020CH\u0002¢\u0006\u0002\u0010IJ1\u0010J\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F2\u0006\u00100\u001a\u0002012\u0006\u0010K\u001a\u00020LH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010MJ)\u0010N\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F2\u0006\u00100\u001a\u000201H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010OJ\f\u0010P\u001a\u00020\u000b*\u00020QH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006R"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "Key", "", "Value", "initialKey", "pagingSource", "Landroidx/paging/PagingSource;", "config", "Landroidx/paging/PagingConfig;", "retryFlow", "Lkotlinx/coroutines/flow/Flow;", "", "remoteMediatorConnection", "Landroidx/paging/RemoteMediatorConnection;", "previousPagingState", "Landroidx/paging/PagingState;", "jumpCallback", "Lkotlin/Function0;", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;Landroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V", "hintHandler", "Landroidx/paging/HintHandler;", "getInitialKey$paging_common", "()Ljava/lang/Object;", "Ljava/lang/Object;", "pageEventCh", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "pageEventChCollected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventChannelFlowJob", "Lkotlinx/coroutines/CompletableJob;", "pageEventFlow", "getPageEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "getPagingSource$paging_common", "()Landroidx/paging/PagingSource;", "getRemoteMediatorConnection", "()Landroidx/paging/RemoteMediatorConnection;", "stateHolder", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "accessHint", "viewportHint", "Landroidx/paging/ViewportHint;", IslandSession.REOPEN_VALUE_CLOSE, "currentPagingState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doInitialLoad", "doLoad", "loadType", "Landroidx/paging/LoadType;", "generationalHint", "Landroidx/paging/GenerationalViewportHint;", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadParams", "Landroidx/paging/PagingSource$LoadParams;", "key", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "loadResultLog", "", "loadKey", "result", "Landroidx/paging/PagingSource$LoadResult;", "(Landroidx/paging/LoadType;Ljava/lang/Object;Landroidx/paging/PagingSource$LoadResult;)Ljava/lang/String;", "onInvalidLoad", "retryLoadError", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectAsGenerationalViewportHints", "", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextLoadKeyOrNull", "Landroidx/paging/PageFetcherSnapshotState;", "generationId", "presentedItemsBeyondAnchor", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "setError", "error", "Landroidx/paging/LoadState$Error;", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLoading", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConsumingHints", "Lkotlinx/coroutines/CoroutineScope;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PageFetcherSnapshot<Key, Value> {
    private final PagingConfig config;
    private final HintHandler hintHandler;
    private final Key initialKey;
    private final Function0<Unit> jumpCallback;
    private final i<PageEvent<Value>> pageEventCh;
    private final AtomicBoolean pageEventChCollected;
    private final z pageEventChannelFlowJob;
    private final kotlinx.coroutines.flow.i<PageEvent<Value>> pageEventFlow;
    private final PagingSource<Key, Value> pagingSource;
    private final PagingState<Key, Value> previousPagingState;
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    private final kotlinx.coroutines.flow.i<Unit> retryFlow;
    private final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/GenerationalViewportHint;", "Key", "", "Value", "previous", "next"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function3<GenerationalViewportHint, GenerationalViewportHint, Continuation<? super GenerationalViewportHint>, Object> {
        final /* synthetic */ LoadType $loadType;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass3(LoadType r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$loadType = r3;
            super(3, r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(GenerationalViewportHint r3, GenerationalViewportHint r4, Continuation<? super GenerationalViewportHint> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.$loadType, r6);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(GenerationalViewportHint r3, GenerationalViewportHint r4, Continuation<? super GenerationalViewportHint> r5) {
            return invoke2((GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r3, GenerationalViewportHint.class, "com.obric.memorydata.plugin"), (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r4, GenerationalViewportHint.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L9;
            ResultKt.throwOnFailure(r4);
            GenerationalViewportHint r5 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(this.L$0, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
            GenerationalViewportHint r0 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(this.L$1, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
            if (PageFetcherSnapshotKt.shouldPrioritizeOver(r0, r5, this.$loadType) == true) goto L7;
            return r5;
        L7:
            return r0;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$currentPagingState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {645}, m = "currentPagingState", n = {"this", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C09441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        C09441(PageFetcherSnapshot<Key, Value> r3, Continuation<? super C09441> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.currentPagingState((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doInitialLoad$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8}, l = {645, 284, 290, 667, 689, 326, 711, 733, 354}, m = "doInitialLoad", n = {"this", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "$this$withLock_u24default$iv$iv", "this", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C09451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        C09451(PageFetcherSnapshot<Key, Value> r3, Continuation<? super C09451> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.access$doInitialLoad(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$doLoad$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {646, 658, 415, 424, 680, 722, 472, 744, 495, 521, 756}, m = "doLoad", n = {"this", "loadType", "generationalHint", "itemsLoaded", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", TrackerImpl.PARAMS, "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", TrackerImpl.PARAMS, "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "loadType", "generationalHint", "$this$withLock_u24default$iv$iv", "state", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", TrackerImpl.PARAMS, "result", "dropType", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", TrackerImpl.PARAMS, "result", "$this$withLock_u24default$iv$iv", "state", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", TrackerImpl.PARAMS, "result", "$this$withLock_u24default$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "this_$iv", "$this$withLock_u24default$iv$iv", "endsPrepend", "endsAppend"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"})
    static final class C09461 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        C09461(PageFetcherSnapshot<Key, Value> r3, Continuation<? super C09461> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot.access$doLoad(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1", f = "PageFetcherSnapshot.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    static final class C09471 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        C09471(PageFetcherSnapshot<Key, Value> r3, Continuation<? super C09471> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09471(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09471) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09471.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            ViewportHint r9 = (ViewportHint) ZeusTransformUtils.preCheckCast(r8, ViewportHint.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L22;
            PageFetcherSnapshot<Key, Value> r2 = this.this$0;
            Logger r3 = LoggerKt.getLOGGER();
            if (r3 != null) goto L16;
        L18:
            if (r4 == false) goto L20;
            r3.log(3, "Jump triggered on PagingSource " + r2.getPagingSource$paging_common() + " by " + r9, null);
        L20:
            PageFetcherSnapshot.access$getJumpCallback$p(this.this$0).invoke();
            goto L22
        L16:
            if (r3.isLoggable(3) != true) goto L18;
            r4 = true;
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.i r10 = k.a(new kotlinx.coroutines.flow.i[]{PageFetcherSnapshot.access$getHintHandler$p(this.this$0).hintFor(LoadType.APPEND), PageFetcherSnapshot.access$getHintHandler$p(this.this$0).hintFor(LoadType.PREPEND)});
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new PageFetcherSnapshot$startConsumingHints$1$jumpHint$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = k.d(r10, r5, r6);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {645, 233}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        AnonymousClass2(PageFetcherSnapshot<Key, Value> r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            PageFetcherSnapshot<Key, Value> r2 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(this.L$2, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$1, a.class, "com.obric.memorydata.plugin");
            PageFetcherSnapshotState.Holder r6 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L23:
            kotlinx.coroutines.flow.i<Integer> r10 = PageFetcherSnapshotState.Holder.access$getState$p(r6).consumePrependGenerationIdAsFlow();     // Catch: Throwable -> L20
            r3.b(null);
            LoadType r4 = LoadType.PREPEND;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (PageFetcherSnapshot.access$collectAsGenerationalViewportHints(r2, r10, r4, r5) != r0) goto L19;
            return r0;
        L20:
            th = move-exception;
            r3.b(null);
            throw th;
        L10:
            ResultKt.throwOnFailure(r9);
            r2 = this.this$0;
            r6 = PageFetcherSnapshot.access$getStateHolder$p(r2);
            a r11 = PageFetcherSnapshotState.Holder.access$getLock$p(r6);
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r6;
            this.L$1 = r11;
            this.L$2 = r2;
            this.label = 1;
            if (r11.a(null, r7) != r0) goto L13;
            return r0;
        L13:
            r3 = r11;
            goto L23
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {645, 238}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1"})
    static final class C09483 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        C09483(PageFetcherSnapshot<Key, Value> r3, Continuation<? super C09483> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09483(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09483) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09483.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            PageFetcherSnapshot<Key, Value> r2 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(this.L$2, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$1, a.class, "com.obric.memorydata.plugin");
            PageFetcherSnapshotState.Holder r6 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L23:
            kotlinx.coroutines.flow.i<Integer> r10 = PageFetcherSnapshotState.Holder.access$getState$p(r6).consumeAppendGenerationIdAsFlow();     // Catch: Throwable -> L20
            r3.b(null);
            LoadType r4 = LoadType.APPEND;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (PageFetcherSnapshot.access$collectAsGenerationalViewportHints(r2, r10, r4, r5) != r0) goto L19;
            return r0;
        L20:
            th = move-exception;
            r3.b(null);
            throw th;
        L10:
            ResultKt.throwOnFailure(r9);
            r2 = this.this$0;
            r6 = PageFetcherSnapshot.access$getStateHolder$p(r2);
            a r11 = PageFetcherSnapshotState.Holder.access$getLock$p(r6);
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r6;
            this.L$1 = r11;
            this.L$2 = r2;
            this.label = 1;
            if (r11.a(null, r7) != r0) goto L13;
            return r0;
        L13:
            r3 = r11;
            goto L23
        }
    }

    public PageFetcherSnapshot(Key r3, PagingSource<Key, Value> r4, PagingConfig r5, kotlinx.coroutines.flow.i<Unit> r6, RemoteMediatorConnection<Key, Value> r7, PagingState<Key, Value> r8, Function0<Unit> r9) {
        kotlinx.coroutines.flow.i<Unit> r10 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        RemoteMediatorConnection<Key, Value> r11 = (RemoteMediatorConnection) ZeusTransformUtils.wrapperContextForParams(r7, RemoteMediatorConnection.class, "com.obric.memorydata.plugin");
        Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pagingSource");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "retryFlow");
        Intrinsics.checkNotNullParameter(r12, "jumpCallback");
        this.initialKey = r3;
        this.pagingSource = r4;
        this.config = r5;
        this.retryFlow = r10;
        this.remoteMediatorConnection = r11;
        this.previousPagingState = r8;
        this.jumpCallback = r12;
        if (r5.jumpThreshold != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L13;
        this.hintHandler = new HintHandler();
        this.pageEventChCollected = new AtomicBoolean(false);
        this.pageEventCh = l.a(-2, null, null, 6, null);
        this.stateHolder = new PageFetcherSnapshotState.Holder(r5);
        z r14 = ca.a(null, 1, null);
        this.pageEventChannelFlowJob = r14;
        this.pageEventFlow = k.b(CancelableChannelFlowKt.cancelableChannelFlow((bx) ZeusTransformUtils.preCheckCast(r14, bx.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new PageFetcherSnapshot$pageEventFlow$1(this, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new PageFetcherSnapshot$pageEventFlow$2(this, null), Function2.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    L5:
        if (r4.getJumpingSupported() == true) goto L8;
        r13 = false;
        goto L9
    }

    public /* synthetic */ PageFetcherSnapshot(Object r11, PagingSource r12, PagingConfig r13, kotlinx.coroutines.flow.i r14, RemoteMediatorConnection r15, PagingState r16, Function0 r17, int r18, DefaultConstructorMarker r19) {
        kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r14, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        RemoteMediatorConnection r0 = (RemoteMediatorConnection) ZeusTransformUtils.wrapperContextForParams(r15, RemoteMediatorConnection.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        if ((r18 & 16) == 0) goto L5;
        RemoteMediatorConnection r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        PagingState r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        Function0 r9 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L14:
        this(r11, r12, r13, r6, r7, r8, r9);
        return;
    L13:
        r9 = r2;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r0;
        goto L7
    }

    public static final /* synthetic */ Object access$collectAsGenerationalViewportHints(PageFetcherSnapshot r2, kotlinx.coroutines.flow.i r3, LoadType r4, Continuation r5) {
        return r2.collectAsGenerationalViewportHints((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$doInitialLoad(PageFetcherSnapshot r2, Continuation r3) {
        return r2.doInitialLoad((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$doLoad(PageFetcherSnapshot r2, LoadType r3, GenerationalViewportHint r4, Continuation r5) {
        return r2.doLoad(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ PagingConfig access$getConfig$p(PageFetcherSnapshot r0) {
        return r0.config;
    }

    public static final /* synthetic */ HintHandler access$getHintHandler$p(PageFetcherSnapshot r0) {
        return r0.hintHandler;
    }

    public static final /* synthetic */ Function0 access$getJumpCallback$p(PageFetcherSnapshot r0) {
        return r0.jumpCallback;
    }

    public static final /* synthetic */ i access$getPageEventCh$p(PageFetcherSnapshot r0) {
        return r0.pageEventCh;
    }

    public static final /* synthetic */ AtomicBoolean access$getPageEventChCollected$p(PageFetcherSnapshot r0) {
        return r0.pageEventChCollected;
    }

    public static final /* synthetic */ PagingState access$getPreviousPagingState$p(PageFetcherSnapshot r0) {
        return r0.previousPagingState;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.i access$getRetryFlow$p(PageFetcherSnapshot r0) {
        return r0.retryFlow;
    }

    public static final /* synthetic */ PageFetcherSnapshotState.Holder access$getStateHolder$p(PageFetcherSnapshot r0) {
        return r0.stateHolder;
    }

    public static final /* synthetic */ Object access$retryLoadError(PageFetcherSnapshot r2, LoadType r3, ViewportHint r4, Continuation r5) {
        return r2.retryLoadError(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$setError(PageFetcherSnapshot r2, PageFetcherSnapshotState r3, LoadType r4, LoadState.Error r5, Continuation r6) {
        return r2.setError(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$setLoading(PageFetcherSnapshot r2, PageFetcherSnapshotState r3, LoadType r4, Continuation r5) {
        return r2.setLoading(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$startConsumingHints(PageFetcherSnapshot r2, al r3) {
        r2.startConsumingHints((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"));
    }

    private final Object collectAsGenerationalViewportHints(kotlinx.coroutines.flow.i<Integer> r5, final LoadType r6, Continuation<? super Unit> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = k.a(FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(r8, (Function3) ZeusTransformUtils.preCheckCast(new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, this, r6), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r6, null), Function3.class, "com.obric.memorydata.plugin"))).collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, r6), j.class, "com.obric.memorydata.plugin"), r9);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    private final Object doInitialLoad(Continuation<? super Unit> r18) {
        PageFetcherSnapshot r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C09451.class) == false) goto L7;
        C09451 r4 = (C09451) ZeusTransformUtils.preCheckCast(r2, C09451.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r4.label) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        a r1 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
    L137:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r1.b(null);
        return Unit.INSTANCE;
    L15:
        th = th;
    L142:
        r1.b(null);
        throw th;
    L17:
        a r7 = (a) ZeusTransformUtils.preCheckCast(r4.L$3, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r8 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r4.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult<Key, Value> r9 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4.L$1, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r10 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        a r11 = r7;
    L165:
        PageFetcherSnapshotState<Key, Value> r12 = PageFetcherSnapshotState.Holder.access$getState$p(r8);     // Catch: Throwable -> L140
        LoadState.Error r13 = new LoadState.Error(((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(r9, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable());     // Catch: Throwable -> L140
        LoadType r14 = LoadType.REFRESH;     // Catch: Throwable -> L140
        r4.L$0 = r11;     // Catch: Throwable -> L140
        r4.L$1 = null;     // Catch: Throwable -> L140
        r4.L$2 = null;     // Catch: Throwable -> L140
        r4.L$3 = null;     // Catch: Throwable -> L140
        r4.label = 9;     // Catch: Throwable -> L140
        if (r10.setError(r12, r14, r13, r4) != r5) goto L136;
        return r5;
    L136:
        r1 = r11;
    L140:
        th = th;
        r1 = r11;
        goto L142
    L18:
        a r15 = (a) ZeusTransformUtils.preCheckCast(r4.L$3, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r16 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r4.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult<Key, Value> r17 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4.L$1, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r10 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        a r19 = r15;
    L171:
        PagingState<Key, Value> r20 = PageFetcherSnapshotState.Holder.access$getState$p(r16).currentPagingState$paging_common(r10.hintHandler.getLastAccessHint());     // Catch: Throwable -> L113
        r19.b(null);
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r17, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey() != null) goto L111;
        r10.remoteMediatorConnection.requestLoad(LoadType.PREPEND, r20);
    L111:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r17, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey() != null) goto L156;
        r10.remoteMediatorConnection.requestLoad(LoadType.APPEND, r20);
    L156:
        return Unit.INSTANCE;
    L113:
        th = move-exception;
        r19.b(null);
        throw th;
    L19:
        a r21 = (a) ZeusTransformUtils.preCheckCast(r4.L$2, a.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult<Key, Value> r22 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4.L$1, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r10 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L22
    L82:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r21.b(null);
        r17 = r22;
    L97:
        if (r10.remoteMediatorConnection == null) goto L156;
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r17, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey() != null) goto L101;
    L102:
        PageFetcherSnapshotState.Holder<Key, Value> r24 = r10.stateHolder;
        r19 = PageFetcherSnapshotState.Holder.access$getLock$p(r24);
        r4.L$0 = r10;
        r4.L$1 = r17;
        r4.L$2 = r24;
        r4.L$3 = r19;
        r4.label = 7;
        if (r19.a(null, r4) != r5) goto L105;
        return r5;
    L105:
        r16 = r24;
        goto L171
    L101:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r17, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey() != null) goto L156;
    L22:
        th = th;
    L86:
        r21.b(null);
        throw th;
    L24:
        a r25 = (a) ZeusTransformUtils.preCheckCast(r4.L$3, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r26 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r4.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult<Key, Value> r27 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4.L$1, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r10 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        a r28 = r25;
        r22 = r27;
    L163:
        PageFetcherSnapshotState r29 = PageFetcherSnapshotState.Holder.access$getState$p(r26);     // Catch: Throwable -> L84
        i<PageEvent<Value>> r30 = r10.pageEventCh;     // Catch: Throwable -> L84
        PageEvent<Value> r31 = r29.toPageEvent$paging_common((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r22, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"), LoadType.REFRESH);     // Catch: Throwable -> L84
        r4.L$0 = r10;     // Catch: Throwable -> L84
        r4.L$1 = r22;     // Catch: Throwable -> L84
        r4.L$2 = r28;     // Catch: Throwable -> L84
        r4.L$3 = null;     // Catch: Throwable -> L84
        r4.label = 6;     // Catch: Throwable -> L84
        if (r30.send(r31, r4) != r5) goto L81;
        return r5;
    L81:
        r21 = r28;
    L84:
        th = th;
        r21 = r28;
        goto L86
    L25:
        a r32 = (a) ZeusTransformUtils.preCheckCast(r4.L$3, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r33 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r4.L$2, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult<Key, Value> r110 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4.L$1, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r10 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        a r34 = r32;
    L175:
        PageFetcherSnapshotState r35 = PageFetcherSnapshotState.Holder.access$getState$p(r33);     // Catch: Throwable -> L116
        boolean r36 = r35.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r110, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L116
        r35.getSourceLoadStates$paging_common().set(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L116
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r110, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey() != null) goto L63;
        r35.getSourceLoadStates$paging_common().set(LoadType.PREPEND, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getComplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L116
    L63:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r110, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey() != null) goto L65;
        r35.getSourceLoadStates$paging_common().set(LoadType.APPEND, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getComplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L116
    L65:
        r34.b(null);
        Logger r37 = LoggerKt.getLOGGER();
        if (r36 == false) goto L88;
        if (r37 != null) goto L69;
    L71:
        boolean r38 = false;
    L72:
        if (r38 == false) goto L74;
        r37.log(3, r10.loadResultLog(LoadType.REFRESH, r10.initialKey, r110), null);
    L74:
        r26 = r10.stateHolder;
        a r39 = PageFetcherSnapshotState.Holder.access$getLock$p(r26);
        r4.L$0 = r10;
        r4.L$1 = r110;
        r4.L$2 = r26;
        r4.L$3 = r39;
        r4.label = 5;
        if (r39.a(null, r4) != r5) goto L77;
        return r5;
    L77:
        r28 = r39;
        r22 = r110;
        goto L163
    L69:
        if (r37.isLoggable(3) != true) goto L71;
        r38 = true;
        goto L72
    L88:
        if (r37 != null) goto L90;
    L92:
        boolean r40 = false;
    L93:
        if (r40 == false) goto L95;
        r37.log(2, r10.loadResultLog(LoadType.REFRESH, r10.initialKey, null), null);
    L95:
        r17 = r110;
        goto L97
    L90:
        if (r37.isLoggable(2) != true) goto L92;
        r40 = true;
    L116:
        th = move-exception;
        r34.b(null);
        throw th;
    L26:
        r0 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L27:
        r10 = r0;
        PagingSource.LoadResult<Key, Value> r41 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r3, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r41, PagingSource.LoadResult.Page.class) == false) goto L120;
        r33 = r10.stateHolder;
        r34 = PageFetcherSnapshotState.Holder.access$getLock$p(r33);
        r4.L$0 = r10;
        r4.L$1 = r41;
        r4.L$2 = r33;
        r4.L$3 = r34;
        r4.label = 4;
        if (r34.a(null, r4) != r5) goto L58;
        return r5;
    L58:
        r110 = r41;
        goto L175
    L120:
        if (ZeusTransformUtils.instanceOf(r41, PagingSource.LoadResult.Error.class) == false) goto L145;
        Logger r42 = LoggerKt.getLOGGER();
        if (r42 != null) goto L124;
    L126:
        boolean r43 = false;
    L127:
        if (r43 == false) goto L129;
        r42.log(2, r10.loadResultLog(LoadType.REFRESH, r10.initialKey, r41), null);
    L129:
        r8 = r10.stateHolder;
        r11 = PageFetcherSnapshotState.Holder.access$getLock$p(r8);
        r4.L$0 = r10;
        r4.L$1 = r41;
        r4.L$2 = r8;
        r4.L$3 = r11;
        r4.label = 8;
        if (r11.a(null, r4) != r5) goto L132;
        return r5;
    L132:
        r9 = r41;
        goto L165
    L124:
        if (r42.isLoggable(2) != true) goto L126;
        r43 = true;
        goto L127
    L145:
        if (ZeusTransformUtils.instanceOf(r41, PagingSource.LoadResult.Invalid.class) == false) goto L156;
        Logger r44 = LoggerKt.getLOGGER();
        if (r44 != null) goto L149;
    L151:
        boolean r45 = false;
    L152:
        if (r45 == false) goto L154;
        r44.log(2, r10.loadResultLog(LoadType.REFRESH, r10.initialKey, r41), null);
    L154:
        r10.onInvalidLoad();
        goto L156
    L149:
        if (r44.isLoggable(2) != true) goto L151;
        r45 = true;
        goto L152
    L28:
        a r46 = (a) ZeusTransformUtils.preCheckCast(r4.L$1, a.class, "com.obric.memorydata.plugin");
        r0 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L31
    L41:
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r46.b(null);
        PagingSource.LoadParams<Key> r48 = r0.loadParams(LoadType.REFRESH, r0.initialKey);
        Logger r49 = LoggerKt.getLOGGER();
        if (r49 != null) goto L45;
    L47:
        boolean r50 = false;
    L48:
        if (r50 == false) goto L50;
        r49.log(3, "Start REFRESH with loadKey " + r0.initialKey + " on " + r0.pagingSource, null);
    L50:
        PagingSource<Key, Value> r51 = r0.pagingSource;
        r4.L$0 = r0;
        r4.L$1 = null;
        r4.label = 3;
        r3 = r51.load(r48, r4);
        if (r3 != r5) goto L27;
        return r5;
    L45:
        if (r49.isLoggable(3) != true) goto L47;
        r50 = true;
    L31:
        th = th;
    L159:
        r46.b(null);
        throw th;
    L33:
        a r52 = (a) ZeusTransformUtils.preCheckCast(r4.L$2, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r53 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r4.L$1, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r54 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r4.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        a r55 = r52;
        r0 = r54;
    L161:
        PageFetcherSnapshotState<Key, Value> r56 = PageFetcherSnapshotState.Holder.access$getState$p(r53);     // Catch: Throwable -> L157
        LoadType r57 = LoadType.REFRESH;     // Catch: Throwable -> L157
        r4.L$0 = r0;     // Catch: Throwable -> L157
        r4.L$1 = r55;     // Catch: Throwable -> L157
        r4.L$2 = null;     // Catch: Throwable -> L157
        r4.label = 2;     // Catch: Throwable -> L157
        if (r0.setLoading(r56, r57, r4) != r5) goto L40;
        return r5;
    L40:
        r46 = r55;
    L157:
        th = th;
        r46 = r55;
        goto L159
    L34:
        ResultKt.throwOnFailure(r3);
        r53 = r0.stateHolder;
        r55 = PageFetcherSnapshotState.Holder.access$getLock$p(r53);
        r4.L$0 = r0;
        r4.L$1 = r53;
        r4.L$2 = r55;
        r4.label = 1;
        if (r55.a(null, r4) != r5) goto L161;
        return r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r4 = new C09451(r0, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v154 */
    /* JADX WARN: Type inference failed for: r0v156 */
    /* JADX WARN: Type inference failed for: r0v73, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v78, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v92, types: [androidx.paging.PageFetcherSnapshotState] */
    /* JADX WARN: Type inference failed for: r12v16, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v57, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v66 */
    /* JADX WARN: Type inference failed for: r12v67 */
    /* JADX WARN: Type inference failed for: r12v68 */
    /* JADX WARN: Type inference failed for: r12v69 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v70 */
    /* JADX WARN: Type inference failed for: r12v71 */
    /* JADX WARN: Type inference failed for: r13v14, types: [androidx.paging.ViewportHint] */
    /* JADX WARN: Type inference failed for: r13v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v65 */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v67 */
    /* JADX WARN: Type inference failed for: r14v19, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v28, types: [androidx.paging.LoadType] */
    /* JADX WARN: Type inference failed for: r14v29, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v7, types: [androidx.paging.ViewportHint] */
    /* JADX WARN: Type inference failed for: r19v2, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r1v130 */
    /* JADX WARN: Type inference failed for: r1v131 */
    /* JADX WARN: Type inference failed for: r1v132 */
    /* JADX WARN: Type inference failed for: r1v133 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v63, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v73, types: [androidx.paging.PageFetcherSnapshotState] */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v49, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v50, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v55, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v56, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r2v59, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v64, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r3v11, types: [T] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v66, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.paging.MutableLoadStateCollection] */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.paging.MutableLoadStateCollection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x0948 -> B:270:0x099a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:260:0x094c -> B:270:0x099a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:262:0x0973 -> B:294:0x0976). Please report as a decompilation issue!!! */
    private final Object doLoad(LoadType r21, GenerationalViewportHint r22, Continuation<? super Unit> r23) {
        PageFetcherSnapshot<Key, Value> r0 = this;
        Object r1 = r21;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, C09461.class) == false) goto L7;
        C09461 r5 = (C09461) ZeusTransformUtils.preCheckCast(r3, C09461.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r8 = "Use doInitialLoad for LoadType == REFRESH";
        switch(r5.label) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L16;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        int r2 = r5.I$1;
        int r7 = r5.I$0;
        a r9 = (a) ZeusTransformUtils.preCheckCast(r5.L$7, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r14 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$6, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r11 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r10 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        GenerationalViewportHint r13 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r15 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r16 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        String r18 = "Use doInitialLoad for LoadType == REFRESH";
        Ref.ObjectRef r17 = r10;
        Ref.BooleanRef r19 = r11;
        GenerationalViewportHint r110 = r13;
        ?? r111 = r15;
        ?? r20 = r16;
    L294:
        PagingState<Key, Value> r24 = PageFetcherSnapshotState.Holder.access$getState$p(r14).currentPagingState$paging_common(r20.hintHandler.getLastAccessHint());     // Catch: Throwable -> L271
        r9.b(null);
        if (r7 == 0) goto L268;
        r20.remoteMediatorConnection.requestLoad(LoadType.PREPEND, r24);
    L268:
        if (r2 == 0) goto L270;
        r20.remoteMediatorConnection.requestLoad(LoadType.APPEND, r24);
    L270:
        Ref.BooleanRef r25 = r19;
        Ref.ObjectRef r26 = r17;
        ?? r112 = r111;
        r8 = r18;
        ?? r27 = r20;
    L86:
        if (r26.element == null) goto L281;
        PagingSource.LoadParams<Key> r28 = r27.loadParams(r112, r26.element);
        Logger r29 = LoggerKt.getLOGGER();
        if (r29 != null) goto L90;
    L92:
        boolean r30 = false;
    L93:
        if (r30 == false) goto L95;
        Object r113 = null;
        r29.log(3, "Start " + r112 + " with loadKey " + r26.element + " on " + r27.pagingSource, null);
    L96:
        PagingSource<Key, Value> r31 = r27.pagingSource;
        r5.L$0 = r27;
        r5.L$1 = r112;
        r5.L$2 = r110;
        r5.L$3 = r12;
        r5.L$4 = r26;
        r5.L$5 = r25;
        r5.L$6 = r28;
        r5.L$7 = r113;
        r5.L$8 = r113;
        r5.label = 4;
        r4 = r31.load(r28, r5);
        if (r4 != r6) goto L99;
        return r6;
    L99:
        GenerationalViewportHint r114 = r110;
        ?? r115 = r112;
        Ref.ObjectRef r116 = r26;
        Ref.IntRef r117 = r12;
        Ref.BooleanRef r118 = r25;
        PagingSource.LoadParams<Key> r32 = r28;
        ?? r33 = r27;
    L100:
        PagingSource.LoadResult r34 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r4, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r34, PagingSource.LoadResult.Page.class) == false) goto L162;
        int r35 = WhenMappings.$EnumSwitchMapping$0[r115.ordinal()];
        if (r35 != 2) goto L105;
        Object r36 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey();
    L111:
        if (r33.pagingSource.getKeyReuseSupported() == false) goto L113;
    L116:
        boolean r37 = true;
    L117:
        if (r37 == false) goto L119;
        PageFetcherSnapshotState.Holder<Key, Value> r38 = r33.stateHolder;
        a r39 = PageFetcherSnapshotState.Holder.access$getLock$p(r38);
        r5.L$0 = r33;
        r5.L$1 = r115;
        r5.L$2 = r114;
        r5.L$3 = r117;
        r5.L$4 = r116;
        r5.L$5 = r118;
        r5.L$6 = r32;
        r5.L$7 = r34;
        r5.L$8 = r38;
        r5.L$9 = r39;
        r5.label = 5;
        ?? r40 = r33;
        ?? r119 = r115;
        if (r39.a(null, r5) == r6) goto L126;
    L30:
        PageFetcherSnapshotState.Holder<Key, Value> r120 = r38;
        a r41 = r39;
        boolean r42 = PageFetcherSnapshotState.Holder.access$getState$p(r120).insert(r114.getGenerationId(), r119, (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L158
        r41.b(null);
        if (r42 == true) goto L138;
        Logger r43 = LoggerKt.getLOGGER();
        if (r43 != null) goto L133;
    L135:
        boolean r121 = false;
    L136:
        if (r121 == false) goto L281;
        r43.log(2, r40.loadResultLog(r119, r116.element, null), null);
        goto L281
    L133:
        if (r43.isLoggable(2) != true) goto L135;
        r121 = true;
        goto L136
    L138:
        Logger r44 = LoggerKt.getLOGGER();
        if (r44 != null) goto L141;
    L143:
        boolean r45 = false;
    L144:
        if (r45 == false) goto L146;
        r44.log(3, r40.loadResultLog(r119, r116.element, r34), null);
    L146:
        r117.element += ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        if (r119 == LoadType.PREPEND) goto L149;
    L152:
        ?? r46 = r40;
        ?? r122 = r119;
        if (r119 != LoadType.APPEND) goto L205;
        r46 = r40;
        r122 = r119;
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey() != null) goto L205;
    L157:
        r118.element = true;
        r46 = r40;
        r122 = r119;
    L205:
        if (WhenMappings.$EnumSwitchMapping$0[r122.ordinal()] != 2) goto L207;
        LoadType r47 = LoadType.APPEND;
    L208:
        PageFetcherSnapshotState.Holder<Key, Value> r48 = r46.stateHolder;
        a r49 = PageFetcherSnapshotState.Holder.access$getLock$p(r48);
        r5.L$0 = r46;
        r5.L$1 = r122;
        r5.L$2 = r114;
        r5.L$3 = r117;
        r5.L$4 = r116;
        r5.L$5 = r118;
        r5.L$6 = r32;
        r5.L$7 = r34;
        r5.L$8 = r47;
        r5.L$9 = r48;
        r5.L$10 = r49;
        r5.label = 8;
        LoadType r210 = r47;
        if (r49.a(null, r5) != r6) goto L211;
        return r6;
    L211:
        ?? r50 = r122;
        GenerationalViewportHint r123 = r114;
        Ref.IntRef r124 = r117;
        r17 = r116;
        Ref.BooleanRef r125 = r118;
        PagingSource.LoadParams<Key> r126 = r32;
        PagingSource.LoadResult r51 = r34;
        LoadType r52 = r210;
        ?? r53 = r46;
        a r54 = r49;
    L307:
        PageFetcherSnapshotState r55 = PageFetcherSnapshotState.Holder.access$getState$p(r48);     // Catch: Throwable -> L276
        PageEvent.Drop<Value> r56 = r55.dropEventOrNull(r52, r123.getHint());     // Catch: Throwable -> L276
        if (r56 == null) goto L226;
        r55.drop(r56);     // Catch: Throwable -> L276
        i<PageEvent<Value>> r127 = r53.pageEventCh;     // Catch: Throwable -> L276
        r5.L$0 = r53;     // Catch: Throwable -> L276
        r5.L$1 = r50;     // Catch: Throwable -> L276
        r5.L$2 = r123;     // Catch: Throwable -> L276
        r5.L$3 = r124;     // Catch: Throwable -> L276
        r5.L$4 = r17;     // Catch: Throwable -> L276
        r5.L$5 = r125;     // Catch: Throwable -> L276
        r5.L$6 = r126;     // Catch: Throwable -> L276
        r5.L$7 = r51;     // Catch: Throwable -> L276
        r5.L$8 = r54;     // Catch: Throwable -> L276
        r5.L$9 = r55;     // Catch: Throwable -> L276
        r5.L$10 = null;     // Catch: Throwable -> L224
        r5.label = 9;     // Catch: Throwable -> L276
        if (r127.send(r56, r5) != r6) goto L221;
        return r6;
    L221:
        r1 = r54;
        PagingSource.LoadResult r57 = r51;
        PagingSource.LoadParams<Key> r58 = r126;
        Ref.BooleanRef r128 = r125;
        Ref.ObjectRef r129 = r17;
        Ref.IntRef r130 = r124;
        GenerationalViewportHint r131 = r123;
        ?? r132 = r50;
        PageFetcherSnapshotState r59 = r55;
        ?? r60 = r53;
    L222:
        Unit r61 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Object r62 = r1;
        ?? r63 = r59;
        ?? r64 = r132;
        r123 = r131;
        r124 = r130;
        r17 = r129;
        r125 = r128;
        ?? r65 = r60;
    L227:
        r18 = r8;
        r17.element = r65.nextLoadKeyOrNull(r63, r64, r123.getGenerationId(), r123.getHint().presentedItemsBeyondAnchor$paging_common(r64) + r124.element);     // Catch: Throwable -> L276
        if (r17.element == null) goto L230;
    L236:
        PageEvent<Value> r66 = r63.toPageEvent$paging_common((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r57, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"), r64);     // Catch: Throwable -> L276
        i<PageEvent<Value>> r67 = r65.pageEventCh;     // Catch: Throwable -> L276
        r5.L$0 = r65;     // Catch: Throwable -> L276
        r5.L$1 = r64;     // Catch: Throwable -> L276
        r5.L$2 = r123;     // Catch: Throwable -> L276
        r5.L$3 = r124;     // Catch: Throwable -> L276
        r5.L$4 = r17;     // Catch: Throwable -> L276
        r5.L$5 = r125;     // Catch: Throwable -> L276
        r5.L$6 = r58;     // Catch: Throwable -> L276
        r5.L$7 = r57;     // Catch: Throwable -> L276
        r5.L$8 = r62;     // Catch: Throwable -> L276
        r5.L$9 = null;     // Catch: Throwable -> L274
        r5.L$10 = null;     // Catch: Throwable -> L274
        r5.label = 10;     // Catch: Throwable -> L276
        if (r67.send(r66, r5) != r6) goto L243;
        return r6;
    L243:
        ?? r68 = r62;
        r12 = r124;
        r111 = r64;
        PagingSource.LoadResult r69 = r57;
        PagingSource.LoadParams<Key> r70 = r58;
        r19 = r125;
        r110 = r123;
        r20 = r65;
    L244:
        Unit r71 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r68.b(null);
        if (ZeusTransformUtils.instanceOf(r70, PagingSource.LoadParams.Prepend.class) == true) goto L248;
    L250:
        r7 = 0;
    L252:
        if (ZeusTransformUtils.instanceOf(r70, PagingSource.LoadParams.Append.class) == true) goto L254;
    L256:
        r2 = 0;
    L258:
        if (r20.remoteMediatorConnection == null) goto L270;
        if (r7 != 0) goto L261;
        if (r2 == 0) goto L270;
    L261:
        r14 = r20.stateHolder;
        r9 = PageFetcherSnapshotState.Holder.access$getLock$p(r14);
        r5.L$0 = r20;
        r5.L$1 = r111;
        r5.L$2 = r110;
        r5.L$3 = r12;
        r5.L$4 = r17;
        r5.L$5 = r19;
        r5.L$6 = r14;
        r5.L$7 = r9;
        r5.L$8 = null;
        r5.I$0 = r7;
        r5.I$1 = r2;
        r5.label = 11;
        r20 = r20;
        r111 = r111;
        if (r9.a(null, r5) != r6) goto L294;
        return r6;
    L254:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r69, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey() != null) goto L256;
        r2 = 1;
        goto L258
    L248:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r69, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey() != null) goto L250;
        r7 = 1;
    L274:
        th = th;
        ?? r72 = r62;
        Object r73 = null;
    L278:
        r72.b(r73);
        throw th;
    L230:
        if (ZeusTransformUtils.instanceOf(r63.getSourceLoadStates$paging_common().get(r64), LoadState.Error.class) == true) goto L236;
        ?? r74 = r63.getSourceLoadStates$paging_common();     // Catch: Throwable -> L276
        if (r125.element == false) goto L234;
        LoadState.NotLoading r133 = LoadState.NotLoading.Companion.getComplete$paging_common();     // Catch: Throwable -> L276
    L235:
        r74.set(r64, (LoadState) ZeusTransformUtils.preCheckCast(r133, LoadState.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L276
        goto L236
    L234:
        r133 = LoadState.NotLoading.Companion.getIncomplete$paging_common();     // Catch: Throwable -> L276
    L224:
        th = th;
        r73 = null;
        r72 = r54;
        goto L278
    L226:
        r57 = r51;
        r58 = r126;
        r64 = r50;
        r63 = r55;
        r65 = r53;
        r62 = r54;
    L276:
        th = th;
        r1 = r54;
    L20:
        r73 = null;
        r72 = r1;
        goto L278
    L207:
        r47 = LoadType.PREPEND;
        goto L208
    L149:
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey() == null) goto L157;
    L141:
        if (r44.isLoggable(3) != true) goto L143;
        r45 = true;
    L158:
        th = move-exception;
        r41.b(null);
        throw th;
    L126:
        return r6;
    L119:
        if (r115 != LoadType.PREPEND) goto L121;
        String r75 = "prevKey";
    L123:
        throw new IllegalStateException(StringsKt.trimMargin$default("The same value, " + r116.element + ", was passed as the " + r75 + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ", null, 1, null).toString());
    L121:
        r75 = "nextKey";
        goto L123
    L113:
        if (Intrinsics.areEqual(r36, r116.element) == false) goto L116;
        r37 = false;
        goto L117
    L105:
        if (r35 != 3) goto L108;
        r36 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey();
        goto L111
    L108:
        throw new IllegalArgumentException(r8);
    L162:
        if (ZeusTransformUtils.instanceOf(r34, PagingSource.LoadResult.Error.class) == false) goto L192;
        Logger r76 = LoggerKt.getLOGGER();
        if (r76 != null) goto L166;
    L168:
        boolean r134 = false;
    L169:
        if (r134 == false) goto L171;
        Object r77 = null;
        r76.log(2, r33.loadResultLog(r115, r116.element, r34), null);
    L172:
        PageFetcherSnapshotState.Holder<Key, Value> r78 = r33.stateHolder;
        a r79 = PageFetcherSnapshotState.Holder.access$getLock$p(r78);
        r5.L$0 = r33;
        r5.L$1 = r115;
        r5.L$2 = r114;
        r5.L$3 = r34;
        r5.L$4 = r78;
        r5.L$5 = r79;
        r5.L$6 = r77;
        r5.label = 6;
        ?? r80 = r33;
        ?? r135 = r115;
        if (r79.a(r77, r5) == r6) goto L174;
    L28:
        ?? r136 = r80;
        a r81 = r79;
        PageFetcherSnapshotState r82 = PageFetcherSnapshotState.Holder.access$getState$p(r78);     // Catch: Throwable -> L188
        LoadState.Error r83 = new LoadState.Error(((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(r34, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable());     // Catch: Throwable -> L188
        r5.L$0 = r135;     // Catch: Throwable -> L188
        r5.L$1 = r114;     // Catch: Throwable -> L188
        r5.L$2 = r81;     // Catch: Throwable -> L188
        r5.L$3 = r82;     // Catch: Throwable -> L188
        r5.L$4 = null;     // Catch: Throwable -> L186
        r5.L$5 = null;     // Catch: Throwable -> L186
        r5.label = 7;     // Catch: Throwable -> L188
        if (r136.setError(r82, r135, r83, r5) != r6) goto L182;
        return r6;
    L182:
        PageFetcherSnapshotState r84 = r82;
        a r85 = r81;
        GenerationalViewportHint r86 = r114;
        ?? r87 = r135;
    L183:
        r84.getFailedHintsByLoadType$paging_common().put(r87, r86.getHint());     // Catch: Throwable -> L25
        Unit r88 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r85.b(null);
        return Unit.INSTANCE;
    L25:
        Throwable th = th;
    L26:
        Object r89 = null;
    L190:
        r85.b(r89);
        throw th;
    L186:
        th = th;
        r85 = r81;
        r89 = null;
    L188:
        th = th;
        r85 = r81;
        goto L26
    L174:
        return r6;
    L171:
        r77 = null;
        goto L172
    L166:
        if (r76.isLoggable(2) != true) goto L168;
        r134 = true;
        goto L169
    L192:
        r46 = r33;
        r122 = r115;
        if (ZeusTransformUtils.instanceOf(r34, PagingSource.LoadResult.Invalid.class) == false) goto L205;
        Logger r90 = LoggerKt.getLOGGER();
        if (r90 == null) goto L199;
        boolean r137 = true;
        if (r90.isLoggable(2) != true) goto L199;
    L200:
        if (r137 == false) goto L202;
        r90.log(2, r33.loadResultLog(r115, r116.element, r34), null);
    L202:
        r33.onInvalidLoad();
        return Unit.INSTANCE;
    L199:
        r137 = false;
        goto L200
    L95:
        r113 = null;
        goto L96
    L90:
        if (r29.isLoggable(3) != true) goto L92;
        r30 = true;
    L281:
        return Unit.INSTANCE;
    L271:
        th = move-exception;
        r9.b(null);
        throw th;
    L13:
        a r91 = (a) ZeusTransformUtils.preCheckCast(r5.L$8, a.class, "com.obric.memorydata.plugin");
        r69 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r5.L$7, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r70 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r5.L$6, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        r19 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r138 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r139 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        GenerationalViewportHint r140 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r141 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r92 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L19
        r18 = "Use doInitialLoad for LoadType == REFRESH";
        r17 = r138;
        r12 = r139;
        r110 = r140;
        r68 = r91;
        r20 = r92;
        r111 = r141;
        goto L244
    L16:
        PageFetcherSnapshotState r93 = (PageFetcherSnapshotState) ZeusTransformUtils.preCheckCast(r5.L$9, PageFetcherSnapshotState.class, "com.obric.memorydata.plugin");
        a r94 = (a) ZeusTransformUtils.preCheckCast(r5.L$8, a.class, "com.obric.memorydata.plugin");
        r57 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r5.L$7, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r58 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r5.L$6, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        r128 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        r129 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r130 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r131 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r142 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r95 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L19
        r59 = r93;
        r1 = r94;
        r60 = r95;
        r132 = r142;
        goto L222
    L21:
        a r96 = (a) ZeusTransformUtils.preCheckCast(r5.L$10, a.class, "com.obric.memorydata.plugin");
        r48 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$9, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        r52 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$8, LoadType.class, "com.obric.memorydata.plugin");
        r51 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r5.L$7, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r126 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r5.L$6, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        r125 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        r17 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r124 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r123 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r97 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r98 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r54 = r96;
        r50 = r97;
        r53 = r98;
        goto L307
    L22:
        r84 = (PageFetcherSnapshotState) ZeusTransformUtils.preCheckCast(r5.L$3, PageFetcherSnapshotState.class, "com.obric.memorydata.plugin");
        r85 = (a) ZeusTransformUtils.preCheckCast(r5.L$2, a.class, "com.obric.memorydata.plugin");
        r86 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$1, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r99 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$0, LoadType.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L25
        r87 = r99;
        goto L183
    L27:
        r79 = (a) ZeusTransformUtils.preCheckCast(r5.L$5, a.class, "com.obric.memorydata.plugin");
        r78 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        r34 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r5.L$3, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        GenerationalViewportHint r100 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r101 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r102 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r114 = r100;
        r135 = r101;
        r80 = r102;
        goto L28
    L29:
        r39 = (a) ZeusTransformUtils.preCheckCast(r5.L$9, a.class, "com.obric.memorydata.plugin");
        r38 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$8, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        r34 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r5.L$7, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        r32 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r5.L$6, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        r118 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        r116 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r117 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r114 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r143 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r103 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r40 = r103;
        r119 = r143;
        goto L30
    L31:
        PagingSource.LoadParams<Key> r104 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r5.L$6, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r105 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r106 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r107 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        GenerationalViewportHint r144 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r145 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r108 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r117 = r107;
        r114 = r144;
        r115 = r145;
        r32 = r104;
        r118 = r105;
        r116 = r106;
        r33 = r108;
        goto L100
    L32:
        Ref.ObjectRef r109 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Object r146 = r5.L$6;
        a r147 = (a) ZeusTransformUtils.preCheckCast(r5.L$5, a.class, "com.obric.memorydata.plugin");
        r26 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r110 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r148 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r149 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L35
        ?? r150 = r149;
        ?? r151 = r148;
    L81:
        ?? r152 = r146;
        a r153 = r147;
        ?? r154 = r150;
        ?? r155 = r151;
    L84:
        r153.b(null);
        r109.element = r152;
        r25 = new Ref.BooleanRef();
        r27 = r154;
        r112 = r155;
    L35:
        th = th;
    L284:
        r147.b(null);
        throw th;
    L37:
        r109 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r153 = (a) ZeusTransformUtils.preCheckCast(r5.L$6, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r156 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$5, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        r26 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r110 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r157 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot r158 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        ?? r159 = r158;
        ?? r160 = r157;
    L300:
        PageFetcherSnapshotState r161 = PageFetcherSnapshotState.Holder.access$getState$p(r156);     // Catch: Throwable -> L282
        Object r162 = r159.nextLoadKeyOrNull(r161, r160, r110.getGenerationId(), r110.getHint().presentedItemsBeyondAnchor$paging_common(r160) + r12.element);     // Catch: Throwable -> L282
        if (r162 == null) goto L83;
        r5.L$0 = r159;     // Catch: Throwable -> L282
        r5.L$1 = r160;     // Catch: Throwable -> L282
        r5.L$2 = r110;     // Catch: Throwable -> L282
        r5.L$3 = r12;     // Catch: Throwable -> L282
        r5.L$4 = r26;     // Catch: Throwable -> L282
        r5.L$5 = r153;     // Catch: Throwable -> L282
        r5.L$6 = r162;     // Catch: Throwable -> L282
        r5.L$7 = r109;     // Catch: Throwable -> L282
        r5.label = 3;     // Catch: Throwable -> L282
        if (r159.setLoading(r161, r160, r5) != r6) goto L80;
        return r6;
    L80:
        r147 = r153;
        r146 = r162;
        r150 = r159;
        r151 = r160;
        goto L81
    L83:
        r152 = 0;
        r154 = r159;
        r155 = r160;
    L282:
        th = th;
        r147 = r153;
        goto L284
    L38:
        a r163 = (a) ZeusTransformUtils.preCheckCast(r5.L$5, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r164 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r5.L$4, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        Ref.IntRef r165 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r5.L$3, Ref.IntRef.class, "com.obric.memorydata.plugin");
        GenerationalViewportHint r166 = (GenerationalViewportHint) ZeusTransformUtils.preCheckCast(r5.L$2, GenerationalViewportHint.class, "com.obric.memorydata.plugin");
        LoadType r167 = (LoadType) ZeusTransformUtils.preCheckCast(r5.L$1, LoadType.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot<Key, Value> r168 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r5.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        a r169 = r163;
        r0 = r168;
        PageFetcherSnapshotState.Holder<Key, Value> r170 = r164;
        ?? r171 = r167;
    L306:
        PageFetcherSnapshotState r172 = PageFetcherSnapshotState.Holder.access$getState$p(r170);     // Catch: Throwable -> L289
        int r173 = WhenMappings.$EnumSwitchMapping$0[r171.ordinal()];     // Catch: Throwable -> L289
        if (r173 == 1) goto L288;
        if (r173 != 2) goto L52;
        int r174 = (r172.getInitialPageIndex$paging_common() + r166.getHint().getOriginalPageOffsetFirst()) - 1;     // Catch: Throwable -> L289
        if (r174 <= CollectionsKt.getLastIndex(r172.getPages$paging_common())) goto L65;
        r165.element += r0.config.pageSize * (r174 - CollectionsKt.getLastIndex(r172.getPages$paging_common()));     // Catch: Throwable -> L289
        r174 = CollectionsKt.getLastIndex(r172.getPages$paging_common());     // Catch: Throwable -> L289
    L65:
        if (r174 < 0) goto L70;
        int r175 = 0;
    L67:
        r165.element += ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r172.getPages$paging_common().get(r175), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();     // Catch: Throwable -> L289
        if (r175 == r174) goto L70;
        r175 = r175 + 1;     // Catch: Throwable -> L289
    L70:
        Unit r176 = Unit.INSTANCE;     // Catch: Throwable -> L289
        r169.b(null);
        Ref.ObjectRef r177 = new Ref.ObjectRef();
        PageFetcherSnapshotState.Holder<Key, Value> r178 = r0.stateHolder;
        a r179 = PageFetcherSnapshotState.Holder.access$getLock$p(r178);
        r5.L$0 = r0;
        r5.L$1 = r171;
        r5.L$2 = r166;
        r5.L$3 = r165;
        r5.L$4 = r177;
        r5.L$5 = r178;
        r5.L$6 = r179;
        r5.L$7 = r177;
        r5.label = 2;
        if (r179.a(null, r5) != r6) goto L74;
        return r6;
    L74:
        r160 = r171;
        r110 = r166;
        r153 = r179;
        r26 = r177;
        r12 = r165;
        r156 = r178;
        r159 = r0;
        r109 = r26;
        goto L300
    L52:
        if (r173 != 3) goto L70;
        int r180 = (r172.getInitialPageIndex$paging_common() + r166.getHint().getOriginalPageOffsetLast()) + 1;     // Catch: Throwable -> L289
        if (r180 >= 0) goto L57;
        r165.element += r0.config.pageSize * (-r180);     // Catch: Throwable -> L289
        r180 = 0;
    L57:
        int r181 = CollectionsKt.getLastIndex(r172.getPages$paging_common());     // Catch: Throwable -> L289
        if (r180 > r181) goto L70;
    L59:
        r165.element += ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r172.getPages$paging_common().get(r180), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();     // Catch: Throwable -> L289
        if (r180 == r181) goto L70;
        r180 = r180 + 1;     // Catch: Throwable -> L289
        goto L59
    L288:
        throw new IllegalStateException("Use doInitialLoad for LoadType == REFRESH");     // Catch: Throwable -> L289
    L289:
        th = move-exception;
        r169.b(null);
        throw th;
    L39:
        ResultKt.throwOnFailure(r4);
        if (r1 == LoadType.REFRESH) goto L42;
        boolean r182 = true;
    L43:
        if (r182 == false) goto L293;
        r165 = new Ref.IntRef();
        r170 = r0.stateHolder;
        r169 = PageFetcherSnapshotState.Holder.access$getLock$p(r170);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r166 = r22;
        r5.L$2 = r166;
        r5.L$3 = r165;
        r5.L$4 = r170;
        r5.L$5 = r169;
        r5.label = 1;
        r171 = r1;
        if (r169.a(null, r5) != r6) goto L306;
        return r6;
    L293:
        throw new IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH".toString());
    L42:
        r182 = false;
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        th = th;
    L7:
        r5 = new C09461(r0, r3);
        goto L8
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType r3, Key r4) {
        PagingSource.LoadParams.Companion r0 = PagingSource.LoadParams.Companion;
        if (r3 != LoadType.REFRESH) goto L5;
        int r1 = this.config.initialLoadSize;
    L7:
        return r0.create(r3, r4, r1, this.config.enablePlaceholders);
    L5:
        r1 = this.config.pageSize;
        goto L7
    }

    private final String loadResultLog(LoadType r2, Key r3, PagingSource.LoadResult<Key, Value> r4) {
        if (r4 != null) goto L5;
        StringBuilder r1 = new StringBuilder().append("End ").append(r2).append(" with loadkey ").append(r3).append(". Load CANCELLED.");
    L7:
        return r1.toString();
    L5:
        r1 = new StringBuilder().append("End ").append(r2).append(" with loadKey ").append(r3).append(". Returned ").append(r4);
        goto L7
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> r3, LoadType r4, int r5, int r6) {
        if (r5 == r3.generationId$paging_common(r4)) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3.getSourceLoadStates$paging_common().get(r4), LoadState.Error.class) == false) goto L9;
        return null;
    L9:
        if (r6 < this.config.prefetchDistance) goto L12;
        return null;
    L12:
        if (r4 != LoadType.PREPEND) goto L15;
        return (Key) ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3.getPages$paging_common()), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey();
    L15:
        return (Key) ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r3.getPages$paging_common()), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey();
    }

    private final void onInvalidLoad() {
        close();
        this.pagingSource.invalidate();
    }

    private final Object retryLoadError(LoadType r3, ViewportHint r4, Continuation<? super Unit> r5) {
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (WhenMappings.$EnumSwitchMapping$0[r3.ordinal()] != 1) goto L9;
        Object r2 = doInitialLoad(r6);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r2;
    L8:
        return Unit.INSTANCE;
    L9:
        if (r4 != null) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L16;
        this.hintHandler.forceSetHint(r3, r4);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
    }

    private final Object setError(PageFetcherSnapshotState<Key, Value> r4, LoadType r5, LoadState.Error r6, Continuation<? super Unit> r7) {
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.getSourceLoadStates$paging_common().get(r5), r6) == true) goto L10;
        r4.getSourceLoadStates$paging_common().set(r5, (LoadState) ZeusTransformUtils.preCheckCast(r6, LoadState.class, "com.obric.memorydata.plugin"));
        Object r3 = this.pageEventCh.send(new PageEvent.LoadStateUpdate(r4.getSourceLoadStates$paging_common().snapshot(), null), r8);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r3;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final Object setLoading(PageFetcherSnapshotState<Key, Value> r5, LoadType r6, Continuation<? super Unit> r7) {
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.getSourceLoadStates$paging_common().get(r6), LoadState.Loading.INSTANCE) == true) goto L10;
        r5.getSourceLoadStates$paging_common().set(r6, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
        Object r4 = this.pageEventCh.send(new PageEvent.LoadStateUpdate(r5.getSourceLoadStates$paging_common().snapshot(), null), r8);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final void startConsumingHints(al r10) {
        al r11 = (al) ZeusTransformUtils.wrapperContextForParams(r10, al.class, "com.obric.memorydata.plugin");
        if (this.config.jumpThreshold == Integer.MIN_VALUE) goto L5;
        kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C09471(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L5:
        kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C09483(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void accessHint(ViewportHint r2) {
        Intrinsics.checkNotNullParameter(r2, "viewportHint");
        this.hintHandler.processHint(r2);
    }

    public final void close() {
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(this.pageEventChannelFlowJob, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
    }

    public final Object currentPagingState(Continuation<? super PagingState<Key, Value>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C09441.class) == false) goto L7;
        C09441 r0 = (C09441) ZeusTransformUtils.preCheckCast(r8, C09441.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0.L$2, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder<Key, Value> r4 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(r0.L$1, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot<Key, Value> r1 = (PageFetcherSnapshot) ZeusTransformUtils.preCheckCast(r0.L$0, PageFetcherSnapshot.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        a r5 = r6;
        PageFetcherSnapshot<Key, Value> this = r1;
    L24:
        PagingState<Key, Value> r10 = PageFetcherSnapshotState.Holder.access$getState$p(r4).currentPagingState$paging_common(this.hintHandler.getLastAccessHint());     // Catch: Throwable -> L21
        r5.b(null);
        return r10;
    L21:
        th = move-exception;
        r5.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        PageFetcherSnapshotState.Holder<Key, Value> r11 = this.stateHolder;
        r5 = PageFetcherSnapshotState.Holder.access$getLock$p(r11);
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.L$2 = r5;
        r0.label = 1;
        if (r5.a(null, r0) != r2) goto L17;
        return r2;
    L17:
        r4 = r11;
    L7:
        r0 = new C09441(this, r8);
        goto L8
    }

    public final Key getInitialKey$paging_common() {
        return this.initialKey;
    }

    public final kotlinx.coroutines.flow.i<PageEvent<Value>> getPageEventFlow() {
        return this.pageEventFlow;
    }

    public final PagingSource<Key, Value> getPagingSource$paging_common() {
        return this.pagingSource;
    }

    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }
}
