package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sidauth.SidAuthSessionService$onSessionEnd$6", f = "SidAuthSessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SidAuthSessionService$onSessionEnd$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $asrTextLen;
    final /* synthetic */ long $audioDurationMs;
    final /* synthetic */ Ref.BooleanRef $isContinuousTalk;
    final /* synthetic */ byte[] $pcmForAuth;
    final /* synthetic */ Ref.LongRef $wkrId;
    private /* synthetic */ Object L$0;
    int label;

    public SidAuthSessionService$onSessionEnd$6(Ref.LongRef r1, byte[] r2, long r3, Ref.BooleanRef r5, int r6, Continuation<? super SidAuthSessionService$onSessionEnd$6> r7) {
        this.$wkrId = r1;
        this.$pcmForAuth = r2;
        this.$audioDurationMs = r3;
        this.$isContinuousTalk = r5;
        this.$asrTextLen = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        SidAuthSessionService$onSessionEnd$6 r8 = new SidAuthSessionService$onSessionEnd$6(this.$wkrId, this.$pcmForAuth, this.$audioDurationMs, this.$isContinuousTalk, this.$asrTextLen, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.audio.enroll.sidauth.o, java.lang.Object] */
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Ref.LongRef r12 = this.$wkrId;
        byte[] r2 = this.$pcmForAuth;
        long r3 = this.$audioDurationMs;
        Ref.BooleanRef r0 = this.$isContinuousTalk;
        int r6 = this.$asrTextLen;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        g r4 = g.a;     // Catch: Throwable -> L7
        long r7 = r12.element;     // Catch: Throwable -> L7
        boolean r5 = r0.element;     // Catch: Throwable -> L7
        r4.getClass();     // Catch: Throwable -> L7
        Object r13 = Result.constructor-impl(g.d(r7, r2, r3, r5, r6));     // Catch: Throwable -> L7
    L9:
        Ref.LongRef r8 = this.$wkrId;
        Throwable r9 = Result.exceptionOrNull-impl(r13);
        if (r9 == null) goto L13;
        FLogger.a.e("SidAuthSessionService", "persistPendingItem exception wkrId=" + r8.element + ": " + r9.getMessage());
    L13:
        if (Result.isFailure-impl(r13) == false) goto L16;
        r13 = null;
    L16:
        if (((g.a) r13) != null) goto L44;
        FLogger.a.w("SidAuthSessionService", "persistPendingItem failed, fallback to sync auth wkrId=" + this.$wkrId.element);
        final Ref.LongRef r14 = this.$wkrId;
        final byte[] r15 = this.$pcmForAuth;
        a r16 = a.a;     // Catch: Throwable -> L26
        ?? r17 = new o(r14, r15);     // Catch: Throwable -> L26
        r16.getClass();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r17, "block");     // Catch: Throwable -> L26
        Object r18 = a.c;     // Catch: Throwable -> L26
        monitor-enter(r18);     // Catch: Throwable -> L26
        r17.invoke();     // Catch: Throwable -> L23
        monitor-exit(r18);     // Catch: Throwable -> L26
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Ref.LongRef r20 = this.$wkrId;
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L32;
        FLogger.a.e("SidAuthSessionService", "runAuthAndDispatch failed: " + r110.getMessage());
        SidAuthSessionService r21 = SidAuthSessionService.a;
        long r22 = r20.element;
        String r111 = "runAuthAndDispatch unexpected ".concat(r110.getClass().getSimpleName());
        r21.getClass();
        SidAuthSessionService.m(r22, r111);
    L32:
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L44:
        a.a.getClass();     // Catch: Throwable -> L35
        a.c();     // Catch: Throwable -> L35
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L41;
        FLogger.a.e("SidAuthSessionService", "checkAndFlushIfReady failed: " + r113.getMessage());
    L41:
        return Unit.INSTANCE;
    L35:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
