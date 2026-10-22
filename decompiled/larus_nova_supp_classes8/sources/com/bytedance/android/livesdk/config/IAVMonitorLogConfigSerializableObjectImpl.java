package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/IAVMonitorLogConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/q7;", "", "enable", "Z", "getEnable", "()Z", "", "", "rtcLogType", "Ljava/util/List;", "N5", "()Ljava/util/List;", "stackTrace", "getStackTrace", "", "stackTraceDepth", "I", "q7", "()I", "", "eventMap", "Ljava/util/Map;", "getEventMap", "()Ljava/util/Map;", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAVMonitorLogConfigSerializableObjectImpl implements q7 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("event_map")
    private final Map<String, String> eventMap;

    @SerializedName("rtc_log_type")
    private final List<String> rtcLogType;

    @SerializedName("stack_trace")
    private final boolean stackTrace;

    @SerializedName("stack_trace_depth")
    private final int stackTraceDepth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/IAVMonitorLogConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IAVMonitorLogConfigSerializableObjectImpl.class);
        }
    }

    public IAVMonitorLogConfigSerializableObjectImpl() {
        this.enable = true;
        this.rtcLogType = com.bytedance.revenue.platform.api.core.c.a(new String[]{"live_client_monitor_log"});
        this.stackTrace = true;
        this.stackTraceDepth = 18;
        this.eventMap = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("rtc_engine_api_call", "sdk_interface_call"), TuplesKt.to("livecore_api_call", "sdk_interface_call")});
    }

    @Override // com.bytedance.android.livesdk.config.q7
    public final List<String> N5() {
        return this.rtcLogType;
    }

    @Override // com.bytedance.android.livesdk.config.q7
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.config.q7
    public final Map<String, String> getEventMap() {
        return this.eventMap;
    }

    @Override // com.bytedance.android.livesdk.config.q7
    public final int q7() {
        return this.stackTraceDepth;
    }
}
