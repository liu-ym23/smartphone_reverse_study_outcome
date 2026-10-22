package com.obric.assistant.session.singleton;

import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$stopVUIWhenTimeout$2", f = "DoraWakeupDetector.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupDetector$stopVUIWhenTimeout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWakeupDetector$stopVUIWhenTimeout$2(Continuation<? super DoraWakeupDetector$stopVUIWhenTimeout$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWakeupDetector$stopVUIWhenTimeout$2(r2);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        AudioServiceDelegate r5 = AudioServiceDelegate.a;
        if (r5.i0().a() == false) goto L14;
    L24:
        DoraWakeupDetector.m = null;
        return Unit.INSTANCE;
    L14:
        if (DoraWakeupDetector.c == true) goto L24;
        if (r5.F().b() == false) goto L24;
        if (DoraAVLinkDelegate.b.j() == true) goto L24;
        DoraWakeupDetector r6 = DoraWakeupDetector.a;
        if (DoraWakeupDetector.h.get() == true) goto L24;
        if (DoraWakeupDetector.g == true) goto L24;
        FLogger.a.e("DoraWakeupDetector", "stopVUIWhenTimeout, try stopVUI when no tts play");
        DoraWakeupDetector.f();
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(20000, this) != r0) goto L11;
        return r0;
    }
}
