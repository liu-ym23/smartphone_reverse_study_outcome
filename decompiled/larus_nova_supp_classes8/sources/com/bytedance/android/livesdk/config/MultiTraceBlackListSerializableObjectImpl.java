package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiTraceBlackListSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/zb1;", "", "", "businessBlackList", "Ljava/util/List;", "B4", "()Ljava/util/List;", "eventBlackList", "D2", "stepBlackList", "E6", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiTraceBlackListSerializableObjectImpl implements zb1 {

    @SerializedName("business_black_list")
    private final List<String> businessBlackList;

    @SerializedName("event_black_list")
    private final List<String> eventBlackList;

    @SerializedName("step_black_list")
    private final List<String> stepBlackList;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiTraceBlackListSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MultiTraceBlackListSerializableObjectImpl.class);
        }
    }

    public MultiTraceBlackListSerializableObjectImpl() {
        this.businessBlackList = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        this.eventBlackList = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        this.stepBlackList = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
    }

    @Override // com.bytedance.android.livesdk.config.zb1
    public final List<String> B4() {
        return this.businessBlackList;
    }

    @Override // com.bytedance.android.livesdk.config.zb1
    public final List<String> D2() {
        return this.eventBlackList;
    }

    @Override // com.bytedance.android.livesdk.config.zb1
    public final List<String> E6() {
        return this.stepBlackList;
    }
}
