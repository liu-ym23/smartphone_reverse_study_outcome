package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class HonorWallBg {

    @SerializedName("border_color")
    String borderColor;

    @SerializedName("color_end")
    String colorEnd;

    @SerializedName("color_start")
    String colorStart;

    @SerializedName("icon")
    py.k icon;

    public HonorWallBg() {
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public String getColorEnd() {
        return this.colorEnd;
    }

    public String getColorStart() {
        return this.colorStart;
    }

    public py.k getIcon() {
        return this.icon;
    }
}
