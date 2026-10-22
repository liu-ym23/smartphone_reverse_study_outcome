package com.larus.voice_setting.voice.editvoice;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.VoicePitchAndRateManager$saveVoicePitchAndRate$1", f = "VoicePitchAndRateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePitchAndRateManager$saveVoicePitchAndRate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b1 $pitchAndRate;
    final /* synthetic */ List<MixVoice> $voiceList;
    int label;

    public VoicePitchAndRateManager$saveVoicePitchAndRate$1(List<MixVoice> r1, b1 r2, Continuation<? super VoicePitchAndRateManager$saveVoicePitchAndRate$1> r3) {
        this.$voiceList = r1;
        this.$pitchAndRate = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoicePitchAndRateManager$saveVoicePitchAndRate$1(this.$voiceList, this.$pitchAndRate, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L61;
        ResultKt.throwOnFailure(r11);
        MixVoice r12 = (MixVoice) CollectionsKt.firstOrNull(this.$voiceList);
        OutputStreamWriter r0 = null;
        if (r12 == null) goto L9;
        SpeakerVoice r13 = r12.getVoiceItem();
        if (r13 == null) goto L9;
        String r14 = r13.getId();
    L10:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[saveVoicePitchAndRate] pitchAndRate is ");
        r2.append(this.$pitchAndRate);
        r2.append(", botId is ");
        r2.append(VoicePitchAndRateManager.b);
        r2.append(", voiceId is ");
        r2.append(r14);
        r2.append(", voiceName is ");
        MixVoice r3 = (MixVoice) CollectionsKt.firstOrNull(this.$voiceList);
        if (r3 == null) goto L15;
        SpeakerVoice r4 = r3.getVoiceItem();
        if (r4 == null) goto L15;
        String r5 = r4.getName();
    L16:
        r2.append(r5);
        r2.append(", pitchF64 ");
        r2.append(this.$pitchAndRate.b());
        r2.append(", speechRateF64 ");
        r2.append(this.$pitchAndRate.c());
        r1.i("VoicePitchAndRateManager", r2.toString());
        d1 r6 = d1.a;
        String r15 = VoicePitchAndRateManager.b + '_' + r14;
        b1 r7 = this.$pitchAndRate;
        r6.getClass();
        if (r15 != null) goto L19;
    L22:
        boolean r8 = true;
    L24:
        if (r8 == true) goto L57;
        if (r7 == null) goto L57;
        com.larus.cache.f r9 = (com.larus.cache.f) d1.c.getValue();
        if (r9 == null) goto L59;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L52
        com.larus.cache.f.c r16 = r9.d(r15);     // Catch: Throwable -> L52
        String r17 = d1.b.toJson(r7);     // Catch: Throwable -> L52
        if (r17 != null) goto L33;
    L36:
        boolean r18 = true;
    L37:
        if (r18 == true) goto L51;
        OutputStreamWriter r19 = new OutputStreamWriter(r16.b(), StandardCharsets.UTF_8);     // Catch: Throwable -> L47
        r19.write(r17);     // Catch: Throwable -> L45
        com.larus.utils.g.a(r19);     // Catch: Throwable -> L52
        if (r16.c == false) goto L43;
        com.larus.cache.f.a(r16.d, r16, false);     // Catch: Throwable -> L52
        r16.d.l(r16.a.a);     // Catch: Throwable -> L52
    L44:
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L52
    L54:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L59;
        FLogger.a.e("VoicePitchAndRateRepo", "[save] key(" + r15 + ") failed", r21);
        goto L59
    L43:
        com.larus.cache.f.a(r16.d, r16, true);     // Catch: Throwable -> L52
    L45:
        th = move-exception;
        th = th;
        r0 = r19;
    L48:
        com.larus.utils.g.a(r0);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L47:
        th = th;
        goto L48
    L51:
        throw new RuntimeException("dataStr is null or Empty, key=" + r15 + ", data=" + r7);     // Catch: Throwable -> L52
    L33:
        if (r17.length() == 0) goto L36;
        r18 = false;
    L52:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L59:
        return Unit.INSTANCE;
    L57:
        r1.i("VoicePitchAndRateRepo", "[save] key(" + r15 + ") or data(" + r7 + ") is null or empty");
        goto L59
    L19:
        if (r15.length() == 0) goto L22;
        r8 = false;
    L15:
        r5 = null;
    L9:
        r14 = null;
        goto L10
    L61:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
