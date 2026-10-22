package com.obric.memorydata.recommend.ui.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$BlockMemoryState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.rule.BlockMemoryDialog$observerState$4", f = "BlockMemoryDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BlockMemoryDialog$observerState$4 extends SuspendLambda implements Function2<BlockMemoryDialogViewModel.a, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    BlockMemoryDialog$observerState$4(d r3, Continuation<? super BlockMemoryDialog$observerState$4> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        BlockMemoryDialog$observerState$4 r0 = new BlockMemoryDialog$observerState$4(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(BlockMemoryDialogViewModel.a r3, Continuation<? super Unit> r4) {
        return ((BlockMemoryDialog$observerState$4) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BlockMemoryDialog$observerState$4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(BlockMemoryDialogViewModel.a r3, Continuation<? super Unit> r4) {
        return invoke2((BlockMemoryDialogViewModel.a) ZeusTransformUtils.preCheckCast(r3, BlockMemoryDialogViewModel.a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        BlockMemoryDialogViewModel.a r4 = (BlockMemoryDialogViewModel.a) ZeusTransformUtils.preCheckCast(this.L$0, BlockMemoryDialogViewModel.a.class, "com.obric.memorydata.plugin");
        d.b(this.this$0, r4);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
