package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010.R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010#\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u001a\u0010)\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR\u001a\u0010+\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r¨\u00060"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkPanelUpdateStrategySerializableObjectImpl;", "Lr11/r;", "", "interval", "J", "getInterval", "()J", "delay", "getDelay", "", "count", "I", "getCount", "()I", "panelInterval", "q", "panelCount", "C", "validRecInterval", "V7", "asyncItemCount", "s1", "asyncDelayTime", "H8", "validActInterval", "m3", "validRecCount", "t", "validOtherInterval", "C2", "enableListOpt", "y2", "listUpdateTimeOut", "S5", "", "enable", "Z", "getEnable", "()Z", "enableReqOpt", "R5", "openPanelCount", "getOpenPanelCount", "openPanelOverCount", "h5", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkPanelUpdateStrategySerializableObjectImpl implements r {

    @SerializedName("async_delay_time")
    private final long asyncDelayTime;

    @SerializedName("async_item_count")
    private final int asyncItemCount;

    @SerializedName("count")
    private final int count;

    @SerializedName("delay")
    private final long delay;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("list_opt")
    private final int enableListOpt;

    @SerializedName("enable_req_opt")
    private final boolean enableReqOpt;

    @SerializedName("interval")
    private final long interval;

    @SerializedName("list_update_timeout")
    private final long listUpdateTimeOut;

    @SerializedName("open_cnt")
    private final int openPanelCount;

    @SerializedName("open_cnt_overtime")
    private final int openPanelOverCount;

    @SerializedName("panel_count")
    private final int panelCount;

    @SerializedName("panel_interval")
    private final long panelInterval;

    @SerializedName("valid_act_interval")
    private final long validActInterval;

    @SerializedName("valid_other_interval")
    private final long validOtherInterval;

    @SerializedName("valid_rec_count")
    private final int validRecCount;

    @SerializedName("valid_rec_interval")
    private final long validRecInterval;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkPanelUpdateStrategySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkPanelUpdateStrategySerializableObjectImpl.class);
        }
    }

    public PkPanelUpdateStrategySerializableObjectImpl() {
        this.interval = 70000;
        this.delay = 5000;
        this.count = 5;
        this.panelInterval = 50000;
        this.panelCount = 2;
        this.validRecInterval = 60000;
        this.asyncItemCount = 20;
        this.asyncDelayTime = 7000;
        this.validActInterval = 0;
        this.validRecCount = 15;
        this.validOtherInterval = 60000;
        this.enableListOpt = 1;
        this.listUpdateTimeOut = 200;
        this.enable = false;
        this.enableReqOpt = true;
        this.openPanelCount = -1;
        this.openPanelOverCount = -1;
    }

    @Override // r11.r
    public final int C() {
        return this.panelCount;
    }

    @Override // r11.r
    public final long C2() {
        return this.validOtherInterval;
    }

    @Override // r11.r
    public final long H8() {
        return this.asyncDelayTime;
    }

    @Override // r11.r
    public final boolean R5() {
        return this.enableReqOpt;
    }

    @Override // r11.r
    public final long S5() {
        return this.listUpdateTimeOut;
    }

    @Override // r11.r
    public final long V7() {
        return this.validRecInterval;
    }

    @Override // r11.r
    public final int getCount() {
        return this.count;
    }

    @Override // r11.r
    public final long getDelay() {
        return this.delay;
    }

    @Override // r11.r
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.r
    public final long getInterval() {
        return this.interval;
    }

    @Override // r11.r
    public final int getOpenPanelCount() {
        return this.openPanelCount;
    }

    @Override // r11.r
    public final int h5() {
        return this.openPanelOverCount;
    }

    @Override // r11.r
    public final long m3() {
        return this.validActInterval;
    }

    @Override // r11.r
    public final long q() {
        return this.panelInterval;
    }

    @Override // r11.r
    public final int s1() {
        return this.asyncItemCount;
    }

    @Override // r11.r
    public final int t() {
        return this.validRecCount;
    }

    @Override // r11.r
    public final int y2() {
        return this.enableListOpt;
    }
}
