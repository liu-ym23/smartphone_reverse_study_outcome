package com.bytedance.android.livesdk.config.link;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import us1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/link/SwitchCameraFrequencyConfigSerializableObjectImpl;", "Lus1/c;", "", "maxCount", "I", "getMaxCount", "()I", "gapTime", "z2", "cdTime", "p8", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SwitchCameraFrequencyConfigSerializableObjectImpl implements c {

    @SerializedName("cd_time")
    private final int cdTime;

    @SerializedName("gap_time")
    private final int gapTime;

    @SerializedName("max_count")
    private final int maxCount;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/link/SwitchCameraFrequencyConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SwitchCameraFrequencyConfigSerializableObjectImpl.class);
        }
    }

    public SwitchCameraFrequencyConfigSerializableObjectImpl() {
        this.maxCount = 2;
        this.gapTime = 3;
        this.cdTime = 15;
    }

    @Override // us1.c
    public final int getMaxCount() {
        return this.maxCount;
    }

    @Override // us1.c
    public final int p8() {
        return this.cdTime;
    }

    @Override // us1.c
    public final int z2() {
        return this.gapTime;
    }
}
