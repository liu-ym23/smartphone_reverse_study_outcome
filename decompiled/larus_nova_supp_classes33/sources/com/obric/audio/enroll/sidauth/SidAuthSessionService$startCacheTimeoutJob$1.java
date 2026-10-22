package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sidauth.SidAuthSessionService$startCacheTimeoutJob$1", f = "SidAuthSessionService.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
final class SidAuthSessionService$startCacheTimeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $wkrId;
    int label;

    public SidAuthSessionService$startCacheTimeoutJob$1(long r1, Continuation<? super SidAuthSessionService$startCacheTimeoutJob$1> r3) {
        this.$wkrId = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SidAuthSessionService$startCacheTimeoutJob$1(this.$wkrId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        Object r12 = SidAuthSessionService.g;
        long r3 = this.$wkrId;
        monitor-enter(r12);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (SidAuthSessionService.e == true) goto L16;
    L26:
        r3 = 0;
    L27:
        monitor-exit(r12);
        if (r3 == 0) goto L32;
        SidAuthSessionService.a.getClass();
        SidAuthSessionService.l(r3, "asr timeout 60000ms");
    L32:
        return Unit.INSTANCE;
    L16:
        if (SidAuthSessionService.d != r3) goto L26;
        ByteArrayOutputStream r4 = SidAuthSessionService.h;     // Catch: Throwable -> L24
        if (r4 == null) goto L21;
        int r5 = r4.size();     // Catch: Throwable -> L24
    L22:
        FLogger.a.i("SidAuthSessionService", "auth cache timeout before asr wkrId=" + r3 + " cachedBytes=" + r5 + " maxDurationMs=60000");     // Catch: Throwable -> L24
        SidAuthSessionService.a.getClass();     // Catch: Throwable -> L24
        SidAuthSessionService.i(false);     // Catch: Throwable -> L24
        goto L27
    L21:
        r5 = 0;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r1) goto L11;
        return r1;
    }
}
