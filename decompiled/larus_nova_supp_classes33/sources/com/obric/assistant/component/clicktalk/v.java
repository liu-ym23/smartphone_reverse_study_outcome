package com.obric.assistant.component.clicktalk;

import com.larus.asr.VoiceInputType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.voice.ComplexEvent;
import com.obric.assistant.voice.ContentScene;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.OAutoEvent;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ ChatClickTalkComponent$a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ VoiceInputType d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Integer g;

    public /* synthetic */ v(ChatClickTalkComponent r1, ChatClickTalkComponent$a r2, String r3, VoiceInputType r4, String r5, String r6, Integer r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        final ChatClickTalkComponent r1 = this.a;
        final ChatClickTalkComponent$a r2 = this.b;
        String r3 = this.c;
        VoiceInputType r7 = this.d;
        String r4 = this.e;
        String r5 = this.f;
        Integer r6 = this.g;
        int r8 = ChatClickTalkComponent.L0;
        if (r1.p3(r2) == true) goto L474;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r1, r1).isDetached() == false) goto L9;
        r1.C3("dropped", "chat_fragment_detached", r3);
        r1.h4(r2);
        return;
    L9:
        if (r3 != null) goto L11;
    L13:
        String r9 = null;
    L14:
        if (r9 == null) goto L16;
        final uga.b r13 = new uga.b(r9);
    L17:
        r1.M = r13;
        if (Intrinsics.areEqual(r1.N, r9) == false) goto L20;
        r1.N = null;
    L20:
        IAssistantChatWindow r10 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r10 != null) goto L23;
    L25:
        boolean r11 = false;
    L27:
        if (r11 == true) goto L29;
        ICoreInputAbility r12 = (ICoreInputAbility) r1.s.getValue();
        if (r12 == null) goto L44;
        r12.Rk();
    L44:
        ICoreInputAbility r14 = (ICoreInputAbility) r1.s.getValue();
        if (r14 == null) goto L47;
        r14.g2(2, true);
    L47:
        ICoreInputAbility r15 = (ICoreInputAbility) r1.s.getValue();
        if (r15 == null) goto L50;
        r15.qp(false);
    L50:
        final String r16 = UUID.randomUUID().toString();
        r1.L = r16;
        if (r1.P != r1.m) goto L130;
        Map r17 = r1.Q;
        if (r17 == null) goto L55;
        Object r18 = r17.get("scene");
    L57:
        if ((r18 instanceof String) == false) goto L59;
        String r0 = (String) r18;
    L60:
        if (r0 != null) goto L62;
        r0 = ContentScene.UNKNOWN.getStr();
    L62:
        ContentScene r19 = ContentScene.OAUTO_CALL_USER;
        VoiceInputType r110 = r7;
        String r111 = "";
        String r112 = r5;
        Integer r20 = r6;
        if (Intrinsics.areEqual(r0, r19.getStr()) == false) goto L81;
        Map r21 = r1.Q;
        if (r21 == null) goto L67;
        Object r22 = r21.get("data");
    L69:
        if ((r22 instanceof OAutoEvent) == false) goto L71;
        OAutoEvent r23 = (OAutoEvent) r22;
    L72:
        String r24 = "<this>";
        FLogger.a.i("ChatClickTalkComponent", "realStart from autoMic by " + r0 + " with data " + r23);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r25 = IObricAutoMicService.a.a();
        if (r25 == null) goto L80;
        Intrinsics.checkNotNullParameter(r19, "scene");
        if (r23 == null) goto L78;
        String r26 = r23.a();
        if (r26 == null) goto L78;
    L79:
        com.obric.assistant.voice.a r27 = new com.obric.assistant.voice.a(r19, r26);
        r27.f = r23;
        r25.m(r16, r27);
    L78:
        r26 = r111;
    L80:
        String r28 = r4;
    L132:
        if (ObricAsrDelegate.b.q() == false) goto L147;
        IAgentVoiceInteractionIDL r29 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r29 == null) goto L139;
        PersonalContextInfo r30 = r29.getUserRecentData();
        if (r30 == null) goto L139;
        String r31 = r30.getPersonalInfo();
        if (r31 == null) goto L139;
    L140:
        IAgentVoiceInteractionIDL r32 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r32 == null) goto L148;
        PersonalContextInfo r33 = r32.getUserRecentData();
        if (r33 == null) goto L148;
        Boolean r34 = r33.isComplete();
        if (r34 == null) goto L148;
        boolean r35 = r34.booleanValue();
    L149:
        r1.V = r2;
        IObricTraceParam r36 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r36 == null) goto L152;
        r36.f(r1.P);
    L152:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r37 = r1.Ak();
        if (r37 != null) goto L155;
        r1.j4(false, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        r1.C3("dropped", "speaker_ability_unavailable", r3);
        r1.h4(r2);
        return;
    L155:
        laa.d r38 = r1.V3();
        if (r38 != null) goto L158;
    L160:
        boolean r39 = false;
    L161:
        if (r39 == false) goto L163;
    L165:
        boolean r40 = false;
    L166:
        Function1 r113 = new x(r1, r2, r16, r13);
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("wakeup_from", Integer.valueOf(r1.P));
        Lazy r41 = l0.a;
        if (r28 != null) goto L169;
        String r42 = UUID.randomUUID().toString();
    L170:
        com.larus.bmhome.chat.component.cvs.y r43 = r1.u0();
        if (r43 == null) goto L173;
        wc9.e r44 = r43.h();
    L174:
        com.larus.bmhome.chat.component.cvs.y r115 = r1.u0();
        if (r115 == null) goto L177;
        BotModel r116 = r115.j0();
    L178:
        de8.c r117 = r1.f1();
        Intrinsics.checkNotNullParameter(r1, r24);
        by7.e r118 = by7.h.h(com.larus.ui.arch.component.internal.attach.a.b(r1, r1));
        Intrinsics.checkNotNullParameter(r42, "callId");
        Intrinsics.checkNotNullParameter(r16, "taskId");
        Intrinsics.checkNotNullParameter(r117, "chatArgumentData");
        if (r118 == null) goto L181;
        HashMap r119 = by7.h.a(r118).getParams();
    L182:
        if (r119 == null) goto L184;
        Object r120 = r119.get("current_page");
    L186:
        if ((r120 instanceof String) == false) goto L188;
        String r45 = (String) r120;
    L189:
        if (r45 != null) goto L192;
        r45 = r111;
    L192:
        if (Intrinsics.areEqual(r45, "chat") == false) goto L202;
        if (r119 == null) goto L195;
        Object r46 = r119.get("previous_page");
    L197:
        if ((r46 instanceof String) == false) goto L199;
        String r47 = (String) r46;
    L200:
        if (r47 != null) goto L203;
        r47 = r111;
    L203:
        if (r116 == null) goto L205;
        SpeakerVoice r121 = r116.getVoiceType();
    L207:
        if (r44 == null) goto L213;
        String r48 = r44.a;
        if (r48 == null) goto L213;
        Function1 r210 = r113;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r211 = r37;
        boolean r212 = r40;
        LinkedHashMap r310 = r114;
        if (StringsKt.contains$default(r48, "local", false, 2, null) != true) goto L214;
        boolean r49 = true;
    L216:
        if (r49 == false) goto L218;
        String r50 = "0";
    L223:
        boolean r311 = ObricRealtimeCallServiceDelegate.b.a();
        IObricVoiceService.a.getClass();
        IObricVoiceService r51 = IObricVoiceService.a.a();
        if (r51 != null) goto L226;
    L228:
        boolean r52 = false;
    L229:
        if (r52 == false) goto L233;
        IObricVoiceService r53 = IObricVoiceService.a.a();
        if (r53 == null) goto L233;
        Integer r54 = r53.q();
    L234:
        if (r20 != null) goto L236;
    L240:
        Integer r122 = r20;
    L241:
        boolean r123 = false;
    L242:
        FLogger r55 = FLogger.a;
        String r312 = r45;
        r55.i("ClickTalkCreateParamUtil", "isDoraVuiWakeup vuiId=" + r122 + ", wakeupId=" + r54 + ", result=" + r123);
        RealtimeCallParam r56 = new RealtimeCallParam();
        r56.e = r42;
        if (r123 == false) goto L248;
        if (r122 == null) goto L246;
        int r57 = r122.intValue();
    L247:
        r56.g = r57;
        r56.c0 = 0;
    L259:
        r55.i("ClickTalkCreateParamUtil", "createClickTalkParam isDoraVuiWakeup=" + r123);
        AudioSessionType r58 = AudioSessionType.SAMI;
        Intrinsics.checkNotNullParameter(r58, "<set-?>");
        r56.s = r58;
        if (r116 == null) goto L264;
        ModelItem r59 = r116.getModel();
        if (r59 == null) goto L264;
        String r60 = r59.getModelName();
    L265:
        if (r60 != null) goto L267;
        r60 = r111;
    L267:
        r56.i = r60;
        RealtimeCallParam.h r61 = r56.k;
        if (r44 == null) goto L270;
        String r62 = r44.a;
    L271:
        r61.getClass();
        Intrinsics.checkNotNullParameter("QwsgN3QXFsz4ttIT", "<set-?>");
        r61.b = "QwsgN3QXFsz4ttIT";
        AudioServiceDelegate r124 = AudioServiceDelegate.a;
        String r125 = r124.d("QwsgN3QXFsz4ttIT");
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r61.a = r125;
        String r313 = r47;
        wc9.e r314 = r44;
        String r63 = m58.h.b(false, null, 6);
        Intrinsics.checkNotNullParameter(r63, "<set-?>");
        r61.d = r63;
        AccountService r64 = AccountService.a;
        String r65 = r64.getUserId();
        Intrinsics.checkNotNullParameter(r65, "<set-?>");
        r61.f = r65;
        com.larus.platform.service.o r66 = com.larus.platform.service.o.a;
        String r126 = r66.getDeviceId();
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r61.g = r126;
        AppHost.Companion r127 = AppHost.a;
        String r128 = r127.getVersionName();
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r61.h = r128;
        r61.i = r127.getVersionCode();
        Intrinsics.checkNotNullParameter("assistant_half_duplex", "<set-?>");
        r61.o = "assistant_half_duplex";
        r61.j = r127.getUpdateVersionCode();
        SpeakerVoice r315 = r121;
        z2 r316 = z2.a;
        lq9.e r410 = r316.V2().getData();
        if (r410 == null) goto L274;
        int r129 = r410.c();
    L275:
        lq9.e r317 = r316.V2().getData();
        if (r317 == null) goto L281;
        int[] r318 = r317.b();
        if (r318 == null) goto L281;
        boolean r67 = false;
        int[] r68 = r318;
    L282:
        RealtimeCallParam.f r130 = new RealtimeCallParam.f(new RealtimeCallParam.e(r67, r129, r68));
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        r61.l = r130;
        if (c78.a.a().length() <= 0) goto L285;
        int r69 = 1;
    L286:
        r61.m = r69;
        LocalSubConvHelper r70 = LocalSubConvHelper.a;
        String r71 = (String) LocalSubConvHelper.d(r62).get("sub_conv_firstmet_type");
        if (r71 != null) goto L289;
        r71 = r111;
    L289:
        Intrinsics.checkNotNullParameter(r71, "<set-?>");
        r61.q = r71;
        String r72 = (String) LocalSubConvHelper.d(r62).get("sub_conv_source_message");
        if (r72 != null) goto L292;
        r72 = r111;
    L292:
        Intrinsics.checkNotNullParameter(r72, "<set-?>");
        r61.r = r72;
        Intrinsics.checkNotNullParameter("assistant_scene_mode_click_talk", "<set-?>");
        r61.t = "assistant_scene_mode_click_talk";
        r61.n = 2;
        if (r124.isDoraConnected() == false) goto L296;
        if (r123 == false) goto L296;
        r61.n = 6;
        r61.s = 1;
    L296:
        RealtimeCallParam.d r73 = r56.l;
        r73.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r73.a = r16;
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        r73.c = r50;
        ISettingRepoService r74 = l0.a();
        if (r74 == null) goto L299;
        String r131 = r74.Z(null);
    L300:
        if (r131 != null) goto L302;
        r131 = r111;
    L302:
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        r73.p = r131;
        ISettingRepoService r75 = l0.a();
        if (r75 == null) goto L305;
        String r132 = r75.S0();
    L306:
        if (r132 != null) goto L308;
        r132 = r111;
    L308:
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        r73.d = r132;
        JSONObject r76 = new JSONObject();
        r76.put("uid", r64.getUserId());
        r76.put("did", r66.getDeviceId());
        r76.put("app_version", String.valueOf(r127.getUpdateVersionCode()));
        ISettingRepoService r77 = l0.a();
        if (r77 == null) goto L311;
        String r133 = r77.Q0();
    L312:
        r76.put("speech_language", r133);
        ISettingRepoService r78 = l0.a();
        if (r78 == null) goto L315;
        String r134 = r78.S0();
    L316:
        r76.put("asr_language", r134);
        ISettingRepoService r79 = l0.a();
        if (r79 == null) goto L319;
        String r135 = r79.Z(null);
    L320:
        r76.put("model", r135);
        r76.put("os", "Android");
        ISettingRepoService r80 = l0.a();
        if (r80 != null) goto L323;
    L325:
        int r81 = 0;
    L326:
        r76.put("dumpRate", r81);
        ISettingRepoService r82 = l0.a();
        if (r82 == null) goto L329;
        Boolean r136 = Boolean.valueOf(r82.B());
    L330:
        r76.put("send_mq", r136);
        if (r31.length() != 0) goto L333;
        boolean r83 = true;
    L334:
        if (r83 == false) goto L468;
    L340:
        r73.a(r76.toString());
        r73.h = 3;
        r73.m = c78.a.g.getBoolean("key_realtime_call_pre_query_enable", false);
        r73.t = true;
        Intrinsics.checkNotNullParameter("bigasr-acllm-release-grpc-1", "<set-?>");
        r73.u = "bigasr-acllm-release-grpc-1";
        if (r123 == false) goto L343;
        Intrinsics.checkNotNullParameter("speech_opus", "<set-?>");
        r73.g = "speech_opus";
    L344:
        RealtimeCallParam.p r84 = r56.o;
        if (r116 == 0) goto L347;
        String r137 = r116.getBotId();
    L348:
        if (r137 != null) goto L350;
        r137 = r111;
    L350:
        r84.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r84.a = r16;
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        r84.h = r137;
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        r84.c = r50;
        r84.o = false;
        r84.p = true;
        ObricRealtimeCallServiceDelegate r85 = ObricRealtimeCallServiceDelegate.b;
        String r86 = r85.h(r315);
        Intrinsics.checkNotNullParameter(r86, "<set-?>");
        r84.d = r86;
        if (r315 == null) goto L353;
        String r138 = r315.getName();
    L354:
        if (r138 != null) goto L356;
        r138 = r111;
    L356:
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        r84.g = r138;
        r84.j = r85.e();
        if (r315 == null) goto L359;
        String r139 = r315.getId();
    L360:
        if (r139 != null) goto L362;
        r139 = r111;
    L362:
        Intrinsics.checkNotNullParameter(r139, "<set-?>");
        r84.f = r139;
        if (r315 == null) goto L365;
        String r140 = r315.getExtra();
    L366:
        if (r140 != null) goto L368;
        r140 = r111;
    L368:
        Intrinsics.checkNotNullParameter(r140, "<set-?>");
        r84.n = r140;
        if (r315 == null) goto L371;
        String r141 = r315.getAudioMetrics();
    L372:
        if (r141 != null) goto L374;
        r141 = r111;
    L374:
        Intrinsics.checkNotNullParameter(r141, "<set-?>");
        r84.t = r141;
        r84.u = r85.b();
        r84.v = r85.c();
        RealtimeCallParam.k r87 = r56.p;
        r87.getClass();
        Intrinsics.checkNotNullParameter(r313, "<set-?>");
        r87.b = r313;
        Intrinsics.checkNotNullParameter("chat", "<set-?>");
        r87.c = "chat";
        Intrinsics.checkNotNullParameter(r312, "<set-?>");
        r87.d = r312;
        RecommendFrom r88 = r117.d;
        if (r88 == null) goto L377;
        String r142 = r88.a;
    L378:
        r87.e = r142;
        if (r88 == null) goto L381;
        String r143 = r88.b;
    L382:
        r87.f = r143;
        IAIChatControlTraceService.Companion r89 = IAIChatControlTraceService.a;
        if (r314 == null) goto L385;
        Integer r144 = r314.v;
    L386:
        if (r116 == 0) goto L388;
        Integer r90 = r116.getBotType();
    L389:
        if (r116 == 0) goto L393;
        BotCreatorInfo r91 = r116.getBotCreatorInfo();
        if (r91 == null) goto L393;
        String r92 = r91.getId();
    L394:
        r87.g = r89.g(r144, r90, Intrinsics.areEqual(r92, AccountService.a.getUserId()));
        SearchMobParam r93 = r117.e;
        if (r93 == null) goto L397;
        String r94 = r93.a;
    L398:
        if (r93 == null) goto L400;
        String r95 = r93.b;
    L401:
        if (r93 == null) goto L403;
        String r96 = r93.c;
    L404:
        if (r93 == null) goto L406;
        String r97 = r93.e;
    L407:
        if (r93 == null) goto L409;
        String r145 = r93.f;
    L410:
        if (r93 == null) goto L412;
        String r146 = r93.g;
    L413:
        r87.h = new RealtimeCallParam.n(r94, r95, r96, r97, r145, r146, 8);
        r87.i = r112;
        String r98 = r111;
        r87.k = r98;
        String r99 = r117.e();
        if (r99 != null) goto L416;
        r99 = r98;
    L416:
        r87.l = r99;
        String r100 = r117.d();
        if (r100 != null) goto L419;
        r100 = r98;
    L419:
        r87.m = r100;
        r87.n = "0";
        Lazy r101 = l0.b;
        r87.r = ((i0) r101.getValue()).a;
        r87.s = ((i0) r101.getValue()).b;
        r56.y = false;
        r56.A = false;
        String r102 = AudioServiceDelegate.a.o(r56.k.b);
        if (r102 != null) goto L422;
        String r147 = r98;
    L423:
        r56.D = r147;
        r56.E = r85.n();
        r56.F = z2.a.b1().getEnableSceneMode();
        ObricOneshotDelegate r103 = ObricOneshotDelegate.b;
        RealtimeCallParam.l r104 = new RealtimeCallParam.l(r311, (String) r103.f("keyword"), ((Number) r103.f("offset")).longValue(), 8);
        FLogger r105 = FLogger.a;
        r105.i("ClickTalkCreateParamUtil", "enableOnehot: " + r104.a + ", keyword: " + r104.b + ", offset: " + r104.c);
        r56.M = r104;
        long r106 = r103.h();
        long r107 = r103.d();
        r105.i("ClickTalkCreateParamUtil", "backTraceHistoryMs: " + r106 + ", wakeupTimeStamp: " + r107);
        if (r106 <= 0) goto L426;
    L429:
        Long r148 = Long.valueOf(r106);
        if (r148.longValue() <= 0) goto L432;
        boolean r108 = true;
    L433:
        if (r108 == true) goto L436;
        r148 = null;
    L436:
        Long r109 = Long.valueOf(r107);
        if (r109.longValue() <= 0) goto L439;
        boolean r149 = true;
    L440:
        if (r149 == true) goto L443;
        r109 = null;
    L443:
        RealtimeCallParam.g r150 = new RealtimeCallParam.g(r148, r109);
    L444:
        r56.N = r150;
        r56.h = ((Number) r103.f("session")).intValue();
        r56.O = true;
        if (r56.g != 0) goto L449;
        int r151 = r56.c0;
        if (r151 <= 0) goto L449;
        r56.g = r151;
    L449:
        LinkedHashMap r152 = r310;
        r152.put("click_talk_param", r56);
        Unit r153 = Unit.INSTANCE;
        uga.b r154 = r13;
        String r155 = com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r211, false, r212, r110, false, null, null, null, r210, r152, null, 632);
        ChatClickTalkComponent r156 = r1;
        if (r156.p3(r2) == true) goto L475;
        if (r155 != null) goto L454;
        r156.j4(false, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        r156.C3("dropped", "click_talk_start_failed", r3);
        r156.h4(r2);
        return;
    L454:
        r156.U = r155;
        r156.T.put(r155, r2);
        if (r154 == null) goto L457;
        r156.O.put(r155, r154);
    L457:
        laa.m r157 = (laa.m) r156.x.getValue();
        if (r157 == null) goto L460;
        r157.MP(r2.b);
    L460:
        hca.c r158 = (hca.c) r156.F.getValue();
        if (r158 == null) goto L473;
        com.larus.bmhome.chat.component.cvs.y r159 = r156.u0();
        if (r159 == null) goto L465;
        String r160 = r159.Y1();
    L466:
        r158.b(r160, Integer.valueOf(r156.P), r156.L);
        r156.S = true;
        return;
    L465:
        r160 = null;
        goto L466
    L473:
        return;
    L475:
        return;
    L439:
        r149 = false;
        goto L440
    L432:
        r108 = false;
        goto L433
    L426:
        if (r107 > 0) goto L429;
        r150 = null;
        goto L444
    L422:
        r147 = r102;
        goto L423
    L412:
        r146 = null;
        goto L413
    L409:
        r145 = null;
        goto L410
    L406:
        r97 = null;
        goto L407
    L403:
        r96 = null;
        goto L404
    L400:
        r95 = null;
        goto L401
    L397:
        r94 = null;
    L393:
        r92 = null;
        goto L394
    L388:
        r90 = null;
        goto L389
    L385:
        r144 = null;
        goto L386
    L381:
        r143 = null;
        goto L382
    L377:
        r142 = null;
        goto L378
    L371:
        r141 = null;
        goto L372
    L365:
        r140 = null;
        goto L366
    L359:
        r139 = null;
        goto L360
    L353:
        r138 = null;
        goto L354
    L347:
        r137 = null;
        goto L348
    L343:
        Intrinsics.checkNotNullParameter("pcm", "<set-?>");
        r73.g = "pcm";
        r73.f = 2;
        goto L344
    L468:
        JSONArray r161 = new JSONArray(r31);     // Catch: JSONException -> L337
    L338:
        if (r161 == null) goto L340;
        r76.put("enable_update_nonstream_context", true);
        r76.put("personal_ctx", r161);
        r76.put("update_nonstream_context_finish", r35);
    L337:
        r161 = null;
        goto L338
    L333:
        r83 = false;
        goto L334
    L329:
        r136 = null;
        goto L330
    L323:
        if (r80.B() != true) goto L325;
        r81 = 1;
        goto L326
    L319:
        r135 = null;
        goto L320
    L315:
        r134 = null;
        goto L316
    L311:
        r133 = null;
        goto L312
    L305:
        r132 = null;
        goto L306
    L299:
        r131 = null;
        goto L300
    L285:
        r69 = 0;
    L281:
        r68 = new int[]{300, 600, 900, 1200, 1500};
        r67 = false;
        goto L282
    L274:
        r129 = 6000;
        goto L275
    L270:
        r62 = null;
    L264:
        r60 = null;
        goto L265
    L246:
        r57 = 0;
        goto L247
    L248:
        r55.i("ClickTalkCreateParamUtil", "UniqueWakeupId is " + r54 + " from voice wakeup / breath wakeup");
        if (r54 == null) goto L251;
        int r162 = r54.intValue();
    L252:
        if (r162 <= 0) goto L258;
        r56.g = 0;
        if (r54 == null) goto L256;
        int r163 = r54.intValue();
    L257:
        r56.c0 = r163;
        goto L259
    L256:
        r163 = 0;
        goto L257
    L258:
        r56.g = 0;
        r56.c0 = 0;
        goto L259
    L251:
        r162 = 0;
        goto L252
    L236:
        if (r20.intValue() == 0) goto L240;
        r122 = r20;
        if (Intrinsics.areEqual(r122, r54) == true) goto L241;
        r123 = true;
    L233:
        r54 = null;
        goto L234
    L226:
        if (r51.n() != true) goto L228;
        r52 = true;
        goto L229
    L218:
        if (r44 == null) goto L220;
        r50 = r44.a;
    L221:
        if (r50 != null) goto L223;
        r50 = r111;
        goto L223
    L220:
        r50 = null;
    L214:
        r49 = false;
    L213:
        r211 = r37;
        r212 = r40;
        r310 = r114;
        r210 = r113;
        goto L214
    L205:
        r121 = null;
        goto L207
    L199:
        r47 = null;
        goto L200
    L195:
        r46 = null;
        goto L197
    L202:
        r1 = r1;
        r47 = r45;
        goto L203
    L188:
        r45 = null;
        goto L189
    L184:
        r120 = null;
        goto L186
    L181:
        r119 = null;
        goto L182
    L177:
        r116 = null;
        goto L178
    L173:
        r44 = null;
        goto L174
    L169:
        r42 = r28;
        goto L170
    L163:
        if (r37.Sx() == false) goto L165;
        r40 = true;
        goto L166
    L158:
        if (r38.Da() != true) goto L160;
        r39 = true;
    L148:
        r35 = true;
    L139:
        r31 = r111;
        goto L140
    L147:
        r31 = r111;
        goto L148
    L71:
        r23 = null;
        goto L72
    L67:
        r22 = null;
        goto L69
    L81:
        r24 = "<this>";
        ContentScene r164 = ContentScene.COMPLEX_ASK_USER;
        if (Intrinsics.areEqual(r0, r164.getStr()) == false) goto L103;
        Map r165 = r1.Q;
        if (r165 == null) goto L86;
        Object r166 = r165.get("data");
    L87:
        Map r167 = r1.Q;
        if (r167 == null) goto L90;
        Object r168 = r167.get("data");
    L92:
        if ((r168 instanceof ComplexEvent) == false) goto L94;
        ComplexEvent r169 = (ComplexEvent) r168;
    L95:
        r28 = r4;
        FLogger.a.i("ChatClickTalkComponent", "realStart from autoMic by " + r0 + " with data " + r169 + ", temp = " + r166);
        if (r169 == null) goto L132;
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r170 = IObricAutoMicService.a.a();
        if (r170 == null) goto L132;
        Intrinsics.checkNotNullParameter(r164, "scene");
        String r171 = r169.a();
        if (r171 != null) goto L102;
        r171 = r111;
    L102:
        com.obric.assistant.voice.a r172 = new com.obric.assistant.voice.a(r164, r171);
        r172.g = r169;
        r170.m(r16, r172);
        goto L132
    L94:
        r169 = null;
        goto L95
    L90:
        r168 = null;
        goto L92
    L86:
        r166 = null;
        goto L87
    L103:
        r28 = r4;
        ContentScene r173 = ContentScene.PRIORITY_NOTIFICATION;
        if (Intrinsics.areEqual(r0, r173.getStr()) == false) goto L116;
        Map r174 = r1.Q;
        if (r174 == null) goto L108;
        Object r175 = r174.get("data");
    L110:
        if ((r175 instanceof AppEvent) == false) goto L112;
        AppEvent r176 = (AppEvent) r175;
    L113:
        FLogger.a.i("ChatClickTalkComponent", "realStart from autoMic by " + r0 + " with data " + r176);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r177 = IObricAutoMicService.a.a();
        if (r177 == null) goto L132;
        r177.m(r16, com.obric.assistant.voice.b.a(r173, r176));
        goto L132
    L112:
        r176 = null;
        goto L113
    L108:
        r175 = null;
        goto L110
    L116:
        ContentScene r178 = ContentScene.AI_ACTIVE_ASK;
        if (Intrinsics.areEqual(r0, r178.getStr()) == false) goto L129;
        Map r179 = r1.Q;
        if (r179 == null) goto L121;
        Object r180 = r179.get("data");
    L123:
        if ((r180 instanceof AppEvent) == false) goto L125;
        AppEvent r181 = (AppEvent) r180;
    L126:
        FLogger.a.i("ChatClickTalkComponent", "realStart from autoMic by " + r0 + " with data " + r181);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r182 = IObricAutoMicService.a.a();
        if (r182 == null) goto L132;
        r182.m(r16, com.obric.assistant.voice.b.a(r178, r181));
        goto L132
    L125:
        r181 = null;
        goto L126
    L121:
        r180 = null;
        goto L123
    L129:
        Intrinsics.areEqual(r0, ContentScene.UNKNOWN.getStr());
        goto L132
    L59:
        r0 = null;
        goto L60
    L55:
        r18 = null;
        goto L57
    L130:
        r28 = r4;
        r112 = r5;
        r20 = r6;
        r110 = r7;
        r24 = "<this>";
        r111 = "";
        goto L132
    L29:
        if (r1.P != 0) goto L38;
        FLogger.a.i("ChatClickTalkComponent", "recoverInputArea clear draft and text without switching input status");
        p1 r183 = (p1) r1.r.getValue();
        if (r183 == null) goto L35;
        j1 r184 = r183.Y3();
        if (r184 == null) goto L35;
        r184.q();
    L35:
        ICoreInputAbility r185 = (ICoreInputAbility) r1.s.getValue();
        if (r185 == null) goto L38;
        r185.p80(false);
    L38:
        va8.o r186 = (va8.o) r1.t.getValue();
        if (r186 == null) goto L47;
        r186.ra();
        goto L47
    L23:
        if (r10.isWindowMode() != true) goto L25;
        r11 = true;
        goto L27
    L16:
        r13 = null;
        goto L17
    L11:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("asr_record_ready"), r3) == false) goto L13;
        r9 = r3;
        goto L14
    }
}
