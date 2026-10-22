package com.larus.voice_setting.voice;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1", f = "DoubleTabTtsSpeakerSettingFragment.kt", i = {}, l = {1279}, m = "invokeSuspend", n = {}, s = {})
final class DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoubleTabTtsSpeakerSettingFragment this$0;

    public DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1(DoubleTabTtsSpeakerSettingFragment r1, Continuation<? super DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r24);
        Object r3 = r24;
    L39:
        com.larus.network.http.y r4 = (com.larus.network.http.a) r3;
        if ((r4 instanceof com.larus.network.http.y) == false) goto L89;
        SpeakerVoice r5 = (SpeakerVoice) ((com.larus.network.http.a) r4).b;
        if (r5 == null) goto L89;
        DoubleTabTtsSpeakerSettingFragment r6 = this.this$0;
        List<String> r7 = DoubleTabTtsSpeakerSettingFragment.Z;
        if (r6.X90().isMultiVoiceMixMode() == false) goto L77;
        List r8 = r5.getMixVoiceList();
        if (r8 == null) goto L89;
        SpeakerVoiceEditModel r9 = r6.X90().getSpeakerVoiceEditModel();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "list");
        FLogger.a.i("SpeakerVoiceEditModel", "[updateVoice] current:" + r9.n + ", list:" + r8);
        ArrayList r10 = new ArrayList();
        if ((!r9.n.isEmpty()) == false) goto L89;
        Iterator r11 = r8.iterator();
    L51:
        if (r11.hasNext() == false) goto L74;
        MixVoice r12 = (MixVoice) r11.next();
        Iterator<MixVoice> r13 = r9.n.iterator();
        int r14 = 0;
    L54:
        if (r13.hasNext() == false) goto L67;
        SpeakerVoice r15 = r13.next().getVoiceItem();
        if (r15 == null) goto L58;
        String r16 = r15.getId();
    L59:
        SpeakerVoice r17 = r12.getVoiceItem();
        if (r17 == null) goto L62;
        String r18 = r17.getId();
    L64:
        if (Intrinsics.areEqual(r16, r18) == true) goto L68;
        r14 = r14 + 1;
    L68:
        if (r14 == (-1)) goto L51;
        MixVoice r19 = (MixVoice) ListProtector.get(r9.n, r14);
        if (r12.isEnable() == false) goto L71;
        int r20 = ((MixVoice) ListProtector.get(r9.n, r14)).getPercentage();
        ListProtector.set(r9.n, r14, new MixVoice(r12.getVoiceItem(), r20, false, null, 12, null));
        r10.add(new MixVoice(r12.getVoiceItem(), r20, false, null, 12, null));
        goto L51
    L71:
        r9.n(r19.getVoiceItem(), "from_tts");
        goto L51
    L62:
        r18 = null;
        goto L64
    L58:
        r16 = null;
        goto L59
    L67:
        r14 = -1;
        goto L68
    L74:
        if ((!r10.isEmpty()) == false) goto L76;
        r9.t.postValue(new w2a.a(r10));
    L76:
        r9.r();
        goto L89
    L77:
        SpeakerVoiceEditModel r21 = r6.X90().getSpeakerVoiceEditModel();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r5, "voiceDetail");
        SpeakerVoice r22 = SpeakerVoiceEditModel.i(r5);
        if (r22 == null) goto L80;
        String r23 = r22.getId();
    L81:
        SpeakerVoice r25 = (SpeakerVoice) r21.j.getValue();
        if (r25 == null) goto L84;
        String r26 = r25.getId();
    L86:
        if (Intrinsics.areEqual(r23, r26) == false) goto L89;
        r21.q(r22, false);
        goto L89
    L84:
        r26 = null;
        goto L86
    L80:
        r23 = null;
    L89:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        SpeakerVoice r27 = this.this$0.n;
        if (r27 == null) goto L12;
        String r28 = r27.getId();
        if (r28 == null) goto L12;
    L18:
        String r29 = this.this$0.getBotId();
        if (r28 != null) goto L21;
    L24:
        boolean r30 = true;
    L25:
        if (r30 == true) goto L91;
        if (r29 != null) goto L28;
    L31:
        boolean r31 = true;
    L32:
        if (r31 == true) goto L91;
        if (Intrinsics.areEqual(r28, "0") == true) goto L91;
        TtsSpeakerSettingViewModel r32 = this.this$0.X90();
        String r33 = this.this$0.j;
        this.label = 1;
        r3 = r32.requestVoiceDetail(r28, r33, r29, this);
        if (r3 != r1) goto L39;
        return r1;
    L28:
        if (r29.length() == 0) goto L31;
        r31 = false;
    L91:
        return Unit.INSTANCE;
    L21:
        if (r28.length() == 0) goto L24;
        r30 = false;
    L12:
        BotModel r34 = this.this$0.g;
        if (r34 == null) goto L17;
        SpeakerVoice r35 = r34.getVoiceType();
        if (r35 == null) goto L17;
        r28 = r35.getId();
    L17:
        r28 = null;
        goto L18
    }
}
