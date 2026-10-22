package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.revenue.platform.api.core.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import r11.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSettingSerializableObjectImpl;", "Lr11/h;", "", "enable", "Z", "getEnable", "()Z", "force", "f4", "", "", "Lr11/h$b;", "configs", "Ljava/util/Map;", "k", "()Ljava/util/Map;", "liveCoreConfigs", "n4", "liveCoreCapEnable", "F7", "", "liveCoreCapMinRatio", "F", "z8", "()F", "liveCoreCapMaxRatio", "q6", "liveCoreCapMaxW", "I", "getLiveCoreCapMaxW", "()I", "liveCoreCapMaxH", "getLiveCoreCapMaxH", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPushDegradeSettingSerializableObjectImpl implements h {

    @SerializedName("config")
    private final Map<Integer, h.b> configs;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_force")
    private final boolean force;

    @SerializedName("livecore_cap_enable")
    private final boolean liveCoreCapEnable;

    @SerializedName("livecore_cap_h_max")
    private final int liveCoreCapMaxH;

    @SerializedName("livecore_cap_ratio_max")
    private final float liveCoreCapMaxRatio;

    @SerializedName("livecore_cap_w_max")
    private final int liveCoreCapMaxW;

    @SerializedName("livecore_cap_ratio_min")
    private final float liveCoreCapMinRatio;

    @SerializedName("livecore_config")
    private final Map<Integer, h.b> liveCoreConfigs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSettingSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkPushDegradeSettingSerializableObjectImpl.class);
        }
    }

    public LinkPushDegradeSettingSerializableObjectImpl() {
        this.enable = false;
        this.force = false;
        this.configs = d.a(new Pair[0]);
        this.liveCoreConfigs = d.a(new Pair[0]);
        this.liveCoreCapEnable = true;
        this.liveCoreCapMinRatio = 1.75f;
        this.liveCoreCapMaxRatio = 1.81f;
        this.liveCoreCapMaxW = 720;
        this.liveCoreCapMaxH = 1280;
    }

    @Override // r11.h
    public final boolean F7() {
        return this.liveCoreCapEnable;
    }

    @Override // r11.h
    public final boolean f4() {
        return this.force;
    }

    @Override // r11.h
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.h
    public final Map<Integer, h.b> k() {
        return this.configs;
    }

    @Override // r11.h
    public final Map<Integer, h.b> n4() {
        return this.liveCoreConfigs;
    }

    @Override // r11.h
    public final float q6() {
        return this.liveCoreCapMaxRatio;
    }

    @Override // r11.h
    public final float z8() {
        return this.liveCoreCapMinRatio;
    }
}
