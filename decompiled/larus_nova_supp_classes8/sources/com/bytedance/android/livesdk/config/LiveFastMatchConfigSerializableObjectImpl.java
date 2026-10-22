package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveFastMatchConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/x21;", "", "guideAutoHideDuration", "I", "h2", "()I", "enableSilenceStatusMemory", "U3", "enableShakeSettingsEntrance", "getEnableShakeSettingsEntrance", "<init>", "()V", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveFastMatchConfigSerializableObjectImpl implements x21 {

    @SerializedName("enable_shake_settings_entrance")
    private final int enableShakeSettingsEntrance;

    @SerializedName("enable_silence_status_memory")
    private final int enableSilenceStatusMemory;

    @SerializedName("guide_auto_hide_duration")
    private final int guideAutoHideDuration;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveFastMatchConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveFastMatchConfigSerializableObjectImpl.class);
        }
    }

    public LiveFastMatchConfigSerializableObjectImpl() {
        this.guideAutoHideDuration = 0;
        this.enableSilenceStatusMemory = 0;
        this.enableShakeSettingsEntrance = 0;
    }

    @Override // com.bytedance.android.livesdk.config.x21
    public final int U3() {
        return this.enableSilenceStatusMemory;
    }

    @Override // com.bytedance.android.livesdk.config.x21
    public final int h2() {
        return this.guideAutoHideDuration;
    }
}
