package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/LiveLinkMicUpdateLiveCoreParamsConfig;", "()V", "anchorEnable", "", "getAnchorEnable", "()Z", "guestEnable", "getGuestEnable", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl implements LiveLinkMicUpdateLiveCoreParamsConfig {

    @SerializedName("anchor_enable")
    private final boolean anchorEnable;

    @SerializedName("guest_enable")
    private final boolean guestEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl.class);
        }
    }

    public LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl() {
        this.anchorEnable = false;
        this.guestEnable = false;
    }

    @Override // com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig
    public final boolean getAnchorEnable() {
        return this.anchorEnable;
    }

    @Override // com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig
    public final boolean getGuestEnable() {
        return this.guestEnable;
    }
}
