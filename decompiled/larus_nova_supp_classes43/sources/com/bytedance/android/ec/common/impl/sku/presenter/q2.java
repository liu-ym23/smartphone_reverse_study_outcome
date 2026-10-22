package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q2<T> implements Observer {
    public final /* synthetic */ t2 a;

    public q2(t2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r77) {
        SkuInfoVO r1 = (SkuInfoVO) r77;
        if (r1 == null) goto L318;
        DisplayConfig r10 = r1.getDisplayConfig();
        if (r10 == null) goto L8;
        Boolean r11 = r10.getShowStepper();
    L10:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L12;
        this.a.Y().d().q(dg.f.class, 8);
    L13:
        List r12 = t2.d0(this.a).getSkuParams().getBenefitLabels();
        if (r12 != null) goto L16;
    L19:
        boolean r13 = true;
    L20:
        boolean r14 = !r13;
        this.a.getClass();
        Lazy r15 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L23;
    L26:
        boolean r16 = true;
    L27:
        if (r16 == false) goto L36;
        DisplayConfig r17 = r1.getDisplayConfig();
        if (r17 == null) goto L31;
        Boolean r18 = r17.getShowDiscount();
    L33:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == false) goto L36;
        if (r14 == false) goto L36;
        this.a.Y().d().q(dg.h.class, 0);
    L37:
        SkuInfoVO r19 = (SkuInfoVO) t2.d0(this.a).getSkuInfo().a();
        if (r19 == null) goto L42;
        DisplayConfig r20 = r19.getDisplayConfig();
        if (r20 == null) goto L42;
        Boolean r21 = r20.getShowDouInstallment();
    L44:
        if (Intrinsics.areEqual(r21, Boolean.TRUE) == false) goto L56;
        SkuInstallmentItemInfo r22 = r1.getInstallmentInfo();
        if (r22 == null) goto L48;
        SkuTermInfo r23 = r22.getTermInfo();
    L49:
        if (r23 != null) goto L55;
        SkuInstallmentItemInfo r24 = r1.getInstallmentInfo();
        if (r24 == null) goto L53;
        SkuDiscountInfo r25 = r24.getDiscountInfo();
    L54:
        if (r25 == null) goto L56;
    L53:
        r25 = null;
    L55:
        this.a.Y().d().q(dg.k.class, 0);
    L57:
        SkuPoiInfo r26 = r1.getPoiInfo();
        if (r26 == null) goto L60;
        Long r27 = r26.getTotal();
    L62:
        if (r1.getPoiInfo() == null) goto L67;
        if (r27 == null) goto L67;
        if (r27.longValue() <= 0) goto L67;
        this.a.Y().d().q(dg.r.class, 0);
    L69:
        if (r1.getSkuBanner() != null) goto L71;
        this.a.Y().d().q(dg.a.class, 8);
    L73:
        if (r1.getCarAdaptComponent() != null) goto L75;
        this.a.Y().d().q(dg.d.class, 8);
    L77:
        if (t2.d0(this.a).getFirst() == false) goto L317;
        QLiveData<Long> r28 = t2.d0(this.a).m1027getCurrentCount();
        SkuRestoreState r29 = t2.d0(this.a).getSkuPanelState();
        if (r29 == null) goto L81;
        Long r30 = Long.valueOf(r29.getProductCount());
    L82:
        r28.g(Long.valueOf(jg.g.b(r30, 1)));
        t2.d0(this.a).setFirst(false);
        SkuParams r31 = t2.d0(this.a).getSkuParams();
        String r32 = r31.getEntranceInfo();
        if (r32 != null) goto L310;
    L87:
        String r33 = "";
        String r110 = r33;
    L88:
        cg.h r111 = t2.d0(this.a).getSpecTitleEntryEventStruct();
        SkuInfoVO r112 = (SkuInfoVO) t2.d0(this.a).getSkuInfo().a();
        if (r112 == null) goto L91;
        SkuBannerStruct r113 = r112.getSkuBanner();
    L93:
        if (r113 == null) goto L95;
        Object r114 = "1";
    L96:
        SkuInfoVO r115 = (SkuInfoVO) t2.d0(this.a).getSkuInfo().a();
        if (r115 == null) goto L115;
        List<SpecInfo> r116 = r115.getSpecInfoList();
        if (r116 == null) goto L115;
        Iterator<T> r117 = r116.iterator();
    L102:
        if (r117.hasNext() == false) goto L109;
        T r118 = r117.next();
        if (((SpecInfo) r118).getSpecType() != 1) goto L106;
        boolean r34 = true;
    L107:
        if (r34 == false) goto L102;
    L110:
        SpecInfo r119 = r118;
        if (r119 == null) goto L115;
        List<SpecInfoItem> r35 = r119.getSpecItems();
        if (r35 == null) goto L115;
        int r36 = r35.size();
    L117:
        if (Intrinsics.areEqual(r33, "product_ranking_homepage") == false) goto L211;
        SkuViewModel r53 = t2.d0(this.a);
        Pair[] r37 = new Pair[12];
        r37[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r110);
        r37[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, t2.d0(this.a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r37[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r37[3] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r37[4] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r37[5] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r37[6] = TuplesKt.to("with_comment", r114);
        if (t2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L121;
        Object r38 = "1";
    L122:
        r37[7] = TuplesKt.to("is_matching_product", r38);
        r37[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r36));
        if (r1.getShowStock() == false) goto L125;
        Object r39 = "1";
    L126:
        r37[9] = TuplesKt.to("is_stock_show", r39);
        r37[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(t2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r37[11] = TuplesKt.to("recommend_fxh_method", t2.d0(this.a).getRecommendTermCount());
        SkuViewModel.doSkuEventAction$default(r53, "show_product_params_detail", r37, "a1.b5267.c0.d0", PageFinder.via(((QFragmentPresenter) this.a).e), null, 16, null);
        Pair[] r40 = new Pair[23];
        r40[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r110);
        r40[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, t2.d0(this.a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r40[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r40[3] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r40[4] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r40[5] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r40[6] = TuplesKt.to("with_comment", r114);
        if (t2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L129;
        Object r41 = "1";
    L130:
        r40[7] = TuplesKt.to("is_matching_product", r41);
        r40[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r36));
        if (r1.getShowStock() == false) goto L133;
        Object r42 = "1";
    L134:
        r40[9] = TuplesKt.to("is_stock_show", r42);
        r40[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(t2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r40[11] = TuplesKt.to("recommend_fxh_method", t2.d0(this.a).getRecommendTermCount());
        String r43 = com.bytedance.android.ec.core.utils.a2.d(r31.getMethod());
        if (r43 != null) goto L137;
        r43 = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
    L137:
        r40[12] = TuplesKt.to("sku_from", r43);
        r40[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, t2.d0(this.a).getSelectFxhMethod());
        if ((!t2.d0(this.a).getTermCountList().isEmpty()) == false) goto L140;
        Object r44 = "1";
    L141:
        r40[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_CREAVAILABLE, r44);
        if (t2.d0(this.a).getHasRefreshDetailInfo() == false) goto L144;
        Object r120 = "1";
    L145:
        r40[15] = TuplesKt.to("if_detail_change", r120);
        SkuExtraData r45 = r31.getSkuExtraData();
        if (r45 == null) goto L154;
        String r46 = r45.getTransitionTrackerData();
        if (r46 == null) goto L154;
        JSONObject r47 = jg.g.f(r46);
        if (r47 == null) goto L154;
        String r48 = com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL;
        String r49 = r47.optString(r48);
        if (r49 == null) goto L155;
    L161:
        r40[16] = TuplesKt.to(r48, r49);
        SkuExtraData r50 = r31.getSkuExtraData();
        if (r50 == null) goto L168;
        String r51 = r50.getTransitionTrackerData();
        if (r51 == null) goto L168;
        JSONObject r52 = jg.g.f(r51);
        if (r52 == null) goto L168;
        String r54 = com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE;
        String r55 = r52.optString(r54);
    L169:
        r40[17] = TuplesKt.to(r54, r55);
        QLiveData<SkuInfoVO> r56 = t2.d0(this.a).getSkuInfo();
        if (r56 == null) goto L178;
        SkuInfoVO r57 = (SkuInfoVO) r56.a();
        if (r57 == null) goto L178;
        SkuInstallmentItemInfo r58 = r57.getInstallmentInfo();
        if (r58 == null) goto L178;
        SkuTermInfo r59 = r58.getTermInfo();
        if (r59 == null) goto L178;
        String r60 = r59.getPlanNo();
    L179:
        r40[18] = TuplesKt.to("plan_no", jg.g.c(r60));
        QLiveData<SkuInfoVO> r61 = t2.d0(this.a).getSkuInfo();
        if (r61 == null) goto L188;
        SkuInfoVO r62 = (SkuInfoVO) r61.a();
        if (r62 == null) goto L188;
        SkuInstallmentItemInfo r63 = r62.getInstallmentInfo();
        if (r63 == null) goto L188;
        SkuTermInfo r64 = r63.getTermInfo();
        if (r64 == null) goto L188;
        String r65 = r64.getMaterialNo();
    L189:
        r40[19] = TuplesKt.to("material_no", jg.g.c(r65));
        QLiveData<SkuInfoVO> r66 = t2.d0(this.a).getSkuInfo();
        if (r66 == null) goto L198;
        SkuInfoVO r67 = (SkuInfoVO) r66.a();
        if (r67 == null) goto L198;
        SkuInstallmentItemInfo r68 = r67.getInstallmentInfo();
        if (r68 == null) goto L198;
        SkuTermInfo r69 = r68.getTermInfo();
        if (r69 == null) goto L198;
        String r70 = r69.getResourceNo();
    L199:
        r40[20] = TuplesKt.to("resource_no", jg.g.c(r70));
        QLiveData<SkuInfoVO> r71 = t2.d0(this.a).getSkuInfo();
        if (r71 == null) goto L208;
        SkuInfoVO r72 = (SkuInfoVO) r71.a();
        if (r72 == null) goto L208;
        SkuInstallmentItemInfo r73 = r72.getInstallmentInfo();
        if (r73 == null) goto L208;
        SkuTermInfo r74 = r73.getTermInfo();
        if (r74 == null) goto L208;
        String r75 = r74.getBizType();
    L209:
        r40[21] = TuplesKt.to("biztype", jg.g.c(r75));
        r40[22] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STATUS, "0");
        Map r76 = MapsKt.mutableMapOf(r40);
        r76.putAll(com.bytedance.android.ec.core.utils.z1.j(r31.asJsonDescription()));
        Map<String, String> r78 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.core.monitor.k.c(com.bytedance.android.ec.hybrid.list.util.k.b(r76));
    L308:
        Map<String, com.bytedance.android.ec.core.monitor.a> r79 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(t2.d0(this.a).getSkuParams().getMonitorId(), MetricNames.DURATION);
        Map<String, String> r80 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.core.monitor.k.e("render_end");
        com.bytedance.android.ec.core.monitor.k.f("ec_perf_duration_sku_panel", null);
        com.bytedance.android.ec.core.monitor.c.d(t2.d0(this.a).getSkuParams().getMonitorId());
        return;
    L208:
        r75 = null;
    L198:
        r70 = null;
    L188:
        r65 = null;
    L178:
        r60 = null;
    L168:
        r54 = com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE;
        r55 = null;
    L155:
        String r81 = r31.getEntranceInfo();
        if (r81 == null) goto L160;
        JSONObject r82 = jg.g.f(r81);
        if (r82 == null) goto L160;
        r49 = r82.optString(r48);
    L160:
        r49 = null;
    L154:
        r48 = com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL;
        goto L155
    L144:
        r120 = "0";
        goto L145
    L140:
        r44 = "0";
        goto L141
    L133:
        r42 = "0";
        goto L134
    L129:
        r41 = "0";
        goto L130
    L125:
        r39 = "0";
        goto L126
    L121:
        r38 = "0";
        goto L122
    L211:
        if (r31.isFromSuperMarket() == false) goto L213;
        t2.d0(this.a).doEventAction("market_show_product_params_detail", new Pair[0]);
        goto L308
    L213:
        SkuViewModel r510 = t2.d0(this.a);
        Pair[] r121 = new Pair[11];
        r121[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r121[1] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r121[2] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r121[3] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r121[4] = TuplesKt.to("with_comment", r114);
        if (t2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L216;
        Object r83 = "1";
    L217:
        r121[5] = TuplesKt.to("is_matching_product", r83);
        r121[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r36));
        if (r1.getShowStock() == false) goto L220;
        Object r84 = "1";
    L221:
        r121[7] = TuplesKt.to("is_stock_show", r84);
        r121[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(t2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r121[9] = TuplesKt.to("recommend_fxh_method", t2.d0(this.a).getRecommendTermCount());
        String r85 = t2.d0(this.a).getSkuParams().getCombinationId();
        if (r85 != null) goto L224;
        r85 = "";
    L224:
        r121[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r85);
        SkuViewModel.doSkuEventAction$default(r510, "show_product_params_detail", r121, "a1.b5267.c0.d0", PageFinder.via(((QFragmentPresenter) this.a).e), null, 16, null);
        Pair[] r86 = new Pair[21];
        r86[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r86[1] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r86[2] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r86[3] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r86[4] = TuplesKt.to("with_comment", r114);
        if (t2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L227;
        Object r87 = "1";
    L228:
        r86[5] = TuplesKt.to("is_matching_product", r87);
        r86[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r36));
        if (r1.getShowStock() == false) goto L231;
        Object r88 = "1";
    L232:
        r86[7] = TuplesKt.to("is_stock_show", r88);
        r86[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(t2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r86[9] = TuplesKt.to("recommend_fxh_method", t2.d0(this.a).getRecommendTermCount());
        String r89 = com.bytedance.android.ec.core.utils.a2.d(r31.getMethod());
        if (r89 != null) goto L235;
        r89 = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
    L235:
        r86[10] = TuplesKt.to("sku_from", r89);
        r86[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, t2.d0(this.a).getSelectFxhMethod());
        if ((!t2.d0(this.a).getTermCountList().isEmpty()) == false) goto L238;
        Object r90 = "1";
    L239:
        r86[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_CREAVAILABLE, r90);
        if (t2.d0(this.a).getHasRefreshDetailInfo() == false) goto L242;
        Object r122 = "1";
    L243:
        r86[13] = TuplesKt.to("if_detail_change", r122);
        SkuExtraData r91 = r31.getSkuExtraData();
        if (r91 == null) goto L252;
        String r92 = r91.getTransitionTrackerData();
        if (r92 == null) goto L252;
        JSONObject r93 = jg.g.f(r92);
        if (r93 == null) goto L252;
        String r94 = com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL;
        String r95 = r93.optString(r94);
        if (r95 == null) goto L253;
    L259:
        r86[14] = TuplesKt.to(r94, r95);
        SkuExtraData r96 = r31.getSkuExtraData();
        if (r96 == null) goto L266;
        String r97 = r96.getTransitionTrackerData();
        if (r97 == null) goto L266;
        JSONObject r98 = jg.g.f(r97);
        if (r98 == null) goto L266;
        String r99 = com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE;
        String r100 = r98.optString(r99);
    L267:
        r86[15] = TuplesKt.to(r99, r100);
        QLiveData<SkuInfoVO> r101 = t2.d0(this.a).getSkuInfo();
        if (r101 == null) goto L276;
        SkuInfoVO r102 = (SkuInfoVO) r101.a();
        if (r102 == null) goto L276;
        SkuInstallmentItemInfo r103 = r102.getInstallmentInfo();
        if (r103 == null) goto L276;
        SkuTermInfo r104 = r103.getTermInfo();
        if (r104 == null) goto L276;
        String r105 = r104.getPlanNo();
    L277:
        r86[16] = TuplesKt.to("plan_no", jg.g.c(r105));
        QLiveData<SkuInfoVO> r106 = t2.d0(this.a).getSkuInfo();
        if (r106 == null) goto L286;
        SkuInfoVO r107 = (SkuInfoVO) r106.a();
        if (r107 == null) goto L286;
        SkuInstallmentItemInfo r108 = r107.getInstallmentInfo();
        if (r108 == null) goto L286;
        SkuTermInfo r109 = r108.getTermInfo();
        if (r109 == null) goto L286;
        String r123 = r109.getMaterialNo();
    L287:
        r86[17] = TuplesKt.to("material_no", jg.g.c(r123));
        QLiveData<SkuInfoVO> r124 = t2.d0(this.a).getSkuInfo();
        if (r124 == null) goto L296;
        SkuInfoVO r125 = (SkuInfoVO) r124.a();
        if (r125 == null) goto L296;
        SkuInstallmentItemInfo r126 = r125.getInstallmentInfo();
        if (r126 == null) goto L296;
        SkuTermInfo r127 = r126.getTermInfo();
        if (r127 == null) goto L296;
        String r128 = r127.getResourceNo();
    L297:
        r86[18] = TuplesKt.to("resource_no", jg.g.c(r128));
        QLiveData<SkuInfoVO> r129 = t2.d0(this.a).getSkuInfo();
        if (r129 == null) goto L306;
        SkuInfoVO r130 = (SkuInfoVO) r129.a();
        if (r130 == null) goto L306;
        SkuInstallmentItemInfo r131 = r130.getInstallmentInfo();
        if (r131 == null) goto L306;
        SkuTermInfo r132 = r131.getTermInfo();
        if (r132 == null) goto L306;
        String r133 = r132.getBizType();
    L307:
        r86[19] = TuplesKt.to("biztype", jg.g.c(r133));
        r86[20] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STATUS, "0");
        Map r134 = MapsKt.mutableMapOf(r86);
        r134.putAll(com.bytedance.android.ec.core.utils.z1.j(r31.asJsonDescription()));
        Map<String, String> r135 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.core.monitor.k.c(com.bytedance.android.ec.hybrid.list.util.k.b(r134));
    L306:
        r133 = null;
    L296:
        r128 = null;
    L286:
        r123 = null;
    L276:
        r105 = null;
    L266:
        r99 = com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE;
        r100 = null;
    L253:
        String r136 = r31.getEntranceInfo();
        if (r136 == null) goto L258;
        JSONObject r137 = jg.g.f(r136);
        if (r137 == null) goto L258;
        r95 = r137.optString(r94);
    L258:
        r95 = null;
    L252:
        r94 = com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL;
        goto L253
    L242:
        r122 = "0";
        goto L243
    L238:
        r90 = "0";
        goto L239
    L231:
        r88 = "0";
        goto L232
    L227:
        r87 = "0";
        goto L228
    L220:
        r84 = "0";
        goto L221
    L216:
        r83 = "0";
        goto L217
    L106:
        r34 = false;
        goto L107
    L109:
        r118 = (T) null;
    L115:
        r36 = 0;
        goto L117
    L95:
        r114 = "0";
        goto L96
    L91:
        r113 = null;
        goto L93
    L310:
        JSONObject r138 = new JSONObject(r32);     // Catch: Exception -> L86
        r33 = r138.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r110 = r138.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L88
    L81:
        r30 = null;
        goto L82
    L317:
        return;
    L75:
        this.a.Y().d().q(dg.d.class, 0);
        goto L77
    L71:
        this.a.Y().d().q(dg.a.class, 0);
    L67:
        this.a.Y().d().q(dg.r.class, 8);
        goto L69
    L60:
        r27 = null;
        goto L62
    L48:
        r23 = null;
    L56:
        this.a.Y().d().q(dg.k.class, 8);
    L42:
        r21 = null;
        goto L44
    L31:
        r18 = null;
    L36:
        this.a.Y().d().q(dg.h.class, 8);
        goto L37
    L23:
        if (we.a.a == true) goto L26;
        r16 = false;
        goto L27
    L16:
        if (r12.isEmpty() == true) goto L19;
        r13 = false;
        goto L20
    L12:
        this.a.Y().d().q(dg.f.class, 0);
        goto L13
    L8:
        r11 = null;
        goto L10
    }
}
