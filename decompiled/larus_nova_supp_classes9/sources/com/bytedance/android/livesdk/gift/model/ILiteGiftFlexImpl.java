package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftLiteStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u001e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\br\u0010sR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\fR\u001b\u0010\u0018\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010#\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u001cR\u001b\u0010&\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007R\u001b\u0010)\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R\u001b\u0010,\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0011R\u001d\u00101\u001a\u0004\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0004\u0018\u0001028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u00105R!\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0003078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010:R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0003078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010:R\u001b\u0010A\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0005\u001a\u0004\bA\u0010BR\u001b\u0010E\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007R\u001b\u0010H\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010\fR!\u0010L\u001a\b\u0012\u0004\u0012\u00020I078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010:R\u001b\u0010O\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\u0007R\u001b\u0010R\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0005\u001a\u0004\bQ\u0010\u0007R\u001b\u0010U\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0005\u001a\u0004\bT\u0010\u0011R'\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030V8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0005\u001a\u0004\bX\u0010YR\u001b\u0010\\\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0005\u001a\u0004\b\\\u0010BR!\u0010_\u001a\b\u0012\u0004\u0012\u00020\u000e078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u0005\u001a\u0004\b^\u0010:R\u001b\u0010b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0005\u001a\u0004\ba\u0010\fR\u001b\u0010e\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0005\u001a\u0004\bd\u0010BR\u001b\u0010h\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0005\u001a\u0004\bg\u0010BR\u001b\u0010k\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0005\u001a\u0004\bj\u0010\u0011R\u001b\u0010n\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\u0005\u001a\u0004\bm\u0010BR\u001b\u0010q\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0005\u001a\u0004\bp\u0010\u0011¨\u0006t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ILiteGiftFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/g2;", BuildConfig.FLAVOR, "id$delegate", "Ljava/lang/Object;", "getId", "()J", "id", BuildConfig.FLAVOR, "type$delegate", "getType", "()I", "type", BuildConfig.FLAVOR, "name$delegate", "getName", "()Ljava/lang/String;", "name", "diamondCount$delegate", "getDiamondCount", "diamondCount", "bizType$delegate", "getBizType", "bizType", "Lcom/bytedance/android/livesdk/gift/model/IGiftImageFlexImpl;", "giftImage$delegate", "getGiftImage", "()Lcom/bytedance/android/livesdk/gift/model/IGiftImageFlexImpl;", "giftImage", "webpGiftImage$delegate", "getWebpGiftImage", "webpGiftImage", "leftLogoGiftImage$delegate", "getLeftLogoGiftImage", "leftLogoGiftImage", "primaryEffectId$delegate", "getPrimaryEffectId", "primaryEffectId", "duration$delegate", "getDuration", "duration", "describe$delegate", "getDescribe", "describe", "Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "giftMsgBoard$delegate", "getGiftMsgBoard", "()Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "giftMsgBoard", "Lcom/bytedance/android/livesdk/gift/model/GiftPreviewInfoFlexImpl;", "giftPreviewInfo$delegate", "getGiftPreviewInfo", "()Lcom/bytedance/android/livesdk/gift/model/GiftPreviewInfoFlexImpl;", "giftPreviewInfo", BuildConfig.FLAVOR, "assetIds$delegate", "getAssetIds", "()Ljava/util/List;", "assetIds", "optionalAssetIds$delegate", "getOptionalAssetIds", "optionalAssetIds", BuildConfig.FLAVOR, "isForFansClub$delegate", "isForFansClub", "()Z", "selectedDynamicEffect$delegate", "getSelectedDynamicEffect", "selectedDynamicEffect", "afterSendAction$delegate", "getAfterSendAction", "afterSendAction", "Lcom/bytedance/android/livesdk/gift/model/GiftGroupInfoFlexImpl;", "giftGroupList$delegate", "getGiftGroupList", "giftGroupList", "giftEndingTime$delegate", "getGiftEndingTime", "giftEndingTime", "reqExtraType$delegate", "getReqExtraType", "reqExtraType", "bannerScheme$delegate", "getBannerScheme", "bannerScheme", BuildConfig.FLAVOR, "specialEffects$delegate", "getSpecialEffects", "()Ljava/util/Map;", "specialEffects", "isDisplayedOnPanel$delegate", "isDisplayedOnPanel", "triggerWords$delegate", "getTriggerWords", "triggerWords", "giftSource$delegate", "getGiftSource", "giftSource", "combo$delegate", "getCombo", "combo", "forFirstRecharge$delegate", "getForFirstRecharge", "forFirstRecharge", "eventName$delegate", "getEventName", "eventName", "disableWishList$delegate", "getDisableWishList", "disableWishList", "sortExtra$delegate", "getSortExtra", "sortExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILiteGiftFlexImpl extends FlexModelBase<g2> implements g2, vh7.h {

    @SerializedName("after_send_action")
    protected int _$$afterSendAction;

    @SerializedName("asset_ids")
    protected List<Long> _$$assetIds;

    @SerializedName("banner_scheme_url")
    protected String _$$bannerScheme;

    @SerializedName("biz_type")
    protected int _$$bizType;

    @SerializedName("combo")
    protected boolean _$$combo;

    @SerializedName("describe")
    protected String _$$describe;

    @SerializedName("diamond_count")
    protected int _$$diamondCount;

    @SerializedName("disable_wish_list")
    protected boolean _$$disableWishList;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("event_name")
    protected String _$$eventName;

    @SerializedName("for_first_recharge")
    protected boolean _$$forFirstRecharge;

    @SerializedName("gift_offline_time")
    protected long _$$giftEndingTime;

    @SerializedName("group_info")
    protected List<GiftGroupInfoFlexImpl> _$$giftGroupList;

    @SerializedName("image")
    protected IGiftImageFlexImpl _$$giftImage;

    @SerializedName("msg_board")
    protected GiftMsgBoard _$$giftMsgBoard;

    @SerializedName("gift_preview_info")
    protected GiftPreviewInfoFlexImpl _$$giftPreviewInfo;

    @SerializedName("gift_source")
    protected int _$$giftSource;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("is_displayed_on_panel")
    protected boolean _$$isDisplayedOnPanel;

    @SerializedName("for_fansclub")
    protected boolean _$$isForFansClub;

    @SerializedName("gift_label_icon")
    protected IGiftImageFlexImpl _$$leftLogoGiftImage;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("optional_asset_ids")
    protected List<Long> _$$optionalAssetIds;

    @SerializedName("primary_effect_id")
    protected long _$$primaryEffectId;

    @SerializedName("req_extra_type")
    protected long _$$reqExtraType;

    @SerializedName("selected_dynamic_effect")
    protected long _$$selectedDynamicEffect;

    @SerializedName("sort_extra")
    protected String _$$sortExtra;

    @SerializedName("special_effects")
    protected Map<String, Long> _$$specialEffects;

    @SerializedName("trigger_words")
    protected List<String> _$$triggerWords;

    @SerializedName("type")
    protected int _$$type;

    @SerializedName("webp_image")
    protected IGiftImageFlexImpl _$$webpGiftImage;

    public ILiteGiftFlexImpl() {
        super(g2.class);
        this._$$name = BuildConfig.FLAVOR;
        this._$$describe = BuildConfig.FLAVOR;
        this._$$assetIds = $defaultValue_assetIds$();
        this._$$optionalAssetIds = $defaultValue_optionalAssetIds$();
        this._$$isForFansClub = false;
        this._$$giftGroupList = $defaultValue_giftGroupList$();
        this._$$bannerScheme = BuildConfig.FLAVOR;
        this._$$specialEffects = $defaultValue_specialEffects$();
        this._$$isDisplayedOnPanel = false;
        this._$$triggerWords = $defaultValue_triggerWords$();
        this._$$combo = false;
        this._$$forFirstRecharge = false;
        this._$$eventName = BuildConfig.FLAVOR;
        this._$$disableWishList = false;
        this._$$sortExtra = BuildConfig.FLAVOR;
    }

    public final List<Long> $defaultValue_assetIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<GiftGroupInfoFlexImpl> $defaultValue_giftGroupList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_optionalAssetIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<String, Long> $defaultValue_specialEffects$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<String> $defaultValue_triggerWords$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public /* bridge */ /* synthetic */ q1 getGiftImage() {
        return getGiftImage();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public /* bridge */ /* synthetic */ k0 getGiftPreviewInfo() {
        return getGiftPreviewInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public /* bridge */ /* synthetic */ q1 getLeftLogoGiftImage() {
        return getLeftLogoGiftImage();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public /* bridge */ /* synthetic */ q1 getWebpGiftImage() {
        return getWebpGiftImage();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final int getAfterSendAction() {
        return this._$$afterSendAction;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final List<Long> getAssetIds() {
        return this._$$assetIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final String getBannerScheme() {
        return this._$$bannerScheme;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final int getBizType() {
        return this._$$bizType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final boolean getCombo() {
        return this._$$combo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final String getDescribe() {
        return this._$$describe;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final int getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final boolean getDisableWishList() {
        return this._$$disableWishList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final String getEventName() {
        return this._$$eventName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final boolean getForFirstRecharge() {
        return this._$$forFirstRecharge;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getGiftEndingTime() {
        return this._$$giftEndingTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final List<GiftGroupInfoFlexImpl> getGiftGroupList() {
        return this._$$giftGroupList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final GiftMsgBoard getGiftMsgBoard() {
        return this._$$giftMsgBoard;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final int getGiftSource() {
        return this._$$giftSource;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final List<Long> getOptionalAssetIds() {
        return this._$$optionalAssetIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getPrimaryEffectId() {
        return this._$$primaryEffectId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getReqExtraType() {
        return this._$$reqExtraType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final long getSelectedDynamicEffect() {
        return this._$$selectedDynamicEffect;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final String getSortExtra() {
        return this._$$sortExtra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final Map<String, Long> getSpecialEffects() {
        return this._$$specialEffects;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final List<String> getTriggerWords() {
        return this._$$triggerWords;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final int getType() {
        return this._$$type;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final boolean isDisplayedOnPanel() {
        return this._$$isDisplayedOnPanel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final boolean isForFansClub() {
        return this._$$isForFansClub;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final IGiftImageFlexImpl getGiftImage() {
        return this._$$giftImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final GiftPreviewInfoFlexImpl getGiftPreviewInfo() {
        return this._$$giftPreviewInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final IGiftImageFlexImpl getLeftLogoGiftImage() {
        return this._$$leftLogoGiftImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g2
    public final IGiftImageFlexImpl getWebpGiftImage() {
        return this._$$webpGiftImage;
    }

    public ILiteGiftFlexImpl(am3.g r13) {
        super(g2.class);
        this._$$assetIds = new ArrayList();
        this._$$optionalAssetIds = new ArrayList();
        this._$$giftGroupList = new ArrayList();
        this._$$specialEffects = new HashMap();
        this._$$triggerWords = new ArrayList();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L57;
        am3.g.a r8 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            case 5: goto L52;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L48;
            case 10: goto L47;
            case 11: goto L7;
            case 12: goto L44;
            case 13: goto L43;
            case 14: goto L42;
            case 15: goto L41;
            case 16: goto L40;
            case 17: goto L39;
            case 18: goto L38;
            case 19: goto L37;
            case 20: goto L36;
            case 21: goto L35;
            case 22: goto L18;
            case 23: goto L17;
            case 24: goto L16;
            case 25: goto L15;
            case 26: goto L14;
            case 27: goto L13;
            case 28: goto L12;
            case 29: goto L7;
            case 30: goto L11;
            case 31: goto L10;
            case 32: goto L9;
            case 33: goto L8;
            default: goto L7;
        };
    L8:
        this._$$sortExtra = am3.h.c(r13);
        goto L3
    L9:
        this._$$bizType = r13.i();
        r3 = r3 | 8;
        goto L3
    L10:
        this._$$name = am3.h.c(r13);
        goto L3
    L11:
        this._$$diamondCount = r13.i();
        r3 = r3 | 4;
        goto L3
    L12:
        this._$$forFirstRecharge = am3.h.a(r13);
        r3 = r3 | 16384;
        goto L3
    L13:
        this._$$combo = am3.h.a(r13);
        r3 = r3 | 8192;
        goto L3
    L14:
        this._$$giftSource = r13.i();
        r3 = r3 | 4096;
        goto L3
    L15:
        this._$$eventName = am3.h.c(r13);
        goto L3
    L16:
        List r5 = this._$$triggerWords;
        Object r6 = am3.h.c(r13);
    L46:
        r5.add(r6);
        goto L3
    L17:
        this._$$isDisplayedOnPanel = am3.h.a(r13);
        r3 = r3 | 2048;
        goto L3
    L18:
        long r7 = r13.c();
        String r9 = null;
        Long r10 = null;
    L19:
        int r11 = r13.f();
        if (r11 == (-1)) goto L27;
        if (r11 != 1) goto L23;
        r9 = am3.h.c(r13);
        goto L19
    L23:
        if (r11 != 2) goto L24;
        r10 = Long.valueOf(r13.j());
        goto L19
    L24:
        am3.h.e(r13);
        goto L19
    L27:
        r13.d(r7);
        Map<String, Long> r14 = this._$$specialEffects;
        if (r9 == null) goto L34;
        if (r10 == null) goto L32;
        r14.put(r9, r10);
        goto L3
    L32:
        throw new IllegalStateException("Value must not be null");
    L34:
        throw new IllegalStateException("Key must not be null");
    L35:
        this._$$bannerScheme = am3.h.c(r13);
        goto L3
    L36:
        this._$$reqExtraType = r13.j();
        r3 = r3 | 1024;
        goto L3
    L37:
        this._$$giftEndingTime = r13.j();
        r3 = r3 | 512;
        goto L3
    L38:
        this._$$disableWishList = am3.h.a(r13);
        r3 = r3 | 32768;
        goto L3
    L39:
        r5 = this._$$giftGroupList;
        r6 = new GiftGroupInfoFlexImpl(r13);
        goto L46
    L40:
        this._$$afterSendAction = r13.i();
        r3 = r3 | 256;
        goto L3
    L41:
        this._$$selectedDynamicEffect = r13.j();
        r3 = r3 | 128;
        goto L3
    L42:
        this._$$isForFansClub = am3.h.a(r13);
        r3 = r3 | 64;
        goto L3
    L43:
        r5 = this._$$optionalAssetIds;
    L45:
        r6 = Long.valueOf(r13.j());
        goto L46
    L44:
        r5 = this._$$assetIds;
        goto L45
    L47:
        this._$$giftPreviewInfo = new GiftPreviewInfoFlexImpl(r13);
        goto L3
    L48:
        this._$$giftMsgBoard = new GiftMsgBoard(r13);
        goto L3
    L49:
        this._$$describe = am3.h.c(r13);
        goto L3
    L50:
        this._$$duration = r13.j();
        r3 = r3 | 32;
        goto L3
    L51:
        this._$$primaryEffectId = r13.j();
        r3 = r3 | 16;
        goto L3
    L52:
        this._$$leftLogoGiftImage = new IGiftImageFlexImpl(r13);
        goto L3
    L53:
        this._$$webpGiftImage = new IGiftImageFlexImpl(r13);
        goto L3
    L54:
        this._$$giftImage = new IGiftImageFlexImpl(r13);
        goto L3
    L55:
        this._$$type = r13.i();
        r3 = r3 | 2;
        goto L3
    L56:
        this._$$id = r13.j();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r8, r13);
        goto L3
    L57:
        r13.d(r1);
        setThreadSafe(true);
        if (this._$$name != null) goto L61;
        this._$$name = BuildConfig.FLAVOR;
    L61:
        if (this._$$describe != null) goto L64;
        this._$$describe = BuildConfig.FLAVOR;
    L64:
        if (this._$$assetIds.isEmpty() == false) goto L67;
        this._$$assetIds = $defaultValue_assetIds$();
    L67:
        if (this._$$optionalAssetIds.isEmpty() == false) goto L70;
        this._$$optionalAssetIds = $defaultValue_optionalAssetIds$();
    L70:
        if ((r3 & 64) != 0) goto L73;
        this._$$isForFansClub = false;
    L73:
        if (this._$$giftGroupList.isEmpty() == false) goto L76;
        this._$$giftGroupList = $defaultValue_giftGroupList$();
    L76:
        if (this._$$bannerScheme != null) goto L79;
        this._$$bannerScheme = BuildConfig.FLAVOR;
    L79:
        if (this._$$specialEffects != null) goto L82;
        this._$$specialEffects = $defaultValue_specialEffects$();
    L82:
        if ((r3 & 2048) != 0) goto L85;
        this._$$isDisplayedOnPanel = false;
    L85:
        if (this._$$triggerWords.isEmpty() == false) goto L88;
        this._$$triggerWords = $defaultValue_triggerWords$();
    L88:
        if ((r3 & 8192) != 0) goto L91;
        this._$$combo = false;
    L91:
        if ((r3 & 16384) != 0) goto L94;
        this._$$forFirstRecharge = false;
    L94:
        if (this._$$eventName != null) goto L97;
        this._$$eventName = BuildConfig.FLAVOR;
    L97:
        if ((r3 & 32768) != 0) goto L100;
        this._$$disableWishList = false;
    L100:
        if (this._$$sortExtra != null) goto L177;
        this._$$sortExtra = BuildConfig.FLAVOR;
        return;
    }
}
