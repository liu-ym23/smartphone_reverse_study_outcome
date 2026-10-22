package com.obric.memorydata.recommend.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "before", "after"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.MemoryListViewModel$deleteMemoryEntity$3$1", f = "MemoryListViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListViewModel$deleteMemoryEntity$3$1 extends SuspendLambda implements Function3<f, f, Continuation<? super f>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MemoryListViewModel this$0;

    MemoryListViewModel$deleteMemoryEntity$3$1(MemoryListViewModel r3, Continuation<? super MemoryListViewModel$deleteMemoryEntity$3$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f r3, f r4, Continuation<? super f> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        MemoryListViewModel$deleteMemoryEntity$3$1 r0 = new MemoryListViewModel$deleteMemoryEntity$3$1(this.this$0, r6);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(f r3, f r4, Continuation<? super f> r5) {
        return invoke2((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        f r8 = (f) ZeusTransformUtils.preCheckCast(this.L$0, f.class, "com.obric.memorydata.plugin");
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.L$1, f.class, "com.obric.memorydata.plugin");
        MemoryListViewModel r4 = this.this$0;
        f.b r9 = (f.b) ZeusTransformUtils.preCheckCast(r8, f.b.class, "com.obric.memorydata.plugin");
        f.b r3 = (f.b) ZeusTransformUtils.preCheckCast(r2, f.b.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 1;
        r7 = MemoryListViewModel.access$generateMemoryItemTime(r4, r9, r3, r5);
        if (r7 != r0) goto L11;
        return r0;
    }
}
