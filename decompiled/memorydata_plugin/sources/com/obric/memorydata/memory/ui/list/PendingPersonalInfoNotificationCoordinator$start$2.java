package com.obric.memorydata.memory.ui.list;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationCoordinator$start$2", f = "PendingPersonalInfoNotificationCoordinator.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class PendingPersonalInfoNotificationCoordinator$start$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    PendingPersonalInfoNotificationCoordinator$start$2(Continuation<? super PendingPersonalInfoNotificationCoordinator$start$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new PendingPersonalInfoNotificationCoordinator$start$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((PendingPersonalInfoNotificationCoordinator$start$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PendingPersonalInfoNotificationCoordinator$start$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003f -> B:12:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        kotlinx.coroutines.channels.k r2 = (kotlinx.coroutines.channels.k) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L13:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L16;
        r2.a();
        at.f11208a.b();
    L9:
        Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 1;
        r6 = r2.a(r7);
        if (r6 != r0) goto L13;
        return r0;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        r2 = at.c().l();
        goto L9
    }
}
