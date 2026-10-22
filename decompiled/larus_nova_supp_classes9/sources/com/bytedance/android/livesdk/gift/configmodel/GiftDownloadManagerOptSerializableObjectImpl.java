package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftDownloadManagerOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/z;", BuildConfig.FLAVOR, "enable", "Z", "getEnable", "()Z", "allAssets", "I0", "cancelNotGift", "X1", "retryOpt", "p5", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftDownloadManagerOptSerializableObjectImpl implements z {

    @SerializedName("all_asset")
    private final boolean allAssets;

    @SerializedName("cancel_not_gift")
    private final boolean cancelNotGift;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("retry_opt")
    private final boolean retryOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftDownloadManagerOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftDownloadManagerOptSerializableObjectImpl.class);
        }
    }

    public GiftDownloadManagerOptSerializableObjectImpl() {
        this.enable = false;
        this.allAssets = false;
        this.cancelNotGift = false;
        this.retryOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.z
    public final boolean I0() {
        return this.allAssets;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.z
    public final boolean X1() {
        return this.cancelNotGift;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.z
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.z
    public final boolean p5() {
        return this.retryOpt;
    }
}
