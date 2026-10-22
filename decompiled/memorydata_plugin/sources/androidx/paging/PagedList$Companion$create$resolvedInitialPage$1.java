package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: Add missing generic type declarations: [T, K] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "K", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagedList$Companion$create$resolvedInitialPage$1", f = "PagedList.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
final class PagedList$Companion$create$resolvedInitialPage$1<K, T> extends SuspendLambda implements Function2<al, Continuation<? super PagingSource.LoadResult.Page<K, T>>, Object> {
    final /* synthetic */ PagingSource<K, T> $pagingSource;
    final /* synthetic */ PagingSource.LoadParams.Refresh<K> $params;
    int label;

    PagedList$Companion$create$resolvedInitialPage$1(PagingSource<K, T> r3, PagingSource.LoadParams.Refresh<K> r4, Continuation<? super PagedList$Companion$create$resolvedInitialPage$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$pagingSource = r3;
        this.$params = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PagedList$Companion$create$resolvedInitialPage$1(this.$pagingSource, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super PagingSource.LoadResult.Page<K, T>> r4) {
        return ((PagedList$Companion$create$resolvedInitialPage$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PagedList$Companion$create$resolvedInitialPage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        PagingSource.LoadResult r5 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r6, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Page.class) == false) goto L16;
        return (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r5, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Error.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, PagingSource.LoadResult.Invalid.class) == false) goto L22;
        throw new IllegalStateException("Failed to create PagedList. The provided PagingSource returned LoadResult.Invalid, but a LoadResult.Page was expected. To use a PagingSource which supports invalidation, use a PagedList builder that accepts a factory method for PagingSource or DataSource.Factory, such as LivePagedList.");
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        throw ((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(r5, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PagingSource<K, T> r7 = this.$pagingSource;
        PagingSource.LoadParams<K> r2 = (PagingSource.LoadParams) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.class, "com.obric.memorydata.plugin");
        Continuation<? super PagingSource.LoadResult<K, T>> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r6 = r7.load(r2, r4);
        if (r6 != r0) goto L11;
        return r0;
    }
}
