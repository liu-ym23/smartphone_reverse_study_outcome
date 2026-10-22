package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class c71 {

    @SerializedName("panel_random_info_text_color")
    public String barTextColor;

    @SerializedName("pk_bg")
    public String pkBg;

    @SerializedName("pk_bg_down")
    public String pkBgDown;

    @SerializedName("pk_bg_up")
    public String pkBgUp;

    @SerializedName("fail_animation")
    public String pkFailAnimation;

    @SerializedName("pk_fail_icon")
    public String pkFailIcon;

    @SerializedName("panel_banner_info_bg")
    public String pkPanelBarBg;

    @SerializedName("panel_invite_button_bg")
    public String pkPanelButtonBg;

    @SerializedName("panel_random_bg")
    public String pkPanelRandomBg;

    @SerializedName("pk_rank_season_down_result_bg")
    public String pkRankSeasonDownResultBg;

    @SerializedName("pk_rank_season_draw_result_bg")
    public String pkRankSeasonDrawResultBg;

    @SerializedName("pk_rank_season_event_bg")
    public String pkRankSeasonEventBg;

    @SerializedName("pk_rank_season_title_image")
    public String pkRankSeasonTitleImage;

    @SerializedName("pk_rank_season_up_result_anim_bg")
    public String pkRankSeasonUpResultAnimBg;

    @SerializedName("pk_rank_season_up_result_bg")
    public String pkRankSeasonUpResultBg;

    @SerializedName("pk_record_consecutiveWin_bg")
    public String pkRecordConsecutiveVictoryBg;

    @SerializedName("pk_record_consecutiveWin_text")
    public String pkRecordConsecutiveVictoryText;

    @SerializedName("pk_record_consecutiveWin_text_color")
    public String pkRecordConsecutiveVictoryTextColor;

    @SerializedName("pk_empty_record_panel_automatch_button_bg")
    public String pkRecordEmptyPanelAutomatchBtnBg;

    @SerializedName("pk_empty_record_panel_automatch_button_textcolor")
    public String pkRecordEmptyPanelAutomatchBtnTextColor;

    @SerializedName("pk_record_cell_onemore_button_bg")
    public String pkRecordOncemoreBtnBg;

    @SerializedName("pk_record_cell_onemore_button_textcolor")
    public String pkRecordOncemoreBtnTextColor;

    @SerializedName("live_pk_record_cell_deuce")
    public String pkRecordResultIconDraw;

    @SerializedName("live_pk_record_cell_defeat")
    public String pkRecordResultIconFailure;

    @SerializedName("live_pk_record_cell_victory")
    public String pkRecordResultIconVictory;

    @SerializedName("live_pk_succession_victory_bronze")
    public String pkResultConsecutiveVictoryBronze;

    @SerializedName("live_pk_succession_victory_diamond")
    public String pkResultConsecutiveVictoryDiamond;

    @SerializedName("live_pk_succession_victory_gold")
    public String pkResultConsecutiveVictoryGold;

    @SerializedName("live_pk_succession_victory_platinum")
    public String pkResultConsecutiveVictoryPlatinum;

    @SerializedName("live_pk_succession_victory_silver")
    public String pkResultConsecutiveVictorySilver;

    @SerializedName("start_animation")
    public String pkStartAnimation;

    @SerializedName("tie_animation")
    public String pkTieAnimation;

    @SerializedName("pk_tie_icon")
    public String pkTieIcon;

    @SerializedName("pk_title_bar_bg")
    public String pkTitleBarBg;

    @SerializedName("pk_title_bar_text_color")
    public String pkTitleBarTextColor;

    @SerializedName("pk_title_bar_width")
    public String pkTitleBarWidth;

    @SerializedName("pk_logo")
    public String pkTitleIcon;

    @SerializedName("victory_animation")
    public String pkVictoryAnimation;

    @SerializedName("pk_victory_icon")
    public String pkVictoryIcon;

    @SerializedName("panel_random_button_bg")
    public String randomPkButtonBg;

    @SerializedName("panel_random_button_text_color")
    public String randomPkButtonTextColor;

    @SerializedName("result_animation_text_bg")
    public String resultTextBg;

    @SerializedName("score_bar_left_end_color")
    public String scoreBarLeftEndColor;

    @SerializedName("score_bar_left_start_color")
    public String scoreBarLeftStartColor;

    @SerializedName("score_bar_left_text_color")
    public String scoreBarLeftTextColor;

    @SerializedName("score_bar_right_end_color")
    public String scoreBarRightEndColor;

    @SerializedName("score_bar_right_start_color")
    public String scoreBarRightStartColor;

    @SerializedName("score_bar_right_text_color")
    public String scoreBarRightTextColor;

    @SerializedName("self_start_animation_info_bg")
    public String startAnimLeftBg;

    @SerializedName("self_start_animation_info_text_color")
    public String startAnimLeftTextColor;

    @SerializedName("oppo_start_animation_info_bg")
    public String startAnimRightBg;

    @SerializedName("oppo_start_animation_info_text_color")
    public String startAnimRightTextColor;

    public static HashMap<Long, c71> a() {
        c71 r0 = new c71();
        r0.pkFailIcon = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_fail_icon_1.png";
        r0.pkVictoryIcon = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_victory_icon_1.png";
        r0.pkTieIcon = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_hourly_rank_tie_icon_1.png";
        r0.pkTitleBarTextColor = "#8C5906";
        r0.pkTitleBarWidth = "90";
        r0.pkTitleBarBg = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_title_bar_bg.png";
        r0.scoreBarLeftStartColor = "#FFAB2D";
        r0.scoreBarLeftEndColor = "#FFD687";
        r0.scoreBarRightStartColor = "#71EEFF";
        r0.scoreBarRightEndColor = "#579CFF";
        r0.scoreBarLeftTextColor = "#520137";
        r0.scoreBarRightTextColor = "#0A2876";
        r0.pkBg = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg.png";
        r0.pkBgUp = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_up.png";
        r0.pkBgDown = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_down.png";
        r0.pkStartAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_start_animation.webp";
        r0.pkVictoryAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_victory_animation.webp";
        r0.pkFailAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_fail_animation.webp";
        r0.pkTieAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_tie_animation.webp";
        return new HashMap();
    }

    public c71() {
        this.pkFailIcon = "";
        this.pkVictoryIcon = "";
        this.pkTieIcon = "";
        this.pkTitleBarTextColor = "";
        this.pkTitleBarWidth = "";
        this.pkTitleBarBg = "";
        this.pkTitleIcon = "";
        this.scoreBarLeftStartColor = "";
        this.scoreBarLeftEndColor = "";
        this.scoreBarRightStartColor = "";
        this.scoreBarRightEndColor = "";
        this.scoreBarLeftTextColor = "";
        this.scoreBarRightTextColor = "";
        this.pkBg = "";
        this.pkBgUp = "";
        this.pkBgDown = "";
        this.pkStartAnimation = "";
        this.pkVictoryAnimation = "";
        this.pkFailAnimation = "";
        this.pkTieAnimation = "";
    }
}
