package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mj4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBTOptimizationManager$onDoraConnected$1", f = "DoraBTOptimizationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraBTOptimizationManager$onDoraConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isForce3MEnabled;
    int label;

    public DoraBTOptimizationManager$onDoraConnected$1(boolean r1, Continuation<? super DoraBTOptimizationManager$onDoraConnected$1> r2) {
        this.$isForce3MEnabled = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraBTOptimizationManager$onDoraConnected$1(this.$isForce3MEnabled, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        DoraBTOptimizationManager r7 = DoraBTOptimizationManager.a;
        kj4.a r8 = DoraBTOptimizationManager.a();
        boolean r0 = this.$isForce3MEnabled;
        f r9 = r8.c;
        r9.getClass();
        lk4.a.a r1 = new lk4.a.a();
        r1.a = 8;
        r1.b = new byte[]{r0 ? 1 : 0};
        g49.d.d("DoraBTOptimizationManager", "onDoraConnected: syncForce3MPacketEnable(" + this.$isForce3MEnabled + ") ret=" + r9.d.i(1, 49, new lk4.a(r1).a()));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
