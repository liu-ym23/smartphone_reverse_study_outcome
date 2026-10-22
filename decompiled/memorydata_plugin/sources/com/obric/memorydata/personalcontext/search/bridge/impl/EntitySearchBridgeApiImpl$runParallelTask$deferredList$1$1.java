package com.obric.memorydata.personalcontext.search.bridge.impl;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.bridge.impl.EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1", f = "EntitySearchBridgeApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Long>, Object> {
    final /* synthetic */ Map<String, Object> $method;
    final /* synthetic */ String $searchTaskId;
    int label;

    EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1(String r3, Map<String, ? extends Object> r4, Continuation<? super EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1> r5) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$searchTaskId = r3;
        this.$method = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1(this.$searchTaskId, this.$method, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Long> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Long> r4) {
        return ((EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        long r0 = System.currentTimeMillis();
        EntitySearchBridgeApiImpl r11 = EntitySearchBridgeApiImpl.INSTANCE;
        String r2 = this.$searchTaskId;
        Object r3 = this.$method.get("methodName");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Object r5 = this.$method.get(TrackerImpl.PARAMS);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        long r6 = r11.invokeSearchMethod(r2, r4, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("NativeEntitySearch", "deferredMethod end costTime: " + (System.currentTimeMillis() - r0) + ", " + this.$method.get("methodName"));
        return Boxing.boxLong(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
