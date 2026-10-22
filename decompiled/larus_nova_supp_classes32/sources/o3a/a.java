package o3a;

import android.text.TextUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.n;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.voicecall.impl.ui.RealtimeCallHelperKt;
import com.lynx.devtool.helper.ScreenCapturer;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final String a = null;
    public static final String b = null;

    public a() {
    }

    static {
        a = o.a.getDeviceId();
        b = AccountService.a.getUserId();
    }

    public static RealtimeCallParam a(int r26, wc9.e r27, BotModel r28) {
        String r1 = UUID.randomUUID().toString();
        String r2 = UUID.randomUUID().toString();
        RealtimeCallParam r3 = new RealtimeCallParam();
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r3.w = "0";
        r3.e = r1;
        r3.i = "Seed Omni Sota";
        AudioSessionType r4 = AudioSessionType.QUIC;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.s = r4;
        r3.y = false;
        r3.A = false;
        r3.L = new n("interpret", 6);
        z2 r6 = z2.a;
        r6.A2().getForcePlay();
        r3.a(AvAudioKitMode.PURE_BIZ);
        r3.j.a = CollectionsKt.listOf(new RealtimeCallParam.a("0", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, Integer.valueOf(r26)));
        RealtimeCallParam.h r7 = r3.k;
        r7.getClass();
        Intrinsics.checkNotNullParameter("OckITjXWeb", "<set-?>");
        r7.b = "OckITjXWeb";
        StringBuilder r8 = new StringBuilder();
        AudioServiceDelegate r9 = AudioServiceDelegate.a;
        r8.append(r9.m0());
        r8.append("?device_platform=android&os=android&ssmix=a&_rticket=1739878822281&cdid=ac5a0a9c-645e-49b6-992b-6ed9d90709fe&channel=debug&aid=482431&app_name=nova_ai&version_code=7060001&version_name=7.6.0&manifest_version_code=7060001&update_version_code=7060006&resolution=1080*2184&dpi=480&device_type=LE2120&device_brand=OnePlus&language=zh&os_api=34&os_version=14&ac=wifi&dora_status=0&uid=");
        String r11 = b;
        r8.append(r11);
        r8.append("&sys_region=CN&tz_name=Asia%2FShanghai&is_new_user=0&region=CN&lang=zh&dora_bond_count=0&has_dora_device=0&pkg_type=inhouse_version&iid=1651926893129595&device_id=1753059379671900&appkey=OckITjXWeb&namespace=VoiceGenieAST, appKey=OckITjXWeb, token=");
        String r10 = r8.toString();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r7.a = r10;
        x58.a r12 = m58.h.a;
        JSONObject r13 = new JSONObject();
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L6;
        String r15 = r14.F0();
        if (r15 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r15) == true) goto L11;
        r13.put("feature_key", r15);
    L11:
        if (AccountService.a.a() == false) goto L13;
        r13.put("minor-mode", "1");
    L13:
        Unit r16 = Unit.INSTANCE;
        String r17 = m58.h.b(false, r13, 2);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r7.d = r17;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r7.f = r11;
        String r18 = a;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r7.g = r18;
        Intrinsics.checkNotNullParameter("request_type_quic", "<set-?>");
        r7.o = "request_type_quic";
        AppHost.Companion r19 = AppHost.a;
        String r110 = r19.getVersionName();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r7.h = r110;
        r7.i = r19.getVersionCode();
        r7.j = r19.getUpdateVersionCode();
        r7.k = r6.realtimeMaxAliveDuration();
        lq9.e r111 = r6.V2().getData();
        if (r111 == null) goto L16;
        boolean r5 = r111.a();
    L17:
        lq9.e r112 = r6.V2().getData();
        if (r112 == null) goto L20;
        int r20 = r112.c();
    L21:
        lq9.e r113 = r6.V2().getData();
        if (r113 == null) goto L27;
        int[] r114 = r113.b();
        if (r114 == null) goto L27;
        int[] r21 = r114;
    L28:
        RealtimeCallParam.f r115 = new RealtimeCallParam.f(new RealtimeCallParam.e(r5, r20, r21));
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r7.l = r115;
        r7.m = 0;
        String r22 = r9.m0();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r7.y = r22;
        Intrinsics.checkNotNullParameter("VoiceGenieAST", "<set-?>");
        r7.x = "VoiceGenieAST";
        if (ic8.n.D(r27) == true) goto L31;
    L33:
        RealtimeCallParam.d r23 = r3.l;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r23.a = r2;
        if (r27 == null) goto L36;
        String r24 = r27.a;
    L37:
        if (r24 != null) goto L39;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L39:
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.c = r24;
        Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "<set-?>");
        r23.p = NameKeys.UnloadStrategy_No_Strategy;
        if (r28 == null) goto L45;
        SpeakerVoice r25 = r28.getVoiceType();
        if (r25 == null) goto L45;
        String r29 = r25.getLanguageCode();
        if (r29 == null) goto L45;
    L46:
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r23.d = r29;
        r23.a("{\"uid\":\"" + r11 + "\",\"did\":\"" + r18 + "\",\"app_version\":\"" + r19.getVersionCode() + "\",\"speech_language\":\"zh\",\"asr_language\":\"zh\",\"model\":\"\",\"os\":\"Android\",\"dumpRate\":0,\"send_mq\":true}");
        r23.h = 3;
        r23.m = false;
        RealtimeCallParam.p r30 = r3.o;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r30.a = r2;
        if (r28 == null) goto L49;
        String r31 = r28.getBotId();
    L50:
        if (r31 != null) goto L52;
        r31 = NameKeys.UnloadStrategy_No_Strategy;
    L52:
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r30.h = r31;
        if (r27 == null) goto L55;
        String r0 = r27.a;
    L56:
        if (r0 != null) goto L58;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L58:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r30.c = r0;
        r30.o = false;
        r30.p = true;
        if (r28 == null) goto L63;
        SpeakerVoice r32 = r28.getVoiceType();
        if (r32 == null) goto L63;
        String r33 = RealtimeCallHelperKt.a(r32);
    L64:
        if (r33 != null) goto L66;
        r33 = NameKeys.UnloadStrategy_No_Strategy;
    L66:
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r30.d = r33;
        if (r28 == null) goto L71;
        SpeakerVoice r34 = r28.getVoiceType();
        if (r34 == null) goto L71;
        String r35 = r34.getName();
    L72:
        if (r35 != null) goto L74;
        r35 = NameKeys.UnloadStrategy_No_Strategy;
    L74:
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r30.g = r35;
        r30.j = r6.Y();
        if (r28 == null) goto L79;
        SpeakerVoice r36 = r28.getVoiceType();
        if (r36 == null) goto L79;
        String r37 = r36.getId();
    L80:
        if (r37 != null) goto L82;
        r37 = NameKeys.UnloadStrategy_No_Strategy;
    L82:
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r30.f = r37;
        Intrinsics.checkNotNullParameter("{\"post_process\":{\"pitch\":0,\"speech_rate\":1}}", "<set-?>");
        r30.n = "{\"post_process\":{\"pitch\":0,\"speech_rate\":1}}";
        if (r28 == null) goto L87;
        SpeakerVoice r38 = r28.getVoiceType();
        if (r38 == null) goto L87;
        String r39 = r38.getAudioMetrics();
    L88:
        if (r39 != null) goto L90;
        r39 = NameKeys.UnloadStrategy_No_Strategy;
    L90:
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r30.t = r39;
        r30.u = r9.a0().b();
        r30.v = r9.a0().c();
        r30.l = ((Boolean) com.larus.voicecall.impl.e.a().getFirst()).booleanValue();
        r30.m = ((Number) com.larus.voicecall.impl.e.a().getSecond()).intValue();
        r30.v = 1;
        RealtimeCallParam.k r40 = r3.p;
        r40.getClass();
        Intrinsics.checkNotNullParameter("landing", "<set-?>");
        r40.b = "landing";
        Intrinsics.checkNotNullParameter("chat", "<set-?>");
        r40.c = "chat";
        Intrinsics.checkNotNullParameter("chat", "<set-?>");
        r40.d = "chat";
        r40.e = null;
        r40.f = null;
        r40.g = LynxUIWebView.DEFAULT;
        r40.h = new RealtimeCallParam.n(null, null, null, null, null, null, 8);
        r40.i = "click_chat_plus_call";
        r40.k = NameKeys.UnloadStrategy_No_Strategy;
        r40.l = NameKeys.UnloadStrategy_No_Strategy;
        r40.m = NameKeys.UnloadStrategy_No_Strategy;
        r40.n = "0";
        r40.o = new RealtimeCallParam.c(null, null, null, null);
        r40.p = null;
        r40.t = false;
        r40.u = r40.u;
        r40.v = null;
        return r3;
    L87:
        r39 = null;
    L79:
        r37 = null;
    L71:
        r35 = null;
    L63:
        r33 = null;
        goto L64
    L55:
        r0 = null;
        goto L56
    L49:
        r31 = null;
    L45:
        r29 = Locale.CHINA.getLanguage();
        goto L46
    L36:
        r24 = null;
        goto L37
    L31:
        if (ic8.n.r(r27) == false) goto L33;
        Intrinsics.checkNotNullParameter("1", "<set-?>");
        r7.q = "1";
    L27:
        r21 = new int[]{300, 600, 900, 1200, ScreenCapturer.SCREEN_SHOT_PREVIEW_DELAY_TIME};
        goto L28
    L20:
        r20 = 0;
        goto L21
    L16:
        r5 = true;
    L6:
        r15 = NameKeys.UnloadStrategy_No_Strategy;
        goto L8
    }
}
