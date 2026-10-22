package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/p4;", "", "", "enable", "Z", "b", "()Z", "", "continueDuration", "J", "a", "()J", "highLevelEnterAnimInterval", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p4 {

    @SerializedName("continue_duration")
    private final long continueDuration;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("high_level_enter_anim_interval")
    private final long highLevelEnterAnimInterval;

    public p4() {
        this(0);
    }

    public final long a() {
        return this.continueDuration;
    }

    public final boolean b() {
        return this.enable;
    }

    public final long c() {
        return this.highLevelEnterAnimInterval;
    }

    public p4(int r3) {
        this.enable = false;
        this.continueDuration = 5000;
        this.highLevelEnterAnimInterval = 500;
    }
}
