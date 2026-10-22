package com.obric.memorydata.memory.memoryentity;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0004B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MappingPagingSource;", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "Landroidx/paging/PagingSource;", "", "original", "mapper", "Lkotlin/Function1;", "<init>", "(Landroidx/paging/PagingSource;Lkotlin/jvm/functions/Function1;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MappingPagingSource<T, R> extends PagingSource<Integer, R> {
    private final Function1<T, R> mapper;
    private final PagingSource<Integer, T> original;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.MappingPagingSource$load$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MappingPagingSource", f = "MappingPagingSource.kt", i = {0}, l = {30}, m = "load", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MappingPagingSource<T, R> this$0;

        AnonymousClass1(MappingPagingSource<T, R> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public MappingPagingSource(PagingSource<Integer, T> r3, Function1<? super T, ? extends R> r4) {
        Function1<T, R> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "original");
        Intrinsics.checkNotNullParameter(r5, "mapper");
        this.original = r3;
        this.mapper = r5;
        r3.registerInvalidatedCallback(new $$Lambda$MappingPagingSource$EARV1vtAiaEI36wRhfaBG4aJZow(this));
    }

    private static final Unit _init_$lambda$0(MappingPagingSource r0) {
        r0.invalidate();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$EARV1vtAiaEI36wRhfaBG4aJZow(MappingPagingSource r0) {
        return _init_$lambda$0(r0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, R> r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        return (Integer) ZeusTransformUtils.preCheckCast(this.original.getRefreshKey(new PagingState(CollectionsKt.emptyList(), r5.getAnchorPosition(), r5.getConfig(), 0)), Integer.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ Integer getRefreshKey(PagingState r1) {
        return getRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> r6, Continuation<? super PagingSource.LoadResult<Integer, R>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        MappingPagingSource<T, R> this = (MappingPagingSource) ZeusTransformUtils.preCheckCast(r0.L$0, MappingPagingSource.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L17:
        PagingSource.LoadResult r10 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r9, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, PagingSource.LoadResult.Page.class) == false) goto L25;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r10, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData(), Iterable.class, "com.obric.memorydata.plugin");
        Function1<T, R> r5 = this.mapper;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        r1.add(r5.invoke(r12.next()));
        goto L21
    L23:
        Object r13 = ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r10, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey(), ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r10, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey()), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
    L32:
        return (PagingSource.LoadResult) r13;
    L25:
        if (ZeusTransformUtils.instanceOf(r10, PagingSource.LoadResult.Error.class) == false) goto L30;
        Object r14 = new PagingSource.LoadResult.Error(((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(r10, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable());
    L27:
        r13 = ZeusTransformUtils.preCheckCast(r14, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        goto L32
    L30:
        if (ZeusTransformUtils.instanceOf(r10, PagingSource.LoadResult.Invalid.class) == false) goto L34;
        this.invalidate();
        r14 = new PagingSource.LoadResult.Invalid();
        goto L27
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        PagingSource<Integer, T> r15 = this.original;
        r0.L$0 = this;
        r0.label = 1;
        r9 = r15.load(r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
