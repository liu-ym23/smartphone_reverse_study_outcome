package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator$onIdleStateChanged$1", f = "DoraLogFileTransferCoordinator.kt", i = {0}, l = {434}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class DoraLogFileTransferCoordinator$onIdleStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isIdle;
    final /* synthetic */ String $sn;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public DoraLogFileTransferCoordinator$onIdleStateChanged$1(boolean r1, String r2, Continuation<? super DoraLogFileTransferCoordinator$onIdleStateChanged$1> r3) {
        this.$isIdle = r1;
        this.$sn = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraLogFileTransferCoordinator$onIdleStateChanged$1(this.$isIdle, this.$sn, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r5 = true;
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        boolean r4 = this.Z$0;
        String r6 = (String) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L27:
        DoraLogFileTransferCoordinator r10 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L24
        if (r4 == true) goto L16;
        r5 = false;
    L16:
        DoraLogFileTransferCoordinator.d = r5;     // Catch: Throwable -> L24
        if (r4 == false) goto L20;
        g49.d.d("DoraLogFileTransferCoordinator", "onIdleStateChanged: idle, schedule delayed resume for sn=" + r6);     // Catch: Throwable -> L24
        DoraLogFileTransferCoordinator.c(r6);     // Catch: Throwable -> L24
    L21:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r7.unlock(null);
        return Unit.INSTANCE;
    L20:
        g49.d.d("DoraLogFileTransferCoordinator", "onIdleStateChanged: busy, cancel idle resume and pause queue for sn=" + r6);     // Catch: Throwable -> L24
        DoraLogFileTransferCoordinator.a();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r7 = DoraLogFileTransferCoordinator.c;
        boolean r12 = this.$isIdle;
        r6 = this.$sn;
        this.L$0 = r7;
        this.L$1 = r6;
        this.Z$0 = r12;
        this.label = 1;
        if (r7.a(null, this) != r2) goto L11;
        return r2;
    L11:
        r4 = r12;
        goto L27
    }
}
