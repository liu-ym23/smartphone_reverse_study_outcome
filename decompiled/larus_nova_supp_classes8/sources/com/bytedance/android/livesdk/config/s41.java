package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class s41 {

    @SerializedName("click_delay_duration")
    public long clickDelayDuration;

    @SerializedName("draw_delay_duration")
    public long drawDelayDuration;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("percent")
    public int percent;

    public s41() {
        this.enable = false;
        this.percent = 50;
        this.clickDelayDuration = -1;
        this.drawDelayDuration = -1;
    }
}
