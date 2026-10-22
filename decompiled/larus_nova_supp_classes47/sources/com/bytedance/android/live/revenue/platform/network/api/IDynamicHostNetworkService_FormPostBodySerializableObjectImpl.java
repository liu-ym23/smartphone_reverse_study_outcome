package com.bytedance.android.live.revenue.platform.network.api;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService_FormPostBodySerializableObjectImpl;", "Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$a;", "", "", "content", "Ljava/util/Map;", "getContent", "()Ljava/util/Map;", "setContent", "(Ljava/util/Map;)V", "<init>", "()V", "Adapter", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDynamicHostNetworkService_FormPostBodySerializableObjectImpl implements IDynamicHostNetworkService.a {

    @SerializedName("content")
    private Map<String, String> content;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService_FormPostBodySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IDynamicHostNetworkService_FormPostBodySerializableObjectImpl.class);
        }
    }

    public IDynamicHostNetworkService_FormPostBodySerializableObjectImpl() {
        this.content = d.b();
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService.a
    public final Map<String, String> getContent() {
        return this.content;
    }
}
