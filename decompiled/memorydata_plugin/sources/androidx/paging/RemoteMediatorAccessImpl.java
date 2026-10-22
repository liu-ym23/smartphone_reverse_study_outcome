package androidx.paging;

import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001!B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0011\u0010\u0015\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0016J\u001c\u0010 \u001a\u00020\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0016J4\u0010\u001a\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0002R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl;", "Key", "", "Value", "Landroidx/paging/RemoteMediatorAccessor;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/RemoteMediator;)V", "accessorState", "Landroidx/paging/AccessorStateHolder;", "isolationRunner", "Landroidx/paging/SingleRunner;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/LoadStates;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "allowRefresh", "", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchBoundary", "launchRefresh", "requestLoad", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "requestRefreshIfAllowed", "retryFailed", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {
    public static final Companion Companion = null;
    private static final int PRIORITY_APPEND_PREPEND = 1;
    private static final int PRIORITY_REFRESH = 2;
    private final AccessorStateHolder<Key, Value> accessorState;
    private final SingleRunner isolationRunner;
    private final RemoteMediator<Key, Value> remoteMediator;
    private final al scope;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl$Companion;", "", "()V", "PRIORITY_APPEND_PREPEND", "", "PRIORITY_REFRESH", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

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

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$initialize$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl", f = "RemoteMediatorAccessor.kt", i = {0}, l = {BDVideoUploaderBase.KeyIsVideoMetaData}, m = "initialize", n = {"this"}, s = {"L$0"})
    static final class C09611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        C09611(RemoteMediatorAccessImpl<Key, Value> r3, Continuation<? super C09611> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.initialize((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
    static final class C09621 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {393}, m = "invokeSuspend", n = {"loadType"}, s = {"L$0"})
        static final class C00381 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

            C00381(RemoteMediatorAccessImpl<Key, Value> r3, Continuation<? super C00381> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(1, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00381(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
                return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Unit> r3) {
                return ((C00381) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C00381.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0075 -> B:16:0x0078). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                final LoadType r2 = (LoadType) ZeusTransformUtils.preCheckCast(this.L$0, LoadType.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r7);
            L16:
                final RemoteMediator.MediatorResult r8 = (RemoteMediator.MediatorResult) ZeusTransformUtils.preCheckCast(r7, RemoteMediator.MediatorResult.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, RemoteMediator.MediatorResult.Success.class) == false) goto L21;
                AccessorStateHolder r4 = RemoteMediatorAccessImpl.access$getAccessorState$p(this.this$0);
                Function1<AccessorState<Key, Value>, Unit> r5 = new AnonymousClass2(r2, r8);
            L19:
                r4.use((Function1) ZeusTransformUtils.preCheckCast(r5, Function1.class, "com.obric.memorydata.plugin"));
            L9:
                Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(RemoteMediatorAccessImpl.access$getAccessorState$p(this.this$0).use((Function1) ZeusTransformUtils.preCheckCast(C00391.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Pair.class, "com.obric.memorydata.plugin");
                if (r9 == null) goto L12;
                r2 = (LoadType) ZeusTransformUtils.preCheckCast(r9.component1(), LoadType.class, "com.obric.memorydata.plugin");
                PagingState<Key, Value> r10 = (PagingState) ZeusTransformUtils.preCheckCast(r9.component2(), PagingState.class, "com.obric.memorydata.plugin");
                RemoteMediator r6 = RemoteMediatorAccessImpl.access$getRemoteMediator$p(this.this$0);
                Continuation<? super RemoteMediator.MediatorResult> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.L$0 = r2;
                this.label = 1;
                r7 = r6.load(r2, r10, r11);
                if (r7 != r0) goto L16;
                return r0;
            L12:
                return Unit.INSTANCE;
            L21:
                if (ZeusTransformUtils.instanceOf(r8, RemoteMediator.MediatorResult.Error.class) == false) goto L9;
                r4 = RemoteMediatorAccessImpl.access$getAccessorState$p(this.this$0);
                r5 = new AnonymousClass3(r2, r8);
                goto L19
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                goto L9
            }
        }

        C09621(RemoteMediatorAccessImpl<Key, Value> r3, Continuation<? super C09621> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09621(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09621) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09621.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            SingleRunner r7 = RemoteMediatorAccessImpl.access$getIsolationRunner$p(this.this$0);
            Function1<? super Continuation<? super Unit>, ? extends Object> r2 = (Function1) ZeusTransformUtils.preCheckCast(new C00381(this.this$0, null), Function1.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.runInIsolation(1, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {314}, m = "invokeSuspend", n = {"launchAppendPrepend"}, s = {"L$0"})
    static final class C09631 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {321}, m = "invokeSuspend", n = {}, s = {})
        static final class C00401 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.BooleanRef $launchAppendPrepend;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

            C00401(RemoteMediatorAccessImpl<Key, Value> r3, Ref.BooleanRef r4, Continuation<? super C00401> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$launchAppendPrepend = r4;
                super(1, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00401(this.this$0, this.$launchAppendPrepend, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
                return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Unit> r3) {
                return ((C00401) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C00401.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                Ref.BooleanRef r2 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
                RemoteMediatorAccessImpl<Key, Value> r7 = (RemoteMediatorAccessImpl) ZeusTransformUtils.preCheckCast(this.L$0, RemoteMediatorAccessImpl.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r8);
            L14:
                final RemoteMediator.MediatorResult r9 = (RemoteMediator.MediatorResult) ZeusTransformUtils.preCheckCast(r8, RemoteMediator.MediatorResult.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, RemoteMediator.MediatorResult.Success.class) == false) goto L19;
                AccessorStateHolder r10 = RemoteMediatorAccessImpl.access$getAccessorState$p(r7);
                Function1<AccessorState<Key, Value>, Boolean> r3 = new RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(r9);
            L21:
                r2.element = ((Boolean) ZeusTransformUtils.preCheckCast(r10.use((Function1) ZeusTransformUtils.preCheckCast(r3, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            L25:
                return Unit.INSTANCE;
            L19:
                if (ZeusTransformUtils.instanceOf(r9, RemoteMediator.MediatorResult.Error.class) == false) goto L23;
                r10 = RemoteMediatorAccessImpl.access$getAccessorState$p(r7);
                r3 = new RemoteMediatorAccessImpl$launchRefresh$1$1$1$2(r9);
                goto L21
            L23:
                throw new NoWhenBranchMatchedException();
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                PagingState<Key, Value> r11 = (PagingState) ZeusTransformUtils.preCheckCast(RemoteMediatorAccessImpl.access$getAccessorState$p(this.this$0).use((Function1) ZeusTransformUtils.preCheckCast(RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), PagingState.class, "com.obric.memorydata.plugin");
                if (r11 == null) goto L25;
                RemoteMediatorAccessImpl<Key, Value> r4 = this.this$0;
                Ref.BooleanRef r5 = this.$launchAppendPrepend;
                RemoteMediator r6 = RemoteMediatorAccessImpl.access$getRemoteMediator$p(r4);
                LoadType r12 = LoadType.REFRESH;
                this.L$0 = r4;
                this.L$1 = r5;
                this.label = 1;
                r8 = r6.load(r12, r11, this);
                if (r8 != r0) goto L13;
                return r0;
            L13:
                r7 = r4;
                r2 = r5;
                goto L14
            }
        }

        C09631(RemoteMediatorAccessImpl<Key, Value> r3, Continuation<? super C09631> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09631(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09631) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09631.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.BooleanRef r2 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L13:
            if (r2.element == false) goto L16;
            RemoteMediatorAccessImpl.access$launchBoundary(this.this$0);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            Ref.BooleanRef r10 = new Ref.BooleanRef();
            SingleRunner r3 = RemoteMediatorAccessImpl.access$getIsolationRunner$p(this.this$0);
            Function1<? super Continuation<? super Unit>, ? extends Object> r5 = (Function1) ZeusTransformUtils.preCheckCast(new C00401(this.this$0, r10, null), Function1.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.label = 1;
            if (r3.runInIsolation(2, r5, r4) != r0) goto L11;
            return r0;
        L11:
            r2 = r10;
            goto L13
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RemoteMediatorAccessImpl(al r3, RemoteMediator<Key, Value> r4) {
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r4, "remoteMediator");
        this.scope = r5;
        this.remoteMediator = r4;
        this.accessorState = new AccessorStateHolder();
        this.isolationRunner = new SingleRunner(false);
    }

    public static final /* synthetic */ AccessorStateHolder access$getAccessorState$p(RemoteMediatorAccessImpl r0) {
        return r0.accessorState;
    }

    public static final /* synthetic */ SingleRunner access$getIsolationRunner$p(RemoteMediatorAccessImpl r0) {
        return r0.isolationRunner;
    }

    public static final /* synthetic */ RemoteMediator access$getRemoteMediator$p(RemoteMediatorAccessImpl r0) {
        return r0.remoteMediator;
    }

    public static final /* synthetic */ void access$launchBoundary(RemoteMediatorAccessImpl r0) {
        r0.launchBoundary();
    }

    public static final /* synthetic */ void access$requestLoad(RemoteMediatorAccessImpl r0, AccessorStateHolder r1, LoadType r2, PagingState r3) {
        r0.requestLoad(r1, r2, r3);
    }

    private final void launchBoundary() {
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C09621(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void launchRefresh() {
        i.a(this.scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C09631(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void requestLoad(AccessorStateHolder<Key, Value> r3, final LoadType r4, final PagingState<Key, Value> r5) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.use((Function1) ZeusTransformUtils.preCheckCast(new RemoteMediatorAccessImpl$requestLoad$newRequest$1(r4, r5), Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return;
    L5:
        if (WhenMappings.$EnumSwitchMapping$0[r4.ordinal()] != 1) goto L7;
        launchRefresh();
        return;
    L7:
        launchBoundary();
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void allowRefresh() {
        this.accessorState.use((Function1) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public ar<LoadStates> getState() {
        return this.accessorState.getLoadStates();
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public Object initialize(Continuation<? super RemoteMediator.InitializeAction> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C09611.class) == false) goto L7;
        C09611 r0 = (C09611) ZeusTransformUtils.preCheckCast(r7, C09611.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RemoteMediatorAccessImpl<Key, Value> this = (RemoteMediatorAccessImpl) ZeusTransformUtils.preCheckCast(r0.L$0, RemoteMediatorAccessImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L18:
        if (((RemoteMediator.InitializeAction) ZeusTransformUtils.preCheckCast(r8, RemoteMediator.InitializeAction.class, "com.obric.memorydata.plugin")) != RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) goto L20;
        this.accessorState.use((Function1) ZeusTransformUtils.preCheckCast(RemoteMediatorAccessImpl$initialize$2$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    L20:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        RemoteMediator<Key, Value> r9 = this.remoteMediator;
        r0.L$0 = this;
        r0.label = 1;
        r8 = r9.initialize(r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new C09611(this, r7);
        goto L8
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestLoad(LoadType r2, PagingState<Key, Value> r3) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        Intrinsics.checkNotNullParameter(r3, "pagingState");
        requestLoad(this.accessorState, r2, r3);
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestRefreshIfAllowed(final PagingState<Key, Value> r3) {
        Intrinsics.checkNotNullParameter(r3, "pagingState");
        this.accessorState.use((Function1) ZeusTransformUtils.preCheckCast(new C09641(this, r3), Function1.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void retryFailed(PagingState<Key, Value> r6) {
        Intrinsics.checkNotNullParameter(r6, "pagingState");
        final List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.accessorState.use((Function1) ZeusTransformUtils.preCheckCast(new C09651(r0), Function1.class, "com.obric.memorydata.plugin"));
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        requestLoad((LoadType) ZeusTransformUtils.preCheckCast(r1.next(), LoadType.class, "com.obric.memorydata.plugin"), r6);
        goto L4
    }
}
