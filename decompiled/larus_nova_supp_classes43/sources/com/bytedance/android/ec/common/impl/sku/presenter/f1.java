package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountDescText;
import com.bytedance.android.ec.common.impl.sku.model.SkuHighlightItem;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f1 extends QFragmentPresenter {
    public SkuViewModel f;
    public boolean g;
    public boolean h;
    public String i;

    public f1(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.i = "";
    }

    public static final String d0(f1 r23) {
        SkuViewModel r10 = r23.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r11 = r10.getSkuParams().getDetailUrl();
        if (r11 == null) goto L212;
        SkuViewModel r12 = r23.f;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        Map r13 = r12.getSkuParams().getLiveEventParams();
        String r17 = "";
        if (r13 == null) goto L71;
        Map r14 = MapsKt.toMutableMap(r13);
        if (r14 == null) goto L71;
        SkuViewModel r15 = r23.f;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Map r16 = r15.getSkuParams().getEventParams();
        Object r19 = "1";
        if (r16 == null) goto L21;
        String r18 = (String) r16.get("screen_type");
        if (r18 == null) goto L21;
    L22:
        r14.put("screen_type", r18);
        SkuViewModel r20 = r23.f;
        if (r20 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        Map r21 = r20.getSkuParams().getEventParams();
        if (r21 == null) goto L28;
        String r22 = (String) r21.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
    L29:
        if (r22 != null) goto L31;
        r22 = "";
    L31:
        r14.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r22);
        SkuViewModel r24 = r23.f;
        if (r24 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        if (r24.isInDepositPresale() == false) goto L37;
        Object r25 = r19;
    L38:
        r14.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r25);
        SkuViewModel r26 = r23.f;
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
        r14.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r28);
        SkuViewModel r29 = r23.f;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        Map r30 = r29.getSkuParams().getEventParams();
        if (r30 == null) goto L54;
        String r31 = (String) r30.get("is_explaining");
        if (r31 == null) goto L54;
    L55:
        r14.put("is_explaining", r31);
        SkuViewModel r32 = r23.f;
        if (r32 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        Map r33 = r32.getSkuParams().getEventParams();
        if (r33 == null) goto L61;
        String r34 = (String) r33.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L62:
        if (r34 != null) goto L64;
        r34 = "";
    L64:
        r14.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r34);
        SkuViewModel r35 = r23.f;
        if (r35 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        String r36 = r35.getSkuParams().getTransmissibleJson();
        if (r36 != null) goto L70;
        r36 = "";
    L70:
        r14.put("transmissible_json", r36);
    L72:
        String r37 = com.bytedance.android.ec.common.impl.sku.utils.d.c(r11, "v3_events_additions", r14);
        String r38 = UriProtector.getQueryParameter(UriProtector.parse(r37), "meta_params");
        if (r38 != null) goto L75;
    L164:
        String r210 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
    L165:
        SkuViewModel r0 = r23.f;
        if (r0 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L168:
        String r1 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r37, "disable_live_window", String.valueOf(r0.getSkuParams().isFromPlayback()));
        Lazy r39 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L171;
        r1 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r1, "request_page", ECAIConstants.SCENE_ECOM_PRODUCT);
    L171:
        SkuViewModel r40 = r23.f;
        if (r40 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L174:
        Map r41 = r40.getSkuParams().getEventParams();
        if (r41 == null) goto L177;
        String r42 = (String) r41.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L178:
        String r43 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r1, com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r42);
        SkuViewModel r44 = r23.f;
        if (r44 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        Map r45 = r44.getSkuParams().getEventParams();
        if (r45 == null) goto L184;
        String r46 = (String) r45.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
    L185:
        String r47 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r43, "label_name_from_live", r46);
        SkuViewModel r48 = r23.f;
        if (r48 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L188:
        Map r49 = r48.getSkuParams().getEventParams();
        String r50 = r210;
        if (r49 == null) goto L191;
        String r51 = (String) r49.get(r50);
    L192:
        String r52 = com.bytedance.android.ec.common.impl.sku.utils.d.d(com.bytedance.android.ec.common.impl.sku.utils.d.d(r47, r50, r51), "promotion_source", String.valueOf(SourceType.XIAO_DIAN.getType()));
        SkuViewModel r53 = r23.f;
        if (r53 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L195:
        r53.setLastBehaviorBeforeDismiss("click");
        if (jg.h.a.getActivity(r23.a0()) == null) goto L198;
        r17 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c6709.d2425", Boolean.FALSE).withView(r23.a0()).build());
    L198:
        String r54 = r17;
        SkuViewModel r55 = r23.f;
        if (r55 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L201:
        Pair[] r110 = new Pair[2];
        SkuViewModel r56 = r23.f;
        if (r56 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L204:
        SkuInfoVO r57 = (SkuInfoVO) r56.getSkuInfo().a();
        if (r57 == null) goto L207;
        Long r111 = r57.getDiscountPrice();
    L208:
        if (r111 == null) goto L210;
        Object r112 = r19;
    L211:
        r110[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r112);
        r110[1] = TuplesKt.to("btm_id", r54);
        SkuViewModel.doSkuEventAction$default(r55, "click_product_detail", r110, null, null, null, 28, null);
        return com.bytedance.android.ec.core.btm.c.c(r52, r23.a0(), "a1.b5267.c6709.d2425", new Pair[0]);
    L210:
        r112 = "0";
        goto L211
    L207:
        r111 = null;
        goto L208
    L191:
        r51 = null;
        goto L192
    L184:
        r46 = null;
        goto L185
    L177:
        r42 = null;
        goto L178
    L75:
        if (r38.length() <= 0) goto L77;
        boolean r211 = true;
    L78:
        if (r211 == true) goto L81;
        r38 = null;
    L81:
        if (r38 == null) goto L164;
        JSONObject r113 = new JSONObject(r38);     // Catch: JSONException -> L161
        String r58 = r113.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: JSONException -> L161
        if (r58.length() <= 0) goto L85;
        boolean r212 = true;
    L86:
        if (r212 == true) goto L89;
        r58 = null;
    L89:
        if (r58 == null) goto L143;
        r210 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        JSONObject r114 = new JSONObject(r58);     // Catch: JSONException -> L159
        r114.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");     // Catch: JSONException -> L159
        SkuViewModel r59 = r23.f;     // Catch: JSONException -> L159
        if (r59 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L95:
        if (r59.isInDepositPresale() == false) goto L97;
        Object r60 = r19;
    L98:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r60);     // Catch: JSONException -> L159
        SkuViewModel r61 = r23.f;     // Catch: JSONException -> L159
        if (r61 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L101:
        SkuInfoVO r62 = (SkuInfoVO) r61.getSkuInfo().a();     // Catch: JSONException -> L159
        if (r62 != null) goto L104;
    L106:
        int r63 = 0;
    L107:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_IS_UNDER_STOCK, r63);     // Catch: JSONException -> L159
        SkuViewModel r64 = r23.f;     // Catch: JSONException -> L159
        if (r64 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L110:
        Map r65 = r64.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r65 == null) goto L115;
        String r66 = (String) r65.get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);     // Catch: JSONException -> L159
        if (r66 == null) goto L115;
    L116:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r66);     // Catch: JSONException -> L159
        SkuViewModel r67 = r23.f;     // Catch: JSONException -> L159
        if (r67 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L119:
        Map r68 = r67.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r68 == null) goto L122;
        String r69 = (String) r68.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);     // Catch: JSONException -> L159
    L123:
        if (r69 != null) goto L125;
        r69 = "";
    L125:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r69);     // Catch: JSONException -> L159
        SkuViewModel r70 = r23.f;     // Catch: JSONException -> L159
        if (r70 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L128:
        Map r71 = r70.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r71 == null) goto L132;
        String r72 = (String) r71.get("is_explaining");     // Catch: JSONException -> L159
        if (r72 == null) goto L132;
    L133:
        r114.put("is_explaining", r72);     // Catch: JSONException -> L159
        SkuViewModel r73 = r23.f;     // Catch: JSONException -> L159
        if (r73 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L136:
        Map r74 = r73.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r74 == null) goto L139;
        String r75 = (String) r74.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);     // Catch: JSONException -> L159
    L140:
        if (r75 != null) goto L142;
        r75 = "";
    L142:
        r114.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r75);     // Catch: JSONException -> L159
        r113.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r114.toString());     // Catch: JSONException -> L159
    L144:
        r37 = com.bytedance.android.ec.common.impl.sku.utils.d.b(r37, "meta_params", r113.toString());     // Catch: JSONException -> L159
        SkuViewModel r76 = r23.f;     // Catch: JSONException -> L159
        if (r76 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L147:
        String r77 = r76.getSkuParams().getSkuLogExtra();     // Catch: JSONException -> L159
        if (r77 == null) goto L165;
        if (r77.length() <= 0) goto L152;
        boolean r78 = true;
    L153:
        if (r78 == true) goto L156;
        r77 = null;
    L156:
        if (r77 == null) goto L165;
        JSONObject r79 = new JSONObject(r77);     // Catch: JSONException -> L159
        r37 = com.bytedance.android.ec.common.impl.sku.utils.d.a(r37, new Pair[]{new Pair(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG, r79.optString(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG, r79.optString(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG, r79.optString(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG, r79.optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG))});     // Catch: JSONException -> L159
        goto L165
    L152:
        r78 = false;
        goto L153
    L139:
        r75 = null;
    L132:
        r72 = "0";
        goto L133
    L122:
        r69 = null;
    L115:
        r66 = "0";
        goto L116
    L104:
        if (r62.isUnderStock() != true) goto L106;
        r63 = 1;
        goto L107
    L97:
        r60 = "0";
    L159:
        e = e;
    L163:
        ECExceptionMonitor.e(e);
        Unit r80 = Unit.INSTANCE;
        goto L165
    L143:
        r210 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        goto L144
    L85:
        r212 = false;
    L161:
        e = e;
        r210 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        goto L163
    L77:
        r211 = false;
        goto L78
    L61:
        r34 = null;
    L54:
        r31 = "0";
        goto L55
    L44:
        r28 = null;
        goto L45
    L37:
        r25 = "0";
        goto L38
    L28:
        r22 = null;
    L21:
        r18 = "0";
    L71:
        r19 = "1";
        r14 = null;
        goto L72
    L212:
        return null;
    }

    public static final /* synthetic */ SkuViewModel e0(f1 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    /* JADX WARN: Type inference failed for: r1v52, types: [android.widget.TextView, com.bytedance.android.ec.core.widget.PriceView] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.TextView, com.bytedance.android.ec.core.widget.PriceView] */
    public static final void i0(f1 r18) {
        SkuViewModel r1 = r18.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r10 = (SkuInfoVO) r1.getSkuInfo().a();
        if (r10 == null) goto L191;
        SkuViewModel r11 = r18.f;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Long r12 = (Long) r11.m1028getCurrentPrice().a();
        if (r12 == null) goto L14;
        long r13 = r12.longValue();
    L15:
        SkuViewModel r14 = r18.f;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        long r15 = r14.getCurrentOriginPrice();
        SkuViewModel r16 = r18.f;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        long r17 = r16.getCurrentDiscountPrice();
        SkuViewModel r19 = r18.f;
        if (r19 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        String r20 = r19.getCurrentDiscountPriceText();
        String r110 = "";
        if (r20 != null) goto L27;
        r20 = "";
    L27:
        SkuViewModel r111 = r18.f;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        String r112 = r111.getCurrentCampainPriceHeader();
        SkuViewModel r113 = r18.f;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        Integer r114 = r113.getCurrentCampainPriceHeaderStyle();
        String r115 = r10.getPriceHeader();
        if (r13 <= 0) goto L37;
        r115 = r112;
    L37:
        if (r114 != null) goto L40;
    L41:
        Integer r21 = r10.getPriceHeaderStyle();
        if (r21 != null) goto L45;
    L46:
        int r22 = 2131383490;
        ((PriceView) r18.Z().b(2131383490).f()).setPrefixText(r115);
    L48:
        ((PriceView) r18.Z().b(r22).f()).C(HeaderPresenter$updatePrice$1.INSTANCE);
        TextView r23 = (TextView) r18.Z().b(2131386856).f();
        r23.setVisibility(8);
        if (r114 != null) goto L51;
        int r24 = 1;
    L53:
        Integer r116 = r10.getPriceHeaderStyle();
        if (r116 != null) goto L57;
    L68:
        int r25 = 0;
    L77:
        CharSequence r117 = null;
        if (r13 <= 0) goto L111;
        r18.m0(r13, null, r25);
        SkuViewModel r26 = r18.f;
        if (r26 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L83:
        if (r26.isInDepositPresale() == false) goto L85;
    L92:
        ((PriceView) r18.Z().b(2131383488).f()).setVisibility(8);
    L94:
        if (1 <= r17) goto L97;
    L105:
        boolean r27 = true;
    L106:
        boolean r118 = false;
    L107:
        if (r118 == false) goto L109;
        r18.k0(r17, r20, r27);
    L159:
        RelativeLayout r28 = (RelativeLayout) r18.Z().b(2131384714).f();
        LinearLayout r29 = (LinearLayout) r18.Z().b(2131378871).f();
        LinearLayout r30 = (LinearLayout) r18.Z().b(2131378874).f();
        LinearLayout r31 = (LinearLayout) r18.Z().b(2131378877).f();
        if (r18.Z().b(2131377481).f().getVisibility() != 0) goto L162;
        int r32 = r18.j0(2131377481);
    L164:
        if (((r18.j0(2131384714) + r32) + vf4.a.b(Float.valueOf(166.0f))) <= UIUtils.getScreenWidth(r18.Y().c())) goto L177;
        if ((!Intrinsics.areEqual(r28.getParent(), r29)) == false) goto L183;
        r30.removeView(r28);
        r29.addView(r28, 1);
        ViewGroup.LayoutParams r33 = r28.getLayoutParams();
        if (r33 == null) goto L175;
        ((LinearLayout.LayoutParams) r33).setMargins(0, 0, 0, 0);
        if (r31.getVisibility() != 0) goto L172;
        int r119 = r18.j0(2131378877) + vf4.a.b(Float.valueOf(10.0f));
    L173:
        ((PriceView) r18.Z().b(2131383490).f()).setMaxWidth(r29.getMeasuredWidth() - r119);
        goto L183
    L172:
        r119 = 0;
        goto L173
    L175:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L183:
        View r34 = r18.Z().b(2131386846).f();
        AccessibilityDelegateCompatImpl r35 = new AccessibilityDelegateCompatImpl(r34);
        if (ECSettingKeys.J0() == true) goto L189;
        StringBuilder r36 = new StringBuilder();
        r36.append(com.bytedance.android.ec.core.widget.d0.b((PriceView) r18.Z().b(2131383490).f()));
        r36.append(((TextView) r18.Z().b(2131391448).f()).getText());
        r36.append(com.bytedance.android.ec.core.widget.d0.b((PriceView) r18.Z().b(2131391447).f()));
        View r0 = r18.Z().b(2131391470).b;
        if ((r0 instanceof TextView) == false) goto L188;
        r117 = ((TextView) r0).getText();
    L188:
        r36.append(r117);
        Unit r37 = Unit.INSTANCE;
        r35.b = r36.toString();
    L189:
        ViewCompat.setAccessibilityDelegate(r34, r35);
        return;
    L177:
        if ((!Intrinsics.areEqual(r28.getParent(), r30)) == false) goto L183;
        r29.removeView(r28);
        r30.addView(r28, 0);
        ViewGroup.LayoutParams r38 = r28.getLayoutParams();
        if (r38 == null) goto L182;
        ((LinearLayout.LayoutParams) r38).setMargins(0, 0, vf4.a.b(Float.valueOf(6.0f)), 0);
        ((PriceView) r18.Z().b(2131383490).f()).setMaxWidth(0.0f);
        goto L183
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L162:
        r32 = 0;
        goto L164
    L109:
        r18.Z().b(2131377481).f().setVisibility(8);
        goto L159
    L97:
        if (r13 <= r17) goto L105;
        if (r20.length() <= 0) goto L101;
        boolean r39 = true;
    L102:
        r27 = true;
        if (r39 != true) goto L106;
        r118 = true;
        goto L107
    L101:
        r39 = false;
        goto L102
    L85:
        if (r20.length() != 0) goto L87;
        boolean r40 = true;
    L88:
        if (r40 == false) goto L92;
        if (r15 <= 0) goto L92;
        ?? r41 = (PriceView) r18.Z().b(2131383488).f();
        r41.setPriceText(jg.b.b(r15));
        r41.setVisibility(0);
        goto L94
    L87:
        r40 = false;
        goto L88
    L111:
        if (r10.getMaxPrice() > 0) goto L113;
    L115:
        r18.m0(r10.getMinPrice(), null, 0);
    L116:
        Long r42 = r10.getDiscountPrice();
        if (r42 == null) goto L119;
        long r43 = r42.longValue();
    L120:
        long r44 = r10.getMinPrice();
        String r45 = r10.getDiscountPriceHeader();
        if (1 <= r43) goto L124;
    L133:
        int r46 = 1;
    L134:
        boolean r47 = false;
    L136:
        if (r10.getShowPriceStyle() == r46) goto L140;
        if (r47 == true) goto L140;
        r18.Z().b(2131377481).f().setVisibility(8);
    L147:
        SkuViewModel r48 = r18.f;
        if (r48 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        if (r48.isInDepositPresale() == true) goto L158;
        if (r47 == true) goto L158;
        if (r10.getShowPriceStyle() == 1) goto L158;
        if (r10.getMarketPrice() <= 0) goto L158;
        ?? r49 = (PriceView) r18.Z().b(2131383488).f();
        r49.setVisibility(0);
        int r50 = jg.b.a;
        r49.setPriceText(jg.b.b(r10.getMarketPrice()));
    L158:
        ((PriceView) r18.Z().b(2131383488).f()).setVisibility(8);
    L140:
        SkuViewModel r51 = r18.f;
        if (r51 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L143:
        r51.setCurrentDiscountPrice(r43);
        SkuViewModel r52 = r18.f;
        if (r52 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L146:
        r52.setCurrentDiscountPriceText(r10.getDiscountPriceHeader());
        r18.k0(r43, r10.getDiscountPriceHeader(), false);
        goto L147
    L124:
        if (r44 <= r43) goto L133;
        if (r45 == null) goto L133;
        if (r45.length() <= 0) goto L129;
        boolean r53 = true;
    L130:
        r46 = 1;
        if (r53 != true) goto L134;
        r47 = true;
        goto L136
    L129:
        r53 = false;
        goto L130
    L119:
        r43 = 0;
        goto L120
    L113:
        if (r10.getMaxPrice() <= r10.getMinPrice()) goto L115;
        r18.m0(r10.getMinPrice(), Long.valueOf(r10.getMaxPrice()), r10.getShowPriceStyle());
        goto L116
    L57:
        if (r116.intValue() != r24) goto L68;
        SkuViewModel r54 = r18.f;
        if (r54 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        if (r54.isInSecKill() == true) goto L68;
    L63:
        if (r114 != null) goto L66;
    L69:
        if (r114 != null) goto L72;
    L76:
        r25 = 0;
        r23.setText(r10.getPriceHeader());
        r23.setVisibility(0);
        goto L77
    L72:
        if (r114.intValue() != 1) goto L76;
        if (r112 == null) goto L75;
        r110 = r112;
    L75:
        r23.setText(r110);
        r25 = 0;
        r23.setVisibility(0);
        goto L77
    L66:
        if (r114.intValue() != 0) goto L69;
        r23.setVisibility(8);
        goto L68
    L51:
        r24 = 1;
        if (r114.intValue() == 1) goto L63;
    L45:
        if (r21.intValue() != 1) goto L46;
    L47:
        r22 = 2131383490;
        goto L48
    L40:
        if (r114.intValue() == 1) goto L47;
    L14:
        r13 = 0;
        goto L15
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        if (ECAppInfoService.e.f() == false) goto L10;
        ViewGroup.LayoutParams r11 = Z().b(2131385282).f().getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r11 = null;
    L7:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r12 == null) goto L10;
        r12.bottomToBottom = -1;
    L10:
        View r13 = Z().b(2131385283).f();
        AccessibilityDelegateCompatImpl r1 = new AccessibilityDelegateCompatImpl(r13);
        r1.b = "商品图片";
        ViewCompat.setAccessibilityDelegate(r13, r1);
        ImageExtensionsKt.D(Z().b(2131385283).f(), new com.bytedance.android.ec.core.imagex.r("ec_sku", "ec_sku_product_image"));
        Z().b(2131385283).f().setOnClickListener(new e1(this));
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r14.m1028getCurrentPrice().b(ECQuickUtilKt.a(Y()), new t0(this));
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        r15.getCurrentDouInstallmentItem().b(ECQuickUtilKt.a(Y()), new u0(this));
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r16.getValidInstallmentInfo().b(ECQuickUtilKt.a(Y()), new v0(this));
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r17.getCurrentStock().b(ECQuickUtilKt.a(Y()), new w0(this));
        SkuViewModel r18 = this.f;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        r18.getCurrentAvatar().b(ECQuickUtilKt.a(Y()), new x0(this));
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r19.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new y0(this));
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        r20.getCheckedNames().b(ECQuickUtilKt.a(Y()), new z0(this));
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r21.getOnItemChange().b(Y().e(), new a1(this));
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r22.getSkuInfo().b(ECQuickUtilKt.a(Y()), new d1(this));
    }

    public final int j0(int r10) {
        View r11 = Z().b(r10).f();
        r11.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r11.getMeasuredWidth();
    }

    public final void l0(String r14) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        ViewGroup.LayoutParams r10 = null;
        if (r1 == null) goto L10;
        Map<String, SkuItemInfoVO> r11 = r1.getSkuList();
        if (r11 == null) goto L10;
        SkuItemInfoVO r15 = r11.get(r14);
    L11:
        if (r15 == null) goto L13;
        Boolean r12 = Boolean.valueOf(r15.isSecKill());
        Boolean r13 = Boolean.valueOf(r15.isDepositPresale());
        ECUrlModel r16 = r15.getActivityIcon();
        Integer r17 = r15.getCampaignSubType();
        String r18 = r15.getAtmosphereHeader();
        long r19 = r15.getDepositPrice();
    L29:
        View r110 = Z().b(2131378877).f();
        Boolean r20 = Boolean.TRUE;
        if (Intrinsics.areEqual(r12, r20) == false) goto L33;
        if (r16 != null) goto L33;
        int r111 = 0;
    L34:
        r110.setVisibility(r111);
        if (Intrinsics.areEqual(r12, r20) == false) goto L43;
        if (r17 != null) goto L38;
    L39:
        Z().b(2131385658).g(0);
        Query r112 = Z().b(2131385659);
        View r21 = r112.b;
        if ((r21 instanceof TextView) == false) goto L42;
        ((TextView) r21).setText(2131914029);
    L42:
        r112.g(0);
    L52:
        SimpleDraweeView r113 = Z().b(2131386868).f();
        if (r16 == null) goto L62;
        r113.setVisibility(0);
        ViewGroup.LayoutParams r22 = r113.getLayoutParams();
        if ((r22 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r10 = r22;
    L58:
        LinearLayout.LayoutParams r23 = (LinearLayout.LayoutParams) r10;
        if (r23 == null) goto L61;
        r23.width = vf4.a.b(Integer.valueOf(r16.getWidth()));
        r23.height = vf4.a.b(Integer.valueOf(r16.getHeight()));
        r113.setLayoutParams(r23);
    L61:
        com.bytedance.android.ec.core.utils.y.a(r113, r16);
    L64:
        if (Intrinsics.areEqual(r13, r20) == false) goto L69;
        TextView r114 = (TextView) Z().b(2131391446).f();
        r114.setVisibility(0);
        String r24 = jg.b.b(r19);
        if (r24 != null) goto L68;
        r24 = "";
    L68:
        r114.setText(ag4.a.a(2131913949, CollectionsKt.listOf(r24)));
        return;
    L69:
        ((TextView) Z().b(2131391446).f()).setVisibility(8);
        return;
    L62:
        r113.setVisibility(8);
        goto L64
    L38:
        if (r17.intValue() == 0) goto L39;
    L43:
        Z().b(2131385658).g(8);
        if (r18 != null) goto L46;
    L51:
        Z().b(2131378877).g(8);
        Z().b(2131385659).g(8);
        goto L52
    L46:
        if ((!StringsKt.isBlank(r18)) == true) goto L49;
        r18 = null;
    L49:
        if (r18 == null) goto L51;
        Z().b(2131378877).g(0);
        Query r115 = Z().b(2131385659);
        r115.e(r18);
        r115.g(0);
    L33:
        r111 = 8;
        goto L34
    L13:
        SkuViewModel r116 = this.f;
        if (r116 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        SkuInfoVO r117 = (SkuInfoVO) r116.getSkuInfo().a();
        r12 = Boolean.valueOf(this.g);
        r13 = Boolean.valueOf(this.h);
        if (r117 == null) goto L19;
        r16 = r117.getActivityIcon();
    L20:
        if (r117 == null) goto L22;
        r17 = r117.getCampaignSubType();
    L23:
        if (r117 == null) goto L25;
        r18 = r117.getAtmosphereHeader();
    L26:
        if (r117 == null) goto L28;
        r19 = r117.getDepositPrice();
        goto L29
    L28:
        r19 = 0;
        goto L29
    L25:
        r18 = null;
        goto L26
    L22:
        r17 = null;
        goto L23
    L19:
        r16 = null;
    L10:
        r15 = null;
        goto L11
    }

    public static final SpannableStringBuilder h0(f1 r10, SkuDiscountDescText r11) {
        r10.getClass();
        if (r11 == null) goto L17;
        if (r11.getText() == null) goto L17;
        SpannableStringBuilder r12 = new SpannableStringBuilder(r11.getText());
        List<SkuHighlightItem> r13 = r11.getHighlightItems();
        if (r13 == null) goto L25;
        Iterator<T> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L26;
        SkuHighlightItem r0 = (SkuHighlightItem) r14.next();
        Integer r1 = r0.getStartIndex();
        Integer r15 = r0.getEndIndex();
        if (r1 == null) goto L11;
        if (r15 == null) goto L11;
        int r16 = r15.intValue();
        int r17 = r1.intValue();
        r12.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), r17, r16, 17);
        goto L11
    L26:
        return r12;
    L25:
        return r12;
    L17:
        return new SpannableStringBuilder("");
    }

    public final void k0(long r10, String r12, boolean r13) {
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r11 = false;
        Z().b(2131377481).f().setVisibility(0);
        ((PriceView) Z().b(2131383488).f()).setVisibility(8);
        ((TextView) Z().b(2131391448).f()).setText(r12);
        String r14 = jg.b.b(r10);
        if (r13 == false) goto L11;
    L15:
        String r15 = "";
    L16:
        PriceView r16 = (PriceView) Z().b(2131391447).f();
        r16.setPriceText(r14);
        r16.setExtraText(r15);
        if (r12 != null) goto L19;
    L20:
        r11 = true;
    L21:
        if (r11 == true) goto L23;
        View r17 = Z().b(2131377481).f();
        r17.setContentDescription(r12 + r14 + th.a.g(Y().c(), 2131913847) + r15);
        r17.setFocusable(true);
        ((TextView) Z().b(2131391448).f()).setImportantForAccessibility(2);
        ((PriceView) Z().b(2131391447).f()).setImportantForAccessibility(2);
        return;
    L23:
        Z().b(2131377481).f().setContentDescription(null);
        return;
    L19:
        if (StringsKt.isBlank(r12) == false) goto L21;
    L11:
        if (r1.getMaxPrice() == r1.getMinPrice()) goto L15;
        if (r1.getShowPriceStyle() == 1) goto L15;
        r15 = th.a.g(Y().c(), 2131914083);
        goto L16
    }

    public final void m0(long r10, Long r11, int r12) {
        PriceView r0 = (PriceView) Z().b(2131383490).f();
        if (r11 != null) goto L5;
    L8:
        r0.setExtraText(null);
    L9:
        r0.setPriceText(jg.b.b(r10));
        if (r12 != 1) goto L15;
        if (r11 == null) goto L15;
        if (r11.longValue() <= r10) goto L15;
        r0.setMaxPriceText(jg.b.b(r11.longValue()));
        return;
    L15:
        r0.setMaxPriceText(null);
        return;
    L5:
        if (r11.longValue() == r10) goto L8;
        if (r12 != 0) goto L8;
        r0.setExtraText(th.a.g(Y().c(), 2131914083));
        goto L9
    }
}
