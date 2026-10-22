package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftImageCdnOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/i0;", BuildConfig.FLAVOR, "giftImageOpt", "Z", "w0", "()Z", BuildConfig.FLAVOR, "giftImageCallbackCount", "I", "M3", "()I", "assetCdnOpt", "C7", "assetCdnCallbackCount", "q9", "giftMessageGiftOpt", "Z1", BuildConfig.FLAVOR, "giftImageFormat", "Ljava/lang/String;", "c0", "()Ljava/lang/String;", "giftImageTpl", "A2", "imgDomainThreadOpt", "D1", "arrayListOpt", "T0", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftImageCdnOptSerializableObjectImpl implements i0 {

    @SerializedName("arraylist_opt")
    private final boolean arrayListOpt;

    @SerializedName("asset_cdn_callback_count")
    private final int assetCdnCallbackCount;

    @SerializedName("asset_cdn")
    private final boolean assetCdnOpt;

    @SerializedName("gift_image_callback_count")
    private final int giftImageCallbackCount;

    @SerializedName("gift_image_format")
    private final String giftImageFormat;

    @SerializedName("gift_image")
    private final boolean giftImageOpt;

    @SerializedName("gift_image_tpl")
    private final String giftImageTpl;

    @SerializedName("gift_message_opt")
    private final boolean giftMessageGiftOpt;

    @SerializedName("img_domain_thread")
    private final boolean imgDomainThreadOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftImageCdnOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftImageCdnOptSerializableObjectImpl.class);
        }
    }

    public GiftImageCdnOptSerializableObjectImpl() {
        this.giftImageOpt = false;
        this.giftImageCallbackCount = 5;
        this.assetCdnOpt = false;
        this.assetCdnCallbackCount = 5;
        this.giftMessageGiftOpt = false;
        this.giftImageFormat = "webp";
        this.giftImageTpl = "tplv-obj";
        this.imgDomainThreadOpt = false;
        this.arrayListOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final String A2() {
        return this.giftImageTpl;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final boolean C7() {
        return this.assetCdnOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final boolean D1() {
        return this.imgDomainThreadOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final int M3() {
        return this.giftImageCallbackCount;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final boolean T0() {
        return this.arrayListOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final boolean Z1() {
        return this.giftMessageGiftOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final String c0() {
        return this.giftImageFormat;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final int q9() {
        return this.assetCdnCallbackCount;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.i0
    public final boolean w0() {
        return this.giftImageOpt;
    }
}
