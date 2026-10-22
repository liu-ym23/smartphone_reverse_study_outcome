package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bJ\u0010KR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0011R\u001d\u0010%\u001a\u0004\u0018\u00010!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0011R\u001b\u00102\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0004\u0018\u0001038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0004\u0018\u0001088VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0005\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0005\u001a\u0004\bC\u0010@R\u001d\u0010I\u001a\u0004\u0018\u00010E8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftExtraInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/g0;", BuildConfig.FLAVOR, "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "giftId", "Lcom/bytedance/android/livesdk/gift/model/SubscribeGiftPackInfoFlexImpl;", "subscribeGiftPackInfo$delegate", "getSubscribeGiftPackInfo", "()Lcom/bytedance/android/livesdk/gift/model/SubscribeGiftPackInfoFlexImpl;", "subscribeGiftPackInfo", BuildConfig.FLAVOR, "bannerGiftInfo$delegate", "getBannerGiftInfo", "()Ljava/lang/String;", "bannerGiftInfo", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/IGiftBuffInfoFlexImpl;", "giftBuffInfos$delegate", "getGiftBuffInfos", "()Ljava/util/List;", "giftBuffInfos", "Lcom/bytedance/android/livesdk/gift/model/DIYGiftToolbarInfoFlexImpl;", "diyGiftToolbarInfo$delegate", "getDiyGiftToolbarInfo", "()Lcom/bytedance/android/livesdk/gift/model/DIYGiftToolbarInfoFlexImpl;", "diyGiftToolbarInfo", "giftHonorLevelUrl$delegate", "getGiftHonorLevelUrl", "giftHonorLevelUrl", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfoFlexImpl;", "comboHintInfo$delegate", "getComboHintInfo", "()Lcom/bytedance/android/livesdk/gift/model/ComboHintInfoFlexImpl;", "comboHintInfo", "Lcom/bytedance/android/livesdk/gift/model/SeriesGiftsInfoFlexImpl;", "seriesGift$delegate", "getSeriesGift", "()Lcom/bytedance/android/livesdk/gift/model/SeriesGiftsInfoFlexImpl;", "seriesGift", "metaInfo$delegate", "getMetaInfo", "metaInfo", BuildConfig.FLAVOR, "showComboTray$delegate", "getShowComboTray", "()Z", "showComboTray", "Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfoFlexImpl;", "giftExposureAnimInfo$delegate", "getGiftExposureAnimInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfoFlexImpl;", "giftExposureAnimInfo", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfoFlexImpl;", "giftMarketingInfo$delegate", "getGiftMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfoFlexImpl;", "giftMarketingInfo", BuildConfig.FLAVOR, "giftSelectedStyle$delegate", "getGiftSelectedStyle", "()I", "giftSelectedStyle", "giftPlayNowStrategy$delegate", "getGiftPlayNowStrategy", "giftPlayNowStrategy", "Lcom/bytedance/android/livesdk/gift/model/IGiftBottomLabelFlexImpl;", "bottomLabel$delegate", "getBottomLabel", "()Lcom/bytedance/android/livesdk/gift/model/IGiftBottomLabelFlexImpl;", "bottomLabel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftExtraInfoFlexImpl extends FlexModelBase<g0> implements g0, vh7.h {

    @SerializedName("banner_gift_info")
    protected String _$$bannerGiftInfo;

    @SerializedName("bottom_label")
    protected IGiftBottomLabelFlexImpl _$$bottomLabel;

    @SerializedName("combo_hint_info")
    protected ComboHintInfoFlexImpl _$$comboHintInfo;

    @SerializedName("diy_gift_toolbar_info")
    protected DIYGiftToolbarInfoFlexImpl _$$diyGiftToolbarInfo;

    @SerializedName("gift_buff_infos")
    protected List<IGiftBuffInfoFlexImpl> _$$giftBuffInfos;

    @SerializedName("icon_autoplay_asset_info")
    protected IGiftExposureAnimInfoFlexImpl _$$giftExposureAnimInfo;

    @SerializedName("gift_panel_top_desc_scheme_url")
    protected String _$$giftHonorLevelUrl;

    @SerializedName("gift_id")
    protected long _$$giftId;

    @SerializedName("gift_marketing_info")
    protected IGiftMarketingInfoFlexImpl _$$giftMarketingInfo;

    @SerializedName("asset_display_strategy")
    protected int _$$giftPlayNowStrategy;

    @SerializedName("gift_selected_style")
    protected int _$$giftSelectedStyle;

    @SerializedName("meta_info")
    protected String _$$metaInfo;

    @SerializedName("series_gifts_info")
    protected SeriesGiftsInfoFlexImpl _$$seriesGift;

    @SerializedName("show_combo_tray")
    protected boolean _$$showComboTray;

    @SerializedName("subscribe_gift_pack_info")
    protected SubscribeGiftPackInfoFlexImpl _$$subscribeGiftPackInfo;

    public GiftExtraInfoFlexImpl() {
        super(g0.class);
        this._$$bannerGiftInfo = BuildConfig.FLAVOR;
        this._$$giftBuffInfos = $defaultValue_giftBuffInfos$();
        this._$$giftHonorLevelUrl = BuildConfig.FLAVOR;
        this._$$showComboTray = false;
    }

    public final List<IGiftBuffInfoFlexImpl> $defaultValue_giftBuffInfos$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ k1 getBottomLabel() {
        return getBottomLabel();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ ComboHintInfo getComboHintInfo() {
        return getComboHintInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ p getDiyGiftToolbarInfo() {
        return getDiyGiftToolbarInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ IGiftExposureAnimInfo getGiftExposureAnimInfo() {
        return getGiftExposureAnimInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ IGiftMarketingInfo getGiftMarketingInfo() {
        return getGiftMarketingInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ l3 getSeriesGift() {
        return getSeriesGift();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public /* bridge */ /* synthetic */ q3 getSubscribeGiftPackInfo() {
        return getSubscribeGiftPackInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final String getBannerGiftInfo() {
        return this._$$bannerGiftInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final List<IGiftBuffInfoFlexImpl> getGiftBuffInfos() {
        return this._$$giftBuffInfos;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final String getGiftHonorLevelUrl() {
        return this._$$giftHonorLevelUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final int getGiftPlayNowStrategy() {
        return this._$$giftPlayNowStrategy;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final int getGiftSelectedStyle() {
        return this._$$giftSelectedStyle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final String getMetaInfo() {
        return this._$$metaInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final boolean getShowComboTray() {
        return this._$$showComboTray;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final IGiftBottomLabelFlexImpl getBottomLabel() {
        return this._$$bottomLabel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final ComboHintInfoFlexImpl getComboHintInfo() {
        return this._$$comboHintInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final DIYGiftToolbarInfoFlexImpl getDiyGiftToolbarInfo() {
        return this._$$diyGiftToolbarInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final IGiftExposureAnimInfoFlexImpl getGiftExposureAnimInfo() {
        return this._$$giftExposureAnimInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final IGiftMarketingInfoFlexImpl getGiftMarketingInfo() {
        return this._$$giftMarketingInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final SeriesGiftsInfoFlexImpl getSeriesGift() {
        return this._$$seriesGift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.g0
    public final SubscribeGiftPackInfoFlexImpl getSubscribeGiftPackInfo() {
        return this._$$subscribeGiftPackInfo;
    }

    public GiftExtraInfoFlexImpl(am3.g r7) {
        super(g0.class);
        this._$$giftBuffInfos = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L23;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            default: goto L7;
        };
    L8:
        this._$$bottomLabel = new IGiftBottomLabelFlexImpl(r7);
        goto L3
    L9:
        this._$$giftPlayNowStrategy = r7.i();
        r3 = r3 | 8;
        goto L3
    L10:
        this._$$giftSelectedStyle = r7.i();
        r3 = r3 | 4;
        goto L3
    L11:
        this._$$showComboTray = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L12:
        this._$$metaInfo = am3.h.c(r7);
        goto L3
    L13:
        this._$$giftMarketingInfo = new IGiftMarketingInfoFlexImpl(r7);
        goto L3
    L14:
        this._$$giftExposureAnimInfo = new IGiftExposureAnimInfoFlexImpl(r7);
        goto L3
    L15:
        this._$$seriesGift = new SeriesGiftsInfoFlexImpl(r7);
        goto L3
    L16:
        this._$$comboHintInfo = new ComboHintInfoFlexImpl(r7);
        goto L3
    L17:
        this._$$diyGiftToolbarInfo = new DIYGiftToolbarInfoFlexImpl(r7);
        goto L3
    L18:
        this._$$giftHonorLevelUrl = am3.h.c(r7);
        goto L3
    L19:
        this._$$giftBuffInfos.add(new IGiftBuffInfoFlexImpl(r7));
        goto L3
    L20:
        this._$$bannerGiftInfo = am3.h.c(r7);
        goto L3
    L21:
        this._$$subscribeGiftPackInfo = new SubscribeGiftPackInfoFlexImpl(r7);
        goto L3
    L22:
        this._$$giftId = r7.j();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L23:
        r7.d(r1);
        setThreadSafe(true);
        if (this._$$bannerGiftInfo != null) goto L27;
        this._$$bannerGiftInfo = BuildConfig.FLAVOR;
    L27:
        if (this._$$giftBuffInfos.isEmpty() == false) goto L30;
        this._$$giftBuffInfos = $defaultValue_giftBuffInfos$();
    L30:
        if (this._$$giftHonorLevelUrl != null) goto L33;
        this._$$giftHonorLevelUrl = BuildConfig.FLAVOR;
    L33:
        if ((r3 & 2) != 0) goto L70;
        this._$$showComboTray = false;
        return;
    }
}
