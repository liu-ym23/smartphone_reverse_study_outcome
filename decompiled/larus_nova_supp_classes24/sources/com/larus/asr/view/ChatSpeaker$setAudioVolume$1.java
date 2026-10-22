package com.larus.asr.view;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.view.ChatSpeaker$setAudioVolume$1", f = "ChatSpeaker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSpeaker$setAudioVolume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $volume;
    int label;
    final /* synthetic */ ChatSpeaker this$0;

    public ChatSpeaker$setAudioVolume$1(ChatSpeaker r1, float r2, Continuation<? super ChatSpeaker$setAudioVolume$1> r3) {
        this.this$0 = r1;
        this.$volume = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSpeaker$setAudioVolume$1(this.this$0, this.$volume, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        LarusWidgetSpeakerBinding r5 = this.this$0.getBinding();
        if (r5 == null) goto L18;
        BlurCircleWithAmplitude r6 = r5.f;
        if (r6 == null) goto L18;
        float r0 = this.$volume;
        if (r6.d() == false) goto L11;
        AudioAmplitudeProcessor r7 = r6.l;
        r7.getClass();
        float r1 = AudioAmplitudeProcessor.b(r0);
        if (r7.c.size() < r7.b) goto L16;
        r7.c.remove(0);
    L16:
        r7.c.add(Float.valueOf(r1));
        goto L18
    L11:
        if (r6.isInEditMode() == true) goto L18;
        FLogger.a.w("BlurCircleWithAmplitude", "[updateVolumeData][NOT_ANIM]");
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
