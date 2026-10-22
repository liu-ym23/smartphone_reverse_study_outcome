package com.bytedance.android.ec.common.impl.sku.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k2;
import com.bytedance.android.ec.core.utils.n0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r22, SkuViewModel r23) {
        Intrinsics.checkNotNullParameter(r22, "originUrl");
        Intrinsics.checkNotNullParameter(r23, "viewModel");
        Uri r10 = UriProtector.parse(r22);
        if (r23.isInSecKill() == false) goto L6;
        String r0 = com.bytedance.android.ec.core.event.a.VALUE_SECKILL;
    L9:
        SkuParams r11 = r23.getSkuParams();
        int r12 = ECSdk.a;
        IEntranceInfoService r13 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r13 == null) goto L12;
        gl.a r14 = r13.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), r11.getEntranceInfo());
    L14:
        if (r14 == null) goto L20;
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, 1);
        String r16 = r23.getApplyCouponIds();
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        r15[1] = TuplesKt.to("coupon_id", r16);
        r15[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "1");
        r14.g(r15);
    L20:
        if (r14 == null) goto L23;
        r14.delete(new String[]{com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID});
    L23:
        if (r14 == null) goto L53;
        Pair[] r17 = new Pair[16];
        r17[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, r0);
        ECAdLogExtra r1 = r11.getAdLogExtra();
        if (r1 == null) goto L27;
        String r18 = r1.getCreativeId();
    L28:
        r17[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CID, r18);
        SkuExtraData r19 = r11.getSkuExtraData();
        if (r19 == null) goto L31;
        String r20 = r19.getBrandVerified();
    L32:
        r17[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r20);
        SkuExtraData r21 = r11.getSkuExtraData();
        if (r21 == null) goto L35;
        String r24 = r21.getLabelName();
    L36:
        r17[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r24);
        SkuExtraData r25 = r11.getSkuExtraData();
        if (r25 == null) goto L39;
        String r26 = r25.getLabelNameLive();
    L40:
        r17[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r26);
        SkuExtraData r27 = r11.getSkuExtraData();
        if (r27 == null) goto L43;
        String r28 = r27.getHasReplay();
    L44:
        r17[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, r28);
        r17[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE));
        SkuExtraData r29 = r11.getSkuExtraData();
        if (r29 == null) goto L47;
        String r30 = r29.getProductTypeVerified();
    L48:
        r17[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r30);
        r17[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS));
        SkuExtraData r31 = r11.getSkuExtraData();
        if (r31 == null) goto L51;
        String r32 = r31.getWithVideo();
    L52:
        r17[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, r32);
        r17[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE));
        r17[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE));
        r17[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r11.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r17[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r11.getPromotionId());
        r17[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r11.getCommodityType());
        r17[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r11.getProductId());
        r14.j(r17, AnchorV3SkuOrderUrlHelper$addEntranceInfoToOrderUrl$1.INSTANCE);
        goto L53
    L51:
        r32 = null;
        goto L52
    L47:
        r30 = null;
        goto L48
    L43:
        r28 = null;
        goto L44
    L39:
        r26 = null;
        goto L40
    L35:
        r24 = null;
        goto L36
    L31:
        r20 = null;
        goto L32
    L27:
        r18 = null;
    L53:
        JSONObject r33 = jg.g.e(r11.getTransmissibleJson());
        if (r33 == null) goto L58;
        Map<String, String> r34 = z1.j(r33);
        if (r14 == null) goto L58;
        r14.putAll(r34);
    L58:
        if (r14 == null) goto L60;
        String r35 = r14.h();
    L61:
        JSONObject r36 = jg.g.e(r35);
        if (r36 != null) goto L64;
        r36 = new JSONObject();
    L64:
        SkuOrderParams r37 = r11.getOrderParams();
        String r38 = com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO;
        if (r37 == null) goto L75;
        JSONObject r39 = jg.g.f(r37.getMegaObject());
        if (r39 == null) goto L71;
        Object r40 = r39.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r40 == null) goto L71;
        String r41 = r40.toString();
    L72:
        JSONObject r42 = jg.g.e(r41);
        if (r42 == null) goto L75;
        ul.e.a(r36, r42);
    L71:
        r41 = null;
    L75:
        JSONObject r43 = EcomBcmTracker.c(null, r36);
        if (r43 != null) goto L78;
        r43 = r36;
    L78:
        Uri r44 = UriProtector.parse(r22);
        String r45 = com.bytedance.android.ec.core.event.a.KEY_LOG_DATA;
        String r46 = UriProtector.getQueryParameter(r44, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);
        if (r46 == null) goto L81;
        JSONObject r47 = new JSONObject(r46);
    L82:
        SkuParams r110 = r23.getSkuParams();
        String r48 = r23.getSkuParams().getAnchorBuyNowLogData();
        if (r48 == null) goto L91;
        JSONObject r49 = jg.g.e(r48);
        if (r49 == null) goto L91;
        Iterator<String> r111 = r49.keys();
        if (r111 == null) goto L91;
    L89:
        if (r111.hasNext() == false) goto L91;
        String r210 = r45;
        String r50 = r111.next();
        r47.put(r50, r49.optString(r50));
        r38 = r38;
        r45 = r210;
    L91:
        String r211 = r38;
        String r212 = r45;
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, 1);
        String r51 = r23.getApplyCouponIds();
        if (r51 != null) goto L94;
        r51 = "";
    L94:
        r47.putOpt("coupon_id", r51);
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, r110.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE));
        String r52 = r110.getEcomEntranceForm();
        if (r52 != null) goto L97;
        r52 = (String) r110.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
    L97:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r52);
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "1");
        Map r53 = r110.getEventParams();
        r47.putOpt("new_user_activity", r53.get("new_user_activity"));
        r47.putOpt("new_user_activity_id", r53.get("new_user_activity_id"));
        r47.putOpt("campaign_type", r53.get("campaign_type"));
        r47.putOpt("campaign_sub_type", r53.get("campaign_sub_type"));
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r53.get(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT));
        r47.putOpt("coupon_id", r53.get("coupon_id"));
        String r54 = "0";
        if (r23.getSkuParams().isGroupingBuy() == false) goto L100;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, "1");
    L101:
        String r55 = (String) r23.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);
        if (r55 != null) goto L104;
        r55 = "0";
    L104:
        r47.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r55);
        SkuExtraData r56 = r110.getSkuExtraData();
        if (r56 == null) goto L109;
        String r57 = r56.getProductTypeVerified();
        if (r57 == null) goto L109;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r57);
    L109:
        SkuExtraData r58 = r110.getSkuExtraData();
        if (r58 == null) goto L115;
        String r59 = r58.getBrandVerified();
        if (r59 == null) goto L115;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r59);
    L115:
        if (StringsKt.isBlank(r47.optString(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS)) == false) goto L123;
        SkuExtraData r60 = r110.getSkuExtraData();
        if (r60 != null) goto L119;
    L121:
        Object r61 = "0";
    L122:
        r47.put(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS, r61);
        goto L123
    L119:
        if (r60.isCrossborderProduct() != true) goto L121;
        r61 = "1";
    L123:
        SkuExtraData r62 = r110.getSkuExtraData();
        if (r62 == null) goto L128;
        String r63 = r62.getGoodsType();
        if (r63 == null) goto L128;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_GOODS_TYPE, r63);
    L128:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r110.getAuthorId());
        SkuExtraData r64 = r110.getSkuExtraData();
        if (r64 == null) goto L133;
        String r65 = r64.getLabelName();
        if (r65 == null) goto L133;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r65);
    L133:
        Map r66 = r110.getEventParams();
        if (r66 == null) goto L136;
        String r67 = (String) r66.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L137:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r67);
        SkuExtraData r68 = r110.getSkuExtraData();
        if (r68 == null) goto L142;
        String r69 = r68.getLabelNameLive();
        if (r69 == null) goto L142;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r69);
    L142:
        SkuExtraData r70 = r110.getSkuExtraData();
        if (r70 == null) goto L148;
        String r71 = r70.isAuthenticInsure();
        if (r71 == null) goto L148;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_IS_AUTHENTIC_INSURE, r71);
    L148:
        if (r23.isInDepositPresale() == false) goto L150;
        r54 = "1";
    L150:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r54);
        SkuExtraData r72 = r23.getSkuParams().getSkuExtraData();
        if (r72 == null) goto L155;
        String r73 = r72.getSourcePage();
        if (r73 == null) goto L155;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r73);
    L155:
        Map r74 = r110.getEventParams();
        if (r74 == null) goto L158;
        String r75 = (String) r74.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L159:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r75);
        Map r76 = r110.getEventParams();
        if (r76 == null) goto L162;
        String r77 = (String) r76.get(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE);
    L163:
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r77);
        r47.putOpt(com.bytedance.android.ec.core.event.a.KEY_ITEM_ID, r110.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ITEM_ID));
        String r78 = r23.getSkuParams().getTransmissibleJson();
        if (r78 != null) goto L166;
    L180:
        SkuExtraData r79 = r23.getSkuParams().getSkuExtraData();
        if (r79 == null) goto L199;
        String r80 = r79.getTransitionTrackerData();
        if (r80 == null) goto L199;
        if (r80.length() <= 0) goto L187;
        boolean r81 = true;
    L188:
        if (r81 == true) goto L191;
        r80 = null;
    L191:
        if (r80 == null) goto L199;
        JSONObject r82 = new JSONObject(r80);     // Catch: Exception -> L197
        Iterator<String> r83 = r82.keys();     // Catch: Exception -> L197
    L194:
        if (r83.hasNext() == false) goto L199;
        String r84 = r83.next();     // Catch: Exception -> L197
        r47.put(r84, r82.optString(r84));     // Catch: Exception -> L197
    L197:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L199
    L187:
        r81 = false;
    L199:
        r47.remove(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE);
        String r85 = r110.getEntranceInfo();
        if (r85 == null) goto L204;
        JSONObject r86 = jg.g.f(r85);
        if (r86 == null) goto L204;
        r47.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r86.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE));
        r47.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r86.optString(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD));
        r47.put(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE, r86.optString(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE));
        r47.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_TYPE, r86.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_TYPE));
        r47.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r86.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));
    L204:
        JSONObject r87 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L207;
        r87.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r88 = jg.d.a;
        r87.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r87.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r87.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, jg.d.a());
    L207:
        String r89 = r23.getSelectFxhMethod();
        if (r89 == null) goto L219;
        if (r89.length() <= 0) goto L212;
        boolean r90 = true;
    L213:
        if (r90 == true) goto L216;
        r89 = null;
    L216:
        if (r89 == null) goto L219;
        r87.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r89);
        goto L219
    L212:
        r90 = false;
    L219:
        if (UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT) == null) goto L221;
        boolean r91 = true;
    L222:
        int r92 = jg.e.a;
        String r93 = jg.e.c(jg.e.c(jg.e.c(r22, r211, r43.toString()), r212, r47.toString()), com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r87.toString());
        SkuExtraData r94 = r23.getSkuParams().getSkuExtraData();
        if (r94 == null) goto L226;
        String r95 = r94.getMarketChannel();
        if (r95 == null) goto L226;
    L227:
        String r96 = jg.e.b(r93, com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r95);
        if (r23.getSelectPoiInfo().a() == null) goto L232;
        ProductSelectPoiInfo r97 = (ProductSelectPoiInfo) r23.getSelectPoiInfo().a();
        if (r97 == null) goto L239;
        String r98 = r97.getPoiId();
    L240:
        String r99 = r23.getCurrentPromiseType();
        if (r99 != null) goto L243;
    L251:
        if (r98 != null) goto L253;
        r98 = "";
    L253:
        String r100 = jg.e.b(r96, "poi_id", r98);
        String r101 = UriProtector.getQueryParameter(r10, "mega_object");
        if (r101 == null) goto L263;
        JSONObject r102 = new JSONObject(r101);
        JSONObject r103 = jg.g.f(new JSONObject(r101).optString(r211));
        if (r103 == null) goto L258;
        r103.remove(com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID);
        Unit r104 = Unit.INSTANCE;
    L259:
        String r105 = r102.put(r211, String.valueOf(r103)).toString();
        if (r105 != null) goto L262;
        r105 = "";
    L262:
        r100 = jg.e.a(r100, "mega_object", r105);
        goto L263
    L258:
        r103 = null;
    L263:
        String r106 = jg.e.b(r100, "iesec_auto_coupon_opt_ab", "1");
        String r107 = r23.getComboId();
        Long r108 = Long.valueOf(r23.getCurrentCount());
        ECAdLogExtra r109 = r23.getSkuParams().getAdLogExtra();
        ECBoltParam r112 = r23.getSkuParams().getBoltParam();
        String r113 = r43.toString();
        String r114 = r23.getSkuParams().getSpellGroupId();
        ECAdInfo r115 = r23.getSkuParams().getLatestRecommendFeedAdInfo();
        SkuParams r116 = r23.getSkuParams();
        if (r106 != null) goto L266;
    L268:
        r106 = null;
    L269:
        if (r106 != null) goto L271;
        String r117 = "";
    L272:
        n0 r118 = new n0(r117, false);
        if (r107 == null) goto L275;
        r118.b(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r107);
    L275:
        if (r108 == null) goto L277;
        r118.a("combo_num", r108.longValue());
    L277:
        if (r114 == null) goto L279;
        r118.b("spell_group_id", r114);
    L279:
        if (r112 == null) goto L288;
        String r119 = r112.getActivityId();
        if (r119 == null) goto L288;
        if ((!TextUtils.isEmpty(r119)) == true) goto L286;
        r119 = null;
    L286:
        if (r119 == null) goto L288;
        r118.b("activity_id", r119);
    L288:
        if (r112 == null) goto L297;
        String r120 = r112.getNewSourceId();
        if (r120 == null) goto L297;
        if ((!TextUtils.isEmpty(r120)) == true) goto L295;
        r120 = null;
    L295:
        if (r120 == null) goto L297;
        r118.b("new_source_id", r120);
    L297:
        if (r113 != null) goto L299;
    L304:
        r118.a("page_init_timestamp", System.currentTimeMillis());
        SkuOrderParams r121 = r116.getOrderParams();
        if (r121 == null) goto L312;
        Map r122 = com.bytedance.android.shopping.extensions.k.z(r121.getQueryItems());
        if (r122 == null) goto L312;
        Iterator r123 = r122.entrySet().iterator();
    L310:
        if (r123.hasNext() == false) goto L312;
        Map.Entry r124 = (Map.Entry) r123.next();
        r118.b((String) r124.getKey(), String.valueOf(r124.getValue()));
    L312:
        int r125 = a.a;
        String r126 = a.a(r118.c(), r109, r115, r91);
        String r127 = k2.a(r126, r23.getSkuParams().getV3EventAdditions());
        if (r127 != null) goto L316;
        return r126;
    L316:
        return r127;
    L299:
        if ((!TextUtils.isEmpty(r113)) == true) goto L302;
        r113 = null;
    L302:
        if (r113 == null) goto L304;
        r118.b(r211, r113);
        goto L304
    L271:
        r117 = r106;
        goto L272
    L266:
        if ((!TextUtils.isEmpty(r106)) == false) goto L268;
    L243:
        if (r99.length() <= 0) goto L245;
        boolean r128 = true;
    L246:
        if (r128 == true) goto L249;
        r99 = null;
    L249:
        if (r99 == null) goto L251;
        r96 = jg.e.b(r96, "promise_type", r99);
        goto L251
    L245:
        r128 = false;
    L239:
        r98 = null;
        goto L240
    L232:
        SkuInfoVO r129 = (SkuInfoVO) r23.getSkuInfo().a();
        if (r129 == null) goto L239;
        SkuPoiInfo r130 = r129.getPoiInfo();
        if (r130 == null) goto L239;
        ProductSelectPoiInfo r131 = r130.getSelectedPoiInfo();
        if (r131 == null) goto L239;
        r98 = r131.getPoiId();
    L226:
        r95 = "";
        goto L227
    L221:
        r91 = false;
        goto L222
    L166:
        if (r78.length() <= 0) goto L168;
        boolean r132 = true;
    L169:
        if (r132 == true) goto L172;
        r78 = null;
    L172:
        if (r78 == null) goto L180;
        JSONObject r133 = new JSONObject(r78);     // Catch: Exception -> L178
        Iterator<String> r134 = r133.keys();     // Catch: Exception -> L178
    L175:
        if (r134.hasNext() == false) goto L180;
        String r135 = r134.next();     // Catch: Exception -> L178
        r47.put(r135, r133.optString(r135));     // Catch: Exception -> L178
    L178:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L180
    L168:
        r132 = false;
        goto L169
    L162:
        r77 = null;
        goto L163
    L158:
        r75 = null;
        goto L159
    L136:
        r67 = null;
        goto L137
    L100:
        r47.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, "0");
        goto L101
    L81:
        r47 = new JSONObject();
        goto L82
    L60:
        r35 = null;
        goto L61
    L12:
        r14 = null;
        goto L14
    L6:
        if (r23.isInPreSecKill() == false) goto L8;
        r0 = com.bytedance.android.ec.core.event.a.VALUE_PRE_SECKILL;
        goto L9
    L8:
        r0 = null;
        goto L9
    }
}
