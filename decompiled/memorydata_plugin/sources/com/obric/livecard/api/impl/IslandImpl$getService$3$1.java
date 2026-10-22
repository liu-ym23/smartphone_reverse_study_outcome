package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.ILiveCard;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/livecard/api/IIslandService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$getService$3$1", f = "IslandImpl.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
final class IslandImpl$getService$3$1 extends SuspendLambda implements Function2<al, Continuation<? super IIslandService>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$getService$3$1(IslandImpl r3, Continuation<? super IslandImpl$getService$3$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandImpl$getService$3$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super IIslandService> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super IIslandService> r4) {
        return ((IslandImpl$getService$3$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandImpl$getService$3$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r8 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$0, IslandImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L16:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        final IslandImpl r10 = this.this$0;
        this.L$0 = r10;
        this.label = 1;
        o r4 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r4.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
        ServiceConnection r5 = new IslandImpl$getService$3$1$1$serviceConnection$1(r10, r2);
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ILiveCard.Companion.getInst().getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        Intent r6 = new Intent();
        IslandImpl.access$setLiveCardComponentName(r10, (Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"), r6);
        ZeusTransformUtils.bindService(r3, r6, (ServiceConnection) ZeusTransformUtils.preCheckCast(r5, ServiceConnection.class, "com.obric.memorydata.plugin"), 1, "com.obric.memorydata.plugin");
    L11:
        r9 = r4.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    L14:
        if (r9 != r0) goto L16;
        return r0;
    }
}
