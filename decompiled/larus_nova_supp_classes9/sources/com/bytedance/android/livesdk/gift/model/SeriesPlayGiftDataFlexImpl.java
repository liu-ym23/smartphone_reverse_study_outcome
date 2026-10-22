package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.SeriesPlayGift")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u0004\u0018\u00010!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SeriesPlayGiftDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/n3;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "gift", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", "Lcom/bytedance/android/livesdk/gift/model/a1;", "anchorGift", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "setAnchorGift", "(Lcom/bytedance/android/livesdk/gift/model/a1;)V", "Lcom/bytedance/android/livesdk/gift/model/SeriesTrayInfoFlexImpl;", "seriesTrayInfo$delegate", "Ljava/lang/Object;", "getSeriesTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/SeriesTrayInfoFlexImpl;", "seriesTrayInfo", "Lcom/bytedance/android/livesdk/gift/model/SendTogetherInfoFlexImpl;", "sendTogetherInfo$delegate", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/SendTogetherInfoFlexImpl;", "sendTogetherInfo", BuildConfig.FLAVOR, "diyItemInfo$delegate", "getDiyItemInfo", "()Ljava/lang/String;", "diyItemInfo", "Lcom/bytedance/android/livesdk/gift/model/AssetEffectMixInfoFlexImpl;", "assetEffectMixInfo$delegate", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/AssetEffectMixInfoFlexImpl;", "assetEffectMixInfo", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeriesPlayGiftDataFlexImpl extends FlexModelBase<n3> implements n3, vh7.h {

    @SerializedName("asset_effect_mix_info")
    protected AssetEffectMixInfoFlexImpl _$$assetEffectMixInfo;

    @SerializedName("diy_item_info")
    protected String _$$diyItemInfo;

    @SerializedName("send_together")
    protected SendTogetherInfoFlexImpl _$$sendTogetherInfo;

    @SerializedName("series_tray_info")
    protected SeriesTrayInfoFlexImpl _$$seriesTrayInfo;

    @SerializedName("anchor_gift")
    protected a1 anchorGift;

    @SerializedName("gift_struct")
    protected h1 gift;

    public SeriesPlayGiftDataFlexImpl() {
        super(n3.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.gift.model.h1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdk.gift.model.a1, java.lang.Object] */
    public SeriesPlayGiftDataFlexImpl(am3.g r5) {
        super(n3.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$assetEffectMixInfo = new AssetEffectMixInfoFlexImpl(r5);
        goto L3
    L9:
        this.anchorGift = vh7.f.a(r5, a1.class);
        goto L3
    L10:
        this._$$diyItemInfo = am3.h.c(r5);
        goto L3
    L11:
        this._$$sendTogetherInfo = new SendTogetherInfoFlexImpl(r5);
        goto L3
    L12:
        this._$$seriesTrayInfo = new SeriesTrayInfoFlexImpl(r5);
        goto L3
    L13:
        this.gift = vh7.f.a(r5, h1.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public /* bridge */ /* synthetic */ c getAssetEffectMixInfo() {
        return getAssetEffectMixInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public /* bridge */ /* synthetic */ j3 getSendTogetherInfo() {
        return getSendTogetherInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public /* bridge */ /* synthetic */ o3 getSeriesTrayInfo() {
        return getSeriesTrayInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public a1 getAnchorGift() {
        return this.anchorGift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public final String getDiyItemInfo() {
        return this._$$diyItemInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public h1 getGift() {
        return this.gift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public final AssetEffectMixInfoFlexImpl getAssetEffectMixInfo() {
        return this._$$assetEffectMixInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public final SendTogetherInfoFlexImpl getSendTogetherInfo() {
        return this._$$sendTogetherInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n3
    public final SeriesTrayInfoFlexImpl getSeriesTrayInfo() {
        return this._$$seriesTrayInfo;
    }

    public void setAnchorGift(a1 r1) {
        this.anchorGift = r1;
    }

    public void setGift(h1 r1) {
        this.gift = r1;
    }
}
