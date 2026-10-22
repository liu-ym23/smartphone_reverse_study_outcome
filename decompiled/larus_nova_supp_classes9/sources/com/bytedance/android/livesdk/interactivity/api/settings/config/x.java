package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class x {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("high_height_multi_factor")
    public float highHeightMultiFactor;

    @SerializedName("low_height_multi_factor")
    public float lowHeightMultiFactor;

    @SerializedName("mid_height_multi_factor")
    public float midHeightMultiFactor;

    @SerializedName("setting_entry_position")
    public int settingEntryPos;

    public x() {
        this.enable = false;
        this.settingEntryPos = 1;
        this.lowHeightMultiFactor = -0.33f;
        this.midHeightMultiFactor = 0.25f;
        this.highHeightMultiFactor = 0.33f;
    }
}
