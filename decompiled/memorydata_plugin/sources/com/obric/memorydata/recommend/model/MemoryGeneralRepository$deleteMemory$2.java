package com.obric.memorydata.recommend.model;

import com.bytedance.obric.memory.model.DelMemoryRequest;
import com.bytedance.obric.memory.model.DelMemoryResponse;
import com.bytedance.obric.memory.model.MemoryData;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.model.MemoryGeneralRepository$deleteMemory$2", f = "MemoryGeneralRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryGeneralRepository$deleteMemory$2 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MemoryData $memoryData;
    int label;

    MemoryGeneralRepository$deleteMemory$2(MemoryData r3, Continuation<? super MemoryGeneralRepository$deleteMemory$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$memoryData = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryGeneralRepository$deleteMemory$2(this.$memoryData, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((MemoryGeneralRepository$deleteMemory$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryGeneralRepository$deleteMemory$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r9);
        boolean r10 = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeneralRepository", "deleteMemory: id=" + this.$memoryData.id + ", category=" + this.$memoryData.category, false, 4, null);     // Catch: Exception -> L8
        DelMemoryRequest r1 = new DelMemoryRequest();     // Catch: Exception -> L8
        MemoryData r8 = this.$memoryData;     // Catch: Exception -> L8
        r1.id = r8.id;     // Catch: Exception -> L8
        r1.category = r8.category;     // Catch: Exception -> L8
        DelMemoryResponse r11 = com.bytedance.obric.memory.a.a.a(r1);     // Catch: Exception -> L8
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeneralRepository", "deleteMemory: response.code=" + r11.code, false, 4, null);     // Catch: Exception -> L8
        if (r11.code != 0) goto L11;
        r10 = true;
    L11:
        return Boxing.boxBoolean(r10);
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryGeneralRepository", "deleteMemory error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
