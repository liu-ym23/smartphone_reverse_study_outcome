package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileBusinessArea {

    @SerializedName("anchor_homeland_banner")
    public b anchorHomelandBanner;

    @SerializedName("bottom_banner_list")
    public List<HonorWallElement> bottomBannerList;

    @SerializedName("bottom_element_list")
    public List<HonorWallElement> bottomElementList;

    @SerializedName("exhibition_banner")
    public ProfileGiftExhibitionBanner exhibitionBanner;

    @SerializedName("group_live_banner")
    public h groupLiveBanner;

    @SerializedName("resident_guest_banner")
    public i0 residentGuestBanner;

    @SerializedName("top_element_list")
    public List<HonorWallElement> topElementList;

    public ProfileBusinessArea() {
    }
}
