package cg;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.ec.common.impl.sku.model.ClothesSizeAssistantStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.common.impl.sku.model.SpecChartStruct;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.HotSalePrice;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.PriceComponent;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPriceInfo;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TopBannerComponent;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final SkuInfoVO d(SkuInfoResponseDTO r176) {
        Intrinsics.checkNotNullParameter(r176, "$this$transformToVO");
        Map<String, SkuItemInfo> r0 = r176.getSkus();
        long r10 = 1000;
        if (r0 == null) goto L201;
        LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
        Iterator<T> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L200;
        Map.Entry r12 = (Map.Entry) r1.next();
        Object r13 = r12.getKey();
        SkuItemInfo r14 = (SkuItemInfo) r12.getValue();
        Intrinsics.checkNotNullParameter(r14, "$this$toSkuItemInfoVO");
        String r15 = r14.getId();
        long r16 = r14.getStockNum();
        Long r17 = r14.getUnpayNum();
        long r18 = r14.getPrice();
        long r19 = r14.getOriginPrice();
        Long r20 = r14.getDiscountPrice();
        String r21 = r14.getDiscountPriceText();
        Long r22 = r14.getUserLimit();
        long r23 = r14.getLowerLimit();
        String r25 = r14.getUpperLimitToast();
        String r26 = r14.getLowerLimitToast();
        String r27 = r14.getLimitText();
        int r28 = r14.getNowStock();
        Long r29 = r14.getSkuType();
        List<PromotionBenefitLabel> r30 = r14.getBenefitLabels();
        String r31 = r14.getCampaignPriceHeader();
        int r32 = r14.getPriceHeaderStyle();
        String r33 = r14.getNewBonusText();
        Long r34 = r14.getMarketPrice();
        Object r35 = r14.getEpInfo();
        String r36 = r14.getPresellDelayDesc();
        String r37 = r14.getDeliveryDelayDesc();
        String r38 = r14.getDeliveryDelayBackground();
        String r39 = r14.getDelayDescIcon();
        Integer r40 = r14.getDelayDescStyle();
        Long r110 = r14.getCampaignStartTime();
        if (r110 == null) goto L14;
        long r111 = r110.longValue();
        long r41 = SystemClock.elapsedRealtime();
        Long r43 = r14.getServerTime();
        if (r43 == null) goto L12;
        long r44 = r43.longValue();
    L13:
        long r42 = r41 + ((r111 - r44) * r10);
    L15:
        Long r112 = r14.getCampaignEndTime();
        if (r112 == null) goto L22;
        long r113 = r112.longValue();
        long r45 = SystemClock.elapsedRealtime();
        Long r46 = r14.getServerTime();
        if (r46 == null) goto L20;
        long r47 = r46.longValue();
    L21:
        long r48 = r45 + ((r113 - r47) * r10);
    L23:
        ECUrlModel r49 = r14.getActivityIcon();
        String r410 = r14.getAtmosphereHeader();
        Integer r411 = r14.getCampaignSubType();
        Long r114 = r14.getDepositPrice();
        if (r114 == null) goto L26;
        long r412 = r114.longValue();
    L27:
        String r50 = r14.getButtonLabel();
        Long r115 = r14.getServerTime();
        if (r115 == null) goto L30;
        long r51 = r115.longValue();
    L31:
        List<SkuBottomButtons> r116 = r14.getButtons();
        if (r116 == null) goto L34;
        List r53 = CollectionsKt.toMutableList(r116);
    L35:
        Long r117 = r14.getSkuType();
        boolean r54 = false;
        if (r117 != null) goto L39;
    L56:
        boolean r24 = false;
    L57:
        Long r52 = r14.getSkuType();
        if (r52 != null) goto L61;
    L78:
        r11 = r11;
    L79:
        boolean r55 = false;
    L80:
        CarAdaptComponent r56 = r14.getCarAdaptComponent();
        PriceComponent r57 = r14.getPriceComponent();
        if (r57 == null) goto L85;
        SkuPriceInfo r58 = r57.getFirstPrice();
        if (r58 == null) goto L85;
        Long r59 = r58.getPrice();
    L86:
        PriceComponent r60 = r14.getPriceComponent();
        if (r60 == null) goto L91;
        SkuPriceInfo r61 = r60.getFirstPrice();
        if (r61 == null) goto L91;
        String r510 = r61.getPrefix();
    L92:
        PriceComponent r62 = r14.getPriceComponent();
        if (r62 == null) goto L97;
        SkuPriceInfo r63 = r62.getFirstPrice();
        if (r63 == null) goto L97;
        String r511 = r63.getSuffix();
    L98:
        PriceComponent r64 = r14.getPriceComponent();
        if (r64 == null) goto L103;
        SkuPriceInfo r65 = r64.getFirstPrice();
        if (r65 == null) goto L103;
        Boolean r66 = r65.isUnderline();
    L104:
        PriceComponent r67 = r14.getPriceComponent();
        if (r67 == null) goto L109;
        SkuPriceInfo r68 = r67.getFirstPrice();
        if (r68 == null) goto L109;
        String r69 = r68.getSupplement();
    L110:
        PriceComponent r70 = r14.getPriceComponent();
        if (r70 == null) goto L115;
        SkuPriceInfo r71 = r70.getSecondPrice();
        if (r71 == null) goto L115;
        Long r610 = r71.getPrice();
    L116:
        PriceComponent r72 = r14.getPriceComponent();
        if (r72 == null) goto L121;
        SkuPriceInfo r73 = r72.getSecondPrice();
        if (r73 == null) goto L121;
        String r611 = r73.getPrefix();
    L122:
        PriceComponent r74 = r14.getPriceComponent();
        if (r74 == null) goto L127;
        SkuPriceInfo r75 = r74.getSecondPrice();
        if (r75 == null) goto L127;
        String r612 = r75.getSuffix();
    L128:
        PriceComponent r76 = r14.getPriceComponent();
        if (r76 == null) goto L133;
        SkuPriceInfo r77 = r76.getSecondPrice();
        if (r77 == null) goto L133;
        Boolean r613 = r77.isUnderline();
    L134:
        PriceComponent r78 = r14.getPriceComponent();
        if (r78 == null) goto L139;
        SkuPriceInfo r79 = r78.getSecondPrice();
        if (r79 == null) goto L139;
        Boolean r614 = r79.isReducePrice();
    L140:
        PriceComponent r80 = r14.getPriceComponent();
        if (r80 == null) goto L145;
        SkuPriceInfo r81 = r80.getSecondPrice();
        if (r81 == null) goto L145;
        String r615 = r81.getSupplement();
    L146:
        PriceComponent r82 = r14.getPriceComponent();
        if (r82 == null) goto L151;
        SkuPriceInfo r83 = r82.getRegularPrice();
        if (r83 == null) goto L151;
        Long r616 = r83.getPrice();
    L152:
        PriceComponent r84 = r14.getPriceComponent();
        if (r84 == null) goto L157;
        SkuPriceInfo r85 = r84.getRegularPrice();
        if (r85 == null) goto L157;
        String r617 = r85.getPrefix();
    L158:
        PriceComponent r86 = r14.getPriceComponent();
        if (r86 == null) goto L163;
        SkuPriceInfo r87 = r86.getRegularPrice();
        if (r87 == null) goto L163;
        String r710 = r87.getSuffix();
    L164:
        PriceComponent r88 = r14.getPriceComponent();
        if (r88 == null) goto L169;
        SkuPriceInfo r89 = r88.getRegularPrice();
        if (r89 == null) goto L169;
        Boolean r711 = r89.isUnderline();
    L170:
        PriceComponent r90 = r14.getPriceComponent();
        if (r90 == null) goto L175;
        SkuPriceInfo r91 = r90.getRegularPrice();
        if (r91 == null) goto L175;
        String r712 = r91.getSupplement();
    L176:
        PriceComponent r92 = r14.getPriceComponent();
        if (r92 == null) goto L179;
        Long r713 = r92.getSkuPriceType();
    L180:
        PriceComponent r93 = r14.getPriceComponent();
        if (r93 == null) goto L185;
        HotSalePrice r94 = r93.getHotSalePrice();
        if (r94 == null) goto L185;
        Long r714 = r94.getMinPrice();
    L186:
        PriceComponent r95 = r14.getPriceComponent();
        if (r95 == null) goto L191;
        HotSalePrice r96 = r95.getHotSalePrice();
        if (r96 == null) goto L191;
        Long r715 = r96.getMaxPrice();
    L192:
        PriceComponent r97 = r14.getPriceComponent();
        if (r97 == null) goto L195;
        Integer r716 = r97.getAtmosphereStyle();
    L196:
        String r717 = r14.getStockDesc();
        SkuStatusDetail r718 = r14.getSkuStatusDetail();
        String r719 = r14.getSkuExtra();
        HashMap<String, String> r810 = r14.getShowEventTrack();
        ButtonTipComponent r811 = r14.getButtonTipComponent();
        Boolean r812 = r14.getHideTradeIn();
        Boolean r98 = r14.getCanAddCart();
        if (r98 == null) goto L199;
        r54 = r98.booleanValue();
    L199:
        boolean r512 = r24;
        SkuItemInfoVO r99 = new SkuItemInfoVO(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r48, r49, r410, r411, r412, r50, r51, r53, r512, r55, r56, r59, r510, r511, r66, r69, r610, r611, r612, r613, r614, r615, r616, r617, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, Boolean.valueOf(r54), r14.getPromiseType());
        r99.setCanSelect(r14.getCanSelect());
        LinkedHashMap r100 = r11;
        r100.put(r13, r99);
        r11 = r100;
        r10 = 1000;
        goto L6
    L195:
        r716 = null;
    L191:
        r715 = null;
    L185:
        r714 = null;
        goto L186
    L179:
        r713 = null;
    L175:
        r712 = null;
    L169:
        r711 = null;
    L163:
        r710 = null;
    L157:
        r617 = null;
    L151:
        r616 = null;
    L145:
        r615 = null;
    L139:
        r614 = null;
    L133:
        r613 = null;
    L127:
        r612 = null;
    L121:
        r611 = null;
    L115:
        r610 = null;
    L109:
        r69 = null;
    L103:
        r66 = null;
    L97:
        r511 = null;
    L91:
        r510 = null;
    L85:
        r59 = null;
        goto L86
    L61:
        if (r52.longValue() != 10) goto L78;
        Long r101 = r14.getCampaignStartTime();
        if (r101 == null) goto L65;
        long r102 = r101.longValue();
    L66:
        Long r118 = r14.getCampaignEndTime();
        if (r118 == null) goto L69;
        long r103 = r118.longValue();
    L70:
        LongRange r104 = new LongRange(r102, r103);
        Long r105 = r14.getServerTime();
        if (r105 != null) goto L73;
    L75:
        boolean r106 = false;
    L76:
        if (r106 == false) goto L79;
        r55 = true;
        goto L80
    L73:
        if (r104.contains(r105.longValue()) == false) goto L75;
        r106 = true;
        goto L76
    L69:
        r103 = 0;
        goto L70
    L65:
        r102 = 0;
        goto L66
    L39:
        if (r117.longValue() != 7) goto L56;
        Long r119 = r14.getCampaignStartTime();
        if (r119 == null) goto L43;
        long r107 = r119.longValue();
    L44:
        Long r513 = r14.getCampaignEndTime();
        if (r513 == null) goto L47;
        long r108 = r513.longValue();
    L48:
        LongRange r120 = new LongRange(r107, r108);
        Long r109 = r14.getServerTime();
        if (r109 != null) goto L51;
    L53:
        boolean r121 = false;
    L54:
        if (r121 == false) goto L56;
        r24 = true;
        goto L57
    L51:
        if (r120.contains(r109.longValue()) == false) goto L53;
        r121 = true;
        goto L54
    L47:
        r108 = 0;
        goto L48
    L43:
        r107 = 0;
        goto L44
    L34:
        r53 = null;
        goto L35
    L30:
        r51 = 0;
        goto L31
    L26:
        r412 = 0;
        goto L27
    L20:
        r47 = 0;
        goto L21
    L22:
        r48 = 0;
        goto L23
    L12:
        r44 = 0;
        goto L13
    L14:
        r42 = 0;
        goto L15
    L200:
        HashMap r813 = r11;
    L202:
        List<SpecInfo> r122 = r176.getSpecList();
        if (r122 != null) goto L205;
        r122 = CollectionsKt.emptyList();
    L205:
        List<SpecInfo> r814 = r122;
        ClothesSizeAssistantStruct r815 = r176.getClothesSizeAssistant();
        String r816 = r176.getCover();
        String r910 = r176.getBigCover();
        Map<String, String> r911 = r176.getPictureMap();
        Map<String, String> r912 = r176.getBigPic();
        Map<String, String> r913 = r176.getSmallPic();
        Long r123 = r176.getMinPrice();
        if (r123 == null) goto L208;
        long r914 = r123.longValue();
    L209:
        Long r124 = r176.getMaxPrice();
        if (r124 == null) goto L212;
        long r915 = r124.longValue();
    L213:
        String r916 = r176.getButtonLabel();
        Long r125 = r176.getComboLimit();
        if (r125 == null) goto L216;
        long r126 = r125.longValue();
    L217:
        SkuLimit r127 = new SkuLimit(r126, r176.getLimitToast());
        Long r128 = r176.getUserMinLimit();
        if (r128 == null) goto L220;
        long r129 = r128.longValue();
    L221:
        SkuLimit r130 = new SkuLimit(r129, r176.getMinLimitToast());
        Long r1010 = r176.getUnUseMinPrice();
        Long r1011 = r176.getDiscountPrice();
        String r1012 = r176.getDiscountPriceHeader();
        Long r1013 = r176.getPresellType();
        String r1014 = r176.getDeliveryDelayDesc();
        String r1015 = r176.getPresellDelayDesc();
        SkuInstallmentItemInfo r1016 = r176.getInstallmentInfo();
        TradeModeComponent r1017 = r176.getTradeModeComponent();
        List<SafeguardComponent> r131 = r176.getSafeguardComponents();
        if (r131 == null) goto L224;
        SafeguardComponent r1018 = (SafeguardComponent) CollectionsKt.firstOrNull(r131);
    L225:
        TopBannerComponent r1110 = r176.getTopBannerComponent();
        SkuTrustTags r1111 = r176.getTrustTags();
        String r1112 = r176.getLogExtra();
        String r1113 = r176.getPriceHeader();
        Integer r1114 = r176.getPriceHeaderStyle();
        String r1115 = r176.getNewBonusText();
        Long r1116 = r176.getSkuType();
        int r1117 = r176.getStatus();
        long r1118 = r176.getDepositPrice();
        String r1210 = r176.getLimitText();
        Long r132 = r176.getCampaignStartTime();
        if (r132 == null) goto L232;
        long r133 = r132.longValue();
        long r134 = SystemClock.elapsedRealtime();
        Long r135 = r176.getServerTime();
        if (r135 == null) goto L230;
        long r136 = r135.longValue();
    L231:
        long r1211 = r134 + ((r133 - r136) * 1000);
    L233:
        Long r137 = r176.getCampaignEndTime();
        if (r137 == null) goto L240;
        long r138 = r137.longValue();
        long r139 = SystemClock.elapsedRealtime();
        Long r140 = r176.getServerTime();
        if (r140 == null) goto L238;
        long r141 = r140.longValue();
    L239:
        long r1212 = r139 + ((r138 - r141) * 1000);
    L241:
        Long r142 = r176.getServerTime();
        if (r142 == null) goto L244;
        long r1213 = r142.longValue();
    L245:
        Long r143 = r176.getMarketPrice();
        if (r143 == null) goto L248;
        long r1214 = r143.longValue();
    L249:
        ECUrlModel r1215 = r176.getActivityIcon();
        SkuPoiInfo r1310 = r176.getPoiInfo();
        String r1311 = r176.getAtmosphereHeader();
        ECUrlModel r1312 = r176.getAtmosphereBackground();
        Integer r1313 = r176.getCampaignSubType();
        Boolean r1314 = r176.getHasGivenProduct();
        Integer r1315 = r176.getGivenProductStock();
        SkuBannerStruct r1316 = r176.getBanner();
        boolean r1317 = r176.getShowStock();
        int r1318 = r176.getShowPriceStyle();
        int r1319 = r176.getDiscountPriceStyleType();
        LogPbData r144 = r176.getLogPb();
        List<SkuBottomButtons> r145 = r176.getDefaultButtons();
        DisplayConfig r146 = r176.getDisplayConfig();
        CarAdaptComponent r147 = r176.getCarAdaptComponent();
        OrderComponent r148 = r176.getOrderComponent();
        PriceComponent r149 = r176.getPriceComponent();
        if (r149 == null) goto L254;
        SkuPriceInfo r150 = r149.getFirstPrice();
        if (r150 == null) goto L254;
        Long r1410 = r150.getPrice();
    L255:
        PriceComponent r151 = r176.getPriceComponent();
        if (r151 == null) goto L260;
        SkuPriceInfo r152 = r151.getFirstPrice();
        if (r152 == null) goto L260;
        String r1411 = r152.getPrefix();
    L261:
        PriceComponent r153 = r176.getPriceComponent();
        if (r153 == null) goto L266;
        SkuPriceInfo r154 = r153.getFirstPrice();
        if (r154 == null) goto L266;
        String r1412 = r154.getSuffix();
    L267:
        PriceComponent r155 = r176.getPriceComponent();
        if (r155 == null) goto L272;
        SkuPriceInfo r156 = r155.getFirstPrice();
        if (r156 == null) goto L272;
        String r1413 = r156.getSupplement();
    L273:
        PriceComponent r157 = r176.getPriceComponent();
        if (r157 == null) goto L278;
        SkuPriceInfo r158 = r157.getFirstPrice();
        if (r158 == null) goto L278;
        Boolean r1414 = r158.isUnderline();
    L279:
        PriceComponent r159 = r176.getPriceComponent();
        if (r159 == null) goto L284;
        SkuPriceInfo r160 = r159.getSecondPrice();
        if (r160 == null) goto L284;
        Long r1510 = r160.getPrice();
    L285:
        PriceComponent r161 = r176.getPriceComponent();
        if (r161 == null) goto L290;
        SkuPriceInfo r162 = r161.getSecondPrice();
        if (r162 == null) goto L290;
        String r1511 = r162.getPrefix();
    L291:
        PriceComponent r163 = r176.getPriceComponent();
        if (r163 == null) goto L296;
        SkuPriceInfo r164 = r163.getSecondPrice();
        if (r164 == null) goto L296;
        String r1512 = r164.getSuffix();
    L297:
        PriceComponent r165 = r176.getPriceComponent();
        if (r165 == null) goto L302;
        SkuPriceInfo r166 = r165.getSecondPrice();
        if (r166 == null) goto L302;
        Boolean r1513 = r166.isUnderline();
    L303:
        PriceComponent r167 = r176.getPriceComponent();
        if (r167 == null) goto L308;
        SkuPriceInfo r168 = r167.getSecondPrice();
        if (r168 == null) goto L308;
        Boolean r1514 = r168.isReducePrice();
    L309:
        PriceComponent r169 = r176.getPriceComponent();
        if (r169 == null) goto L314;
        SkuPriceInfo r170 = r169.getSecondPrice();
        if (r170 == null) goto L314;
        String r1515 = r170.getSupplement();
    L315:
        PriceComponent r171 = r176.getPriceComponent();
        if (r171 == null) goto L318;
        Long r1516 = r171.getSkuPriceType();
    L319:
        PriceComponent r172 = r176.getPriceComponent();
        if (r172 == null) goto L324;
        SkuPriceInfo r173 = r172.getRegularPrice();
        if (r173 == null) goto L324;
        Long r1517 = r173.getPrice();
    L325:
        PriceComponent r174 = r176.getPriceComponent();
        if (r174 == null) goto L330;
        SkuPriceInfo r175 = r174.getRegularPrice();
        if (r175 == null) goto L330;
        String r1518 = r175.getPrefix();
    L331:
        PriceComponent r177 = r176.getPriceComponent();
        if (r177 == null) goto L336;
        SkuPriceInfo r178 = r177.getRegularPrice();
        if (r178 == null) goto L336;
        String r1519 = r178.getSuffix();
    L337:
        PriceComponent r179 = r176.getPriceComponent();
        if (r179 == null) goto L342;
        SkuPriceInfo r180 = r179.getRegularPrice();
        if (r180 == null) goto L342;
        Boolean r1610 = r180.isUnderline();
    L343:
        PriceComponent r181 = r176.getPriceComponent();
        if (r181 == null) goto L348;
        SkuPriceInfo r182 = r181.getRegularPrice();
        if (r182 == null) goto L348;
        String r1611 = r182.getSupplement();
    L349:
        PriceComponent r183 = r176.getPriceComponent();
        if (r183 == null) goto L354;
        HotSalePrice r184 = r183.getHotSalePrice();
        if (r184 == null) goto L354;
        Long r1612 = r184.getMinPrice();
    L355:
        PriceComponent r185 = r176.getPriceComponent();
        if (r185 == null) goto L360;
        HotSalePrice r186 = r185.getHotSalePrice();
        if (r186 == null) goto L360;
        Long r1613 = r186.getMaxPrice();
    L361:
        PriceComponent r187 = r176.getPriceComponent();
        if (r187 == null) goto L366;
        HotSalePrice r188 = r187.getHotSalePrice();
        if (r188 == null) goto L366;
        String r1614 = r188.getPrefix();
    L367:
        PriceComponent r189 = r176.getPriceComponent();
        if (r189 == null) goto L370;
        Integer r1615 = r189.getAtmosphereStyle();
    L372:
        return new SkuInfoVO(r813, r814, r815, r816, r910, r911, r912, r913, r914, r915, r916, r127, r130, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r1110, r1111, r1112, r1113, r1114, r1115, r1116, r1117, r1118, r1210, r1211, r1212, r1213, r1214, r1215, r1310, r1311, r1312, r1313, r1314, r1315, r1316, r1317, r1318, r1319, r144, r145, r146, r147, r148, r1410, r1411, r1412, r1414, r1413, r1510, r1511, r1512, r1513, r1514, r1515, r1516, r1517, r1518, r1519, r1610, r1611, r1612, r1613, r1614, null, r1615, r176.getProductExtra(), r176.getButtonTipComponent(), r176.getShowTrackParams(), r176.getAddCartGuideInfo(), r176.getUpdateActionOption(), 0, 0, 256, null);
    L370:
        r1615 = null;
    L366:
        r1614 = null;
    L360:
        r1613 = null;
    L354:
        r1612 = null;
    L348:
        r1611 = null;
    L342:
        r1610 = null;
    L336:
        r1519 = null;
    L330:
        r1518 = null;
    L324:
        r1517 = null;
        goto L325
    L318:
        r1516 = null;
    L314:
        r1515 = null;
    L308:
        r1514 = null;
    L302:
        r1513 = null;
    L296:
        r1512 = null;
    L290:
        r1511 = null;
    L284:
        r1510 = null;
    L278:
        r1414 = null;
    L272:
        r1413 = null;
    L266:
        r1412 = null;
    L260:
        r1411 = null;
    L254:
        r1410 = null;
        goto L255
    L248:
        r1214 = 0;
        goto L249
    L244:
        r1213 = 0;
        goto L245
    L238:
        r141 = 0;
        goto L239
    L240:
        r1212 = 0;
        goto L241
    L230:
        r136 = 0;
        goto L231
    L232:
        r1211 = 0;
        goto L233
    L224:
        r1018 = null;
        goto L225
    L220:
        r129 = 1;
        goto L221
    L216:
        r126 = Long.MAX_VALUE;
        goto L217
    L212:
        r915 = 0;
        goto L213
    L208:
        r914 = 0;
        goto L209
    L201:
        r813 = new HashMap();
        goto L202
    }

    public static final String a(String r1, Integer r10) {
        if (jg.g.a(r1) == false) goto L9;
        if (r10 != null) goto L6;
        return r1;
    L6:
        if (r10.intValue() > 0) goto L8;
        return r1;
    L8:
        return l0.a(r1, "height_percent", String.valueOf(r10.intValue()));
    L9:
        return r1;
    }

    public static final String b(int r10, String r11, List<? extends ECUrlModel> r12, String r13) {
        boolean r0 = false;
        if (r10 != 1) goto L13;
        if (r13 != null) goto L6;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L13;
        return r11;
    L6:
        if (r13.length() == 0) goto L9;
        r14 = false;
    L13:
        if (r10 != 2) goto L16;
        return "";
    L16:
        Uri.Builder r15 = UriProtector.parse(r11).buildUpon();
        JSONArray r16 = new JSONArray();
        Iterator<? extends ECUrlModel> r17 = r12.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        r16.put(tv5.a.b(r17.next()));
        goto L18
    L20:
        JSONObject r18 = new JSONObject();
        r18.put("images", r16);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L31
        if (r10 != 1) goto L29;
        if (r13 != null) goto L25;
    L26:
        r0 = true;
    L27:
        if (r0 == true) goto L29;
        r18.put("track_params", r13);     // Catch: Throwable -> L31
        goto L29
    L25:
        if (r13.length() != 0) goto L27;
    L29:
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L36;
        ECExceptionMonitor.e(r21);
    L36:
        Unit r22 = Unit.INSTANCE;
        r15.appendQueryParameter("mega_object", r18.toString());
        return r15.build().toString();
    L31:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public static final e c(SkuInfoVO r23, Context r24, int r25, Integer r26, int r27, String r28, Integer r29) {
        Intrinsics.checkNotNullParameter(r23, "$this$transformToGroupTitleVO");
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r28, "baseParamsJson");
        SpecInfo r10 = (SpecInfo) ListProtector.get(r23.getSpecInfoList(), r25);
        if (r26 == null) goto L9;
        if (r26.intValue() != 3) goto L9;
        j r11 = new j(th.a.a(r24, 2131101247), 13.0f, true, r10.getName(), true);
    L21:
        ClothesSizeAssistantStruct r12 = r23.getClothesSizeAssistant();
        c r13 = null;
        if (r12 == null) goto L24;
        Integer r14 = r12.getSpecLocation();
    L25:
        if (r14 == null) goto L143;
        if (r14.intValue() != r25) goto L143;
        Integer r1 = r23.getClothesSizeAssistant().getAbTest();
        int r15 = -2;
        boolean r16 = true;
        boolean r17 = false;
        String r18 = "";
        if (r1 != null) goto L34;
    L77:
        Integer r19 = r23.getClothesSizeAssistant().getAbTest();
        if (r19 == null) goto L143;
        if (r19.intValue() != 2) goto L143;
        String r20 = r23.getClothesSizeAssistant().getRecommendClothesSize();
        if (r20 != null) goto L85;
    L88:
        boolean r21 = true;
    L89:
        if (r21 == false) goto L91;
        String r0 = th.a.g(r24, 2131914099);
    L92:
        String r22 = r23.getClothesSizeAssistant().getLinkSchema();
        if (r22 != null) goto L95;
    L97:
        boolean r30 = false;
    L99:
        if (r27 != 101) goto L101;
    L112:
        String r31 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L114:
        if (r28.length() != 0) goto L116;
        r17 = true;
    L116:
        if (r17 == false) goto L118;
        JSONObject r32 = new JSONObject();
    L119:
        r32.put("sku_from", r31);
        r32.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r32.optString(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID));
        Unit r33 = Unit.INSTANCE;
        String r34 = r32.toString();
        if (r30 == false) goto L143;
        SpecChartStruct r35 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r35 == null) goto L126;
        Integer r36 = r35.getWidth();
        if (r36 == null) goto L126;
        int r37 = r36.intValue();
    L127:
        SpecChartStruct r110 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r110 == null) goto L132;
        Integer r111 = r110.getHeight();
        if (r111 == null) goto L132;
        r15 = r111.intValue();
    L132:
        String r112 = r23.getClothesSizeAssistant().getLinkSchema();
        if (r112 == null) goto L136;
        r18 = r112;
    L136:
        SpecChartStruct r38 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r38 == null) goto L140;
        List<ECUrlModel> r39 = r38.getImages();
        if (r39 == null) goto L140;
    L141:
        r13 = new c(1, r0, null, r37, r15, a(b(1, r18, r39, r34), r29));
    L140:
        r39 = CollectionsKt.emptyList();
    L126:
        r37 = -2;
        goto L127
    L118:
        r32 = new JSONObject(r28);
        goto L119
    L101:
        if (r27 == 102) goto L112;
        if (r27 != 201) goto L105;
        r31 = "live";
        goto L114
    L105:
        if (r27 != 901) goto L107;
        r31 = "cart";
        goto L114
    L107:
        if (r27 == 1001) goto L109;
        r31 = "";
        goto L114
    L109:
        r31 = "exchange";
        goto L114
    L95:
        if (jg.g.a(r22) != true) goto L97;
        r30 = true;
        goto L99
    L91:
        r0 = th.a.g(r24, 2131914100) + ' ' + r23.getClothesSizeAssistant().getRecommendClothesSize();
        goto L92
    L85:
        if (r20.length() == 0) goto L88;
        r21 = false;
        goto L89
    L34:
        if (r1.intValue() != 1) goto L77;
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.r0().length() <= 0) goto L38;
        boolean r40 = true;
    L39:
        if (r40 == false) goto L47;
        SpecChartStruct r41 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r41 == null) goto L47;
        List<ECUrlModel> r42 = r41.getImages();
        if (r42 == null) goto L47;
        if ((!r42.isEmpty()) != true) goto L47;
    L48:
        if (r16 == false) goto L143;
        SpecChartStruct r43 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r43 == null) goto L53;
        String r44 = r43.getTitle();
        if (r44 == null) goto L53;
    L54:
        ECUrlModel r45 = new ECUrlModel();
        SpecChartStruct r46 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r46 == null) goto L60;
        String r47 = r46.getIcon();
        if (r47 == null) goto L60;
        r18 = r47;
    L60:
        r45.setUrlList(CollectionsKt.listOf(r18));
        Unit r48 = Unit.INSTANCE;
        SpecChartStruct r49 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r49 == null) goto L65;
        Integer r50 = r49.getWidth();
        if (r50 == null) goto L65;
        int r51 = r50.intValue();
    L66:
        SpecChartStruct r52 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r52 == null) goto L71;
        Integer r53 = r52.getHeight();
        if (r53 == null) goto L71;
        r15 = r53.intValue();
    L71:
        String r54 = ECSettingKeys.r0();
        SpecChartStruct r55 = r23.getClothesSizeAssistant().getSizeComponent();
        if (r55 == null) goto L75;
        List<ECUrlModel> r56 = r55.getImages();
        if (r56 == null) goto L75;
    L76:
        r13 = new c(0, r44, r45, r51, r15, a(b(0, r54, r56, null), r29));
    L75:
        r56 = CollectionsKt.emptyList();
    L65:
        r51 = -2;
    L53:
        r44 = "";
    L47:
        r16 = false;
        goto L48
    L38:
        r40 = false;
    L143:
        return new e(r11, r13);
    L24:
        r14 = null;
    L9:
        if (r26 != null) goto L12;
    L15:
        if (r26 != null) goto L18;
    L20:
        j r57 = new j(th.a.a(r24, 2131106228), 13.0f, false, r10.getName(), false);
    L14:
        r11 = r57;
        goto L21
    L18:
        if (r26.intValue() != 4) goto L20;
        r11 = new j(th.a.a(r24, 2131101245), 13.0f, false, r10.getName(), false);
        goto L21
    L12:
        if (r26.intValue() != 2) goto L15;
        r57 = new j(th.a.a(r24, 2131106228), 11.0f, false, r10.getName(), false);
        goto L14
    }
}
