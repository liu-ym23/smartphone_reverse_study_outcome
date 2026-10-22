package com.obric.memorydata.awareness.persistent;

import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.persistent.PersistentAwarenessRuntime$removeGeoFence$1", f = "PersistentAwarenessRuntime.kt", i = {}, l = {Constants.UPLOAD_DISASTER_ESCAPE}, m = "invokeSuspend", n = {}, s = {})
final class PersistentAwarenessRuntime$removeGeoFence$1 extends SuspendLambda implements Function2<al, Continuation<? super MemoryResponse<Void>>, Object> {
    final /* synthetic */ String $fenceId;
    int label;

    PersistentAwarenessRuntime$removeGeoFence$1(String r3, Continuation<? super PersistentAwarenessRuntime$removeGeoFence$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$fenceId = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersistentAwarenessRuntime$removeGeoFence$1(this.$fenceId, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super MemoryResponse<Void>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super MemoryResponse<Void>> r4) {
        return ((PersistentAwarenessRuntime$removeGeoFence$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersistentAwarenessRuntime$removeGeoFence$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "bind location service failed for remove geofence " + this.$fenceId, null, 4, null);
        return new MemoryResponse(404, "bind location service failed", null, 4, null);
    L16:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.b.f8563a.d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "remove geofence failed: fenceId=" + this.$fenceId + ", fence service not ready", null, 4, null);
        return new MemoryResponse(404, "fence service not ready", null, 4, null);
    L19:
        boolean r15 = com.obric.memorydata.awareness.cae.b.f8563a.c(this.$fenceId);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "remove geofence fenceId=" + this.$fenceId + " success=" + r15, false, 4, null);
        if (r15 == true) goto L24;
        return new MemoryResponse(400, "remove geofence failed", null, 4, null);
    L24:
        return MemoryResponse.CREATOR.a();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        com.obric.memorydata.awareness.cae.b r16 = com.obric.memorydata.awareness.cae.b.f8563a;
        Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r14 = r16.b(r2);
        if (r14 != r0) goto L12;
        return r0;
    }
}
