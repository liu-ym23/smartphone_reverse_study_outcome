package com.obric.assistant.session.lifecycle;

import bga.j;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.session.model.ISessionMaintaining;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.BluetoothSoundEffectPlayer$activateSoundTimerRunnable$1$1", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BluetoothSoundEffectPlayer$activateSoundTimerRunnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BluetoothSoundEffectPlayer$activateSoundTimerRunnable$1$1(Continuation<? super BluetoothSoundEffectPlayer$activateSoundTimerRunnable$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BluetoothSoundEffectPlayer$activateSoundTimerRunnable$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        if (com.obric.assistant.feedback.a.a() == false) goto L13;
        FLogger r5 = FLogger.a;
        String r0 = BluetoothSoundEffectPlayer.b.c();
        StringBuilder r1 = new StringBuilder("skip delayed main wakeup feedback: reason=child_already_played requestFrom=");
        r1.append(a.b());
        r1.append(" sessionName=");
        ISessionMaintaining r2 = j.b();
        if (r2 == null) goto L10;
        String r3 = r2.o();
        if (r3 == null) goto L10;
    L11:
        r1.append(r3);
        r5.i(r0, r1.toString());
        return Unit.INSTANCE;
    L10:
        r3 = "";
        goto L11
    L13:
        SoundEffectHelper.INSTANCE.playActivate();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WAKE_UP);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
