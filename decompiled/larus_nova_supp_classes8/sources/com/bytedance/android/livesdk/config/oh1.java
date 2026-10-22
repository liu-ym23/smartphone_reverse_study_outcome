package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/oh1;", "", "", "monitorSwitch", "Z", "c", "()Z", "setMonitorSwitch", "(Z)V", "", "fpsCheckMaxCount", "I", "b", "()I", "setFpsCheckMaxCount", "(I)V", "", "fpsCheckInterval", "J", "a", "()J", "setFpsCheckInterval", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class oh1 {

    @SerializedName("sonic_game_fps_check_interval")
    private long fpsCheckInterval;

    @SerializedName("sonic_game_fps_check_max_count")
    private int fpsCheckMaxCount;

    @SerializedName("sonic_game_fps_monitor_switch")
    private boolean monitorSwitch;

    public oh1() {
        this.monitorSwitch = true;
        this.fpsCheckMaxCount = 5;
        this.fpsCheckInterval = 5000;
    }

    public final long a() {
        return this.fpsCheckInterval;
    }

    public final int b() {
        return this.fpsCheckMaxCount;
    }

    public final boolean c() {
        return this.monitorSwitch;
    }
}
