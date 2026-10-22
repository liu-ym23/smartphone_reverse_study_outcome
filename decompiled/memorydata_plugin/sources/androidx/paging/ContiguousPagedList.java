package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u0004\b\u0017\u0018\u0000 X*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0006:\u0001XBg\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0015J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bH\u0001¢\u0006\u0002\b4J\b\u00105\u001a\u000200H\u0016J\u0018\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0002J\"\u00109\u001a\u0002002\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002000;H\u0016J\u0010\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u0017H\u0017J\u0010\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u0017H\u0017J \u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0017J \u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0017J\"\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020<2\u0010\u0010J\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0018\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0018\u0010M\u001a\u0002002\u0006\u0010L\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0018\u0010N\u001a\u0002002\u0006\u0010I\u001a\u00020<2\u0006\u0010O\u001a\u00020=H\u0016J\b\u0010P\u001a\u000200H\u0016J\u0018\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020=H\u0016J\u001e\u0010T\u001a\u0002002\u0006\u0010I\u001a\u00020<2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00010UH\u0002J\u0010\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020\u001bH\u0002R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010#R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Landroidx/paging/ContiguousPagedList;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "config", "Landroidx/paging/PagedList$Config;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialLastKey", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "appendItemsRequested", "", "getBoundaryCallback$paging_common", "()Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallbackBeginDeferred", "", "boundaryCallbackEndDeferred", "highestIndexAccessed", "Ljava/lang/Object;", "isDetached", "()Z", "lastKey", "getLastKey$annotations", "()V", "getLastKey", "()Ljava/lang/Object;", "lowestIndexAccessed", "pager", "Landroidx/paging/LegacyPageFetcher;", "getPager$annotations", "getPagingSource", "()Landroidx/paging/PagingSource;", "prependItemsRequested", "replacePagesWithNulls", "shouldTrim", "deferBoundaryCallbacks", "", "deferEmpty", "deferBegin", "deferEnd", "deferBoundaryCallbacks$paging_common", "detach", "dispatchBoundaryCallbacks", "begin", "end", "dispatchCurrentLoadState", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "loadAroundInternal", "index", "onInitialized", CommonConsts.COUNT_TYPE, "onPageAppended", "endPosition", "changed", "added", "onPagePrepended", "leadingNulls", "onPageResult", "type", "page", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "onStateChanged", "state", "retry", "setInitialLoadState", "loadType", "loadState", "triggerBoundaryCallback", "", "tryDispatchBoundaryCallbacks", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ContiguousPagedList<K, V> extends PagedList<V> implements LegacyPageFetcher.PageConsumer<V>, PagedStorage.Callback {
    public static final Companion Companion = null;
    private int appendItemsRequested;
    private final PagedList.BoundaryCallback<V> boundaryCallback;
    private boolean boundaryCallbackBeginDeferred;
    private boolean boundaryCallbackEndDeferred;
    private int highestIndexAccessed;
    private final K initialLastKey;
    private int lowestIndexAccessed;
    private final LegacyPageFetcher<K, V> pager;
    private final PagingSource<K, V> pagingSource;
    private int prependItemsRequested;
    private boolean replacePagesWithNulls;
    private final boolean shouldTrim;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bJ%\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/ContiguousPagedList$Companion;", "", "()V", "getAppendItemsRequested", "", "prefetchDistance", "index", "itemsBeforeTrailingNulls", "getAppendItemsRequested$paging_common", "getPrependItemsRequested", "leadingNulls", "getPrependItemsRequested$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int getAppendItemsRequested$paging_common(int r1, int r2, int r3) {
            return ((r2 + r1) + 1) - r3;
        }

        public final int getPrependItemsRequested$paging_common(int r1, int r2, int r3) {
            return r1 - (r2 - r3);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1", f = "ContiguousPagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $dispatchBegin;
        final /* synthetic */ boolean $dispatchEnd;
        int label;
        final /* synthetic */ ContiguousPagedList<K, V> this$0;

        AnonymousClass1(ContiguousPagedList<K, V> r3, boolean r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$dispatchBegin = r4;
            this.$dispatchEnd = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$dispatchBegin, this.$dispatchEnd, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ContiguousPagedList.access$dispatchBoundaryCallbacks(this.this$0, this.$dispatchBegin, this.$dispatchEnd);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ContiguousPagedList(PagingSource<K, V> r23, al r24, ah r25, ah r26, PagedList.BoundaryCallback<V> r27, PagedList.Config r28, PagingSource.LoadResult.Page<K, V> r29, K r30) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r24, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "pagingSource");
        Intrinsics.checkNotNullParameter(r8, "coroutineScope");
        Intrinsics.checkNotNullParameter(r25, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(r26, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(r28, "config");
        Intrinsics.checkNotNullParameter(r29, "initialPage");
        super(r23, r8, r25, new PagedStorage(), r28);
        this.pagingSource = r23;
        this.boundaryCallback = r27;
        this.initialLastKey = r30;
        this.lowestIndexAccessed = Integer.MAX_VALUE;
        this.highestIndexAccessed = Integer.MIN_VALUE;
        if (r28.maxSize == Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        this.shouldTrim = r0;
        LegacyPageFetcher.PageConsumer r2 = (LegacyPageFetcher.PageConsumer) ZeusTransformUtils.preCheckCast(this, LegacyPageFetcher.PageConsumer.class, "com.obric.memorydata.plugin");
        PagedStorage<V> r5 = getStorage$paging_common();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K of androidx.paging.ContiguousPagedList>");
        this.pager = new LegacyPageFetcher(r8, r28, r23, r25, r26, r2, (LegacyPageFetcher.KeyProvider) ZeusTransformUtils.preCheckCast(r5, LegacyPageFetcher.KeyProvider.class, "com.obric.memorydata.plugin"));
        boolean r1 = r28.enablePlaceholders;
        PagedStorage<V> r15 = getStorage$paging_common();
        if (r1 == true) goto L9;
        int r16 = 0;
        int r18 = 0;
        if (r29.getItemsBefore() == Integer.MIN_VALUE) goto L25;
        int r19 = r29.getItemsBefore();
    L26:
        PagedStorage.Callback r20 = (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin");
        boolean r21 = false;
    L27:
        r15.init(r16, r29, r18, r19, r20, r21);
        triggerBoundaryCallback(LoadType.REFRESH, r29.getData());
        return;
    L25:
        r19 = 0;
        goto L26
    L9:
        if (r29.getItemsBefore() == Integer.MIN_VALUE) goto L11;
        r16 = r29.getItemsBefore();
    L13:
        if (r29.getItemsAfter() == Integer.MIN_VALUE) goto L15;
        r18 = r29.getItemsAfter();
    L16:
        r19 = 0;
        r20 = (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin");
        if (r29.getItemsBefore() != Integer.MIN_VALUE) goto L19;
    L21:
        r21 = false;
        goto L27
    L19:
        if (r29.getItemsAfter() == Integer.MIN_VALUE) goto L21;
        r21 = true;
        goto L27
    L15:
        r18 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ void access$dispatchBoundaryCallbacks(ContiguousPagedList r0, boolean r1, boolean r2) {
        r0.dispatchBoundaryCallbacks(r1, r2);
    }

    public static final /* synthetic */ void access$setBoundaryCallbackBeginDeferred$p(ContiguousPagedList r0, boolean r1) {
        r0.boundaryCallbackBeginDeferred = r1;
    }

    public static final /* synthetic */ void access$setBoundaryCallbackEndDeferred$p(ContiguousPagedList r0, boolean r1) {
        r0.boundaryCallbackEndDeferred = r1;
    }

    public static final /* synthetic */ void access$tryDispatchBoundaryCallbacks(ContiguousPagedList r0, boolean r1) {
        r0.tryDispatchBoundaryCallbacks(r1);
    }

    private final void dispatchBoundaryCallbacks(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        PagedList.BoundaryCallback<V> r4 = this.boundaryCallback;
        Intrinsics.checkNotNull(r4);
        r4.onItemAtFrontLoaded(getStorage$paging_common().getFirstLoadedItem$paging_common());
    L4:
        if (r3 == false) goto L7;
        PagedList.BoundaryCallback<V> r5 = this.boundaryCallback;
        Intrinsics.checkNotNull(r5);
        r5.onItemAtEndLoaded(getStorage$paging_common().getLastLoadedItem$paging_common());
        return;
    }

    public static /* synthetic */ void getLastKey$annotations() {
    }

    private static /* synthetic */ void getPager$annotations() {
    }

    private final void triggerBoundaryCallback(LoadType r6, List<? extends V> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (this.boundaryCallback == null) goto L24;
        boolean r1 = true;
        if (getStorage$paging_common().size() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L14:
        boolean r3 = false;
    L15:
        if (r0 == false) goto L17;
    L21:
        r1 = false;
    L22:
        deferBoundaryCallbacks$paging_common(r0, r3, r1);
        return;
    L17:
        if (r6 != LoadType.APPEND) goto L21;
        if (r8.isEmpty() == false) goto L21;
    L10:
        if (r6 != LoadType.PREPEND) goto L14;
        if (r8.isEmpty() == false) goto L14;
        r3 = true;
        goto L15
    L7:
        r0 = false;
        goto L8
    }

    private final void tryDispatchBoundaryCallbacks(boolean r10) {
        boolean r1 = true;
        if (this.boundaryCallbackBeginDeferred == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (this.boundaryCallbackEndDeferred == true) goto L11;
    L13:
        r1 = false;
    L14:
        if (r0 == true) goto L17;
        if (r1 == true) goto L17;
        return;
    L17:
        if (r0 == false) goto L19;
        this.boundaryCallbackBeginDeferred = false;
    L19:
        if (r1 == false) goto L21;
        this.boundaryCallbackEndDeferred = false;
    L21:
        if (r10 == false) goto L23;
        i.a(getCoroutineScope$paging_common(), (CoroutineContext) ZeusTransformUtils.preCheckCast(getNotifyDispatcher$paging_common(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r0, r1, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L23:
        dispatchBoundaryCallbacks(r0, r1);
        return;
    L11:
        if (this.highestIndexAccessed < ((size() - 1) - getConfig().prefetchDistance)) goto L13;
    L5:
        if (this.lowestIndexAccessed > getConfig().prefetchDistance) goto L7;
        r0 = true;
        goto L9
    }

    public final void deferBoundaryCallbacks$paging_common(boolean r12, boolean r13, boolean r14) {
        if (this.boundaryCallback == null) goto L16;
        if (this.lowestIndexAccessed != Integer.MAX_VALUE) goto L8;
        this.lowestIndexAccessed = getStorage$paging_common().size();
    L8:
        if (this.highestIndexAccessed != Integer.MIN_VALUE) goto L10;
        this.highestIndexAccessed = 0;
    L10:
        if (r12 == true) goto L13;
        if (r13 == true) goto L13;
        if (r14 == true) goto L13;
        return;
    L13:
        i.a(getCoroutineScope$paging_common(), (CoroutineContext) ZeusTransformUtils.preCheckCast(getNotifyDispatcher$paging_common(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new ContiguousPagedList$deferBoundaryCallbacks$1(r12, this, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L16:
        throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
    }

    @Override // androidx.paging.PagedList
    public void detach() {
        this.pager.detach();
    }

    @Override // androidx.paging.PagedList
    public void dispatchCurrentLoadState(Function2<? super LoadType, ? super LoadState, Unit> r3) {
        Function2<? super LoadType, ? super LoadState, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.pager.getLoadStateManager().dispatchCurrentLoadState(r4);
    }

    public final PagedList.BoundaryCallback<V> getBoundaryCallback$paging_common() {
        return this.boundaryCallback;
    }

    @Override // androidx.paging.PagedList
    public K getLastKey() {
        PagingState<?, V> r0 = getStorage$paging_common().getRefreshKeyInfo(getConfig());
        if (r0 == null) goto L8;
        K r1 = this.pagingSource.getRefreshKey(r0);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.initialLastKey;
    }

    @Override // androidx.paging.PagedList
    public final PagingSource<K, V> getPagingSource() {
        return this.pagingSource;
    }

    @Override // androidx.paging.PagedList
    public boolean isDetached() {
        return this.pager.isDetached();
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int r6) {
        Companion r0 = Companion;
        int r1 = r0.getPrependItemsRequested$paging_common(getConfig().prefetchDistance, r6, getStorage$paging_common().getPlaceholdersBefore());
        int r2 = r0.getAppendItemsRequested$paging_common(getConfig().prefetchDistance, r6, getStorage$paging_common().getPlaceholdersBefore() + getStorage$paging_common().getStorageCount());
        int r3 = Math.max(r1, this.prependItemsRequested);
        this.prependItemsRequested = r3;
        if (r3 <= 0) goto L5;
        this.pager.trySchedulePrepend();
    L5:
        int r4 = Math.max(r2, this.appendItemsRequested);
        this.appendItemsRequested = r4;
        if (r4 <= 0) goto L8;
        this.pager.tryScheduleAppend();
    L8:
        this.lowestIndexAccessed = Math.min(this.lowestIndexAccessed, r6);
        this.highestIndexAccessed = Math.max(this.highestIndexAccessed, r6);
        tryDispatchBoundaryCallbacks(true);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onInitialized(int r2) {
        boolean r0 = false;
        notifyInserted$paging_common(0, r2);
        if (getStorage$paging_common().getPlaceholdersBefore() <= 0) goto L5;
    L6:
        r0 = true;
    L7:
        this.replacePagesWithNulls = r0;
        return;
    L5:
        if (getStorage$paging_common().getPlaceholdersAfter() <= 0) goto L7;
        goto L6
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageAppended(int r1, int r2, int r3) {
        notifyChanged(r1, r2);
        notifyInserted$paging_common(r1 + r2, r3);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePrepended(int r1, int r2, int r3) {
        notifyChanged(r1, r2);
        notifyInserted$paging_common(0, r3);
        this.lowestIndexAccessed += r3;
        this.highestIndexAccessed += r3;
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public boolean onPageResult(LoadType r9, PagingSource.LoadResult.Page<?, V> r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "page");
        List<? extends V> r0 = r10.getData();
        boolean r3 = false;
        if (lastLoad() <= getStorage$paging_common().getMiddleOfLoadedRange()) goto L5;
        boolean r1 = true;
    L7:
        if (this.shouldTrim == true) goto L9;
    L11:
        boolean r2 = false;
    L13:
        if (r9 != LoadType.APPEND) goto L23;
        if (r2 == false) goto L17;
        if (r1 == true) goto L17;
        this.appendItemsRequested = 0;
    L33:
        if (this.shouldTrim == false) goto L47;
        PagedList.LoadStateManager r11 = this.pager.getLoadStateManager();
        if (r1 == false) goto L42;
        if (ZeusTransformUtils.instanceOf(r11.getStartState(), LoadState.Loading.class) == true) goto L47;
        if (getStorage$paging_common().trimFromFront$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder$paging_common(), (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin")) == false) goto L47;
        PagedList.LoadStateManager r12 = this.pager.getLoadStateManager();
        LoadType r4 = LoadType.PREPEND;
    L46:
        r12.setState(r4, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
        goto L47
    L42:
        if (ZeusTransformUtils.instanceOf(r11.getEndState(), LoadState.Loading.class) == true) goto L47;
        if (getStorage$paging_common().trimFromEnd$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder$paging_common(), (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin")) == false) goto L47;
        r12 = this.pager.getLoadStateManager();
        r4 = LoadType.APPEND;
    L47:
        triggerBoundaryCallback(r9, r0);
        return r3;
    L17:
        getStorage$paging_common().appendPage$paging_common(r10, (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin"));
        int r13 = this.appendItemsRequested - r0.size();
        this.appendItemsRequested = r13;
        if (r13 <= 0) goto L33;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
    L21:
        r3 = true;
        goto L33
    L23:
        if (r9 != LoadType.PREPEND) goto L50;
        if (r2 == false) goto L27;
        if (r1 == false) goto L27;
        this.prependItemsRequested = 0;
    L27:
        getStorage$paging_common().prependPage$paging_common(r10, (PagedStorage.Callback) ZeusTransformUtils.preCheckCast(this, PagedStorage.Callback.class, "com.obric.memorydata.plugin"));
        int r14 = this.prependItemsRequested - r0.size();
        this.prependItemsRequested = r14;
        if (r14 <= 0) goto L33;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
    L50:
        throw new IllegalArgumentException("unexpected result type " + r9);
    L9:
        if (getStorage$paging_common().shouldPreTrimNewPage(getConfig().maxSize, getRequiredRemainder$paging_common(), r0.size()) == false) goto L11;
        r2 = true;
        goto L13
    L5:
        r1 = false;
        goto L7
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesRemoved(int r1, int r2) {
        notifyRemoved(r1, r2);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesSwappedToPlaceholder(int r1, int r2) {
        notifyChanged(r1, r2);
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public void onStateChanged(LoadType r2, LoadState r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "state");
        dispatchStateChangeAsync$paging_common(r2, r3);
    }

    @Override // androidx.paging.PagedList
    public void retry() {
        super.retry();
        this.pager.retry();
        if (ZeusTransformUtils.instanceOf(this.pager.getLoadStateManager().getRefreshState(), LoadState.Error.class) == false) goto L8;
        Runnable r2 = getRefreshRetryCallback$paging_common();
        if (r2 == null) goto L9;
        r2.run();
        return;
    L9:
        return;
    }

    @Override // androidx.paging.PagedList
    public void setInitialLoadState(LoadType r2, LoadState r3) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        Intrinsics.checkNotNullParameter(r3, "loadState");
        this.pager.getLoadStateManager().setState(r2, r3);
    }
}
