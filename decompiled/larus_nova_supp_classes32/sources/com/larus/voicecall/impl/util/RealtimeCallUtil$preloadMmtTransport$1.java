package com.larus.voicecall.impl.util;

import com.larus.im.internal.audio.u;
import com.larus.im.service.d;
import com.obric.aivoice.core.data.NameKeys;
import gd9.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.util.RealtimeCallUtil$preloadMmtTransport$1", f = "RealtimeCallUtil.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallUtil$preloadMmtTransport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $transportDelayMs;
    int label;

    public RealtimeCallUtil$preloadMmtTransport$1(int r1, Continuation<? super RealtimeCallUtil$preloadMmtTransport$1> r2) {
        this.$transportDelayMs = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallUtil$preloadMmtTransport$1(this.$transportDelayMs, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        AtomicBoolean r7 = RealtimeCallUtil.c;
        if (r7.get() == true) goto L14;
        RealtimeCallUtil.a.getClass();
        d r2 = RealtimeCallUtil.d();
        int r3 = com.larus.im.a.a;
        o r4 = com.larus.im.internal.d.a;
        u.c.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        if (u.a().g.d(r2) != 0) goto L19;
        r7.set(true);
    L19:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r5 = this.$transportDelayMs;
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L11;
        return r0;
    }
}
