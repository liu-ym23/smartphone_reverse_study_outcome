package com.obric.assistant.session.lifecycle;

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
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.BluetoothSoundEffectPlayer$playTone$1", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {175, 177}, m = "invokeSuspend", n = {}, s = {})
public final class BluetoothSoundEffectPlayer$playTone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromSco;
    int label;

    public BluetoothSoundEffectPlayer$playTone$1(boolean r1, Continuation<? super BluetoothSoundEffectPlayer$playTone$1> r2) {
        this.$fromSco = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BluetoothSoundEffectPlayer$playTone$1(this.$fromSco, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L15:
        BluetoothSoundEffectPlayer r7 = BluetoothSoundEffectPlayer.b;
        this.label = 2;
        if (BluetoothSoundEffectPlayer.d(r7, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        if (this.$fromSco == false) goto L15;
        FLogger.a.w(BluetoothSoundEffectPlayer.b.c(), "playTone NOW from sco , need wait 100ms");
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L15;
        return r0;
    }
}
