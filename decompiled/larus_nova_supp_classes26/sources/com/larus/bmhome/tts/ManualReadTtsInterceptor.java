package com.larus.bmhome.tts;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.p0;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.i;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.larus.urlplayer.IAudioUrlPlayService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f2a.c;
import f2a.d;
import f2a.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ry8.b;
import t19.s;
import tx9.c0;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u0010\u001a\u00020\t*\u00020\u000bH\u0002J \u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0002J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/tts/ManualReadTtsInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "priority", "", "canHandle", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "isVideoSummaryMsg", "getInterpretUrl", "", "ext", "", "mobTtsIconClick", "", "msg", "toStatus", "ttsSwitchEnterMethod", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualReadTtsInterceptor implements ITtsReaderInterceptor {
    public final d a;

    public static final class a {
    }

    static {
    }

    public final int priority() {
        return 100;
    }

    public ManualReadTtsInterceptor() {
        this.a = new d("Chat", "ManualReadTtsInterceptor");
    }

    public final boolean a(Message r12, TtsScene r13) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "scene");
        FLogger r14 = FLogger.a;
        StringBuilder r0 = new StringBuilder("canHandle : ");
        TtsScene r3 = TtsScene.Manual_ActionView;
        TtsScene r5 = TtsScene.Manual_LongPress;
        TtsScene r7 = TtsScene.Manual_Selector;
        TtsScene r9 = TtsScene.Manual_Other;
        r0.append(CollectionsKt.listOf(new TtsScene[]{r3, r5, r7, r9}).contains(r13));
        r14.i("ManualReadTtsInterceptor", r0.toString());
        return CollectionsKt.listOf(new TtsScene[]{r3, r5, r7, r9}).contains(r13);
    }

    public final TtsInterceptResult b(Message r12, TtsScene r13) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "scene");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r1 = "";
        if (r0 == null) goto L18;
        r0.P();
        Fragment r2 = ChatServiceImpl.a.f();
        if (r2 == null) goto L18;
        y r3 = s1a.a.g(r2).getAbility(y.class);
        if (r3 == null) goto L18;
        BotModel r4 = r3.j0();
        if (r4 != null) goto L19;
        String r5 = r3.Y1();
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        Object r6 = BotInfoCache.INSTANCE.get(r5);
        if (r6 != null) goto L17;
        r6 = null;
    L17:
        r4 = (BotModel) r6;
    L19:
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L24;
        r7.P();
        Fragment r8 = ChatServiceImpl.a.f();
        if (r8 == null) goto L24;
        y r9 = (y) s1a.a.g(r8).getAbility(y.class);
    L25:
        AudioServiceDelegate r10 = AudioServiceDelegate.a;
        p0 r11 = r10.getAudioConfig();
        if (r13 != TtsScene.Manual_LongPress) goto L28;
    L34:
        String r14 = "long_press";
    L35:
        if (r9 == null) goto L37;
        e r15 = r9.h();
    L39:
        if (r11.o("tts", r14, i.f(r15)) == true) goto L41;
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r17 = false;
        if (r16 == null) goto L51;
        r16.P();
        Fragment r18 = ChatServiceImpl.a.f();
        if (r18 == null) goto L51;
        l r19 = s1a.a.g(r18).getAbility(l.class);
        if (r19 == null) goto L51;
        if (r19.Lo() != true) goto L51;
        boolean r20 = true;
    L53:
        if (r20 == false) goto L60;
        s r110 = s.a;
        Application r21 = FlowRuntime.a().getApplication();
        r110.getClass();
        s.s(r21, 2131911054);
        c r111 = this.a.a("[TTS][INTERRUPT_BY_HANDSFREE_MODE]");
        r111.c.b = CollectionsKt.listOf("TtsPlay");
        f r22 = f.i;
        String r112 = r12.getMessageId();
        if (r112 == null) goto L58;
        r1 = r112;
    L58:
        r111.d(MapsKt.mapOf(TuplesKt.to(r22, r1)));
        c.c(r111, null, 15);
        return TtsInterceptResult.Deny;
    L60:
        Map r23 = r12.getExt();
        if (r23 == null) goto L68;
        String r24 = (String) r23.get("simultaneous_interpretation");
        if (r24 == null) goto L65;
        JSONObject r25 = new JSONObject(r24);
    L66:
        if (r25 == null) goto L68;
        String r26 = r25.optString("translator_tts_audio_url");
    L70:
        if (TextUtils.isEmpty(r26) == true) goto L88;
        if (r26 == null) goto L87;
        c(r12, "1", "other_open");
        zh8.a.a.getReceiver().c().i6("click_answer_action", true);
        IFlowSdkDepend r113 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r113 == null) goto L79;
        r113.P();
        Fragment r114 = ChatServiceImpl.a.f();
        if (r114 == null) goto L79;
        xa8.d r115 = s1a.a.g(r114).getAbility(xa8.d.class);
        if (r115 == null) goto L79;
        r115.ZM("click_play");
    L79:
        c r116 = this.a.b("[TTS][START] startTts by interpret url");
        r116.c.b = CollectionsKt.listOf("TtsPlay");
        f r27 = f.i;
        String r28 = r12.getMessageId();
        if (r28 == null) goto L83;
        r1 = r28;
    L83:
        r116.d(MapsKt.mapOf(TuplesKt.to(r27, r1)));
        c.c(r116, null, 15);
        IAudioUrlPlayService r117 = (IAudioUrlPlayService) ServiceManager.get().getService(IAudioUrlPlayService.class);
        if (r117 == null) goto L87;
        r117.D(r26, r12);
    L87:
        return TtsInterceptResult.Deny;
    L88:
        AppHost.Companion r29 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r29.getApplication()) == true) goto L113;
        String r30 = r12.getMessageId();
        if (r4 == null) goto L95;
        SpeakerVoice r118 = r4.getVoiceType();
        if (r118 == null) goto L95;
        String r119 = r118.getStyleId();
    L96:
        if (r4 == null) goto L100;
        SpeakerVoice r31 = r4.getVoiceType();
        if (r31 == null) goto L100;
        String r32 = r31.getExtra();
    L102:
        if (r10.h(r30, r119, r32, null) == true) goto L113;
        c r120 = this.a.a("[TTS][NO_INTERNET_NO_CACHE]");
        r120.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r33 = new Pair[5];
        f r34 = f.i;
        String r35 = r12.getMessageId();
        if (r35 != null) goto L106;
        r35 = "";
    L106:
        r33[0] = TuplesKt.to(r34, r35);
        f r36 = new f("reply_id");
        String r37 = r12.getReplyId();
        if (r37 == null) goto L110;
        r1 = r37;
    L110:
        r33[1] = TuplesKt.to(r36, r1);
        r33[2] = TuplesKt.to(f.g, Integer.valueOf(r12.getContentType()));
        r33[3] = TuplesKt.to(new f("status_local"), Integer.valueOf(r12.getMessageStatusLocal()));
        r33[4] = TuplesKt.to(new f("status"), String.valueOf(r12.getMessageStatus()));
        r120.d(MapsKt.mapOf(r33));
        c.c(r120, null, 15);
        s r121 = s.a;
        Activity r122 = com.larus.utils.i.getActivity(r29.getApplication());
        r121.getClass();
        s.s(r122, 2131910632);
        return TtsInterceptResult.Deny;
    L100:
        r32 = null;
    L95:
        r119 = null;
    L113:
        if (r10.k0() == false) goto L121;
        s r123 = s.a;
        Activity r38 = com.larus.utils.i.getActivity(r29.getApplication());
        r123.getClass();
        s.s(r38, 2131900707);
        c r124 = this.a.a("[TTS][MANUAL_PLAY_HARD_DOWNGRADE] startTts isManualPlayHardDowngrade");
        r124.c.b = CollectionsKt.listOf("TtsPlay");
        f r39 = f.i;
        String r40 = r12.getMessageId();
        if (r40 == null) goto L118;
        r1 = r40;
    L118:
        r124.d(MapsKt.mapOf(TuplesKt.to(r39, r1)));
        c.c(r124, null, 15);
        c(r12, TriggerSendLoading.NO_LOADING, "resource_downgrade_auto_close");
        return TtsInterceptResult.Deny;
    L121:
        if (com.larus.bmhome.chat.bean.d.G0(r12) == false) goto L123;
    L129:
        boolean r41 = false;
    L130:
        boolean r42 = com.larus.bmhome.chat.bean.d.z0(r12);
        if (r41 == true) goto L146;
        if (r42 == true) goto L146;
        if (r12.getContentType() == 800) goto L136;
    L138:
        boolean r43 = false;
    L139:
        if (r43 == true) goto L146;
        c r125 = this.a.a("[TTS][NOT_TTS_ANSWER_OR_NOT_ON_BOARDING] start tts failed!");
        r125.c.b = CollectionsKt.listOf("TtsPlay");
        f r44 = f.i;
        String r126 = r12.getMessageId();
        if (r126 == null) goto L144;
        r1 = r126;
    L144:
        r125.d(MapsKt.mapOf(TuplesKt.to(r44, r1)));
        c.c(r125, null, 15);
        return TtsInterceptResult.Deny;
    L136:
        if (Intrinsics.areEqual(r12.getBizContentType(), "video_summary") == false) goto L138;
        r43 = true;
    L146:
        IFlowSdkDepend r45 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r45 == null) goto L155;
        r45.P();
        Fragment r46 = ChatServiceImpl.a.f();
        if (r46 == null) goto L155;
        com.larus.bmhome.chat.component.regen.a r47 = s1a.a.g(r46).getAbility(com.larus.bmhome.chat.component.regen.a.class);
        if (r47 == null) goto L155;
        if (r47.tL(r12) != true) goto L155;
        boolean r48 = true;
    L156:
        if (r48 == false) goto L158;
    L161:
        r17 = true;
    L163:
        if (r13 != TtsScene.Manual_ActionView) goto L172;
        if (r17 == true) goto L172;
        c r127 = this.a.a("[TTS][MESSAGE_HAS_NO_ACTION] start tts failed!");
        r127.c.b = CollectionsKt.listOf("TtsPlay");
        f r49 = f.i;
        String r128 = r12.getMessageId();
        if (r128 == null) goto L169;
        r1 = r128;
    L169:
        r127.d(MapsKt.mapOf(TuplesKt.to(r49, r1)));
        c.c(r127, null, 15);
        return TtsInterceptResult.Deny;
    L172:
        return TtsInterceptResult.Pass;
    L158:
        if (com.larus.im.bean.message.a.y0(r12) == true) goto L161;
        if (r29.isPlugin() == false) goto L163;
    L155:
        r48 = false;
        goto L156
    L123:
        if (com.larus.bmhome.chat.bean.d.N(r12) == false) goto L125;
    L128:
        r41 = true;
        goto L130
    L125:
        if (dp8.a.b(r12) == true) goto L128;
        if (com.larus.bmhome.chat.bean.d.k(r12) == false) goto L129;
    L65:
        r25 = null;
    L68:
        r26 = null;
    L51:
        r20 = false;
        goto L53
    L41:
        return TtsInterceptResult.Deny;
    L37:
        r15 = null;
        goto L39
    L28:
        if (r13 == TtsScene.Manual_Selector) goto L34;
        if (r13 != TtsScene.Manual_ActionView) goto L33;
        r14 = "action_view";
        goto L35
    L33:
        r14 = "other";
    L24:
        r9 = null;
    L18:
        r4 = null;
        goto L19
    }

    public static void c(Message r69, String r70, String r71) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L11;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
        if (r1 == null) goto L11;
        y r2 = s1a.a.g(r1).getAbility(y.class);
        if (r2 == null) goto L11;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L11;
    L12:
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L21;
        r4.P();
        Fragment r5 = ChatServiceImpl.a.f();
        if (r5 == null) goto L21;
        b r6 = s1a.a.g(r5).getAbility(b.class);
        if (r6 == null) goto L21;
        Boolean r7 = r6.L9();
        if (r7 == null) goto L21;
        boolean r8 = r7.booleanValue();
    L22:
        Fragment r9 = es8.d.b();
        String r10 = null;
        if (r9 == null) goto L27;
        y r11 = s1a.a.g(r9).getAbility(y.class);
        if (r11 == null) goto L27;
        e r12 = r11.h();
    L28:
        String r13 = r3.getBotId();
        String r14 = r69.getConversationId();
        if (r14 == null) goto L31;
        Long r15 = StringsKt.toLongOrNull(r14);
    L32:
        long r16 = 0;
        if (com.larus.bmhome.chat.bean.d.z0(r69) == false) goto L35;
        long r17 = 1;
    L36:
        String r18 = r69.getMessageId();
        if (r8 == false) goto L39;
        String r19 = "1";
    L40:
        String r110 = r19;
        LruCache<String, e> r20 = ko8.a.a;
        if (r12 == null) goto L43;
        Integer r21 = r12.v;
    L44:
        Integer r22 = r3.getBotType();
        BotCreatorInfo r23 = r3.getBotCreatorInfo();
        if (r23 == null) goto L47;
        r10 = r23.getId();
    L47:
        String r24 = ko8.a.f(r21, r22, Intrinsics.areEqual(r10, AccountService.a.getUserId()));
        boolean r25 = com.larus.bmhome.chat.bean.d.Q0(r69);
        IFlowSdkDepend r26 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r26 == null) goto L56;
        r26.P();
        Fragment r27 = ChatServiceImpl.a.f();
        if (r27 == null) goto L56;
        t1a.b r28 = s1a.a.g(r27);
        if (r28 == null) goto L56;
        de8.c r29 = r28.a(de8.c.class);
        if (r29 == null) goto L56;
        r16 = r29.n;
    L56:
        c0.G(r13, r24, "answer", r15, Long.valueOf(r17), r18, r70, r110, Boolean.valueOf(r25), r71, "main_text", Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r69)), Boolean.valueOf(com.larus.bmhome.chat.bean.d.K0(r69)), IAIChatControlTraceService.a.ob(r16), 262752);
        return;
    L43:
        r21 = null;
        goto L44
    L39:
        r19 = TriggerSendLoading.NO_LOADING;
        goto L40
    L35:
        r17 = 0;
        goto L36
    L31:
        r15 = null;
    L27:
        r12 = null;
    L21:
        r8 = false;
    L11:
        r3 = new BotModel("-1", "unknown", null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -132, Integer.MAX_VALUE, null);
        goto L12
    }
}
