package com.obric.memorydata.memory.ui.list;

import com.bytedance.obric.memory.model.DelMemoryRequest;
import com.bytedance.obric.memory.model.DelMemoryResponse;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.RecommendMemoryRepository$deleteMemory$2", f = "RecommendMemoryRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecommendMemoryRepository$deleteMemory$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $category;
    final /* synthetic */ long $id;
    int label;

    RecommendMemoryRepository$deleteMemory$2(long r3, int r5, Continuation<? super RecommendMemoryRepository$deleteMemory$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$id = r3;
        this.$category = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RecommendMemoryRepository$deleteMemory$2(this.$id, this.$category, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Boolean> r4) {
        return ((RecommendMemoryRepository$deleteMemory$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RecommendMemoryRepository$deleteMemory$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r9);
        boolean r10 = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "deleteRecommendMemory: id=" + this.$id + ", category=" + this.$category, false, 4, null);     // Catch: Exception -> L8
        DelMemoryRequest r1 = new DelMemoryRequest();     // Catch: Exception -> L8
        long r2 = this.$id;     // Catch: Exception -> L8
        int r8 = this.$category;     // Catch: Exception -> L8
        r1.id = r2;     // Catch: Exception -> L8
        r1.category = r8;     // Catch: Exception -> L8
        DelMemoryResponse r11 = com.bytedance.obric.memory.a.a.a(r1);     // Catch: Exception -> L8
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "deleteMemory: response.code=" + r11.code + ", msg = " + r11.msg, false, 4, null);     // Catch: Exception -> L8
        if (r11.code != 0) goto L11;
        r10 = true;
    L11:
        return Boxing.boxBoolean(r10);
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("RecommendMemoryRepository", "deleteMemory error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
