package com.bytedance.android.ec.common.impl.sku.buy;

import android.text.TextUtils;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.extensions.k;
import java.util.Iterator;
import java.util.Map;
import jg.d;
import jg.g;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public final IOrderSchema a;
    public final SkuViewModel b;

    @Override // com.bytedance.android.ec.common.impl.sku.buy.b
    public final boolean u() {
        IOrderSchema r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.u() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.ec.common.impl.sku.buy.b
    public final void v() {
        IOrderSchema r1 = this.a;
        if (r1 == null) goto L161;
        SkuViewModel r10 = this.b;
        if (r10.isInSecKill() == false) goto L8;
        String r11 = com.bytedance.android.ec.core.event.a.VALUE_SECKILL;
    L11:
        SkuParams r12 = r10.getSkuParams();
        OrderSchema.b r13 = r1.P();
        if (r13 == null) goto L14;
        r13.i(g.e(r12.getEntranceInfo()));
    L14:
        boolean r14 = false;
        String r15 = "";
        if (r13 == null) goto L20;
        Pair<String, ? extends Object>[] r16 = new Pair[3];
        r16[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AUTO_APPLY_COUPON, 1);
        String r17 = r10.getApplyCouponIds();
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        r16[1] = TuplesKt.to("coupon_id", r17);
        r16[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, "1");
        r13.g(r16);
    L20:
        if (r13 == null) goto L22;
        r13.delete(new String[]{com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID});
    L22:
        Map r18 = r12.getEventParams();
        if (r13 == null) goto L53;
        Pair<String, ? extends Object>[] r19 = new Pair[16];
        r19[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, r11);
        ECAdLogExtra r20 = r12.getAdLogExtra();
        if (r20 == null) goto L27;
        String r21 = r20.getCreativeId();
    L28:
        r19[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CID, r21);
        SkuExtraData r22 = r12.getSkuExtraData();
        if (r22 == null) goto L31;
        String r23 = r22.getBrandVerified();
    L32:
        r19[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r23);
        SkuExtraData r24 = r12.getSkuExtraData();
        if (r24 == null) goto L35;
        String r25 = r24.getLabelName();
    L36:
        r19[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r25);
        SkuExtraData r26 = r12.getSkuExtraData();
        if (r26 == null) goto L39;
        String r27 = r26.getLabelNameLive();
    L40:
        r19[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r27);
        SkuExtraData r28 = r12.getSkuExtraData();
        if (r28 == null) goto L43;
        String r29 = r28.getHasReplay();
    L44:
        r19[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, r29);
        r19[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r18.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE));
        SkuExtraData r30 = r12.getSkuExtraData();
        if (r30 == null) goto L47;
        String r31 = r30.getProductTypeVerified();
    L48:
        r19[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r31);
        r19[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r18.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS));
        SkuExtraData r32 = r12.getSkuExtraData();
        if (r32 == null) goto L51;
        String r33 = r32.getWithVideo();
    L52:
        r19[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, r33);
        r19[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r18.get(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE));
        r19[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r18.get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE));
        r19[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r18.get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r19[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r12.getPromotionId());
        r19[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r12.getCommodityType());
        r19[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r12.getProductId());
        r13.j(r19, AnchorV3SkuOrderUrlHelperV2$appendEntranceInfo$1.INSTANCE);
        goto L53
    L51:
        r33 = null;
        goto L52
    L47:
        r31 = null;
        goto L48
    L43:
        r29 = null;
        goto L44
    L39:
        r27 = null;
        goto L40
    L35:
        r25 = null;
        goto L36
    L31:
        r23 = null;
        goto L32
    L27:
        r21 = null;
    L53:
        JSONObject r34 = g.e(r12.getTransmissibleJson());
        if (r34 == null) goto L58;
        Map<String, String> r35 = z1.j(r34);
        if (r13 == null) goto L58;
        r13.putAll(r35);
    L58:
        SkuOrderParams r36 = r12.getOrderParams();
        if (r36 == null) goto L71;
        JSONObject r37 = g.f(r36.getMegaObject());
        if (r37 == null) goto L65;
        Object r38 = r37.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r38 == null) goto L65;
        String r39 = r38.toString();
    L66:
        JSONObject r40 = g.e(r39);
        if (r40 == null) goto L71;
        Map<String, String> r41 = z1.j(r40);
        if (r13 == null) goto L71;
        r13.putAll(r41);
    L65:
        r39 = null;
    L71:
        ECAdInfo r42 = r10.getSkuParams().getLatestRecommendFeedAdInfo();
        if (r42 == null) goto L75;
        if (r13 == null) goto L75;
        r13.g(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r42.getCid()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r42.getLogExtra())});
    L75:
        SkuViewModel r43 = this.b;
        JSONObject r44 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L78;
        r44.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r45 = d.a;
        r44.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r44.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r44.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, d.a());
    L78:
        String r46 = r43.getSelectFxhMethod();
        if (r46 != null) goto L81;
    L89:
        r1.replaceOrAppendParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r44.toString());
        SkuViewModel r47 = this.b;
        SkuExtraData r48 = r47.getSkuParams().getSkuExtraData();
        if (r48 == null) goto L93;
        String r49 = r48.getMarketChannel();
        if (r49 == null) goto L93;
    L94:
        r1.replaceOrAppendParam(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r49);
        if (r47.getSelectPoiInfo().a() == null) goto L99;
        ProductSelectPoiInfo r50 = (ProductSelectPoiInfo) r47.getSelectPoiInfo().a();
        if (r50 == null) goto L106;
        String r51 = r50.getPoiId();
    L107:
        if (r51 == null) goto L110;
        r15 = r51;
    L110:
        r1.replaceOrAppendParam("poi_id", r15);
        String r52 = r47.getCurrentPromiseType();
        if (r52 != null) goto L113;
    L120:
        r1.replaceOrAppendParam("iesec_auto_coupon_opt_ab", "1");
        String r53 = r47.getComboId();
        if (r53 == null) goto L123;
        r1.replaceOrAppendParam(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r53);
    L123:
        r1.replaceOrAppendParam("combo_num", String.valueOf(r47.getCurrentCount()));
        String r54 = r47.getSkuParams().getSpellGroupId();
        if (r54 == null) goto L126;
        r1.replaceOrAppendParam("spell_group_id", r54);
    L126:
        ECBoltParam r55 = r47.getSkuParams().getBoltParam();
        if (r55 == null) goto L136;
        String r56 = r55.getActivityId();
        if (r56 == null) goto L136;
        if ((!TextUtils.isEmpty(r56)) == true) goto L134;
        r56 = null;
    L134:
        if (r56 == null) goto L136;
        r1.replaceOrAppendParam("activity_id", r56);
    L136:
        ECBoltParam r57 = r47.getSkuParams().getBoltParam();
        if (r57 == null) goto L146;
        String r58 = r57.getNewSourceId();
        if (r58 == null) goto L146;
        if ((!TextUtils.isEmpty(r58)) == true) goto L144;
        r58 = null;
    L144:
        if (r58 == null) goto L146;
        r1.replaceOrAppendParam("new_source_id", r58);
    L146:
        r1.replaceOrAppendParam("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        SkuOrderParams r59 = r47.getSkuParams().getOrderParams();
        if (r59 == null) goto L154;
        Map r60 = k.z(r59.getQueryItems());
        if (r60 == null) goto L154;
        Iterator r61 = r60.entrySet().iterator();
    L152:
        if (r61.hasNext() == false) goto L154;
        Map.Entry r62 = (Map.Entry) r61.next();
        r1.replaceOrAppendParam((String) r62.getKey(), String.valueOf(r62.getValue()));
    L154:
        ECAdLogExtra r63 = r47.getSkuParams().getAdLogExtra();
        if (r63 != null) goto L157;
        return;
    L157:
        if (a2.b(r63.getCreativeId()) == false) goto L163;
        String r64 = r63.getAdExtraData();
        JSONObject r65 = new JSONObject();
        r65.put(com.bytedance.android.ec.core.event.a.KEY_CID, r63.getCreativeId());
        r65.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r63.getLogExtra());
        r65.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r64);
        r1.replaceOrAppendParam("has_adinfojson", "1");
        r1.replaceOrAppendParam("adinfojson", r65.toString());
        return;
    L163:
        return;
    L113:
        if (r52.length() <= 0) goto L115;
        r14 = true;
    L115:
        if (r14 == true) goto L118;
        r52 = null;
    L118:
        if (r52 == null) goto L120;
        r1.replaceOrAppendParam("promise_type", r52);
    L106:
        r51 = null;
        goto L107
    L99:
        SkuInfoVO r66 = (SkuInfoVO) r47.getSkuInfo().a();
        if (r66 == null) goto L106;
        SkuPoiInfo r67 = r66.getPoiInfo();
        if (r67 == null) goto L106;
        ProductSelectPoiInfo r68 = r67.getSelectedPoiInfo();
        if (r68 == null) goto L106;
        r51 = r68.getPoiId();
    L93:
        r49 = "";
        goto L94
    L81:
        if (r46.length() <= 0) goto L83;
        boolean r69 = true;
    L84:
        if (r69 == true) goto L87;
        r46 = null;
    L87:
        if (r46 == null) goto L89;
        r44.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r46);
        goto L89
    L83:
        r69 = false;
        goto L84
    L8:
        if (r10.isInPreSecKill() == false) goto L10;
        r11 = com.bytedance.android.ec.core.event.a.VALUE_PRE_SECKILL;
        goto L11
    L10:
        r11 = null;
        goto L11
    }

    @Override // com.bytedance.android.ec.common.impl.sku.buy.b
    public final IOrderSchema a() {
        return this.a;
    }

    public a(String r10, SkuViewModel r11) {
        Intrinsics.checkNotNullParameter(r10, "originUrl");
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        this.b = r11;
        new EntranceInfoScene("sku", "orderUrl");
        int r12 = ECSdk.a;
        IECCommonService r13 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r13 == null) goto L5;
        IOrderSchema r14 = r13.convertToOrderSchema(r10, new EntranceInfoScene("sku", "orderUrl"));
    L6:
        this.a = r14;
        return;
    L5:
        r14 = null;
        goto L6
    }
}
