package com.bytedance.android.ec.core.monitor;

import android.util.Base64;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECProcessMonitor {
    public static final Set<String> a = null;
    public static final HashMap<String, ActionRateListener> b = null;
    public static PdpMonitorSetting c;

    public ECProcessMonitor() {
    }

    static {
        a = new LinkedHashSet();
        b = new HashMap();
    }

    public static boolean a() {
        if (c != null) goto L5;
        c = h();
    L5:
        PdpMonitorSetting r0 = c;
        if (r0 != null) goto L10;
        return false;
    L10:
        return r0.getALogSwitch();
    }

    @SettingPanel("商详监控配置")
    public static final PdpMonitorSetting h() {
        int r0 = com.bytedance.android.ec.core.abtest.j.a;
        Object r1 = new PdpMonitorSetting(null, false, false, null, null, null, null, null, 255, null);
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("pdp_monitor_setting");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L172
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof PdpMonitorSetting) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (PdpMonitorSetting) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("pdp_monitor_setting");     // Catch: Throwable -> L172
        if ((r19 instanceof PdpMonitorSetting) == true) goto L76;
        r19 = null;
    L76:
        r18 = (PdpMonitorSetting) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L185;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("pdp_monitor_setting", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_monitor_setting", PdpMonitorSetting.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("pdp_monitor_setting");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L159
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof PdpMonitorSetting) == true) goto L144;
        r25 = null;
    L144:
        r22 = (PdpMonitorSetting) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("pdp_monitor_setting", PdpMonitorSetting.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof PdpMonitorSetting) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (PdpMonitorSetting) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof PdpMonitorSetting) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (PdpMonitorSetting) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof PdpMonitorSetting) == true) goto L98;
        r31 = null;
    L98:
        r24 = (PdpMonitorSetting) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof PdpMonitorSetting) == true) goto L104;
        r32 = null;
    L104:
        r24 = (PdpMonitorSetting) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof PdpMonitorSetting) == true) goto L110;
        r33 = null;
    L110:
        r24 = (PdpMonitorSetting) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof PdpMonitorSetting) == true) goto L116;
        r34 = null;
    L116:
        r24 = (PdpMonitorSetting) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), PdpMonitorSetting.class);     // Catch: Throwable -> L126
        if ((r35 instanceof PdpMonitorSetting) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((PdpMonitorSetting) r35);     // Catch: Throwable -> L126
    L128:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L133
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r23 instanceof JSONArray) == false) goto L130;
    L87:
        r30 = r23;
    L133:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L159
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return (PdpMonitorSetting) r18;
    L11:
        if ((r14 instanceof PdpMonitorSetting) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (PdpMonitorSetting) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof PdpMonitorSetting) == true) goto L24;
        r40 = null;
    L24:
        r15 = (PdpMonitorSetting) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof PdpMonitorSetting) == true) goto L30;
        r41 = null;
    L30:
        r15 = (PdpMonitorSetting) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof PdpMonitorSetting) == true) goto L36;
        r42 = null;
    L36:
        r15 = (PdpMonitorSetting) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpMonitorSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof PdpMonitorSetting) == true) goto L42;
        r43 = null;
    L42:
        r15 = (PdpMonitorSetting) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), PdpMonitorSetting.class);     // Catch: Throwable -> L52
        if ((r44 instanceof PdpMonitorSetting) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((PdpMonitorSetting) r44);     // Catch: Throwable -> L52
    L54:
        r15 = r45;
        if (Result.isFailure-impl(r15) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L59
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r14 instanceof JSONArray) == false) goto L56;
    L13:
        r39 = r14;
    L59:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L172
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L177;
        EnsureManager.ensureNotReachHere(r50);
    L177:
        if (Result.isFailure-impl(r49) == true) goto L180;
        r1 = r49;
    L180:
        r18 = r1;
        goto L182
    }

    public static com.bytedance.android.ec.core.monitor.listener.d o() {
        HashMap<String, ActionRateListener> r0 = b;
        Object r10 = r0.get(g("ec_product_detail", "enter_page"));
        if ((r10 instanceof com.bytedance.android.ec.core.monitor.listener.d) == true) goto L5;
        r10 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.d r11 = (com.bytedance.android.ec.core.monitor.listener.d) r10;
        if (r11 == null) goto L8;
        return r11;
    L8:
        com.bytedance.android.ec.core.monitor.listener.d r12 = new com.bytedance.android.ec.core.monitor.listener.d(ECProcessMonitor$openPdpListener$2$1.INSTANCE);
        r0.put(g("ec_product_detail", "enter_page"), r12);
        return r12;
    }

    public static com.bytedance.android.ec.core.monitor.listener.e p() {
        HashMap<String, ActionRateListener> r0 = b;
        Object r10 = r0.get(g("ec_sku", "enter_page"));
        if ((r10 instanceof com.bytedance.android.ec.core.monitor.listener.e) == true) goto L5;
        r10 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.e r11 = (com.bytedance.android.ec.core.monitor.listener.e) r10;
        if (r11 == null) goto L8;
        return r11;
    L8:
        com.bytedance.android.ec.core.monitor.listener.e r12 = new com.bytedance.android.ec.core.monitor.listener.e(ECProcessMonitor$openSkuListener$2$1.INSTANCE);
        r0.put(g("ec_sku", "enter_page"), r12);
        return r12;
    }

    public static boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "actionType");
        if (c != null) goto L6;
        c = h();
    L6:
        if (a() == false) goto L16;
        PdpMonitorSetting r0 = c;
        if (r0 == null) goto L12;
        List<String> r1 = r0.getActionALogBlockList();
        if (r1 == null) goto L12;
        boolean r11 = r1.contains(r10);
    L13:
        if (r11 == true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r11 = false;
        goto L13
    L16:
        return false;
    }

    public static com.bytedance.android.ec.core.monitor.listener.a d(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        HashMap<String, ActionRateListener> r0 = b;
        Object r11 = r0.get(g(r10, "add_2_cart"));
        if ((r11 instanceof com.bytedance.android.ec.core.monitor.listener.a) == true) goto L5;
        r11 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.a r12 = (com.bytedance.android.ec.core.monitor.listener.a) r11;
        if (r12 == null) goto L8;
        return r12;
    L8:
        com.bytedance.android.ec.core.monitor.listener.a r13 = new com.bytedance.android.ec.core.monitor.listener.a(r10, new ECProcessMonitor$addCartListener$$inlined$run$lambda$1(r10));
        r0.put(g(r10, "add_2_cart"), r13);
        return r13;
    }

    public static com.bytedance.android.ec.core.monitor.listener.b e(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        HashMap<String, ActionRateListener> r0 = b;
        Object r11 = r0.get(g(r10, "buy_now"));
        if ((r11 instanceof com.bytedance.android.ec.core.monitor.listener.b) == true) goto L5;
        r11 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.b r12 = (com.bytedance.android.ec.core.monitor.listener.b) r11;
        if (r12 == null) goto L8;
        return r12;
    L8:
        com.bytedance.android.ec.core.monitor.listener.b r13 = new com.bytedance.android.ec.core.monitor.listener.b(r10, new ECProcessMonitor$buyNowListener$$inlined$run$lambda$1(r10));
        r0.put(g(r10, "buy_now"), r13);
        return r13;
    }

    public static String f(String r10) {
        Intrinsics.checkNotNullParameter("UTF-8", "encoding");
        GZIPOutputStream r0 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L35
        if (r10 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L40;
        return null;
    L40:
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L35
        GZIPOutputStream r14 = new GZIPOutputStream(r13);     // Catch: Throwable -> L23 IOException -> L25
        Charset r1 = Charset.forName("UTF-8");     // Catch: Throwable -> L19 IOException -> L21
        if (r10 == null) goto L18;
        r14.write(r10.getBytes(r1));     // Catch: Throwable -> L19 IOException -> L21
    L29:
        r14.close();     // Catch: Throwable -> L35
    L31:
        return Base64.encodeToString(r13.toByteArray(), 0);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L19 IOException -> L21
    L21:
        e = e;
    L27:
        e.getMessage();     // Catch: Throwable -> L19
        if (r14 == null) goto L31;
    L25:
        e = e;
        r14 = null;
    L23:
        th = th;
    L32:
        if (0 == 0) goto L34;
        r0.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        th = th;
        goto L32
    L6:
        if (r10.length() == 0) goto L9;
        r12 = false;
    L35:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Throwable r16 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r16 == null) goto L39;
        ECExceptionMonitor.e(r16);
    L39:
        return null;
    }

    public static boolean q(String r10) {
        Intrinsics.checkNotNullParameter(r10, "eventType");
        if (c != null) goto L5;
        c = h();
    L5:
        PdpMonitorSetting r0 = c;
        if (r0 == null) goto L12;
        Map<String, Integer> r1 = r0.getSampleConfigMap();
        if (r1 == null) goto L12;
        Integer r11 = r1.get(r10);
        if (r11 == null) goto L12;
        int r12 = r11.intValue();
    L14:
        if (Random.Default.nextFloat() >= (r12 / 100.0f)) goto L16;
        return true;
    L16:
        return false;
    L12:
        r12 = 100;
        goto L14
    }

    public static com.bytedance.android.ec.core.monitor.listener.c c(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        HashMap<String, ActionRateListener> r0 = b;
        Object r1 = r0.get(g(r10, r11));
        if ((r1 instanceof com.bytedance.android.ec.core.monitor.listener.c) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.ec.core.monitor.listener.c r12 = (com.bytedance.android.ec.core.monitor.listener.c) r1;
        if (r12 == null) goto L8;
        return r12;
    L8:
        com.bytedance.android.ec.core.monitor.listener.c r13 = new com.bytedance.android.ec.core.monitor.listener.c(r10, r11, new ECProcessMonitor$actionListener$$inlined$run$lambda$1(r10, r11));
        r0.put(g(r10, r11), r13);
        return r13;
    }

    public static String g(String r1, String r10) {
        return r1 + "_" + r10;
    }

    public static String r(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        int r0 = r10.hashCode();
        if (r0 == (-1309050372)) goto L11;
        if (r0 == 1300332386) goto L8;
    L13:
        String r12 = "Trade";
    L15:
        return r12 + r11;
    L8:
        if (r10.equals("ec_product_detail") == false) goto L13;
        r12 = "Detail";
        goto L15
    L11:
        if (r10.equals("ec_sku") == false) goto L13;
        r12 = "Sku";
        goto L15
    }

    public static void s(long r10, String r11) {
        if (r11 == null) goto L26;
        Set<String> r0 = a;
        if (r0.contains(r11) == true) goto L6;
        return;
    L6:
        if (c != null) goto L8;
        c = h();
    L8:
        PdpMonitorSetting r1 = c;
        if (r1 == null) goto L13;
        Float r12 = r1.getUploadSample();
        if (r12 == null) goto L13;
        float r13 = r12.floatValue();
    L14:
        PdpMonitorSetting r14 = c;
        if (r14 == null) goto L21;
        boolean r15 = true;
        if (r14.getUploadSwitch() != true) goto L21;
        if (Random.Default.nextFloat() >= (r13 / 100.0f)) goto L21;
    L22:
        if (r15 == false) goto L24;
        com.bytedance.android.ec.sdk.helper.g.a.c(r10 - 5000, System.currentTimeMillis());
    L24:
        r0.remove(r11);
        return;
    L21:
        r15 = false;
    L13:
        r13 = 0.0f;
        goto L14
    }

    public static void j(String r10, String r11, long r12, JSONObject r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        boolean r1 = q(com.bytedance.android.ec.core.event.a.KEY_DURATION);
        if (r13 == null) goto L5;
        JSONObject r15 = x0.a(r13);
    L6:
        JSONObject r16 = r15;
        r16.put("event_type", com.bytedance.android.ec.core.event.a.KEY_DURATION);
        r16.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r10);
        r16.put("action_name", r11);
        Unit r17 = Unit.INSTANCE;
        JSONObject r18 = new JSONObject();
        r18.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r12);
        i(r1, 0, "ec_full_trade_process_monitor", r16, r18, r14, r(r10, ""));
        return;
    L5:
        r15 = new JSONObject();
        goto L6
    }

    public static /* synthetic */ void k(String r10, long r11, JSONObject r12, JSONObject r13, int r14) {
        if ((r14 & 8) == 0) goto L5;
        JSONObject r15 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        JSONObject r16 = null;
    L10:
        j("ec_product_detail", r10, r11, r15, r16);
        return;
    L9:
        r16 = r13;
        goto L10
    L5:
        r15 = r12;
        goto L7
    }

    public static /* synthetic */ void n(ActionRateListener r10, String r11, String r12, Integer r13, String r14, JSONObject r15) {
        m(r10, r11, r12, r13, r14, r15, null);
    }

    public static void i(boolean r10, int r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, String r16) {
        Intrinsics.checkNotNullParameter(r12, "serviceName");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        if (r10 == false) goto L8;
        int r17 = ECSdk.a;
        pi.b r18 = (pi.b) ECSdk.a(pi.b.class);
        if (r18 == null) goto L8;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_DATA_TYPE, com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        Unit r0 = Unit.INSTANCE;
        r18.monitorEvent(r12, r13, r14, r15);
    L8:
        if (a() == false) goto L16;
        JSONObject r19 = new JSONObject();
        z1.b(r19, r13);
        String r20 = r19.toString();
        dm.a.b r21 = dm.a.a(r16);
        if (r11 != 0) goto L13;
        r21.i(r20);
        return;
    L13:
        if (r11 != 1) goto L18;
        r21.b(r20, null);
        return;
    L18:
        return;
    }

    public static void m(ActionRateListener r26, String r27, String r28, Integer r29, String r30, JSONObject r31, JSONObject r32) {
        Intrinsics.checkNotNullParameter(r26, "listener");
        Intrinsics.checkNotNullParameter(r27, "pageName");
        Intrinsics.checkNotNullParameter(r28, "actionName");
        Intrinsics.checkNotNullParameter(r30, com.bytedance.android.ec.core.event.a.KEY_MSG);
        boolean r10 = r26.a;
        if (r31 == null) goto L5;
        JSONObject r0 = x0.a(r31);
    L6:
        JSONObject r11 = r0;
        r11.put("event_type", "rate");
        r11.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r27);
        r11.put("action_name", r28);
        if (r29 == null) goto L9;
        r11.put("action_code", r29.intValue());
    L9:
        String r12 = a2.d(r30);
        if (r12 == null) goto L12;
        r11.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r12);
    L12:
        r11.put("rate_type", MessageIndication.STATUS_FAILED);
        Unit r13 = Unit.INSTANCE;
        i(r10, 1, "ec_full_trade_process_monitor", r11, null, r32, r(r27, ""));
        if (r31 == null) goto L15;
        JSONObject r14 = x0.a(r31);
    L16:
        r14.put("event_type", "rate");
        r14.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r27);
        r14.put("action_name", r28);
        if (r29 == null) goto L19;
        r14.put("action_code", r29.intValue());
    L19:
        String r1 = a2.d(r30);
        if (r1 == null) goto L22;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r1);
    L22:
        r14.put("rate_type", MessageIndication.STATUS_FAILED);
        JSONObject r22 = r14;
        i(true, 1, "ec_full_trade_error", r22, null, r32, r(r27, ""));
        return;
    L15:
        r14 = new JSONObject();
        goto L16
    L5:
        r0 = new JSONObject();
        goto L6
    }

    public static void l(String r11, String r12, String r13, JSONObject r14, JSONObject r15, String r16, String r17, int r18) {
        String r10 = null;
        if ((r18 & 8) == 0) goto L5;
        String r19 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        JSONObject r20 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        JSONObject r21 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        String r22 = "";
    L19:
        if ((r18 & 128) != 0) goto L22;
        r10 = r17;
    L22:
        Intrinsics.checkNotNullParameter(r11, "pageName");
        Intrinsics.checkNotNullParameter(r12, "actionName");
        Intrinsics.checkNotNullParameter(r22, "logTag");
        if (r10 == null) goto L26;
        a.add(r10);
    L26:
        if (r20 == null) goto L28;
        JSONObject r23 = x0.a(r20);
    L29:
        r23.put("event_type", IHostStyleUIDepend.TOAST_TYPE_ERROR);
        r23.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r11);
        r23.put("action_name", r12);
        String r1 = a2.d(r23.optString("code"));
        if (r1 == null) goto L40;
        String r110 = r23.optString("action_code");
        if (r110 != null) goto L34;
    L37:
        boolean r111 = true;
    L38:
        if (r111 == false) goto L40;
        KtSafeMethodExtensionKt.safePut(r23, "action_code", r1);
        goto L40
    L34:
        if (r110.length() == 0) goto L37;
        r111 = false;
    L40:
        if (r19 == null) goto L42;
        KtSafeMethodExtensionKt.safePut(r23, com.bytedance.android.ec.core.event.a.KEY_MSG, r19);
    L42:
        Unit r24 = Unit.INSTANCE;
        i(true, 1, "ec_full_trade_error", r23, null, r21, r(r11, r22));
        return;
    L28:
        r23 = new JSONObject();
        goto L29
    L17:
        r22 = r16;
        goto L19
    L13:
        r21 = r15;
        goto L15
    L9:
        r20 = r14;
        goto L11
    L5:
        r19 = r13;
        goto L7
    }
}
