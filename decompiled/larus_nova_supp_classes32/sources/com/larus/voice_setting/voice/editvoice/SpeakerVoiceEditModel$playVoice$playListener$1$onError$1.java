package com.larus.voice_setting.voice.editvoice;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$playVoice$playListener$1$onError$1", f = "SpeakerVoiceEditModel.kt", i = {}, l = {684}, m = "invokeSuspend", n = {}, s = {})
public final class SpeakerVoiceEditModel$playVoice$playListener$1$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpeakerVoice $singleSelectedVoice;
    int label;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$playVoice$playListener$1$onError$1(SpeakerVoiceEditModel r1, SpeakerVoice r2, Continuation<? super SpeakerVoiceEditModel$playVoice$playListener$1$onError$1> r3) {
        this.this$0 = r1;
        this.$singleSelectedVoice = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpeakerVoiceEditModel$playVoice$playListener$1$onError$1(this.this$0, this.$singleSelectedVoice, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        SpeakerVoiceEditModel r6 = this.this$0;
        if (r6.e == false) goto L15;
        r6.t(this.$singleSelectedVoice, "from_play_button", 1);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GlobalAudioObserver.a.f("trail_listening", null, null);
        AudioServiceDelegate.a.O().c(SoundsSource.VOICE_TEST);
        this.this$0.x.setValue(Boxing.boxInt(3));
        MutableSharedFlow<a1> r7 = this.this$0.z;
        a1.b r2 = a1.b.a;
        this.label = 1;
        if (r7.emit(r2, this) != r0) goto L11;
        return r0;
    }
}
