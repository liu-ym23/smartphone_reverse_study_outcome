package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class l0 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("public_screen_consume_level_3")
    public int highFreq;

    @SerializedName("public_screen_consume_level_1")
    public int lowFreq;

    @SerializedName("public_screen_consume_level_2")
    public int normaFreq;

    public l0() {
        this.enable = true;
        this.highFreq = 1;
        this.normaFreq = 1;
        this.lowFreq = 1;
    }
}
