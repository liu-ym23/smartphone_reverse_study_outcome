package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequestSerializableObjectImpl;", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest;", "", "state", "I", "getState", "()I", "N", "(I)V", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$c;", "stateStarted", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$c;", "getStateStarted", "()Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$c;", "setStateStarted", "(Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$c;)V", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;", "stateLoaded", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;", "I1", "()Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;", "t6", "(Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;)V", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$d;", "stateStopped", "Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$d;", "getStateStopped", "()Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$d;", "setStateStopped", "(Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$d;)V", "", "serviceVersion", "Ljava/lang/String;", "getServiceVersion", "()Ljava/lang/String;", "setServiceVersion", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NotifyServiceCenterStateRequestSerializableObjectImpl implements NotifyServiceCenterStateRequest {

    @SerializedName("service_version")
    private String serviceVersion;

    @SerializedName("state")
    private int state;

    @SerializedName("state_loaded")
    private NotifyServiceCenterStateRequest.b stateLoaded;

    @SerializedName("state_started")
    private NotifyServiceCenterStateRequest.c stateStarted;

    @SerializedName("state_stopped")
    private NotifyServiceCenterStateRequest.d stateStopped;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(NotifyServiceCenterStateRequestSerializableObjectImpl.class);
        }
    }

    public NotifyServiceCenterStateRequestSerializableObjectImpl() {
        this.stateStarted = (NotifyServiceCenterStateRequest.c) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(NotifyServiceCenterStateRequest.c.class);
        this.stateLoaded = (NotifyServiceCenterStateRequest.b) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(NotifyServiceCenterStateRequest.b.class);
        this.stateStopped = (NotifyServiceCenterStateRequest.d) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(NotifyServiceCenterStateRequest.d.class);
        this.serviceVersion = "";
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest
    public final NotifyServiceCenterStateRequest.b I1() {
        return this.stateLoaded;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest
    public final String getServiceVersion() {
        return this.serviceVersion;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest
    public final int getState() {
        return this.state;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest
    public final void N(int r1) {
        this.state = r1;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest
    public final void t6(NotifyServiceCenterStateRequest.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stateLoaded = r2;
    }
}
