package com.bytedance.android.abtest;

import com.bytedance.android.abtest.model.BuyNowDegradeConfig;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.shopping.anchorv3.detail.vo.AuthorizationDialogImageInfo;
import com.bytedance.dataplatform.config.SettingPanel;
import d63.c;
import d63.n;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001{B\t\b\u0002¢\u0006\u0004\bz\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0015\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0018\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u001b\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\rR\u001a\u0010\u001e\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\rR\u001a\u0010!\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\rR\u001c\u0010&\u001a\u0004\u0018\u00010\"8GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b#\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010'8GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b(\u0010)R\u001a\u0010.\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b,\u0010\u0004R\u001a\u00101\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b/\u0010\rR\u001a\u00104\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b2\u0010\rR\u001a\u00107\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0006\u001a\u0004\b5\u0010\rR\u001a\u0010:\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b8\u0010\rR\u001a\u0010?\u001a\u00020;8GX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b<\u0010=R\u001a\u0010B\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\b@\u0010\rR\u001a\u0010E\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0006\u001a\u0004\bC\u0010\rR\u001a\u0010H\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010\u0006\u001a\u0004\bF\u0010\rR\u001a\u0010K\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bI\u0010\rR\u001a\u0010N\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0006\u001a\u0004\bL\u0010\rR\u001c\u0010S\u001a\u0004\u0018\u00010O8GX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010\u0006\u001a\u0004\bP\u0010QR\u001a\u0010V\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010\u0006\u001a\u0004\bT\u0010\u0004R\u001a\u0010Y\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0006\u001a\u0004\bW\u0010\rR\u001a\u0010\\\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0006\u001a\u0004\bZ\u0010\rR\u001a\u0010_\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010\u0006\u001a\u0004\b]\u0010\u0004R\u001a\u0010b\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\u0006\u001a\u0004\b`\u0010\rR\u001a\u0010e\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010\u0006\u001a\u0004\bc\u0010\rR\u001a\u0010h\u001a\u00020;8GX\u0087\u0004¢\u0006\f\u0012\u0004\bg\u0010\u0006\u001a\u0004\bf\u0010=R\u001a\u0010k\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\bj\u0010\u0006\u001a\u0004\bi\u0010\rR\u001a\u0010p\u001a\u00020l8GX\u0087\u0004¢\u0006\f\u0012\u0004\bo\u0010\u0006\u001a\u0004\bm\u0010nR\u001a\u0010s\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\br\u0010\u0006\u001a\u0004\bq\u0010\u0004R\u001a\u0010v\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bu\u0010\u0006\u001a\u0004\bt\u0010\u0004R\u001a\u0010y\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bx\u0010\u0006\u001a\u0004\bw\u0010\u0004¨\u0006|"}, d2 = {"Lcom/bytedance/android/abtest/SettingKeys;", "", "", "getDETAIL_USE_ECOM_API_HOST", "()Z", "getDETAIL_USE_ECOM_API_HOST$annotations", "()V", "DETAIL_USE_ECOM_API_HOST", "getDETAIL_USE_AWEME_API_HOST", "getDETAIL_USE_AWEME_API_HOST$annotations", "DETAIL_USE_AWEME_API_HOST", "", "getLYNX_CART_COUPON_SCHEMA", "()Ljava/lang/String;", "getLYNX_CART_COUPON_SCHEMA$annotations", "LYNX_CART_COUPON_SCHEMA", "getLYNX_STORE_CATEGORY_SCHEMA", "getLYNX_STORE_CATEGORY_SCHEMA$annotations", "LYNX_STORE_CATEGORY_SCHEMA", "getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL", "getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL$annotations", "STORE_MOMENT_TAB_PREFETCH_LYNX_URL", "getSTORE_LYNX_FLOAT_LAYER_NAME", "getSTORE_LYNX_FLOAT_LAYER_NAME$annotations", "STORE_LYNX_FLOAT_LAYER_NAME", "getORDER_SCHEMA", "getORDER_SCHEMA$annotations", "ORDER_SCHEMA", "getPUBLIC_REPUTATION_SCHEMA", "getPUBLIC_REPUTATION_SCHEMA$annotations", "PUBLIC_REPUTATION_SCHEMA", "getSTORE_V2_PUBLICITY_TEXT", "getSTORE_V2_PUBLICITY_TEXT$annotations", "STORE_V2_PUBLICITY_TEXT", "Ld63/c;", "getPRICE_DESCRIPTION_CONTENT", "()Ld63/c;", "getPRICE_DESCRIPTION_CONTENT$annotations", "PRICE_DESCRIPTION_CONTENT", "Ld63/n;", "getINTERNAL_FEED_AUTHOR_TRAFFIC_PERCENT", "()Ld63/n;", "getINTERNAL_FEED_AUTHOR_TRAFFIC_PERCENT$annotations", "INTERNAL_FEED_AUTHOR_TRAFFIC_PERCENT", "getEC_LAZY_LOAD_FAVORITE_FEED", "getEC_LAZY_LOAD_FAVORITE_FEED$annotations", "EC_LAZY_LOAD_FAVORITE_FEED", "getLYNX_GROUP_RULE_SCHEMA", "getLYNX_GROUP_RULE_SCHEMA$annotations", "LYNX_GROUP_RULE_SCHEMA", "getIESEC_ORDER_COUPON_PANEL_SCHEMA", "getIESEC_ORDER_COUPON_PANEL_SCHEMA$annotations", "IESEC_ORDER_COUPON_PANEL_SCHEMA", "getIESEC_GIVENGOODS_PANEL_SCHEMA", "getIESEC_GIVENGOODS_PANEL_SCHEMA$annotations", "IESEC_GIVENGOODS_PANEL_SCHEMA", "getIESEC_ORDER_REDPACK_PANEL_SCHEMA", "getIESEC_ORDER_REDPACK_PANEL_SCHEMA$annotations", "IESEC_ORDER_REDPACK_PANEL_SCHEMA", "", "getSHOW_CHOOSE_PANEL", "()I", "getSHOW_CHOOSE_PANEL$annotations", "SHOW_CHOOSE_PANEL", "getEC_SEARCH_PAGE_URL", "getEC_SEARCH_PAGE_URL$annotations", "EC_SEARCH_PAGE_URL", "getLYNX_SHOP_FOLLOW", "getLYNX_SHOP_FOLLOW$annotations", "LYNX_SHOP_FOLLOW", "getLYNX_WINDOW_PRELOAD_CARD_URL", "getLYNX_WINDOW_PRELOAD_CARD_URL$annotations", "LYNX_WINDOW_PRELOAD_CARD_URL", "getEC_COMMERCE_INNER_FEED_JUMP_SEARCH_SCHEMA", "getEC_COMMERCE_INNER_FEED_JUMP_SEARCH_SCHEMA$annotations", "EC_COMMERCE_INNER_FEED_JUMP_SEARCH_SCHEMA", "getSHRINK_MEANINGLESS_COMMENT_EXPLAIN", "getSHRINK_MEANINGLESS_COMMENT_EXPLAIN$annotations", "SHRINK_MEANINGLESS_COMMENT_EXPLAIN", "Lcom/bytedance/android/shopping/anchorv3/detail/vo/AuthorizationDialogImageInfo;", "getSEARCH_SIMILAR_DIALOG_IMAGE", "()Lcom/bytedance/android/shopping/anchorv3/detail/vo/AuthorizationDialogImageInfo;", "getSEARCH_SIMILAR_DIALOG_IMAGE$annotations", "SEARCH_SIMILAR_DIALOG_IMAGE", "getENABLE_3D_BUTTON_CLICK", "getENABLE_3D_BUTTON_CLICK$annotations", "ENABLE_3D_BUTTON_CLICK", "getSELF_OPERATED_QUALIFICATION", "getSELF_OPERATED_QUALIFICATION$annotations", "SELF_OPERATED_QUALIFICATION", "getSHARE_DAILY_STORY_TITLE", "getSHARE_DAILY_STORY_TITLE$annotations", "SHARE_DAILY_STORY_TITLE", "getFALLBACK_TO_ANCHOR_V3", "getFALLBACK_TO_ANCHOR_V3$annotations", "FALLBACK_TO_ANCHOR_V3", "getAUCTION_RESULT_PANEL", "getAUCTION_RESULT_PANEL$annotations", "AUCTION_RESULT_PANEL", "getEC_COMMERCE_COMMENT_QUALITY_ICON_URL", "getEC_COMMERCE_COMMENT_QUALITY_ICON_URL$annotations", "EC_COMMERCE_COMMENT_QUALITY_ICON_URL", "getEC_COMMERCE_COMMENT_LOAD_MORE", "getEC_COMMERCE_COMMENT_LOAD_MORE$annotations", "EC_COMMERCE_COMMENT_LOAD_MORE", "getBUY_NOW_PAY_METHODS_CARD", "getBUY_NOW_PAY_METHODS_CARD$annotations", "BUY_NOW_PAY_METHODS_CARD", "Lcom/bytedance/android/abtest/model/BuyNowDegradeConfig;", "getECOM_VMSDK_ORDER_DEGRADE_CONFIG", "()Lcom/bytedance/android/abtest/model/BuyNowDegradeConfig;", "getECOM_VMSDK_ORDER_DEGRADE_CONFIG$annotations", "ECOM_VMSDK_ORDER_DEGRADE_CONFIG", "getECOM_ENABLE_VMSDK_ORDER_DEGRADE", "getECOM_ENABLE_VMSDK_ORDER_DEGRADE$annotations", "ECOM_ENABLE_VMSDK_ORDER_DEGRADE", "getECOM_ENABLE_BN_PERFORMANCE_MONITOR", "getECOM_ENABLE_BN_PERFORMANCE_MONITOR$annotations", "ECOM_ENABLE_BN_PERFORMANCE_MONITOR", "getBUYNOW_USE_NEW_DOMAIN", "getBUYNOW_USE_NEW_DOMAIN$annotations", "BUYNOW_USE_NEW_DOMAIN", "<init>", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@OptSetting(business = "shopping专用")
public final class SettingKeys {
    public static final SettingKeys INSTANCE = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    private SettingKeys() {
    }

    @JvmStatic
    public static /* synthetic */ void getAUCTION_RESULT_PANEL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBUYNOW_USE_NEW_DOMAIN$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBUY_NOW_PAY_METHODS_CARD$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDETAIL_USE_AWEME_API_HOST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDETAIL_USE_ECOM_API_HOST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getECOM_ENABLE_BN_PERFORMANCE_MONITOR$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getECOM_ENABLE_VMSDK_ORDER_DEGRADE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getECOM_VMSDK_ORDER_DEGRADE_CONFIG$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_COMMENT_LOAD_MORE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_COMMENT_QUALITY_ICON_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_INNER_FEED_JUMP_SEARCH_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LAZY_LOAD_FAVORITE_FEED$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_SEARCH_PAGE_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getENABLE_3D_BUTTON_CLICK$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getFALLBACK_TO_ANCHOR_V3$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIESEC_GIVENGOODS_PANEL_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIESEC_ORDER_COUPON_PANEL_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIESEC_ORDER_REDPACK_PANEL_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getINTERNAL_FEED_AUTHOR_TRAFFIC_PERCENT$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_CART_COUPON_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_GROUP_RULE_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_SHOP_FOLLOW$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_STORE_CATEGORY_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_WINDOW_PRELOAD_CARD_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getORDER_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPRICE_DESCRIPTION_CONTENT$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPUBLIC_REPUTATION_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSEARCH_SIMILAR_DIALOG_IMAGE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSELF_OPERATED_QUALIFICATION$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSHARE_DAILY_STORY_TITLE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSHOW_CHOOSE_PANEL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSHRINK_MEANINGLESS_COMMENT_EXPLAIN$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_LYNX_FLOAT_LAYER_NAME$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_V2_PUBLICITY_TEXT$annotations() {
    }

    static {
        INSTANCE = new SettingKeys();
    }

    @SettingPanel("竞拍成功弹窗")
    public static final String getAUCTION_RESULT_PANEL() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?type=popup&gravity=center&width_percent=100&height_percent=100&enable_full_screen=1&load_taro=0&top_level=1&url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_commerce_ecom_auction%2Fresult_panel%2Ftemplate.js";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_auction_result_schema", String.class, "sslocal://webcast_lynxview?type=popup&gravity=center&width_percent=100&height_percent=100&enable_full_screen=1&load_taro=0&top_level=1&url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_commerce_ecom_auction%2Fresult_panel%2Ftemplate.js", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("提单下单是否使用新的域名")
    public static final boolean getBUYNOW_USE_NEW_DOMAIN() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_buynow_use_new_domain", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("提单页支付面板")
    public static final String getBUY_NOW_PAY_METHODS_CARD() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_pay_card%2Fpay_card%2Ftemplate.js%3Fis_native%3Dtrue&should_full_screen=1&enable_immersion_keyboard_control=0&status_font_dark=1&hide_debug_label=0&thread_strategy=2&revision_ab=4&filter_oncall_entry=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_buy_now_pay_methods_card", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_pay_card%2Fpay_card%2Ftemplate.js%3Fis_native%3Dtrue&should_full_screen=1&enable_immersion_keyboard_control=0&status_font_dark=1&hide_debug_label=0&thread_strategy=2&revision_ab=4&filter_oncall_entry=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("挂车内流切换到新域名新路由")
    public static final boolean getDETAIL_USE_AWEME_API_HOST() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_use_domain_amemv", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详页切换到ECOM的HOST")
    public static final boolean getDETAIL_USE_ECOM_API_HOST() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_use_domain_ecombdapi", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("是否支持提单性能监控")
    public static final boolean getECOM_ENABLE_BN_PERFORMANCE_MONITOR() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecom_enable_BN_performance_monitor", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("提单页是否降级VmSdk实验开关")
    public static final boolean getECOM_ENABLE_VMSDK_ORDER_DEGRADE() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecom_enable_vmsdk_order_degrade", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("native提单页降级配置")
    public static final BuyNowDegradeConfig getECOM_VMSDK_ORDER_DEGRADE_CONFIG() {
        int r0 = p.a;
        Object r1 = new BuyNowDegradeConfig(null, 1, null);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecom_vmsdk_order_degrade_config", BuyNowDegradeConfig.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (BuyNowDegradeConfig) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商品评价页列表loadmore个数配置")
    public static final int getEC_COMMERCE_COMMENT_LOAD_MORE() {
        int r0 = p.a;
        Object r1 = 10;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_commerce_comment_load_more", Integer.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r12).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商品评价页评论保障icon地址")
    public static final String getEC_COMMERCE_COMMENT_QUALITY_ICON_URL() {
        int r0 = p.a;
        Object r1 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/fkuhyeh7uhyvhn/ic_basic_quality_outlined.png";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_commerce_comment_quality_icon_url", String.class, "https://lf3-static.bytednsdoc.com/obj/eden-cn/fkuhyeh7uhyvhn/ic_basic_quality_outlined.png", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("内流搜索跳转")
    public static final String getEC_COMMERCE_INNER_FEED_JUMP_SEARCH_SCHEMA() {
        int r0 = p.a;
        Object r1 = "aweme://search?search_style=commodity_center&enter_from=ecom_video_product_inner&previous_page=ecom_video_product_inner&from=ecom_video_product_inner&transitionType=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_commerce_inner_feed_jump_search_schema", String.class, "aweme://search?search_style=commodity_center&enter_from=ecom_video_product_inner&previous_page=ecom_video_product_inner&from=ecom_video_product_inner&transitionType=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详猜你喜欢延迟加载")
    public static final boolean getEC_LAZY_LOAD_FAVORITE_FEED() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("lazy_load_favorite_feed", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("搜索中间页面url")
    public static final String getEC_SEARCH_PAGE_URL() {
        int r0 = p.a;
        Object r1 = "aweme://search?search_style=commodity_center&enter_from=search_product_detail&previous_page=search_product_detail&from=search_product_detail&previousPage=search_product_detail&transitionType=1&trending_words_from=search_bar_outer";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecomterm_search_page_url", String.class, "aweme://search?search_style=commodity_center&enter_from=search_product_detail&previous_page=search_product_detail&from=search_product_detail&previousPage=search_product_detail&transitionType=1&trending_words_from=search_bar_outer", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("直播间3d商品展示")
    public static final boolean getENABLE_3D_BUTTON_CLICK() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_3d_button_back_detail", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("")
    public static final boolean getFALLBACK_TO_ANCHOR_V3() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_fallback_to_anchor_v3", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("提单页赠品二级面板")
    public static final String getIESEC_GIVENGOODS_PANEL_SCHEMA() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Fecommmerce_order_givengoods_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_givengoods_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Fecommmerce_order_givengoods_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("提单页优惠券二级面板")
    public static final String getIESEC_ORDER_COUPON_PANEL_SCHEMA() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommmerce_order_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_coupon_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommmerce_order_coupon_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("红包优惠券面板")
    public static final String getIESEC_ORDER_REDPACK_PANEL_SCHEMA() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_order_redpack_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&rate_height=420&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_order_redpack_panel_schema", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_order_redpack_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&rate_height=420&top_level=1&mask_alpha=0.5&use_real_screen_height=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("视频内流的创作者流量百分比")
    public static final n getINTERNAL_FEED_AUTHOR_TRAFFIC_PERCENT() {
        int r0 = p.a;
        Object r1 = new n();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("internal_feed_author_traffic_config", n.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (n) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详优惠券列表lynx url")
    public static final String getLYNX_CART_COUPON_SCHEMA() {
        int r0 = p.a;
        Object r1 = "aweme://lynxview/?channel=fe_lynx_commerce_cart&bundle=coupon/template.js";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecomterm_lynx_cart_coupon", String.class, "aweme://lynxview/?channel=fe_lynx_commerce_cart&bundle=coupon/template.js", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详拼团规则说明lynx scheme")
    public static final String getLYNX_GROUP_RULE_SCHEMA() {
        int r0 = p.a;
        Object r1 = "aweme://lynxview/?channel=fe_lynx_commerce_cart&bundle=group_buy_rule/template.js";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecomterm_lynx_cart_group_buy_rule", String.class, "aweme://lynxview/?channel=fe_lynx_commerce_cart&bundle=group_buy_rule/template.js", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("店铺关注跳转粉丝券url")
    public static final String getLYNX_SHOP_FOLLOW() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Ffe_lynx_ecommerce_store%2Fapp%2Fcoupon%2Ftemplate.js&type=popup&gravity=center&open_animate=0&enable_full_screen=1&height_percent=100&width_percent=100&show_dim=1&mask_alpha=0.5";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecom_store_coupon_guide_lynx_url", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Ffe_lynx_ecommerce_store%2Fapp%2Fcoupon%2Ftemplate.js&type=popup&gravity=center&open_animate=0&enable_full_screen=1&height_percent=100&width_percent=100&show_dim=1&mask_alpha=0.5", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("电商Lynx分类页")
    public static final String getLYNX_STORE_CATEGORY_SCHEMA() {
        int r0 = p.a;
        Object r1 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_shop/classification/template.js";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("lynx_classification_bundle_url", String.class, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_shop/classification/template.js", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("橱窗lynx卡bundle_url")
    public static final String getLYNX_WINDOW_PRELOAD_CARD_URL() {
        int r0 = p.a;
        Object r1 = "";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("window_preload_lynx_card", String.class, "", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("我的订单页面 url")
    public static final String getORDER_SCHEMA() {
        int r0 = p.a;
        Object r1 = "aweme://lynxview/?fallback_url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Forder_dashboard_new%2F&use_rifle=1&hide_nav_bar=1&loading_bgcolor=ffffff&status_font_dark=1&trans_status_bar=1&hide_debug_label=1&channel=fe_ecom_center&bundle=homepage%2Ftemplate.js&revision_ab=4&enter_from=enterFromPlaceholder&origin_type=originTypePlaceholder&enable_immersion_keyboard_control=0&disable_activity=0&filter_service_entry=0&light_theme=1&theme_bg_color=%23f3f3f4&enabled_font_scale=1";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecomterm_order_schema", String.class, "aweme://lynxview/?fallback_url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Forder_dashboard_new%2F&use_rifle=1&hide_nav_bar=1&loading_bgcolor=ffffff&status_font_dark=1&trans_status_bar=1&hide_debug_label=1&channel=fe_ecom_center&bundle=homepage%2Ftemplate.js&revision_ab=4&enter_from=enterFromPlaceholder&origin_type=originTypePlaceholder&enable_immersion_keyboard_control=0&disable_activity=0&filter_service_entry=0&light_theme=1&theme_bg_color=%23f3f3f4&enabled_font_scale=1", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详展示价格说明信息")
    public static final c getPRICE_DESCRIPTION_CONTENT() {
        int r0 = a.a;
        int r1 = w0.a;
        Object r10 = (c) w0.b("{\"values\":[{\"contents\":[\"划线价格\\n并非原价，仅供参考。划线价格可能是该商品的专柜价、吊牌价、官网零售价、厂商指导价或该商品曾经展示过的销售价等。\",\"非划线价格\\n指商品的实时销售价格，不因表述的差异改变性质。该商品可能适用优惠券或参与其他优惠活动等，最终成交价格以订单结算页价格为准。\",\"商品详情页以图片或文字形式标注的一口价、促销价、优惠价等价格可能是在使用优惠券、参与各类优惠活动和特殊时段等各类因素综合起来的价格，具体请以订单结算页面为准。\\n若商家单独对划线价格进行说明的，以商家的表述为准。\"],\"title\":\"价格说明\"}]}", c.class);
        if (r10 == null) goto L17;
        int r11 = p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        b r13 = b.b;     // Catch: Throwable -> L9
        Object r14 = jj4.a.a("iesec_product_price_description", c.class, r10, false);     // Catch: Throwable -> L9
        if (r14 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        c r15 = (c) r14;
        if (r15 == null) goto L17;
        return r15;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L14;
        r10 = r17;
    L14:
        r14 = r10;
    L17:
        int r18 = p.a;
        Object r19 = null;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L20
        b r21 = b.b;     // Catch: Throwable -> L20
        r19 = jj4.a.a("iesec_product_price_description", c.class, null, false);     // Catch: Throwable -> L20
    L26:
        return (c) r19;
    L20:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r23) == true) goto L26;
        r19 = r23;
        goto L26
    }

    @SettingPanel("卖货口碑页面 url")
    public static final String getPUBLIC_REPUTATION_SCHEMA() {
        int r0 = p.a;
        Object r1 = "aweme://webview/?url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Fpublic_reputation%3Fsec_author_id%3Dsec_author_id_placeholder%26dynamic%3D1%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff%26enter_from%3Denter_from_placeholder&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fmodule_name%3Dpage_public_reputation%26channel%3Dfe_lyon_public_reputation%26bundle%3Dindex.js%26dynamic%3D1%26sec_author_id%3Dsec_author_id_placeholder%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26enter_form%3Denter_from_placeholder%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ecomterm_public_reputation_schema", String.class, "aweme://webview/?url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Fpublic_reputation%3Fsec_author_id%3Dsec_author_id_placeholder%26dynamic%3D1%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff%26enter_from%3Denter_from_placeholder&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fmodule_name%3Dpage_public_reputation%26channel%3Dfe_lyon_public_reputation%26bundle%3Dindex.js%26dynamic%3D1%26sec_author_id%3Dsec_author_id_placeholder%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26enter_form%3Denter_from_placeholder%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("找相似授权弹窗图片")
    public static final AuthorizationDialogImageInfo getSEARCH_SIMILAR_DIALOG_IMAGE() {
        int r0 = p.a;
        Object r1 = new AuthorizationDialogImageInfo();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_search_similar_dialog_image", AuthorizationDialogImageInfo.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (AuthorizationDialogImageInfo) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详类自营资质信息弹窗")
    public static final String getSELF_OPERATED_QUALIFICATION() {
        int r0 = p.a;
        Object r1 = "sslocal://webcast_lynxview?url=https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/fe_reactlynx_ecommerce_images_show_panel/app/template.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1&mask_alpha=0.5";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("fe_reactlynx_ecommerce_images_show_panel", String.class, "sslocal://webcast_lynxview?url=https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/fe_reactlynx_ecommerce_images_show_panel/app/template.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&use_real_screen_height=1&mask_alpha=0.5", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("商详分享到日常编辑页图片title")
    public static final String getSHARE_DAILY_STORY_TITLE() {
        int r0 = p.a;
        Object r1 = "HEY~ 这个商品很棒!!!";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("iesec_share_to_story_title", String.class, "HEY~ 这个商品很棒!!!", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("控制商详是否展示“选择”入口+选择sku是否刷新商详Setting")
    public static final int getSHOW_CHOOSE_PANEL() {
        int r0 = p.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        b r12 = b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("ec_product_detail_choose_panel_ab", Integer.class, r10, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r10 = r14;
    L12:
        r1 = r10;
        goto L14
    }

    @SettingPanel("折叠商品评价解释")
    public static final String getSHRINK_MEANINGLESS_COMMENT_EXPLAIN() {
        int r0 = p.a;
        Object r1 = "{\n    \"why\":\"为什么评价会被折叠?\",\n    \"explain\":\"被折叠评价是抖音通过大数据筛选的，对消费者决策帮助意义不大的评价。\"\n}";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("shrink_meaningless_comment_explain", String.class, "{\n    \"why\":\"为什么评价会被折叠?\",\n    \"explain\":\"被折叠评价是抖音通过大数据筛选的，对消费者决策帮助意义不大的评价。\"\n}", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("会挡住店铺置顶按钮的浮层")
    public static final String getSTORE_LYNX_FLOAT_LAYER_NAME() {
        int r0 = p.a;
        Object r1 = "[]";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("store_lynx_float_layer_name", String.class, "[]", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("店铺动态预加载Lynx卡片列表")
    public static final String getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL() {
        int r0 = p.a;
        Object r1 = "";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("shop_moments_preload_lynx_card", String.class, "", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("橱窗商品Tab页法务文案")
    public static final String getSTORE_V2_PUBLICITY_TEXT() {
        int r0 = p.a;
        Object r1 = "本橱窗账号为 name_placeholder 绑定账号newline_placeholder橱窗内所有「自卖商品」均为该店铺商品";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        b r11 = b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("shopping_store_product_publicity", String.class, "本橱窗账号为 name_placeholder 绑定账号newline_placeholder橱窗内所有「自卖商品」均为该店铺商品", false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r12;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }
}
