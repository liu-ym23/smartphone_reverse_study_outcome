package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ai1 {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    @SerializedName("background")
    public String backgroundImage;

    @SerializedName("flexible_blue_win_animation")
    public String flexibleBlueWinAnimation;

    @SerializedName("flexible_even_result_animation")
    public String flexibleEvenResultAnimation;

    @SerializedName("flexible_red_win_animation")
    public String flexibleRedWinAnimation;

    @SerializedName("start_animation")
    public String startAnimation;

    @SerializedName("start_btn_animation")
    public String startBtnAnimation;

    @SerializedName("team_fight_rule")
    public String teamFightRule;

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-android/team_fight_red_team_win_anim.webp");
        a = r0.toString();
        b = "https://" + r2.getObjectTosPath() + "/obj/live-android/team_fight_blue_team_win_anim.webp";
        c = "https://" + r2.getObjectTosPath() + "/obj/live-android/team_fight_even_result_anim.webp";
    }

    public ai1() {
        this.backgroundImage = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_team_fight_bg.png";
        this.startAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/team_fight_start_anim_dy.webp";
        this.startBtnAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/team_fight_start_btn_guide_douyin.webp";
        this.teamFightRule = "obj/live-android/ttlive_bg_team_fight_rule.png";
        this.flexibleRedWinAnimation = a;
        this.flexibleBlueWinAnimation = b;
        this.flexibleEvenResultAnimation = c;
    }
}
