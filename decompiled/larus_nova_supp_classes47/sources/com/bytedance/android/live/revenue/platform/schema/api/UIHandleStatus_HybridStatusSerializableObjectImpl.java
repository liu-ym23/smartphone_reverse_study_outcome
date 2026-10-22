package com.bytedance.android.live.revenue.platform.schema.api;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus_HybridStatusSerializableObjectImpl;", "Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus;", "", "type", "I", "getType", "()I", "setType", "(I)V", "Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$b;", "failedInfo", "Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$b;", "getFailedInfo", "()Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$b;", "D8", "(Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$b;)V", "<init>", "()V", "Adapter", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UIHandleStatus_HybridStatusSerializableObjectImpl implements UIHandleStatus.HybridStatus {

    @SerializedName("failed_info")
    private UIHandleStatus.HybridStatus.b failedInfo;

    @SerializedName("type")
    private int type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus_HybridStatusSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(UIHandleStatus_HybridStatusSerializableObjectImpl.class);
        }
    }

    public UIHandleStatus_HybridStatusSerializableObjectImpl() {
        this.failedInfo = (UIHandleStatus.HybridStatus.b) d.c(UIHandleStatus.HybridStatus.b.class);
    }

    @Override // com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus.HybridStatus
    public final int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus.HybridStatus
    public final void D8(UIHandleStatus.HybridStatus.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.failedInfo = r2;
    }

    @Override // com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus.HybridStatus
    public final void setType(int r1) {
        this.type = r1;
    }
}
