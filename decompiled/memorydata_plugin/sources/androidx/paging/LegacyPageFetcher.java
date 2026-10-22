package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u000289BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020&H\u0002J$\u0010-\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0002J\u0006\u00100\u001a\u00020&J\b\u00101\u001a\u00020&H\u0002J\u001e\u00102\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0002J\b\u00105\u001a\u00020&H\u0002J\u0006\u00106\u001a\u00020&J\u0006\u00107\u001a\u00020&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006:"}, d2 = {"Landroidx/paging/LegacyPageFetcher;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "pagedListScope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Landroidx/paging/PagedList$Config;", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/paging/PagingSource;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "pageConsumer", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "keyProvider", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/LegacyPageFetcher$PageConsumer;Landroidx/paging/LegacyPageFetcher$KeyProvider;)V", "getConfig", "()Landroidx/paging/PagedList$Config;", "detached", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDetached", "", "()Z", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager$annotations", "()V", "getLoadStateManager", "()Landroidx/paging/PagedList$LoadStateManager;", "setLoadStateManager", "(Landroidx/paging/PagedList$LoadStateManager;)V", "getPageConsumer", "()Landroidx/paging/LegacyPageFetcher$PageConsumer;", "getSource", "()Landroidx/paging/PagingSource;", "detach", "", "onLoadError", "type", "Landroidx/paging/LoadType;", "throwable", "", "onLoadInvalid", "onLoadSuccess", EventBody.KEY_VALUE, "Landroidx/paging/PagingSource$LoadResult$Page;", "retry", "scheduleAppend", "scheduleLoad", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "schedulePrepend", "tryScheduleAppend", "trySchedulePrepend", "KeyProvider", "PageConsumer", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyPageFetcher<K, V> {
    private final PagedList.Config config;
    private final AtomicBoolean detached;
    private final ah fetchDispatcher;
    private final KeyProvider<K> keyProvider;
    private PagedList.LoadStateManager loadStateManager;
    private final ah notifyDispatcher;
    private final PageConsumer<V> pageConsumer;
    private final al pagedListScope;
    private final PagingSource<K, V> source;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b`\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/paging/LegacyPageFetcher$KeyProvider;", "K", "", "nextKey", "getNextKey", "()Ljava/lang/Object;", "prevKey", "getPrevKey", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface KeyProvider<K> {
        K getNextKey();

        K getPrevKey();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/paging/LegacyPageFetcher$PageConsumer;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "onPageResult", "", "type", "Landroidx/paging/LoadType;", "page", "Landroidx/paging/PagingSource$LoadResult$Page;", "onStateChanged", "", "state", "Landroidx/paging/LoadState;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PageConsumer<V> {
        boolean onPageResult(LoadType r1, PagingSource.LoadResult.Page<?, V> r2);

        void onStateChanged(LoadType r1, LoadState r2);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.PREPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ PagingSource.LoadParams<K> $params;
        final /* synthetic */ LoadType $type;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LegacyPageFetcher<K, V> this$0;

        /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00331 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ LoadType $type;
            final /* synthetic */ PagingSource.LoadResult<K, V> $value;
            int label;
            final /* synthetic */ LegacyPageFetcher<K, V> this$0;

            C00331(PagingSource.LoadResult<K, V> r3, LegacyPageFetcher<K, V> r4, LoadType r5, Continuation<? super C00331> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.$value = r3;
                this.this$0 = r4;
                this.$type = r5;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00331(this.$value, this.this$0, this.$type, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C00331) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00331.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r4);
                PagingSource.LoadResult<K, V> r5 = this.$value;
                if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Page.class) == false) goto L8;
                LegacyPageFetcher.access$onLoadSuccess(this.this$0, this.$type, (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.$value, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"));
            L14:
                return Unit.INSTANCE;
            L8:
                if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Error.class) == false) goto L11;
                LegacyPageFetcher.access$onLoadError(this.this$0, this.$type, ((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(this.$value, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable());
                goto L14
            L11:
                if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Invalid.class) == false) goto L14;
                LegacyPageFetcher.access$onLoadInvalid(this.this$0);
                goto L14
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(LegacyPageFetcher<K, V> r3, PagingSource.LoadParams<K> r4, LoadType r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            this.$type = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$params, this.$type, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            al r4 = r2;
        L12:
            PagingSource.LoadResult r12 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r11, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
            if (this.this$0.getSource().getInvalid() == false) goto L17;
            this.this$0.detach();
        L16:
            return Unit.INSTANCE;
        L17:
            i.a(r4, (CoroutineContext) ZeusTransformUtils.preCheckCast(LegacyPageFetcher.access$getNotifyDispatcher$p(this.this$0), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C00331(r12, this.this$0, this.$type, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            PagingSource<K, V> r3 = this.this$0.getSource();
            PagingSource.LoadParams<K> r5 = this.$params;
            Continuation<? super PagingSource.LoadResult<K, V>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r13;
            this.label = 1;
            Object r7 = r3.load(r5, r6);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r4 = r13;
            r11 = r7;
            goto L12
        }
    }

    public LegacyPageFetcher(al r3, PagedList.Config r4, PagingSource<K, V> r5, ah r6, ah r7, PageConsumer<V> r8, KeyProvider<K> r9) {
        al r10 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        PageConsumer<V> r11 = (PageConsumer) ZeusTransformUtils.wrapperContextForParams(r8, PageConsumer.class, "com.obric.memorydata.plugin");
        KeyProvider<K> r12 = (KeyProvider) ZeusTransformUtils.wrapperContextForParams(r9, KeyProvider.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "pagedListScope");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r6, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(r7, "fetchDispatcher");
        Intrinsics.checkNotNullParameter(r11, "pageConsumer");
        Intrinsics.checkNotNullParameter(r12, "keyProvider");
        this.pagedListScope = r10;
        this.config = r4;
        this.source = r5;
        this.notifyDispatcher = r6;
        this.fetchDispatcher = r7;
        this.pageConsumer = r11;
        this.keyProvider = r12;
        this.detached = new AtomicBoolean(false);
        this.loadStateManager = (PagedList.LoadStateManager) ZeusTransformUtils.preCheckCast(new LegacyPageFetcher$loadStateManager$1(this), PagedList.LoadStateManager.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ah access$getNotifyDispatcher$p(LegacyPageFetcher r0) {
        return r0.notifyDispatcher;
    }

    public static final /* synthetic */ void access$onLoadError(LegacyPageFetcher r0, LoadType r1, Throwable r2) {
        r0.onLoadError(r1, r2);
    }

    public static final /* synthetic */ void access$onLoadInvalid(LegacyPageFetcher r0) {
        r0.onLoadInvalid();
    }

    public static final /* synthetic */ void access$onLoadSuccess(LegacyPageFetcher r0, LoadType r1, PagingSource.LoadResult.Page r2) {
        r0.onLoadSuccess(r1, r2);
    }

    public static /* synthetic */ void getLoadStateManager$annotations() {
    }

    private final void onLoadError(LoadType r3, Throwable r4) {
        if (isDetached() == false) goto L5;
        return;
    L5:
        LoadState.Error r0 = new LoadState.Error(r4);
        this.loadStateManager.setState(r3, (LoadState) ZeusTransformUtils.preCheckCast(r0, LoadState.class, "com.obric.memorydata.plugin"));
    }

    private final void onLoadInvalid() {
        this.source.invalidate();
        detach();
    }

    private final void onLoadSuccess(LoadType r3, PagingSource.LoadResult.Page<K, V> r4) {
        if (isDetached() == false) goto L6;
        return;
    L6:
        if (this.pageConsumer.onPageResult(r3, r4) == false) goto L15;
        int r5 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r5 != 1) goto L10;
        schedulePrepend();
        return;
    L10:
        if (r5 != 2) goto L13;
        scheduleAppend();
        return;
    L13:
        throw new IllegalStateException("Can only fetch more during append/prepend");
    L15:
        PagedList.LoadStateManager r2 = this.loadStateManager;
        if (r4.getData().isEmpty() == false) goto L18;
        LoadState.NotLoading r6 = LoadState.NotLoading.Companion.getComplete$paging_common();
    L19:
        r2.setState(r3, (LoadState) ZeusTransformUtils.preCheckCast(r6, LoadState.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        r6 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        goto L19
    }

    private final void scheduleAppend() {
        K r0 = this.keyProvider.getNextKey();
        if (r0 != null) goto L6;
        onLoadSuccess(LoadType.APPEND, PagingSource.LoadResult.Page.Companion.empty$paging_common());
        return;
    L6:
        this.loadStateManager.setState(LoadType.APPEND, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
        PagingSource.LoadParams.Append r1 = new PagingSource.LoadParams.Append(r0, this.config.pageSize, this.config.enablePlaceholders);
        scheduleLoad(LoadType.APPEND, (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r1, PagingSource.LoadParams.class, "com.obric.memorydata.plugin"));
    }

    private final void scheduleLoad(LoadType r7, PagingSource.LoadParams<K> r8) {
        i.a(this.pagedListScope, (CoroutineContext) ZeusTransformUtils.preCheckCast(this.fetchDispatcher, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void schedulePrepend() {
        K r0 = this.keyProvider.getPrevKey();
        if (r0 != null) goto L6;
        onLoadSuccess(LoadType.PREPEND, PagingSource.LoadResult.Page.Companion.empty$paging_common());
        return;
    L6:
        this.loadStateManager.setState(LoadType.PREPEND, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
        PagingSource.LoadParams.Prepend r1 = new PagingSource.LoadParams.Prepend(r0, this.config.pageSize, this.config.enablePlaceholders);
        scheduleLoad(LoadType.PREPEND, (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(r1, PagingSource.LoadParams.class, "com.obric.memorydata.plugin"));
    }

    public final void detach() {
        this.detached.set(true);
    }

    public final PagedList.Config getConfig() {
        return this.config;
    }

    public final PagedList.LoadStateManager getLoadStateManager() {
        return this.loadStateManager;
    }

    public final PageConsumer<V> getPageConsumer() {
        return this.pageConsumer;
    }

    public final PagingSource<K, V> getSource() {
        return this.source;
    }

    public final boolean isDetached() {
        return this.detached.get();
    }

    public final void retry() {
        if (ZeusTransformUtils.instanceOf(this.loadStateManager.getStartState(), LoadState.Error.class) == false) goto L6;
        schedulePrepend();
    L6:
        if (ZeusTransformUtils.instanceOf(this.loadStateManager.getEndState(), LoadState.Error.class) == false) goto L9;
        scheduleAppend();
        return;
    }

    public final void setLoadStateManager(PagedList.LoadStateManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadStateManager = r2;
    }

    public final void tryScheduleAppend() {
        LoadState r0 = this.loadStateManager.getEndState();
        if (ZeusTransformUtils.instanceOf(r0, LoadState.NotLoading.class) == true) goto L5;
        return;
    L5:
        if (r0.getEndOfPaginationReached() == true) goto L9;
        scheduleAppend();
        return;
    }

    public final void trySchedulePrepend() {
        LoadState r0 = this.loadStateManager.getStartState();
        if (ZeusTransformUtils.instanceOf(r0, LoadState.NotLoading.class) == true) goto L5;
        return;
    L5:
        if (r0.getEndOfPaginationReached() == true) goto L9;
        schedulePrepend();
        return;
    }
}
