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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sidauth.SidAuthSessionService$onSessionEnd$5", f = "SidAuthSessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SidAuthSessionService$onSessionEnd$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $wkrId;
    private /* synthetic */ Object L$0;
    int label;

    public SidAuthSessionService$onSessionEnd$5(Ref.LongRef r1, Continuation<? super SidAuthSessionService$onSessionEnd$5> r2) {
        this.$wkrId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SidAuthSessionService$onSessionEnd$5 r0 = new SidAuthSessionService$onSessionEnd$5(this.$wkrId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        Ref.LongRef r6 = this.$wkrId;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        SidAuthSessionService r1 = SidAuthSessionService.a;     // Catch: Throwable -> L7
        long r2 = r6.element;     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        SidAuthSessionService.o(r2, 0);     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        FLogger.a.e("SidAuthSessionService", "dispatch fail on short asr failed: " + r8.getMessage());
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
