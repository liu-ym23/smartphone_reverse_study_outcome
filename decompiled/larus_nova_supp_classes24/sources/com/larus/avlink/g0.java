package com.larus.avlink;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.VideoEncoderCodecType;
import com.larus.platform.service.z2;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g0 {
    public static final g0 a = null;
    public static final String b = null;

    public g0() {
    }

    static {
        a = new g0();
        b = GsonProtectorUtils.toJson(new Gson(), MapsKt.mapOf(new Pair[]{TuplesKt.to("bmmt.full_chain_rtt", MapsKt.mapOf(TuplesKt.to("enable", Boolean.FALSE))), TuplesKt.to("bmmt.ttnet_config", MapsKt.mapOf(TuplesKt.to("channel_path", "/mmt/hardware/".concat(d(AudioSessionType.MMT)))))}));
    }

    public static IDoraService.d b() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.device();
    }

    public static boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "requestType");
        if (Intrinsics.areEqual(r1, "dora_si") == false) goto L5;
        return false;
    L5:
        lq9.e r2 = z2.a.V2().getData();
        if (r2 != null) goto L11;
        return true;
    L11:
        return r2.a();
    }

    public static String d(AudioSessionType r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionType");
        boolean r1 = false;
        if (r4 != AudioSessionType.MMT) goto L13;
        DeviceService r5 = b();
        if (r5 != null) goto L7;
    L9:
        if (r1 == true) goto L38;
        return "dora_earphone";
    L38:
        return "dora_g";
    L7:
        if (r5.M() != true) goto L9;
        r1 = true;
        goto L9
    L13:
        DeviceService r6 = b();
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L21;
        return "dora_h";
    L21:
        DeviceService r8 = b();
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L29;
        return "dora_e";
    L29:
        DeviceService r10 = b();
        if (r10 != null) goto L32;
    L34:
        if (r1 == true) goto L41;
        return "dora_lite";
    L41:
        return "dora_g";
    L32:
        if (r10.M() != true) goto L34;
        r1 = true;
        goto L34
    L24:
        if (r8.L() != true) goto L26;
        r9 = true;
        goto L27
    L16:
        if (r6.f() != true) goto L18;
        r7 = true;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.larus.im.service.audio.h1] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    public static Map a(RealtimeCallParam.j r16, int r17, String r19, boolean r110, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r16, "config");
        Intrinsics.checkNotNullParameter(r19, "requestType");
        com.larus.avlink.rtc.d.a.getClass();
        Boolean r5 = com.larus.avlink.rtc.d.a(r21);
        Boolean r6 = Boolean.TRUE;
        boolean r7 = Intrinsics.areEqual(r5, r6);
        if (r17 != 32) goto L5;
        boolean r10 = true;
    L6:
        boolean r8 = Intrinsics.areEqual(com.larus.avlink.rtc.d.a(r21), r6);
        if (r17 != 32) goto L9;
        boolean r11 = true;
    L10:
        if (r110 == true) goto L12;
        if (r20 == true) goto L12;
    L15:
        boolean r9 = false;
    L17:
        n1.d("DoraRealtimeCallParamBuilder", "shouldEnableRtcVideoStream enabled=" + r9 + ", extraEnabled=" + r7 + ", modeEnabled=" + r10 + ", useRTCLink=" + r110 + ", useMMT=" + r20 + ", extra=" + r21);
        LinkedHashMap r3 = new LinkedHashMap();
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L22;
        DeviceService r13 = r12.device();
        if (r13 == null) goto L22;
        String r14 = r13.s();
    L23:
        String r15 = "";
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r3.put("rtos_version_code", r14);
        a.getClass();
        IDoraService r22 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r22 == null) goto L31;
        DeviceService r23 = r22.device();
        if (r23 == null) goto L31;
        Integer r24 = Integer.valueOf(r23.L0().length);
    L32:
        if (r24 != null) goto L34;
    L36:
        boolean r25 = false;
    L37:
        String r111 = "1";
        if (r25 == false) goto L40;
        Object r26 = "1";
    L41:
        r3.put("support_client_intent", r26);
        IDoraService r27 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r27 == null) goto L48;
        DeviceService r29 = r27.device();
        if (r29 == null) goto L48;
        if (r29.j0() != true) goto L48;
        boolean r30 = true;
    L49:
        if (r30 == false) goto L51;
        Object r31 = "1";
    L52:
        r3.put("support_ast", r31);
        IDoraService r32 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r32 == null) goto L59;
        DeviceService r33 = r32.device();
        if (r33 == null) goto L59;
        if (r33.g0() != true) goto L59;
        boolean r34 = true;
    L60:
        if (r34 == false) goto L62;
        Object r35 = "1";
    L63:
        r3.put("support_fpa_meeting", r35);
        IDoraService r36 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r36 == null) goto L70;
        DeviceService r37 = r36.device();
        if (r37 == null) goto L70;
        if (r37.Y() != true) goto L70;
        boolean r38 = true;
    L71:
        if (r38 == false) goto L73;
        Object r39 = "1";
    L74:
        r3.put("support_lark_meeting", r39);
        DeviceService r40 = b();
        if (r40 != null) goto L77;
    L79:
        boolean r41 = false;
    L80:
        if (r41 == false) goto L93;
        IObricDoraService r42 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r42 != null) goto L84;
    L86:
        boolean r43 = false;
    L87:
        if (r43 == false) goto L93;
        IObricDoraService r44 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r44 == null) goto L93;
        Map r45 = r44.a(0, true);
        if (r45 == null) goto L93;
        r3.putAll(r45);
        goto L93
    L84:
        if (r42.k() != true) goto L86;
        r43 = true;
    L93:
        boolean r46 = v88.a.f(Integer.valueOf(r17));
        r16.b = r46;
        DeviceService r47 = b();
        if (r47 != null) goto L96;
    L98:
        boolean r48 = false;
    L100:
        if (r48 == false) goto L128;
        if (r46 == false) goto L103;
        boolean r49 = false;
    L104:
        r16.c = r49;
        if (r9 == true) goto L115;
        if (r46 == false) goto L110;
        int r50 = 1;
    L116:
        r16.d = r50;
        IDoraService r51 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r51 == null) goto L123;
        com.larus.dora.impl.serviceimpl.h r52 = r51.debug();
        if (r52 == null) goto L123;
        if (r52.f() != true) goto L123;
        boolean r53 = true;
    L124:
        if (r53 == true) goto L127;
        r111 = "0";
    L127:
        r3.put("force_llm_photo_intent", r111);
    L123:
        r53 = false;
        goto L124
    L110:
        if (v88.a.c(Integer.valueOf(r17)) == true) goto L115;
        if (v88.a.b(Integer.valueOf(r17)) == true) goto L115;
        r50 = 2;
    L115:
        r50 = 3;
        goto L116
    L103:
        r49 = v88.a.c(Integer.valueOf(r17));
    L128:
        n1.d("DoraRealtimeCallParamBuilder", "fillDoraConfigSingleEnd meeting record: support_fpa_meeting=" + ((String) r3.get("support_fpa_meeting")) + ", support_lark_meeting=" + ((String) r3.get("support_lark_meeting")));
        DeviceService r4 = b();
        if (r4 == null) goto L131;
        r4.y();
    L131:
        DeviceService r54 = b();
        if (r54 != null) goto L134;
    L136:
        boolean r55 = false;
    L137:
        if (r55 == false) goto L139;
        String r56 = DoraConfig.d();
    L140:
        Intrinsics.checkNotNullParameter(r56, "<set-?>");
        r16.g = r56;
        DeviceService r57 = b();
        if (r57 != null) goto L143;
    L145:
        boolean r59 = false;
    L146:
        if (r59 == false) goto L148;
        String r60 = DoraConfig.c();
    L149:
        Intrinsics.checkNotNullParameter(r60, "<set-?>");
        r16.h = r60;
        Keva r61 = DoraConfig.a;
        String r62 = r61.getString("key_timbre_clone", "");
        Intrinsics.checkNotNullParameter(r62, "<set-?>");
        r16.l = r62;
        r16.j = System.currentTimeMillis();
        if (Intrinsics.areEqual(r19, "dora_si") == false) goto L214;
        DeviceService r0 = b();
        if (r0 != null) goto L154;
    L156:
        boolean r1 = false;
    L157:
        if (r1 == false) goto L214;
        boolean r2 = ha8.d.a;
        AppHost.Companion r63 = AppHost.a;
        File r64 = r63.getApplication().getExternalFilesDir(null);
        if (r64 == null) goto L162;
        String r65 = r64.getAbsolutePath();
        if (r65 == null) goto L162;
    L163:
        StringBuilder r112 = new StringBuilder();
        r112.append(r65);
        String r66 = File.separator;
        r112.append(r66);
        r112.append("audio");
        r112.append(r66);
        r112.append("dmiccpu");
        r112.append(r66);
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112.toString(), "dora_dmic_cpu.bin");
        int r114 = r61.getInt("key_dora_dmic_cpu_version", 0);
        if (r113.exists() == false) goto L168;
        if (r114 != 2) goto L168;
        r15 = r113.getAbsolutePath();
        n1.d("SimultaneousInterpretSettingManager", "cpu path is " + r15 + " (cached, v" + r114 + ')');
    L177:
        ?? r115 = 0;
    L215:
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r16.k = r15;
        r16.e = r9;
        if (r9 == false) goto L218;
        com.larus.im.internal.delegate.w.p r67 = com.larus.im.internal.delegate.w.o();
        ?? r116 = new com.larus.im.service.audio.h1(r67.a, r67.b, r67.c, VideoEncoderCodecType.H265);
    L219:
        r16.f = r116;
        Map<String, Object> r68 = r16.n;
        DoraVisionBizScene.Companion.getClass();
        r68.put("dora_vision_biz_scene", Integer.valueOf(DoraVisionBizScene.a.a(r17).getValue()));
        a.getClass();
        if (r17 != 32) goto L231;
        IDoraService r69 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r69 == null) goto L228;
        AbilityService r70 = r69.o0();
        if (r70 == null) goto L228;
        if (r70.k() != true) goto L228;
        boolean r71 = true;
    L229:
        if (r71 == false) goto L231;
    L238:
        boolean r72 = false;
    L239:
        if (r72 == false) goto L241;
        String r73 = "true";
    L242:
        r68.put("dora_live_ocr", r73);
        if (r9 == false) goto L245;
        r68.put("trans_mode", GlobalAudioSceneEnum.VIDEO);
    L245:
        DeviceService r74 = b();
        if (r74 == null) goto L248;
        boolean r75 = r74.f0();
    L249:
        r68.put("enable_query_comfort", Boolean.valueOf(r75));
        return r3;
    L248:
        r75 = false;
        goto L249
    L241:
        r73 = "false";
    L228:
        r71 = false;
    L231:
        IDoraService r76 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r76 == null) goto L238;
        com.larus.dora.impl.serviceimpl.h r77 = r76.debug();
        if (r77 == null) goto L238;
        if (r77.d() != true) goto L238;
        r72 = true;
        goto L239
    L218:
        r116 = r115;
    L168:
        if (r113.exists() == false) goto L170;
        n1.d("SimultaneousInterpretSettingManager", "Deleting old asset file (v" + r114 + ')');
        r113.delete();
    L170:
        File r79 = r113.getParentFile();
        if (r79 != null) goto L173;
    L253:
        n1.d("SimultaneousInterpretSettingManager", "CPU File not found, copying from assets...");     // Catch: IOException -> L208
        InputStream r80 = r63.getApplication().getAssets().open("dora_dmic_cpu.bin");     // Catch: IOException -> L208
        PolarisFileOutputStreamWrapper r117 = new PolarisFileOutputStreamWrapper(r113);     // Catch: Throwable -> L200
        Intrinsics.checkNotNull(r80);     // Catch: Throwable -> L192
        r114 = 0;
        r115 = 0;
        ByteStreamsKt.copyTo$default(r80, r117, 0, 2, null);     // Catch: Throwable -> L190
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L188
        CloseableKt.closeFinally(r80, null);     // Catch: IOException -> L186
        r61.storeInt("key_dora_dmic_cpu_version", 2);     // Catch: IOException -> L186
        String r81 = r113.getAbsolutePath();     // Catch: IOException -> L186
        n1.d("SimultaneousInterpretSettingManager", "cpu path is " + r81 + " (copy)");     // Catch: IOException -> L186
        r15 = r81;
    L190:
        th = th;
    L194:
        Throwable r82 = th;
        throw r82;     // Catch: Throwable -> L196
    L196:
        th = move-exception;
        CloseableKt.closeFinally(r117, r82);     // Catch: Throwable -> L188
        throw th;     // Catch: Throwable -> L188
    L192:
        th = th;
        r114 = 0;
    L200:
        th = th;
        r114 = 0;
    L202:
        Throwable r83 = th;
        throw r83;     // Catch: Throwable -> L204
    L204:
        th = move-exception;
        CloseableKt.closeFinally(r80, r83);     // Catch: IOException -> L186
        throw th;     // Catch: IOException -> L186
    L188:
        th = th;
    L186:
        e = e;
    L210:
        e.printStackTrace();
        if (r113.exists() == false) goto L213;
        r113.delete();
    L213:
        n1.b("SimultaneousInterpretSettingManager", "exception is " + e);
        r115 = r114;
    L208:
        e = e;
        r114 = 0;
        goto L210
    L173:
        if (r79.exists() == true) goto L253;
        if (r79.mkdirs() == true) goto L253;
        n1.b("SimultaneousInterpretSettingManager", "Failed to create directory: " + r79);
    L162:
        r65 = "";
        goto L163
    L154:
        if (r0.a() != true) goto L156;
        r1 = true;
    L214:
        r115 = 0;
        goto L215
    L148:
        r60 = DoraConfig.b();
        goto L149
    L143:
        if (r57.b0() != true) goto L145;
        r59 = true;
        goto L146
    L139:
        r56 = DoraConfig.a();
        goto L140
    L134:
        if (r54.b0() != true) goto L136;
        r55 = true;
        goto L137
    L96:
        if (r47.C() != true) goto L98;
        r48 = true;
        goto L100
    L77:
        if (r40.M() != true) goto L79;
        r41 = true;
        goto L80
    L73:
        r39 = "0";
    L70:
        r38 = false;
        goto L71
    L62:
        r35 = "0";
    L59:
        r34 = false;
        goto L60
    L51:
        r31 = "0";
    L48:
        r30 = false;
        goto L49
    L40:
        r26 = "0";
        goto L41
    L34:
        if (r24.intValue() <= 0) goto L36;
        r25 = true;
    L31:
        r24 = null;
    L22:
        r14 = null;
    L12:
        if (r8 == true) goto L16;
        if (r11 == false) goto L15;
    L16:
        r9 = true;
        goto L17
    L9:
        r11 = false;
        goto L10
    L5:
        r10 = false;
        goto L6
    }
}
