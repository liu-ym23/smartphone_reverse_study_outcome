package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0014\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\fR\"\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\fR\"\u0010\u001a\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\fR\"\u0010\u001d\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001b\u0010\fR\"\u0010 \u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001e\u0010\fR\"\u0010#\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b!\u0010\fR\"\u0010&\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0007\u001a\u0004\b$\u0010\fR\u001a\u0010)\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0007\u001a\u0004\b'\u0010\u0005R>\u00102\u001a&\u0012\b\u0012\u00060+j\u0002`,\u0012\u0004\u0012\u00020-0*j\u0012\u0012\b\u0012\u00060+j\u0002`,\u0012\u0004\u0012\u00020-`.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0007\u001a\u0004\b/\u00100R\"\u00105\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0007\u001a\u0004\b3\u0010\fR\"\u00108\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b6\u0010\fR\"\u0010;\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b9\u0010\fR\"\u0010>\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u0010\fR\"\u0010A\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b?\u0010\fR\"\u0010D\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bB\u0010\fR\"\u0010G\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bE\u0010\fR\"\u0010J\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0007\u001a\u0004\bH\u0010\fR\"\u0010M\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0007\u001a\u0004\bK\u0010\fR\"\u0010P\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0007\u001a\u0004\bN\u0010\f¨\u0006Q"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/t;", "Lvh7/c;", "", "", "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getShortTouchWaiting", "()Lpy/k;", "getShortTouchWaiting$annotations", "shortTouchWaiting", "getShortTouchOutNoMore", "getShortTouchOutNoMore$annotations", "shortTouchOutNoMore", "getShortTouchOutWithMore", "getShortTouchOutWithMore$annotations", "shortTouchOutWithMore", "getEnterSkin", "getEnterSkin$annotations", "enterSkin", "getUpperCover", "getUpperCover$annotations", "upperCover", "getLowerCover", "getLowerCover$annotations", "lowerCover", "getBackgroud", "getBackgroud$annotations", "backgroud", "getBorder", "getBorder$annotations", "border", "getBlessIcon", "getBlessIcon$annotations", "blessIcon", "getBlessWord", "getBlessWord$annotations", "blessWord", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/android/live/profit/dress/config/v;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getSurpriseGifts", "()Ljava/util/Map;", "getSurpriseGifts$annotations", "surpriseGifts", "getLeftBannerBackground", "getLeftBannerBackground$annotations", "leftBannerBackground", "getRightBannerBackground", "getRightBannerBackground$annotations", "rightBannerBackground", "getCounterImg", "getCounterImg$annotations", "counterImg", "getCardImg", "getCardImg$annotations", "cardImg", "getLeftGiftRedEnvelope", "getLeftGiftRedEnvelope$annotations", "leftGiftRedEnvelope", "getRightGiftRedEnvelope", "getRightGiftRedEnvelope$annotations", "rightGiftRedEnvelope", "getLeftDiamondRedEnvelope", "getLeftDiamondRedEnvelope$annotations", "leftDiamondRedEnvelope", "getRightDiamondRedEnvelope", "getRightDiamondRedEnvelope$annotations", "rightDiamondRedEnvelope", "getSaleTitle", "getSaleTitle$annotations", "saleTitle", "getDressCenterIcon", "getDressCenterIcon$annotations", "dressCenterIcon", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t extends vh7.c<t> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "backgroud")
    py.k getBackgroud();

    @FieldName(name = "bless_icon")
    py.k getBlessIcon();

    @FieldName(name = "bless_word")
    String getBlessWord();

    @FieldName(name = "border")
    py.k getBorder();

    @FieldName(name = "card_img")
    py.k getCardImg();

    @FieldName(name = "counter_img")
    py.k getCounterImg();

    @FieldName(name = "dress_center_icon")
    py.k getDressCenterIcon();

    @FieldName(name = "enter_skin")
    py.k getEnterSkin();

    @FieldName(name = "left_banner_background")
    py.k getLeftBannerBackground();

    @FieldName(name = "left_diamond_red_envelope")
    py.k getLeftDiamondRedEnvelope();

    @FieldName(name = "left_gift_red_envelope")
    py.k getLeftGiftRedEnvelope();

    @FieldName(name = "lower_cover")
    py.k getLowerCover();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "right_banner_background")
    py.k getRightBannerBackground();

    @FieldName(name = "right_diamond_red_envelope")
    py.k getRightDiamondRedEnvelope();

    @FieldName(name = "right_gift_red_envelope")
    py.k getRightGiftRedEnvelope();

    @FieldName(name = "sale_title")
    py.k getSaleTitle();

    @FieldName(name = "short_touch_out_no_more")
    py.k getShortTouchOutNoMore();

    @FieldName(name = "short_touch_out_with_more")
    py.k getShortTouchOutWithMore();

    @FieldName(name = "short_touch_waiting")
    py.k getShortTouchWaiting();

    @FieldName(name = "surprise_gifts")
    Map<Long, v> getSurpriseGifts();

    @FieldName(name = "upper_cover")
    py.k getUpperCover();
}
