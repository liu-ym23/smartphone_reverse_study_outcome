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
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator$onDoraLinkStateChanged$1", f = "DoraLogFileTransferCoordinator.kt", i = {0}, l = {434}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class DoraLogFileTransferCoordinator$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $connected;
    final /* synthetic */ String $sn;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public DoraLogFileTransferCoordinator$onDoraLinkStateChanged$1(boolean r1, String r2, Continuation<? super DoraLogFileTransferCoordinator$onDoraLinkStateChanged$1> r3) {
        this.$connected = r1;
        this.$sn = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraLogFileTransferCoordinator$onDoraLinkStateChanged$1(this.$connected, this.$sn, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L8;
        if (r5 != 1) goto L7;
        boolean r6 = this.Z$0;
        String r7 = (String) this.L$1;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);
    L29:
        StringBuilder r12 = new StringBuilder("onDoraLinkStateChanged: connected=");     // Catch: Throwable -> L26
        if (r6 == false) goto L15;
        boolean r9 = true;
    L16:
        r12.append(r9);     // Catch: Throwable -> L26
        r12.append(", sn=");     // Catch: Throwable -> L26
        r12.append(r7);     // Catch: Throwable -> L26
        g49.d.d("DoraLogFileTransferCoordinator", r12.toString());     // Catch: Throwable -> L26
        if (r6 == false) goto L22;
        DoraLogFileTransferCoordinator r13 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.e = true;     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.k.b(r7);     // Catch: Throwable -> L26
        if (DoraLogFileTransferCoordinator.d == false) goto L21;
        g49.d.d("DoraLogFileTransferCoordinator", "onDoraLinkStateChanged: connected & idle, schedule delayed resume for sn=".concat(r7));     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.c(r7);     // Catch: Throwable -> L26
    L23:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r8.unlock(null);
        return Unit.INSTANCE;
    L21:
        g49.d.d("DoraLogFileTransferCoordinator", "onDoraLinkStateChanged: connected but busy, keep queue paused for sn=".concat(r7));     // Catch: Throwable -> L26
        goto L23
    L22:
        DoraLogFileTransferCoordinator r15 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.e = false;     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.a();     // Catch: Throwable -> L26
        DoraLogFileTransferCoordinator.k.c();     // Catch: Throwable -> L26
        goto L23
    L15:
        r9 = false;
    L26:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r8 = DoraLogFileTransferCoordinator.c;
        boolean r16 = this.$connected;
        r7 = this.$sn;
        this.L$0 = r8;
        this.L$1 = r7;
        this.Z$0 = r16;
        this.label = 1;
        if (r8.a(null, this) != r4) goto L11;
        return r4;
    L11:
        r6 = r16;
        goto L29
    }
}
