package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LivePkInviteConfigSerializableObjectImpl;", "Lr11/l;", "", "controlEnable", "Z", "P7", "()Z", "", "startInterval", "I", "R3", "()I", "endTimesLimit", "c7", "endTimeInterval", "A0", "refuseInterval", "T4", "refuseTimeLimit", "l2", "refuseIntevalDelay", "Y", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePkInviteConfigSerializableObjectImpl implements l {

    @SerializedName("live_pk_disable_frequency_control")
    private final boolean controlEnable;

    @SerializedName("end_limit_interval")
    private final int endTimeInterval;

    @SerializedName("initiative_end_times_limit")
    private final int endTimesLimit;

    @SerializedName("continuous_refused_limit_interval")
    private final int refuseInterval;

    @SerializedName("rufused_limit_interval")
    private final int refuseIntevalDelay;

    @SerializedName("refused_times_limit")
    private final int refuseTimeLimit;

    @SerializedName("start_limit_interval")
    private final int startInterval;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LivePkInviteConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LivePkInviteConfigSerializableObjectImpl.class);
        }
    }

    public LivePkInviteConfigSerializableObjectImpl() {
        this.controlEnable = true;
        this.startInterval = 3000;
        this.endTimesLimit = 100;
        this.endTimeInterval = 60000;
        this.refuseInterval = 300000;
        this.refuseTimeLimit = 10;
        this.refuseIntevalDelay = 60000;
    }

    @Override // r11.l
    public final int A0() {
        return this.endTimeInterval;
    }

    @Override // r11.l
    public final boolean P7() {
        return this.controlEnable;
    }

    @Override // r11.l
    public final int R3() {
        return this.startInterval;
    }

    @Override // r11.l
    public final int T4() {
        return this.refuseInterval;
    }

    @Override // r11.l
    public final int Y() {
        return this.refuseIntevalDelay;
    }

    @Override // r11.l
    public final int c7() {
        return this.endTimesLimit;
    }

    @Override // r11.l
    public final int l2() {
        return this.refuseTimeLimit;
    }
}
