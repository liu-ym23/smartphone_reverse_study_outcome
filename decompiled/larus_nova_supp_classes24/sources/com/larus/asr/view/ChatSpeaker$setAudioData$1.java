package com.larus.asr.view;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
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
@DebugMetadata(c = "com.larus.asr.view.ChatSpeaker$setAudioData$1", f = "ChatSpeaker.kt", i = {}, l = {1971}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSpeaker$setAudioData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $it;
    int label;
    final /* synthetic */ ChatSpeaker this$0;

    public ChatSpeaker$setAudioData$1(ChatSpeaker r1, byte[] r2, Continuation<? super ChatSpeaker$setAudioData$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatSpeaker$setAudioData$1(this.this$0, this.$it, r4);
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
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        LarusWidgetSpeakerBinding r5 = this.this$0.getBinding();
        if (r5 == null) goto L25;
        BlurCircleWithAmplitude r6 = r5.f;
        if (r6 == null) goto L25;
        byte[] r2 = this.$it;
        this.label = 1;
        if (r6.d() == false) goto L15;
        Object r7 = r6.l.update(r2, this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        r7 = Unit.INSTANCE;
    L22:
        if (r7 != r0) goto L25;
        return r0;
    L15:
        if (r6.isInEditMode() == true) goto L17;
        FLogger.a.w("BlurCircleWithAmplitude", "[updateAudioData][NOT_ANIM]");
    L17:
        r7 = Unit.INSTANCE;
        goto L22
    }
}
