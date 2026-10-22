package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class m1 {

    @SerializedName("about")
    public String mAbout;

    @SerializedName("about_page_url")
    public String mAboutPageUrl;

    @SerializedName("advertisement")
    public String mAdvertisement;

    @SerializedName("detail")
    public String mDetail;

    @SerializedName("detail_page_url")
    public String mDetailPageUrl;

    @SerializedName("notice")
    public ArrayList<Object> mNoticeList;

    @SerializedName("show_level_panel")
    public boolean mShowLevelPanel;

    public m1() {
    }
}
