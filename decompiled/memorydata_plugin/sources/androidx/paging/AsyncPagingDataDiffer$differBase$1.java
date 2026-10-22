package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JE\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/PagingDataDiffer;", "postEvents", "", "presentNewList", "", "previousList", "Landroidx/paging/NullPaddedList;", "newList", "lastAccessedIndex", "onListPresentable", "Lkotlin/Function0;", "", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncPagingDataDiffer$differBase$1<T> extends PagingDataDiffer<T> {
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    AsyncPagingDataDiffer$differBase$1(AsyncPagingDataDiffer<T> r9, DifferCallback r10, CoroutineContext r11) {
        DifferCallback r3 = (DifferCallback) ZeusTransformUtils.wrapperContextForParams(r10, DifferCallback.class, "com.obric.memorydata.plugin");
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r11, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.this$0 = r9;
        super(r3, r4, null, 4, null);
    }

    @Override // androidx.paging.PagingDataDiffer
    public boolean postEvents() {
        return this.this$0.getInGetItem$paging_runtime_release();
    }

    @Override // androidx.paging.PagingDataDiffer
    public Object presentNewList(NullPaddedList<T> r8, NullPaddedList<T> r9, int r10, Function0<Unit> r11, Continuation<? super Integer> r12) {
        NullPaddedList r13 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r8, NullPaddedList.class, "com.obric.memorydata.plugin");
        NullPaddedList r14 = (NullPaddedList) ZeusTransformUtils.wrapperContextForParams(r9, NullPaddedList.class, "com.obric.memorydata.plugin");
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, AsyncPagingDataDiffer$differBase$1$presentNewList$1.class) == false) goto L7;
        AsyncPagingDataDiffer$differBase$1$presentNewList$1 r0 = (AsyncPagingDataDiffer$differBase$1$presentNewList$1) ZeusTransformUtils.preCheckCast(r16, AsyncPagingDataDiffer$differBase$1$presentNewList$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = r0.I$0;
        r15 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$3, Function0.class, "com.obric.memorydata.plugin");
        r14 = (NullPaddedList) ZeusTransformUtils.preCheckCast(r0.L$2, NullPaddedList.class, "com.obric.memorydata.plugin");
        r13 = (NullPaddedList) ZeusTransformUtils.preCheckCast(r0.L$1, NullPaddedList.class, "com.obric.memorydata.plugin");
        AsyncPagingDataDiffer$differBase$1<T> this = (AsyncPagingDataDiffer$differBase$1) ZeusTransformUtils.preCheckCast(r0.L$0, AsyncPagingDataDiffer$differBase$1.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L23:
        NullPaddedDiffResult r18 = (NullPaddedDiffResult) ZeusTransformUtils.preCheckCast(r17, NullPaddedDiffResult.class, "com.obric.memorydata.plugin");
        r15.invoke();
        NullPaddedListDiffHelperKt.dispatchDiff(r13, AsyncPagingDataDiffer.access$getUpdateCallback$p(this.this$0), r14, r18);
        return Boxing.boxInt(NullPaddedListDiffHelperKt.transformAnchorIndex(r13, r18, r14, r10));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        if (r13.getSize() != 0) goto L18;
        r15.invoke();
        this.this$0.getDifferCallback$paging_runtime_release().onInserted(0, r14.getSize());
        return null;
    L18:
        if (r14.getSize() != 0) goto L20;
        r15.invoke();
        this.this$0.getDifferCallback$paging_runtime_release().onRemoved(0, r13.getSize());
        return null;
    L20:
        CoroutineContext r19 = AsyncPagingDataDiffer.access$getWorkerDispatcher$p(this.this$0);
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(r13, r14, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
        r0.L$0 = this;
        r0.L$1 = r13;
        r0.L$2 = r14;
        r0.L$3 = r15;
        r0.I$0 = r10;
        r0.label = 1;
        r17 = i.a(r19, r4, r0);
        if (r17 != r2) goto L23;
        return r2;
    L7:
        r0 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, r16);
        goto L8
    }
}
