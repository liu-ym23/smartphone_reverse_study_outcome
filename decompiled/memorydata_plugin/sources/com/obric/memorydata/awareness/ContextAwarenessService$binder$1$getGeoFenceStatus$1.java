package com.obric.memorydata.awareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.GeoFenceStatus;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/MemoryResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.ContextAwarenessService$binder$1$getGeoFenceStatus$1", f = "ContextAwarenessService.kt", i = {}, l = {TypedValues.PositionType.TYPE_CURVE_FIT}, m = "invokeSuspend", n = {}, s = {})
final class ContextAwarenessService$binder$1$getGeoFenceStatus$1 extends SuspendLambda implements Function2<al, Continuation<? super MemoryResponse<Integer>>, Object> {
    final /* synthetic */ String $fenceId;
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8498a = null;

        static {
            int[] r0 = new int[StarGeofence.GeoState.values().length];
            r0[StarGeofence.GeoState.INSIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StarGeofence.GeoState.OUTSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f8498a = r0;
        }
    }

    ContextAwarenessService$binder$1$getGeoFenceStatus$1(String r3, Continuation<? super ContextAwarenessService$binder$1$getGeoFenceStatus$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$fenceId = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ContextAwarenessService$binder$1$getGeoFenceStatus$1(this.$fenceId, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super MemoryResponse<Integer>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super MemoryResponse<Integer>> r4) {
        return ((ContextAwarenessService$binder$1$getGeoFenceStatus$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ContextAwarenessService$binder$1$getGeoFenceStatus$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
        StarGeofence r6 = com.obric.memorydata.awareness.cae.b.f8563a.f(this.$fenceId);
        if (r6 == null) goto L18;
        StarGeofence.GeoState r4 = r6.getGeoState();
        if (r4 != null) goto L22;
        int r7 = -1;
    L23:
        if (r7 != 1) goto L25;
        GeoFenceStatus r8 = GeoFenceStatus.INSIDE;
    L30:
        return new MemoryResponse(0, "success", Boxing.boxInt(r8.getValue()));
    L25:
        if (r7 == 2) goto L27;
        r8 = GeoFenceStatus.UNKNOWN;
        goto L30
    L27:
        r8 = GeoFenceStatus.OUTSIDE;
        goto L30
    L22:
        r7 = a.f8498a[r4.ordinal()];
        goto L23
    L18:
        return new MemoryResponse(405, "invalid geofence " + this.$fenceId, null);
    L14:
        return new MemoryResponse(404, "bind location service failed", null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.obric.memorydata.awareness.cae.b r9 = com.obric.memorydata.awareness.cae.b.f8563a;
        Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r5 = r9.b(r2);
        if (r5 != r0) goto L12;
        return r0;
    }
}
