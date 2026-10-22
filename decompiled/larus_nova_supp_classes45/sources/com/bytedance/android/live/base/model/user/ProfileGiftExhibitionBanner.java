package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileGiftExhibitionBanner {

    @SerializedName("achieved_gifts")
    public List<py.k> achievedGifts;

    @SerializedName("achieved_icon")
    public py.k achievedIcon;

    @SerializedName("grade_level")
    public int gradeLevel;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("level_up_animation")
    public py.k levelUpAnimation;

    @SerializedName("light_sweep_animation")
    public py.k lightSweepAnimation;

    @SerializedName("lighted_count")
    public int lightedCount;

    @SerializedName("text")
    public String text;

    @SerializedName("total_count")
    public int totalCount;

    @SerializedName("ui_config")
    public ProfileGiftExhibitionBannerUIConfig uiConfig;

    @SerializedName("universe_info")
    public ProfileGiftExhibitionBannerUniverseInfo universeInfo;

    public ProfileGiftExhibitionBanner() {
    }

    public boolean isGroupAnchor() {
        ProfileGiftExhibitionBannerUniverseInfo r0 = this.universeInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getValid();
    }
}
