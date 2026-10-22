package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.sync.a;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$2", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {645, 179}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1"})
final class PageFetcherSnapshot$pageEventFlow$2<Value> extends SuspendLambda implements Function2<j<? super PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    PageFetcherSnapshot$pageEventFlow$2(PageFetcherSnapshot<Key, Value> r3, Continuation<? super PageFetcherSnapshot$pageEventFlow$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot$pageEventFlow$2 r0 = new PageFetcherSnapshot$pageEventFlow$2(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super PageEvent<Value>> r3, Continuation<? super Unit> r4) {
        return ((PageFetcherSnapshot$pageEventFlow$2) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageFetcherSnapshot$pageEventFlow$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        j r2 = (j) ZeusTransformUtils.preCheckCast(this.L$2, j.class, "com.obric.memorydata.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$1, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder r6 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$0, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L23:
        LoadStates r10 = PageFetcherSnapshotState.Holder.access$getState$p(r6).getSourceLoadStates$paging_common().snapshot();     // Catch: Throwable -> L20
        r3.b(null);
        PageEvent.LoadStateUpdate r4 = new PageEvent.LoadStateUpdate(r10, null, 2, null);
        Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (r2.emit(r4, r11) != r0) goto L19;
        return r0;
    L20:
        th = move-exception;
        r3.b(null);
        throw th;
    L10:
        ResultKt.throwOnFailure(r9);
        r2 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        r6 = PageFetcherSnapshot.access$getStateHolder$p(this.this$0);
        a r12 = PageFetcherSnapshotState.Holder.access$getLock$p(r6);
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r12;
        this.L$2 = r2;
        this.label = 1;
        if (r12.a(null, r7) != r0) goto L13;
        return r0;
    L13:
        r3 = r12;
        goto L23
    }
}
