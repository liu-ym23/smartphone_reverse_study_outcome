package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a0 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("expected_visible_height")
    public float expectedVisibleHeight;

    @SerializedName("pad_expected_visible_height")
    public float padExpectedVisibleHeight;

    public a0() {
        this.enable = false;
        this.expectedVisibleHeight = 120.0f;
        this.padExpectedVisibleHeight = 160.0f;
    }
}
