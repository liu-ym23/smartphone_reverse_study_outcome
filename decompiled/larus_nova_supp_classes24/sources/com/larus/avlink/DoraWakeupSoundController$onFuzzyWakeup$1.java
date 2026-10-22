package com.larus.avlink;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupSoundController$onFuzzyWakeup$1", f = "DoraWakeupSoundController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupSoundController$onFuzzyWakeup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $result;
    final /* synthetic */ long $triggerMs;
    int label;

    public DoraWakeupSoundController$onFuzzyWakeup$1(int r1, long r2, Continuation<? super DoraWakeupSoundController$onFuzzyWakeup$1> r4) {
        this.$result = r1;
        this.$triggerMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraWakeupSoundController$onFuzzyWakeup$1(this.$result, this.$triggerMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r8);
        n1.d("DoraWakeupSoundController", "onFuzzyWakeup result=" + this.$result + ", conversationStopped=" + DoraWakeupSoundController.d);
        Lazy r9 = DoraWakeupSoundController.a;
        if (DoraWakeupSoundController.a() == false) goto L7;
        int r10 = this.$result;
        if (r10 != 1) goto L11;
        DoraWakeupSoundController.f = true;
        DoraWakeupSoundController.d = false;
        long r3 = this.$triggerMs;
        int r11 = this.$result;
        n1.d("DoraWakeupSoundController", "tryPlayFuzzyWakeVoice, conversationStopped=" + DoraWakeupSoundController.d);
        DoraWakeupSoundController.e = SystemClock.elapsedRealtime();
        DoraWakeupSoundController.g = true;
        q1 r0 = new q1("dora_fuzzy_wake_sound_play_duration", r3, r11);
        r0.e = SystemClock.elapsedRealtime();
        DoraWakeupSoundController.h = r0;
        ((SoundPlayManager) DoraWakeupSoundController.c.getValue()).g(AppHost.a.getApplication(), "dora_natural_fuzzy_wake.mp3", "dora_natural_fuzzy_wake.wav", new l1(), r0.l);
    L18:
        return Unit.INSTANCE;
    L11:
        if (r10 != 2) goto L18;
        DoraWakeupSoundController.f = false;
        if (DoraWakeupSoundController.d == true) goto L18;
        DoraWakeupSoundController.d = true;
        DoraWakeupSoundController.b(this.$triggerMs);
        goto L18
    L7:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
