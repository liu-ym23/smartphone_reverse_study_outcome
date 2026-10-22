package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting_SceneConfigSerializableObjectImpl;", "Lr11/e$d;", "", "enable", "Z", "getEnable", "()Z", "", "monitorDelay", "J", "H", "()J", "interval", "getInterval", "intervalAudience", "w2", "", "sampleCount", "I", "i", "()I", "sampleCountAudience", "D7", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPerformanceSetting_SceneConfigSerializableObjectImpl implements e.d {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("interval")
    private final long interval;

    @SerializedName("interval_audience")
    private final long intervalAudience;

    @SerializedName("monitor_delay")
    private final long monitorDelay;

    @SerializedName("sample_count")
    private final int sampleCount;

    @SerializedName("sample_count_audience")
    private final int sampleCountAudience;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting_SceneConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkPerformanceSetting_SceneConfigSerializableObjectImpl.class);
        }
    }

    public LinkPerformanceSetting_SceneConfigSerializableObjectImpl() {
        this.enable = true;
        this.monitorDelay = 15000;
        this.interval = 0;
        this.intervalAudience = 0;
        this.sampleCount = 0;
        this.sampleCountAudience = 0;
    }

    @Override // r11.e.d
    public final int D7() {
        return this.sampleCountAudience;
    }

    @Override // r11.e.d
    public final long H() {
        return this.monitorDelay;
    }

    @Override // r11.e.d
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.e.d
    public final long getInterval() {
        return this.interval;
    }

    @Override // r11.e.d
    public final int i() {
        return this.sampleCount;
    }

    @Override // r11.e.d
    public final long w2() {
        return this.intervalAudience;
    }
}
