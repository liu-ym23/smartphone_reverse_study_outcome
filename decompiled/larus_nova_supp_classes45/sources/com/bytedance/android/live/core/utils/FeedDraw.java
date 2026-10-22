package com.bytedance.android.live.core.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FeedDraw {

    @SerializedName("city_url")
    private String cityFeedUrl;

    @SerializedName("more_live_url")
    private String followDrawerUrl;

    @SerializedName("pk_url")
    private String pkUrl;

    @SerializedName("settings")
    private Map<String, Integer> settings;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String url;

    public FeedDraw() {
        this.settings = new HashMap();
    }

    public String getFollowDrawerUrl() {
        return this.followDrawerUrl;
    }

    public String getPkUrl() {
        return this.pkUrl;
    }

    public Map<String, Integer> getSettings() {
        return this.settings;
    }

    public String getUrl() {
        return this.url;
    }

    public static FeedDraw defaultInstance(String r3) {
        FeedDraw r0 = new FeedDraw();
        if (tb1.c.a == false) goto L5;
        r0.url = "https://" + r3 + "/webcast/feed/?content_type=0&channel_id=25&is_draw=1";
    L6:
        return r0;
    L5:
        r0.url = "";
        goto L6
    }

    public static boolean needCollectUnRead(String r2) {
        if (StringUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.startsWith("homepage_follow_stream") == false) goto L8;
        return false;
    L8:
        return true;
    }

    public String getInnerUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "";
    L7:
        if (r2.equals("pk") == false) goto L11;
        return this.pkUrl;
    L11:
        if (r2.equals("city_feed") == false) goto L15;
        return this.cityFeedUrl;
    L15:
        return this.url;
    }

    public boolean isSupportedRequestFrom(String r4) {
        if (StringUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        Integer r0 = this.settings.get(r4);
        if (r0 == null) goto L11;
        if (r0.intValue() != 1) goto L11;
        return true;
    L11:
        if (r4.equals("pk") == false) goto L15;
        return !TextUtils.isEmpty(this.pkUrl);
    L15:
        if (r4.equals("city_feed") == true) goto L17;
        return false;
    L17:
        return !TextUtils.isEmpty(this.cityFeedUrl);
    }

    public void setPkUrl(String r1) {
        this.pkUrl = r1;
    }

    public static String conventRequestFrom(String r4, String r5, Bundle r6) {
        if (tb1.c.a == false) goto L105;
        if (r4 != null) goto L7;
        return "";
    L7:
        if ("live_merge".equals(r4) == false) goto L13;
        if ("live_cover".equals(r5) == false) goto L11;
        return "feed_draw";
    L11:
        return "";
    L13:
        if ("discover_page".equals(r4) == false) goto L23;
        if ("draw_more".equals(r5) == false) goto L17;
        return "from_discover";
    L17:
        if ("living_icon".equals(r5) == true) goto L107;
        return "";
    L107:
        return "from_discover";
    L23:
        if ("live_merge_activity".equals(r4) == false) goto L32;
        if ("live_k_activity".equals(r5) == false) goto L27;
    L30:
        return "feed_draw";
    L27:
        if ("live_d3_activity".equals(r5) == true) goto L30;
        return "";
    L32:
        if (r4.equals("homepage_hot") == false) goto L43;
        if ("live_cell".equals(r5) == false) goto L38;
        return "homepage_hot_draw";
    L38:
        if ("video_head".equals(r5) == false) goto L41;
        return "homepage_hot_head";
    L41:
        return "";
    L43:
        if (r4.equals("homepage_fresh") == false) goto L47;
        return "homepage_fresh_head";
    L47:
        if (r4.equals("homepage_follow") == false) goto L55;
        if (r5.equals("live_cell_cover") == false) goto L51;
    L52:
        return "homepage_follow_stream";
    L51:
        if (r5.equals("live_cell") == true) goto L52;
        return "";
    L55:
        if (r4.equals("others_homepage") == false) goto L68;
        if (r5 != null) goto L59;
        return "";
    L59:
        if (r5.equals("others_photo") == false) goto L63;
        return "others_homepage_photo";
    L63:
        if (r5.equals("video_head") == false) goto L66;
        return "others_homepage_head";
    L66:
        return "";
    L68:
        if (r4.equals("general_search") == false) goto L84;
        if (r5 != null) goto L72;
        return "";
    L72:
        if (r5.equals("others_photo") == false) goto L76;
        return "general_search_photo";
    L76:
        if (r5.equals("video_head") == false) goto L80;
        return "general_search_head";
    L80:
        if (r5.equals("drawer_cover") == false) goto L82;
        return "feed_draw";
    L82:
        return "";
    L84:
        if (r4.equals("live_detail") == false) goto L96;
        if ("right_anchor".equals(r5) == false) goto L90;
        return "live_detail_pk";
    L90:
        if ("top_message".equals(r5) == false) goto L93;
        return "live_detail_top_message";
    L93:
        return "live_detail_hourly_rank";
    L96:
        if (r4.equals("live_end") == false) goto L100;
        return "live_end_cover";
    L100:
        if (r4.equals("push") == false) goto L103;
        return "push";
    L103:
        if (r4.equals("h5") == false) goto L105;
        return "h5";
    L105:
        return "";
    }
}
