package com.larus.voicecall.impl.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallHelperKt$a implements p0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ BotModel b;
    public final /* synthetic */ Ref.ObjectRef<b3a.c> c;

    public final void confirm() {
        if (AudioServiceDelegate.a.getAudioConfig().o("voice_setting", "setting", true) == true) goto L51;
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, "//flow/single_tts_speaker_setting");
        Pair[] r1 = new Pair[6];
        r1[0] = TuplesKt.to("select_speaker_argument", this.b);
        r1[1] = TuplesKt.to("enter_from", "chat_realtime_call");
        r1[2] = TuplesKt.to("argSearchMobParam", ((b3a.c) this.c.element).l);
        BotModel r3 = this.b;
        if (r3 == null) goto L10;
        String r4 = r3.getName();
        if (r4 == null) goto L10;
        String r5 = r4;
    L11:
        BotModel r6 = this.b;
        if (r6 == null) goto L17;
        String r7 = r6.getDescriptionForHuman();
        if (r7 == null) goto L17;
        String r8 = r7;
    L18:
        BotModel r9 = this.b;
        if (r9 == null) goto L26;
        SpeakerVoice r10 = r9.getVoiceType();
        if (r10 == null) goto L26;
        String r11 = r10.getId();
        if (r11 == null) goto L26;
        String r12 = r11;
    L27:
        BotModel r13 = this.b;
        if (r13 == null) goto L33;
        String r14 = r13.getBotId();
        if (r14 == null) goto L33;
        String r15 = r14;
    L34:
        BotModel r16 = this.b;
        if (r16 == null) goto L39;
        ModelItem r17 = r16.getModel();
        if (r17 == null) goto L39;
        long r18 = r17.getModelType();
    L40:
        BotModel r19 = this.b;
        if (r19 == null) goto L48;
        SpeakerVoice r20 = r19.getVoiceType();
        if (r20 == null) goto L48;
        String r21 = r20.getLanguageCode();
        if (r21 == null) goto L48;
        String r110 = r21;
    L49:
        r1[3] = TuplesKt.to("key_voice_recommend_param", new GetMatchVoiceRequest(r5, r8, r12, r15, r18, r110, null, 64));
        r1[4] = TuplesKt.to("conversation_id", ((b3a.c) this.c.element).b);
        r1[5] = TuplesKt.to("key_enter_method", "tts_disabled");
        Bundle r2 = BundleKt.bundleOf(r1);
        r0.c.putExtras(r2);
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.e(100);
        return;
    L48:
        r110 = NameKeys.UnloadStrategy_No_Strategy;
    L39:
        r18 = 0;
    L33:
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r5 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    }

    public RealtimeCallHelperKt$a(Context r1, BotModel r2, Ref.ObjectRef<b3a.c> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
