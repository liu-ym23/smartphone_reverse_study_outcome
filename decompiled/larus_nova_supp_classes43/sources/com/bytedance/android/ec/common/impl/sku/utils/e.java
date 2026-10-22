package com.bytedance.android.ec.common.impl.sku.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        switch(r10.hashCode()) {
            case -1341549256: goto L60;
            case -1263773160: goto L42;
            case -547242443: goto L24;
            case 611778703: goto L6;
            default: goto L77;
        };
    L77:
        return r10;
    L6:
        if (r10.equals("click_add_to_cart") == false) goto L77;
        if (r11 != null) goto L10;
    L12:
        if (r11 != null) goto L15;
    L17:
        if (r11 != null) goto L20;
        return "click_add_to_cart";
    L20:
        if (r11.intValue() != 1) goto L79;
        return "vs_livesdk_click_add_to_cart";
    L79:
        return "click_add_to_cart";
    L15:
        if (r11.intValue() != 3) goto L17;
    L16:
        return "vs_video_click_add_to_cart";
    L10:
        if (r11.intValue() != 2) goto L12;
    L24:
        if (r10.equals("confirm_product_params") == false) goto L77;
        if (r11 != null) goto L28;
    L30:
        if (r11 != null) goto L33;
    L35:
        if (r11 != null) goto L38;
        return "confirm_product_params";
    L38:
        if (r11.intValue() != 1) goto L82;
        return "vs_livesdk_confirm_product_params";
    L82:
        return "confirm_product_params";
    L33:
        if (r11.intValue() != 3) goto L35;
    L34:
        return "vs_video_confirm_product_params";
    L28:
        if (r11.intValue() != 2) goto L30;
    L42:
        if (r10.equals("show_product_params_detail") == false) goto L77;
        if (r11 != null) goto L46;
    L48:
        if (r11 != null) goto L51;
    L53:
        if (r11 != null) goto L56;
        return "show_product_params_detail";
    L56:
        if (r11.intValue() != 1) goto L85;
        return "vs_livesdk_show_product_params_detail";
    L85:
        return "show_product_params_detail";
    L51:
        if (r11.intValue() != 3) goto L53;
    L52:
        return "vs_video_show_product_params_detail";
    L46:
        if (r11.intValue() != 2) goto L48;
    L60:
        if (r10.equals("click_product_detail") == false) goto L77;
        if (r11 != null) goto L64;
    L66:
        if (r11 != null) goto L69;
    L71:
        if (r11 != null) goto L74;
        return "click_product_detail";
    L74:
        if (r11.intValue() != 1) goto L88;
        return "vs_livesdk_click_product_detail";
    L88:
        return "click_product_detail";
    L69:
        if (r11.intValue() != 3) goto L71;
    L70:
        return "vs_video_click_product_detail";
    L64:
        if (r11.intValue() != 2) goto L66;
        goto L66
    }
}
