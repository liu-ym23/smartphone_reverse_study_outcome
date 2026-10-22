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
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j2<T> implements Observer {
    public final /* synthetic */ m2 a;

    public j2(m2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r63) {
        SkuInfoVO r1 = (SkuInfoVO) r63;
        if (r1 == null) goto L264;
        DisplayConfig r10 = r1.getDisplayConfig();
        if (r10 == null) goto L8;
        Boolean r11 = r10.getShowStepper();
    L10:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L12;
        this.a.Y().d().q(dg.g.class, 8);
    L13:
        SkuInfoVO r12 = (SkuInfoVO) m2.d0(this.a).getSkuInfo().a();
        if (r12 == null) goto L18;
        DisplayConfig r13 = r12.getDisplayConfig();
        if (r13 == null) goto L18;
        Boolean r14 = r13.getShowDouInstallment();
    L20:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L32;
        SkuInstallmentItemInfo r15 = r1.getInstallmentInfo();
        if (r15 == null) goto L24;
        SkuTermInfo r16 = r15.getTermInfo();
    L25:
        if (r16 != null) goto L31;
        SkuInstallmentItemInfo r17 = r1.getInstallmentInfo();
        if (r17 == null) goto L29;
        SkuDiscountInfo r18 = r17.getDiscountInfo();
    L30:
        if (r18 == null) goto L32;
    L29:
        r18 = null;
    L31:
        boolean r19 = true;
    L33:
        if (r19 == false) goto L35;
        this.a.Y().d().q(dg.l.class, 0);
    L37:
        if (r1.getTradeModeComponent() == null) goto L39;
        this.a.Y().d().q(dg.u.class, 0);
    L41:
        if (r1.getSafeguardComponent() == null) goto L43;
        this.a.Y().d().q(dg.m.class, 0);
    L44:
        SkuTrustTags r20 = r1.getTrustTags();
        if (r20 == null) goto L47;
        List r21 = r20.getSkuDocument();
    L48:
        List r22 = r21;
        if (r22 != null) goto L51;
    L54:
        boolean r23 = true;
    L55:
        if (r23 == true) goto L58;
        this.a.Y().d().q(dg.v.class, 0);
        this.a.Y().d().q(dg.t.class, 8);
    L62:
        if (r1.getPoiInfo() == null) goto L70;
        Long r24 = r1.getPoiInfo().getTotal();
        if (r24 == null) goto L66;
        long r25 = r24.longValue();
    L68:
        if (r25 <= 0) goto L70;
        boolean r26 = true;
    L72:
        if (r26 == false) goto L74;
        this.a.Y().d().q(dg.s.class, 0);
    L76:
        if (r1.getSkuBanner() != null) goto L78;
        this.a.Y().d().q(dg.a.class, 8);
    L80:
        if (r1.getCarAdaptComponent() != null) goto L82;
        this.a.Y().d().q(dg.e.class, 8);
        this.a.Z().b(2131392480).g(4);
    L84:
        if (m2.d0(this.a).getFirst() == false) goto L258;
        SkuRestoreState r27 = m2.d0(this.a).getSkuPanelState();
        if (r27 == null) goto L88;
        Long r28 = Long.valueOf(r27.getProductCount());
    L89:
        long r29 = jg.g.b(r28, 1);
        if (r29 == m2.d0(this.a).getCurrentCount()) goto L92;
        m2.d0(this.a).setClickCountUnConsumed(true);
    L92:
        m2.d0(this.a).m1027getCurrentCount().g(Long.valueOf(r29));
        m2.d0(this.a).setFirst(false);
        SkuParams r30 = m2.d0(this.a).getSkuParams();
        String r31 = r30.getEntranceInfo();
        if (r31 != null) goto L260;
    L97:
        String r32 = "";
        String r110 = r32;
    L98:
        cg.h r111 = m2.d0(this.a).getSpecTitleEntryEventStruct();
        SkuInfoVO r112 = (SkuInfoVO) m2.d0(this.a).getSkuInfo().a();
        if (r112 == null) goto L101;
        SkuBannerStruct r113 = r112.getSkuBanner();
    L103:
        if (r113 == null) goto L105;
        Object r114 = "1";
    L106:
        SkuInfoVO r33 = (SkuInfoVO) m2.d0(this.a).getSkuInfo().a();
        if (r33 == null) goto L126;
        List<SpecInfo> r34 = r33.getSpecInfoList();
        if (r34 == null) goto L126;
        Iterator<T> r35 = r34.iterator();
    L112:
        if (r35.hasNext() == false) goto L120;
        T r115 = r35.next();
        if (((SpecInfo) r115).getSpecType() != 1) goto L116;
        boolean r36 = true;
    L117:
        if (r36 == false) goto L112;
    L121:
        SpecInfo r116 = r115;
        if (r116 == null) goto L126;
        List<SpecInfoItem> r37 = r116.getSpecItems();
        if (r37 == null) goto L126;
        int r38 = r37.size();
    L127:
        Object r39 = "recommend_fxh_method";
        if (Intrinsics.areEqual(r32, "product_ranking_homepage") == false) goto L149;
        SkuViewModel r42 = m2.d0(this.a);
        SkuInfoVO r50 = r1;
        Pair[] r40 = new Pair[17];
        r40[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r110);
        r40[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, m2.d0(this.a).getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_THREE_D));
        r40[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r40[3] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r40[4] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r40[5] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r40[6] = TuplesKt.to("with_comment", r114);
        if (m2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L132;
        Object r41 = "1";
    L133:
        r40[7] = TuplesKt.to("is_matching_product", r41);
        r40[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r38));
        if (r50.getShowStock() == false) goto L136;
        Object r43 = "1";
    L137:
        Object r44 = com.bytedance.android.ec.core.event.a.KEY_THREE_D;
        Object r117 = "is_stock_show";
        r40[9] = TuplesKt.to(r117, r43);
        String r45 = ArraysKt.joinToString$default(CollectionsKt.toIntArray(m2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null);
        Object r51 = com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE;
        r40[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, r45);
        String r46 = r110;
        r40[11] = TuplesKt.to(r39, m2.d0(this.a).getRecommendTermCount());
        if (m2.d0(this.a).isExistSizeTab() == false) goto L140;
        Object r47 = "1";
    L141:
        r40[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, r47);
        String r48 = m2.d0(this.a).getSkuParams().getCombinationId();
        r39 = r39;
        if (r48 != null) goto L144;
        r48 = "";
    L144:
        r40[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r48);
        if (m2.d0(this.a).isTradeIn() == false) goto L147;
        Object r49 = "1";
    L148:
        r40[14] = TuplesKt.to("is_trade_in", r49);
        r40[15] = TuplesKt.to("trade_benefit_id", m2.d0(this.a).getTradeBenefitId());
        r40[16] = TuplesKt.to("trade_benefit_text", m2.d0(this.a).getTradeBenefitText());
        SkuViewModel.doSkuEventAction$default(r42, "show_product_params_detail", r40, "a1.b5267.c0.d0", PageFinder.via(((QFragmentPresenter) this.a).e), null, 16, null);
        Object r210 = com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST;
    L152:
        Object r310 = r117;
        Object r118 = r39;
    L170:
        Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r52 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
        com.bytedance.android.ec.common.impl.sku.monitor.a r53 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(r30.getMonitorId());
        if (r53 == null) goto L258;
        SkuViewModel r54 = m2.d0(this.a);
        Intrinsics.checkNotNullParameter(r54, "viewModel");
        String r0 = r46;
        Intrinsics.checkNotNullParameter(r0, "previousPage");
        Object r311 = r118;
        Intrinsics.checkNotNullParameter(r111, "titleEntryEventStruct");
        Intrinsics.checkNotNullParameter(r114, "withComment");
        int r312 = r38;
        SkuInfoVO r55 = r50;
        Intrinsics.checkNotNullParameter(r55, "skuInfoVO");
        com.bytedance.android.ec.common.impl.sku.monitor.b r56 = r53.b;
        if (r56.a > 1) goto L177;
        Map<String, com.bytedance.android.ec.core.monitor.a> r57 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r56.b.getMonitorId(), MetricNames.DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r56.b.getMonitorId());
    L177:
        if (r53.c.a <= 1) goto L179;
        String r58 = null;
    L180:
        com.bytedance.android.ec.common.impl.sku.monitor.e r59 = r53.d;
        r59.getClass();
        Intrinsics.checkNotNullParameter(r54, "viewModel");
        Intrinsics.checkNotNullParameter(r0, "previousPage");
        Intrinsics.checkNotNullParameter(r111, "titleEntryEventStruct");
        Intrinsics.checkNotNullParameter(r114, "withComment");
        Intrinsics.checkNotNullParameter(r55, "skuInfoVO");
        if (r59.a > 1) goto L257;
        Pair[] r60 = new Pair[23];
        r60[0] = TuplesKt.to(r51, r0);
        Object r61 = r44;
        r60[1] = TuplesKt.to(r61, r59.b.getEventParams().get(r61));
        r60[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r60[3] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r60[4] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r60[5] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r60[6] = TuplesKt.to("with_comment", r114);
        if (r59.b.isFromMatchPurchase() == false) goto L186;
        Object r62 = "1";
    L187:
        r60[7] = TuplesKt.to("is_matching_product", r62);
        r60[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r312));
        if (r55.getShowStock() == false) goto L190;
        Object r64 = "1";
    L191:
        r60[9] = TuplesKt.to(r310, r64);
        r60[10] = TuplesKt.to(r210, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r54.getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r60[11] = TuplesKt.to(r311, r54.getRecommendTermCount());
        String r65 = com.bytedance.android.ec.core.utils.a2.d(r59.b.getMethod());
        if (r65 != null) goto L194;
        r65 = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
    L194:
        r60[12] = TuplesKt.to("sku_from", r65);
        r60[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r54.getSelectFxhMethod());
        if ((!r54.getTermCountList().isEmpty()) == false) goto L197;
        Object r66 = "1";
    L198:
        r60[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_CREAVAILABLE, r66);
        if (r54.getHasRefreshDetailInfo() == false) goto L201;
        Object r119 = "1";
    L202:
        r60[15] = TuplesKt.to("if_detail_change", r119);
        SkuExtraData r67 = r59.b.getSkuExtraData();
        if (r67 == null) goto L210;
        String r68 = r67.getTransitionTrackerData();
        if (r68 == null) goto L210;
        JSONObject r69 = jg.g.f(r68);
        if (r69 == null) goto L210;
        String r70 = r69.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
        if (r70 == null) goto L210;
    L216:
        r60[16] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r70);
        SkuExtraData r71 = r59.b.getSkuExtraData();
        if (r71 == null) goto L223;
        String r72 = r71.getTransitionTrackerData();
        if (r72 == null) goto L223;
        JSONObject r73 = jg.g.f(r72);
        if (r73 == null) goto L223;
        String r74 = r73.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE);
    L224:
        r60[17] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE, r74);
        SkuInfoVO r75 = (SkuInfoVO) r54.getSkuInfo().a();
        if (r75 == null) goto L231;
        SkuInstallmentItemInfo r76 = r75.getInstallmentInfo();
        if (r76 == null) goto L231;
        SkuTermInfo r77 = r76.getTermInfo();
        if (r77 == null) goto L231;
        String r78 = r77.getPlanNo();
    L232:
        r60[18] = TuplesKt.to("plan_no", jg.g.c(r78));
        SkuInfoVO r79 = (SkuInfoVO) r54.getSkuInfo().a();
        if (r79 == null) goto L239;
        SkuInstallmentItemInfo r80 = r79.getInstallmentInfo();
        if (r80 == null) goto L239;
        SkuTermInfo r81 = r80.getTermInfo();
        if (r81 == null) goto L239;
        String r82 = r81.getMaterialNo();
    L240:
        r60[19] = TuplesKt.to("material_no", jg.g.c(r82));
        SkuInfoVO r83 = (SkuInfoVO) r54.getSkuInfo().a();
        if (r83 == null) goto L247;
        SkuInstallmentItemInfo r84 = r83.getInstallmentInfo();
        if (r84 == null) goto L247;
        SkuTermInfo r85 = r84.getTermInfo();
        if (r85 == null) goto L247;
        String r86 = r85.getResourceNo();
    L248:
        r60[20] = TuplesKt.to("resource_no", jg.g.c(r86));
        SkuInfoVO r87 = (SkuInfoVO) r54.getSkuInfo().a();
        if (r87 == null) goto L255;
        SkuInstallmentItemInfo r88 = r87.getInstallmentInfo();
        if (r88 == null) goto L255;
        SkuTermInfo r89 = r88.getTermInfo();
        if (r89 == null) goto L255;
        String r90 = r89.getBizType();
    L256:
        r60[21] = TuplesKt.to("biztype", jg.g.c(r90));
        r60[22] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STATUS, "0");
        Map r91 = MapsKt.mutableMapOf(r60);
        r91.putAll(com.bytedance.android.ec.core.utils.z1.j(r59.b.asJsonDescription()));
        Map<String, String> r92 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.core.monitor.k.c(com.bytedance.android.ec.hybrid.list.util.k.b(r91));
    L255:
        r90 = r58;
    L247:
        r86 = r58;
    L239:
        r82 = r58;
    L231:
        r78 = r58;
    L223:
        r74 = r58;
    L210:
        String r93 = r59.b.getEntranceInfo();
        if (r93 == null) goto L215;
        JSONObject r94 = jg.g.f(r93);
        if (r94 == null) goto L215;
        r70 = r94.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
    L215:
        r70 = r58;
        goto L216
    L201:
        r119 = "0";
        goto L202
    L197:
        r66 = "0";
        goto L198
    L190:
        r64 = "0";
        goto L191
    L186:
        r62 = "0";
    L257:
        r53.e.getClass();
        Set<String> r95 = ECProcessMonitor.a;
        ECProcessMonitor.p().g();
        goto L258
    L179:
        Map<String, String> r96 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.core.monitor.k.e("render_end");
        r58 = null;
        com.bytedance.android.ec.core.monitor.k.f("ec_perf_duration_sku_panel", null);
        goto L180
    L147:
        r49 = "0";
        goto L148
    L140:
        r47 = "0";
        goto L141
    L136:
        r43 = "0";
        goto L137
    L132:
        r41 = "0";
        goto L133
    L149:
        r50 = r1;
        r51 = com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE;
        r46 = r110;
        r44 = com.bytedance.android.ec.core.event.a.KEY_THREE_D;
        r117 = "is_stock_show";
        if (r30.isFromSuperMarket() == false) goto L153;
        SkuViewModel r97 = m2.d0(this.a);
        r210 = com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST;
        r97.doEventAction("market_show_product_params_detail", new Pair[0]);
        goto L152
    L153:
        r210 = com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST;
        SkuViewModel r410 = m2.d0(this.a);
        Pair[] r98 = new Pair[14];
        r98[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, String.valueOf(r111.a));
        r98[1] = TuplesKt.to("is_product_recommand", String.valueOf(r111.b));
        r98[2] = TuplesKt.to("is_user_input", String.valueOf(r111.c));
        r98[3] = TuplesKt.to("is_size_recommand", String.valueOf(r111.d));
        r98[4] = TuplesKt.to("with_comment", r114);
        if (m2.d0(this.a).getSkuParams().isFromMatchPurchase() == false) goto L156;
        Object r99 = "1";
    L157:
        r98[5] = TuplesKt.to("is_matching_product", r99);
        r98[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TIME_SKU_NUM, String.valueOf(r38));
        if (r50.getShowStock() == false) goto L160;
        Object r100 = "1";
    L161:
        r98[7] = TuplesKt.to(r117, r100);
        r310 = r117;
        r98[8] = TuplesKt.to(r210, ArraysKt.joinToString$default(CollectionsKt.toIntArray(m2.d0(this.a).getTermCountList()), ",", null, null, 0, null, null, 62, null));
        r118 = r39;
        r98[9] = TuplesKt.to(r118, m2.d0(this.a).getRecommendTermCount());
        if (m2.d0(this.a).isExistSizeTab() == false) goto L164;
        Object r101 = "1";
    L165:
        r98[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXIST_SIZE_TAB, r101);
        if (m2.d0(this.a).isTradeIn() == false) goto L168;
        Object r102 = "1";
    L169:
        r98[11] = TuplesKt.to("is_trade_in", r102);
        r98[12] = TuplesKt.to("trade_benefit_id", m2.d0(this.a).getTradeBenefitId());
        r98[13] = TuplesKt.to("trade_benefit_text", m2.d0(this.a).getTradeBenefitText());
        SkuViewModel.doSkuEventAction$default(r410, "show_product_params_detail", r98, "a1.b5267.c0.d0", PageFinder.via(((QFragmentPresenter) this.a).e), null, 16, null);
        goto L170
    L168:
        r102 = "0";
        goto L169
    L164:
        r101 = "0";
        goto L165
    L160:
        r100 = "0";
        goto L161
    L156:
        r99 = "0";
        goto L157
    L116:
        r36 = false;
        goto L117
    L120:
        r115 = (T) null;
    L126:
        r38 = 0;
        goto L127
    L105:
        r114 = "0";
        goto L106
    L101:
        r113 = null;
        goto L103
    L260:
        JSONObject r120 = new JSONObject(r31);     // Catch: Exception -> L96
        r32 = r120.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r110 = r120.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
        goto L98
    L88:
        r28 = null;
    L258:
        this.a.Z().b(2131387796).f().setOnScrollChangeListener(new i2(this));
        return;
    L82:
        this.a.Y().d().q(dg.e.class, 0);
        this.a.Z().b(2131392480).g(0);
        goto L84
    L78:
        this.a.Y().d().q(dg.a.class, 0);
        goto L80
    L74:
        this.a.Y().d().q(dg.s.class, 4);
        goto L76
    L66:
        r25 = 0;
    L70:
        r26 = false;
        goto L72
    L58:
        if (r1.getTopBannerComponent() == null) goto L60;
        this.a.Y().d().q(dg.t.class, 0);
        this.a.Y().d().q(dg.v.class, 8);
        goto L62
    L60:
        this.a.Y().d().q(dg.t.class, 8);
        this.a.Y().d().q(dg.v.class, 8);
        goto L62
    L51:
        if (r22.isEmpty() == true) goto L54;
        r23 = false;
        goto L55
    L47:
        r21 = null;
        goto L48
    L43:
        this.a.Y().d().q(dg.m.class, 8);
        goto L44
    L39:
        this.a.Y().d().q(dg.u.class, 8);
        goto L41
    L35:
        this.a.Y().d().q(dg.l.class, 8);
        goto L37
    L24:
        r16 = null;
    L32:
        r19 = false;
    L18:
        r14 = null;
        goto L20
    L12:
        this.a.Y().d().q(dg.g.class, 0);
        goto L13
    L8:
        r11 = null;
        goto L10
    }
}
