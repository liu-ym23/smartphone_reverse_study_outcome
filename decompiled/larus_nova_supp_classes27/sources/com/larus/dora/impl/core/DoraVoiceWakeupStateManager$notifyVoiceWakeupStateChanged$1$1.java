package com.larus.dora.impl.core;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1", f = "DoraVoiceWakeupStateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t39.x $it;
    final /* synthetic */ boolean $state;
    private /* synthetic */ Object L$0;
    int label;

    public DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1(t39.x r1, boolean r2, Continuation<? super DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1> r3) {
        this.$it = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1 r0 = new DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1(this.$it, this.$state, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        t39.x r10 = this.$it;
        boolean r2 = this.$state;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r2 == false) goto L8;
        boolean r5 = true;
    L9:
        r10.a(r5);     // Catch: Throwable -> L11
        g49.d.d("DoraVoiceWakeupStateManager", "notifyVoiceWakeupStateChanged: " + r10 + " consume: " + (System.currentTimeMillis() - r4));     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L17;
        g49.d.c("DoraVoiceWakeupStateManager", "notifyVoiceWakeupStateChanged: " + r12 + " exception", r12);
    L17:
        return Unit.INSTANCE;
    L8:
        r5 = false;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
