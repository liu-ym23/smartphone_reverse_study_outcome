package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class t0 {

    @SerializedName("delay_time")
    public int delayTime;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("test")
    public boolean test;

    public t0() {
        this.enable = false;
        this.delayTime = 0;
        this.test = false;
    }
}
