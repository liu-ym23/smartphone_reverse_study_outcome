package com.bytedance.android.ec.common.impl.sku;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k2;
import com.bytedance.android.ec.core.utils.n0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Observer<SkuInfoResponseDTO> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ SkuParams c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "d");
    }

    public final void onError(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        Context r11 = this.b;
        UIUtils.displayToast(r11, th.a.g(r11, 2131913822));
    }

    public final void onNext(Object r33) {
        SkuInfoResponseDTO r10 = (SkuInfoResponseDTO) r33;
        Intrinsics.checkNotNullParameter(r10, "response");
        String r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L33;
        OrderComponent r11 = r10.getOrderComponent();
        if (r11 == null) goto L13;
        String r12 = r11.getOrderUrl();
    L14:
        if (r12 != null) goto L16;
    L19:
        boolean r13 = true;
    L20:
        if (r13 == true) goto L33;
        OrderComponent r14 = r10.getOrderComponent();     // Catch: Exception -> L28
        if (r14 == null) goto L25;
        String r15 = r14.getOrderUrl();     // Catch: Exception -> L28
    L26:
        Uri.Builder r16 = UriProtector.parse(r15).buildUpon();     // Catch: Exception -> L28
        r16.appendQueryParameter("source_btm_token", this.a);     // Catch: Exception -> L28
        String r17 = r16.build().toString();     // Catch: Exception -> L28
    L36:
        String r18 = r17;
    L38:
        if (r18 == null) goto L338;
        int r19 = d.a;
        SkuParams r20 = this.c;
        String r21 = this.d;
        long r110 = this.e;
        int r22 = b.a;
        Intrinsics.checkNotNullParameter(r18, "originUrl");
        Intrinsics.checkNotNullParameter(r20, "skuParams");
        Intrinsics.checkNotNullParameter(r10, "dto");
        Intrinsics.checkNotNullParameter("", "couponId");
        Intrinsics.checkNotNullParameter(r21, "selectSkuId");
        Uri r111 = UriProtector.parse(r18);
        SkuInfoVO r23 = cg.f.d(r10);
        SkuItemInfoVO r112 = b.a(r23, r21);
        if (r112 != null) goto L42;
    L44:
        if (r112 != null) goto L46;
    L48:
        String r24 = null;
    L49:
        int r113 = ECSdk.a;
        IEntranceInfoService r114 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r114 == null) goto L52;
        gl.a r25 = r114.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), r20.getEntranceInfo());
    L54:
        if (r25 == null) goto L57;
        r25.g(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, 1), TuplesKt.to("coupon_id", ""), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "1")});
    L57:
        if (r25 == null) goto L60;
        r25.delete(new String[]{com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID});
    L60:
        if (r25 == null) goto L91;
        Pair[] r26 = new Pair[16];
        r26[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, r24);
        ECAdLogExtra r27 = r20.getAdLogExtra();
        if (r27 == null) goto L64;
        String r28 = r27.getCreativeId();
    L65:
        r26[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CID, r28);
        SkuExtraData r29 = r20.getSkuExtraData();
        if (r29 == null) goto L68;
        String r30 = r29.getBrandVerified();
    L69:
        r26[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r30);
        SkuExtraData r31 = r20.getSkuExtraData();
        if (r31 == null) goto L72;
        String r32 = r31.getLabelName();
    L73:
        r26[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r32);
        SkuExtraData r34 = r20.getSkuExtraData();
        if (r34 == null) goto L76;
        String r35 = r34.getLabelNameLive();
    L77:
        r26[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r35);
        SkuExtraData r36 = r20.getSkuExtraData();
        if (r36 == null) goto L80;
        String r37 = r36.getHasReplay();
    L81:
        r26[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, r37);
        r26[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE));
        SkuExtraData r38 = r20.getSkuExtraData();
        if (r38 == null) goto L84;
        String r39 = r38.getProductTypeVerified();
    L85:
        r26[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r39);
        r26[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS));
        SkuExtraData r40 = r20.getSkuExtraData();
        if (r40 == null) goto L88;
        String r41 = r40.getWithVideo();
    L89:
        r26[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, r41);
        r26[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE));
        r26[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE));
        r26[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r26[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r20.getPromotionId());
        r26[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r20.getCommodityType());
        r26[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r20.getProductId());
        r25.j(r26, BasicBuyNowOrderUrlHelper$addEntranceInfoToOrderUrl$1.INSTANCE);
        goto L91
    L88:
        r41 = null;
        goto L89
    L84:
        r39 = null;
        goto L85
    L80:
        r37 = null;
        goto L81
    L76:
        r35 = null;
        goto L77
    L72:
        r32 = null;
        goto L73
    L68:
        r30 = null;
        goto L69
    L64:
        r28 = null;
    L91:
        JSONObject r42 = jg.g.e(r20.getTransmissibleJson());
        if (r42 == null) goto L96;
        Map<String, String> r43 = z1.j(r42);
        if (r25 == null) goto L96;
        r25.putAll(r43);
    L96:
        if (r25 == null) goto L98;
        String r44 = r25.h();
    L99:
        JSONObject r45 = jg.g.e(r44);
        if (r45 != null) goto L102;
        r45 = new JSONObject();
    L102:
        SkuOrderParams r46 = r20.getOrderParams();
        String r47 = com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO;
        if (r46 == null) goto L113;
        JSONObject r48 = jg.g.f(r46.getMegaObject());
        if (r48 == null) goto L109;
        Object r49 = r48.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r49 == null) goto L109;
        String r50 = r49.toString();
    L110:
        JSONObject r51 = jg.g.e(r50);
        if (r51 == null) goto L113;
        ul.e.a(r45, r51);
    L109:
        r50 = null;
    L113:
        JSONObject r115 = EcomBcmTracker.c(null, r45);
        if (r115 == null) goto L117;
        r45 = r115;
    L117:
        SkuItemInfoVO r52 = b.a(r23, r21);
        Uri r116 = UriProtector.parse(r18);
        String r53 = com.bytedance.android.ec.core.event.a.KEY_LOG_DATA;
        String r117 = UriProtector.getQueryParameter(r116, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);
        if (r117 == null) goto L120;
        JSONObject r54 = new JSONObject(r117);
    L121:
        String r118 = r20.getLogData();
        if (r118 == null) goto L130;
        JSONObject r119 = jg.g.e(r118);
        if (r119 == null) goto L130;
        Iterator<String> r120 = r119.keys();
        if (r120 == null) goto L130;
    L128:
        if (r120.hasNext() == false) goto L130;
        String r310 = r53;
        String r55 = r120.next();
        r54.put(r55, r119.optString(r55));
        r47 = r47;
        r53 = r310;
    L130:
        String r311 = r53;
        String r312 = r47;
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, 1);
        r54.putOpt("coupon_id", "");
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE));
        String r56 = r20.getEcomEntranceForm();
        if (r56 != null) goto L133;
        r56 = (String) r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
    L133:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r56);
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "1");
        Map r57 = r20.getEventParams();
        r54.putOpt("new_user_activity", r57.get("new_user_activity"));
        r54.putOpt("new_user_activity_id", r57.get("new_user_activity_id"));
        r54.putOpt("campaign_type", r57.get("campaign_type"));
        r54.putOpt("campaign_sub_type", r57.get("campaign_sub_type"));
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r57.get(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT));
        r54.putOpt("coupon_id", r57.get("coupon_id"));
        String r58 = "0";
        if (r20.isGroupingBuy() == false) goto L136;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, "1");
    L137:
        String r59 = (String) r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);
        if (r59 != null) goto L140;
        r59 = "0";
    L140:
        r54.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r59);
        SkuExtraData r60 = r20.getSkuExtraData();
        if (r60 == null) goto L145;
        String r61 = r60.getProductTypeVerified();
        if (r61 == null) goto L145;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r61);
    L145:
        SkuExtraData r62 = r20.getSkuExtraData();
        if (r62 == null) goto L151;
        String r63 = r62.getBrandVerified();
        if (r63 == null) goto L151;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r63);
    L151:
        if (StringsKt.isBlank(r54.optString(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS)) == false) goto L159;
        SkuExtraData r64 = r20.getSkuExtraData();
        if (r64 != null) goto L155;
    L157:
        Object r65 = "0";
    L158:
        r54.put(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS, r65);
        goto L159
    L155:
        if (r64.isCrossborderProduct() != true) goto L157;
        r65 = "1";
    L159:
        SkuExtraData r66 = r20.getSkuExtraData();
        if (r66 == null) goto L164;
        String r67 = r66.getGoodsType();
        if (r67 == null) goto L164;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_GOODS_TYPE, r67);
    L164:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r20.getAuthorId());
        SkuExtraData r68 = r20.getSkuExtraData();
        if (r68 == null) goto L169;
        String r69 = r68.getLabelName();
        if (r69 == null) goto L169;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r69);
    L169:
        Map r70 = r20.getEventParams();
        if (r70 == null) goto L172;
        String r71 = (String) r70.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L173:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r71);
        SkuExtraData r72 = r20.getSkuExtraData();
        if (r72 == null) goto L178;
        String r73 = r72.getLabelNameLive();
        if (r73 == null) goto L178;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r73);
    L178:
        SkuExtraData r74 = r20.getSkuExtraData();
        if (r74 == null) goto L183;
        String r75 = r74.isAuthenticInsure();
        if (r75 == null) goto L183;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_IS_AUTHENTIC_INSURE, r75);
    L183:
        if (r52 != null) goto L185;
    L187:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r58);
        SkuExtraData r76 = r20.getSkuExtraData();
        if (r76 == null) goto L192;
        String r77 = r76.getSourcePage();
        if (r77 == null) goto L192;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r77);
    L192:
        Map r78 = r20.getEventParams();
        if (r78 == null) goto L195;
        String r79 = (String) r78.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L196:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r79);
        Map r80 = r20.getEventParams();
        if (r80 == null) goto L199;
        String r81 = (String) r80.get(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE);
    L200:
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r81);
        r54.putOpt(com.bytedance.android.ec.core.event.a.KEY_ITEM_ID, r20.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ITEM_ID));
        String r82 = r20.getTransmissibleJson();
        if (r82 != null) goto L203;
    L217:
        SkuExtraData r83 = r20.getSkuExtraData();
        if (r83 == null) goto L236;
        String r84 = r83.getTransitionTrackerData();
        if (r84 == null) goto L236;
        if (r84.length() <= 0) goto L224;
        boolean r85 = true;
    L225:
        if (r85 == true) goto L228;
        r84 = null;
    L228:
        if (r84 == null) goto L236;
        JSONObject r86 = new JSONObject(r84);     // Catch: Exception -> L234
        Iterator<String> r87 = r86.keys();     // Catch: Exception -> L234
    L231:
        if (r87.hasNext() == false) goto L236;
        String r88 = r87.next();     // Catch: Exception -> L234
        r54.put(r88, r86.optString(r88));     // Catch: Exception -> L234
    L234:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L236
    L224:
        r85 = false;
    L236:
        r54.remove(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE);
        String r89 = r20.getEntranceInfo();
        if (r89 == null) goto L242;
        JSONObject r90 = jg.g.f(r89);
        if (r90 == null) goto L242;
        r54.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r90.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE));
        r54.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r90.optString(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD));
        r54.put(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE, r90.optString(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE));
        r54.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_TYPE, r90.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_TYPE));
        r54.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r90.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));
    L242:
        if (BuyNowPerformanceOpt.j() == true) goto L244;
        JSONObject r91 = new JSONObject();
        r91.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r92 = jg.d.a;
        r91.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r91.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r91.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, jg.d.a());
    L246:
        if (UriProtector.getQueryParameter(r111, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT) == null) goto L248;
        boolean r93 = true;
    L249:
        int r94 = jg.e.a;
        String r95 = jg.e.c(jg.e.c(r18, r312, r45.toString()), r311, r54.toString());
        if (r91 == null) goto L252;
        r95 = jg.e.c(r95, com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r91.toString());
    L252:
        SkuExtraData r96 = r20.getSkuExtraData();
        if (r96 == null) goto L256;
        String r97 = r96.getMarketChannel();
        if (r97 == null) goto L256;
    L257:
        String r98 = jg.e.b(r95, com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r97);
        SkuPoiInfo r99 = r10.getPoiInfo();
        if (r99 == null) goto L262;
        ProductSelectPoiInfo r100 = r99.getSelectedPoiInfo();
        if (r100 == null) goto L262;
        String r101 = r100.getPoiId();
    L263:
        if (r101 != null) goto L265;
        r101 = "";
    L265:
        String r102 = jg.e.b(r98, "poi_id", r101);
        String r103 = UriProtector.getQueryParameter(r111, "mega_object");
        if (r103 == null) goto L275;
        JSONObject r104 = new JSONObject(r103);
        JSONObject r105 = jg.g.f(new JSONObject(r103).optString(r312));
        if (r105 == null) goto L270;
        r105.remove(com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID);
        Unit r106 = Unit.INSTANCE;
    L271:
        String r107 = r104.put(r312, String.valueOf(r105)).toString();
        if (r107 != null) goto L274;
        r107 = "";
    L274:
        r102 = jg.e.a(r102, "mega_object", r107);
        goto L275
    L270:
        r105 = null;
    L275:
        String r108 = jg.e.b(r102, "iesec_auto_coupon_opt_ab", "1");
        Pair r109 = new Pair(r21, Long.valueOf(r110));
        String r121 = (String) r109.getFirst();
        Long r122 = (Long) r109.getSecond();
        ECAdLogExtra r123 = r20.getAdLogExtra();
        ECBoltParam r124 = r20.getBoltParam();
        String r125 = r45.toString();
        String r126 = r20.getSpellGroupId();
        ECAdInfo r127 = r20.getLatestRecommendFeedAdInfo();
        Intrinsics.checkNotNullParameter(r20, "skuParams");
        if (r108 != null) goto L278;
    L280:
        r108 = null;
    L281:
        if (r108 != null) goto L283;
        r108 = "";
    L283:
        n0 r128 = new n0(r108, false);
        if (r121 == null) goto L286;
        r128.b(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r121);
    L286:
        if (r122 == null) goto L288;
        r128.a("combo_num", r122.longValue());
    L288:
        if (r126 == null) goto L290;
        r128.b("spell_group_id", r126);
    L290:
        if (r124 == null) goto L299;
        String r129 = r124.getActivityId();
        if (r129 == null) goto L299;
        if ((!TextUtils.isEmpty(r129)) == true) goto L297;
        r129 = null;
    L297:
        if (r129 == null) goto L299;
        r128.b("activity_id", r129);
    L299:
        if (r124 == null) goto L308;
        String r130 = r124.getNewSourceId();
        if (r130 == null) goto L308;
        if ((!TextUtils.isEmpty(r130)) == true) goto L306;
        r130 = null;
    L306:
        if (r130 == null) goto L308;
        r128.b("new_source_id", r130);
    L308:
        if (r125 != null) goto L310;
    L315:
        r128.a("page_init_timestamp", System.currentTimeMillis());
        SkuOrderParams r131 = r20.getOrderParams();
        if (r131 == null) goto L323;
        Map r132 = com.bytedance.android.shopping.extensions.k.z(r131.getQueryItems());
        if (r132 == null) goto L323;
        Iterator r133 = r132.entrySet().iterator();
    L321:
        if (r133.hasNext() == false) goto L323;
        Map.Entry r134 = (Map.Entry) r133.next();
        r128.b((String) r134.getKey(), String.valueOf(r134.getValue()));
    L323:
        int r135 = com.bytedance.android.ec.common.impl.sku.utils.a.a;
        String r136 = com.bytedance.android.ec.common.impl.sku.utils.a.a(r128.c(), r123, r127, r93);
        String r137 = k2.a(r136, r20.getV3EventAdditions());
        if (r137 == null) goto L327;
        r136 = r137;
    L327:
        Activity r138 = ECAppInfoService.e.getCurrentActivity();
        if (r138 == null) goto L337;
        int r139 = com.bytedance.android.ec.common.impl.sku.utils.i.a;
        String r140 = r20.getPromotionLogId();
        if (r140 != null) goto L332;
        r140 = "";
    L332:
        String r141 = r20.getSkuLogId();
        if (r141 != null) goto L335;
        String r142 = "";
    L336:
        com.bytedance.android.ec.common.impl.sku.utils.i.a(r136, r138, r140, r142, false);
        goto L337
    L335:
        r142 = r141;
    L337:
        String r143 = r20.getSkuSessionId();
        JSONObject r144 = new JSONObject();
        r144.put("sku_session_id", r143);
        r144.put("success", true);
        Unit r145 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.buynow", r144);
        return;
    L310:
        if ((!TextUtils.isEmpty(r125)) == true) goto L313;
        r125 = null;
    L313:
        if (r125 == null) goto L315;
        r128.b(r312, r125);
        goto L315
    L278:
        if ((!TextUtils.isEmpty(r108)) == false) goto L280;
    L262:
        r101 = null;
    L256:
        r97 = "";
        goto L257
    L248:
        r93 = false;
        goto L249
    L244:
        r91 = null;
        goto L246
    L203:
        if (r82.length() <= 0) goto L205;
        boolean r146 = true;
    L206:
        if (r146 == true) goto L209;
        r82 = null;
    L209:
        if (r82 == null) goto L217;
        JSONObject r147 = new JSONObject(r82);     // Catch: Exception -> L215
        Iterator<String> r148 = r147.keys();     // Catch: Exception -> L215
    L212:
        if (r148.hasNext() == false) goto L217;
        String r149 = r148.next();     // Catch: Exception -> L215
        r54.put(r149, r147.optString(r149));     // Catch: Exception -> L215
    L215:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L217
    L205:
        r146 = false;
        goto L206
    L199:
        r81 = null;
        goto L200
    L195:
        r79 = null;
        goto L196
    L185:
        if (r52.isInDepositPresale() != true) goto L187;
        r58 = "1";
        goto L187
    L172:
        r71 = null;
        goto L173
    L136:
        r54.put(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, "0");
        goto L137
    L120:
        r54 = new JSONObject();
        goto L121
    L98:
        r44 = null;
        goto L99
    L52:
        r25 = null;
        goto L54
    L46:
        if (r112.isInPreSecKill() != true) goto L48;
        r24 = com.bytedance.android.ec.core.event.a.VALUE_PRE_SECKILL;
        goto L49
    L42:
        if (r112.isInSecKill() != true) goto L44;
        r24 = com.bytedance.android.ec.core.event.a.VALUE_SECKILL;
        goto L49
    L338:
        Context r150 = this.b;
        UIUtils.displayToast(r150, th.a.g(r150, 2131913822));
        return;
    L25:
        r15 = null;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
        OrderComponent r151 = r10.getOrderComponent();
        if (r151 == null) goto L32;
        r17 = r151.getOrderUrl();
        goto L36
    L32:
        r17 = null;
        goto L36
    L16:
        if (r12.length() == 0) goto L19;
        r13 = false;
        goto L20
    L13:
        r12 = null;
    L33:
        OrderComponent r152 = r10.getOrderComponent();
        if (r152 == null) goto L37;
        r17 = r152.getOrderUrl();
        goto L36
    L37:
        r18 = null;
        goto L38
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public c(String r1, Context r10, SkuParams r11, String r12, long r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
