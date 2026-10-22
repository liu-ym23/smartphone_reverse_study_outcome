package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.y;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001FB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0/J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0/J#\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0000¢\u0006\u0002\b5J\u0014\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000109J\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001092\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0013J\u0015\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\b>J,\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0007J+\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00010D*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\bER \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\u001bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0019¨\u0006G"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "_pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "_placeholdersAfter", "", "_placeholdersBefore", "appendGenerationId", "appendGenerationIdCh", "Lkotlinx/coroutines/channels/Channel;", "failedHintsByLoadType", "", "Landroidx/paging/LoadType;", "Landroidx/paging/ViewportHint;", "getFailedHintsByLoadType$paging_common", "()Ljava/util/Map;", "<set-?>", "initialPageIndex", "getInitialPageIndex$paging_common", "()I", "pages", "", "getPages$paging_common", "()Ljava/util/List;", EventBody.KEY_VALUE, "placeholdersAfter", "getPlaceholdersAfter$paging_common", "setPlaceholdersAfter$paging_common", "(I)V", "placeholdersBefore", "getPlaceholdersBefore$paging_common", "setPlaceholdersBefore$paging_common", "prependGenerationId", "prependGenerationIdCh", "Landroidx/paging/MutableLoadStateCollection;", "sourceLoadStates", "getSourceLoadStates$paging_common", "()Landroidx/paging/MutableLoadStateCollection;", "storageCount", "getStorageCount$paging_common", "consumeAppendGenerationIdAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumePrependGenerationIdAsFlow", "currentPagingState", "Landroidx/paging/PagingState;", "viewportHint", "Landroidx/paging/ViewportHint$Access;", "currentPagingState$paging_common", "drop", "", "event", "Landroidx/paging/PageEvent$Drop;", "dropEventOrNull", "loadType", "hint", "generationId", "generationId$paging_common", "insert", "", "loadId", "page", "toPageEvent", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common", "Holder", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    private int appendGenerationId;
    private final i<Integer> appendGenerationIdCh;
    private final PagingConfig config;
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    private int prependGenerationId;
    private final i<Integer> prependGenerationIdCh;
    private MutableLoadStateCollection sourceLoadStates;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JF\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0004\u0010\f2-\u0010\r\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\f0\u000eH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "lock", "Lkotlinx/coroutines/sync/Mutex;", "state", "Landroidx/paging/PageFetcherSnapshotState;", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        private final a lock;
        private final PageFetcherSnapshotState<Key, Value> state;

        public Holder(PagingConfig r4) {
            Intrinsics.checkNotNullParameter(r4, "config");
            this.config = r4;
            this.lock = c.a(false, 1, null);
            this.state = new PageFetcherSnapshotState(r4, null);
        }

        public static final /* synthetic */ a access$getLock$p(Holder r0) {
            return r0.lock;
        }

        public static final /* synthetic */ PageFetcherSnapshotState access$getState$p(Holder r0) {
            return r0.state;
        }

        private final <T> Object withLock$$forInline(Function1<? super PageFetcherSnapshotState<Key, Value>, ? extends T> r3, Continuation<? super T> r4) {
            Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            a r0 = access$getLock$p(this);
            InlineMarker.mark(0);
            r0.a(null, r6);
            InlineMarker.mark(1);
            Object r2 = r5.invoke(access$getState$p(this));     // Catch: Throwable -> L6
            InlineMarker.finallyStart(1);
            r0.b(null);
            InlineMarker.finallyEnd(1);
            return r2;
        L6:
            th = move-exception;
            InlineMarker.finallyStart(1);
            r0.b(null);
            InlineMarker.finallyEnd(1);
            throw th;
        }

        public final <T> Object withLock(Function1<? super PageFetcherSnapshotState<Key, Value>, ? extends T> r7, Continuation<? super T> r8) {
            Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, PageFetcherSnapshotState$Holder$withLock$1.class) == false) goto L7;
            PageFetcherSnapshotState$Holder$withLock$1 r0 = (PageFetcherSnapshotState$Holder$withLock$1) ZeusTransformUtils.preCheckCast(r10, PageFetcherSnapshotState$Holder$withLock$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r0.L$2, a.class, "com.obric.memorydata.plugin");
            r9 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$1, Function1.class, "com.obric.memorydata.plugin");
            Holder<Key, Value> r1 = (Holder) ZeusTransformUtils.preCheckCast(r0.L$0, Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            a r12 = r6;
            Holder<Key, Value> this = r1;
        L23:
            Object r13 = r9.invoke(access$getState$p(this));     // Catch: Throwable -> L20
            InlineMarker.finallyStart(1);
            r12.b(null);
            InlineMarker.finallyEnd(1);
            return r13;
        L20:
            th = move-exception;
            InlineMarker.finallyStart(1);
            r12.b(null);
            InlineMarker.finallyEnd(1);
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r11);
            r12 = access$getLock$p(this);
            r0.L$0 = this;
            r0.L$1 = r9;
            r0.L$2 = r12;
            r0.label = 1;
            if (r12.a(null, r0) != r2) goto L23;
            return r2;
        L7:
            r0 = new PageFetcherSnapshotState$Holder$withLock$1(this, r10);
            goto L8
        }
    }

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

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<j<? super Integer>, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        AnonymousClass1(PageFetcherSnapshotState<Key, Value> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(j<? super Integer> r3, Continuation<? super Unit> r4) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super Integer> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            PageFetcherSnapshotState.access$getAppendGenerationIdCh$p(this.this$0).mo54trySendJP2dKIU(Boxing.boxInt(PageFetcherSnapshotState.access$getAppendGenerationId$p(this.this$0)));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09491 extends SuspendLambda implements Function2<j<? super Integer>, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        C09491(PageFetcherSnapshotState<Key, Value> r3, Continuation<? super C09491> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09491(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(j<? super Integer> r3, Continuation<? super Unit> r4) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super Integer> r3, Continuation<? super Unit> r4) {
            return ((C09491) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09491.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            PageFetcherSnapshotState.access$getPrependGenerationIdCh$p(this.this$0).mo54trySendJP2dKIU(Boxing.boxInt(PageFetcherSnapshotState.access$getPrependGenerationId$p(this.this$0)));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private PageFetcherSnapshotState(PagingConfig r5) {
        this.config = r5;
        List<PagingSource.LoadResult.Page<Key, Value>> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this._pages = r6;
        this.pages = r6;
        this.prependGenerationIdCh = l.a(-1, null, null, 6, null);
        this.appendGenerationIdCh = l.a(-1, null, null, 6, null);
        this.failedHintsByLoadType = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        MutableLoadStateCollection r7 = new MutableLoadStateCollection();
        r7.set(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
        this.sourceLoadStates = r7;
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static final /* synthetic */ int access$getAppendGenerationId$p(PageFetcherSnapshotState r0) {
        return r0.appendGenerationId;
    }

    public static final /* synthetic */ i access$getAppendGenerationIdCh$p(PageFetcherSnapshotState r0) {
        return r0.appendGenerationIdCh;
    }

    public static final /* synthetic */ int access$getPrependGenerationId$p(PageFetcherSnapshotState r0) {
        return r0.prependGenerationId;
    }

    public static final /* synthetic */ i access$getPrependGenerationIdCh$p(PageFetcherSnapshotState r0) {
        return r0.prependGenerationIdCh;
    }

    public final kotlinx.coroutines.flow.i<Integer> consumeAppendGenerationIdAsFlow() {
        return k.b(k.b((y) ZeusTransformUtils.preCheckCast(this.appendGenerationIdCh, y.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public final kotlinx.coroutines.flow.i<Integer> consumePrependGenerationIdAsFlow() {
        return k.b(k.b((y) ZeusTransformUtils.preCheckCast(this.prependGenerationIdCh, y.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new C09491(this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public final PagingState<Key, Value> currentPagingState$paging_common(ViewportHint.Access r10) {
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L14;
        int r1 = getPlaceholdersBefore$paging_common();
        int r3 = -this.initialPageIndex;
        int r4 = CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
        int r5 = r10.getPageOffset();
        int r6 = r3;
    L5:
        if (r6 >= r5) goto L10;
        if (r6 <= r4) goto L8;
        int r7 = this.config.pageSize;
    L9:
        r1 = r1 + r7;
        r6 = r6 + 1;
        goto L5
    L8:
        r7 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(this.initialPageIndex + r6), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        goto L9
    L10:
        int r2 = r1 + r10.getIndexInPage();
        if (r10.getPageOffset() >= r3) goto L13;
        r2 = r2 - this.config.pageSize;
    L13:
        Integer r11 = Integer.valueOf(r2);
    L16:
        return new PagingState(r0, r11, this.config, getPlaceholdersBefore$paging_common());
    L14:
        r11 = null;
        goto L16
    }

    public final void drop(PageEvent.Drop<Value> r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        int r2 = 0;
        if (r8.getPageCount() > this.pages.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L24;
        this.failedHintsByLoadType.remove(r8.getLoadType());
        this.sourceLoadStates.set(r8.getLoadType(), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
        int r1 = WhenMappings.$EnumSwitchMapping$0[r8.getLoadType().ordinal()];
        if (r1 != 2) goto L10;
        int r3 = r8.getPageCount();
        int r4 = 0;
    L18:
        if (r4 >= r3) goto L20;
        this._pages.remove(0);
        r4 = r4 + 1;
        goto L18
    L20:
        this.initialPageIndex -= r8.getPageCount();
        setPlaceholdersBefore$paging_common(r8.getPlaceholdersRemaining());
        int r9 = this.prependGenerationId + 1;
        this.prependGenerationId = r9;
        i<Integer> r7 = this.prependGenerationIdCh;
    L21:
        r7.mo54trySendJP2dKIU(Integer.valueOf(r9));
        return;
    L10:
        if (r1 != 3) goto L16;
        int r5 = r8.getPageCount();
    L12:
        if (r2 >= r5) goto L14;
        this._pages.remove(this.pages.size() - 1);
        r2 = r2 + 1;
        goto L12
    L14:
        setPlaceholdersAfter$paging_common(r8.getPlaceholdersRemaining());
        r9 = this.appendGenerationId + 1;
        this.appendGenerationId = r9;
        r7 = this.appendGenerationIdCh;
        goto L21
    L16:
        throw new IllegalArgumentException("cannot drop " + r8.getLoadType());
    L24:
        throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + r8.getPageCount()).toString());
    L5:
        r0 = false;
        goto L6
    }

    public final PageEvent.Drop<Value> dropEventOrNull(LoadType r10, ViewportHint r11) {
        Intrinsics.checkNotNullParameter(r10, "loadType");
        Intrinsics.checkNotNullParameter(r11, "hint");
        PageEvent.Drop<Value> r1 = null;
        if (this.config.maxSize != Integer.MAX_VALUE) goto L6;
        return null;
    L6:
        if (this.pages.size() > 2) goto L9;
        return null;
    L9:
        if (getStorageCount$paging_common() > this.config.maxSize) goto L11;
        return null;
    L11:
        int r4 = 0;
        if (r10 == LoadType.REFRESH) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L53;
        int r2 = 0;
        int r5 = 0;
    L18:
        if (r2 >= this.pages.size()) goto L32;
        if ((getStorageCount$paging_common() - r5) <= this.config.maxSize) goto L32;
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] != 2) goto L24;
        PagingSource.LoadResult.Page<Key, Value> r6 = this.pages.get(r2);
    L25:
        int r7 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r6, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] != 2) goto L28;
        int r8 = r11.getPresentedItemsBefore();
    L30:
        if (((r8 - r5) - r7) < this.config.prefetchDistance) goto L32;
        r5 = r5 + r7;
        r2 = r2 + 1;
        goto L18
    L28:
        r8 = r11.getPresentedItemsAfter();
        goto L30
    L24:
        List<PagingSource.LoadResult.Page<Key, Value>> r9 = this.pages;
        r6 = r9.get(CollectionsKt.getLastIndex(r9) - r2);
    L32:
        if (r2 != 0) goto L35;
    L51:
        return r1;
    L35:
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] != 2) goto L37;
        int r12 = -this.initialPageIndex;
    L39:
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] != 2) goto L41;
        int r3 = r2 - 1;
    L42:
        int r13 = r3 - this.initialPageIndex;
        if (this.config.enablePlaceholders == true) goto L46;
    L50:
        r1 = new PageEvent.Drop(r10, r12, r13, r4);
        goto L51
    L46:
        if (r10 != LoadType.PREPEND) goto L48;
        int r14 = getPlaceholdersBefore$paging_common();
    L49:
        r4 = r14 + r5;
        goto L50
    L48:
        r14 = getPlaceholdersAfter$paging_common();
        goto L49
    L41:
        r3 = CollectionsKt.getLastIndex(this.pages);
        goto L42
    L37:
        r12 = (CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex) - (r2 - 1);
        goto L39
    L53:
        throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + r10).toString());
    L14:
        r0 = false;
        goto L15
    }

    public final int generationId$paging_common(LoadType r2) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L10;
        return this.appendGenerationId;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return this.prependGenerationId;
    L14:
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }

    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common() {
        return this.failedHintsByLoadType;
    }

    public final int getInitialPageIndex$paging_common() {
        return this.initialPageIndex;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common() {
        return this.pages;
    }

    public final int getPlaceholdersAfter$paging_common() {
        if (this.config.enablePlaceholders == true) goto L7;
        return 0;
    L7:
        return this._placeholdersAfter;
    }

    public final int getPlaceholdersBefore$paging_common() {
        if (this.config.enablePlaceholders == true) goto L7;
        return 0;
    L7:
        return this._placeholdersBefore;
    }

    public final MutableLoadStateCollection getSourceLoadStates$paging_common() {
        return this.sourceLoadStates;
    }

    public final int getStorageCount$paging_common() {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r4.next(), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        goto L4
    L6:
        return r0;
    }

    public final boolean insert(int r6, LoadType r7, PagingSource.LoadResult.Page<Key, Value> r8) {
        Intrinsics.checkNotNullParameter(r7, "loadType");
        Intrinsics.checkNotNullParameter(r8, "page");
        int r9 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r9 == 1) goto L35;
        if (r9 == 2) goto L22;
        if (r9 == 3) goto L10;
    L41:
        return true;
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.pages, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        if (r6 == this.appendGenerationId) goto L14;
        return false;
    L14:
        this._pages.add(r8);
        if (r8.getItemsAfter() != Integer.MIN_VALUE) goto L17;
        int r10 = RangesKt.coerceAtLeast(getPlaceholdersAfter$paging_common() - r8.getData().size(), 0);
    L18:
        setPlaceholdersAfter$paging_common(r10);
        Map<LoadType, ViewportHint> r5 = this.failedHintsByLoadType;
        LoadType r11 = LoadType.APPEND;
    L31:
        r5.remove(r11);
        goto L41
    L17:
        r10 = r8.getItemsAfter();
        goto L18
    L20:
        throw new IllegalStateException("should've received an init before append".toString());
    L22:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.pages, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
        if (r6 == this.prependGenerationId) goto L26;
        return false;
    L26:
        this._pages.add(0, r8);
        this.initialPageIndex++;
        if (r8.getItemsBefore() != Integer.MIN_VALUE) goto L29;
        int r12 = RangesKt.coerceAtLeast(getPlaceholdersBefore$paging_common() - r8.getData().size(), 0);
    L30:
        setPlaceholdersBefore$paging_common(r12);
        r5 = this.failedHintsByLoadType;
        r11 = LoadType.PREPEND;
        goto L31
    L29:
        r12 = r8.getItemsBefore();
        goto L30
    L33:
        throw new IllegalStateException("should've received an init before prepend".toString());
    L35:
        if (this.pages.isEmpty() == false) goto L45;
        if (r6 != 0) goto L38;
        boolean r13 = true;
    L39:
        if (r13 == false) goto L43;
        this._pages.add(r8);
        this.initialPageIndex = 0;
        setPlaceholdersAfter$paging_common(r8.getItemsAfter());
        setPlaceholdersBefore$paging_common(r8.getItemsBefore());
        goto L41
    L43:
        throw new IllegalStateException("init loadId must be the initial value, 0".toString());
    L38:
        r13 = false;
        goto L39
    L45:
        throw new IllegalStateException("cannot receive multiple init calls".toString());
    }

    public final void setPlaceholdersAfter$paging_common(int r2) {
        if (r2 != Integer.MIN_VALUE) goto L5;
        r2 = 0;
    L5:
        this._placeholdersAfter = r2;
    }

    public final void setPlaceholdersBefore$paging_common(int r2) {
        if (r2 != Integer.MIN_VALUE) goto L5;
        r2 = 0;
    L5:
        this._placeholdersBefore = r2;
    }

    public final PageEvent<Value> toPageEvent$paging_common(PagingSource.LoadResult.Page<Key, Value> r12, LoadType r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "loadType");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        int r1 = 0;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        r1 = (this.pages.size() - this.initialPageIndex) - 1;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r1 = 0 - this.initialPageIndex;
    L10:
        List r6 = CollectionsKt.listOf(new TransformablePage(r1, r12.getData()));
        int r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r14 != 1) goto L13;
        PageEvent.Insert r11 = PageEvent.Insert.Companion.Refresh(r6, getPlaceholdersBefore$paging_common(), getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
    L21:
        return (PageEvent) ZeusTransformUtils.preCheckCast(r11, PageEvent.class, "com.obric.memorydata.plugin");
    L13:
        if (r14 == 2) goto L18;
        if (r14 != 3) goto L17;
        r11 = PageEvent.Insert.Companion.Append(r6, getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
        goto L21
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        r11 = PageEvent.Insert.Companion.Prepend(r6, getPlaceholdersBefore$paging_common(), this.sourceLoadStates.snapshot(), null);
        goto L21
    }
}
