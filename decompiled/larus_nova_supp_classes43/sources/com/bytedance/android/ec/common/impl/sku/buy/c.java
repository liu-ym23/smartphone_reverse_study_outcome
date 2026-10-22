package com.bytedance.android.ec.common.impl.sku.buy;

import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;
import jg.d;
import jg.g;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements b {
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
        IOrderSchema r0 = this.a;
        if (r0 == null) goto L113;
        SkuViewModel r1 = this.b;
        SkuParams r10 = r1.getSkuParams();
        OrderSchema.b r11 = r0.P();
        Map r12 = r10.getEventParams();
        boolean r13 = false;
        String r14 = "";
        if (r11 == null) goto L49;
        Pair<String, ? extends Object>[] r15 = new Pair[16];
        String r16 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING);
        if (r16 != null) goto L9;
        r16 = "";
    L9:
        r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, r16);
        String r17 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);
        if (r17 != null) goto L12;
        r17 = "0";
    L12:
        r15[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r17);
        String r18 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
        if (r18 != null) goto L15;
        r18 = "";
    L15:
        r15[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r18);
        String r19 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r19 != null) goto L18;
        r19 = "";
    L18:
        r15[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r19);
        r15[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "live");
        String r110 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        if (r110 != null) goto L21;
        r110 = "";
    L21:
        r15[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r110);
        String r111 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL);
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        r15[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r111);
        String r112 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        r15[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r112);
        String r113 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        r15[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r113);
        String r114 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME);
        if (r114 != null) goto L33;
        r114 = "";
    L33:
        r15[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r114);
        String r115 = (String) r12.get("is_explaining");
        if (r115 != null) goto L36;
        r115 = "";
    L36:
        r15[10] = TuplesKt.to("is_explaining", r115);
        String r116 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
        if (r116 != null) goto L39;
        r116 = "";
    L39:
        r15[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r116);
        String r20 = (String) r12.get(com.bytedance.android.ec.core.event.a.KEY_THREE_D);
        if (r20 != null) goto L42;
        r20 = "";
    L42:
        r15[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r20);
        r15[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r10.getPromotionId());
        String r21 = r10.getCommodityType();
        if (r21 != null) goto L45;
        r21 = "";
    L45:
        r15[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r21);
        String r22 = r10.getProductId();
        if (r22 != null) goto L48;
        r22 = "";
    L48:
        r15[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r22);
        r11.j(r15, LiveSkuOrderUrlHelperV2$appendEntranceInfo$1.INSTANCE);
    L49:
        JSONObject r23 = g.e(r10.getTransmissibleJson());
        if (r23 == null) goto L54;
        Map<String, String> r24 = z1.j(r23);
        if (r11 == null) goto L54;
        r11.putAll(r24);
    L54:
        ECAdInfo r25 = r1.getSkuParams().getLatestRecommendFeedAdInfo();
        if (r25 == null) goto L58;
        if (r11 == null) goto L58;
        r11.g(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r25.getCid()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r25.getLogExtra())});
    L58:
        SkuViewModel r26 = this.b;
        JSONObject r27 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L61;
        r27.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        int r28 = d.a;
        r27.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r27.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r27.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, d.a());
    L61:
        String r29 = r26.getSelectFxhMethod();
        String r30 = null;
        if (r29 != null) goto L64;
    L72:
        r0.replaceOrAppendParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r27.toString());
        SkuViewModel r31 = this.b;
        String r32 = r31.getComboId();
        if (r32 != null) goto L75;
        r32 = "";
    L75:
        r0.replaceOrAppendParam(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r32);
        r0.replaceOrAppendParam("combo_num", String.valueOf(r31.getCurrentCount()));
        String r33 = r31.getSkuParams().getSpellGroupId();
        if (r33 == null) goto L87;
        if (r33.length() <= 0) goto L80;
        boolean r34 = true;
    L81:
        if (r34 == true) goto L84;
        r33 = null;
    L84:
        if (r33 == null) goto L87;
        r0.replaceOrAppendParam("spell_group_id", r33);
        goto L87
    L80:
        r34 = false;
    L87:
        if (r31.getSelectPoiInfo().a() == null) goto L91;
        ProductSelectPoiInfo r35 = (ProductSelectPoiInfo) r31.getSelectPoiInfo().a();
        if (r35 == null) goto L98;
        String r36 = r35.getPoiId();
    L99:
        if (r36 == null) goto L102;
        r14 = r36;
    L102:
        r0.replaceOrAppendParam("poi_id", r14);
        String r37 = r31.getCurrentPromiseType();
        if (r37 != null) goto L105;
    L111:
        r0.replaceOrAppendParam("iesec_auto_coupon_opt_ab", "1");
        r0.replaceOrAppendParam("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        return;
    L105:
        if (r37.length() <= 0) goto L107;
        r13 = true;
    L107:
        if (r13 == false) goto L109;
        r30 = r37;
    L109:
        if (r30 == null) goto L111;
        r0.replaceOrAppendParam("promise_type", r30);
    L98:
        r36 = null;
        goto L99
    L91:
        SkuInfoVO r38 = (SkuInfoVO) r31.getSkuInfo().a();
        if (r38 == null) goto L98;
        SkuPoiInfo r39 = r38.getPoiInfo();
        if (r39 == null) goto L98;
        ProductSelectPoiInfo r40 = r39.getSelectedPoiInfo();
        if (r40 == null) goto L98;
        r36 = r40.getPoiId();
        goto L99
    L64:
        if (r29.length() <= 0) goto L66;
        boolean r41 = true;
    L67:
        if (r41 == true) goto L70;
        r29 = null;
    L70:
        if (r29 == null) goto L72;
        r27.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r29);
        goto L72
    L66:
        r41 = false;
        goto L67
    }

    @Override // com.bytedance.android.ec.common.impl.sku.buy.b
    public final IOrderSchema a() {
        return this.a;
    }

    public c(String r10, SkuViewModel r11) {
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
