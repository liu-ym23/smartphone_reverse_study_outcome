package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/p21;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "fling_room_num", "I", "b", "()I", "setFling_room_num", "(I)V", "total_cost_time", "e", "setTotal_cost_time", "strategy_diff_count", "d", "setStrategy_diff_count", "poor_net_trigger", "c", "setPoor_net_trigger", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p21 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fling_room_num")
    private int fling_room_num;

    @SerializedName("poor_net_trigger")
    private boolean poor_net_trigger;

    @SerializedName("strategy_diff_count")
    private int strategy_diff_count;

    @SerializedName("total_cost_time")
    private int total_cost_time;

    public p21() {
        this.fling_room_num = 2;
        this.total_cost_time = 5000;
        this.strategy_diff_count = 1;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.fling_room_num;
    }

    public final boolean c() {
        return this.poor_net_trigger;
    }

    public final int d() {
        return this.strategy_diff_count;
    }

    public final int e() {
        return this.total_cost_time;
    }
}
