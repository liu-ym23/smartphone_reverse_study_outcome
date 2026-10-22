package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileGiftExhibitionBannerUIConfig {

    @SerializedName("background_icon")
    public py.k backgroundIcon;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("gradient_color")
    public List<String> gradientColor;

    @SerializedName("text_color")
    public String textColor;

    @SerializedName("text_color_v3")
    public String textColorV3;

    @SerializedName("title_color_v3")
    public String titleColorV3;

    public ProfileGiftExhibitionBannerUIConfig() {
    }
}
