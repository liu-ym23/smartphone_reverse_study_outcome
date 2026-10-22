package com.obric.memorydata.recommend.ui.list;

import com.bytedance.obric.memory.model.MemoryData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.PortraitViewModel$deleteMemoryEntity$2$1", f = "PortraitViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PortraitViewModel$deleteMemoryEntity$2$1 extends SuspendLambda implements Function2<f, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MemoryData $memoryData;
    /* synthetic */ Object L$0;
    int label;

    PortraitViewModel$deleteMemoryEntity$2$1(MemoryData r3, Continuation<? super PortraitViewModel$deleteMemoryEntity$2$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$memoryData = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PortraitViewModel$deleteMemoryEntity$2$1 r0 = new PortraitViewModel$deleteMemoryEntity$2$1(this.$memoryData, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f r3, Continuation<? super Boolean> r4) {
        return ((PortraitViewModel$deleteMemoryEntity$2$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PortraitViewModel$deleteMemoryEntity$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(f r3, Continuation<? super Boolean> r4) {
        return invoke2((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        f r4 = (f) ZeusTransformUtils.preCheckCast(this.L$0, f.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.c.class) == true) goto L7;
    L9:
        boolean r2 = false;
    L11:
        return Boxing.boxBoolean(r2);
    L7:
        if (((f.c) ZeusTransformUtils.preCheckCast(r4, f.c.class, "com.obric.memorydata.plugin")).a().id == this.$memoryData.id) goto L9;
        r2 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
