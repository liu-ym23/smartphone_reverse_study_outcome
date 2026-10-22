package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/config/AssetManualCleanCacheConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/e0;", "", "enable", "Z", "getEnable", "()Z", "", "expireDurationSecond", "J", "C0", "()J", "", "maxRoomMemberCount", "I", "Q4", "()I", "minAssetCacheSize", "d4", "minAppStorageUsagePercentage", "F1", "maxLoadingDurationSecond", "T7", "cleanGapIntervalSecond", "T8", "maxPushHintCount", "H5", "enterRoomWaitPushDurationSecond", "Q8", "<init>", "()V", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetManualCleanCacheConfigSerializableObjectImpl implements e0 {

    @SerializedName("clean_gap")
    private final long cleanGapIntervalSecond;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_room_wait_hint_duration")
    private final int enterRoomWaitPushDurationSecond;

    @SerializedName("expire_duration")
    private final long expireDurationSecond;

    @SerializedName("max_loading_duration")
    private final int maxLoadingDurationSecond;

    @SerializedName("hint_count")
    private final int maxPushHintCount;

    @SerializedName("max_room_member_count")
    private final int maxRoomMemberCount;

    @SerializedName("app_on_device_percentage")
    private final int minAppStorageUsagePercentage;

    @SerializedName("min_asset_size")
    private final int minAssetCacheSize;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/AssetManualCleanCacheConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AssetManualCleanCacheConfigSerializableObjectImpl.class);
        }
    }

    public AssetManualCleanCacheConfigSerializableObjectImpl() {
        this.enable = false;
        this.expireDurationSecond = 604800;
        this.maxRoomMemberCount = 100;
        this.minAssetCacheSize = 100;
        this.minAppStorageUsagePercentage = 30;
        this.maxLoadingDurationSecond = 6;
        this.cleanGapIntervalSecond = 604800;
        this.maxPushHintCount = 100;
        this.enterRoomWaitPushDurationSecond = 10;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final long C0() {
        return this.expireDurationSecond;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int F1() {
        return this.minAppStorageUsagePercentage;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int H5() {
        return this.maxPushHintCount;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int Q4() {
        return this.maxRoomMemberCount;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int Q8() {
        return this.enterRoomWaitPushDurationSecond;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int T7() {
        return this.maxLoadingDurationSecond;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final long T8() {
        return this.cleanGapIntervalSecond;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final int d4() {
        return this.minAssetCacheSize;
    }

    @Override // com.bytedance.android.livesdk.config.e0
    public final boolean getEnable() {
        return this.enable;
    }
}
