package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000f\u0018\u0000 A*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001AB'\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB1\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bB1\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\f\u0012\b\b\u0002\u0010\n\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001a\u0010,\u001a\u00020(2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020(0.J\u0014\u0010/\u001a\u00020(2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020(00J\u0019\u00101\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u00102\u001a\u00020\u001fH\u0007¢\u0006\u0002\u00103J\u0019\u00104\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u00102\u001a\u00020\u001fH\u0007¢\u0006\u0002\u00103J\u0006\u00105\u001a\u00020(J\u001a\u00106\u001a\u00020(2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020(0.J\u0014\u00107\u001a\u00020(2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020(00J\u0006\u00108\u001a\u00020(J\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:J\u001c\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?J\u001f\u0010;\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010@R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0007\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0#¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V", "workerDispatcher", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "differBase", "androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "differCallback", "Landroidx/paging/DifferCallback;", "getDifferCallback$paging_runtime_release$annotations", "()V", "getDifferCallback$paging_runtime_release", "()Landroidx/paging/DifferCallback;", "inGetItem", "", "getInGetItem$paging_runtime_release$annotations", "getInGetItem$paging_runtime_release", "()Z", "setInGetItem$paging_runtime_release", "(Z)V", "itemCount", "", "getItemCount", "()I", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "", "getOnPagesUpdatedFlow", "submitDataId", "Ljava/util/concurrent/atomic/AtomicInteger;", "addLoadStateListener", "listener", "Lkotlin/Function1;", "addOnPagesUpdatedListener", "Lkotlin/Function0;", "getItem", "index", "(I)Ljava/lang/Object;", "peek", "refresh", "removeLoadStateListener", "removeOnPagesUpdatedListener", "retry", "snapshot", "Landroidx/paging/ItemSnapshotList;", "submitData", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncPagingDataDiffer<T> {
    private static final Companion Companion = null;
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final AsyncPagingDataDiffer$differBase$1<T> differBase;
    private final DifferCallback differCallback;
    private boolean inGetItem;
    private final i<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainDispatcher;
    private final i<Unit> onPagesUpdatedFlow;
    private final AtomicInteger submitDataId;
    private final ListUpdateCallback updateCallback;
    private final CoroutineContext workerDispatcher;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer$Companion;", "", "()V", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.AsyncPagingDataDiffer$submitData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", i = {}, l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $id;
        final /* synthetic */ PagingData<T> $pagingData;
        int label;
        final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

        AnonymousClass2(AsyncPagingDataDiffer<T> r3, int r4, PagingData<T> r5, Continuation<? super AnonymousClass2> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$id = r4;
            this.$pagingData = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$id, this.$pagingData, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (AsyncPagingDataDiffer.access$getSubmitDataId$p(this.this$0).get() != this.$id) goto L14;
            AsyncPagingDataDiffer$differBase$1 r7 = AsyncPagingDataDiffer.access$getDifferBase$p(this.this$0);
            PagingData<T> r2 = this.$pagingData;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collectFrom(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
        Logger r0 = LoggerKt.getLOGGER();
        if (r0 != null) goto L5;
        r0 = (Logger) ZeusTransformUtils.preCheckCast(new Companion.AnonymousClass1(), Logger.class, "com.obric.memorydata.plugin");
    L5:
        LoggerKt.setLOGGER(r0);
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> r8, ListUpdateCallback r9) {
        ListUpdateCallback r2 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r9, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "diffCallback");
        Intrinsics.checkNotNullParameter(r2, "updateCallback");
        this(r8, r2, null, null, 12, null);
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> r10, ListUpdateCallback r11, CoroutineContext r12) {
        ListUpdateCallback r4 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r11, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r12, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "diffCallback");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        Intrinsics.checkNotNullParameter(r5, "mainDispatcher");
        this(r10, r4, r5, null, 8, null);
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> r3, ListUpdateCallback r4, CoroutineContext r5, CoroutineContext r6) {
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r4, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "diffCallback");
        Intrinsics.checkNotNullParameter(r7, "updateCallback");
        Intrinsics.checkNotNullParameter(r8, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r9, "workerDispatcher");
        this.diffCallback = r3;
        this.updateCallback = r7;
        this.mainDispatcher = r8;
        this.workerDispatcher = r9;
        DifferCallback r10 = (DifferCallback) ZeusTransformUtils.preCheckCast(new AsyncPagingDataDiffer$differCallback$1(this), DifferCallback.class, "com.obric.memorydata.plugin");
        this.differCallback = r10;
        AsyncPagingDataDiffer$differBase$1<T> r11 = new AsyncPagingDataDiffer$differBase$1(this, r10, r8);
        this.differBase = r11;
        this.submitDataId = new AtomicInteger(0);
        this.loadStateFlow = k.c((i) ZeusTransformUtils.preCheckCast(r11.getLoadStateFlow(), i.class, "com.obric.memorydata.plugin"));
        this.onPagesUpdatedFlow = r11.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback r2, ListUpdateCallback r3, CoroutineContext r4, CoroutineContext r5, int r6, DefaultConstructorMarker r7) {
        ListUpdateCallback r8 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 8) == 0) goto L8;
        r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L8:
        this(r2, r8, r9, r10);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback r4, ListUpdateCallback r5, ah r6) {
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r5, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "diffCallback");
        Intrinsics.checkNotNullParameter(r7, "updateCallback");
        Intrinsics.checkNotNullParameter(r6, "mainDispatcher");
        this(r4, r7, (CoroutineContext) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback r2, ListUpdateCallback r3, ah r4, int r5, DefaultConstructorMarker r6) {
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L5:
        this(r2, r7, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback r3, ListUpdateCallback r4, ah r5, ah r6) {
        ListUpdateCallback r7 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r4, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "diffCallback");
        Intrinsics.checkNotNullParameter(r7, "updateCallback");
        Intrinsics.checkNotNullParameter(r5, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r6, "workerDispatcher");
        this(r3, r7, (CoroutineContext) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback r2, ListUpdateCallback r3, ah r4, ah r5, int r6, DefaultConstructorMarker r7) {
        ListUpdateCallback r8 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = ba.a();
    L8:
        this(r2, r8, r4, r5);
    }

    public static final /* synthetic */ DiffUtil.ItemCallback access$getDiffCallback$p(AsyncPagingDataDiffer r0) {
        return r0.diffCallback;
    }

    public static final /* synthetic */ AsyncPagingDataDiffer$differBase$1 access$getDifferBase$p(AsyncPagingDataDiffer r0) {
        return r0.differBase;
    }

    public static final /* synthetic */ AtomicInteger access$getSubmitDataId$p(AsyncPagingDataDiffer r0) {
        return r0.submitDataId;
    }

    public static final /* synthetic */ ListUpdateCallback access$getUpdateCallback$p(AsyncPagingDataDiffer r0) {
        return r0.updateCallback;
    }

    public static final /* synthetic */ CoroutineContext access$getWorkerDispatcher$p(AsyncPagingDataDiffer r0) {
        return r0.workerDispatcher;
    }

    public static /* synthetic */ void getDifferCallback$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getInGetItem$paging_runtime_release$annotations() {
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differBase.addLoadStateListener(r4);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differBase.addOnPagesUpdatedListener(r4);
    }

    public final DifferCallback getDifferCallback$paging_runtime_release() {
        return this.differCallback;
    }

    public final boolean getInGetItem$paging_runtime_release() {
        return this.inGetItem;
    }

    public final T getItem(int r3) {
        this.inGetItem = true;     // Catch: Throwable -> L6
        T r4 = this.differBase.get(r3);     // Catch: Throwable -> L6
        this.inGetItem = false;
        return r4;
    L6:
        th = move-exception;
        this.inGetItem = false;
        throw th;
    }

    public final int getItemCount() {
        return this.differBase.getSize();
    }

    public final i<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final i<Unit> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    public final T peek(int r1) {
        return this.differBase.peek(r1);
    }

    public final void refresh() {
        this.differBase.refresh();
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differBase.removeLoadStateListener(r4);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differBase.removeOnPagesUpdatedListener(r4);
    }

    public final void retry() {
        this.differBase.retry();
    }

    public final void setInGetItem$paging_runtime_release(boolean r1) {
        this.inGetItem = r1;
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differBase.snapshot();
    }

    public final Object submitData(PagingData<T> r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.submitDataId.incrementAndGet();
        Object r2 = this.differBase.collectFrom(r3, r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    public final void submitData(Lifecycle r10, PagingData<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        Intrinsics.checkNotNullParameter(r11, "pagingData");
        int r0 = this.submitDataId.incrementAndGet();
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleKt.getCoroutineScope(r10), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r0, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
