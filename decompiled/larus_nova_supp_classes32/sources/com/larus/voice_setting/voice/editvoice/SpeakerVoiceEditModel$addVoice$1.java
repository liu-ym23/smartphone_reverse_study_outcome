package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel$addVoice$1", f = "SpeakerVoiceEditModel.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
final class SpeakerVoiceEditModel$addVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$addVoice$1(SpeakerVoiceEditModel r1, Continuation<? super SpeakerVoiceEditModel$addVoice$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpeakerVoiceEditModel$addVoice$1(this.this$0, r3);
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
        b1 r5 = (b1) r4;
        if (r5 == null) goto L14;
        SpeakerVoiceEditModel r2 = this.this$0;
        float r3 = r5.b();
        r2.getClass();
        com.larus.utils.t0.e(new p0(r2, r3));
        SpeakerVoiceEditModel r6 = this.this$0;
        float r7 = r5.c();
        r6.getClass();
        com.larus.utils.t0.e(new r0(r6, r7));
    L16:
        return Unit.INSTANCE;
    L14:
        SpeakerVoiceEditModel r8 = this.this$0;
        int r9 = SpeakerVoiceEditModel.P;
        r8.getClass();
        com.larus.utils.t0.e(new q0(r8));
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        VoicePitchAndRateManager r10 = VoicePitchAndRateManager.a;
        ArrayList<MixVoice> r11 = this.this$0.n;
        this.label = 1;
        r10.getClass();
        r4 = VoicePitchAndRateManager.c(r11, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
