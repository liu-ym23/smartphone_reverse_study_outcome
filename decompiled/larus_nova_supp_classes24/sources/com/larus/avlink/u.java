package com.larus.avlink;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IAudioService;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.utils.AvBizType;
import com.larus.avlink.dora.DoraMode;
import com.larus.avlink.plugins.DoraNotificationSummaryPlugin;
import com.larus.avlink.plugins.p4;
import com.larus.avlink.plugins.t2;
import com.larus.avlink.plugins.x2;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.ui.RealtimeCallHelperKt;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class u implements w88.t {
    public final String a;
    public final BotModel b;
    public final int c;
    public final Integer d;
    public final Lazy e;
    public final String f;
    public RealtimeCallParam g;
    public final CoroutineScope h;
    public final Lazy i;
    public final b78.c j;
    public final Lazy k;
    public final b l;

    public static final class a {
    }

    public static final class b implements j0.a {
        public final /* synthetic */ u a;

        @Override // com.larus.avlink.j0.a
        public final void b() {
        }

        @Override // com.larus.avlink.j0.a
        public final void a() {
            LLMCallController.D(this.a.o(), this.a.g, false, 6);
        }

        public b(DoraRealtimeCallTaskNew r1) {
            this.a = r1;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            n1.b("DoraRealtimeCallTaskNew", "ioScope error: " + r3);
        }
    }

    static {
    }

    public final void b() {
        n1.d("DoraRealtimeCallTaskNew", "interrupt call");
        LLMCallController.D(o(), this.g, false, 6);
    }

    public final o o() {
        return (o) this.k.getValue();
    }

    public final com.larus.avlink.rtc.a p() {
        return (com.larus.avlink.rtc.a) this.i.getValue();
    }

    public final void a() {
        o().Y();
    }

    public final void j() {
        final o r0 = o();
        n1.d(r0.A(), "try stopWake call: hash:" + r0.hashCode());
        r0.Z();
        r0.V(0).invokeOnCompletion(new f(r0));
    }

    public final int c() {
        return this.c;
    }

    public final void f(com.larus.avlink.impl.a r2) {
        o().A = r2;
    }

    public final void g(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        o().i0(r2);
    }

    public final void h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (Intrinsics.areEqual(r4, "FaceToFace") == false) goto L5;
    L8:
        RealtimeCallParam.j r1 = this.g.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.i = r4;
        o r2 = o();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "scene");
        LLMCallController.w(r2, Reflection.getOrCreateKotlinClass(p4.class)).T0(r4);
        return;
    L5:
        if (Intrinsics.areEqual(r4, "ConferenceRoom") == true) goto L8;
        n1.d("DoraRealtimeCallTaskNew", "updateTranslateSceneSwitch unsupported scene: ".concat(r4));
    }

    public final void k(x88.a r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        o r1 = o();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "param");
        LLMCallController.w(r1, Reflection.getOrCreateKotlinClass(p4.class)).K2(r3);
    }

    public final void l(Integer r4) {
        n1.d("DoraRealtimeCallTaskNew", "DoraRealtimeCallTaskNew stop, state: " + r4);
        o r0 = o();
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        r0.d0(r5);
        q68.c<j0.a> r6 = j0.a;
        b r7 = this.l;
        Intrinsics.checkNotNullParameter(r7, "listener");
        q68.c<j0.a> r1 = j0.a;
        r1.a.remove(r7);
        n1.d("DoraIMStateObserver", "removeIMStateListener: " + r7 + ", size: " + r1.a.size());
        return;
    L5:
        r5 = -1;
        goto L6
    }

    public final void m(Function1<? super z98.f, Unit> r2) {
        if (r2 == null) goto L5;
        o().X().m(r2);
        return;
    }

    public final void d(boolean r2, int r3, int r4) {
        o().f0(r2, r3, r4);
    }

    public u(String r1, BotModel r2, int r3, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = LazyKt.lazy(new q());
        int r5 = bytekn.foundation.utils.h.a;
        this.f = UUID.randomUUID().toString().toString();
        this.g = new RealtimeCallParam();
        this.h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new c(CoroutineExceptionHandler.Key)));
        final DoraRealtimeCallTaskNew r6 = (DoraRealtimeCallTaskNew) this;
        this.i = LazyKt.lazy(new r(r6));
        if (p().d == false) goto L6;
        b78.c r7 = new b78.d(AvBizType.DORA);
    L12:
        this.j = r7;
        this.k = LazyKt.lazy(new s(r6));
        this.l = new b(r6);
        return;
    L6:
        if (p().a == false) goto L9;
        r7 = new b78.e(AvBizType.DORA);
        goto L12
    L9:
        if (p().b == false) goto L11;
        r7 = new b78.f(AvBizType.DORA);
        goto L12
    L11:
        r7 = new b78.h(AvBizType.DORA);
        goto L12
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final void n(String r84, int r85, int r86, String r87, Integer r88, long r89, String r91) {
        Intrinsics.checkNotNullParameter(r84, "requestType");
        Intrinsics.checkNotNullParameter(r87, "keyword");
        n1.d("DoraRealtimeCallTaskNew", "DoraRealtimeCallTaskNew start， bizMode: " + r88);
        q68.c<j0.a> r0 = j0.a;
        b r1 = this.l;
        Intrinsics.checkNotNullParameter(r1, "listener");
        q68.c<j0.a> r5 = j0.a;
        if (r5.a.contains(r1) == true) goto L5;
        r5.a.add(r1);
    L5:
        n1.d("DoraIMStateObserver", "addIMStateListener: " + r1 + ", size: " + r5.a.size());
        String r2 = this.a;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L22;
        AuthModelDelegate r4 = AuthModelDelegate.b;
        wc9.e r6 = (wc9.e) r4.y().getValue();
        if (r6 == null) goto L17;
        String r7 = r6.a;
        if (r7 == null) goto L17;
    L21:
        n1.d("DoraRealtimeCallTaskNew", "getFallbackConversationId: " + r7);
    L24:
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        String r8 = (String) this.e.getValue();
        BotModel r9 = this.b;
        if (r9 != null) goto L29;
        String r10 = DoraConfig.g();
        n1.d("DoraRealtimeCallTaskNew", "getFallbackBotId: " + r10);
        r9 = new BotModel(r10, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, LKUIToast.DURATION_MAX, null);
    L29:
        String r11 = this.f;
        new LinkedHashMap();
        new LinkedHashMap();
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L36;
        DeviceService r13 = r12.device();
        if (r13 == null) goto L36;
        if (r13.M() != true) goto L36;
        boolean r14 = true;
    L37:
        if (r14 == true) goto L47;
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 != null) goto L41;
    L43:
        boolean r16 = false;
    L44:
        if (r16 == false) goto L47;
        boolean r17 = false;
    L48:
        boolean r19 = p().b;
        boolean r110 = p().c;
        boolean r111 = p().a;
        boolean r112 = p().d;
        Integer r113 = Integer.valueOf(r86);
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "localCallId");
        Intrinsics.checkNotNullParameter(r84, "requestType");
        Intrinsics.checkNotNullParameter(r9, "botModel");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "localCallId");
        Intrinsics.checkNotNullParameter(r84, "requestType");
        Intrinsics.checkNotNullParameter(r9, "botModel");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        g0 r20 = g0.a;
        if (StringsKt.contains$default(r7, "local", false, 2, null) == false) goto L51;
        r7 = "";
    L51:
        if (r112 == false) goto L53;
        AudioSessionType r21 = AudioSessionType.MMT;
    L58:
        n1.d("DoraRealtimeCallParamBuilder", "avSessionType: " + r21);
        RealtimeCallParam r22 = new RealtimeCallParam();
        r22.e = r8;
        r22.c = r89;
        SpeakerVoice r23 = r9.getVoiceType();
        if (r23 == null) goto L62;
        String r24 = r23.getStyleId();
        if (r24 == null) goto L62;
    L68:
        r22.i = r24;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r84, "requestType");
        JSONObject r25 = new JSONObject();
        DeviceService r26 = g0.b();
        if (r26 != null) goto L71;
    L73:
        boolean r27 = false;
    L75:
        if (r27 == false) goto L87;
        IDoraService r29 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r29 == null) goto L79;
        Integer r30 = Integer.valueOf(r29.K());
    L80:
        if (r30 != null) goto L82;
        boolean r210 = r111;
    L85:
        boolean r114 = false;
    L86:
        r25.put("enable_vui_vad", r114);
        FLogger.a.i("DoraRealtimeCallParamBuilder", "vpuEnable: " + r30);
    L92:
        boolean r115 = true;
    L93:
        DeviceService r31 = g0.b();
        if (r31 != null) goto L96;
    L98:
        boolean r32 = false;
    L99:
        if (r32 == false) goto L139;
        IDoraService r33 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r33 == null) goto L107;
        DeviceService r34 = r33.device();
        if (r34 == null) goto L107;
        if (r34.f0() != true) goto L107;
        boolean r35 = true;
    L108:
        if (r35 == false) goto L139;
        long r116 = System.currentTimeMillis();
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L120
        boolean r211 = r112;
        BotModel r212 = r9;
        Object r37 = Result.constructor-impl(com.larus.platform.service.c1.a.b("voice_vad_model.model", "com_flow_dora_voice_vad_model", true));     // Catch: Throwable -> L116
    L123:
        Throwable r38 = Result.exceptionOrNull-impl(r37);
        if (r38 == null) goto L127;
        FLogger.a.e("DoraRealtimeCallParamBuilder", "load vad model failed: " + r38.getMessage());
        r37 = "";
    L127:
        String r39 = (String) r37;
        long r117 = System.currentTimeMillis() - r116;
        FLogger r40 = FLogger.a;
        r40.i("DoraRealtimeCallParamBuilder", "vad model path: " + r39 + ", cost:" + r117 + "ms");
        if (r39 != null) goto L130;
    L133:
        boolean r118 = true;
    L134:
        if (r118 == false) goto L136;
        JSONObject r119 = null;
    L137:
        if (r119 == null) goto L140;
        String r41 = new JSONObject().put("flute_vad_config", r119).toString();
        r25.put("flute_vad_config", r41);
        r40.i("DoraRealtimeCallParamBuilder", "put vad config to sessionExtra: " + r41);
    L140:
        boolean r42 = t2.f;
        Map r43 = t2.a.a();
        if (r43 == null) goto L146;
        Iterator r44 = r43.entrySet().iterator();
    L144:
        if (r44.hasNext() == false) goto L146;
        Map.Entry r45 = (Map.Entry) r44.next();
        r25.put((String) r45.getKey(), r45.getValue());
    L146:
        ouc.d0 r46 = com.larus.voicecall.impl.util.d.c(r25);
        Intrinsics.checkNotNullParameter(r46, "<set-?>");
        r22.q = r46;
        Intrinsics.checkNotNullParameter("dora", "<set-?>");
        r22.J = "dora";
        DeviceService r47 = g0.b();
        if (r47 == null) goto L150;
        String r48 = r47.v();
        if (r48 == null) goto L150;
    L151:
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r22.K = r48;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r22.s = r21;
        RealtimeCallParam.h r49 = r22.k;
        Intrinsics.checkNotNullParameter(r84, "requestType");
        IDoraService r50 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r50 == null) goto L156;
        SessionService r51 = r50.d();
        if (r51 == null) goto L156;
        String r52 = r51.g(r84);
    L157:
        r49.getClass();
        Intrinsics.checkNotNullParameter(r52, "<set-?>");
        r49.b = r52;
        Intrinsics.checkNotNullParameter(r52, "appKey");
        Intrinsics.checkNotNullParameter(r21, "sessionType");
        if (r21 != AudioSessionType.QUIC) goto L160;
        String r53 = AudioServiceDelegate.a.M(r52);
    L161:
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r49.a = r53;
        x58.a r54 = m58.h.a;
        JSONObject r55 = new JSONObject();
        FLogger r120 = FLogger.a;
        StringBuilder r121 = new StringBuilder("buildParam isMinorMode=");
        AccountService r122 = AccountService.a;
        Integer r810 = r113;
        r121.append(r122.a());
        r120.i("DoraRealtimeCallParamBuilder", r121.toString());
        if (r122.a() == false) goto L164;
        r55.put("minor-mode", "1");
    L164:
        IFlowSdkDepend r123 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r123 == null) goto L168;
        String r124 = r123.F0();
        if (r124 == null) goto L168;
    L170:
        if (TextUtils.isEmpty(r124) == true) goto L172;
        r55.put("feature_key", r124);
    L172:
        Unit r125 = Unit.INSTANCE;
        String r56 = m58.h.b(r19, r55, 2);
        Intrinsics.checkNotNullParameter(r56, "<set-?>");
        r49.d = r56;
        String r57 = r122.getUserId();
        Intrinsics.checkNotNullParameter(r57, "<set-?>");
        r49.f = r57;
        com.larus.platform.service.o r59 = com.larus.platform.service.o.a;
        String r126 = r59.getDeviceId();
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r49.g = r126;
        AppHost.Companion r127 = AppHost.a;
        String r128 = r127.getVersionName();
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r49.h = r128;
        DeviceService r129 = g0.b();
        if (r129 == null) goto L177;
        String r213 = "1";
        boolean r130 = true;
        if (r129.f() != true) goto L178;
        boolean r131 = true;
    L179:
        if (r131 == true) goto L197;
        DeviceService r132 = g0.b();
        if (r132 != null) goto L184;
    L186:
        boolean r133 = false;
    L187:
        if (r133 == false) goto L189;
        int r134 = 8;
    L198:
        r49.n = r134;
        Intrinsics.checkNotNullParameter(r84, "<set-?>");
        r49.o = r84;
        r49.s = r85;
        String r135 = ia8.n.c(r85);
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        r49.t = r135;
        r49.u = r810;
        r49.w = r17;
        String r60 = g0.d(r21);
        Intrinsics.checkNotNullParameter(r60, "<set-?>");
        r49.z = r60;
        if (Intrinsics.areEqual(r49.t, DoraMode.DORA_RADIO_SINGLE_TURN.getValue()) == false) goto L205;
        int r61 = z98.h.a;
        r49.e = (int) ((((long) e10.P().f()) * 1000) + 32000);
        boolean r136 = g0.c(r84);
        lq9.e r137 = z2.a.V2().getData();
        if (r137 == null) goto L203;
        int r138 = r137.c();
    L204:
        e10 r310 = e10.a;
        boolean r811 = r19;
        RealtimeCallParam.f r62 = new RealtimeCallParam.f(new RealtimeCallParam.e(r136, r138, e10.P().b()));
        Intrinsics.checkNotNullParameter(r62, "<set-?>");
        r49.l = r62;
        r49.v = true;
    L210:
        Intrinsics.checkNotNullParameter(r49, "config");
        Intrinsics.checkNotNullParameter(r84, "requestType");
        if (Intrinsics.areEqual(r84, "dora_si") == false) goto L227;
        DeviceService r63 = g0.b();
        if (r63 == null) goto L217;
        boolean r64 = true;
        if (r63.b0() != true) goto L218;
        boolean r65 = true;
    L219:
        if (r65 == false) goto L223;
        Keva r66 = DoraConfig.a;
        boolean r139 = r66.getBoolean("key_lite_first_enter_si", r64);
        if (r139 == false) goto L226;
        r66.storeBoolean("key_lite_first_enter_si", false);
    L226:
        r49.p = r139;
        goto L227
    L223:
        Keva r67 = DoraConfig.a;
        r139 = r67.getBoolean("key_g_first_enter_si", r64);
        if (r139 == false) goto L226;
        r67.storeBoolean("key_g_first_enter_si", false);
    L218:
        r65 = false;
        goto L219
    L217:
        r64 = true;
    L227:
        r49.k = z2.a.realtimeMaxAliveDuration();
        if (r85 != 1) goto L244;
        DeviceService r68 = g0.b();
        if (r68 != null) goto L232;
    L234:
        boolean r69 = false;
    L235:
        if (r69 == true) goto L243;
        DeviceService r70 = g0.b();
        if (r70 != null) goto L239;
    L241:
        boolean r71 = false;
    L242:
        if (r71 == false) goto L244;
    L239:
        if (r70.d0() != true) goto L241;
        r71 = true;
    L243:
        boolean r72 = true;
    L245:
        r49.B = r72;
        RealtimeCallParam.d r73 = r22.l;
        r73.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r73.a = r11;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r73.c = r7;
        ISettingRepoService r74 = zh8.a.c;
        String r140 = r74.Z(null);
        Intrinsics.checkNotNullParameter(r140, "<set-?>");
        r73.p = r140;
        String r75 = r74.S0();
        Intrinsics.checkNotNullParameter(r75, "<set-?>");
        r73.d = r75;
        Intrinsics.checkNotNullParameter("speech_opus", "<set-?>");
        r73.g = "speech_opus";
        n1.d("DoraRealtimeCallParamBuilder", "enable_sv_rejection is " + DoraConfig.e());
        JSONObject r141 = new JSONObject();
        r141.put("uid", r122.getUserId());
        r141.put("did", r59.getDeviceId());
        r141.put("app_version", String.valueOf(r127.getUpdateVersionCode()));
        g0.a.getClass();
        r141.put("speech_language", r74.Q0());
        r141.put("asr_language", r74.S0());
        r141.put("model", r74.Z(null));
        r141.put("os", "Android");
        DeviceService r76 = g0.b();
        if (r76 == null) goto L248;
        Object r77 = r76.s();
    L249:
        r141.put("dora_firmware_version", r77);
        DeviceService r79 = g0.b();
        if (r79 == null) goto L252;
        Object r80 = r79.l();
    L253:
        r141.put("dora_engine_version", r80);
        r141.put("dumpRate", r74.B() ? 1 : 0);
        r141.put("send_mq", r74.B());
        r141.put("enable_sv_rejection", DoraConfig.e());
        r73.a(r141.toString());
        if (v88.a.f(Integer.valueOf(r85)) == false) goto L256;
        int r81 = 1;
    L257:
        r73.h = r81;
        r73.m = true;
        IDoraService r82 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r82 != null) goto L260;
    L262:
        boolean r83 = false;
    L263:
        String r142 = "0";
        if (r83 == false) goto L266;
        String r90 = r213;
    L267:
        Intrinsics.checkNotNullParameter(r90, "<set-?>");
        r73.r = r90;
        RealtimeCallParam.p r92 = r22.o;
        r92.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r92.a = r11;
        String r93 = r212.getBotId();
        if (r93 != null) goto L270;
        r93 = "";
    L270:
        Intrinsics.checkNotNullParameter(r93, "<set-?>");
        r92.h = r93;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r92.c = r7;
        r92.o = false;
        r92.p = true;
        BotModel r94 = r212;
        Intrinsics.checkNotNullParameter(r94, "botModel");
        SpeakerVoice r95 = r94.getVoiceType();
        if (r95 == null) goto L273;
        String r96 = RealtimeCallHelperKt.a(r95);
    L274:
        if (r96 != null) goto L276;
    L279:
        boolean r97 = true;
    L280:
        if (r97 == false) goto L284;
        e10 r98 = e10.a;
        r96 = e10.f().a();
        if (r96 != null) goto L284;
        r96 = "";
    L284:
        Intrinsics.checkNotNullParameter(r96, "<set-?>");
        r92.d = r96;
        Intrinsics.checkNotNullParameter(r94, "botModel");
        SpeakerVoice r99 = r94.getVoiceType();
        if (r99 == null) goto L294;
        String r100 = r99.getExtra();
        if (r100 == null) goto L294;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L290
    L292:
        String r102 = r101.toString();
        if (r102 == null) goto L294;
    L295:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r92.n = r102;
        SpeakerVoice r103 = r94.getVoiceType();
        if (r103 == null) goto L298;
        String r104 = r103.getAudioMetrics();
    L299:
        if (r104 != null) goto L301;
        r104 = "";
    L301:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r92.t = r104;
        r92.u = ia8.e.c().b();
        r92.v = ia8.e.c().c();
        Pair r105 = com.larus.voicecall.impl.e.a();
        r92.l = ((Boolean) r105.getFirst()).booleanValue();
        r92.m = ((Number) r105.getSecond()).intValue();
        r92.w = false;
        RealtimeCallParam.o r106 = r22.m;
        r106.getClass();
        Intrinsics.checkNotNullParameter("speech_opus", "<set-?>");
        r106.a = "speech_opus";
        r106.c = 16000;
        r106.b = 80;
        r106.e = 32000;
        r106.d = 1;
        IDoraService r107 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r107 == null) goto L304;
        String r108 = r107.Q0();
    L305:
        r106.f = r108;
        IDoraService r109 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r109 == null) goto L308;
        String r143 = r109.z0();
    L309:
        r106.g = r143;
        RealtimeCallParam.j r144 = r22.n;
        Map r145 = g0.a(r144, r85, r84, r811, r211, r91);
        if (DoraConfig.f() == false) goto L312;
        String r146 = "ConferenceRoom";
    L313:
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        r144.i = r146;
        LinkedHashMap r147 = new LinkedHashMap();
        Map r148 = x2.a;
        IDoraService r149 = x2.c();
        if (r149 == null) goto L320;
        DeviceService r150 = r149.device();
        if (r150 == null) goto L320;
        String r151 = null;
        if (r150.o0(null) != true) goto L321;
        boolean r152 = true;
    L322:
        if (r152 == false) goto L324;
        String r153 = r213;
    L325:
        ouc.g0 r154 = ouc.k.c(r153);
        Intrinsics.checkNotNullParameter("support_noise_cancellation", "key");
        Intrinsics.checkNotNullParameter(r154, "element");
        ouc.i r155 = (ouc.i) r147.put("support_noise_cancellation", r154);
        String r156 = new ouc.d0(r147).toString();
        Map r157 = MapsKt.createMapBuilder();
        r157.put("is_new_user", r22.l.s);
        IDoraService r158 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r158 == null) goto L330;
        DeviceService r159 = r158.device();
        if (r159 == null) goto L330;
        String r160 = r159.m();
    L331:
        if (r160 != null) goto L333;
        r160 = "";
    L333:
        r157.put("dora_sn", r160);
        g0.a.getClass();
        IDoraService r161 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r161 != null) goto L336;
    L338:
        boolean r162 = false;
    L339:
        if (r162 == false) goto L341;
        String r163 = r213;
    L342:
        r157.put("new_dora_onboarding", r163);
        r157.put("dora_scene", String.valueOf(ia8.n.b(ia8.n.c(r85))));
        DeviceService r164 = g0.b();
        if (r164 == null) goto L345;
        boolean r165 = r164.l0();
    L346:
        if (r165 == false) goto L348;
        r142 = r213;
    L348:
        r157.put("is_start_vui_enabled", r142);
        DoraNotificationSummaryPlugin.a r166 = DoraNotificationSummaryPlugin.m;
        String r167 = (String) com.larus.utils.l.b(r166, "next_dora_call_inherit_data");
        com.larus.utils.l.d(r166, "next_dora_call_inherit_data");
        if (r167 == null) goto L352;
        String r168 = (String) r157.put("next_dora_call_inherit_data", r167);
    L352:
        if (r88 != null) goto L355;
    L357:
        if (r88 != null) goto L360;
    L362:
        if (r88 != null) goto L365;
    L367:
        String r169 = r151;
    L368:
        n1.d("DoraRealtimeCallParamBuilder", "definiteIntentType for bizMode=" + r88 + " is " + r169);
        if (r169 == null) goto L371;
        String r170 = (String) r157.put("definite_intent_type", r169);
    L371:
        r157.put("support_live", r213);
        r157.put("dora_noise_control", r156);
        r157.putAll(r145);
        Map<String, String> r171 = MapsKt.build(r157);
        Intrinsics.checkNotNullParameter(r171, "<set-?>");
        r144.m = r171;
        RealtimeCallParam.k r172 = r22.p;
        r172.g = "default";
        Intrinsics.checkNotNullParameter(r172, "extra");
        com.larus.avlink.notification.a.a.getClass();
        r172.w = com.larus.avlink.notification.a.b;
        r172.x = com.larus.avlink.notification.a.c;
        r172.y = com.larus.avlink.notification.a.d;
        r172.z = com.larus.avlink.notification.a.h;
        r172.A = com.larus.avlink.notification.a.g;
        DeviceService r173 = g0.b();
        if (r173 == null) goto L374;
        String r174 = r173.s();
    L375:
        if (r174 != null) goto L377;
        r174 = "";
    L377:
        Intrinsics.checkNotNullParameter(r174, "<set-?>");
        r172.M = r174;
        IDoraService r175 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r175 == null) goto L380;
        String r176 = r175.U();
    L381:
        if (r176 != null) goto L383;
    L385:
        boolean r177 = false;
    L386:
        if (r177 == false) goto L395;
        r176.getClass();
        boolean r178 = com.larus.dora.impl.onboarding.d.a;
        int r179 = com.larus.dora.impl.onboarding.d.e;
        if (r179 != 1) goto L390;
        r172.k = "dora_new_onboarding_voicewakeup_example";
    L394:
        r176.c();
        goto L395
    L390:
        if (r179 != 2) goto L394;
        r172.k = "dora_new_onboarding_voicewakeup_continue";
    L395:
        RealtimeCallUtil.a.getClass();
        r22.y = RealtimeCallUtil.v;
        r22.A = false;
        String r180 = r22.k.b;
        Intrinsics.checkNotNullParameter(r180, "appKey");
        String r181 = AudioServiceDelegate.a.z().o(r180);
        if (r181 != null) goto L398;
        r181 = "";
    L398:
        r22.D = r181;
        r22.E = RealtimeCallUtil.l();
        r22.F = z2.a.b1().getEnableSceneMode();
        if (r811 == false) goto L409;
        r22.u = r110 ? 1 : 0;
        r22.a(AvAudioKitMode.MIX_SPEECH_BIZ);
        String r182 = r22.k.z;
        Intrinsics.checkNotNullParameter(r182, "streamApp");
        IAudioService r183 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r183 == null) goto L403;
        String r184 = r183.x0(r182);
    L404:
        if (r184 != null) goto L406;
        String r185 = "";
    L407:
        r22.B = new RealtimeCallParam.m(r185);
    L423:
        this.g = r22;
        o().c0(this.g, r86, r87, r91);
        return;
    L406:
        r185 = r184;
        goto L407
    L403:
        r184 = r151;
        goto L404
    L409:
        if (r210 == false) goto L411;
        r22.a(AvAudioKitMode.MIX_SPEECH_BIZ);
        r22.C = new ve9.c(72000, 50, 100);
        goto L423
    L411:
        if (r211 == false) goto L423;
        r22.a(AvAudioKitMode.MIX_SPEECH_BIZ);
        ve9.c r186 = new ve9.c(72000, 50, 100);
        if (Intrinsics.areEqual(r22.k.t, DoraMode.DORA_RADIO_SINGLE_TURN.getValue()) == false) goto L415;
        int r187 = z98.h.a;
        r186 = new ve9.c((int) ((((long) e10.P().f()) * 1000) + 32000), 50, 100);
    L415:
        r22.C = r186;
        if (HttpExtKt.e().a == false) goto L418;
    L421:
        String r188 = "66bde825ecb470011f96dd93";
    L422:
        Intrinsics.checkNotNullParameter(r188, "<set-?>");
        r22.b0 = g0.b;
        r22.X = Boolean.valueOf(c78.a.d);
        r22.Y = Boolean.valueOf(c78.a.e);
        r22.Z = Boolean.valueOf(c78.a.f);
        goto L423
    L418:
        if (HttpExtKt.e().c == true) goto L421;
        r188 = "6a6b388ca872660164282353";
        goto L422
    L383:
        if (r176.b() != true) goto L385;
        r177 = true;
        goto L386
    L380:
        r176 = r151;
        goto L381
    L374:
        r174 = r151;
        goto L375
    L365:
        if (r88.intValue() != 10002) goto L367;
        r169 = "11";
        goto L368
    L360:
        if (r88.intValue() != 10001) goto L362;
    L361:
        r169 = r213;
        goto L368
    L355:
        if (r88.intValue() != 21) goto L357;
    L345:
        r165 = false;
        goto L346
    L341:
        r163 = "0";
        goto L342
    L336:
        if (r161.J0() != true) goto L338;
        r162 = true;
    L330:
        r160 = r151;
        goto L331
    L324:
        r153 = "0";
    L321:
        r152 = false;
    L320:
        r151 = null;
        goto L321
    L312:
        r146 = "FaceToFace";
        goto L313
    L308:
        r143 = null;
        goto L309
    L304:
        r108 = null;
        goto L305
    L298:
        r104 = null;
    L290:
        e = move-exception;
        n1.d("DoraRealtimeCallParamBuilder", e.getMessage());
        r101 = new JSONObject();
    L294:
        r102 = new JSONObject().toString();
        goto L295
    L276:
        if (r96.length() == 0) goto L279;
        r97 = false;
        goto L280
    L273:
        r96 = null;
        goto L274
    L266:
        r90 = "0";
        goto L267
    L260:
        if (r82.J0() != true) goto L262;
        r83 = true;
        goto L263
    L256:
        r81 = 2;
        goto L257
    L252:
        r80 = null;
        goto L253
    L248:
        r77 = null;
        goto L249
    L232:
        if (r68.f0() != true) goto L234;
        r69 = true;
    L244:
        r72 = false;
        goto L245
    L203:
        r138 = 0;
        goto L204
    L205:
        r811 = r19;
        boolean r189 = g0.c(r84);
        z2 r190 = z2.a;
        lq9.e r191 = r190.V2().getData();
        if (r191 == null) goto L208;
        int r192 = r191.c();
    L209:
        RealtimeCallParam.f r193 = new RealtimeCallParam.f(new RealtimeCallParam.e(r189, r192, r190.getDoraSamiConfig().getReconnectInterval()));
        Intrinsics.checkNotNullParameter(r193, "<set-?>");
        r49.l = r193;
        r49.e = r190.getDoraSamiConfig().getReconnectTimeout();
        goto L210
    L208:
        r192 = 0;
        goto L209
    L189:
        DeviceService r194 = g0.b();
        if (r194 != null) goto L192;
    L194:
        boolean r195 = false;
    L195:
        if (r195 == false) goto L197;
        r134 = 9;
        goto L198
    L192:
        if (r194.M() != true) goto L194;
        r195 = true;
        goto L195
    L184:
        if (r132.L() != r130) goto L186;
        r133 = true;
    L197:
        r134 = 6;
    L178:
        r131 = false;
        goto L179
    L177:
        r213 = "1";
        r130 = true;
    L168:
        r124 = "";
        goto L170
    L160:
        r53 = ia8.e.b().c(AudioServiceDelegate.a.n0().d(r52));
    L156:
        r52 = "";
    L150:
        r48 = "";
        goto L151
    L136:
        r119 = new JSONObject();
        r119.put("enabled", true);
        r119.put("model_path", r39);
        JSONObject r196 = new JSONObject();
        r196.put("likelihood_threshold", 0.5d);
        r196.put("begin_smooth_window_ms", 500);
        r196.put("begin_smooth_voice_proportion", 0.5d);
        r196.put("end_smooth_window_ms", 700);
        r196.put("end_smooth_silence_proportion", 0.925d);
        Unit r197 = Unit.INSTANCE;
        r119.put("param", r196);
        goto L137
    L130:
        if (r39.length() == 0) goto L133;
        r118 = false;
    L116:
        th = th;
    L122:
        Result.Companion r198 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L120:
        th = th;
        r212 = r9;
        r211 = r112;
    L107:
        r35 = false;
    L139:
        r212 = r9;
        r211 = r112;
        r113 = r113;
        goto L140
    L96:
        if (r31.a() != r115) goto L98;
        r32 = true;
        goto L99
    L82:
        r210 = r111;
        if (r30.intValue() != 1) goto L85;
        r114 = true;
        goto L86
    L79:
        r30 = null;
        goto L80
    L87:
        r210 = r111;
        if (DoraConfig.a.getBoolean("key_dora_switch_vad", false) == false) goto L92;
        if (Intrinsics.areEqual(r84, "dora_full_duplex") == false) goto L92;
        r115 = true;
        r25.put("enable_vui_vad", true);
        goto L93
    L71:
        if (r26.L() != true) goto L73;
        r27 = true;
    L62:
        ModelItem r199 = r9.getModel();
        if (r199 == null) goto L65;
        r24 = r199.getModelName();
    L66:
        if (r24 != null) goto L68;
        r24 = "";
        goto L68
    L65:
        r24 = null;
        goto L66
    L53:
        if (r111 == false) goto L55;
        r21 = AudioSessionType.QUIC;
        goto L58
    L55:
        if (r19 == false) goto L57;
        r21 = AudioSessionType.RTC;
        goto L58
    L57:
        r21 = AudioSessionType.SAMI;
        goto L58
    L41:
        if (r15.J0() != true) goto L43;
        r16 = true;
    L47:
        r17 = true;
    L36:
        r14 = false;
    L17:
        wc9.e r200 = (wc9.e) r4.u().getValue();
        if (r200 == null) goto L20;
        r7 = r200.a;
        goto L21
    L20:
        r7 = null;
        goto L21
    L22:
        r7 = this.a;
        goto L24
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }
}
