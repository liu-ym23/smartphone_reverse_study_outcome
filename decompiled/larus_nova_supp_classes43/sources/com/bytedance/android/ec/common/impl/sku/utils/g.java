package com.bytedance.android.ec.common.impl.sku.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String r26, SkuViewModel r27) {
        Intrinsics.checkNotNullParameter(r26, "orderUrl");
        Intrinsics.checkNotNullParameter(r27, "viewModel");
        SkuParams r10 = r27.getSkuParams();
        Map r11 = r10.getEventParams();
        String r12 = r27.getSelectFxhMethod();
        String r13 = "";
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        LinkedHashMap r14 = new LinkedHashMap();
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r12);
    L9:
        if (BuyNowPerformanceOpt.j() == true) goto L14;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r15 = jg.d.a;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        String r16 = jg.d.a();
        if (r16 != null) goto L13;
        r16 = "";
    L13:
        r14.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, r16);
        r14.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
    L14:
        String r0 = d.c(r26, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r14);
        Map r17 = MapsKt.toMutableMap(r10.getLiveEventParams());
        if (r11 == null) goto L17;
        String r18 = (String) r11.get("screen_type");
    L18:
        if (r18 != null) goto L20;
        r18 = "";
    L20:
        r17.put("screen_type", r18);
        if (r11 == null) goto L23;
        String r19 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING);
    L24:
        if (r19 != null) goto L26;
        r19 = "";
    L26:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, r19);
        Map r110 = r27.getSkuParams().getEventParams();
        if (r110 == null) goto L30;
        String r111 = (String) r110.get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);
        if (r111 == null) goto L30;
    L31:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r111);
        if (r11 == null) goto L34;
        String r112 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
    L35:
        if (r112 != null) goto L37;
        r112 = "";
    L37:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r112);
        if (r11 == null) goto L40;
        String r113 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL);
    L41:
        if (r113 != null) goto L43;
        r113 = "";
    L43:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r113);
        if (r11 == null) goto L46;
        String r114 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS);
    L47:
        if (r114 != null) goto L49;
        r114 = "";
    L49:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS, r114);
        if (r11 == null) goto L52;
        String r115 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
    L53:
        if (r115 != null) goto L55;
        r115 = "";
    L55:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r115);
        if (r11 == null) goto L58;
        String r116 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L59:
        if (r116 != null) goto L61;
        String r20 = "";
    L62:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r20);
        if (r11 == null) goto L65;
        String r117 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
    L67:
        if (r117 == null) goto L70;
        r13 = r117;
    L70:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r13);
        if (r11 == null) goto L73;
        String r118 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU);
    L75:
        if (r118 != null) goto L77;
        String r119 = "";
    L78:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, r119);
        if (r11 == null) goto L81;
        String r120 = (String) r11.get("is_explaining");
    L82:
        if (r120 != null) goto L84;
        r120 = "";
    L84:
        r17.put("is_explaining", r120);
        r17.put("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        r17.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "live");
        String r21 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r21 != null) goto L87;
        String r22 = "";
    L88:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r22);
        if (r10.isFromPlayback() == false) goto L91;
        r17.put("product_detail_reply", "1");
    L91:
        String r23 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
        if (r23 != null) goto L94;
        r23 = "";
    L94:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r23);
        b(r27, r17);
        String r1 = d.c(r0, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, r17);
        String r24 = r10.getSpellGroupId();
        if (r24 != null) goto L97;
    L100:
        boolean r25 = true;
    L101:
        if (r25 == true) goto L105;
        r1 = d.b(r1, "spell_group_id", r10.getSpellGroupId());
    L105:
        if (r27.getSelectPoiInfo().a() == null) goto L109;
        ProductSelectPoiInfo r28 = (ProductSelectPoiInfo) r27.getSelectPoiInfo().a();
        if (r28 == null) goto L116;
        String r29 = r28.getPoiId();
    L117:
        int r30 = jg.e.a;
        if (r29 != null) goto L120;
        r29 = "";
    L120:
        String r31 = jg.e.b(r1, "poi_id", r29);
        String r32 = r27.getCurrentPromiseType();
        if (r32 != null) goto L123;
    L131:
        Map r33 = new LinkedHashMap();
        String r34 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING);
        if (r34 != null) goto L134;
        r34 = "";
    L134:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, r34);
        Map r35 = r27.getSkuParams().getEventParams();
        if (r35 == null) goto L138;
        String r36 = (String) r35.get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);
        if (r36 == null) goto L138;
    L139:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r36);
        String r37 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
        if (r37 != null) goto L142;
        r37 = "";
    L142:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r37);
        String r38 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r38 != null) goto L145;
        r38 = "";
    L145:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r38);
        r33.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "live");
        String r39 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        if (r39 != null) goto L148;
        r39 = "";
    L148:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r39);
        String r40 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL);
        if (r40 != null) goto L151;
        r40 = "";
    L151:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r40);
        String r41 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
        if (r41 != null) goto L154;
        r41 = "";
    L154:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r41);
        String r42 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        if (r42 != null) goto L157;
        r42 = "";
    L157:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r42);
        String r43 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME);
        if (r43 != null) goto L160;
        r43 = "";
    L160:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r43);
        String r44 = (String) r11.get("is_explaining");
        if (r44 != null) goto L163;
        r44 = "";
    L163:
        r33.put("is_explaining", r44);
        String r45 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
        if (r45 != null) goto L166;
        r45 = "";
    L166:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r45);
        String r46 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_THREE_D);
        if (r46 != null) goto L169;
        r46 = "";
    L169:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r46);
        r33.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r27.getSkuParams().getPromotionId());
        String r47 = r27.getSkuParams().getCommodityType();
        if (r47 != null) goto L172;
        r47 = "";
    L172:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r47);
        String r48 = r27.getSkuParams().getProductId();
        if (r48 != null) goto L175;
        r48 = "";
    L175:
        r33.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r48);
        b(r27, r33);
        Map r49 = EcomBcmTracker.f(null, r33);
        if (r49 == null) goto L181;
        Iterator r50 = r49.entrySet().iterator();
    L179:
        if (r50.hasNext() == false) goto L181;
        Map.Entry r51 = (Map.Entry) r50.next();
        r33.put(r51.getKey(), String.valueOf(r51.getValue()));
    L181:
        int r52 = ECSdk.a;
        IEntranceInfoService r53 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r53 == null) goto L184;
        Map r54 = null;
        gl.a r55 = r53.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), null);
    L185:
        if (r55 == null) goto L187;
        r55.putAll(r33);
    L187:
        if (r55 == null) goto L191;
        String r56 = r55.h();
        if (r56 == null) goto L191;
        Map r57 = com.bytedance.android.shopping.extensions.k.z(r56);
    L193:
        if (TypeIntrinsics.isMutableMap(r57) == true) goto L195;
        r57 = r54;
    L195:
        if (r57 == null) goto L198;
        r33 = r57;
    L198:
        String r58 = d.c(r31, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r33);
        String r59 = r10.getSkuLogExtra();
        if (r59 != 0) goto L201;
    L209:
        String r60 = d.d(r58, "page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        String r61 = (String) r11.get(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME);
        if (r61 != null) goto L212;
        r61 = "";
    L212:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r61);
        String r62 = jg.e.b(r60, "iesec_auto_coupon_opt_ab", "1");
        String r63 = r27.getComboId();
        if (r63 != null) goto L215;
        String r64 = "";
    L217:
        return jg.e.c(jg.e.c(r62, com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r64), "combo_num", String.valueOf(r27.getCurrentCount()));
    L215:
        r64 = r63;
        goto L217
    L201:
        if (r59.length() <= 0) goto L203;
        boolean r65 = true;
    L204:
        if (r65 == true) goto L207;
        r59 = r54;
    L207:
        if (r59 == 0) goto L209;
        JSONObject r66 = new JSONObject(r59);
        r58 = d.c(r58, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, MapsKt.mapOf(new Pair[]{new Pair(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG, r66.optString(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG, r66.optString(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG, r66.optString(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG, r66.optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG))}));
        goto L209
    L203:
        r65 = false;
    L191:
        r57 = r54;
        goto L193
    L184:
        r54 = null;
        r55 = null;
    L138:
        r36 = "0";
        goto L139
    L123:
        if (r32.length() <= 0) goto L125;
        boolean r67 = true;
    L126:
        if (r67 == true) goto L129;
        r32 = null;
    L129:
        if (r32 == null) goto L131;
        r31 = jg.e.b(r31, "promise_type", r32);
        goto L131
    L125:
        r67 = false;
    L116:
        r29 = null;
        goto L117
    L109:
        SkuInfoVO r68 = (SkuInfoVO) r27.getSkuInfo().a();
        if (r68 == null) goto L116;
        SkuPoiInfo r69 = r68.getPoiInfo();
        if (r69 == null) goto L116;
        ProductSelectPoiInfo r70 = r69.getSelectedPoiInfo();
        if (r70 == null) goto L116;
        r29 = r70.getPoiId();
        goto L117
    L97:
        if (r24.length() == 0) goto L100;
        r25 = false;
        goto L101
    L87:
        r22 = r21;
        goto L88
    L81:
        r120 = null;
        goto L82
    L77:
        r119 = r118;
        goto L78
    L73:
        r118 = null;
        goto L75
    L65:
        r117 = null;
        goto L67
    L61:
        r20 = r116;
        goto L62
    L58:
        r116 = null;
        goto L59
    L52:
        r115 = null;
        goto L53
    L46:
        r114 = null;
        goto L47
    L40:
        r113 = null;
        goto L41
    L34:
        r112 = null;
    L30:
        r111 = "0";
        goto L31
    L23:
        r19 = null;
        goto L24
    L17:
        r18 = null;
        goto L18
    }

    public static void b(SkuViewModel r10, Map r11) {
        String r12 = r10.getSkuParams().getTransmissibleJson();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r12 = null;
    L11:
        if (r12 == null) goto L25;
        JSONObject r1 = new JSONObject(r12);     // Catch: Exception -> L17
        Iterator<String> r13 = r1.keys();     // Catch: Exception -> L17
    L14:
        if (r13.hasNext() == false) goto L26;
        String r14 = r13.next();     // Catch: Exception -> L17
        r11.put(r14, r1.optString(r14));     // Catch: Exception -> L17
        goto L14
    L26:
        return;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L25:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
