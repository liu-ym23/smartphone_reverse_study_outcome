package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r41.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/LiveRevenueVolumeIndicatorConfigSerializableObjectImpl;", "Lr41/e;", "", "enabled", "Z", "getEnabled", "()Z", "", "changeThreshold", "I", "H2", "()I", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRevenueVolumeIndicatorConfigSerializableObjectImpl implements e {

    @SerializedName("change_threshold")
    private final int changeThreshold;

    @SerializedName("enabled")
    private final boolean enabled;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/LiveRevenueVolumeIndicatorConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveRevenueVolumeIndicatorConfigSerializableObjectImpl.class);
        }
    }

    public LiveRevenueVolumeIndicatorConfigSerializableObjectImpl() {
        this.enabled = true;
        this.changeThreshold = 25;
    }

    @Override // r41.e
    public final int H2() {
        return this.changeThreshold;
    }

    @Override // r41.e
    public final boolean getEnabled() {
        return this.enabled;
    }
}
