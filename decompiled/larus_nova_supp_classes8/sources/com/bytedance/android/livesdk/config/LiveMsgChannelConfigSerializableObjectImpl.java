package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveMsgChannelConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/z51;", "", "featureSwitch", "Ljava/lang/Integer;", "L1", "()Ljava/lang/Integer;", "", "pkConRtmHandle", "Ljava/lang/Boolean;", "getPkConRtmHandle", "()Ljava/lang/Boolean;", "<init>", "()V", "Adapter", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveMsgChannelConfigSerializableObjectImpl implements z51 {

    @SerializedName("feature_switch")
    private final Integer featureSwitch;

    @SerializedName("pk_con_rtm_handle_enable")
    private final Boolean pkConRtmHandle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveMsgChannelConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveMsgChannelConfigSerializableObjectImpl.class);
        }
    }

    public LiveMsgChannelConfigSerializableObjectImpl() {
        this.featureSwitch = 1;
        this.pkConRtmHandle = Boolean.FALSE;
    }

    @Override // com.bytedance.android.livesdk.config.z51
    public final Integer L1() {
        return this.featureSwitch;
    }
}
