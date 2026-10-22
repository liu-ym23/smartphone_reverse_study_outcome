package com.larus.dora.impl.file;

import com.larus.dora.impl.core.o0;
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
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator$enqueueFileFetchTask$1", f = "DoraLogFileTransferCoordinator.kt", i = {0, 1}, l = {434, 302}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class DoraLogFileTransferCoordinator$enqueueFileFetchTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fetchFrom;
    final /* synthetic */ String $firmwareVersion;
    final /* synthetic */ String $sn;
    final /* synthetic */ int[] $types;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public DoraLogFileTransferCoordinator$enqueueFileFetchTask$1(String r1, String r2, String r3, int[] r4, Continuation<? super DoraLogFileTransferCoordinator$enqueueFileFetchTask$1> r5) {
        this.$fetchFrom = r1;
        this.$sn = r2;
        this.$firmwareVersion = r3;
        this.$types = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraLogFileTransferCoordinator$enqueueFileFetchTask$1(this.$fetchFrom, this.$sn, this.$firmwareVersion, this.$types, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L9
    L28:
        kotlinx.coroutines.sync.a r16 = r0;
    L32:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r16.unlock(null);
        return Unit.INSTANCE;
    L35:
        th = move-exception;
        r0 = r16;
        th = th;
    L37:
        r0.unlock(null);
        throw th;
    L9:
        Throwable th = th;
    L41:
        g49.d.c("DoraLogFileTransferCoordinator", "enqueueFileFetchTask: ERROR", th);     // Catch: Throwable -> L29
    L29:
        th = th;
        goto L37
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        int[] r4 = (int[]) this.L$4;
        String r5 = (String) this.L$3;
        String r7 = (String) this.L$2;
        String r8 = (String) this.L$1;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
        int[] r11 = r4;
        String r10 = r5;
        r16 = r9;
    L18:
        String r12 = r7;
        sk4.e r6 = o0.a;     // Catch: Throwable -> L35
        if (o0.c("slardarOSFile") == true) goto L43;
        g49.d.e("DoraLogFileTransferCoordinator", "enqueueFileFetchTask: " + r12 + " is not support slardar os file");     // Catch: Throwable -> L35
        goto L32
    L43:
        DoraLogFileTransferCoordinator r13 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L25
        this.L$0 = r16;     // Catch: Throwable -> L25
        this.L$1 = null;     // Catch: Throwable -> L25
        this.L$2 = null;     // Catch: Throwable -> L25
        this.L$3 = null;     // Catch: Throwable -> L25
        this.L$4 = null;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        if (r13.e(r8, r12, r10, r11, this) != r1) goto L24;
        return r1;
    L24:
        r0 = r16;
    L25:
        th = move-exception;
        r0 = r16;
        th = th;
        goto L41
    L14:
        ResultKt.throwOnFailure(r15);
        r16 = DoraLogFileTransferCoordinator.c;
        r8 = this.$fetchFrom;
        r7 = this.$sn;
        String r14 = this.$firmwareVersion;
        int[] r17 = this.$types;
        this.L$0 = r16;
        this.L$1 = r8;
        this.L$2 = r7;
        this.L$3 = r14;
        this.L$4 = r17;
        this.label = 1;
        if (r16.a(null, this) != r1) goto L17;
        return r1;
    L17:
        r10 = r14;
        r11 = r17;
        goto L18
    }
}
