package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.rd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl;", "Lw20/rd$b;", "", "", "nodePaths", "Ljava/util/List;", "w", "()Ljava/util/List;", "setNodePaths", "(Ljava/util/List;)V", "Lcom/google/gson/JsonObject;", "streamMapper", "Lcom/google/gson/JsonObject;", "getStreamMapper", "()Lcom/google/gson/JsonObject;", "setStreamMapper", "(Lcom/google/gson/JsonObject;)V", "layoutKey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setLayoutKey", "(Ljava/lang/String;)V", "rtcKey", "G", "setRtcKey", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl implements rd.b {

    @SerializedName("layoutKey")
    private String layoutKey;

    @SerializedName("nodePaths")
    private List<String> nodePaths;

    @SerializedName("rtcKey")
    private String rtcKey;

    @SerializedName("streamMapper")
    private JsonObject streamMapper;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl.class);
        }
    }

    public RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl() {
    }

    @Override // w20.rd.b
    public final String G() {
        return this.rtcKey;
    }

    @Override // w20.rd.b
    public final String c() {
        return this.layoutKey;
    }

    @Override // w20.rd.b
    public final List<String> w() {
        return this.nodePaths;
    }
}
