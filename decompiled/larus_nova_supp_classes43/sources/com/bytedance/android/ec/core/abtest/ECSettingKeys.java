package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.anchorv3.m;
import com.bytedance.android.ec.core.buynow.BuyNowSettingConfig;
import com.bytedance.android.ec.core.data.EntranceInfoReportConfig;
import com.bytedance.android.ec.core.data.EntranceInfoWhiteListConfig;
import com.bytedance.android.ec.core.data.EntranceInfoWriteConfig;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.order.OrderCacheConfig;
import com.bytedance.android.ec.core.order.OrderListSettingConfig;
import com.bytedance.android.ec.core.order.OrderSkeletonMonitorConfig;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.promotion.ECSimilarProductFunctionDescriptionViewUri;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECSettingKeys {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final ECSettingKeys j = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class c {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class d {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class e {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class f {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public ECSettingKeys() {
    }

    public static final boolean d() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static com.bytedance.android.ec.core.cart.a h() {
        return (com.bytedance.android.ec.core.cart.a) g.getValue();
    }

    public static final boolean n() {
        return ((Boolean) h.getValue()).booleanValue();
    }

    static {
        j = new ECSettingKeys();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        a = LazyKt.lazy(r0, ECSettingKeys$IESEC_BUY_NOW_OPT_FOOTER_MARGIN$2.INSTANCE);
        b = LazyKt.lazy(r0, ECSettingKeys$BUYNOW_SUPPORT_LONG_LINK$2.INSTANCE);
        c = LazyKt.lazy(r0, ECSettingKeys$PDP_PRELOAD_USE_PITAYA$2.INSTANCE);
        d = LazyKt.lazy(r0, ECSettingKeys$LIVE_FIRST_SHOW_PREFETCH$2.INSTANCE);
        e = LazyKt.lazy(r0, ECSettingKeys$LIVE_PRODUCT_CLICK_PREFETCH$2.INSTANCE);
        f = LazyKt.lazy(ECSettingKeys$BUY_NOW_STARTER_HOLDER_MEMORY_LEAK$2.INSTANCE);
        g = LazyKt.lazy(ECSettingKeys$CART_ENTER_PERF_OPT_V1$2.INSTANCE);
        h = LazyKt.lazy(r0, ECSettingKeys$ECOM_SKU_JS_EVENT_OPT$2.INSTANCE);
        i = LazyKt.lazy(r0, ECSettingKeys$EC_BUY_CJ_PASSTHROUGH$2.INSTANCE);
    }

    @SettingPanel("电商直播间事件中心开关")
    public static final boolean A() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_live_event_center_switch", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("头图收缩配置")
    public static final k A0() {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = new k(0);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        Object r11 = null;
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("pdp_head_shrink_config");     // Catch: Throwable -> L57
        if (r12 != null) goto L9;
    L54:
        Object r13 = null;
    L55:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L57
    L59:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L166
        if (r15 == null) goto L63;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r14) == false) goto L66;
        r14 = null;
    L66:
        if ((r14 instanceof k) == true) goto L68;
        r14 = null;
    L68:
        Object r16 = (k) r14;     // Catch: Throwable -> L166
        if (r16 != null) goto L75;
        Object r17 = com.bytedance.android.ec.base.settings.d.a.get("pdp_head_shrink_config");     // Catch: Throwable -> L166
        if ((r17 instanceof k) == true) goto L74;
        r17 = null;
    L74:
        r16 = (k) r17;     // Catch: Throwable -> L166
    L75:
        if (r16 != null) goto L176;
        int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r19 = com.bytedance.android.ec.base.settings.d.c.get("pdp_head_shrink_config");     // Catch: Throwable -> L130
        if (r19 != null) goto L82;
    L127:
        Object r20 = null;
    L128:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L130
    L132:
        Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L156
        if (r22 == null) goto L136;
        EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r21) == false) goto L139;
        r21 = null;
    L139:
        if ((r21 instanceof k) == true) goto L141;
        r21 = null;
    L141:
        r16 = (k) r21;     // Catch: Throwable -> L156
        if (r16 != null) goto L164;
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r23 == null) goto L147;
        Object r24 = r23.getHostABValue("pdp_head_shrink_config", r1);     // Catch: Throwable -> L156
    L148:
        if (r24 != null) goto L150;
    L155:
        r16 = r1;
        goto L164
    L150:
        if ((r24 instanceof k) == false) goto L153;
        r11 = r24;
    L153:
        Object r25 = (k) r11;     // Catch: Throwable -> L156
        if (r25 == null) goto L155;
    L163:
        r16 = r25;
        goto L164
    L147:
        r24 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("pdp_head_shrink_config", r16);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r19 instanceof k) == true) goto L84;
        Object r26 = null;
    L85:
        r20 = (k) r26;     // Catch: Throwable -> L130
        if (r20 != null) goto L128;
        if ((r19 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r27 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L130
        if ((r27 instanceof k) == true) goto L95;
        r27 = null;
    L95:
        r20 = (k) r27;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r28 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L130
        if ((r28 instanceof k) == true) goto L101;
        r28 = null;
    L101:
        r20 = (k) r28;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r29 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L130
        if ((r29 instanceof k) == true) goto L107;
        r29 = null;
    L107:
        r20 = (k) r29;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r30 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L130
        if ((r30 instanceof k) == true) goto L113;
        r30 = null;
    L113:
        r20 = (k) r30;     // Catch: Throwable -> L130
    L115:
        if ((r19 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r31 = SDKSettingsCacheManager.a().fromJson(r19.toString(), k.class);     // Catch: Throwable -> L123
        if ((r31 instanceof k) == true) goto L121;
        r31 = null;
    L121:
        Object r32 = Result.constructor-impl((k) r31);     // Catch: Throwable -> L123
    L125:
        r20 = r32;
        if (Result.isFailure-impl(r20) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L130
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r19 instanceof JSONArray) == false) goto L127;
    L84:
        r26 = r19;
    L156:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L166
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r35 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L166
        if (r35 == null) goto L161;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r25) == false) goto L163;
        r25 = r1;
    L130:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L156
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return (k) r16;
    L9:
        if ((r12 instanceof k) == true) goto L11;
        Object r37 = null;
    L12:
        r13 = (k) r37;     // Catch: Throwable -> L57
        if (r13 != null) goto L55;
        if ((r12 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L57
        if ((r38 instanceof k) == true) goto L22;
        r38 = null;
    L22:
        r13 = (k) r38;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L57
        if ((r39 instanceof k) == true) goto L28;
        r39 = null;
    L28:
        r13 = (k) r39;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r40 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L57
        if ((r40 instanceof k) == true) goto L34;
        r40 = null;
    L34:
        r13 = (k) r40;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(k.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r41 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L57
        if ((r41 instanceof k) == true) goto L40;
        r41 = null;
    L40:
        r13 = (k) r41;     // Catch: Throwable -> L57
    L42:
        if ((r12 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r42 = SDKSettingsCacheManager.a().fromJson(r12.toString(), k.class);     // Catch: Throwable -> L50
        if ((r42 instanceof k) == true) goto L48;
        r42 = null;
    L48:
        Object r43 = Result.constructor-impl((k) r42);     // Catch: Throwable -> L50
    L52:
        r13 = r43;
        if (Result.isFailure-impl(r13) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L57
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r12 instanceof JSONArray) == false) goto L54;
    L11:
        r37 = r12;
    L57:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r16 = r1;
        goto L176
    }

    @SettingPanel("电商域直播预览流默认清晰度优化v2")
    public static final Map<String, String> B() {
        int r0 = n.a;
        Object r1 = new LinkedHashMap();
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L170
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("ec_live_player_default_resolution");     // Catch: Throwable -> L57
        if (r13 != null) goto L9;
    L54:
        Object r14 = null;
    L55:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L57
    L59:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L170
        if (r16 == null) goto L63;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L170
    L63:
        if (Result.isFailure-impl(r15) == false) goto L66;
        r15 = null;
    L66:
        if (TypeIntrinsics.isMutableMap(r15) == true) goto L68;
        r15 = null;
    L68:
        Object r17 = (Map) r15;     // Catch: Throwable -> L170
        if (r17 != null) goto L71;
    L73:
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("ec_live_player_default_resolution");     // Catch: Throwable -> L170
        if (TypeIntrinsics.isMutableMap(r18) == true) goto L76;
        r18 = null;
    L76:
        r17 = (Map) r18;     // Catch: Throwable -> L170
    L77:
        if (r17 != null) goto L180;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L170
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("ec_live_player_default_resolution");     // Catch: Throwable -> L132
        if (r20 != null) goto L84;
    L129:
        Object r21 = null;
    L130:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L132
    L134:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L160
        if (r23 == null) goto L138;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L160
    L138:
        if (Result.isFailure-impl(r22) == false) goto L141;
        r22 = null;
    L141:
        if (TypeIntrinsics.isMutableMap(r22) == true) goto L143;
        r22 = null;
    L143:
        r17 = (Map) r22;     // Catch: Throwable -> L160
        if (r17 != null) goto L146;
    L148:
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L160
        if (r24 == null) goto L151;
        Object r25 = r24.getHostABValue("ec_live_player_default_resolution", r1);     // Catch: Throwable -> L160
    L152:
        if (r25 != null) goto L154;
    L159:
        r17 = r1;
    L168:
        com.bytedance.android.ec.base.settings.d.d("ec_live_player_default_resolution", r17);     // Catch: Throwable -> L170
        goto L180
    L154:
        if (TypeIntrinsics.isMutableMap(r25) == false) goto L157;
        r12 = r25;
    L157:
        Object r26 = (Map) r12;     // Catch: Throwable -> L160
        if (r26 == null) goto L159;
    L167:
        r17 = r26;
        goto L168
    L151:
        r25 = null;
        goto L152
    L146:
        if (TypeIntrinsics.isMutableMap(r17) == false) goto L148;
    L84:
        if (TypeIntrinsics.isMutableMap(r20) == true) goto L86;
        Object r27 = null;
    L87:
        r21 = (Map) r27;     // Catch: Throwable -> L132
        if (r21 != null) goto L130;
        if ((r20 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r28) == true) goto L97;
        r28 = null;
    L97:
        r21 = (Map) r28;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r29) == true) goto L103;
        r29 = null;
    L103:
        r21 = (Map) r29;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r30 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r30) == true) goto L109;
        r30 = null;
    L109:
        r21 = (Map) r30;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r31 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r31) == true) goto L115;
        r31 = null;
    L115:
        r21 = (Map) r31;     // Catch: Throwable -> L132
    L117:
        if ((r20 instanceof JSONObject) == false) goto L119;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L125
        Object r32 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Map.class);     // Catch: Throwable -> L125
        if (TypeIntrinsics.isMutableMap(r32) == true) goto L123;
        r32 = null;
    L123:
        Object r33 = Result.constructor-impl((Map) r32);     // Catch: Throwable -> L125
    L127:
        r21 = r33;
        if (Result.isFailure-impl(r21) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L132
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r20 instanceof JSONArray) == false) goto L129;
    L86:
        r27 = r20;
    L160:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L170
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r36 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L170
        if (r36 == null) goto L165;
        EnsureManager.ensureNotReachHere(r36);     // Catch: Throwable -> L170
    L165:
        if (Result.isFailure-impl(r26) == false) goto L167;
        r26 = r1;
    L132:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L160
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L180:
        return (Map) r17;
    L71:
        if (TypeIntrinsics.isMutableMap(r17) == false) goto L73;
    L9:
        if (TypeIntrinsics.isMutableMap(r13) == true) goto L11;
        Object r38 = null;
    L12:
        r14 = (Map) r38;     // Catch: Throwable -> L57
        if (r14 != null) goto L55;
        if ((r13 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r39) == true) goto L22;
        r39 = null;
    L22:
        r14 = (Map) r39;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r40) == true) goto L28;
        r40 = null;
    L28:
        r14 = (Map) r40;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r41) == true) goto L34;
        r41 = null;
    L34:
        r14 = (Map) r41;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r42) == true) goto L40;
        r42 = null;
    L40:
        r14 = (Map) r42;     // Catch: Throwable -> L57
    L42:
        if ((r13 instanceof JSONObject) == false) goto L44;
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Map.class);     // Catch: Throwable -> L50
        if (TypeIntrinsics.isMutableMap(r43) == true) goto L48;
        r43 = null;
    L48:
        Object r44 = Result.constructor-impl((Map) r43);     // Catch: Throwable -> L50
    L52:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L57
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r13 instanceof JSONArray) == false) goto L54;
    L11:
        r38 = r13;
    L57:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L170
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L175;
        EnsureManager.ensureNotReachHere(r49);
    L175:
        if (Result.isFailure-impl(r48) == true) goto L178;
        r1 = r48;
    L178:
        r17 = r1;
        goto L180
    }

    @SettingPanel("商详头图视频自动播放-已固化")
    public static final int B0() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r24 = r23;
        if (Result.exceptionOrNull-impl(r24) != null) goto L179;
    L163:
        r19 = r24;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_video_auto_play", r19);     // Catch: Throwable -> L166
        goto L176
    L179:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_video_auto_play", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r24 != null) goto L163;
        r19 = r10;
    L160:
        r24 = r10;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r25 = SDKSettingsCacheManager.b.get("iesec_pdp_video_auto_play");     // Catch: Throwable -> L127
        if (r25 != null) goto L82;
    L124:
        Object r26 = null;
    L125:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L127
    L129:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L153
        if (r28 == null) goto L133;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r27) == false) goto L136;
        r27 = null;
    L136:
        if ((r27 instanceof Integer) == true) goto L138;
        r27 = null;
    L138:
        r24 = (Integer) r27;     // Catch: Throwable -> L153
        if (r24 != null) goto L163;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L153
        Object r30 = jj4.a.a("iesec_pdp_video_auto_play", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r30 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r30 instanceof Integer) == false) goto L148;
        r14 = r30;
    L148:
        Object r31 = (Integer) r14;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        r31 = r10;
    L151:
        r23 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L82:
        if ((r25 instanceof Integer) == true) goto L84;
        Object r32 = null;
    L85:
        r26 = (Integer) r32;     // Catch: Throwable -> L127
        if (r26 != null) goto L125;
        if ((r25 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L95;
        r33 = null;
    L95:
        r26 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L101;
        r34 = null;
    L101:
        r26 = (Integer) r34;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L127
        if ((r35 instanceof Integer) == true) goto L110;
        r35 = null;
    L110:
        r26 = (Integer) r35;     // Catch: Throwable -> L127
    L112:
        if ((r25 instanceof JSONObject) == false) goto L114;
    L177:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r36 instanceof Integer) == true) goto L118;
        r36 = null;
    L118:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L120
    L122:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L127
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r25 instanceof JSONArray) == false) goto L124;
    L84:
        r32 = r25;
    L127:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r43 instanceof Integer) == true) goto L39;
        r43 = null;
    L39:
        r16 = (Integer) r43;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r44 instanceof Integer) == true) goto L47;
        r44 = null;
    L47:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L49
    L51:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L56
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r40 = r15;
    L56:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L171;
        EnsureManager.ensureNotReachHere(r50);
    L171:
        if (Result.isFailure-impl(r49) == true) goto L174;
        r10 = r49;
    L174:
        r19 = r10;
        goto L176
    }

    @SettingPanel("电商域直播预览流默认清晰度优化")
    public static final Map<String, String> C() {
        int r0 = p.a;
        Object r1 = MapsKt.emptyMap();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_live_player_default_resolution", Map.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (Map) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详大字模式适配-已固化")
    public static final int C0() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r24 = r23;
        if (Result.exceptionOrNull-impl(r24) != null) goto L179;
    L163:
        r19 = r24;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_new_large_font_mode", r19);     // Catch: Throwable -> L166
        goto L176
    L179:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_new_large_font_mode", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r24 != null) goto L163;
        r19 = r10;
    L160:
        r24 = r10;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r25 = SDKSettingsCacheManager.b.get("iesec_pdp_new_large_font_mode");     // Catch: Throwable -> L127
        if (r25 != null) goto L82;
    L124:
        Object r26 = null;
    L125:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L127
    L129:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L153
        if (r28 == null) goto L133;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r27) == false) goto L136;
        r27 = null;
    L136:
        if ((r27 instanceof Integer) == true) goto L138;
        r27 = null;
    L138:
        r24 = (Integer) r27;     // Catch: Throwable -> L153
        if (r24 != null) goto L163;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L153
        Object r30 = jj4.a.a("iesec_pdp_new_large_font_mode", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r30 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r30 instanceof Integer) == false) goto L148;
        r14 = r30;
    L148:
        Object r31 = (Integer) r14;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        r31 = r10;
    L151:
        r23 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L82:
        if ((r25 instanceof Integer) == true) goto L84;
        Object r32 = null;
    L85:
        r26 = (Integer) r32;     // Catch: Throwable -> L127
        if (r26 != null) goto L125;
        if ((r25 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L95;
        r33 = null;
    L95:
        r26 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L101;
        r34 = null;
    L101:
        r26 = (Integer) r34;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L127
        if ((r35 instanceof Integer) == true) goto L110;
        r35 = null;
    L110:
        r26 = (Integer) r35;     // Catch: Throwable -> L127
    L112:
        if ((r25 instanceof JSONObject) == false) goto L114;
    L177:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r36 instanceof Integer) == true) goto L118;
        r36 = null;
    L118:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L120
    L122:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L127
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r25 instanceof JSONArray) == false) goto L124;
    L84:
        r32 = r25;
    L127:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r43 instanceof Integer) == true) goto L39;
        r43 = null;
    L39:
        r16 = (Integer) r43;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r44 instanceof Integer) == true) goto L47;
        r44 = null;
    L47:
        Object r45 = Result.constructor-impl((Integer) r44);     // Catch: Throwable -> L49
    L51:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L56
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r40 = r15;
    L56:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L171;
        EnsureManager.ensureNotReachHere(r50);
    L171:
        if (Result.isFailure-impl(r49) == true) goto L174;
        r10 = r49;
    L174:
        r19 = r10;
        goto L176
    }

    @SettingPanel("讲解回放页面消费优化")
    public static final int D() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("ecom_live_replay_page_opt", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("商详底部系统导航栏颜色适配-生效的 schema 集合")
    public static final Map<String, String> D0() {
        int r0 = j.a;
        Object r1 = MapsKt.emptyMap();
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof Map) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Map) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L174
        if ((r19 instanceof Map) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Map) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_pdp_nav_bar_color_schema_map", r18);     // Catch: Throwable -> L174
        goto L184
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_nav_bar_color_schema_map", Map.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_pdp_nav_bar_color_schema_map");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof Map) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Map) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("ec_pdp_nav_bar_color_schema_map", Map.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof Map) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (Map) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof Map) == false) goto L149;
    L85:
        if ((r23 instanceof Map) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Map) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Map) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Map) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Map) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Map) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Map) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Map) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Map) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Map) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Map) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Map) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r18;
    L11:
        if ((r14 instanceof Map) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Map) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Map) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Map) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Map) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Map) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Map) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Map) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Map) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Map) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L191:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Map) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Map) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("抖音&电商Slogan loading是否缓存到内存")
    public static final boolean E() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_loading_persistent_cache", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详讲解回放视频优化-已固化")
    public static final int E0() {
        int r0 = j.a;
        int r1 = ECSdk.a;
        s83.g r10 = (s83.g) ECSdk.a(s83.g.class);
        if (r10 == null) goto L7;
        s83.f r11 = r10.p();
        if (r11 == null) goto L7;
        r11.i();
    L7:
        Object r12 = 0;
        int r13 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r15 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        Object r16 = null;
        r15.getClass();     // Catch: Throwable -> L61
        Object r17 = SDKSettingsCacheManager.b.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L61
        if (r17 != null) goto L16;
    L58:
        Object r18 = null;
    L59:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L61
    L63:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L171
        if (r20 == null) goto L67;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L171
    L67:
        if (Result.isFailure-impl(r19) == false) goto L70;
        r19 = null;
    L70:
        if ((r19 instanceof Integer) == true) goto L72;
        r19 = null;
    L72:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L171
        if (r21 != null) goto L79;
        r15.getClass();     // Catch: Throwable -> L171
        Object r22 = SDKSettingsCacheManager.a.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L171
        if ((r22 instanceof Integer) == true) goto L78;
        r22 = null;
    L78:
        r21 = (Integer) r22;     // Catch: Throwable -> L171
    L79:
        if (r21 != null) goto L181;
        int r23 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L171
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L161:
        if (Result.exceptionOrNull-impl(r25) != null) goto L190;
    L168:
        r21 = r25;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("iesec_pdp_replay_opt", r21);     // Catch: Throwable -> L171
        goto L181
    L190:
        r25 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_replay_opt", Integer.class, r12);     // Catch: Throwable -> L165
    L166:
        if (r25 != null) goto L168;
        r21 = r12;
    L165:
        r25 = r12;
        goto L166
    L182:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r26 = SDKSettingsCacheManager.b.get("iesec_pdp_replay_opt");     // Catch: Throwable -> L132
        if (r26 != null) goto L87;
    L129:
        Object r27 = null;
    L130:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L132
    L134:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L158
        if (r29 == null) goto L138;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r28) == false) goto L141;
        r28 = null;
    L141:
        if ((r28 instanceof Integer) == true) goto L143;
        r28 = null;
    L143:
        Integer r30 = (Integer) r28;     // Catch: Throwable -> L158
        if (r30 == null) goto L146;
        r21 = r30;
        goto L169
    L146:
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L158
        Object r32 = jj4.a.a("iesec_pdp_replay_opt", Integer.class, r12, false);     // Catch: Throwable -> L158
        if (r32 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r32 instanceof Integer) == false) goto L153;
        r16 = r32;
    L153:
        Object r33 = (Integer) r16;     // Catch: Throwable -> L158
        if (r33 != null) goto L156;
        r33 = r12;
    L156:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L158
    L87:
        if ((r26 instanceof Integer) == true) goto L89;
        Object r34 = null;
    L90:
        r27 = (Integer) r34;     // Catch: Throwable -> L132
        if (r27 != null) goto L130;
        if ((r26 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r35 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L132
        if ((r35 instanceof Integer) == true) goto L100;
        r35 = null;
    L100:
        r27 = (Integer) r35;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r36 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L132
        if ((r36 instanceof Integer) == true) goto L106;
        r36 = null;
    L106:
        r27 = (Integer) r36;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L132
        if ((r37 instanceof Integer) == true) goto L115;
        r37 = null;
    L115:
        r27 = (Integer) r37;     // Catch: Throwable -> L132
    L117:
        if ((r26 instanceof JSONObject) == false) goto L119;
    L188:
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r38 instanceof Integer) == true) goto L123;
        r38 = null;
    L123:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L125
    L127:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L132
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r26 instanceof JSONArray) == false) goto L129;
    L89:
        r34 = r26;
    L132:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L158
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return ((Number) r21).intValue();
    L16:
        if ((r17 instanceof Integer) == true) goto L18;
        Object r42 = null;
    L19:
        r18 = (Integer) r42;     // Catch: Throwable -> L61
        if (r18 != null) goto L59;
        if ((r17 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        Float r43 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L61
        if ((r43 instanceof Integer) == true) goto L29;
        r43 = null;
    L29:
        r18 = (Integer) r43;     // Catch: Throwable -> L61
        goto L59
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L37;
        Double r44 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L61
        if ((r44 instanceof Integer) == true) goto L35;
        r44 = null;
    L35:
        r18 = (Integer) r44;     // Catch: Throwable -> L61
        goto L59
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r45 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L61
        if ((r45 instanceof Integer) == true) goto L44;
        r45 = null;
    L44:
        r18 = (Integer) r45;     // Catch: Throwable -> L61
    L46:
        if ((r17 instanceof JSONObject) == false) goto L48;
    L186:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L54
        if ((r46 instanceof Integer) == true) goto L52;
        r46 = null;
    L52:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L54
    L56:
        r18 = r47;
        if (Result.isFailure-impl(r18) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L61
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r17 instanceof JSONArray) == false) goto L58;
    L18:
        r42 = r17;
    L61:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L171
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L176;
        EnsureManager.ensureNotReachHere(r52);
    L176:
        if (Result.isFailure-impl(r51) == true) goto L179;
        r12 = r51;
    L179:
        r21 = r12;
        goto L181
    }

    @SettingPanel("订单列表和订单搜索页面配置")
    public static final OrderListSettingConfig F() {
        int r0 = p.a;
        OrderListSettingConfig r14 = new OrderListSettingConfig(null, null, null, false, false, 0, false, false, false, 0, false, 0, false, false, false, 32767, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        jj4.b r10 = jj4.b.b;     // Catch: Throwable -> L11
        OrderListSettingConfig r11 = r14;
        Object r12 = jj4.a.a("iesec_order_config", OrderListSettingConfig.class, r11, false);     // Catch: Throwable -> L9
        if (r12 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L18:
        return (OrderListSettingConfig) r12;
    L9:
        th = th;
    L13:
        Result.Companion r13 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == false) goto L16;
        r15 = r11;
    L16:
        r12 = r15;
    L11:
        th = th;
        r11 = r14;
        goto L13
    }

    @SettingPanel("商详店铺推荐商品卡曝光点击去掉entrance_info-已固化")
    public static final boolean F0() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L191;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("pdp_recommend_goods_remove_entrance_info", r18);     // Catch: Throwable -> L172
        goto L182
    L191:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_recommend_goods_remove_entrance_info", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r10;
    L166:
        r22 = r10;
        goto L167
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("pdp_recommend_goods_remove_entrance_info");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("pdp_recommend_goods_remove_entrance_info", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r10;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L195:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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
        r10 = r49;
    L180:
        r18 = r10;
        goto L182
    }

    @SettingPanel("订单列表slice render info时机")
    public static final boolean G() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("order_create_slice_render_info");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("order_create_slice_render_info");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("order_create_slice_render_info", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("order_create_slice_render_info", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("order_create_slice_render_info");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("order_create_slice_render_info", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详筛查btm及埋点关系")
    public static final boolean G0() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("pdp_save_btm_event_relations", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_save_btm_event_relations", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("pdp_save_btm_event_relations");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("pdp_save_btm_event_relations", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("订单列表缓存配置")
    public static final OrderCacheConfig H() {
        int r0 = p.a;
        Object r10 = new OrderCacheConfig(0, false, 0, null, false, 31, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_list_cache_config", OrderCacheConfig.class, r10, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (OrderCacheConfig) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r12 = r10;
        goto L14
    }

    @SettingPanel("商详顶部新增高斯模糊-已固化")
    public static final boolean H0() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("pdp_top_guide_gauss");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
    L56:
        Object r16 = null;
    L57:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L172
        if (r18 == null) goto L65;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r17) == false) goto L68;
        r17 = null;
    L68:
        if ((r17 instanceof Boolean) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (Boolean) r17;     // Catch: Throwable -> L172
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L172
        Object r20 = SDKSettingsCacheManager.a.get("pdp_top_guide_gauss");     // Catch: Throwable -> L172
        if ((r20 instanceof Boolean) == true) goto L76;
        r20 = null;
    L76:
        r19 = (Boolean) r20;     // Catch: Throwable -> L172
    L77:
        if (r19 != null) goto L182;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L172
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r23) != null) goto L191;
    L169:
        r19 = r23;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("pdp_top_guide_gauss", r19);     // Catch: Throwable -> L172
        goto L182
    L191:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pdp_top_guide_gauss", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r23 != null) goto L169;
        r19 = r10;
    L166:
        r23 = r10;
        goto L167
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r24 = SDKSettingsCacheManager.b.get("pdp_top_guide_gauss");     // Catch: Throwable -> L133
        if (r24 != null) goto L85;
    L130:
        Object r25 = null;
    L131:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L133
    L135:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L159
        if (r27 == null) goto L139;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r26) == false) goto L142;
        r26 = null;
    L142:
        if ((r26 instanceof Boolean) == true) goto L144;
        r26 = null;
    L144:
        r23 = (Boolean) r26;     // Catch: Throwable -> L159
        if (r23 != null) goto L169;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L159
        Object r29 = jj4.a.a("pdp_top_guide_gauss", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r29 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r29 instanceof Boolean) == false) goto L154;
        r14 = r29;
    L154:
        Object r30 = (Boolean) r14;     // Catch: Throwable -> L159
        if (r30 != null) goto L157;
        r30 = r10;
    L157:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L159
    L85:
        if ((r24 instanceof Boolean) == true) goto L87;
        Object r31 = null;
    L88:
        r25 = (Boolean) r31;     // Catch: Throwable -> L133
        if (r25 != null) goto L131;
        if ((r24 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L98;
        r32 = null;
    L98:
        r25 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L104;
        r33 = null;
    L104:
        r25 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Boolean) r34;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L133
        if ((r35 instanceof Boolean) == true) goto L116;
        r35 = null;
    L116:
        r25 = (Boolean) r35;     // Catch: Throwable -> L133
    L118:
        if ((r24 instanceof JSONObject) == false) goto L120;
    L189:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r36 instanceof Boolean) == true) goto L124;
        r36 = null;
    L124:
        Object r37 = Result.constructor-impl((Boolean) r36);     // Catch: Throwable -> L126
    L128:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L133
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r24 instanceof JSONArray) == false) goto L130;
    L87:
        r31 = r24;
    L133:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L159
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r19).booleanValue();
    L11:
        if ((r15 instanceof Boolean) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Boolean) r40;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r43 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L36;
        r43 = null;
    L36:
        r16 = (Boolean) r43;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r44 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Boolean) == true) goto L42;
        r44 = null;
    L42:
        r16 = (Boolean) r44;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L195:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r45 instanceof Boolean) == true) goto L50;
        r45 = null;
    L50:
        Object r46 = Result.constructor-impl((Boolean) r45);     // Catch: Throwable -> L52
    L54:
        r16 = r46;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L59
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r40 = r15;
    L59:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L172
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L177;
        EnsureManager.ensureNotReachHere(r51);
    L177:
        if (Result.isFailure-impl(r50) == true) goto L180;
        r10 = r50;
    L180:
        r19 = r10;
        goto L182
    }

    @SettingPanel("订单列表首屏耗时优化")
    public static final boolean I() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_list_duration_perf", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("讲解回放多码率开关")
    public static final boolean I0() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_playback_video_mbr_switch", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("订单列表预加载任务优化")
    public static final boolean J() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_list_preload_task_opt", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("PriceView 统一重构")
    public static final boolean J0() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("shopping_priceview_refactor", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("订单列表组件化流式请求tab_id控制")
    public static final List<Integer> K() {
        int r0 = p.a;
        Object r1 = CollectionsKt.emptyList();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_ecommerce_order_stream_tab_config", List.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("找相似功能说明落地页")
    public static final ECSimilarProductFunctionDescriptionViewUri K0() {
        int r0 = e.a;
        int r1 = w0.a;
        Object r10 = (ECSimilarProductFunctionDescriptionViewUri) w0.b("{\"white_background_uri\":\"sslocal://webcast_lynxview?type=popup&height_percent=73&gravity=bottom&mask_alpha=0.5&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_address_aweme%2Faddress%2Flist%2Ftemplate.js&disable_input_scroll=1&window_floating=0&intercept_back=1&add_safe_area_height=0&input_smart_scroll=0&screen_size_adaptation=1&hide_nav_bar=1&status_bar_color=black&trans_status_bar=1&web_bg_color=%23ffffffff&top_level=1&use_real_screen_height=1&enter_from=live&new_source_type=live&enter_from_live_saas=&support_select=1&selected_id=&product_id=&shop_id=&previous_new_source_type=&need_show_poi=1&session_id=&store_id=&select_area_type=&hourly_purchase_shop_id=\"}", ECSimilarProductFunctionDescriptionViewUri.class);
        if (r10 == null) goto L17;
        int r11 = p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L9
        Object r14 = jj4.a.a("ec_commerce_similar_product_function_description_view_uri", ECSimilarProductFunctionDescriptionViewUri.class, r10, false);     // Catch: Throwable -> L9
        if (r14 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        ECSimilarProductFunctionDescriptionViewUri r15 = (ECSimilarProductFunctionDescriptionViewUri) r14;
        if (r15 == null) goto L17;
        return r15;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L14;
        r10 = r17;
    L14:
        r14 = r10;
    L17:
        int r18 = p.a;
        Object r19 = null;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L20
        jj4.b r21 = jj4.b.b;     // Catch: Throwable -> L20
        Object r22 = jj4.a.a(" ec_commerce_similar_product_function_description_view_uri", ECSimilarProductFunctionDescriptionViewUri.class, null, false);     // Catch: Throwable -> L20
    L27:
        return (ECSimilarProductFunctionDescriptionViewUri) r22;
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r24) == true) goto L25;
        r19 = r24;
    L25:
        r22 = r19;
        goto L27
    }

    @SettingPanel("订单列表白屏监控参数")
    public static final OrderSkeletonMonitorConfig L() {
        int r0 = j.a;
        Object r1 = new OrderSkeletonMonitorConfig(false, 0, 0, 0, 0, 31, null);
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L59
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
        if ((r16 instanceof OrderSkeletonMonitorConfig) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (OrderSkeletonMonitorConfig) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L172
        if ((r19 instanceof OrderSkeletonMonitorConfig) == true) goto L76;
        r19 = null;
    L76:
        r18 = (OrderSkeletonMonitorConfig) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_order_list_skeleton_monitor_config", r18);     // Catch: Throwable -> L172
        goto L182
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_order_list_skeleton_monitor_config", OrderSkeletonMonitorConfig.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_order_list_skeleton_monitor_config");     // Catch: Throwable -> L133
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
        if ((r25 instanceof OrderSkeletonMonitorConfig) == true) goto L144;
        r25 = null;
    L144:
        r22 = (OrderSkeletonMonitorConfig) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("iesec_order_list_skeleton_monitor_config", OrderSkeletonMonitorConfig.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof OrderSkeletonMonitorConfig) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (OrderSkeletonMonitorConfig) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof OrderSkeletonMonitorConfig) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (OrderSkeletonMonitorConfig) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof OrderSkeletonMonitorConfig) == true) goto L98;
        r31 = null;
    L98:
        r24 = (OrderSkeletonMonitorConfig) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof OrderSkeletonMonitorConfig) == true) goto L104;
        r32 = null;
    L104:
        r24 = (OrderSkeletonMonitorConfig) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof OrderSkeletonMonitorConfig) == true) goto L110;
        r33 = null;
    L110:
        r24 = (OrderSkeletonMonitorConfig) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof OrderSkeletonMonitorConfig) == true) goto L116;
        r34 = null;
    L116:
        r24 = (OrderSkeletonMonitorConfig) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L191:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), OrderSkeletonMonitorConfig.class);     // Catch: Throwable -> L126
        if ((r35 instanceof OrderSkeletonMonitorConfig) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((OrderSkeletonMonitorConfig) r35);     // Catch: Throwable -> L126
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
        return (OrderSkeletonMonitorConfig) r18;
    L11:
        if ((r14 instanceof OrderSkeletonMonitorConfig) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (OrderSkeletonMonitorConfig) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof OrderSkeletonMonitorConfig) == true) goto L24;
        r40 = null;
    L24:
        r15 = (OrderSkeletonMonitorConfig) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof OrderSkeletonMonitorConfig) == true) goto L30;
        r41 = null;
    L30:
        r15 = (OrderSkeletonMonitorConfig) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof OrderSkeletonMonitorConfig) == true) goto L36;
        r42 = null;
    L36:
        r15 = (OrderSkeletonMonitorConfig) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(OrderSkeletonMonitorConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof OrderSkeletonMonitorConfig) == true) goto L42;
        r43 = null;
    L42:
        r15 = (OrderSkeletonMonitorConfig) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L183:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), OrderSkeletonMonitorConfig.class);     // Catch: Throwable -> L52
        if ((r44 instanceof OrderSkeletonMonitorConfig) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((OrderSkeletonMonitorConfig) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("Android获取ttnet监控网络耗时开放的path")
    public static final String L0() {
        int r0 = j.a;
        Object r1 = "{\"paths\":[\"\"]}";
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L59
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
        if ((r16 instanceof String) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (String) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L172
        if ((r19 instanceof String) == true) goto L76;
        r19 = null;
    L76:
        r18 = (String) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_ttnet_monitor_path_list", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_ttnet_monitor_path_list", String.class, "{\"paths\":[\"\"]}");     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = "{\"paths\":[\"\"]}";
    L166:
        r22 = "{\"paths\":[\"\"]}";
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_ttnet_monitor_path_list");     // Catch: Throwable -> L133
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
        if ((r25 instanceof String) == true) goto L144;
        r25 = null;
    L144:
        r22 = (String) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_ttnet_monitor_path_list", String.class, "{\"paths\":[\"\"]}", false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof String) == false) goto L154;
        r13 = r28;
    L154:
        String r29 = (String) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = "{\"paths\":[\"\"]}";
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof String) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (String) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof String) == true) goto L98;
        r31 = null;
    L98:
        r24 = (String) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof String) == true) goto L104;
        r32 = null;
    L104:
        r24 = (String) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof String) == true) goto L110;
        r33 = null;
    L110:
        r24 = (String) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof String) == true) goto L116;
        r34 = null;
    L116:
        r24 = (String) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), String.class);     // Catch: Throwable -> L126
        if ((r35 instanceof String) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((String) r35);     // Catch: Throwable -> L126
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
        return (String) r18;
    L11:
        if ((r14 instanceof String) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (String) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof String) == true) goto L24;
        r40 = null;
    L24:
        r15 = (String) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof String) == true) goto L30;
        r41 = null;
    L30:
        r15 = (String) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof String) == true) goto L36;
        r42 = null;
    L36:
        r15 = (String) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof String) == true) goto L42;
        r43 = null;
    L42:
        r15 = (String) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), String.class);     // Catch: Throwable -> L52
        if ((r44 instanceof String) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((String) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详返回动画修复")
    public static final boolean M() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L59
        if (r13 != null) goto L11;
    L56:
        Object r14 = null;
    L57:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L59
    L61:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L172
        if (r16 == null) goto L65;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r15) == false) goto L68;
        r15 = null;
    L68:
        if ((r15 instanceof Boolean) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L172
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L172
        Object r18 = SDKSettingsCacheManager.a.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L172
        if ((r18 instanceof Boolean) == true) goto L76;
        r18 = null;
    L76:
        r17 = (Boolean) r18;     // Catch: Throwable -> L172
    L77:
        if (r17 != null) goto L182;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L172
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r21) != null) goto L185;
    L169:
        r17 = r21;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_fix_close_anim_v2", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_fix_close_anim_v2", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_pdp_fix_close_anim_v2");     // Catch: Throwable -> L133
        if (r22 != null) goto L85;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L159
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof Boolean) == true) goto L144;
        r24 = null;
    L144:
        r21 = (Boolean) r24;     // Catch: Throwable -> L159
        if (r21 != null) goto L169;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L159
        Object r27 = jj4.a.a("ec_pdp_fix_close_anim_v2", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r27 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r27 instanceof Boolean) == false) goto L154;
        r12 = r27;
    L154:
        Object r28 = (Boolean) r12;     // Catch: Throwable -> L159
        if (r28 != null) goto L157;
        r28 = r1;
    L157:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L159
    L85:
        if ((r22 instanceof Boolean) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (Boolean) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof Boolean) == true) goto L98;
        r30 = null;
    L98:
        r23 = (Boolean) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L104;
        r31 = null;
    L104:
        r23 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L110;
        r32 = null;
    L110:
        r23 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L116;
        r33 = null;
    L116:
        r23 = (Boolean) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L183:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r34 instanceof Boolean) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L126
    L128:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L133
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L87:
        r29 = r22;
    L133:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L159
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r17).booleanValue();
    L11:
        if ((r13 instanceof Boolean) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (Boolean) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof Boolean) == true) goto L24;
        r39 = null;
    L24:
        r14 = (Boolean) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L30;
        r40 = null;
    L30:
        r14 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L36;
        r41 = null;
    L36:
        r14 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L42;
        r42 = null;
    L42:
        r14 = (Boolean) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r43 instanceof Boolean) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L52
    L54:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L59
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r13 instanceof JSONArray) == false) goto L56;
    L13:
        r38 = r13;
    L59:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L172
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L177;
        EnsureManager.ensureNotReachHere(r49);
    L177:
        if (Result.isFailure-impl(r48) == true) goto L180;
        r1 = r48;
    L180:
        r17 = r1;
        goto L182
    }

    @SettingPanel("极致提单缓存配置")
    public static final UltimateBuyCacheConfig M0() {
        int r0 = j.a;
        Object r1 = new UltimateBuyCacheConfig(0, 0, null, 7, null);
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ultimate_buy_cache_config");     // Catch: Throwable -> L59
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
        if ((r16 instanceof UltimateBuyCacheConfig) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (UltimateBuyCacheConfig) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ultimate_buy_cache_config");     // Catch: Throwable -> L172
        if ((r19 instanceof UltimateBuyCacheConfig) == true) goto L76;
        r19 = null;
    L76:
        r18 = (UltimateBuyCacheConfig) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ultimate_buy_cache_config", r18);     // Catch: Throwable -> L172
        goto L182
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ultimate_buy_cache_config", UltimateBuyCacheConfig.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ultimate_buy_cache_config");     // Catch: Throwable -> L133
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
        if ((r25 instanceof UltimateBuyCacheConfig) == true) goto L144;
        r25 = null;
    L144:
        r22 = (UltimateBuyCacheConfig) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ultimate_buy_cache_config", UltimateBuyCacheConfig.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof UltimateBuyCacheConfig) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (UltimateBuyCacheConfig) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof UltimateBuyCacheConfig) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (UltimateBuyCacheConfig) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof UltimateBuyCacheConfig) == true) goto L98;
        r31 = null;
    L98:
        r24 = (UltimateBuyCacheConfig) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof UltimateBuyCacheConfig) == true) goto L104;
        r32 = null;
    L104:
        r24 = (UltimateBuyCacheConfig) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof UltimateBuyCacheConfig) == true) goto L110;
        r33 = null;
    L110:
        r24 = (UltimateBuyCacheConfig) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof UltimateBuyCacheConfig) == true) goto L116;
        r34 = null;
    L116:
        r24 = (UltimateBuyCacheConfig) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L191:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), UltimateBuyCacheConfig.class);     // Catch: Throwable -> L126
        if ((r35 instanceof UltimateBuyCacheConfig) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((UltimateBuyCacheConfig) r35);     // Catch: Throwable -> L126
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
        return (UltimateBuyCacheConfig) r18;
    L11:
        if ((r14 instanceof UltimateBuyCacheConfig) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (UltimateBuyCacheConfig) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof UltimateBuyCacheConfig) == true) goto L24;
        r40 = null;
    L24:
        r15 = (UltimateBuyCacheConfig) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof UltimateBuyCacheConfig) == true) goto L30;
        r41 = null;
    L30:
        r15 = (UltimateBuyCacheConfig) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof UltimateBuyCacheConfig) == true) goto L36;
        r42 = null;
    L36:
        r15 = (UltimateBuyCacheConfig) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(UltimateBuyCacheConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof UltimateBuyCacheConfig) == true) goto L42;
        r43 = null;
    L42:
        r15 = (UltimateBuyCacheConfig) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L183:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), UltimateBuyCacheConfig.class);     // Catch: Throwable -> L52
        if ((r44 instanceof UltimateBuyCacheConfig) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((UltimateBuyCacheConfig) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详视频UI调整")
    public static final int N() {
        int r0 = j.a;
        Lazy r1 = ECAppInfoService.a;
        Object r10 = Integer.valueOf(ECAppInfoService.h() ? 1 : 0);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L56
        Object r15 = SDKSettingsCacheManager.b.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L56
        if (r15 != null) goto L11;
    L53:
        Object r16 = null;
    L54:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L56
    L58:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r18 == null) goto L62;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r17) == false) goto L65;
        r17 = null;
    L65:
        if ((r17 instanceof Integer) == true) goto L67;
        r17 = null;
    L67:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L166
        if (r19 != null) goto L74;
        r13.getClass();     // Catch: Throwable -> L166
        Object r20 = SDKSettingsCacheManager.a.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L166
        if ((r20 instanceof Integer) == true) goto L73;
        r20 = null;
    L73:
        r19 = (Integer) r20;     // Catch: Throwable -> L166
    L74:
        if (r19 != null) goto L176;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L166
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r23) != null) goto L185;
    L163:
        r19 = r23;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_pdp_video_ui_opt", r19);     // Catch: Throwable -> L166
        goto L176
    L185:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_video_ui_opt", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r23 != null) goto L163;
        r19 = r10;
    L160:
        r23 = r10;
        goto L161
    L177:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r24 = SDKSettingsCacheManager.b.get("ec_pdp_video_ui_opt");     // Catch: Throwable -> L127
        if (r24 != null) goto L82;
    L124:
        Object r25 = null;
    L125:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L127
    L129:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L153
        if (r27 == null) goto L133;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r26) == false) goto L136;
        r26 = null;
    L136:
        if ((r26 instanceof Integer) == true) goto L138;
        r26 = null;
    L138:
        r23 = (Integer) r26;     // Catch: Throwable -> L153
        if (r23 != null) goto L163;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("ec_pdp_video_ui_opt", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r14 = r29;
    L148:
        Object r30 = (Integer) r14;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r10;
    L151:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r24 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r25 = (Integer) r31;     // Catch: Throwable -> L127
        if (r25 != null) goto L125;
        if ((r24 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r25 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r25 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r25 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r24 instanceof JSONObject) == false) goto L114;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r25 = r36;
        if (Result.isFailure-impl(r25) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r24 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r24;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r19).intValue();
    L11:
        if ((r15 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r16 = (Integer) r39;     // Catch: Throwable -> L56
        if (r16 != null) goto L54;
        if ((r15 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r16 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r16 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r16 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r15 instanceof JSONObject) == false) goto L43;
    L181:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r16 = r44;
        if (Result.isFailure-impl(r16) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r15 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r15;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r10 = r48;
    L174:
        r19 = r10;
        goto L176
    }

    @SettingPanel("商详直播小窗底部 margin")
    public static final int O() {
        int r0 = j.a;
        Object r1 = 103;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_pdp_live_window_bottom_margin", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_live_window_bottom_margin", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_pdp_live_window_bottom_margin");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        r22 = (Integer) r25;     // Catch: Throwable -> L153
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_pdp_live_window_bottom_margin", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r13 = r28;
    L148:
        Object r29 = (Integer) r13;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r24 = (Integer) r30;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r23;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r15 = (Integer) r38;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r14;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("商品卡移除无用蒙层")
    public static final boolean P() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_promotion_card_remove_mask", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("交易链路SaaS AB实验key")
    public static final List<String> Q() {
        int r0 = j.a;
        Object r1 = CollectionsKt.listOf(new String[]{"iesec_saas_shop_comment", "iesec_saas_pdp_search", "debug_flag"});
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_saas_ab_keys");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof List) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (List) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("iesec_saas_ab_keys");     // Catch: Throwable -> L174
        if ((r19 instanceof List) == true) goto L76;
        r19 = null;
    L76:
        r18 = (List) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L187;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_saas_ab_keys", r18);     // Catch: Throwable -> L174
        goto L184
    L187:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_saas_ab_keys", List.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_saas_ab_keys");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof List) == true) goto L144;
        r25 = null;
    L144:
        r22 = (List) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("iesec_saas_ab_keys", List.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof List) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (List) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof List) == false) goto L149;
    L85:
        if ((r23 instanceof List) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (List) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof List) == true) goto L98;
        r31 = null;
    L98:
        r24 = (List) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof List) == true) goto L104;
        r32 = null;
    L104:
        r24 = (List) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof List) == true) goto L110;
        r33 = null;
    L110:
        r24 = (List) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof List) == true) goto L116;
        r34 = null;
    L116:
        r24 = (List) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L197:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), List.class);     // Catch: Throwable -> L126
        if ((r35 instanceof List) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((List) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r18;
    L11:
        if ((r14 instanceof List) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (List) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof List) == true) goto L24;
        r40 = null;
    L24:
        r15 = (List) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof List) == true) goto L30;
        r41 = null;
    L30:
        r15 = (List) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof List) == true) goto L36;
        r42 = null;
    L36:
        r15 = (List) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof List) == true) goto L42;
        r43 = null;
    L42:
        r15 = (List) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L185:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), List.class);     // Catch: Throwable -> L52
        if ((r44 instanceof List) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((List) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("电商saas接入直播小窗")
    public static final int R() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("ec_saas_live_window_enable", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("sku加购引导的频控逻辑")
    public static final List<String> S() {
        int r0 = p.a;
        Object r1 = CollectionsKt.listOf(new String[]{"1", com.bytedance.android.ec.core.event.a.VALUE_VIRTUAL_PRODUCT, com.bytedance.android.ec.core.event.a.VALUE_JOIN_MEMBER});
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("sku_add_cart_guide_config", List.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("一步提单&sku大字体")
    public static int T() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_sku_buy_big_font");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_sku_buy_big_font");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_sku_buy_big_font", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_buy_big_font", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_sku_buy_big_font");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("ec_sku_buy_big_font", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("独立端新设计语言二期")
    public static int U() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("legou_sku_buy_layout_opt_v2");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("legou_sku_buy_layout_opt_v2", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("legou_sku_buy_layout_opt_v2", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @SettingPanel("一步提单 & SKU 缩放优化")
    public static boolean V() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
    L56:
        Object r16 = null;
    L57:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L172
        if (r18 == null) goto L65;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r17) == false) goto L68;
        r17 = null;
    L68:
        if ((r17 instanceof Boolean) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (Boolean) r17;     // Catch: Throwable -> L172
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L172
        Object r20 = SDKSettingsCacheManager.a.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L172
        if ((r20 instanceof Boolean) == true) goto L76;
        r20 = null;
    L76:
        r19 = (Boolean) r20;     // Catch: Throwable -> L172
    L77:
        if (r19 != null) goto L182;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L172
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r23) != null) goto L191;
    L169:
        r19 = r23;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_sku_buy_scale_opt", r19);     // Catch: Throwable -> L172
        goto L182
    L191:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_buy_scale_opt", Boolean.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r23 != null) goto L169;
        r19 = r10;
    L166:
        r23 = r10;
        goto L167
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r24 = SDKSettingsCacheManager.b.get("ec_sku_buy_scale_opt");     // Catch: Throwable -> L133
        if (r24 != null) goto L85;
    L130:
        Object r25 = null;
    L131:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L133
    L135:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L159
        if (r27 == null) goto L139;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r26) == false) goto L142;
        r26 = null;
    L142:
        if ((r26 instanceof Boolean) == true) goto L144;
        r26 = null;
    L144:
        r23 = (Boolean) r26;     // Catch: Throwable -> L159
        if (r23 != null) goto L169;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L159
        Object r29 = jj4.a.a("ec_sku_buy_scale_opt", Boolean.class, r10, false);     // Catch: Throwable -> L159
        if (r29 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r29 instanceof Boolean) == false) goto L154;
        r14 = r29;
    L154:
        Object r30 = (Boolean) r14;     // Catch: Throwable -> L159
        if (r30 != null) goto L157;
        r30 = r10;
    L157:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L159
    L85:
        if ((r24 instanceof Boolean) == true) goto L87;
        Object r31 = null;
    L88:
        r25 = (Boolean) r31;     // Catch: Throwable -> L133
        if (r25 != null) goto L131;
        if ((r24 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L98;
        r32 = null;
    L98:
        r25 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L104;
        r33 = null;
    L104:
        r25 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Boolean) r34;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L133
        if ((r35 instanceof Boolean) == true) goto L116;
        r35 = null;
    L116:
        r25 = (Boolean) r35;     // Catch: Throwable -> L133
    L118:
        if ((r24 instanceof JSONObject) == false) goto L120;
    L189:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r36 instanceof Boolean) == true) goto L124;
        r36 = null;
    L124:
        Object r37 = Result.constructor-impl((Boolean) r36);     // Catch: Throwable -> L126
    L128:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L133
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r24 instanceof JSONArray) == false) goto L130;
    L87:
        r31 = r24;
    L133:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L159
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r19).booleanValue();
    L11:
        if ((r15 instanceof Boolean) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (Boolean) r40;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L24;
        r41 = null;
    L24:
        r16 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L30;
        r42 = null;
    L30:
        r16 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r43 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L36;
        r43 = null;
    L36:
        r16 = (Boolean) r43;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r44 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r44 instanceof Boolean) == true) goto L42;
        r44 = null;
    L42:
        r16 = (Boolean) r44;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L195:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r45 instanceof Boolean) == true) goto L50;
        r45 = null;
    L50:
        Object r46 = Result.constructor-impl((Boolean) r45);     // Catch: Throwable -> L52
    L54:
        r16 = r46;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L59
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r40 = r15;
    L59:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L172
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L177;
        EnsureManager.ensureNotReachHere(r51);
    L177:
        if (Result.isFailure-impl(r50) == true) goto L180;
        r10 = r50;
    L180:
        r19 = r10;
        goto L182
    }

    @SettingPanel("sku拉屏高scenetype名单")
    public static List W() {
        int r0 = j.a;
        Object r1 = CollectionsKt.listOf(new String[]{"101", "102", "105", "106"});
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof List) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (List) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L174
        if ((r19 instanceof List) == true) goto L76;
        r19 = null;
    L76:
        r18 = (List) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L189;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_sku_height_imp_scene_list", r18);     // Catch: Throwable -> L174
        goto L184
    L189:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_height_imp_scene_list", List.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L193:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_sku_height_imp_scene_list");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof List) == true) goto L144;
        r25 = null;
    L144:
        r22 = (List) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("ec_sku_height_imp_scene_list", List.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof List) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (List) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof List) == false) goto L149;
    L85:
        if ((r23 instanceof List) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (List) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof List) == true) goto L98;
        r31 = null;
    L98:
        r24 = (List) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof List) == true) goto L104;
        r32 = null;
    L104:
        r24 = (List) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof List) == true) goto L110;
        r33 = null;
    L110:
        r24 = (List) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof List) == true) goto L116;
        r34 = null;
    L116:
        r24 = (List) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L185:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), List.class);     // Catch: Throwable -> L126
        if ((r35 instanceof List) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((List) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r18;
    L11:
        if ((r14 instanceof List) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (List) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof List) == true) goto L24;
        r40 = null;
    L24:
        r15 = (List) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof List) == true) goto L30;
        r41 = null;
    L30:
        r15 = (List) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof List) == true) goto L36;
        r42 = null;
    L36:
        r15 = (List) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof List) == true) goto L42;
        r43 = null;
    L42:
        r15 = (List) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L187:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), List.class);     // Catch: Throwable -> L52
        if ((r44 instanceof List) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((List) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("sku拉屏高高度比例")
    public static int X() {
        int r0 = j.a;
        Object r1 = 83;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_sku_height_percent");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_sku_height_percent");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_sku_height_percent", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_sku_height_percent", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_sku_height_percent");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        r22 = (Integer) r25;     // Catch: Throwable -> L153
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_sku_height_percent", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r13 = r28;
    L148:
        Object r29 = (Integer) r13;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r24 = (Integer) r30;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r23;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r15 = (Integer) r38;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r14;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("Sku组件化页面配置")
    public static final com.bytedance.android.ec.core.sku.e Y() {
        int r0 = p.a;
        Object r1 = new com.bytedance.android.ec.core.sku.e(0);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_sku_page_config", com.bytedance.android.ec.core.sku.e.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (com.bytedance.android.ec.core.sku.e) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("SKU模版预加载配置")
    public static final List<Map<String, Object>> Z() {
        int r0 = p.a;
        Object r1 = com.bytedance.android.ec.core.sku.f.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_sku_slice_templates", List.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("电商半屏页面FPS监控是否采用校准方案")
    public static final boolean a() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("live_ec_fps_monitor_adjust", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("Tabkit 优化配置")
    public static final String a0() {
        int r0 = p.a;
        Object r1 = "{}";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_tabkit_config", String.class, "{}", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("预约成功弹窗中心文案")
    public static final ECResultDialogContentVO b() {
        int r0 = c.a;
        int r1 = w0.a;
        Object r10 = (ECResultDialogContentVO) w0.b("{\"title\":\"预约成功\",\"content\":\"1.预售开始的提醒会以短信与APP消息的方式通知您～请及时关注\\n2.您可以APP消息里找到已预约商品进行查看\",\"confirm\":\"我知道了\"}", ECResultDialogContentVO.class);
        if (r10 == null) goto L17;
        int r11 = p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L9
        Object r14 = jj4.a.a("appointment_result_dialog", ECResultDialogContentVO.class, r10, false);     // Catch: Throwable -> L9
        if (r14 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        ECResultDialogContentVO r15 = (ECResultDialogContentVO) r14;
        if (r15 == null) goto L17;
        return r15;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L14;
        r10 = r17;
    L14:
        r14 = r10;
    L17:
        int r18 = p.a;
        Object r19 = null;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L20
        jj4.b r21 = jj4.b.b;     // Catch: Throwable -> L20
        Object r22 = jj4.a.a(" appointment_result_dialog", ECResultDialogContentVO.class, null, false);     // Catch: Throwable -> L20
    L27:
        return (ECResultDialogContentVO) r22;
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r24) == true) goto L25;
        r19 = r24;
    L25:
        r22 = r19;
        goto L27
    }

    @SettingPanel("修复 ViewConfiguration Crash")
    public static int b0() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = 0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L56
        Object r13 = SDKSettingsCacheManager.b.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L56
        if (r13 != null) goto L11;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Integer) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L74;
        r11.getClass();     // Catch: Throwable -> L166
        Object r18 = SDKSettingsCacheManager.a.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L166
        if ((r18 instanceof Integer) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Integer) r18;     // Catch: Throwable -> L166
    L74:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L166
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r21) != null) goto L179;
    L163:
        r17 = r21;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_fix_viewconf_crash", r17);     // Catch: Throwable -> L166
        goto L176
    L179:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fix_viewconf_crash", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r21 != null) goto L163;
        r17 = r1;
    L160:
        r21 = r1;
        goto L161
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r22 = SDKSettingsCacheManager.b.get("ec_fix_viewconf_crash");     // Catch: Throwable -> L127
        if (r22 != null) goto L82;
    L124:
        Object r23 = null;
    L125:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L127
    L129:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L153
        if (r25 == null) goto L133;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r24) == false) goto L136;
        r24 = null;
    L136:
        if ((r24 instanceof Integer) == true) goto L138;
        r24 = null;
    L138:
        Integer r26 = (Integer) r24;     // Catch: Throwable -> L153
        if (r26 == null) goto L141;
        r17 = r26;
        goto L164
    L141:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_fix_viewconf_crash", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r12 = r28;
    L148:
        Object r29 = (Integer) r12;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r21 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r22 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r23 = (Integer) r30;     // Catch: Throwable -> L127
        if (r23 != null) goto L125;
        if ((r22 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r23 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r23 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r23 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r22 instanceof JSONObject) == false) goto L114;
    L177:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r22 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r22;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r17).intValue();
    L11:
        if ((r13 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (Integer) r38;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r14 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r14 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r14 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L189:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r14 = r43;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r13;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r17 = r1;
        goto L176
    }

    @SettingPanel("Android电商业务网络接口监控开关")
    public static final boolean c() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_business_net_monitor_switch", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_business_net_monitor_switch", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_business_net_monitor_switch");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_business_net_monitor_switch", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("橱窗商品图片预加载")
    public static final int c0() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("ec_window_image_preload_enable", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("橱窗视频商卡使用电商播放器")
    public static final boolean d0() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("window_video_product_use_ec_player", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("组件化提单页模版预加载Fields配置")
    public static final String e() {
        int r0 = j.a;
        Object r1 = "{}";
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L59
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
        if ((r16 instanceof String) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (String) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L172
        if ((r19 instanceof String) == true) goto L76;
        r19 = null;
    L76:
        r18 = (String) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_buynow_slice_fields", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buynow_slice_fields", String.class, "{}");     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = "{}";
    L166:
        r22 = "{}";
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_buynow_slice_fields");     // Catch: Throwable -> L133
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
        if ((r25 instanceof String) == true) goto L144;
        r25 = null;
    L144:
        r22 = (String) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("iesec_buynow_slice_fields", String.class, "{}", false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof String) == false) goto L154;
        r13 = r28;
    L154:
        String r29 = (String) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = "{}";
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof String) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (String) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof String) == true) goto L98;
        r31 = null;
    L98:
        r24 = (String) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof String) == true) goto L104;
        r32 = null;
    L104:
        r24 = (String) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof String) == true) goto L110;
        r33 = null;
    L110:
        r24 = (String) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof String) == true) goto L116;
        r34 = null;
    L116:
        r24 = (String) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), String.class);     // Catch: Throwable -> L126
        if ((r35 instanceof String) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((String) r35);     // Catch: Throwable -> L126
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
        return (String) r18;
    L11:
        if ((r14 instanceof String) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (String) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof String) == true) goto L24;
        r40 = null;
    L24:
        r15 = (String) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof String) == true) goto L30;
        r41 = null;
    L30:
        r15 = (String) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof String) == true) goto L36;
        r42 = null;
    L36:
        r15 = (String) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof String) == true) goto L42;
        r43 = null;
    L42:
        r15 = (String) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), String.class);     // Catch: Throwable -> L52
        if ((r44 instanceof String) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((String) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("Yata事件上报配置")
    public static final Map<String, Object> e0() {
        int r0 = p.a;
        Object r1 = MapsKt.emptyMap();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_yata_report_config", Map.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (Map) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("组件化提单页模版预加载配置")
    public static final z43.b f() {
        int r0 = j.a;
        Object r1 = new z43.b();
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L59
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
        if ((r16 instanceof z43.b) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (z43.b) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L172
        if ((r19 instanceof z43.b) == true) goto L76;
        r19 = null;
    L76:
        r18 = (z43.b) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L189;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_buynow_slice_templates", r18);     // Catch: Throwable -> L172
        goto L182
    L189:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_buynow_slice_templates", z43.b.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_buynow_slice_templates");     // Catch: Throwable -> L133
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
        if ((r25 instanceof z43.b) == true) goto L144;
        r25 = null;
    L144:
        r22 = (z43.b) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("iesec_buynow_slice_templates", z43.b.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof z43.b) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (z43.b) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof z43.b) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (z43.b) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof z43.b) == true) goto L98;
        r31 = null;
    L98:
        r24 = (z43.b) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof z43.b) == true) goto L104;
        r32 = null;
    L104:
        r24 = (z43.b) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof z43.b) == true) goto L110;
        r33 = null;
    L110:
        r24 = (z43.b) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof z43.b) == true) goto L116;
        r34 = null;
    L116:
        r24 = (z43.b) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L187:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), z43.b.class);     // Catch: Throwable -> L126
        if ((r35 instanceof z43.b) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((z43.b) r35);     // Catch: Throwable -> L126
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
        return (z43.b) r18;
    L11:
        if ((r14 instanceof z43.b) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (z43.b) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof z43.b) == true) goto L24;
        r40 = null;
    L24:
        r15 = (z43.b) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof z43.b) == true) goto L30;
        r41 = null;
    L30:
        r15 = (z43.b) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof z43.b) == true) goto L36;
        r42 = null;
    L36:
        r15 = (z43.b) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(z43.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof z43.b) == true) goto L42;
        r43 = null;
    L42:
        r15 = (z43.b) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L193:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), z43.b.class);     // Catch: Throwable -> L52
        if ((r44 instanceof z43.b) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((z43.b) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("Yata开关配置")
    public static final Map<String, Object> f0() {
        int r0 = j.a;
        Object r1 = MapsKt.emptyMap();
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_yata_switch_config");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof Map) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Map) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("iesec_yata_switch_config");     // Catch: Throwable -> L174
        if ((r19 instanceof Map) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Map) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_yata_switch_config", r18);     // Catch: Throwable -> L174
        goto L184
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_yata_switch_config", Map.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_yata_switch_config");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof Map) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Map) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("iesec_yata_switch_config", Map.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof Map) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (Map) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof Map) == false) goto L149;
    L85:
        if ((r23 instanceof Map) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Map) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Map) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Map) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Map) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Map) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Map) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Map) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Map) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Map) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Map) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Map) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r18;
    L11:
        if ((r14 instanceof Map) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Map) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Map) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Map) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Map) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Map) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Map) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Map) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Map) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Map) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L191:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Map) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Map) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("启用card_list_kit的页面名称")
    public static List g() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = CollectionsKt.emptyList();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_card_list_kit_enable");     // Catch: Throwable -> L59
        if (r13 != null) goto L11;
    L56:
        Object r14 = null;
    L57:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L59
    L61:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L174
        if (r16 == null) goto L65;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r15) == false) goto L68;
        r15 = null;
    L68:
        if ((r15 instanceof List) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (List) r15;     // Catch: Throwable -> L174
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L174
        Object r18 = SDKSettingsCacheManager.a.get("ec_card_list_kit_enable");     // Catch: Throwable -> L174
        if ((r18 instanceof List) == true) goto L76;
        r18 = null;
    L76:
        r17 = (List) r18;     // Catch: Throwable -> L174
    L77:
        if (r17 != null) goto L184;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L174
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r21) != null) goto L191;
    L171:
        r17 = r21;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_card_list_kit_enable", r17);     // Catch: Throwable -> L174
        goto L184
    L191:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_card_list_kit_enable", List.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r21 != null) goto L171;
        r17 = r1;
    L168:
        r21 = r1;
        goto L169
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_card_list_kit_enable");     // Catch: Throwable -> L133
        if (r22 != null) goto L85;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L161
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof List) == true) goto L144;
        r24 = null;
    L144:
        r21 = (List) r24;     // Catch: Throwable -> L161
        if (r21 != null) goto L147;
    L149:
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L161
        Object r27 = jj4.a.a("ec_card_list_kit_enable", List.class, r1, false);     // Catch: Throwable -> L161
        if (r27 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r27 instanceof List) == false) goto L156;
        r12 = r27;
    L156:
        Object r28 = (List) r12;     // Catch: Throwable -> L161
        if (r28 != null) goto L159;
        r28 = r1;
    L159:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L161
    L147:
        if ((r21 instanceof List) == false) goto L149;
    L85:
        if ((r22 instanceof List) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (List) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof List) == true) goto L98;
        r30 = null;
    L98:
        r23 = (List) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof List) == true) goto L104;
        r31 = null;
    L104:
        r23 = (List) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof List) == true) goto L110;
        r32 = null;
    L110:
        r23 = (List) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof List) == true) goto L116;
        r33 = null;
    L116:
        r23 = (List) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L187:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), List.class);     // Catch: Throwable -> L126
        if ((r34 instanceof List) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((List) r34);     // Catch: Throwable -> L126
    L128:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L133
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L87:
        r29 = r22;
    L133:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L161
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r17;
    L11:
        if ((r13 instanceof List) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (List) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof List) == true) goto L24;
        r39 = null;
    L24:
        r14 = (List) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof List) == true) goto L30;
        r40 = null;
    L30:
        r14 = (List) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof List) == true) goto L36;
        r41 = null;
    L36:
        r14 = (List) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof List) == true) goto L42;
        r42 = null;
    L42:
        r14 = (List) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), List.class);     // Catch: Throwable -> L52
        if ((r43 instanceof List) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((List) r43);     // Catch: Throwable -> L52
    L54:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L59
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r13 instanceof JSONArray) == false) goto L56;
    L13:
        r38 = r13;
    L59:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L174
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L179;
        EnsureManager.ensureNotReachHere(r49);
    L179:
        if (Result.isFailure-impl(r48) == true) goto L182;
        r1 = r48;
    L182:
        r17 = r1;
        goto L184
    }

    @SettingPanel("standard_product_marketing_param埋点优化")
    public static final boolean g0() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_standard_track_params_refactor_enable", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商城关注tab首屏直")
    public static final int h0() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("enable_xtab_follow_page_opt", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("地址 SDK 定位优化开关")
    public static final boolean i() {
        int r0 = j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("iesec_address_sdk_enable_locate_opt", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_address_sdk_enable_locate_opt", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_address_sdk_enable_locate_opt");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("iesec_address_sdk_enable_locate_opt", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("entrance_info加工规则配置")
    public static final EntranceInfoWriteConfig i0() {
        int r0 = j.a;
        Object r1 = new EntranceInfoWriteConfig(null, null, null, null, null, 31, null);
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("entrance_info_check_config");     // Catch: Throwable -> L59
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
        if ((r16 instanceof EntranceInfoWriteConfig) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (EntranceInfoWriteConfig) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("entrance_info_check_config");     // Catch: Throwable -> L172
        if ((r19 instanceof EntranceInfoWriteConfig) == true) goto L76;
        r19 = null;
    L76:
        r18 = (EntranceInfoWriteConfig) r19;     // Catch: Throwable -> L172
    L77:
        if (r18 != null) goto L182;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L172
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L169:
        r18 = r22;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("entrance_info_check_config", r18);     // Catch: Throwable -> L172
        goto L182
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("entrance_info_check_config", EntranceInfoWriteConfig.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("entrance_info_check_config");     // Catch: Throwable -> L133
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
        if ((r25 instanceof EntranceInfoWriteConfig) == true) goto L144;
        r25 = null;
    L144:
        r22 = (EntranceInfoWriteConfig) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("entrance_info_check_config", EntranceInfoWriteConfig.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof EntranceInfoWriteConfig) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (EntranceInfoWriteConfig) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof EntranceInfoWriteConfig) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (EntranceInfoWriteConfig) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof EntranceInfoWriteConfig) == true) goto L98;
        r31 = null;
    L98:
        r24 = (EntranceInfoWriteConfig) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof EntranceInfoWriteConfig) == true) goto L104;
        r32 = null;
    L104:
        r24 = (EntranceInfoWriteConfig) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof EntranceInfoWriteConfig) == true) goto L110;
        r33 = null;
    L110:
        r24 = (EntranceInfoWriteConfig) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof EntranceInfoWriteConfig) == true) goto L116;
        r34 = null;
    L116:
        r24 = (EntranceInfoWriteConfig) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L191:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), EntranceInfoWriteConfig.class);     // Catch: Throwable -> L126
        if ((r35 instanceof EntranceInfoWriteConfig) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((EntranceInfoWriteConfig) r35);     // Catch: Throwable -> L126
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
        return (EntranceInfoWriteConfig) r18;
    L11:
        if ((r14 instanceof EntranceInfoWriteConfig) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (EntranceInfoWriteConfig) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof EntranceInfoWriteConfig) == true) goto L24;
        r40 = null;
    L24:
        r15 = (EntranceInfoWriteConfig) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof EntranceInfoWriteConfig) == true) goto L30;
        r41 = null;
    L30:
        r15 = (EntranceInfoWriteConfig) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof EntranceInfoWriteConfig) == true) goto L36;
        r42 = null;
    L36:
        r15 = (EntranceInfoWriteConfig) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWriteConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof EntranceInfoWriteConfig) == true) goto L42;
        r43 = null;
    L42:
        r15 = (EntranceInfoWriteConfig) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L183:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), EntranceInfoWriteConfig.class);     // Catch: Throwable -> L52
        if ((r44 instanceof EntranceInfoWriteConfig) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((EntranceInfoWriteConfig) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("新版电商主播管理页Scheme配置")
    public static final vh.a j() {
        int r0 = p.a;
        Object r1 = new vh.a();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecom_anchor_manage_scheme", vh.a.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (vh.a) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("entrance_info 白名单配置")
    public static final EntranceInfoReportConfig j0() {
        int r0 = j.a;
        Object r10 = null;
        Object r1 = new EntranceInfoReportConfig(0, null, 3, null);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        r13.getClass();     // Catch: Throwable -> L58
        Object r14 = SDKSettingsCacheManager.b.get("ec_entrance_info_report_track");     // Catch: Throwable -> L58
        if (r14 != null) goto L10;
    L55:
        Object r15 = null;
    L56:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L58
    L60:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L171
        if (r17 == null) goto L64;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L171
    L64:
        if (Result.isFailure-impl(r16) == false) goto L67;
        r16 = null;
    L67:
        if ((r16 instanceof EntranceInfoReportConfig) == true) goto L69;
        r16 = null;
    L69:
        Object r18 = (EntranceInfoReportConfig) r16;     // Catch: Throwable -> L171
        if (r18 != null) goto L76;
        r13.getClass();     // Catch: Throwable -> L171
        Object r19 = SDKSettingsCacheManager.a.get("ec_entrance_info_report_track");     // Catch: Throwable -> L171
        if ((r19 instanceof EntranceInfoReportConfig) == true) goto L75;
        r19 = null;
    L75:
        r18 = (EntranceInfoReportConfig) r19;     // Catch: Throwable -> L171
    L76:
        if (r18 != null) goto L181;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L171
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L160:
        Object r23 = r22;
        if (Result.exceptionOrNull-impl(r23) != null) goto L188;
    L168:
        r18 = r23;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_entrance_info_report_track", r18);     // Catch: Throwable -> L171
        goto L181
    L188:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_entrance_info_report_track", EntranceInfoReportConfig.class, r1);     // Catch: Throwable -> L165
    L166:
        if (r23 != null) goto L168;
        r18 = r1;
    L165:
        r23 = r1;
        goto L166
    L194:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r24 = SDKSettingsCacheManager.b.get("ec_entrance_info_report_track");     // Catch: Throwable -> L132
        if (r24 != null) goto L84;
    L129:
        Object r25 = null;
    L130:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L132
    L134:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L158
        if (r27 == null) goto L138;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r26) == false) goto L141;
        r26 = null;
    L141:
        if ((r26 instanceof EntranceInfoReportConfig) == true) goto L143;
        r26 = null;
    L143:
        r23 = (EntranceInfoReportConfig) r26;     // Catch: Throwable -> L158
        if (r23 != null) goto L168;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L158
        Object r29 = jj4.a.a("ec_entrance_info_report_track", EntranceInfoReportConfig.class, r1, false);     // Catch: Throwable -> L158
        if (r29 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r29 instanceof EntranceInfoReportConfig) == false) goto L153;
        r10 = r29;
    L153:
        Object r30 = (EntranceInfoReportConfig) r10;     // Catch: Throwable -> L158
        if (r30 != null) goto L156;
        r30 = r1;
    L156:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L158
    L84:
        if ((r24 instanceof EntranceInfoReportConfig) == true) goto L86;
        Object r31 = null;
    L87:
        r25 = (EntranceInfoReportConfig) r31;     // Catch: Throwable -> L132
        if (r25 != null) goto L130;
        if ((r24 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L132
        if ((r32 instanceof EntranceInfoReportConfig) == true) goto L97;
        r32 = null;
    L97:
        r25 = (EntranceInfoReportConfig) r32;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L132
        if ((r33 instanceof EntranceInfoReportConfig) == true) goto L103;
        r33 = null;
    L103:
        r25 = (EntranceInfoReportConfig) r33;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L132
        if ((r34 instanceof EntranceInfoReportConfig) == true) goto L109;
        r34 = null;
    L109:
        r25 = (EntranceInfoReportConfig) r34;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L132
        if ((r35 instanceof EntranceInfoReportConfig) == true) goto L115;
        r35 = null;
    L115:
        r25 = (EntranceInfoReportConfig) r35;     // Catch: Throwable -> L132
    L117:
        if ((r24 instanceof JSONObject) == false) goto L119;
    L186:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), EntranceInfoReportConfig.class);     // Catch: Throwable -> L125
        if ((r36 instanceof EntranceInfoReportConfig) == true) goto L123;
        r36 = null;
    L123:
        Object r37 = Result.constructor-impl((EntranceInfoReportConfig) r36);     // Catch: Throwable -> L125
    L127:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L132
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r24 instanceof JSONArray) == false) goto L129;
    L86:
        r31 = r24;
    L132:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L158
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (EntranceInfoReportConfig) r18;
    L10:
        if ((r14 instanceof EntranceInfoReportConfig) == true) goto L12;
        Object r40 = null;
    L13:
        r15 = (EntranceInfoReportConfig) r40;     // Catch: Throwable -> L58
        if (r15 != null) goto L56;
        if ((r14 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r41 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L58
        if ((r41 instanceof EntranceInfoReportConfig) == true) goto L23;
        r41 = null;
    L23:
        r15 = (EntranceInfoReportConfig) r41;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r42 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L58
        if ((r42 instanceof EntranceInfoReportConfig) == true) goto L29;
        r42 = null;
    L29:
        r15 = (EntranceInfoReportConfig) r42;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r43 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L58
        if ((r43 instanceof EntranceInfoReportConfig) == true) goto L35;
        r43 = null;
    L35:
        r15 = (EntranceInfoReportConfig) r43;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoReportConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r44 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L58
        if ((r44 instanceof EntranceInfoReportConfig) == true) goto L41;
        r44 = null;
    L41:
        r15 = (EntranceInfoReportConfig) r44;     // Catch: Throwable -> L58
    L43:
        if ((r14 instanceof JSONObject) == false) goto L45;
    L192:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r14.toString(), EntranceInfoReportConfig.class);     // Catch: Throwable -> L51
        if ((r45 instanceof EntranceInfoReportConfig) == true) goto L49;
        r45 = null;
    L49:
        Object r46 = Result.constructor-impl((EntranceInfoReportConfig) r45);     // Catch: Throwable -> L51
    L53:
        r15 = r46;
        if (Result.isFailure-impl(r15) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L58
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r14 instanceof JSONArray) == false) goto L55;
    L12:
        r40 = r14;
    L58:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L171
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L176;
        EnsureManager.ensureNotReachHere(r51);
    L176:
        if (Result.isFailure-impl(r50) == true) goto L179;
        r1 = r50;
    L179:
        r18 = r1;
        goto L181
    }

    @SettingPanel("Android 提单页自定义事件抽象化")
    public static final int k() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("buy_now_self_event_refactor", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("entrance_info 白名单配置")
    public static final EntranceInfoWhiteListConfig k0() {
        int r0 = j.a;
        Object r1 = null;
        Object r10 = new EntranceInfoWhiteListConfig(null, null, 3, null);
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        r13.getClass();     // Catch: Throwable -> L58
        Object r14 = SDKSettingsCacheManager.b.get("entrance_info_white_list_config");     // Catch: Throwable -> L58
        if (r14 != null) goto L10;
    L55:
        Object r15 = null;
    L56:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L58
    L60:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L171
        if (r17 == null) goto L64;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L171
    L64:
        if (Result.isFailure-impl(r16) == false) goto L67;
        r16 = null;
    L67:
        if ((r16 instanceof EntranceInfoWhiteListConfig) == true) goto L69;
        r16 = null;
    L69:
        Object r18 = (EntranceInfoWhiteListConfig) r16;     // Catch: Throwable -> L171
        if (r18 != null) goto L76;
        r13.getClass();     // Catch: Throwable -> L171
        Object r19 = SDKSettingsCacheManager.a.get("entrance_info_white_list_config");     // Catch: Throwable -> L171
        if ((r19 instanceof EntranceInfoWhiteListConfig) == true) goto L75;
        r19 = null;
    L75:
        r18 = (EntranceInfoWhiteListConfig) r19;     // Catch: Throwable -> L171
    L76:
        if (r18 != null) goto L181;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L171
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L160:
        Object r23 = r22;
        if (Result.exceptionOrNull-impl(r23) != null) goto L188;
    L168:
        r18 = r23;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("entrance_info_white_list_config", r18);     // Catch: Throwable -> L171
        goto L181
    L188:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("entrance_info_white_list_config", EntranceInfoWhiteListConfig.class, r10);     // Catch: Throwable -> L165
    L166:
        if (r23 != null) goto L168;
        r18 = r10;
    L165:
        r23 = r10;
        goto L166
    L194:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r24 = SDKSettingsCacheManager.b.get("entrance_info_white_list_config");     // Catch: Throwable -> L132
        if (r24 != null) goto L84;
    L129:
        Object r25 = null;
    L130:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L132
    L134:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L158
        if (r27 == null) goto L138;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r26) == false) goto L141;
        r26 = null;
    L141:
        if ((r26 instanceof EntranceInfoWhiteListConfig) == true) goto L143;
        r26 = null;
    L143:
        r23 = (EntranceInfoWhiteListConfig) r26;     // Catch: Throwable -> L158
        if (r23 != null) goto L168;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L158
        Object r29 = jj4.a.a("entrance_info_white_list_config", EntranceInfoWhiteListConfig.class, r10, false);     // Catch: Throwable -> L158
        if (r29 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r29 instanceof EntranceInfoWhiteListConfig) == false) goto L153;
        r1 = r29;
    L153:
        Object r30 = (EntranceInfoWhiteListConfig) r1;     // Catch: Throwable -> L158
        if (r30 != null) goto L156;
        r30 = r10;
    L156:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L158
    L84:
        if ((r24 instanceof EntranceInfoWhiteListConfig) == true) goto L86;
        Object r31 = null;
    L87:
        r25 = (EntranceInfoWhiteListConfig) r31;     // Catch: Throwable -> L132
        if (r25 != null) goto L130;
        if ((r24 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L132
        if ((r32 instanceof EntranceInfoWhiteListConfig) == true) goto L97;
        r32 = null;
    L97:
        r25 = (EntranceInfoWhiteListConfig) r32;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L132
        if ((r33 instanceof EntranceInfoWhiteListConfig) == true) goto L103;
        r33 = null;
    L103:
        r25 = (EntranceInfoWhiteListConfig) r33;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L132
        if ((r34 instanceof EntranceInfoWhiteListConfig) == true) goto L109;
        r34 = null;
    L109:
        r25 = (EntranceInfoWhiteListConfig) r34;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L132
        if ((r35 instanceof EntranceInfoWhiteListConfig) == true) goto L115;
        r35 = null;
    L115:
        r25 = (EntranceInfoWhiteListConfig) r35;     // Catch: Throwable -> L132
    L117:
        if ((r24 instanceof JSONObject) == false) goto L119;
    L186:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), EntranceInfoWhiteListConfig.class);     // Catch: Throwable -> L125
        if ((r36 instanceof EntranceInfoWhiteListConfig) == true) goto L123;
        r36 = null;
    L123:
        Object r37 = Result.constructor-impl((EntranceInfoWhiteListConfig) r36);     // Catch: Throwable -> L125
    L127:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L132
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r24 instanceof JSONArray) == false) goto L129;
    L86:
        r31 = r24;
    L132:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L158
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (EntranceInfoWhiteListConfig) r18;
    L10:
        if ((r14 instanceof EntranceInfoWhiteListConfig) == true) goto L12;
        Object r40 = null;
    L13:
        r15 = (EntranceInfoWhiteListConfig) r40;     // Catch: Throwable -> L58
        if (r15 != null) goto L56;
        if ((r14 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r41 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L58
        if ((r41 instanceof EntranceInfoWhiteListConfig) == true) goto L23;
        r41 = null;
    L23:
        r15 = (EntranceInfoWhiteListConfig) r41;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r42 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L58
        if ((r42 instanceof EntranceInfoWhiteListConfig) == true) goto L29;
        r42 = null;
    L29:
        r15 = (EntranceInfoWhiteListConfig) r42;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r43 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L58
        if ((r43 instanceof EntranceInfoWhiteListConfig) == true) goto L35;
        r43 = null;
    L35:
        r15 = (EntranceInfoWhiteListConfig) r43;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(EntranceInfoWhiteListConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r44 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L58
        if ((r44 instanceof EntranceInfoWhiteListConfig) == true) goto L41;
        r44 = null;
    L41:
        r15 = (EntranceInfoWhiteListConfig) r44;     // Catch: Throwable -> L58
    L43:
        if ((r14 instanceof JSONObject) == false) goto L45;
    L192:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r14.toString(), EntranceInfoWhiteListConfig.class);     // Catch: Throwable -> L51
        if ((r45 instanceof EntranceInfoWhiteListConfig) == true) goto L49;
        r45 = null;
    L49:
        Object r46 = Result.constructor-impl((EntranceInfoWhiteListConfig) r45);     // Catch: Throwable -> L51
    L53:
        r15 = r46;
        if (Result.isFailure-impl(r15) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L58
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r14 instanceof JSONArray) == false) goto L55;
    L12:
        r40 = r14;
    L58:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L171
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L176;
        EnsureManager.ensureNotReachHere(r51);
    L176:
        if (Result.isFailure-impl(r50) == true) goto L179;
        r10 = r50;
    L179:
        r18 = r10;
        goto L181
    }

    @SettingPanel("电商VmSdk实验开关")
    public static final boolean l() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ecom_enable_vmsdk_params_verify", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_enable_vmsdk_params_verify", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ecom_enable_vmsdk_params_verify");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ecom_enable_vmsdk_params_verify", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("提单页 参数校验接入 增加")
    public static final BuyNowSettingConfig l0() {
        int r0 = p.a;
        Object r1 = new BuyNowSettingConfig(false, null, 3, null);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_buynow_config", BuyNowSettingConfig.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (BuyNowSettingConfig) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("电商网络监控path白名单")
    public static final String m() {
        int r0 = j.a;
        Object r1 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L59
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
        if ((r16 instanceof String) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (String) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L172
        if ((r19 instanceof String) == true) goto L76;
        r19 = null;
    L76:
        r18 = (String) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ecom_network_monitor_switcher", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_network_monitor_switcher", String.class, "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}");     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
    L166:
        r22 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ecom_network_monitor_switcher");     // Catch: Throwable -> L133
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
        if ((r25 instanceof String) == true) goto L144;
        r25 = null;
    L144:
        r22 = (String) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ecom_network_monitor_switcher", String.class, "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}", false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof String) == false) goto L154;
        r13 = r28;
    L154:
        String r29 = (String) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = "{\"paths\":[\"/aweme/v2/shop/promotion/pack/\"]}";
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof String) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (String) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof String) == true) goto L98;
        r31 = null;
    L98:
        r24 = (String) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof String) == true) goto L104;
        r32 = null;
    L104:
        r24 = (String) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof String) == true) goto L110;
        r33 = null;
    L110:
        r24 = (String) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof String) == true) goto L116;
        r34 = null;
    L116:
        r24 = (String) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), String.class);     // Catch: Throwable -> L126
        if ((r35 instanceof String) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((String) r35);     // Catch: Throwable -> L126
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
        return (String) r18;
    L11:
        if ((r14 instanceof String) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (String) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof String) == true) goto L24;
        r40 = null;
    L24:
        r15 = (String) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof String) == true) goto L30;
        r41 = null;
    L30:
        r15 = (String) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof String) == true) goto L36;
        r42 = null;
    L36:
        r15 = (String) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof String) == true) goto L42;
        r43 = null;
    L42:
        r15 = (String) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), String.class);     // Catch: Throwable -> L52
        if ((r44 instanceof String) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((String) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("电商优惠券面板schema下发")
    public static final String m0() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_coupon_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("电商商详直播容器Schema下发")
    public static final String n0() {
        int r0 = p.a;
        Object r1 = "{}";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_goodsdetail_hybrid_setting", String.class, "{}", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("异步收银台埋点后置开关")
    public static boolean o() {
        int r0 = j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_buy_now_async_tracker_delay", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_buy_now_async_tracker_delay", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_buy_now_async_tracker_delay");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_buy_now_async_tracker_delay", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详找相似入口优化-已固化")
    public static final int o0() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(2, 0);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r23 = r22;
        if (Result.exceptionOrNull-impl(r23) != null) goto L187;
    L163:
        r18 = r23;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_pdp_find_same_opt", r18);     // Catch: Throwable -> L166
        goto L176
    L187:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_find_same_opt", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r23 != null) goto L163;
        r18 = r10;
    L160:
        r23 = r10;
        goto L161
    L179:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r24 = SDKSettingsCacheManager.b.get("iesec_pdp_find_same_opt");     // Catch: Throwable -> L127
        if (r24 != null) goto L82;
    L124:
        Object r25 = null;
    L125:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L127
    L129:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L153
        if (r27 == null) goto L133;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r26) == false) goto L136;
        r26 = null;
    L136:
        if ((r26 instanceof Integer) == true) goto L138;
        r26 = null;
    L138:
        r23 = (Integer) r26;     // Catch: Throwable -> L153
        if (r23 != null) goto L163;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("iesec_pdp_find_same_opt", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r10;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r24 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r25 = (Integer) r31;     // Catch: Throwable -> L127
        if (r25 != null) goto L125;
        if ((r24 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r25 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r25 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r25 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r25 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r24 instanceof JSONObject) == false) goto L114;
    L185:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r25 = r36;
        if (Result.isFailure-impl(r25) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r24 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r24;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L183:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r10 = r48;
    L174:
        r18 = r10;
        goto L176
    }

    @SettingPanel("na购物车页面配置")
    public static final com.bytedance.android.ec.core.cart.c p() {
        int r0 = p.a;
        Object r1 = new com.bytedance.android.ec.core.cart.c(null);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_cart_config", com.bytedance.android.ec.core.cart.c.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (com.bytedance.android.ec.core.cart.c) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详半屏分场景(ecom_scene_id)的开关配置，包括是否一次下滑关闭商详、1:1.5的类目ID等")
    public static final Map<String, Object> p0() {
        int r0 = j.a;
        Object r1 = MapsKt.emptyMap();
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof Map) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Map) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L174
        if ((r19 instanceof Map) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Map) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_pdp_half_panel_scene_config", r18);     // Catch: Throwable -> L174
        goto L184
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_half_panel_scene_config", Map.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_half_panel_scene_config");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof Map) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Map) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("iesec_pdp_half_panel_scene_config", Map.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof Map) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (Map) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof Map) == false) goto L149;
    L85:
        if ((r23 instanceof Map) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Map) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Map) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Map) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Map) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Map) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Map) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Map) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Map) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Map) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Map) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Map) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (Map) r18;
    L11:
        if ((r14 instanceof Map) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Map) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Map) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Map) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Map) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Map) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Map) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Map) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Map) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Map) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L191:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Map) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Map) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("购物车半屏适配直播开关")
    public static boolean q() {
        int r0 = j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_cart_half_panel_adapt_live", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_cart_half_panel_adapt_live", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_cart_half_panel_adapt_live");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_cart_half_panel_adapt_live", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("直播间商详增加氛围条")
    public static final boolean q0() {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L166
        Object r11 = null;
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L57
        if (r12 != null) goto L9;
    L54:
        Object r13 = null;
    L55:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L57
    L59:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L166
        if (r15 == null) goto L63;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r14) == false) goto L66;
        r14 = null;
    L66:
        if ((r14 instanceof Boolean) == true) goto L68;
        r14 = null;
    L68:
        Object r16 = (Boolean) r14;     // Catch: Throwable -> L166
        if (r16 != null) goto L75;
        Object r17 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L166
        if ((r17 instanceof Boolean) == true) goto L74;
        r17 = null;
    L74:
        r16 = (Boolean) r17;     // Catch: Throwable -> L166
    L75:
        if (r16 != null) goto L176;
        int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r19 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_live_atmosphere_type_opt");     // Catch: Throwable -> L130
        if (r19 != null) goto L82;
    L127:
        Object r20 = null;
    L128:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L130
    L132:
        Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L156
        if (r22 == null) goto L136;
        EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r21) == false) goto L139;
        r21 = null;
    L139:
        if ((r21 instanceof Boolean) == true) goto L141;
        r21 = null;
    L141:
        r16 = (Boolean) r21;     // Catch: Throwable -> L156
        if (r16 != null) goto L164;
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r23 == null) goto L147;
        Object r24 = r23.getHostABValue("iesec_pdp_live_atmosphere_type_opt", r1);     // Catch: Throwable -> L156
    L148:
        if (r24 != null) goto L150;
    L155:
        r16 = r1;
        goto L164
    L150:
        if ((r24 instanceof Boolean) == false) goto L153;
        r11 = r24;
    L153:
        Object r25 = (Boolean) r11;     // Catch: Throwable -> L156
        if (r25 == null) goto L155;
    L163:
        r16 = r25;
        goto L164
    L147:
        r24 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_live_atmosphere_type_opt", r16);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r19 instanceof Boolean) == true) goto L84;
        Object r26 = null;
    L85:
        r20 = (Boolean) r26;     // Catch: Throwable -> L130
        if (r20 != null) goto L128;
        if ((r19 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r27 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L130
        if ((r27 instanceof Boolean) == true) goto L95;
        r27 = null;
    L95:
        r20 = (Boolean) r27;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r28 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L130
        if ((r28 instanceof Boolean) == true) goto L101;
        r28 = null;
    L101:
        r20 = (Boolean) r28;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r29 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Boolean) == true) goto L107;
        r29 = null;
    L107:
        r20 = (Boolean) r29;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r30 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Boolean) == true) goto L113;
        r30 = null;
    L113:
        r20 = (Boolean) r30;     // Catch: Throwable -> L130
    L115:
        if ((r19 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r31 = SDKSettingsCacheManager.a().fromJson(r19.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r31 instanceof Boolean) == true) goto L121;
        r31 = null;
    L121:
        Object r32 = Result.constructor-impl((Boolean) r31);     // Catch: Throwable -> L123
    L125:
        r20 = r32;
        if (Result.isFailure-impl(r20) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L130
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r19 instanceof JSONArray) == false) goto L127;
    L84:
        r26 = r19;
    L156:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L166
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r35 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L166
        if (r35 == null) goto L161;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r25) == false) goto L163;
        r25 = r1;
    L130:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L156
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r16).booleanValue();
    L9:
        if ((r12 instanceof Boolean) == true) goto L11;
        Object r37 = null;
    L12:
        r13 = (Boolean) r37;     // Catch: Throwable -> L57
        if (r13 != null) goto L55;
        if ((r12 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L57
        if ((r38 instanceof Boolean) == true) goto L22;
        r38 = null;
    L22:
        r13 = (Boolean) r38;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L57
        if ((r39 instanceof Boolean) == true) goto L28;
        r39 = null;
    L28:
        r13 = (Boolean) r39;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r40 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L57
        if ((r40 instanceof Boolean) == true) goto L34;
        r40 = null;
    L34:
        r13 = (Boolean) r40;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r41 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L57
        if ((r41 instanceof Boolean) == true) goto L40;
        r41 = null;
    L40:
        r13 = (Boolean) r41;     // Catch: Throwable -> L57
    L42:
        if ((r12 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r42 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r42 instanceof Boolean) == true) goto L48;
        r42 = null;
    L48:
        Object r43 = Result.constructor-impl((Boolean) r42);     // Catch: Throwable -> L50
    L52:
        r13 = r43;
        if (Result.isFailure-impl(r13) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L57
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r12 instanceof JSONArray) == false) goto L54;
    L11:
        r37 = r12;
    L57:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r16 = r1;
        goto L176
    }

    @SettingPanel("电商防暴击限制时间配置")
    public static final int r() {
        int r0 = j.a;
        Object r1 = 750;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_client_click_interval_time");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_client_click_interval_time");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_client_click_interval_time", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_client_click_interval_time", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_client_click_interval_time");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        r22 = (Integer) r25;     // Catch: Throwable -> L153
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_client_click_interval_time", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r13 = r28;
    L148:
        Object r29 = (Integer) r13;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r24 = (Integer) r30;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r23;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r15 = (Integer) r38;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r14;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("电商图片展示面板schema")
    public static String r0() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_images_show_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_images_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_images_show_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("解决个人页商品收藏页商品卡的长按冲突")
    public static final boolean s() {
        int r0 = j.a;
        Object r1 = Boolean.TRUE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_collect_long_press_opt");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_collect_long_press_opt");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_collect_long_press_opt", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_collect_long_press_opt", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_collect_long_press_opt");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_collect_long_press_opt", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详展示弹窗")
    public static final int s0() {
        int r0 = j.a;
        Object r1 = 3;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_disclaimer_optimize");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_disclaimer_optimize");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_disclaimer_optimize", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_disclaimer_optimize", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_disclaimer_optimize");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        r22 = (Integer) r25;     // Catch: Throwable -> L153
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("ec_disclaimer_optimize", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r13 = r28;
    L148:
        Object r29 = (Integer) r13;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r1;
    L151:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r24 = (Integer) r30;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r23;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r15 = (Integer) r38;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r14;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r1 = r47;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("收藏组件化页面配置")
    public static final qg.a t() {
        int r0 = p.a;
        Object r1 = new qg.a(0);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_collect_page_config", qg.a.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (qg.a) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("讲解回放倍速播放和直播入口实验")
    public static final int t0() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("live_replay_optimize", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("商详找同款2.0体验优化-已固化")
    public static final int u() {
        int r0 = p.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(3, 1);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r12 = jj4.b.b;     // Catch: Throwable -> L7
        Object r13 = jj4.a.a("ec_find_same_v2_request_opt", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r13 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r13).intValue();
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == true) goto L12;
        r10 = r15;
    L12:
        r13 = r10;
        goto L14
    }

    @SettingPanel("商城首页关注tab优化配置")
    public static final String u0() {
        int r0 = p.a;
        Object r1 = "{}";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("mall_shop_moment_config", String.class, "{}", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("字体资源配置")
    public static Map v() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = new HashMap();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_font_res_config");     // Catch: Throwable -> L59
        if (r13 != null) goto L11;
    L56:
        Object r14 = null;
    L57:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L59
    L61:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L172
        if (r16 == null) goto L65;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r15) == false) goto L68;
        r15 = null;
    L68:
        if ((r15 instanceof HashMap) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (HashMap) r15;     // Catch: Throwable -> L172
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L172
        Object r18 = SDKSettingsCacheManager.a.get("ec_font_res_config");     // Catch: Throwable -> L172
        if ((r18 instanceof HashMap) == true) goto L76;
        r18 = null;
    L76:
        r17 = (HashMap) r18;     // Catch: Throwable -> L172
    L77:
        if (r17 != null) goto L182;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L172
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r21) != null) goto L185;
    L169:
        r17 = r21;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_font_res_config", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_font_res_config", HashMap.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_font_res_config");     // Catch: Throwable -> L133
        if (r22 != null) goto L85;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L159
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof HashMap) == true) goto L144;
        r24 = null;
    L144:
        r21 = (HashMap) r24;     // Catch: Throwable -> L159
        if (r21 != null) goto L169;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L159
        Object r27 = jj4.a.a("ec_font_res_config", HashMap.class, r1, false);     // Catch: Throwable -> L159
        if (r27 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r27 instanceof HashMap) == false) goto L154;
        r12 = r27;
    L154:
        Object r28 = (HashMap) r12;     // Catch: Throwable -> L159
        if (r28 != null) goto L157;
        r28 = r1;
    L157:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L159
    L85:
        if ((r22 instanceof HashMap) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (HashMap) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof HashMap) == true) goto L98;
        r30 = null;
    L98:
        r23 = (HashMap) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof HashMap) == true) goto L104;
        r31 = null;
    L104:
        r23 = (HashMap) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof HashMap) == true) goto L110;
        r32 = null;
    L110:
        r23 = (HashMap) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof HashMap) == true) goto L116;
        r33 = null;
    L116:
        r23 = (HashMap) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L183:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), HashMap.class);     // Catch: Throwable -> L126
        if ((r34 instanceof HashMap) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((HashMap) r34);     // Catch: Throwable -> L126
    L128:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L133
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L87:
        r29 = r22;
    L133:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L159
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return (Map) r17;
    L11:
        if ((r13 instanceof HashMap) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (HashMap) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof HashMap) == true) goto L24;
        r39 = null;
    L24:
        r14 = (HashMap) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof HashMap) == true) goto L30;
        r40 = null;
    L30:
        r14 = (HashMap) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof HashMap) == true) goto L36;
        r41 = null;
    L36:
        r14 = (HashMap) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof HashMap) == true) goto L42;
        r42 = null;
    L42:
        r14 = (HashMap) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), HashMap.class);     // Catch: Throwable -> L52
        if ((r43 instanceof HashMap) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((HashMap) r43);     // Catch: Throwable -> L52
    L54:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L59
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r13 instanceof JSONArray) == false) goto L56;
    L13:
        r38 = r13;
    L59:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L172
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L177;
        EnsureManager.ensureNotReachHere(r49);
    L177:
        if (Result.isFailure-impl(r48) == true) goto L180;
        r1 = r48;
    L180:
        r17 = r1;
        goto L182
    }

    @SettingPanel("商详打开二级页设置高度的白名单")
    public static final List<String> v0() {
        int r0 = j.a;
        Object r1 = CollectionsKt.emptyList();
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L174
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof List) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (List) r16;     // Catch: Throwable -> L174
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L174
        Object r19 = SDKSettingsCacheManager.a.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L174
        if ((r19 instanceof List) == true) goto L76;
        r19 = null;
    L76:
        r18 = (List) r19;     // Catch: Throwable -> L174
    L77:
        if (r18 != null) goto L184;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L174
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r22) != null) goto L193;
    L171:
        r18 = r22;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_pdp_replace_secondary_page_height_percent", r18);     // Catch: Throwable -> L174
        goto L184
    L193:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_replace_secondary_page_height_percent", List.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r22 != null) goto L171;
        r18 = r1;
    L168:
        r22 = r1;
        goto L169
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("iesec_pdp_replace_secondary_page_height_percent");     // Catch: Throwable -> L133
        if (r23 != null) goto L85;
    L130:
        Object r24 = null;
    L131:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L133
    L135:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L161
        if (r26 == null) goto L139;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r25) == false) goto L142;
        r25 = null;
    L142:
        if ((r25 instanceof List) == true) goto L144;
        r25 = null;
    L144:
        r22 = (List) r25;     // Catch: Throwable -> L161
        if (r22 != null) goto L147;
    L149:
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L161
        Object r28 = jj4.a.a("iesec_pdp_replace_secondary_page_height_percent", List.class, r1, false);     // Catch: Throwable -> L161
        if (r28 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r28 instanceof List) == false) goto L156;
        r13 = r28;
    L156:
        Object r29 = (List) r13;     // Catch: Throwable -> L161
        if (r29 != null) goto L159;
        r29 = r1;
    L159:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L161
    L147:
        if ((r22 instanceof List) == false) goto L149;
    L85:
        if ((r23 instanceof List) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (List) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof List) == true) goto L98;
        r31 = null;
    L98:
        r24 = (List) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof List) == true) goto L104;
        r32 = null;
    L104:
        r24 = (List) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof List) == true) goto L110;
        r33 = null;
    L110:
        r24 = (List) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof List) == true) goto L116;
        r34 = null;
    L116:
        r24 = (List) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), List.class);     // Catch: Throwable -> L126
        if ((r35 instanceof List) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((List) r35);     // Catch: Throwable -> L126
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
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L161
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L184:
        return (List) r18;
    L11:
        if ((r14 instanceof List) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (List) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof List) == true) goto L24;
        r40 = null;
    L24:
        r15 = (List) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof List) == true) goto L30;
        r41 = null;
    L30:
        r15 = (List) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof List) == true) goto L36;
        r42 = null;
    L36:
        r15 = (List) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof List) == true) goto L42;
        r43 = null;
    L42:
        r15 = (List) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L191:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), List.class);     // Catch: Throwable -> L52
        if ((r44 instanceof List) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((List) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L174
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L179;
        EnsureManager.ensureNotReachHere(r50);
    L179:
        if (Result.isFailure-impl(r49) == true) goto L182;
        r1 = r49;
    L182:
        r18 = r1;
        goto L184
    }

    @SettingPanel("商详缓存优化实验-已固化")
    public static final ECCacheMonitorStruct w() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        int r10 = d.a;
        Object r11 = com.bytedance.android.ec.core.abtest.e.a(new ECCacheMonitorStruct(true, 1800, 10), new ECCacheMonitorStruct(false, 0, 0, 7, null));
        int r12 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r14 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r15 = null;
        r14.getClass();     // Catch: Throwable -> L59
        Object r16 = SDKSettingsCacheManager.b.get("iesec_goods_detail_cache");     // Catch: Throwable -> L59
        if (r16 != null) goto L11;
    L56:
        Object r17 = null;
    L57:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L59
    L61:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L172
        if (r19 == null) goto L65;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r18) == false) goto L68;
        r18 = null;
    L68:
        if ((r18 instanceof ECCacheMonitorStruct) == true) goto L70;
        r18 = null;
    L70:
        Object r20 = (ECCacheMonitorStruct) r18;     // Catch: Throwable -> L172
        if (r20 != null) goto L77;
        r14.getClass();     // Catch: Throwable -> L172
        Object r21 = SDKSettingsCacheManager.a.get("iesec_goods_detail_cache");     // Catch: Throwable -> L172
        if ((r21 instanceof ECCacheMonitorStruct) == true) goto L76;
        r21 = null;
    L76:
        r20 = (ECCacheMonitorStruct) r21;     // Catch: Throwable -> L172
    L77:
        if (r20 != null) goto L182;
        int r22 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L172
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r24) != null) goto L193;
    L169:
        r20 = r24;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("iesec_goods_detail_cache", r20);     // Catch: Throwable -> L172
        goto L182
    L193:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_goods_detail_cache", ECCacheMonitorStruct.class, r11);     // Catch: Throwable -> L166
    L167:
        if (r24 != null) goto L169;
        r20 = r11;
    L166:
        r24 = r11;
        goto L167
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r25 = SDKSettingsCacheManager.b.get("iesec_goods_detail_cache");     // Catch: Throwable -> L133
        if (r25 != null) goto L85;
    L130:
        Object r26 = null;
    L131:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L133
    L135:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L159
        if (r28 == null) goto L139;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r27) == false) goto L142;
        r27 = null;
    L142:
        if ((r27 instanceof ECCacheMonitorStruct) == true) goto L144;
        r27 = null;
    L144:
        r24 = (ECCacheMonitorStruct) r27;     // Catch: Throwable -> L159
        if (r24 != null) goto L169;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L159
        Object r30 = jj4.a.a("iesec_goods_detail_cache", ECCacheMonitorStruct.class, r11, false);     // Catch: Throwable -> L159
        if (r30 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r30 instanceof ECCacheMonitorStruct) == false) goto L154;
        r15 = r30;
    L154:
        Object r31 = (ECCacheMonitorStruct) r15;     // Catch: Throwable -> L159
        if (r31 != null) goto L157;
        r31 = r11;
    L157:
        r24 = Result.constructor-impl(r31);     // Catch: Throwable -> L159
    L85:
        if ((r25 instanceof ECCacheMonitorStruct) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (ECCacheMonitorStruct) r32;     // Catch: Throwable -> L133
        if (r26 != null) goto L131;
        if ((r25 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L133
        if ((r33 instanceof ECCacheMonitorStruct) == true) goto L98;
        r33 = null;
    L98:
        r26 = (ECCacheMonitorStruct) r33;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L133
        if ((r34 instanceof ECCacheMonitorStruct) == true) goto L104;
        r34 = null;
    L104:
        r26 = (ECCacheMonitorStruct) r34;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r35 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L133
        if ((r35 instanceof ECCacheMonitorStruct) == true) goto L110;
        r35 = null;
    L110:
        r26 = (ECCacheMonitorStruct) r35;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r36 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L133
        if ((r36 instanceof ECCacheMonitorStruct) == true) goto L116;
        r36 = null;
    L116:
        r26 = (ECCacheMonitorStruct) r36;     // Catch: Throwable -> L133
    L118:
        if ((r25 instanceof JSONObject) == false) goto L120;
    L191:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r25.toString(), ECCacheMonitorStruct.class);     // Catch: Throwable -> L126
        if ((r37 instanceof ECCacheMonitorStruct) == true) goto L124;
        r37 = null;
    L124:
        Object r38 = Result.constructor-impl((ECCacheMonitorStruct) r37);     // Catch: Throwable -> L126
    L128:
        r26 = r38;
        if (Result.isFailure-impl(r26) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L133
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r25 instanceof JSONArray) == false) goto L130;
    L87:
        r32 = r25;
    L133:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L159
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return (ECCacheMonitorStruct) r20;
    L11:
        if ((r16 instanceof ECCacheMonitorStruct) == true) goto L13;
        Object r41 = null;
    L14:
        r17 = (ECCacheMonitorStruct) r41;     // Catch: Throwable -> L59
        if (r17 != null) goto L57;
        if ((r16 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r42 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L59
        if ((r42 instanceof ECCacheMonitorStruct) == true) goto L24;
        r42 = null;
    L24:
        r17 = (ECCacheMonitorStruct) r42;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r43 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L59
        if ((r43 instanceof ECCacheMonitorStruct) == true) goto L30;
        r43 = null;
    L30:
        r17 = (ECCacheMonitorStruct) r43;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r44 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L59
        if ((r44 instanceof ECCacheMonitorStruct) == true) goto L36;
        r44 = null;
    L36:
        r17 = (ECCacheMonitorStruct) r44;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECCacheMonitorStruct.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r45 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L59
        if ((r45 instanceof ECCacheMonitorStruct) == true) goto L42;
        r45 = null;
    L42:
        r17 = (ECCacheMonitorStruct) r45;     // Catch: Throwable -> L59
    L44:
        if ((r16 instanceof JSONObject) == false) goto L46;
    L183:
        Object r46 = SDKSettingsCacheManager.a().fromJson(r16.toString(), ECCacheMonitorStruct.class);     // Catch: Throwable -> L52
        if ((r46 instanceof ECCacheMonitorStruct) == true) goto L50;
        r46 = null;
    L50:
        Object r47 = Result.constructor-impl((ECCacheMonitorStruct) r46);     // Catch: Throwable -> L52
    L54:
        r17 = r47;
        if (Result.isFailure-impl(r17) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L59
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r16 instanceof JSONArray) == false) goto L56;
    L13:
        r41 = r16;
    L59:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L172
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L177;
        EnsureManager.ensureNotReachHere(r52);
    L177:
        if (Result.isFailure-impl(r51) == true) goto L180;
        r11 = r51;
    L180:
        r20 = r11;
        goto L182
    }

    @SettingPanel("商详性能优化-消息队列-已固化")
    public static final com.bytedance.android.ec.core.anchorv3.i w0() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(new com.bytedance.android.ec.core.anchorv3.i(true, true, true, true, Boolean.FALSE, 104), new com.bytedance.android.ec.core.anchorv3.i(false, false, false, false, null, 255));
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
    L56:
        Object r16 = null;
    L57:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L171
        if (r18 == null) goto L65;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L171
    L65:
        if (Result.isFailure-impl(r17) == false) goto L68;
        r17 = null;
    L68:
        if ((r17 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (com.bytedance.android.ec.core.anchorv3.i) r17;     // Catch: Throwable -> L171
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L171
        Object r20 = SDKSettingsCacheManager.a.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L171
        if ((r20 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L76;
        r20 = null;
    L76:
        r19 = (com.bytedance.android.ec.core.anchorv3.i) r20;     // Catch: Throwable -> L171
    L77:
        if (r19 != null) goto L181;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L171
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.exceptionOrNull-impl(r23) != null) goto L186;
    L163:
        r19 = r23;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_msg", r19);     // Catch: Throwable -> L171
        goto L181
    L186:
        r23 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_msg", com.bytedance.android.ec.core.anchorv3.i.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r23 != null) goto L163;
        r19 = r10;
    L166:
        r23 = r10;
        goto L167
    L190:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r24 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_msg");     // Catch: Throwable -> L133
        if (r24 != null) goto L85;
    L130:
        Object r25 = null;
    L131:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L133
    L135:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L159
        if (r27 == null) goto L139;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r26) == false) goto L142;
        r26 = null;
    L142:
        if ((r26 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L144;
        r26 = null;
    L144:
        r23 = (com.bytedance.android.ec.core.anchorv3.i) r26;     // Catch: Throwable -> L159
        if (r23 != null) goto L163;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L159
        Object r29 = jj4.a.a("ec_pdp_perf_opt_msg", com.bytedance.android.ec.core.anchorv3.i.class, r10, false);     // Catch: Throwable -> L159
        if (r29 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r29 instanceof com.bytedance.android.ec.core.anchorv3.i) == false) goto L154;
        r14 = r29;
    L154:
        Object r30 = (com.bytedance.android.ec.core.anchorv3.i) r14;     // Catch: Throwable -> L159
        if (r30 != null) goto L157;
        r30 = r10;
    L157:
        r23 = Result.constructor-impl(r30);     // Catch: Throwable -> L159
    L85:
        if ((r24 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L87;
        Object r31 = null;
    L88:
        r25 = (com.bytedance.android.ec.core.anchorv3.i) r31;     // Catch: Throwable -> L133
        if (r25 != null) goto L131;
        if ((r24 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L133
        if ((r32 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L98;
        r32 = null;
    L98:
        r25 = (com.bytedance.android.ec.core.anchorv3.i) r32;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L133
        if ((r33 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L104;
        r33 = null;
    L104:
        r25 = (com.bytedance.android.ec.core.anchorv3.i) r33;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r34 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L133
        if ((r34 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L110;
        r34 = null;
    L110:
        r25 = (com.bytedance.android.ec.core.anchorv3.i) r34;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r35 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L133
        if ((r35 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L116;
        r35 = null;
    L116:
        r25 = (com.bytedance.android.ec.core.anchorv3.i) r35;     // Catch: Throwable -> L133
    L118:
        if ((r24 instanceof JSONObject) == false) goto L120;
    L184:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r24.toString(), com.bytedance.android.ec.core.anchorv3.i.class);     // Catch: Throwable -> L126
        if ((r36 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L124;
        r36 = null;
    L124:
        Object r37 = Result.constructor-impl((com.bytedance.android.ec.core.anchorv3.i) r36);     // Catch: Throwable -> L126
    L128:
        r25 = r37;
        if (Result.isFailure-impl(r25) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L133
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r24 instanceof JSONArray) == false) goto L130;
    L87:
        r31 = r24;
    L133:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L159
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L181:
        return (com.bytedance.android.ec.core.anchorv3.i) r19;
    L11:
        if ((r15 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L13;
        Object r40 = null;
    L14:
        r16 = (com.bytedance.android.ec.core.anchorv3.i) r40;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r41 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r41 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L24;
        r41 = null;
    L24:
        r16 = (com.bytedance.android.ec.core.anchorv3.i) r41;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r42 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r42 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L30;
        r42 = null;
    L30:
        r16 = (com.bytedance.android.ec.core.anchorv3.i) r42;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r43 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r43 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L36;
        r43 = null;
    L36:
        r16 = (com.bytedance.android.ec.core.anchorv3.i) r43;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.i.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r44 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r44 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L42;
        r44 = null;
    L42:
        r16 = (com.bytedance.android.ec.core.anchorv3.i) r44;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L188:
        Object r45 = SDKSettingsCacheManager.a().fromJson(r15.toString(), com.bytedance.android.ec.core.anchorv3.i.class);     // Catch: Throwable -> L52
        if ((r45 instanceof com.bytedance.android.ec.core.anchorv3.i) == true) goto L50;
        r45 = null;
    L50:
        Object r46 = Result.constructor-impl((com.bytedance.android.ec.core.anchorv3.i) r45);     // Catch: Throwable -> L52
    L54:
        r16 = r46;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L59
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r40 = r15;
    L59:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L171
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L176;
        EnsureManager.ensureNotReachHere(r51);
    L176:
        if (Result.isFailure-impl(r50) == true) goto L179;
        r10 = r50;
    L179:
        r19 = r10;
        goto L181
    }

    @SettingPanel("内流预链接图片域名")
    public static final List<String> x() {
        int r0 = p.a;
        Object r1 = CollectionsKt.emptyList();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_goods_feed_host_list", List.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详性能优化一期-已固化")
    public static final m x0() {
        int r0 = j.a;
        Object r1 = com.bytedance.android.ec.core.abtest.e.a(new m(true, true, 1, true, true, 625), new m(false, false, 0, false, false, 1023));
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L59
        if (r14 != null) goto L11;
    L56:
        Object r15 = null;
    L57:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L59
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L171
        if (r17 == null) goto L65;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L171
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = null;
    L68:
        if ((r16 instanceof m) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (m) r16;     // Catch: Throwable -> L171
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L171
        Object r19 = SDKSettingsCacheManager.a.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L171
        if ((r19 instanceof m) == true) goto L76;
        r19 = null;
    L76:
        r18 = (m) r19;     // Catch: Throwable -> L171
    L77:
        if (r18 != null) goto L181;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L171
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.exceptionOrNull-impl(r22) != null) goto L194;
    L163:
        r18 = r22;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_v1", r18);     // Catch: Throwable -> L171
        goto L181
    L194:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_v1", m.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L163;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_v1");     // Catch: Throwable -> L133
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
        if ((r25 instanceof m) == true) goto L144;
        r25 = null;
    L144:
        r22 = (m) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_pdp_perf_opt_v1", m.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof m) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (m) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof m) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (m) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof m) == true) goto L98;
        r31 = null;
    L98:
        r24 = (m) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof m) == true) goto L104;
        r32 = null;
    L104:
        r24 = (m) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof m) == true) goto L110;
        r33 = null;
    L110:
        r24 = (m) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof m) == true) goto L116;
        r34 = null;
    L116:
        r24 = (m) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L192:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), m.class);     // Catch: Throwable -> L126
        if ((r35 instanceof m) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((m) r35);     // Catch: Throwable -> L126
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
    L181:
        return (m) r18;
    L11:
        if ((r14 instanceof m) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (m) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof m) == true) goto L24;
        r40 = null;
    L24:
        r15 = (m) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof m) == true) goto L30;
        r41 = null;
    L30:
        r15 = (m) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof m) == true) goto L36;
        r42 = null;
    L36:
        r15 = (m) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof m) == true) goto L42;
        r43 = null;
    L42:
        r15 = (m) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L182:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), m.class);     // Catch: Throwable -> L52
        if ((r44 instanceof m) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((m) r44);     // Catch: Throwable -> L52
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
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L171
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L176;
        EnsureManager.ensureNotReachHere(r50);
    L176:
        if (Result.isFailure-impl(r49) == true) goto L179;
        r1 = r49;
    L179:
        r18 = r1;
        goto L181
    }

    @SettingPanel("自动领券收敛到交易链路控制-内流")
    public static final int y() {
        int r0 = j.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L183;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("ec_inner_feed_auto_coupon_opt_ab", r18);     // Catch: Throwable -> L166
        goto L176
    L183:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_inner_feed_auto_coupon_opt_ab", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r1;
    L160:
        r22 = r1;
        goto L161
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("ec_inner_feed_auto_coupon_opt_ab");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        Integer r27 = (Integer) r25;     // Catch: Throwable -> L153
        if (r27 == null) goto L141;
        r18 = r27;
        goto L164
    L141:
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L153
        Object r29 = jj4.a.a("ec_inner_feed_auto_coupon_opt_ab", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r29 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r29 instanceof Integer) == false) goto L148;
        r13 = r29;
    L148:
        Object r30 = (Integer) r13;     // Catch: Throwable -> L153
        if (r30 != null) goto L151;
        r30 = r1;
    L151:
        r22 = Result.constructor-impl(r30);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r31 = null;
    L85:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r32 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L95;
        r32 = null;
    L95:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r33 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L101;
        r33 = null;
    L101:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r34 instanceof Integer) == true) goto L110;
        r34 = null;
    L110:
        r24 = (Integer) r34;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L181:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r35 instanceof Integer) == true) goto L118;
        r35 = null;
    L118:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L120
    L122:
        r24 = r36;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L127
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r31 = r23;
    L127:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r18).intValue();
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r42 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r15 = (Integer) r42;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L179:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r43 instanceof Integer) == true) goto L47;
        r43 = null;
    L47:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L49
    L51:
        r15 = r44;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L56
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r39 = r14;
    L56:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r18 = r1;
        goto L176
    }

    @SettingPanel("商详性能优化二期-已固化")
    public static final com.bytedance.android.ec.core.anchorv3.n y0() {
        int r0 = j.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(new com.bytedance.android.ec.core.anchorv3.n(true, true, true, 3, 3, true, 2, true, 7, 14344), new com.bytedance.android.ec.core.anchorv3.n(false, false, false, 0, 0, false, 0, false, 0, 16383));
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L171
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        Object r14 = null;
        r13.getClass();     // Catch: Throwable -> L59
        Object r15 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
    L56:
        Object r16 = null;
    L57:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L171
        if (r18 == null) goto L65;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L171
    L65:
        if (Result.isFailure-impl(r17) == false) goto L68;
        r17 = null;
    L68:
        if ((r17 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L70;
        r17 = null;
    L70:
        Object r19 = (com.bytedance.android.ec.core.anchorv3.n) r17;     // Catch: Throwable -> L171
        if (r19 != null) goto L77;
        r13.getClass();     // Catch: Throwable -> L171
        Object r20 = SDKSettingsCacheManager.a.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L171
        if ((r20 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L76;
        r20 = null;
    L76:
        r19 = (com.bytedance.android.ec.core.anchorv3.n) r20;     // Catch: Throwable -> L171
    L77:
        if (r19 != null) goto L181;
        int r21 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L171
    L159:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L171
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L162:
        if (Result.exceptionOrNull-impl(r19) != null) goto L194;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("ec_pdp_perf_opt_v2", r19);     // Catch: Throwable -> L171
        goto L181
    L194:
        r19 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_perf_opt_v2", com.bytedance.android.ec.core.anchorv3.n.class, r10);     // Catch: Throwable -> L166
    L167:
        if (r19 != null) goto L169;
        r19 = r10;
    L166:
        r19 = r10;
        goto L167
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_pdp_perf_opt_v2");     // Catch: Throwable -> L133
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
        if ((r25 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L144;
        r25 = null;
    L144:
        r19 = (com.bytedance.android.ec.core.anchorv3.n) r25;     // Catch: Throwable -> L159
        if (r19 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_pdp_perf_opt_v2", com.bytedance.android.ec.core.anchorv3.n.class, r10, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof com.bytedance.android.ec.core.anchorv3.n) == false) goto L154;
        r14 = r28;
    L154:
        Object r29 = (com.bytedance.android.ec.core.anchorv3.n) r14;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r10;
    L157:
        r19 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (com.bytedance.android.ec.core.anchorv3.n) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L98;
        r31 = null;
    L98:
        r24 = (com.bytedance.android.ec.core.anchorv3.n) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L104;
        r32 = null;
    L104:
        r24 = (com.bytedance.android.ec.core.anchorv3.n) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L110;
        r33 = null;
    L110:
        r24 = (com.bytedance.android.ec.core.anchorv3.n) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L116;
        r34 = null;
    L116:
        r24 = (com.bytedance.android.ec.core.anchorv3.n) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L192:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), com.bytedance.android.ec.core.anchorv3.n.class);     // Catch: Throwable -> L126
        if ((r35 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((com.bytedance.android.ec.core.anchorv3.n) r35);     // Catch: Throwable -> L126
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
    L181:
        return (com.bytedance.android.ec.core.anchorv3.n) r19;
    L11:
        if ((r15 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L13;
        Object r39 = null;
    L14:
        r16 = (com.bytedance.android.ec.core.anchorv3.n) r39;     // Catch: Throwable -> L59
        if (r16 != null) goto L57;
        if ((r15 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L24;
        r40 = null;
    L24:
        r16 = (com.bytedance.android.ec.core.anchorv3.n) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L30;
        r41 = null;
    L30:
        r16 = (com.bytedance.android.ec.core.anchorv3.n) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L36;
        r42 = null;
    L36:
        r16 = (com.bytedance.android.ec.core.anchorv3.n) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.core.anchorv3.n.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L42;
        r43 = null;
    L42:
        r16 = (com.bytedance.android.ec.core.anchorv3.n) r43;     // Catch: Throwable -> L59
    L44:
        if ((r15 instanceof JSONObject) == false) goto L46;
    L182:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r15.toString(), com.bytedance.android.ec.core.anchorv3.n.class);     // Catch: Throwable -> L52
        if ((r44 instanceof com.bytedance.android.ec.core.anchorv3.n) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((com.bytedance.android.ec.core.anchorv3.n) r44);     // Catch: Throwable -> L52
    L54:
        r16 = r45;
        if (Result.isFailure-impl(r16) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L59
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r15 instanceof JSONArray) == false) goto L56;
    L13:
        r39 = r15;
    L59:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L171
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Object r49 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r49);
        if (r50 == null) goto L176;
        EnsureManager.ensureNotReachHere(r50);
    L176:
        if (Result.isFailure-impl(r49) == true) goto L179;
        r10 = r49;
    L179:
        r19 = r10;
        goto L181
    }

    @SettingPanel("电商直播策略服务开关")
    public static final boolean z() {
        int r0 = j.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L59
        Object r14 = SDKSettingsCacheManager.b.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L59
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
        if ((r16 instanceof Boolean) == true) goto L70;
        r16 = null;
    L70:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L172
        if (r18 != null) goto L77;
        r12.getClass();     // Catch: Throwable -> L172
        Object r19 = SDKSettingsCacheManager.a.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L172
        if ((r19 instanceof Boolean) == true) goto L76;
        r19 = null;
    L76:
        r18 = (Boolean) r19;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_ligo_strategy_switch", r18);     // Catch: Throwable -> L172
        goto L182
    L185:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_ligo_strategy_switch", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r22 != null) goto L169;
        r18 = r1;
    L166:
        r22 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r23 = SDKSettingsCacheManager.b.get("ec_ligo_strategy_switch");     // Catch: Throwable -> L133
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
        if ((r25 instanceof Boolean) == true) goto L144;
        r25 = null;
    L144:
        r22 = (Boolean) r25;     // Catch: Throwable -> L159
        if (r22 != null) goto L169;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L159
        Object r28 = jj4.a.a("ec_ligo_strategy_switch", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r28 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r28 instanceof Boolean) == false) goto L154;
        r13 = r28;
    L154:
        Object r29 = (Boolean) r13;     // Catch: Throwable -> L159
        if (r29 != null) goto L157;
        r29 = r1;
    L157:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L159
    L85:
        if ((r23 instanceof Boolean) == true) goto L87;
        Object r30 = null;
    L88:
        r24 = (Boolean) r30;     // Catch: Throwable -> L133
        if (r24 != null) goto L131;
        if ((r23 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L98;
        r31 = null;
    L98:
        r24 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L104;
        r32 = null;
    L104:
        r24 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r33 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Boolean) r33;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r34 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L133
        if ((r34 instanceof Boolean) == true) goto L116;
        r34 = null;
    L116:
        r24 = (Boolean) r34;     // Catch: Throwable -> L133
    L118:
        if ((r23 instanceof JSONObject) == false) goto L120;
    L183:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L126
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
        return ((Boolean) r18).booleanValue();
    L11:
        if ((r14 instanceof Boolean) == true) goto L13;
        Object r39 = null;
    L14:
        r15 = (Boolean) r39;     // Catch: Throwable -> L59
        if (r15 != null) goto L57;
        if ((r14 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r40 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L24;
        r40 = null;
    L24:
        r15 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r41 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L30;
        r41 = null;
    L30:
        r15 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r42 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L36;
        r42 = null;
    L36:
        r15 = (Boolean) r42;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r43 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L59
        if ((r43 instanceof Boolean) == true) goto L42;
        r43 = null;
    L42:
        r15 = (Boolean) r43;     // Catch: Throwable -> L59
    L44:
        if ((r14 instanceof JSONObject) == false) goto L46;
    L189:
        Object r44 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r44 instanceof Boolean) == true) goto L50;
        r44 = null;
    L50:
        Object r45 = Result.constructor-impl((Boolean) r44);     // Catch: Throwable -> L52
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

    @SettingPanel("商详修复小红条半屏关闭没有跟随消失问题")
    public static final boolean z0() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r11 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r12 = null;
        r11.getClass();     // Catch: Throwable -> L59
        Object r13 = SDKSettingsCacheManager.b.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L59
        if (r13 != null) goto L11;
    L56:
        Object r14 = null;
    L57:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L59
    L61:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L172
        if (r16 == null) goto L65;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r15) == false) goto L68;
        r15 = null;
    L68:
        if ((r15 instanceof Boolean) == true) goto L70;
        r15 = null;
    L70:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L172
        if (r17 != null) goto L77;
        r11.getClass();     // Catch: Throwable -> L172
        Object r18 = SDKSettingsCacheManager.a.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L172
        if ((r18 instanceof Boolean) == true) goto L76;
        r18 = null;
    L76:
        r17 = (Boolean) r18;     // Catch: Throwable -> L172
    L77:
        if (r17 != null) goto L182;
        int r19 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L172
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r21) != null) goto L185;
    L169:
        r17 = r21;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_fix_red_tip_diss_miss", r17);     // Catch: Throwable -> L172
        goto L182
    L185:
        r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_fix_red_tip_diss_miss", Boolean.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r21 != null) goto L169;
        r17 = r1;
    L166:
        r21 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r22 = SDKSettingsCacheManager.b.get("ec_pdp_fix_red_tip_diss_miss");     // Catch: Throwable -> L133
        if (r22 != null) goto L85;
    L130:
        Object r23 = null;
    L131:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L133
    L135:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L159
        if (r25 == null) goto L139;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r24) == false) goto L142;
        r24 = null;
    L142:
        if ((r24 instanceof Boolean) == true) goto L144;
        r24 = null;
    L144:
        r21 = (Boolean) r24;     // Catch: Throwable -> L159
        if (r21 != null) goto L169;
        jj4.b r26 = jj4.b.b;     // Catch: Throwable -> L159
        Object r27 = jj4.a.a("ec_pdp_fix_red_tip_diss_miss", Boolean.class, r1, false);     // Catch: Throwable -> L159
        if (r27 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r27 instanceof Boolean) == false) goto L154;
        r12 = r27;
    L154:
        Object r28 = (Boolean) r12;     // Catch: Throwable -> L159
        if (r28 != null) goto L157;
        r28 = r1;
    L157:
        r21 = Result.constructor-impl(r28);     // Catch: Throwable -> L159
    L85:
        if ((r22 instanceof Boolean) == true) goto L87;
        Object r29 = null;
    L88:
        r23 = (Boolean) r29;     // Catch: Throwable -> L133
        if (r23 != null) goto L131;
        if ((r22 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r30 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L133
        if ((r30 instanceof Boolean) == true) goto L98;
        r30 = null;
    L98:
        r23 = (Boolean) r30;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r31 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L133
        if ((r31 instanceof Boolean) == true) goto L104;
        r31 = null;
    L104:
        r23 = (Boolean) r31;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r32 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L133
        if ((r32 instanceof Boolean) == true) goto L110;
        r32 = null;
    L110:
        r23 = (Boolean) r32;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L133
        if ((r33 instanceof Boolean) == true) goto L116;
        r33 = null;
    L116:
        r23 = (Boolean) r33;     // Catch: Throwable -> L133
    L118:
        if ((r22 instanceof JSONObject) == false) goto L120;
    L183:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r34 instanceof Boolean) == true) goto L124;
        r34 = null;
    L124:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L126
    L128:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L133
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r22 instanceof JSONArray) == false) goto L130;
    L87:
        r29 = r22;
    L133:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L159
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r17).booleanValue();
    L11:
        if ((r13 instanceof Boolean) == true) goto L13;
        Object r38 = null;
    L14:
        r14 = (Boolean) r38;     // Catch: Throwable -> L59
        if (r14 != null) goto L57;
        if ((r13 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L59
        if ((r39 instanceof Boolean) == true) goto L24;
        r39 = null;
    L24:
        r14 = (Boolean) r39;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L59
        if ((r40 instanceof Boolean) == true) goto L30;
        r40 = null;
    L30:
        r14 = (Boolean) r40;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L59
        if ((r41 instanceof Boolean) == true) goto L36;
        r41 = null;
    L36:
        r14 = (Boolean) r41;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L59
        if ((r42 instanceof Boolean) == true) goto L42;
        r42 = null;
    L42:
        r14 = (Boolean) r42;     // Catch: Throwable -> L59
    L44:
        if ((r13 instanceof JSONObject) == false) goto L46;
    L189:
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r43 instanceof Boolean) == true) goto L50;
        r43 = null;
    L50:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L52
    L54:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L59
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r13 instanceof JSONArray) == false) goto L56;
    L13:
        r38 = r13;
    L59:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L172
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L177;
        EnsureManager.ensureNotReachHere(r49);
    L177:
        if (Result.isFailure-impl(r48) == true) goto L180;
        r1 = r48;
    L180:
        r17 = r1;
        goto L182
    }
}
