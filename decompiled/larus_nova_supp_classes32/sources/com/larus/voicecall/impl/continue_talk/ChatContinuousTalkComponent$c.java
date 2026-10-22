package com.larus.voicecall.impl.continue_talk;

import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.aivoice.core.data.NameKeys;
import de8.c;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ChatContinuousTalkComponent$c implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public final void confirm() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a.getContext(), "//flow/single_tts_speaker_setting");
        Pair[] r1 = new Pair[6];
        ChatContinuousTalkComponent r2 = this.a;
        int r3 = ChatContinuousTalkComponent.M;
        com.larus.bmhome.chat.component.cvs.y r4 = r2.u0();
        String r5 = null;
        if (r4 == null) goto L5;
        BotModel r6 = r4.j0();
    L6:
        r1[0] = TuplesKt.to("select_speaker_argument", r6);
        r1[1] = TuplesKt.to("enter_from", "chat_realtime_call");
        r1[2] = TuplesKt.to("argSearchMobParam", ((c) this.a.q.getValue()).e);
        com.larus.bmhome.chat.component.cvs.y r7 = this.a.u0();
        if (r7 == null) goto L14;
        BotModel r8 = r7.j0();
        if (r8 == null) goto L14;
        String r9 = r8.getName();
        if (r9 == null) goto L14;
        String r10 = r9;
    L15:
        com.larus.bmhome.chat.component.cvs.y r11 = this.a.u0();
        if (r11 == null) goto L23;
        BotModel r12 = r11.j0();
        if (r12 == null) goto L23;
        String r13 = r12.getDescriptionForHuman();
        if (r13 == null) goto L23;
        String r14 = r13;
    L24:
        com.larus.bmhome.chat.component.cvs.y r15 = this.a.u0();
        if (r15 == null) goto L34;
        BotModel r16 = r15.j0();
        if (r16 == null) goto L34;
        SpeakerVoice r17 = r16.getVoiceType();
        if (r17 == null) goto L34;
        String r18 = r17.getId();
        if (r18 == null) goto L34;
        String r19 = r18;
    L35:
        com.larus.bmhome.chat.component.cvs.y r20 = this.a.u0();
        if (r20 == null) goto L43;
        BotModel r21 = r20.j0();
        if (r21 == null) goto L43;
        String r22 = r21.getBotId();
        if (r22 == null) goto L43;
        String r23 = r22;
    L44:
        com.larus.bmhome.chat.component.cvs.y r24 = this.a.u0();
        if (r24 == null) goto L51;
        BotModel r25 = r24.j0();
        if (r25 == null) goto L51;
        ModelItem r26 = r25.getModel();
        if (r26 == null) goto L51;
        long r110 = r26.getModelType();
    L52:
        com.larus.bmhome.chat.component.cvs.y r27 = this.a.u0();
        if (r27 == null) goto L62;
        BotModel r28 = r27.j0();
        if (r28 == null) goto L62;
        SpeakerVoice r29 = r28.getVoiceType();
        if (r29 == null) goto L62;
        String r30 = r29.getLanguageCode();
        if (r30 == null) goto L62;
        String r111 = r30;
    L63:
        r1[3] = TuplesKt.to("key_voice_recommend_param", new GetMatchVoiceRequest(r10, r14, r19, r23, r110, r111, null, 64));
        com.larus.bmhome.chat.component.cvs.y r31 = this.a.u0();
        if (r31 == null) goto L68;
        wc9.e r32 = r31.h();
        if (r32 == null) goto L68;
        r5 = r32.a;
    L68:
        r1[4] = TuplesKt.to("conversation_id", r5);
        r1[5] = TuplesKt.to("key_enter_method", "tts_disabled");
        r0.c.putExtras(BundleKt.bundleOf(r1));
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.e(100);
        return;
    L62:
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L51:
        r110 = 0;
    L43:
        r23 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
        goto L15
    L5:
        r6 = null;
        goto L6
    }

    public ChatContinuousTalkComponent$c(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }
}
