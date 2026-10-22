package com.larus.dora.impl.core;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraVoiceWakeupStateManager$loadVoiceWakeupState$1", f = "DoraVoiceWakeupStateManager.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class DoraVoiceWakeupStateManager$loadVoiceWakeupState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;

    public DoraVoiceWakeupStateManager$loadVoiceWakeupState$1(Continuation<? super DoraVoiceWakeupStateManager$loadVoiceWakeupState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraVoiceWakeupStateManager$loadVoiceWakeupState$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0054 -> B:22:0x0063). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r8);
        DoraVoiceWakeupStateManager$loadVoiceWakeupState$1 r9 = this;
    L22:
        r2 = r2 + 1;
    L10:
        if (r2 >= 3) goto L24;
        byte r4 = kj4.a.g().B();
        g49.d.d("DoraVoiceWakeupStateManager", "loadVoiceWakeupState, ret=" + r4 + ", retry=" + r2);
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L17;
        r9.I$0 = r2;
        r9.label = 1;
        if (DelayKt.delay(300, r9) != r0) goto L22;
        return r0;
    L17:
        DoraVoiceWakeupStateManager r5 = DoraVoiceWakeupStateManager.a;
        if (r4 != 1) goto L25;
        r5.a(true, "loadVoiceWakeupState");
        goto L22
    L25:
        r5.a(false, "loadVoiceWakeupState");
        goto L22
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r9 = this;
        r2 = 0;
        goto L10
    }
}
