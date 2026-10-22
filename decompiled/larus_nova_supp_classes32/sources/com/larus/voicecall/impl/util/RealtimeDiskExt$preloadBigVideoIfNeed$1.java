package com.larus.voicecall.impl.util;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import hq9.u;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.util.RealtimeDiskExt$preloadBigVideoIfNeed$1", f = "RealtimeDiskExt.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeDiskExt$preloadBigVideoIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public RealtimeDiskExt$preloadBigVideoIfNeed$1(Continuation<? super RealtimeDiskExt$preloadBigVideoIfNeed$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        RealtimeDiskExt$preloadBigVideoIfNeed$1 r0 = new RealtimeDiskExt$preloadBigVideoIfNeed$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L18
    L13:
        t0 r5 = t0.a;     // Catch: Throwable -> L18
        r5.getClass();     // Catch: Throwable -> L18
        if (t0.c().a() == true) goto L16;
        u r2 = z2.a.H0();     // Catch: Throwable -> L18
        t0.a(r5, new t0.a(r2.b, r2.c));     // Catch: Throwable -> L18
    L16:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L24;
        FLogger.a.e("RealtimeDiskExt", "preloadBigVideo failed:" + r7);
    L24:
        t0.e.set(false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (DelayKt.delay(500, this) != r0) goto L13;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
