package com.larus.dora.impl;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import kj4.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$forwardETPPayload$2$1", f = "DoraServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$forwardETPPayload$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $adaptiveVolumeRequestId;
    final /* synthetic */ byte[] $decodedPayload;
    final /* synthetic */ String $hexPayload;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$forwardETPPayload$2$1(String r1, Long r2, DoraServiceImpl r3, byte[] r4, Continuation<? super DoraServiceImpl$forwardETPPayload$2$1> r5) {
        this.$hexPayload = r1;
        this.$adaptiveVolumeRequestId = r2;
        this.this$0 = r3;
        this.$decodedPayload = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        DoraServiceImpl$forwardETPPayload$2$1 r6 = new DoraServiceImpl$forwardETPPayload$2$1(this.$hexPayload, this.$adaptiveVolumeRequestId, this.this$0, this.$decodedPayload, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        byte[] r9 = this.$decodedPayload;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r10 = Result.constructor-impl(Boxing.boxInt(a.g().sendETPPayload(r9)));     // Catch: Throwable -> L7
    L9:
        Long r1 = this.$adaptiveVolumeRequestId;
        DoraServiceImpl r2 = this.this$0;
        Throwable r3 = Result.exceptionOrNull-impl(r10);
        if (r3 != null) goto L20;
        int r11 = ((Number) r10).intValue();
        FLogger r4 = FLogger.a;
        r4.i("DoraServiceImpl", "handleDoraAtomicFunction: sendETPPayload result=" + r11 + ", payload=" + this.$hexPayload);
        if (r11 == 0) goto L19;
        Long r5 = this.$adaptiveVolumeRequestId;
        if (r5 == null) goto L19;
        if (this.this$0.W.a(r5.longValue()) == false) goto L19;
        r4.w("DoraServiceImpl", "handleDoraAtomicFunction: discard adaptive-volume request after send failure, requestId=" + this.$adaptiveVolumeRequestId + ", result=" + r11);
    L19:
        return Unit.INSTANCE;
    L20:
        if (r1 == null) goto L29;
        a r12 = r2.W;
        long r6 = r1.longValue();
        Map r13 = r12.a;
        monitor-enter(r13);
        boolean r14 = r12.b(r6);     // Catch: Throwable -> L26
        monitor-exit(r13);
        Boxing.boxBoolean(r14);
    L26:
        th = move-exception;
        throw th;
    L29:
        FLogger.a.e("DoraServiceImpl", "handleDoraAtomicFunction: failed to send ETP payload", r3);
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
