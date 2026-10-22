package com.obric.audio.continuous_talk.session.impl;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IAudioService;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl$start$job$1", f = "ObricContTalkMgrImpl.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContTalkMgrImpl$start$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $callId;
    final /* synthetic */ de8.c $chatArgumentData;
    final /* synthetic */ String $convId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $llmModelName;
    final /* synthetic */ RealtimeCallParam.l $oneshotParams;
    final /* synthetic */ String $personalCtx;
    final /* synthetic */ Integer $sourceType;
    final /* synthetic */ String $taskId;
    final /* synthetic */ by7.e $traceNode;
    final /* synthetic */ SpeakerVoice $voiceType;
    final /* synthetic */ Integer $vuiId;
    final /* synthetic */ Integer $wakeupId;
    int label;
    final /* synthetic */ ObricContTalkMgrImpl this$0;

    public ObricContTalkMgrImpl$start$job$1(ObricContTalkMgrImpl r4, String r5, String r6, Integer r7, Integer r8, Integer r9, String r10, String r11, SpeakerVoice r12, de8.c r13, by7.e r14, String r15, String r16, String r17, RealtimeCallParam.l r18, Continuation<? super ObricContTalkMgrImpl$start$job$1> r19) {
        this.this$0 = r4;
        this.$callId = r5;
        this.$taskId = r6;
        this.$vuiId = r7;
        this.$wakeupId = r8;
        this.$sourceType = r9;
        this.$convId = r10;
        this.$botId = r11;
        this.$voiceType = r12;
        this.$chatArgumentData = r13;
        this.$traceNode = r14;
        this.$enterMethod = r15;
        this.$llmModelName = r16;
        this.$personalCtx = r17;
        this.$oneshotParams = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
        return new ObricContTalkMgrImpl$start$job$1(this.this$0, this.$callId, this.$taskId, this.$vuiId, this.$wakeupId, this.$sourceType, this.$convId, this.$botId, this.$voiceType, this.$chatArgumentData, this.$traceNode, this.$enterMethod, this.$llmModelName, this.$personalCtx, this.$oneshotParams, r21);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r48) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r48);
    L11:
        this.this$0.W(true);
        ObricContTalkMgrImpl r3 = this.this$0;
        if (r3.z == false) goto L274;
        com.larus.audio.call.util.e.a.w(r3.v, "silent audio player already running");
    L23:
        if (this.this$0.w.get() == 1) goto L26;
        this.this$0.W(false);
        this.this$0.X();
        return Unit.INSTANCE;
    L26:
        ObricContTalkMgrImpl r1 = this.this$0;
        Lazy r6 = p.a;
        String r7 = this.$callId;
        String r8 = this.$taskId;
        Integer r9 = this.$vuiId;
        Integer r10 = this.$wakeupId;
        Integer r11 = this.$sourceType;
        String r12 = this.$convId;
        String r13 = this.$botId;
        SpeakerVoice r14 = this.$voiceType;
        de8.c r15 = this.$chatArgumentData;
        by7.e r16 = this.$traceNode;
        String r4 = this.$enterMethod;
        String r5 = this.$llmModelName;
        String r17 = this.$personalCtx;
        RealtimeCallParam.l r18 = this.$oneshotParams;
        Intrinsics.checkNotNullParameter(r7, "callId");
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Intrinsics.checkNotNullParameter(r12, "convId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r15, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r18, "oneshotParams");
        IAudioService r19 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r19 == null) goto L29;
        String r20 = r19.x0("doubao_phone");
    L31:
        if (r20 != null) goto L33;
        r20 = "";
    L33:
        if (r16 == null) goto L35;
        HashMap r110 = by7.h.a(r16).getParams();
    L36:
        if (r110 == null) goto L38;
        Object r21 = r110.get("current_page");
    L40:
        if ((r21 instanceof String) == false) goto L42;
        String r22 = (String) r21;
    L43:
        if (r22 != null) goto L46;
        r22 = r4;
    L46:
        if (Intrinsics.areEqual(r22, "chat") == false) goto L56;
        if (r110 == null) goto L49;
        Object r23 = r110.get("previous_page");
    L51:
        if ((r23 instanceof String) == false) goto L53;
        r22 = (String) r23;
    L54:
        if (r22 != null) goto L57;
        r22 = r4;
    L57:
        boolean r111 = p.b(r9, r10);
        AudioServiceDelegate r112 = AudioServiceDelegate.a;
        String r24 = r22;
        boolean r25 = r112.e0();
        RealtimeCallParam r113 = new RealtimeCallParam();
        r113.e = r7;
        if (r5 != null) goto L60;
        r5 = r4;
    L60:
        r113.i = r5;
        r113.u = 1;
        r113.k.B = true;
        if (r9 == null) goto L63;
        int r26 = r9.intValue();
    L66:
        r113.g = r26;
        if (r10 == null) goto L69;
        int r27 = r10.intValue();
    L70:
        r113.c0 = r27;
        e0 r28 = new e0();
        if (r11 == null) goto L73;
        ouc.j.b(r28, "obric_click_source_type", Integer.valueOf(r11.intValue()));
    L73:
        if (r25 == false) goto L76;
        if (r111 == false) goto L76;
        int r29 = 1;
    L77:
        ouc.j.b(r28, "is_dora_vui_wakeup", Integer.valueOf(r29));
        d0 r30 = r28.a();
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r113.r = r30;
        FLogger r31 = FLogger.a;
        r31.i("ObricContTalkUtils", "createCallParam isDoraVuiWakeup=" + r111);
        boolean r32 = r18.a;
        if (r32 == false) goto L81;
        if (r25 == true) goto L81;
        boolean r33 = true;
    L82:
        r31.i("ObricContTalkUtils", "createCallParam oneshot, isDoraWakeUp=" + r25 + ", effectiveOneshotEnable=" + r32 + ", enableBackTraceForOneshot=" + r33 + ", keyword=" + r18.b + ", offset=" + r18.c);
        if (r32 == false) goto L85;
        String r34 = r18.b;
    L86:
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r113.f = r34;
        r113.k.w = r32;
        String r35 = r18.b;
        long r36 = r18.c;
        boolean r114 = r18.d;
        Intrinsics.checkNotNullParameter(r35, "keyword");
        r113.M = new RealtimeCallParam.l(r32, r35, r36, r114);
        ObricOneshotDelegate r37 = ObricOneshotDelegate.b;
        long r38 = r37.h();
        long r210 = r37.d();
        if (r33 == true) goto L89;
    L107:
        RealtimeCallParam.g r39 = null;
    L108:
        r113.N = r39;
        RealtimeCallParam.h r40 = r113.k;
        r40.getClass();
        Intrinsics.checkNotNullParameter("doubao_phone", "<set-?>");
        r40.z = "doubao_phone";
        r113.B = new RealtimeCallParam.m(r20);
        RealtimeCallParam.h r41 = r113.k;
        r41.getClass();
        Intrinsics.checkNotNullParameter("QwsgN3QXFsz4ttIT", "<set-?>");
        r41.b = "QwsgN3QXFsz4ttIT";
        r113.b = true;
        AudioSessionType r42 = AudioSessionType.RTC;
        Intrinsics.checkNotNullParameter(r42, "<set-?>");
        r113.s = r42;
        RealtimeCallParam.h r43 = r113.k;
        Integer r44 = Integer.valueOf(r113.g);
        String r45 = r112.d(r43.b);
        Intrinsics.checkNotNullParameter(r45, "<set-?>");
        r43.a = r45;
        String r115 = m58.h.b(true, null, 6);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r43.d = r115;
        AccountService r46 = AccountService.a;
        String r47 = r46.getUserId();
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        r43.f = r47;
        com.larus.platform.service.o r49 = com.larus.platform.service.o.a;
        String r116 = r49.getDeviceId();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r43.g = r116;
        AppHost.Companion r117 = AppHost.a;
        String r50 = r117.getVersionName();
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        r43.h = r50;
        r43.i = r117.getVersionCode();
        Intrinsics.checkNotNullParameter("assistant_half_duplex", "<set-?>");
        r43.o = "assistant_half_duplex";
        r43.j = r117.getUpdateVersionCode();
        z2 r211 = z2.a;
        lq9.e r310 = r211.V2().getData();
        if (r310 == null) goto L111;
        int r118 = r310.c();
    L112:
        lq9.e r212 = r211.V2().getData();
        if (r212 == null) goto L118;
        int[] r213 = r212.b();
        if (r213 == null) goto L118;
        boolean r51 = false;
        int[] r52 = r213;
    L119:
        RealtimeCallParam.f r53 = new RealtimeCallParam.f(new RealtimeCallParam.e(r51, r118, r52));
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r43.l = r53;
        if (c78.a.a().length() <= 0) goto L122;
        int r54 = 1;
    L123:
        r43.m = r54;
        LocalSubConvHelper r55 = LocalSubConvHelper.a;
        String r56 = (String) LocalSubConvHelper.d(r12).get("sub_conv_firstmet_type");
        if (r56 != null) goto L126;
        r56 = r4;
    L126:
        Intrinsics.checkNotNullParameter(r56, "<set-?>");
        r43.q = r56;
        String r57 = (String) LocalSubConvHelper.d(r12).get("sub_conv_source_message");
        if (r57 != null) goto L129;
        r57 = r4;
    L129:
        Intrinsics.checkNotNullParameter(r57, "<set-?>");
        r43.r = r57;
        Intrinsics.checkNotNullParameter("assistant_scene_mode_click_talk", "<set-?>");
        r43.t = "assistant_scene_mode_click_talk";
        r43.n = 2;
        r43.u = r44;
        if (r112.isDoraConnected() == false) goto L133;
        if (r111 == false) goto L133;
        r43.n = 6;
        r43.s = 1;
    L133:
        RealtimeCallParam.d r58 = r113.l;
        r58.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r58.a = r8;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r58.c = r12;
        ISettingRepoService r59 = p.a();
        if (r59 == null) goto L136;
        String r60 = r59.Z(null);
    L137:
        if (r60 != null) goto L139;
        r60 = r4;
    L139:
        Intrinsics.checkNotNullParameter(r60, "<set-?>");
        r58.p = r60;
        ISettingRepoService r61 = p.a();
        if (r61 == null) goto L142;
        String r62 = r61.S0();
    L143:
        if (r62 != null) goto L145;
        r62 = r4;
    L145:
        Intrinsics.checkNotNullParameter(r62, "<set-?>");
        r58.d = r62;
        JSONObject r63 = new JSONObject();
        r63.put("uid", r46.getUserId());
        r63.put("did", r49.getDeviceId());
        r63.put("app_version", String.valueOf(r117.getUpdateVersionCode()));
        ISettingRepoService r64 = p.a();
        if (r64 == null) goto L148;
        String r65 = r64.Q0();
    L149:
        r63.put("speech_language", r65);
        ISettingRepoService r66 = p.a();
        if (r66 == null) goto L152;
        String r67 = r66.S0();
    L153:
        r63.put("asr_language", r67);
        ISettingRepoService r68 = p.a();
        String r69 = null;
        if (r68 == null) goto L156;
        String r70 = r68.Z(null);
    L157:
        r63.put("model", r70);
        r63.put("os", "Android");
        ISettingRepoService r71 = p.a();
        if (r71 != null) goto L160;
    L162:
        int r72 = 0;
    L163:
        r63.put("dumpRate", r72);
        ISettingRepoService r73 = p.a();
        if (r73 == null) goto L166;
        Boolean r74 = Boolean.valueOf(r73.B());
    L167:
        r63.put("send_mq", r74);
        if (r17 != null) goto L170;
    L173:
        boolean r75 = true;
    L174:
        if (r75 == true) goto L176;
        r63.put("enable_update_nonstream_context", true);
    L176:
        r58.a(r63.toString());
        r58.h = 3;
        r58.m = c78.a.g.getBoolean("key_realtime_call_pre_query_enable", false);
        r58.t = true;
        Intrinsics.checkNotNullParameter("bigasr-acllm-release-grpc-1", "<set-?>");
        r58.u = "bigasr-acllm-release-grpc-1";
        if (r111 == false) goto L179;
        Intrinsics.checkNotNullParameter("speech_opus", "<set-?>");
        r58.g = "speech_opus";
    L180:
        RealtimeCallParam.p r76 = r113.o;
        r76.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r76.a = r8;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r76.h = r13;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r76.c = r12;
        r76.o = false;
        r76.p = true;
        if (r14 == null) goto L183;
        String r77 = r14.getStyleId();
    L184:
        if (r77 != null) goto L186;
        r77 = r4;
    L186:
        Intrinsics.checkNotNullParameter(r77, "<set-?>");
        r76.d = r77;
        if (r14 == null) goto L189;
        String r78 = r14.getName();
    L190:
        if (r78 != null) goto L192;
        r78 = r4;
    L192:
        Intrinsics.checkNotNullParameter(r78, "<set-?>");
        r76.g = r78;
        ObricRealtimeCallServiceDelegate r79 = ObricRealtimeCallServiceDelegate.b;
        r76.j = r79.e();
        if (r14 == null) goto L195;
        String r80 = r14.getId();
    L196:
        if (r80 != null) goto L198;
        r80 = r4;
    L198:
        Intrinsics.checkNotNullParameter(r80, "<set-?>");
        r76.f = r80;
        if (r14 == null) goto L201;
        String r81 = r14.getExtra();
    L202:
        if (r81 != null) goto L204;
        r81 = r4;
    L204:
        Intrinsics.checkNotNullParameter(r81, "<set-?>");
        r76.n = r81;
        if (r14 == null) goto L207;
        String r82 = r14.getAudioMetrics();
    L208:
        if (r82 != null) goto L210;
        r82 = r4;
    L210:
        Intrinsics.checkNotNullParameter(r82, "<set-?>");
        r76.t = r82;
        r76.u = r79.b();
        r76.v = r79.c();
        RealtimeCallParam.k r83 = r113.p;
        r83.getClass();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r83.b = r24;
        Intrinsics.checkNotNullParameter("chat", "<set-?>");
        r83.c = "chat";
        String r84 = r22;
        Intrinsics.checkNotNullParameter(r84, "<set-?>");
        r83.d = r84;
        RecommendFrom r85 = r15.d;
        if (r85 == null) goto L213;
        String r86 = r85.b;
    L214:
        r83.f = r86;
        boolean r87 = false;
        r83.g = IAIChatControlTraceService.a.g(1, 1, false);
        SearchMobParam r88 = r15.e;
        if (r88 == null) goto L217;
        String r311 = r88.a;
    L218:
        if (r88 == null) goto L220;
        String r410 = r88.b;
    L221:
        if (r88 == null) goto L223;
        String r411 = r88.c;
    L224:
        if (r88 == null) goto L226;
        String r412 = r88.e;
    L227:
        if (r88 == null) goto L229;
        String r413 = r88.f;
    L230:
        if (r88 == null) goto L232;
        r69 = r88.g;
    L232:
        r83.h = new RealtimeCallParam.n(r311, r410, r411, r412, r413, r69, 8);
        r83.i = r4;
        r83.k = "";
        String r89 = r15.e();
        if (r89 != null) goto L235;
        r89 = "";
    L235:
        r83.l = r89;
        String r90 = r15.d();
        if (r90 != null) goto L238;
        r90 = "";
    L238:
        r83.m = r90;
        r83.n = "0";
        ObricAssistantForAudioDelegate r91 = ObricAssistantForAudioDelegate.b;
        r83.r = r91.X4();
        r83.s = r91.P4();
        String r92 = r112.o(r113.k.b);
        if (r92 != null) goto L241;
        r92 = "";
    L241:
        r113.D = r92;
        if (r33 == false) goto L244;
        int r93 = ((Number) r37.f("session")).intValue();
    L245:
        r113.h = r93;
        if (r25 == false) goto L249;
        if (r111 == false) goto L249;
        r113.a(AvAudioKitMode.MIX_SPEECH_BIZ);
        Intrinsics.checkNotNullParameter("dora", "<set-?>");
        r113.J = "dora";
    L249:
        r31.i("ObricContTalkUtils", "VoiceAuthResult init taskId = " + r113.l.a);
        boolean r94 = t1.a.D1();
        String r95 = r113.l.o;
        if (r95.length() != 0) goto L252;
        boolean r96 = true;
    L254:
        if (r96 == false) goto L256;
        RealtimeCallParam.d r97 = r113.l;
        JSONObject r98 = new JSONObject();
        r98.put("enable_speaker_verify", r94);
        r98.put("dora_engine_version", ObricEnrollInteropDelegate.b.A());
        r97.a(r98.toString());
    L257:
        r31.i("ObricContTalkUtils", "initVoiceAuthenticationParams enable_speaker_verify: " + r94 + " and asrConfig.extra: " + r113.l.o);
        String r99 = r113.l.o;
        if (r99.length() != 0) goto L261;
        r87 = true;
    L261:
        if (r87 == false) goto L263;
        RealtimeCallParam.d r100 = r113.l;
        JSONObject r101 = new JSONObject();
        r101.put("enable_third_party_accessory_connection", ObricChatSPIServiceDelegate.b.a());
        r100.a(r101.toString());
    L264:
        JSONObject r102 = new JSONObject();
        if (r32 == false) goto L267;
        RealtimeCallParam.l r103 = r18;
        long r104 = r103.c;
    L268:
        r102.put("wakeup_audio_duration_ms", r104);
        r102.put("wakeup_audio_upload", r32);
        if (r32 == false) goto L271;
        String r105 = r103.b;
    L272:
        r102.put("wakeup_words", r105);
        r102.put("vui_id", r9);
        r102.put("is_near_speaking", r103.d);
        d0 r106 = com.larus.audio.call.util.k.b(r102);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r113.q = r106;
        LLMCallController.S(r1, r113);
        return Unit.INSTANCE;
    L271:
        r105 = "";
        goto L272
    L267:
        r103 = r18;
        r104 = 0;
        goto L268
    L263:
        JSONObject r107 = new JSONObject(r99);
        r107.put("enable_third_party_accessory_connection", ObricChatSPIServiceDelegate.b.a());
        r113.l.a(r107.toString());
        goto L264
    L256:
        JSONObject r108 = new JSONObject(r95);
        r108.put("enable_speaker_verify", r94);
        r108.put("dora_engine_version", ObricEnrollInteropDelegate.b.A());
        r113.l.a(r108.toString());
        goto L257
    L252:
        r96 = false;
        goto L254
    L244:
        r93 = -1;
        goto L245
    L229:
        r413 = null;
        goto L230
    L226:
        r412 = null;
        goto L227
    L223:
        r411 = null;
        goto L224
    L220:
        r410 = null;
        goto L221
    L217:
        r311 = null;
        goto L218
    L213:
        r86 = null;
        goto L214
    L207:
        r82 = null;
        goto L208
    L201:
        r81 = null;
        goto L202
    L195:
        r80 = null;
        goto L196
    L189:
        r78 = null;
        goto L190
    L183:
        r77 = null;
        goto L184
    L179:
        r58.f = 2;
        goto L180
    L170:
        if (r17.length() == 0) goto L173;
        r75 = false;
        goto L174
    L166:
        r74 = null;
        goto L167
    L160:
        if (r71.B() != true) goto L162;
        r72 = 1;
        goto L163
    L156:
        r70 = null;
        goto L157
    L152:
        r67 = null;
        goto L153
    L148:
        r65 = null;
        goto L149
    L142:
        r62 = null;
        goto L143
    L136:
        r60 = null;
        goto L137
    L122:
        r54 = 0;
    L118:
        r52 = new int[]{300, 600, 900, 1200, 1500};
        r51 = false;
        goto L119
    L111:
        r118 = 6000;
        goto L112
    L89:
        if (r38 <= 0) goto L91;
    L92:
        Long r109 = Long.valueOf(r38);
        if (r109.longValue() <= 0) goto L95;
        boolean r119 = true;
    L96:
        if (r119 == true) goto L99;
        r109 = null;
    L99:
        Long r120 = Long.valueOf(r210);
        if (r120.longValue() <= 0) goto L102;
        boolean r121 = true;
    L103:
        if (r121 == true) goto L106;
        r120 = null;
    L106:
        r39 = new RealtimeCallParam.g(r109, r120);
        goto L108
    L102:
        r121 = false;
        goto L103
    L95:
        r119 = false;
        goto L96
    L91:
        if (r210 <= 0) goto L107;
    L85:
        r34 = r4;
    L81:
        r33 = false;
    L76:
        r29 = 0;
        goto L77
    L69:
        r27 = 0;
        goto L70
    L63:
        if (r10 == null) goto L65;
        r26 = r10.intValue();
        goto L66
    L65:
        r26 = 0;
        goto L66
    L53:
        r22 = null;
        goto L54
    L49:
        r23 = null;
        goto L51
    L56:
        r22 = r22;
        goto L57
    L42:
        r22 = null;
        goto L43
    L38:
        r21 = null;
        goto L40
    L35:
        r110 = null;
        goto L36
    L29:
        r20 = null;
        goto L31
    L274:
        q r122 = new q();     // Catch: Exception -> L20
        r122.a();     // Catch: Exception -> L20
        r3.x = r122;
        r3.z = true;
        com.larus.audio.call.util.e.a.i(r3.v, "silent audio player started");
        CoroutineScope r123 = (CoroutineScope) ((LLMCallController) r3).d.invoke();
        if (r123 == null) goto L18;
        Job r124 = BuildersKt.launch$default(r123, Dispatchers.getIO(), null, new ObricContTalkMgrImpl$startSilentAudioPlayer$1(r3, null), 2, null);
    L19:
        r3.y = r124;
        goto L23
    L18:
        r124 = null;
    L20:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(r3.v, "startSilentAudioPlayer failed: " + e);
        r3.X();
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r48);
        AudioServiceDelegate r125 = AudioServiceDelegate.a;
        this.label = 1;
        if (r125.K("ObricContTalk", this) != r0) goto L11;
        return r0;
    }
}
