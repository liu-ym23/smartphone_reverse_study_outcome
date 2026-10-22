package com.larus.tts.impl;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.d1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.MainBotInfoUtil;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$startTtsWithoutMessage$1", f = "TtsReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$startTtsWithoutMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onNext;
    final /* synthetic */ Map<String, String> $payloadParam;
    final /* synthetic */ String $type;
    final /* synthetic */ String $uniId;
    int label;
    final /* synthetic */ TtsReader this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public TtsReader$startTtsWithoutMessage$1(String r1, String r2, Map<String, String> r3, Function0<Unit> r4, Function1<? super String, Unit> r5, TtsReader r6, Continuation<? super TtsReader$startTtsWithoutMessage$1> r7) {
        this.$uniId = r1;
        this.$type = r2;
        this.$payloadParam = r3;
        this.$onNext = r4;
        this.$onFailed = r5;
        this.this$0 = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new TtsReader$startTtsWithoutMessage$1(this.$uniId, this.$type, this.$payloadParam, this.$onNext, this.$onFailed, this.this$0, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r18);
        HashMap r1 = new HashMap();
        int r2 = b.a;
        String r3 = com.flow.kmp.common.util.i.a();
        r1.put("enable_toast_reading", "true");
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().d(this.$uniId, "startTtsWithoutMessage_" + this.$type);
        if (MainBotInfoUtil.a != null) goto L7;
        MainBotInfoUtil.a();
    L7:
        BotModel r4 = MainBotInfoUtil.a;
        String r5 = null;
        if (r4 == null) goto L10;
        SpeakerVoice r6 = r4.getVoiceType();
    L12:
        if (r6 == null) goto L30;
        String r7 = r6.getStyleId();
        if (r7 != null) goto L16;
        String r8 = "";
    L17:
        String r9 = r6.getName();
        if (r9 != null) goto L20;
        String r10 = "";
    L21:
        String r11 = r6.getExtra();
        if (r11 != null) goto L24;
        String r12 = "";
    L25:
        String r13 = r6.getAudioMetrics();
        if (r13 != null) goto L28;
        String r14 = "";
    L29:
        p68.i r15 = new p68.i(r8, r10, null, r12, r14, 4);
    L31:
        if (r6 == null) goto L34;
        d1 r16 = AudioServiceDelegate.a.i0();
        Map<String, String> r17 = this.$payloadParam;
        Function0<Unit> r19 = this.$onNext;
        Function1<String, Unit> r110 = this.$onFailed;
        String r20 = this.$type;
        r16.d(r3, "0", "0", false, r17, true, r15, true, r19, r110, r20, r20);
        TtsReader.b(this.this$0, "", this.$uniId, r3);
        return Unit.INSTANCE;
    L34:
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("startTtsWithoutMessage failed, mainSpeakerVoice is null. mainBotId=");
        if (MainBotInfoUtil.a != null) goto L37;
        MainBotInfoUtil.a();
    L37:
        BotModel r23 = MainBotInfoUtil.a;
        if (r23 == null) goto L40;
        r5 = r23.getBotId();
    L40:
        r22.append(r5);
        r21.e("TtsReader", r22.toString());
        return Unit.INSTANCE;
    L28:
        r14 = r13;
        goto L29
    L24:
        r12 = r11;
        goto L25
    L20:
        r10 = r9;
        goto L21
    L16:
        r8 = r7;
        goto L17
    L30:
        r15 = null;
        goto L31
    L10:
        r6 = null;
        goto L12
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
