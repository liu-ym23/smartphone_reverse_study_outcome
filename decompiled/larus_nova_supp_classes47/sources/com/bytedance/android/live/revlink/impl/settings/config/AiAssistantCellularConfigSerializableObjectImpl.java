package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r41.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/AiAssistantCellularConfigSerializableObjectImpl;", "Lr41/a;", "", "txQualityCount", "I", "m2", "()I", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "aiAssistantAudio", "c2", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AiAssistantCellularConfigSerializableObjectImpl implements a {

    @SerializedName("ai_assistant_audio")
    private final String aiAssistantAudio;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("tx_quality_count")
    private final int txQualityCount;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/AiAssistantCellularConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AiAssistantCellularConfigSerializableObjectImpl.class);
        }
    }

    public AiAssistantCellularConfigSerializableObjectImpl() {
        this.txQualityCount = 5;
        this.schema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fchatroom_lynx_douyin%2Fpages%2Fcellular_enhancement%2Ftemplate.js%3Fbiz_type%3D2&mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&radius=12&show_error=1&height=88";
        this.aiAssistantAudio = "aigc_config";
    }

    @Override // r41.a
    public final String c2() {
        return this.aiAssistantAudio;
    }

    @Override // r41.a
    public final String getSchema() {
        return this.schema;
    }

    @Override // r41.a
    public final int m2() {
        return this.txQualityCount;
    }
}
