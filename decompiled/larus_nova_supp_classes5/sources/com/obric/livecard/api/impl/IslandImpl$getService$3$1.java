package com.obric.livecard.api.impl;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.ILiveCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/livecard/api/IIslandService;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$getService$3$1", f = "IslandImpl.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
public final class IslandImpl$getService$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IIslandService>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$getService$3$1(IslandImpl r1, Continuation<? super IslandImpl$getService$3$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new IslandImpl$getService$3$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super IIslandService> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r2 = (IslandImpl) this.L$0;
        ResultKt.throwOnFailure(r7);
    L16:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final IslandImpl r8 = this.this$0;
        this.L$0 = r8;
        this.label = 1;
        final j r3 = new j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        ServiceConnection r4 = new IslandImpl$getService$3$1$1$serviceConnection$1(r8, r3);
        Application r5 = ILiveCard.Companion.getInst().getContext();
        if (r5 == null) goto L11;
        Intent r6 = new Intent();
        IslandImpl.access$setLiveCardComponentName(r8, r5, r6);
        r5.bindService(r6, r4, 1);
    L11:
        r7 = r3.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r7 != r0) goto L16;
        return r0;
    }
}
