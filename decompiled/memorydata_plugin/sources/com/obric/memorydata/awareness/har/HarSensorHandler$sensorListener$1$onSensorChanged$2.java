package com.obric.memorydata.awareness.har;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.har.HarSensorHandler$sensorListener$1$onSensorChanged$2", f = "HarSensorHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HarSensorHandler$sensorListener$1$onSensorChanged$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    HarSensorHandler$sensorListener$1$onSensorChanged$2(b r3, Continuation<? super HarSensorHandler$sensorListener$1$onSensorChanged$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final boolean invokeSuspend$lambda$0(b r0, Integer r1) {
        return b.b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$aYgizxGdDZd0IpAKZY-hhHTUvcQ, reason: not valid java name */
    public static /* synthetic */ boolean m501lambda$aYgizxGdDZd0IpAKZYhhHTUvcQ(b r0, Integer r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new HarSensorHandler$sensorListener$1$onSensorChanged$2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((HarSensorHandler$sensorListener$1$onSensorChanged$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), HarSensorHandler$sensorListener$1$onSensorChanged$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        if (b.a(this.this$0) == false) goto L7;
        b r5 = this.this$0;
        Integer r0 = b.b(r5);
        final b r1 = this.this$0;
        b.a(r5, "elevator", r0, new $$Lambda$HarSensorHandler$sensorListener$1$onSensorChanged$2$aYgizxGdDZd0IpAKZYhhHTUvcQ(r1));
    L7:
        b.a(this.this$0, null);
        b.a(this.this$0, false);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
