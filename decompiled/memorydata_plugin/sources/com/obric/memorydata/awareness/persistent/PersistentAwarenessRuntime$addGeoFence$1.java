package com.obric.memorydata.awareness.persistent;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.GeoFenceRequest;
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
@DebugMetadata(c = "com.obric.memorydata.awareness.persistent.PersistentAwarenessRuntime$addGeoFence$1", f = "PersistentAwarenessRuntime.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
final class PersistentAwarenessRuntime$addGeoFence$1 extends SuspendLambda implements Function2<al, Continuation<? super MemoryResponse<Void>>, Object> {
    final /* synthetic */ String $fenceId;
    final /* synthetic */ String $ownerPackage;
    final /* synthetic */ GeoFenceRequest $request;
    int label;

    PersistentAwarenessRuntime$addGeoFence$1(String r3, GeoFenceRequest r4, String r5, Continuation<? super PersistentAwarenessRuntime$addGeoFence$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$fenceId = r3;
        this.$request = r4;
        this.$ownerPackage = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersistentAwarenessRuntime$addGeoFence$1(this.$fenceId, this.$request, this.$ownerPackage, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super MemoryResponse<Void>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super MemoryResponse<Void>> r4) {
        return ((PersistentAwarenessRuntime$addGeoFence$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersistentAwarenessRuntime$addGeoFence$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r26);
        Object r3 = r26;
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "bind location service failed for add geofence " + this.$fenceId, null, 4, null);
        return new MemoryResponse(404, "bind location service failed", null, 4, null);
    L16:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.b.f8563a.d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "add geofence failed: fenceId=" + this.$fenceId + ", fence service not ready", null, 4, null);
        return new MemoryResponse(404, "fence service not ready", null, 4, null);
    L19:
        boolean r4 = com.obric.memorydata.awareness.cae.b.a(com.obric.memorydata.awareness.cae.b.f8563a, this.$fenceId, this.$request.getLongitude(), this.$request.getLatitude(), this.$request.getRadius(), 3, null, 32, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "add geofence fenceId=" + this.$fenceId + " success=" + r4, false, 4, null);
        if (r4 == false) goto L22;
        com.obric.memorydata.awareness.a.f8503a.b(this.$fenceId, this.$ownerPackage);
        return MemoryResponse.CREATOR.a();
    L22:
        return new MemoryResponse(400, "add geofence failed", null, 4, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        com.obric.memorydata.awareness.cae.b r5 = com.obric.memorydata.awareness.cae.b.f8563a;
        Continuation<? super Boolean> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = r5.b(r6);
        if (r3 != r1) goto L12;
        return r1;
    }
}
