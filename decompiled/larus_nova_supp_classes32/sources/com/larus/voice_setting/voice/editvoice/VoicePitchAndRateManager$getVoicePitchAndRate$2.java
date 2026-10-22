package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/voice_setting/voice/editvoice/VoicePitchAndRate;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.VoicePitchAndRateManager$getVoicePitchAndRate$2", f = "VoicePitchAndRateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePitchAndRateManager$getVoicePitchAndRate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b1>, Object> {
    final /* synthetic */ List<MixVoice> $voiceList;
    int label;

    public VoicePitchAndRateManager$getVoicePitchAndRate$2(List<MixVoice> r1, Continuation<? super VoicePitchAndRateManager$getVoicePitchAndRate$2> r2) {
        this.$voiceList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoicePitchAndRateManager$getVoicePitchAndRate$2(this.$voiceList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r7);
        VoicePitchAndRateManager r8 = VoicePitchAndRateManager.a;
        List<MixVoice> r0 = this.$voiceList;
        r8.getClass();
        if (VoicePitchAndRateManager.a(r0, "getVoicePitchAndRate") == false) goto L27;
        MixVoice r9 = (MixVoice) CollectionsKt.firstOrNull(this.$voiceList);
        Float r1 = null;
        if (r9 == null) goto L11;
        SpeakerVoice r10 = r9.getVoiceItem();
        if (r10 == null) goto L11;
        String r11 = r10.getId();
    L12:
        b1 r2 = d1.a.query(VoicePitchAndRateManager.b + '_' + r11);
        List<MixVoice> r3 = this.$voiceList;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[getVoicePitchAndRate] voiceId is ");
        r5.append(r11);
        r5.append(", botId is ");
        r5.append(VoicePitchAndRateManager.b);
        r5.append(", voiceName is ");
        MixVoice r12 = (MixVoice) CollectionsKt.firstOrNull(r3);
        if (r12 == null) goto L17;
        SpeakerVoice r13 = r12.getVoiceItem();
        if (r13 == null) goto L17;
        String r14 = r13.getName();
    L18:
        r5.append(r14);
        r5.append(", pitchAndRate is ");
        r5.append(r2);
        r5.append(", pitchF64 ");
        if (r2 == null) goto L21;
        Float r15 = Boxing.boxFloat(r2.b());
    L22:
        r5.append(r15);
        r5.append(", speechRateF64 ");
        if (r2 == null) goto L25;
        r1 = Boxing.boxFloat(r2.c());
    L25:
        r5.append(r1);
        r4.i("VoicePitchAndRateManager", r5.toString());
        return r2;
    L21:
        r15 = null;
    L17:
        r14 = null;
    L11:
        r11 = null;
        goto L12
    L27:
        return VoicePitchAndRateManager.b(this.$voiceList);
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
