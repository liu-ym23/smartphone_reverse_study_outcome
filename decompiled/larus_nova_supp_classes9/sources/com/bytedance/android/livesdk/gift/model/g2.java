package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u001c\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0017\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u001aR\u001a\u0010%\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b#\u0010\u0004R\u001a\u0010(\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0006\u001a\u0004\b&\u0010\u0004R\u001a\u0010+\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b)\u0010\u000fR\u001c\u00100\u001a\u0004\u0018\u00010,8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b-\u0010.R\u001c\u00105\u001a\u0004\u0018\u0001018&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0006\u001a\u0004\b2\u00103R \u0010:\u001a\b\u0012\u0004\u0012\u00020\u0002068&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b7\u00108R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u0002068&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0006\u001a\u0004\b;\u00108R\u001a\u0010?\u001a\u00020>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0006\u001a\u0004\bB\u0010\u0004R\u001a\u0010G\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0006\u001a\u0004\bE\u0010\nR \u0010K\u001a\b\u0012\u0004\u0012\u00020H068&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bI\u00108R\u001a\u0010N\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0006\u001a\u0004\bL\u0010\u0004R\u001a\u0010Q\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0006\u001a\u0004\bO\u0010\u0004R\u001a\u0010T\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\bS\u0010\u0006\u001a\u0004\bR\u0010\u000fR&\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020U8&X§\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0006\u001a\u0004\bV\u0010WR\u001a\u0010Z\u001a\u00020>8&X§\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0006\u001a\u0004\bZ\u0010@R \u0010^\u001a\b\u0012\u0004\u0012\u00020\r068&X§\u0004¢\u0006\f\u0012\u0004\b]\u0010\u0006\u001a\u0004\b\\\u00108R\u001a\u0010a\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b`\u0010\u0006\u001a\u0004\b_\u0010\nR\u001a\u0010d\u001a\u00020>8&X§\u0004¢\u0006\f\u0012\u0004\bc\u0010\u0006\u001a\u0004\bb\u0010@R\u001a\u0010g\u001a\u00020>8&X§\u0004¢\u0006\f\u0012\u0004\bf\u0010\u0006\u001a\u0004\be\u0010@R\u001a\u0010j\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\bi\u0010\u0006\u001a\u0004\bh\u0010\u000fR\u001a\u0010m\u001a\u00020>8&X§\u0004¢\u0006\f\u0012\u0004\bl\u0010\u0006\u001a\u0004\bk\u0010@R\u001a\u0010p\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\bo\u0010\u0006\u001a\u0004\bn\u0010\u000f¨\u0006q"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/g2;", "Lvh7/c;", BuildConfig.FLAVOR, "getId", "()J", "getId$annotations", "()V", "id", BuildConfig.FLAVOR, "getType", "()I", "getType$annotations", "type", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "getName$annotations", "name", "getDiamondCount", "getDiamondCount$annotations", "diamondCount", "getBizType", "getBizType$annotations", "bizType", "Lcom/bytedance/android/livesdk/gift/model/q1;", "getGiftImage", "()Lcom/bytedance/android/livesdk/gift/model/q1;", "getGiftImage$annotations", "giftImage", "getWebpGiftImage", "getWebpGiftImage$annotations", "webpGiftImage", "getLeftLogoGiftImage", "getLeftLogoGiftImage$annotations", "leftLogoGiftImage", "getPrimaryEffectId", "getPrimaryEffectId$annotations", "primaryEffectId", "getDuration", "getDuration$annotations", "duration", "getDescribe", "getDescribe$annotations", "describe", "Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "getGiftMsgBoard", "()Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "getGiftMsgBoard$annotations", "giftMsgBoard", "Lcom/bytedance/android/livesdk/gift/model/k0;", "getGiftPreviewInfo", "()Lcom/bytedance/android/livesdk/gift/model/k0;", "getGiftPreviewInfo$annotations", "giftPreviewInfo", BuildConfig.FLAVOR, "getAssetIds", "()Ljava/util/List;", "getAssetIds$annotations", "assetIds", "getOptionalAssetIds", "getOptionalAssetIds$annotations", "optionalAssetIds", BuildConfig.FLAVOR, "isForFansClub", "()Z", "isForFansClub$annotations", "getSelectedDynamicEffect", "getSelectedDynamicEffect$annotations", "selectedDynamicEffect", "getAfterSendAction", "getAfterSendAction$annotations", "afterSendAction", "Lcom/bytedance/android/livesdk/gift/model/h0;", "getGiftGroupList", "getGiftGroupList$annotations", "giftGroupList", "getGiftEndingTime", "getGiftEndingTime$annotations", "giftEndingTime", "getReqExtraType", "getReqExtraType$annotations", "reqExtraType", "getBannerScheme", "getBannerScheme$annotations", "bannerScheme", BuildConfig.FLAVOR, "getSpecialEffects", "()Ljava/util/Map;", "getSpecialEffects$annotations", "specialEffects", "isDisplayedOnPanel", "isDisplayedOnPanel$annotations", "getTriggerWords", "getTriggerWords$annotations", "triggerWords", "getGiftSource", "getGiftSource$annotations", "giftSource", "getCombo", "getCombo$annotations", "combo", "getForFirstRecharge", "getForFirstRecharge$annotations", "forFirstRecharge", "getEventName", "getEventName$annotations", "eventName", "getDisableWishList", "getDisableWishList$annotations", "disableWishList", "getSortExtra", "getSortExtra$annotations", "sortExtra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g2 extends vh7.c<g2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "after_send_action")
    int getAfterSendAction();

    @FieldName(name = "asset_ids")
    List<Long> getAssetIds();

    @FieldName(name = "banner_scheme_url")
    String getBannerScheme();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "combo")
    boolean getCombo();

    @FieldName(name = "describe")
    String getDescribe();

    @FieldName(name = "diamond_count")
    int getDiamondCount();

    @FieldName(name = "disable_wish_list")
    boolean getDisableWishList();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "event_name")
    String getEventName();

    @FieldName(name = "for_first_recharge")
    boolean getForFirstRecharge();

    @FieldName(name = "gift_offline_time")
    long getGiftEndingTime();

    @FieldName(name = "group_info")
    List<h0> getGiftGroupList();

    @FieldName(name = "image")
    q1 getGiftImage();

    @FieldName(name = "msg_board")
    GiftMsgBoard getGiftMsgBoard();

    @FieldName(name = "gift_preview_info")
    k0 getGiftPreviewInfo();

    @FieldName(name = "gift_source")
    int getGiftSource();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "gift_label_icon")
    q1 getLeftLogoGiftImage();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "optional_asset_ids")
    List<Long> getOptionalAssetIds();

    @FieldName(name = "primary_effect_id")
    long getPrimaryEffectId();

    @FieldName(name = "req_extra_type")
    long getReqExtraType();

    @FieldName(name = "selected_dynamic_effect")
    long getSelectedDynamicEffect();

    @FieldName(name = "sort_extra")
    String getSortExtra();

    @FieldName(name = "special_effects")
    Map<String, Long> getSpecialEffects();

    @FieldName(name = "trigger_words")
    List<String> getTriggerWords();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "webp_image")
    q1 getWebpGiftImage();

    @FieldName(name = "is_displayed_on_panel")
    boolean isDisplayedOnPanel();

    @FieldName(name = "for_fansclub")
    boolean isForFansClub();
}
