package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupOptimizeLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s0 extends QFragmentPresenter {
    public SkuViewModel f;

    public final void k0() {
        int r0 = UIUtils.getScreenWidth(Y().c());
        if (Z().b(2131378870).f().getVisibility() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        int r10 = i0(2131378870);
        ((TextView) Z().b(2131391463).f()).setMaxWidth(((((r0 - vf4.a.b(56)) - vf4.a.b(24)) - vf4.a.b(8)) - r10) - vf4.a.b(8));
        return;
    L9:
        ((TextView) Z().b(2131391463).f()).setMaxWidth(((r0 - vf4.a.b(56)) - vf4.a.b(24)) - vf4.a.b(8));
        return;
    L5:
        r1 = false;
        goto L7
    }

    public s0(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final String d0(s0 r31) {
        String r10 = com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG;
        SkuViewModel r11 = r31.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r12 = r11.getSkuParams().getDetailUrl();
        if (r12 == null) goto L231;
        SkuViewModel r13 = r31.f;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        Map r14 = r13.getSkuParams().getLiveEventParams();
        String r15 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        String r19 = "";
        if (r14 == null) goto L76;
        Map r16 = MapsKt.toMutableMap(r14);
        if (r16 == null) goto L76;
        String r20 = com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG;
        SkuViewModel r0 = r31.f;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Map r1 = r0.getSkuParams().getEventParams();
        String r21 = com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG;
        if (r1 == null) goto L21;
        String r17 = (String) r1.get("screen_type");
        if (r17 == null) goto L21;
    L22:
        r16.put("screen_type", r17);
        SkuViewModel r18 = r31.f;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        Map r22 = r18.getSkuParams().getEventParams();
        if (r22 == null) goto L28;
        String r23 = (String) r22.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
    L29:
        if (r23 != null) goto L31;
        r23 = "";
    L31:
        r16.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r23);
        SkuViewModel r24 = r31.f;
        if (r24 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        if (r24.isInDepositPresale() == false) goto L37;
        Object r25 = "1";
    L38:
        r16.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r25);
        SkuViewModel r26 = r31.f;
        if (r26 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        Map r27 = r26.getSkuParams().getEventParams();
        if (r27 == null) goto L44;
        String r28 = (String) r27.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
    L45:
        if (r28 != null) goto L47;
        r28 = "";
    L47:
        r16.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r28);
        SkuViewModel r29 = r31.f;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        Map r30 = r29.getSkuParams().getEventParams();
        if (r30 == null) goto L54;
        String r32 = (String) r30.get("is_explaining");
        if (r32 == null) goto L54;
    L55:
        r16.put("is_explaining", r32);
        SkuViewModel r33 = r31.f;
        if (r33 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        Map r34 = r33.getSkuParams().getEventParams();
        if (r34 == null) goto L61;
        String r35 = (String) r34.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L62:
        if (r35 != null) goto L64;
        r35 = "";
    L64:
        r16.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r35);
        SkuViewModel r36 = r31.f;
        if (r36 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        String r37 = r36.getSkuParams().getTransmissibleJson();
        if (r37 != null) goto L70;
        r37 = "";
    L70:
        r16.put("transmissible_json", r37);
        SkuViewModel r38 = r31.f;
        if (r38 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        if (r38.getSkuParams().isLiveSkuCheck() == false) goto L77;
        r16.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");
    L77:
        String r39 = com.bytedance.android.ec.common.impl.sku.utils.d.c(r12, "v3_events_additions", r16);
        String r40 = "meta_params";
        String r41 = UriProtector.getQueryParameter(UriProtector.parse(r39), "meta_params");
        if (r41 != null) goto L80;
    L183:
        r15 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        String r42 = r39;
    L184:
        SkuViewModel r43 = r31.f;
        if (r43 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L187:
        String r44 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r42, "disable_live_window", String.valueOf(r43.getSkuParams().isFromPlayback()));
        Lazy r45 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L190;
        r44 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r44, "request_page", ECAIConstants.SCENE_ECOM_PRODUCT);
    L190:
        SkuViewModel r46 = r31.f;
        if (r46 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L193:
        Map r47 = r46.getSkuParams().getEventParams();
        if (r47 == null) goto L196;
        String r48 = (String) r47.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L197:
        String r49 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r44, com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r48);
        SkuViewModel r50 = r31.f;
        if (r50 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L200:
        Map r51 = r50.getSkuParams().getEventParams();
        if (r51 == null) goto L203;
        String r52 = (String) r51.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
    L204:
        String r53 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r49, "label_name_from_live", r52);
        SkuViewModel r54 = r31.f;
        if (r54 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        Map r55 = r54.getSkuParams().getEventParams();
        String r56 = r15;
        if (r55 == null) goto L210;
        String r57 = (String) r55.get(r56);
    L211:
        String r58 = com.bytedance.android.ec.common.impl.sku.utils.d.d(com.bytedance.android.ec.common.impl.sku.utils.d.d(r53, r56, r57), "promotion_source", String.valueOf(SourceType.XIAO_DIAN.getType()));
        SkuViewModel r59 = r31.f;
        if (r59 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        r59.setLastBehaviorBeforeDismiss("click");
        if (jg.h.a.getActivity(r31.a0()) == null) goto L217;
        r19 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c6709.d2425", Boolean.FALSE).withView(r31.a0()).build());
    L217:
        String r60 = r19;
        SkuViewModel r61 = r31.f;
        if (r61 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L220:
        Pair[] r62 = new Pair[2];
        SkuViewModel r63 = r31.f;
        if (r63 != null) goto L223;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L223:
        SkuInfoVO r64 = (SkuInfoVO) r63.getSkuInfo().a();
        if (r64 == null) goto L226;
        Long r65 = r64.getDiscountPrice();
    L227:
        if (r65 == null) goto L229;
        Object r110 = "1";
    L230:
        r62[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r110);
        r62[1] = TuplesKt.to("btm_id", r60);
        SkuViewModel.doSkuEventAction$default(r61, "click_product_detail", r62, null, null, null, 28, null);
        return com.bytedance.android.ec.core.btm.c.c(r58, r31.a0(), "a1.b5267.c6709.d2425", new Pair[0]);
    L229:
        r110 = "0";
        goto L230
    L226:
        r65 = null;
        goto L227
    L210:
        r57 = null;
        goto L211
    L203:
        r52 = null;
        goto L204
    L196:
        r48 = null;
        goto L197
    L80:
        if (r41.length() <= 0) goto L82;
        boolean r210 = true;
    L83:
        if (r210 == true) goto L86;
        r41 = null;
    L86:
        if (r41 == null) goto L183;
        JSONObject r111 = new JSONObject(r41);     // Catch: JSONException -> L179
        String r66 = r111.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: JSONException -> L179
        if (r66.length() <= 0) goto L90;
        boolean r211 = true;
    L91:
        if (r211 == true) goto L95;
        r66 = null;
    L95:
        if (r66 != null) goto L237;
        String r212 = r39;
        r10 = com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG;
        r40 = "meta_params";
    L239:
        String r67 = r212;
        r42 = com.bytedance.android.ec.common.impl.sku.utils.d.b(r67, r40, r111.toString());     // Catch: JSONException -> L175
        SkuViewModel r68 = r31.f;     // Catch: JSONException -> L173
        if (r68 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L173
    L161:
        String r69 = r68.getSkuParams().getSkuLogExtra();     // Catch: JSONException -> L173
        if (r69 == null) goto L184;
        if (r69.length() <= 0) goto L166;
        boolean r70 = true;
    L167:
        if (r70 == true) goto L170;
        r69 = null;
    L170:
        if (r69 == null) goto L184;
        JSONObject r71 = new JSONObject(r69);     // Catch: JSONException -> L173
        String r72 = r10;
        String r73 = r21;
        String r74 = r20;
        r42 = com.bytedance.android.ec.common.impl.sku.utils.d.a(r42, new Pair[]{new Pair(r72, r71.optString(r72)), new Pair(r73, r71.optString(r73)), new Pair(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG, r71.optString(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG)), new Pair(r74, r71.optString(r74))});     // Catch: JSONException -> L173
        goto L184
    L166:
        r70 = false;
    L173:
        e = e;
    L182:
        ECExceptionMonitor.e(e);
        Unit r75 = Unit.INSTANCE;
    L175:
        e = e;
    L181:
        r42 = r67;
    L177:
        e = e;
        r67 = r212;
        goto L181
    L237:
        int r213 = ECSdk.a;     // Catch: JSONException -> L151
        IEntranceInfoService r76 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);     // Catch: JSONException -> L151
        if (r76 == null) goto L101;
        r212 = r39;
        gl.a r77 = r76.initEntranceInfo(new EntranceInfoScene("sku", "enterProductDetail"), r66);     // Catch: JSONException -> L144
    L102:
        if (r77 == null) goto L146;
        Pair[] r78 = new Pair[7];     // Catch: JSONException -> L144
        r78[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");     // Catch: JSONException -> L144
        SkuViewModel r79 = r31.f;     // Catch: JSONException -> L144
        if (r79 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L107:
        if (r79.isInDepositPresale() == false) goto L109;
        Object r80 = "1";
    L110:
        r78[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r80);     // Catch: JSONException -> L144
        SkuViewModel r81 = r31.f;     // Catch: JSONException -> L144
        if (r81 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L113:
        SkuInfoVO r82 = (SkuInfoVO) r81.getSkuInfo().a();     // Catch: JSONException -> L144
        if (r82 != null) goto L116;
    L118:
        int r83 = 0;
    L119:
        r78[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_UNDER_STOCK, Integer.valueOf(r83));     // Catch: JSONException -> L144
        SkuViewModel r84 = r31.f;     // Catch: JSONException -> L144
        if (r84 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L122:
        String r85 = (String) r84.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);     // Catch: JSONException -> L144
        if (r85 != null) goto L125;
        r85 = "0";
    L125:
        r78[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r85);     // Catch: JSONException -> L144
        SkuViewModel r86 = r31.f;     // Catch: JSONException -> L144
        if (r86 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L128:
        String r87 = (String) r86.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);     // Catch: JSONException -> L144
        if (r87 != null) goto L131;
        r87 = "";
    L131:
        r78[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r87);     // Catch: JSONException -> L144
        SkuViewModel r88 = r31.f;     // Catch: JSONException -> L144
        if (r88 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L134:
        String r89 = (String) r88.getSkuParams().getEventParams().get("is_explaining");     // Catch: JSONException -> L144
        if (r89 != null) goto L137;
        r89 = "0";
    L137:
        r78[5] = TuplesKt.to("is_explaining", r89);     // Catch: JSONException -> L144
        SkuViewModel r90 = r31.f;     // Catch: JSONException -> L144
        if (r90 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L140:
        String r91 = (String) r90.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);     // Catch: JSONException -> L144
        if (r91 != null) goto L143;
        r91 = "";
    L143:
        r78[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r91);     // Catch: JSONException -> L144
        r77.g(r78);     // Catch: JSONException -> L144
        goto L146
    L116:
        if (r82.isUnderStock() != true) goto L118;
        r83 = 1;
        goto L119
    L109:
        r80 = "0";
    L146:
        if (r77 == null) goto L148;
        String r92 = r77.h();     // Catch: JSONException -> L144
    L149:
        r111.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r92);     // Catch: JSONException -> L144
        goto L239
    L148:
        r92 = null;
    L144:
        e = e;
    L153:
        r42 = r212;
        goto L182
    L101:
        r212 = r39;
        r77 = null;
    L151:
        e = e;
        r212 = r39;
        goto L153
    L90:
        r211 = false;
    L179:
        e = e;
        r15 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        r67 = r39;
        goto L181
    L82:
        r210 = false;
        goto L83
    L61:
        r35 = null;
    L54:
        r32 = "0";
        goto L55
    L44:
        r28 = null;
        goto L45
    L37:
        r25 = "0";
        goto L38
    L28:
        r23 = null;
    L21:
        r17 = "0";
    L76:
        r20 = com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG;
        r21 = com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG;
        r16 = null;
        goto L77
    L231:
        return null;
    }

    public static final /* synthetic */ SkuViewModel e0(s0 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    /* JADX WARN: Type inference failed for: r1v110, types: [android.widget.TextView, com.bytedance.android.ec.core.widget.PriceView] */
    /* JADX WARN: Type inference failed for: r1v158, types: [android.view.View, com.bytedance.android.ec.core.widget.PriceView] */
    /* JADX WARN: Type inference failed for: r1v73, types: [android.widget.TextView, com.bytedance.android.ec.core.widget.PriceView] */
    /* JADX WARN: Type inference failed for: r1v90, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.ec.core.widget.PriceView, com.bytedance.android.ec.core.widget.price.PriceView] */
    /* JADX WARN: Type inference failed for: r1v95, types: [android.widget.TextView, com.bytedance.android.ec.core.widget.PriceView] */
    public static final void h0(s0 r25) {
        SkuViewModel r1 = r25.f;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r1.getCurrentHotMinPrice() == null) goto L8;
        boolean r10 = true;
    L9:
        int r11 = 2131383488;
        if (r10 == false) goto L60;
        SkuViewModel r12 = r25.f;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        if (r12.getCurrentHotMaxPrice() == null) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L60;
        SkuViewModel r14 = r25.f;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        Long r15 = r14.getCurrentPriceType();
        if (r15 != null) goto L26;
    L45:
        PriceView r16 = (PriceView) r25.Z().b(2131383487).f();
        int r17 = jg.b.a;
        SkuViewModel r18 = r25.f;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        Long r19 = r18.getCurrentHotMinPrice();
        if (r19 == null) goto L51;
        long r110 = r19.longValue();
    L52:
        r16.setPriceText(jg.b.b(r110));
        PriceView r20 = (PriceView) r25.Z().b(2131383486).f();
        SkuViewModel r111 = r25.f;
        if (r111 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        Long r112 = r111.getCurrentHotMaxPrice();
        if (r112 == null) goto L58;
        long r113 = r112.longValue();
    L59:
        r20.setPriceText(jg.b.b(r113));
        r25.Z().b(2131383487).f().setVisibility(0);
        r25.Z().b(2131391451).f().setVisibility(0);
        r25.Z().b(2131383486).f().setVisibility(0);
    L61:
        SkuViewModel r21 = r25.f;
        if (r21 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        if (r21.getCurrentFirstPrice() == null) goto L67;
        boolean r22 = true;
    L69:
        if (r22 == false) goto L100;
        ?? r23 = (PriceView) r25.Z().b(2131383484).f();
        SkuViewModel r114 = r25.f;
        if (r114 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        r23.setPrefixText(r114.getCurrentFirstPricePrefix());
        SkuViewModel r115 = r25.f;
        if (r115 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L76:
        r23.setExtraText(r115.getCurrentFirstPriceSuffix());
        SkuViewModel r116 = r25.f;
        if (r116 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L79:
        Boolean r117 = r116.getCurrentFirstPriceIsUnderline();
        if (r117 == null) goto L82;
        boolean r118 = r117.booleanValue();
    L83:
        r23.setShowDeleteLine(r118);
        int r119 = jg.b.a;
        SkuViewModel r120 = r25.f;
        if (r120 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L86:
        Long r121 = r120.getCurrentFirstPrice();
        if (r121 == null) goto L89;
        long r122 = r121.longValue();
    L90:
        r23.setPriceText(jg.b.b(r122));
        r23.setVisibility(0);
        SkuViewModel r24 = r25.f;
        if (r24 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        if (cg4.a.a(r24.getCurrentFirstPriceSupplement()) == false) goto L99;
        TextView r26 = (TextView) r25.Z().b(2131383485).f();
        SkuViewModel r123 = r25.f;
        if (r123 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r26.setText(r123.getCurrentFirstPriceSupplement());
        r26.setVisibility(0);
    L101:
        SkuViewModel r27 = r25.f;
        if (r27 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        if (r27.getCurrentSecondPrice() == null) goto L107;
        boolean r28 = true;
    L109:
        if (r28 == false) goto L209;
        SkuViewModel r29 = r25.f;
        if (r29 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L113:
        Long r30 = r29.getCurrentPriceType();
        if (r30 != null) goto L117;
    L148:
        ?? r31 = (PriceView) r25.Z().b(2131383493).f();
        SkuViewModel r32 = r25.f;
        if (r32 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        r31.setPrefixText(r32.getCurrentSecondPricePrefix());
        SkuViewModel r33 = r25.f;
        if (r33 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        r31.setExtraText(r33.getCurrentSecondPriceSuffix());
        SkuViewModel r34 = r25.f;
        if (r34 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L157:
        Boolean r35 = r34.getCurrentSecondPriceIsUnderline();
        if (r35 == null) goto L160;
        boolean r36 = r35.booleanValue();
    L161:
        r31.setShowDeleteLine(r36);
        int r37 = jg.b.a;
        SkuViewModel r38 = r25.f;
        if (r38 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L164:
        Long r39 = r38.getCurrentSecondPrice();
        if (r39 == null) goto L167;
        long r124 = r39.longValue();
    L168:
        r31.setPriceText(jg.b.b(r124));
        r31.setVisibility(0);
        SkuViewModel r40 = r25.f;
        if (r40 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        if (cg4.a.a(r40.getCurrentSecondPriceSupplement()) == false) goto L177;
        TextView r41 = (TextView) r25.Z().b(2131383494).f();
        SkuViewModel r125 = r25.f;
        if (r125 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L176:
        r41.setText(r125.getCurrentSecondPriceSupplement());
        r41.setVisibility(0);
    L178:
        SkuViewModel r42 = r25.f;
        if (r42 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        Boolean r43 = r42.getCurrentSecondPriceIsReducePrice();
        Boolean r126 = Boolean.TRUE;
        if (Intrinsics.areEqual(r43, r126) == false) goto L189;
        r31.setHideYang(true);
        r31.C(HeaderOptimizePresenter$updatePriceNew$3$2.INSTANCE);
        r31.setPadding(UnitExtensionKt.dp2px(6), UnitExtensionKt.dp2px(2), UnitExtensionKt.dp2px(6), UnitExtensionKt.dp2px(2));
        Drawable r44 = r31.getBackground();
        if ((r44 instanceof GradientDrawable) == true) goto L186;
        r44 = null;
    L186:
        GradientDrawable r45 = (GradientDrawable) r44;
        if (r45 == null) goto L195;
        r45.setCornerRadii(new float[]{com.bytedance.android.ec.core.utils.q.a(10), com.bytedance.android.ec.core.utils.q.a(10), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(0), com.bytedance.android.ec.core.utils.q.a(0)});
        r31.setBackgroundDrawable(r45);
    L195:
        SkuViewModel r46 = r25.f;
        if (r46 != null) goto L198;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L198:
        Long r47 = r46.getCurrentPriceType();
        if (r47 != null) goto L202;
    L210:
        SkuViewModel r48 = r25.f;
        if (r48 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        if (r48.getCurrentRegularPrice() == null) goto L216;
        boolean r49 = true;
    L218:
        if (r49 == false) goto L249;
        ?? r50 = (PriceView) r25.Z().b(2131383491).f();
        SkuViewModel r51 = r25.f;
        if (r51 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L222:
        r50.setPrefixText(r51.getCurrentRegularPricePrefix());
        SkuViewModel r52 = r25.f;
        if (r52 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L225:
        r50.setExtraText(r52.getCurrentRegularPriceSuffix());
        SkuViewModel r53 = r25.f;
        if (r53 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L228:
        Boolean r54 = r53.getCurrentRegularPriceIsUnderline();
        if (r54 == null) goto L231;
        boolean r55 = r54.booleanValue();
    L232:
        r50.setShowDeleteLine(r55);
        int r56 = jg.b.a;
        SkuViewModel r57 = r25.f;
        if (r57 != null) goto L235;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L235:
        Long r58 = r57.getCurrentRegularPrice();
        if (r58 == null) goto L238;
        long r127 = r58.longValue();
    L239:
        r50.setPriceText(jg.b.b(r127));
        r50.setVisibility(0);
        SkuViewModel r59 = r25.f;
        if (r59 != null) goto L243;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L243:
        if (cg4.a.a(r59.getCurrentRegularPriceSupplement()) == false) goto L248;
        TextView r60 = (TextView) r25.Z().b(2131383492).f();
        SkuViewModel r61 = r25.f;
        if (r61 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L247:
        r60.setText(r61.getCurrentRegularPriceSupplement());
        r60.setVisibility(0);
    L250:
        LinearLayout r62 = (LinearLayout) r25.Z().b(2131378875).f();
        LinearLayout r63 = (LinearLayout) r25.Z().b(2131378876).f();
        RelativeLayout r64 = (RelativeLayout) r25.Z().b(2131384714).f();
        SkuViewModel r65 = r25.f;
        if (r65 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L253:
        Long r66 = r65.getCurrentPriceType();
        if (r66 != null) goto L257;
    L258:
        AppCompatTextView r67 = (PriceView) r25.Z().b(2131383493).f();
    L260:
        TextView r128 = (TextView) r25.Z().b(2131383494).f();
        if (r67.getVisibility() != 0) goto L272;
        SkuViewModel r129 = r25.f;
        if (r129 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L265:
        Long r68 = r129.getCurrentPriceType();
        if (r68 != null) goto L269;
    L270:
        r11 = 2131383493;
    L271:
        int r69 = r25.i0(r11);
    L274:
        if (r128.getVisibility() != 0) goto L276;
        int r70 = r25.i0(2131383494);
    L278:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L280;
    L283:
        int r130 = (((((r25.i0(2131384714) + r69) + vf4.a.b(16)) + vf4.a.b(24)) + vf4.a.b(52)) + vf4.a.b(8)) + vf4.a.b(8);
        int r71 = vf4.a.b(12);
    L285:
        if (((r130 + r71) + r70) <= UIUtils.getScreenWidth(r25.Y().c())) goto L302;
        if ((!Intrinsics.areEqual(r67.getParent(), r63)) == false) goto L316;
        r62.removeView(r67);
        r62.removeView(r128);
        r63.addView(r67, 0);
        r63.addView(r128, 1);
        ViewGroup.LayoutParams r72 = r67.getLayoutParams();
        if ((r72 instanceof ViewGroup.MarginLayoutParams) == true) goto L291;
        r72 = null;
    L291:
        ViewGroup.MarginLayoutParams r73 = (ViewGroup.MarginLayoutParams) r72;
        if (r73 == null) goto L294;
        r73.topMargin = vf4.a.b(4);
        r67.setLayoutParams(r73);
    L294:
        ViewGroup.LayoutParams r74 = r128.getLayoutParams();
        if ((r74 instanceof ViewGroup.MarginLayoutParams) == true) goto L297;
        ViewGroup.LayoutParams r131 = null;
    L298:
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        if (r132 == null) goto L316;
        r132.topMargin = vf4.a.b(4);
        r128.setLayoutParams(r132);
        goto L316
    L297:
        r131 = r74;
    L316:
        View r75 = r25.Z().b(2131386846).f();
        AccessibilityDelegateCompatImpl r76 = new AccessibilityDelegateCompatImpl(r75);
        if (ECSettingKeys.J0() == true) goto L319;
        Unit r0 = Unit.INSTANCE;
        r76.b = com.bytedance.android.ec.core.widget.d0.b((PriceView) r25.Z().b(2131383484).f()) + ((TextView) r25.Z().b(2131383493).f()).getText() + com.bytedance.android.ec.core.widget.d0.b((PriceView) r25.Z().b(2131383491).f());
    L319:
        ViewCompat.setAccessibilityDelegate(r75, r76);
        return;
    L302:
        if ((!Intrinsics.areEqual(r67.getParent(), r62)) == false) goto L316;
        r63.removeView(r67);
        r63.removeView(r128);
        r62.addView(r67, 1);
        r62.addView(r128, 2);
        ViewGroup.LayoutParams r77 = r67.getLayoutParams();
        if ((r77 instanceof ViewGroup.MarginLayoutParams) == true) goto L306;
        r77 = null;
    L306:
        ViewGroup.MarginLayoutParams r78 = (ViewGroup.MarginLayoutParams) r77;
        if (r78 == null) goto L309;
        r78.topMargin = vf4.a.b(0);
        r67.setLayoutParams(r78);
    L309:
        ViewGroup.LayoutParams r79 = r128.getLayoutParams();
        if ((r79 instanceof ViewGroup.MarginLayoutParams) == true) goto L312;
        ViewGroup.LayoutParams r133 = null;
    L313:
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        if (r134 == null) goto L316;
        r134.topMargin = vf4.a.b(0);
        r128.setLayoutParams(r134);
        goto L316
    L312:
        r133 = r79;
        goto L313
    L280:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L283;
        r130 = ((((r25.i0(2131384714) + r69) + vf4.a.b(12)) + vf4.a.b(56)) + vf4.a.b(8)) + vf4.a.b(16);
        r71 = vf4.a.b(12);
        goto L285
    L276:
        r70 = 0;
        goto L278
    L269:
        if (r68.longValue() == 2) goto L271;
    L272:
        r69 = 0;
        goto L274
    L257:
        if (r66.longValue() != 2) goto L258;
        r67 = (PriceView) r25.Z().b(2131383488).f();
        goto L260
    L248:
        r25.Z().b(2131383492).f().setVisibility(8);
        goto L250
    L238:
        r127 = 0;
        goto L239
    L231:
        r55 = false;
        goto L232
    L249:
        r25.Z().b(2131383491).f().setVisibility(8);
        r25.Z().b(2131383492).f().setVisibility(8);
        goto L250
    L216:
        r49 = false;
        goto L218
    L202:
        if (r47.longValue() != 1) goto L210;
        SkuViewModel r80 = r25.f;
        if (r80 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        if ((!Intrinsics.areEqual(r80.getCurrentSecondPriceIsReducePrice(), r126)) == false) goto L210;
        r31.C(HeaderOptimizePresenter$updatePriceNew$3$6.INSTANCE);
        goto L210
    L189:
        r31.setHideYang(false);
        r31.C(HeaderOptimizePresenter$updatePriceNew$3$4.INSTANCE);
        r31.setPadding(UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(3), UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(3));
        Drawable r81 = r31.getBackground();
        if ((r81 instanceof GradientDrawable) == true) goto L192;
        r81 = null;
    L192:
        GradientDrawable r82 = (GradientDrawable) r81;
        if (r82 == null) goto L195;
        r82.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(30));
        r31.setBackgroundDrawable(r82);
        goto L195
    L177:
        r25.Z().b(2131383494).f().setVisibility(8);
        goto L178
    L167:
        r124 = 0;
        goto L168
    L160:
        r36 = false;
        goto L161
    L117:
        if (r30.longValue() != 2) goto L148;
        ?? r83 = (PriceView) r25.Z().b(2131383488).f();
        SkuViewModel r135 = r25.f;
        if (r135 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L121:
        r83.setPrefixText(r135.getCurrentSecondPricePrefix());
        SkuViewModel r136 = r25.f;
        if (r136 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L124:
        r83.setExtraText(r136.getCurrentSecondPriceSuffix());
        SkuViewModel r137 = r25.f;
        if (r137 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L127:
        Boolean r138 = r137.getCurrentSecondPriceIsUnderline();
        if (r138 == null) goto L130;
        boolean r139 = r138.booleanValue();
    L131:
        r83.setShowDeleteLine(r139);
        int r140 = jg.b.a;
        SkuViewModel r141 = r25.f;
        if (r141 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L134:
        Long r142 = r141.getCurrentSecondPrice();
        if (r142 == null) goto L137;
        long r143 = r142.longValue();
    L138:
        r83.setPriceText(jg.b.b(r143));
        r83.setVisibility(0);
        SkuViewModel r84 = r25.f;
        if (r84 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        if (cg4.a.a(r84.getCurrentOriginPriceSupplement()) == false) goto L147;
        TextView r85 = (TextView) r25.Z().b(2131383489).f();
        SkuViewModel r86 = r25.f;
        if (r86 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L146:
        r85.setText(r86.getCurrentOriginPriceSupplement());
        r85.setVisibility(0);
        goto L210
    L147:
        r25.Z().b(2131383489).f().setVisibility(8);
        goto L210
    L137:
        r143 = 0;
        goto L138
    L130:
        r139 = false;
        goto L131
    L209:
        r25.Z().b(2131383493).f().setVisibility(8);
        r25.Z().b(2131383488).f().setVisibility(8);
        r25.Z().b(2131383494).f().setVisibility(8);
        r25.Z().b(2131383489).f().setVisibility(8);
        goto L210
    L107:
        r28 = false;
        goto L109
    L99:
        r25.Z().b(2131383485).f().setVisibility(8);
        goto L101
    L89:
        r122 = 0;
        goto L90
    L82:
        r118 = false;
        goto L83
    L100:
        r25.Z().b(2131383484).f().setVisibility(8);
        r25.Z().b(2131383485).f().setVisibility(8);
        goto L101
    L67:
        r22 = false;
        goto L69
    L58:
        r113 = 0;
        goto L59
    L51:
        r110 = 0;
        goto L52
    L26:
        if (r15.longValue() != 2) goto L45;
        r25.Z().b(2131383487).f().setVisibility(8);
        r25.Z().b(2131391451).f().setVisibility(8);
        r25.Z().b(2131383486).f().setVisibility(8);
        ?? r87 = (PriceView) r25.Z().b(2131383488).f();
        r87.setVisibility(0);
        int r144 = jg.b.a;
        SkuViewModel r145 = r25.f;
        if (r145 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        Long r146 = r145.getCurrentHotMinPrice();
        if (r146 == null) goto L33;
        long r147 = r146.longValue();
    L34:
        r87.setPriceText(jg.b.b(r147));
        SkuViewModel r148 = r25.f;
        if (r148 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        Long r149 = r148.getCurrentHotMaxPrice();
        if (r149 == null) goto L40;
        long r150 = r149.longValue();
    L41:
        r87.setMaxPriceText(jg.b.b(r150));
        SkuViewModel r151 = r25.f;
        if (r151 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        r87.setPrefixText(r151.getCurrentHotPricePrefix());
        goto L61
    L40:
        r150 = 0;
        goto L41
    L33:
        r147 = 0;
        goto L34
    L17:
        r13 = false;
    L60:
        r25.Z().b(2131383487).f().setVisibility(8);
        r25.Z().b(2131391451).f().setVisibility(8);
        r25.Z().b(2131383486).f().setVisibility(8);
        goto L61
    L8:
        r10 = false;
        goto L9
    }

    public final void b0(QModel r19) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r1 = Z().b(2131385283).f();
        AccessibilityDelegateCompatImpl r10 = new AccessibilityDelegateCompatImpl(r1);
        r10.b = "商品图片";
        ViewCompat.setAccessibilityDelegate(r1, r10);
        ImageExtensionsKt.D(Z().b(2131385283).f(), new com.bytedance.android.ec.core.imagex.r("ec_sku", "ec_sku_product_image"));
        Z().b(2131385283).f().setOnClickListener(new r0(this));
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        List r12 = r11.getSkuParams().getBenefitLabels();
        if (r12 == null) goto L27;
        if ((!r12.isEmpty()) == true) goto L11;
        r12 = null;
    L11:
        if (r12 == null) goto L27;
        SkuBenefitLabelGroupOptimizeLayout r13 = (SkuBenefitLabelGroupOptimizeLayout) Z().b(2131378864).f();
        r13.setVisibility(0);
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        Intrinsics.checkNotNullParameter(r12, "benefitLabelList");
        Intrinsics.checkNotNullParameter(r14, "viewModel");
        r13.c = r14;
        ((ArrayList) r13.a).clear();
        ((ArrayList) r13.b).clear();
        Iterator r15 = r12.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        PromotionBenefitLabel r16 = (PromotionBenefitLabel) r15.next();
        ((ArrayList) r13.a).add(r16);
        ((ArrayList) r13.b).add(r16);
        goto L17
    L19:
        r13.a();
        if (com.bytedance.android.ec.core.abtest.d.F() != 5) goto L25;
        Z().b(2131376610).f().setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(Z().b(2131368095).f(), null, null, new HeaderOptimizePresenter$initViews$$inlined$apply$lambda$1(this), 3);
        View r17 = Z().b(2131368095).f();
        int r18 = vf4.a.b(14);
        int r20 = vf4.a.b(14);
        Intrinsics.checkNotNullParameter(r17, "$this$expendTouch");
        r17.post(new com.bytedance.android.ec.common.impl.sku.utils.s(r17, r18, r20));
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        SkuViewModel.doSkuEventAction$default(r110, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "discount_info")}, null, null, null, 28, null);
        goto L27
    L25:
        Z().b(2131376610).f().setVisibility(8);
    L27:
        if (com.bytedance.android.ec.core.abtest.d.F() != 4) goto L29;
    L32:
        Z().b(2131391463).f().setVisibility(0);
        k0();
    L33:
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        r21.m1028getCurrentPrice().b(ECQuickUtilKt.a(Y()), new l0(this));
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r22.getCurrentAvatar().b(ECQuickUtilKt.a(Y()), new m0(this));
        SkuViewModel r23 = this.f;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        r23.getCheckedNames().b(ECQuickUtilKt.a(Y()), new n0(this));
        SkuViewModel r24 = this.f;
        if (r24 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        r24.getSkuInfo().b(ECQuickUtilKt.a(Y()), new o0(this));
        SkuViewModel r25 = this.f;
        if (r25 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        r25.getCurrentBenefitLabel().b(ECQuickUtilKt.a(Y()), new p0(this));
        SkuViewModel r26 = this.f;
        if (r26 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        r26.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new q0(this));
        return;
    L29:
        if (com.bytedance.android.ec.core.abtest.d.F() == 5) goto L32;
        Z().b(2131391463).f().setVisibility(8);
        goto L33
    }

    public final int i0(int r10) {
        View r11 = Z().b(r10).f();
        r11.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r11.getMeasuredWidth();
    }

    public final void j0(int r10) {
        PriceView r0 = (PriceView) Z().b(2131383484).f();
        r0.setPriceTextColor(r10);
        r0.setExtraTextColor(r10);
        r0.setPrefixTextColor(r10);
        AppCompatTextView r1 = (PriceView) Z().b(2131383493).f();
        Drawable r11 = r1.getBackground();
        if ((r11 instanceof GradientDrawable) == true) goto L5;
        r11 = null;
    L5:
        GradientDrawable r12 = (GradientDrawable) r11;
        if (r12 == null) goto L8;
        r12.setColor(r10);
        r1.setBackgroundDrawable(r12);
    L8:
        ((PriceView) Z().b(2131383487).f()).setPriceTextColor(r10);
        ((PriceView) Z().b(2131383486).f()).setPriceTextColor(r10);
        ((TextView) Z().b(2131391451).f()).setTextColor(r10);
    }

    public final void l0(int r10) {
        ((TextView) Z().b(2131383485).f()).setTextColor(r10);
        ((TextView) Z().b(2131383494).f()).setTextColor(r10);
        ((TextView) Z().b(2131383489).f()).setTextColor(r10);
    }
}
