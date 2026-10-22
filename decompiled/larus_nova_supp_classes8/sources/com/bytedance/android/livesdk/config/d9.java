package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class d9 {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;

    @SerializedName("ktv_bg_degrade_anchor_limit")
    public double ktvBgDegradeAnchorLimit;

    @SerializedName("ktv_bg_degrade_audience_limit")
    public double ktvBgDegradeAudienceLimit;

    @SerializedName("ktv_stage_animated_background")
    public String ktvStageAnimatedBg;

    @SerializedName("ktv_stage_static_background")
    public String ktvStageStaticBg;

    @SerializedName("ktv_talk_effect")
    public String seatTalkEffect;

    @SerializedName("ktv_sing_effect_url")
    public String stageSingEffect;

    @SerializedName("ktv_start_talk_effect")
    public String startTalkEffect;

    static {
        a = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_ktv_theme_bg_default.webp");
        b = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_ktv_theme_bg_default.webp");
        boolean r0 = tb1.c.a;
        if (r0 == true) goto L5;
        boolean r1 = tb1.c.c;
    L5:
        c = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_stage_sing_effect1.webp";
        d = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/red_circle_singing.webp";
        if (r0 == true) goto L8;
        boolean r2 = tb1.c.c;
    L8:
        e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_seat_talk_effect.webp";
        if (r0 == true) goto L11;
        boolean r3 = tb1.c.c;
    L11:
        f = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_seat_talk_start_effect.webp";
    }

    public d9() {
        this.ktvBgDegradeAnchorLimit = 7.09d;
        this.ktvBgDegradeAudienceLimit = 6.11d;
    }
}
