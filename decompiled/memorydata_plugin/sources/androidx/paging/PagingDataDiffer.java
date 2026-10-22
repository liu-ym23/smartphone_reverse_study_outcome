package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000*\u0001&\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001a\u0010-\u001a\u00020\f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0/J\u0014\u00100\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\"J\u001f\u00101\u001a\u00020\f2\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u00103J\u001f\u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0002\b8J\u001a\u00109\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010:\u001a\u00020\u0014H\u0087\u0002¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010:\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010;J\b\u0010=\u001a\u00020\u0016H\u0016JE\u0010>\u001a\u0004\u0018\u00010\u00142\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010CJY\u0010>\u001a\u00020\f2\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000F0E2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00162\b\u0010I\u001a\u0004\u0018\u0001062\b\u0010J\u001a\u0004\u0018\u0001062\u0006\u0010K\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0006\u0010M\u001a\u00020\fJ\u001a\u0010N\u001a\u00020\f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0/J\u0014\u0010O\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\"J\u0006\u0010P\u001a\u00020\fJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000RR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0011\u0010(\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"Landroidx/paging/PagingDataDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "differCallback", "Landroidx/paging/DifferCallback;", "mainContext", "Lkotlin/coroutines/CoroutineContext;", "cachedPagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/DifferCallback;Lkotlin/coroutines/CoroutineContext;Landroidx/paging/PagingData;)V", "_onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "collectFromRunner", "Landroidx/paging/SingleRunner;", "combinedLoadStatesCollection", "Landroidx/paging/MutableCombinedLoadStateCollection;", "hintReceiver", "Landroidx/paging/HintReceiver;", "lastAccessedIndex", "", "lastAccessedIndexUnfulfilled", "", "loadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/Flow;", "getOnPagesUpdatedFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "presenter", "Landroidx/paging/PagePresenter;", "processPageEventCallback", "androidx/paging/PagingDataDiffer$processPageEventCallback$1", "Landroidx/paging/PagingDataDiffer$processPageEventCallback$1;", "size", "getSize", "()I", "uiReceiver", "Landroidx/paging/UiReceiver;", "addLoadStateListener", "listener", "Lkotlin/Function1;", "addOnPagesUpdatedListener", "collectFrom", "pagingData", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchLoadStates", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/paging/LoadStates;", "mediator", "dispatchLoadStates$paging_common", "get", "index", "(I)Ljava/lang/Object;", "peek", "postEvents", "presentNewList", "previousList", "Landroidx/paging/NullPaddedList;", "newList", "onListPresentable", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "placeholdersAfter", "sourceLoadStates", "mediatorLoadStates", "newHintReceiver", "(Ljava/util/List;IIZLandroidx/paging/LoadStates;Landroidx/paging/LoadStates;Landroidx/paging/HintReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "removeLoadStateListener", "removeOnPagesUpdatedListener", "retry", "snapshot", "Landroidx/paging/ItemSnapshotList;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PagingDataDiffer<T> {
    private final ad<Unit> _onPagesUpdatedFlow;
    private final SingleRunner collectFromRunner;
    private final MutableCombinedLoadStateCollection combinedLoadStatesCollection;
    private final DifferCallback differCallback;
    private HintReceiver hintReceiver;
    private volatile int lastAccessedIndex;
    private volatile boolean lastAccessedIndexUnfulfilled;
    private final ar<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainContext;
    private final CopyOnWriteArrayList<Function0<Unit>> onPagesUpdatedListeners;
    private PagePresenter<T> presenter;
    private final PagingDataDiffer$processPageEventCallback$1<T> processPageEventCallback;
    private UiReceiver uiReceiver;

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$collectFrom$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PagingData<T> $pagingData;
        int label;
        final /* synthetic */ PagingDataDiffer<T> this$0;

        AnonymousClass2(PagingDataDiffer<T> r3, PagingData<T> r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$pagingData = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$pagingData, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            PagingDataDiffer.access$setUiReceiver$p(this.this$0, this.$pagingData.getUiReceiver$paging_common());
            i<PageEvent<T>> r7 = this.$pagingData.getFlow$paging_common();
            final PagingDataDiffer<T> r3 = this.this$0;
            final PagingData<T> r4 = this.$pagingData;
            j<? super PageEvent<T>> r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r5) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$presentNewList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataDiffer", f = "PagingDataDiffer.kt", i = {0, 0, 0, 0, 0, 0}, l = {460}, m = "presentNewList", n = {"this", "sourceLoadStates", "mediatorLoadStates", "newPresenter", "onListPresentableCalled", "dispatchLoadStates"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
    static final class C09581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagingDataDiffer<T> this$0;

        C09581(PagingDataDiffer<T> r3, Continuation<? super C09581> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return PagingDataDiffer.access$presentNewList(this.this$0, null, 0, 0, false, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public PagingDataDiffer(DifferCallback r4, CoroutineContext r5, PagingData<T> r6) {
        DifferCallback r7 = (DifferCallback) ZeusTransformUtils.wrapperContextForParams(r4, DifferCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "differCallback");
        Intrinsics.checkNotNullParameter(r8, "mainContext");
        this.differCallback = r7;
        this.mainContext = r8;
        PagePresenter.Companion r9 = PagePresenter.Companion;
        DefaultConstructorMarker r10 = null;
        if (r6 == null) goto L5;
        PageEvent.Insert<T> r0 = r6.cachedEvent$paging_common();
    L6:
        this.presenter = r9.initial$paging_common(r0);
        MutableCombinedLoadStateCollection r11 = new MutableCombinedLoadStateCollection();
        if (r6 == null) goto L11;
        PageEvent.Insert<T> r12 = r6.cachedEvent$paging_common();
        if (r12 == null) goto L11;
        r11.set(r12.getSourceLoadStates(), r12.getMediatorLoadStates());
    L11:
        this.combinedLoadStatesCollection = r11;
        this.onPagesUpdatedListeners = new CopyOnWriteArrayList();
        this.collectFromRunner = new SingleRunner(false, 1, r10);
        this.processPageEventCallback = (PagingDataDiffer$processPageEventCallback$1<T>) new PagingDataDiffer$processPageEventCallback$1(this);
        this.loadStateFlow = r11.getStateFlow();
        this._onPagesUpdatedFlow = ak.a(0, 64, BufferOverflow.DROP_OLDEST);
        addOnPagesUpdatedListener((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = null;
        goto L6
    }

    public /* synthetic */ PagingDataDiffer(DifferCallback r2, CoroutineContext r3, PagingData r4, int r5, DefaultConstructorMarker r6) {
        DifferCallback r7 = (DifferCallback) ZeusTransformUtils.wrapperContextForParams(r2, DifferCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ MutableCombinedLoadStateCollection access$getCombinedLoadStatesCollection$p(PagingDataDiffer r0) {
        return r0.combinedLoadStatesCollection;
    }

    public static final /* synthetic */ DifferCallback access$getDifferCallback$p(PagingDataDiffer r0) {
        return r0.differCallback;
    }

    public static final /* synthetic */ HintReceiver access$getHintReceiver$p(PagingDataDiffer r0) {
        return r0.hintReceiver;
    }

    public static final /* synthetic */ int access$getLastAccessedIndex$p(PagingDataDiffer r0) {
        return r0.lastAccessedIndex;
    }

    public static final /* synthetic */ boolean access$getLastAccessedIndexUnfulfilled$p(PagingDataDiffer r0) {
        return r0.lastAccessedIndexUnfulfilled;
    }

    public static final /* synthetic */ CoroutineContext access$getMainContext$p(PagingDataDiffer r0) {
        return r0.mainContext;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getOnPagesUpdatedListeners$p(PagingDataDiffer r0) {
        return r0.onPagesUpdatedListeners;
    }

    public static final /* synthetic */ PagePresenter access$getPresenter$p(PagingDataDiffer r0) {
        return r0.presenter;
    }

    public static final /* synthetic */ PagingDataDiffer$processPageEventCallback$1 access$getProcessPageEventCallback$p(PagingDataDiffer r0) {
        return r0.processPageEventCallback;
    }

    public static final /* synthetic */ ad access$get_onPagesUpdatedFlow$p(PagingDataDiffer r0) {
        return r0._onPagesUpdatedFlow;
    }

    public static final /* synthetic */ Object access$presentNewList(PagingDataDiffer r11, List r12, int r13, int r14, boolean r15, LoadStates r16, LoadStates r17, HintReceiver r18, Continuation r19) {
        return r11.presentNewList((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), r13, r14, r15, r16, r17, (HintReceiver) ZeusTransformUtils.wrapperContextForParams(r18, HintReceiver.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setHintReceiver$p(PagingDataDiffer r2, HintReceiver r3) {
        r2.hintReceiver = (HintReceiver) ZeusTransformUtils.wrapperContextForParams(r3, HintReceiver.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setLastAccessedIndexUnfulfilled$p(PagingDataDiffer r0, boolean r1) {
        r0.lastAccessedIndexUnfulfilled = r1;
    }

    public static final /* synthetic */ void access$setPresenter$p(PagingDataDiffer r0, PagePresenter r1) {
        r0.presenter = r1;
    }

    public static final /* synthetic */ void access$setUiReceiver$p(PagingDataDiffer r2, UiReceiver r3) {
        r2.uiReceiver = (UiReceiver) ZeusTransformUtils.wrapperContextForParams(r3, UiReceiver.class, "com.obric.memorydata.plugin");
    }

    private final Object presentNewList(List<TransformablePage<T>> r20, final int r21, final int r22, boolean r23, final LoadStates r24, final LoadStates r25, HintReceiver r26, Continuation<? super Unit> r27) {
        PagingDataDiffer r10 = this;
        LoadStates r12 = r24;
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        final HintReceiver r4 = (HintReceiver) ZeusTransformUtils.wrapperContextForParams(r26, HintReceiver.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C09581.class) == false) goto L7;
        C09581 r1 = (C09581) ZeusTransformUtils.preCheckCast(r0, C09581.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        C09581 r14 = r1;
        Object r2 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r14.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r5 = r14.Z$0;
        Ref.BooleanRef r7 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r14.L$4, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        PagePresenter r8 = (PagePresenter) ZeusTransformUtils.preCheckCast(r14.L$3, PagePresenter.class, "com.obric.memorydata.plugin");
        LoadStates r9 = (LoadStates) ZeusTransformUtils.preCheckCast(r14.L$2, LoadStates.class, "com.obric.memorydata.plugin");
        LoadStates r11 = (LoadStates) ZeusTransformUtils.preCheckCast(r14.L$1, LoadStates.class, "com.obric.memorydata.plugin");
        PagingDataDiffer r13 = (PagingDataDiffer) ZeusTransformUtils.preCheckCast(r14.L$0, PagingDataDiffer.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        boolean r16 = r5;
        r12 = r11;
        PagingDataDiffer r17 = r13;
    L25:
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        if (r7.element == false) goto L39;
        if (r16 == false) goto L29;
        Intrinsics.checkNotNull(r12);
        r17.dispatchLoadStates$paging_common(r12, r9);
    L29:
        if (r18 != null) goto L33;
        HintReceiver r19 = r17.hintReceiver;
        if (r19 == null) goto L37;
        r19.accessHint((ViewportHint) ZeusTransformUtils.preCheckCast(r8.initializeHint(), ViewportHint.class, "com.obric.memorydata.plugin"));
    L37:
        return Unit.INSTANCE;
    L33:
        r17.lastAccessedIndex = r18.intValue();
        HintReceiver r28 = r17.hintReceiver;
        if (r28 == null) goto L37;
        r28.accessHint((ViewportHint) ZeusTransformUtils.preCheckCast(r8.accessHintForPresenterIndex(r18.intValue()), ViewportHint.class, "com.obric.memorydata.plugin"));
        goto L37
    L39:
        throw new IllegalStateException("Missing call to onListPresentable after new list was presented. If you are seeing\n this exception, it is generally an indication of an issue with Paging.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106".toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (r23 == false) goto L19;
        if (r12 != null) goto L19;
        boolean r29 = false;
    L20:
        if (r29 == false) goto L41;
        r10.lastAccessedIndexUnfulfilled = false;
        final PagePresenter r30 = new PagePresenter(r6, r21, r22);
        final Ref.BooleanRef r31 = new Ref.BooleanRef();
        NullPaddedList<T> r110 = (NullPaddedList) ZeusTransformUtils.preCheckCast(r10.presenter, NullPaddedList.class, "com.obric.memorydata.plugin");
        NullPaddedList<T> r111 = (NullPaddedList) ZeusTransformUtils.preCheckCast(r30, NullPaddedList.class, "com.obric.memorydata.plugin");
        int r32 = r10.lastAccessedIndex;
        Function0<Unit> r33 = (Function0) ZeusTransformUtils.preCheckCast(new PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1(this, r30, r31, r4, r25, r6, r21, r22, r24), Function0.class, "com.obric.memorydata.plugin");
        r14.L$0 = r10;
        r14.L$1 = r12;
        r14.L$2 = r25;
        r14.L$3 = r30;
        r14.L$4 = r31;
        r16 = r23;
        r14.Z$0 = r16;
        r14.label = 1;
        r2 = presentNewList(r110, r111, r32, r33, r14);
        if (r2 != r15) goto L24;
        return r15;
    L24:
        r9 = r25;
        r7 = r31;
        r8 = r30;
        r17 = r10;
        goto L25
    L41:
        throw new IllegalArgumentException("Cannot dispatch LoadStates in PagingDataDiffer without source LoadStates set.".toString());
    L19:
        r29 = true;
    L7:
        r1 = new C09581(r10, r0);
        goto L8
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.combinedLoadStatesCollection.addListener(r4);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onPagesUpdatedListeners.add(r4);
    }

    public final Object collectFrom(PagingData<T> r9, Continuation<? super Unit> r10) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Object r8 = SingleRunner.runInIsolation$default(this.collectFromRunner, 0, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r9, null), Function1.class, "com.obric.memorydata.plugin"), r5, 1, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final void dispatchLoadStates$paging_common(LoadStates r2, LoadStates r3) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        this.combinedLoadStatesCollection.set(r2, r3);
    }

    public final T get(int r6) {
        boolean r0 = true;
        this.lastAccessedIndexUnfulfilled = true;
        this.lastAccessedIndex = r6;
        Logger r1 = LoggerKt.getLOGGER();
        if (r1 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        r1.log(2, "Accessing item index[" + r6 + ']', null);
    L10:
        HintReceiver r2 = this.hintReceiver;
        if (r2 == null) goto L14;
        r2.accessHint((ViewportHint) ZeusTransformUtils.preCheckCast(this.presenter.accessHintForPresenterIndex(r6), ViewportHint.class, "com.obric.memorydata.plugin"));
    L14:
        return this.presenter.get(r6);
    L5:
        if (r1.isLoggable(2) != true) goto L7;
        goto L7
    }

    public final ar<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final i<Unit> getOnPagesUpdatedFlow() {
        return (i) ZeusTransformUtils.preCheckCast(k.a(this._onPagesUpdatedFlow), i.class, "com.obric.memorydata.plugin");
    }

    public final int getSize() {
        return this.presenter.getSize();
    }

    public final T peek(int r1) {
        return this.presenter.get(r1);
    }

    public boolean postEvents() {
        return false;
    }

    public abstract Object presentNewList(NullPaddedList<T> r1, NullPaddedList<T> r2, int r3, Function0<Unit> r4, Continuation<? super Integer> r5);

    public final void refresh() {
        Logger r0 = LoggerKt.getLOGGER();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r0.log(3, "Refresh signal received", null);
    L10:
        UiReceiver r5 = this.uiReceiver;
        if (r5 == null) goto L14;
        r5.refresh();
        return;
    L14:
        return;
    L5:
        if (r0.isLoggable(3) != true) goto L7;
        goto L7
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.combinedLoadStatesCollection.removeListener(r4);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onPagesUpdatedListeners.remove(r4);
    }

    public final void retry() {
        Logger r0 = LoggerKt.getLOGGER();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r0.log(3, "Retry signal received", null);
    L10:
        UiReceiver r5 = this.uiReceiver;
        if (r5 == null) goto L14;
        r5.retry();
        return;
    L14:
        return;
    L5:
        if (r0.isLoggable(3) != true) goto L7;
        goto L7
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.presenter.snapshot();
    }
}
