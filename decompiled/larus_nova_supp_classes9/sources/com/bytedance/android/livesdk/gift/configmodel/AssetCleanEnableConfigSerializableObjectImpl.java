package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetCleanEnableConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/c;", BuildConfig.FLAVOR, "enableClean", "Z", "h1", "()Z", "enableDeleteFromNet", "U1", BuildConfig.FLAVOR, "peakPeriodStartTime", "I", "Q0", "()I", "peakPeriodEndTime", "K4", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetCleanEnableConfigSerializableObjectImpl implements c {

    @SerializedName("enable_clean")
    private final boolean enableClean;

    @SerializedName("enable_delete_from_net")
    private final boolean enableDeleteFromNet;

    @SerializedName("peak_period_end_time")
    private final int peakPeriodEndTime;

    @SerializedName("peak_period_start_time")
    private final int peakPeriodStartTime;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetCleanEnableConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AssetCleanEnableConfigSerializableObjectImpl.class);
        }
    }

    public AssetCleanEnableConfigSerializableObjectImpl() {
        this.enableClean = false;
        this.enableDeleteFromNet = false;
        this.peakPeriodStartTime = 20;
        this.peakPeriodEndTime = 23;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.c
    public final int K4() {
        return this.peakPeriodEndTime;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.c
    public final int Q0() {
        return this.peakPeriodStartTime;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.c
    public final boolean U1() {
        return this.enableDeleteFromNet;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.c
    public final boolean h1() {
        return this.enableClean;
    }
}
