package com.bytedance.android.livesdk.chatroom.vs_base.base.setting;

import com.bytedance.android.live.core.setting.SettingKey;
import oq1.d;
import oq1.e;
import oq1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface ReplayConfigSettingKeys {
    public static final SettingKey<Boolean> LIVE_PAID_REPLAY_BAN_SCREEN_RECORD = null;
    public static final SettingKey<f> LIVE_REPLAY_DEFAULT_RESOLUTION = null;
    public static final SettingKey<String> LIVE_REPLAY_HDR_GUILD_WEBP = null;
    public static final SettingKey<String> LIVE_REPLAY_HDR_SUCCESS_WEBP = null;
    public static final SettingKey<Boolean> LIVE_REPLAY_PERFORMANCE_TEST = null;
    public static final SettingKey<Boolean> LIVE_REPLAY_VIDEO_RESIZE_ENABLE = null;
    public static final SettingKey<Integer> REPLAY_COMMENT_WORDS_COUNT_LIMIT = null;
    public static final SettingKey<e> REPLAY_DANMAKU_CONFIG = null;
    public static final SettingKey<Boolean> REPLAY_ENABLE_VIDEO_DOWNLOAD_ENTRANCE = null;
    public static final SettingKey<Float> REPLAY_FAST_FORWARD_SPEED = null;
    public static final SettingKey<String> REPLAY_LOADING_BG = null;
    public static final SettingKey<Boolean> REPLAY_PAID_ANDROID_DOU_PRICE = null;
    public static final SettingKey<d> REPLAY_PAID_CONFIG = null;
    public static final SettingKey<Boolean> REPLAY_SCHEDULE_CLOSE_TEST = null;
    public static final SettingKey<Boolean> REPLAY_SHOW_SHADOW_PLAYER_BACKGROUND = null;

    static {
        LIVE_REPLAY_DEFAULT_RESOLUTION = new SettingKey("live_replay_default_resolution", "vs回放默认清晰度", new f(), new f());
        REPLAY_DANMAKU_CONFIG = new SettingKey("live_playback_danmaku_config", "横屏弹幕模式下弹幕设置", new e(), new e());
        Boolean r1 = Boolean.TRUE;
        Boolean r2 = Boolean.FALSE;
        LIVE_PAID_REPLAY_BAN_SCREEN_RECORD = new SettingKey("live_playback_paidLive_ban_screenRecord", "付费回放是否禁止录屏", r1, r2);
        REPLAY_COMMENT_WORDS_COUNT_LIMIT = new SettingKey("live_playback_comment_words_count_limit", "评论最大字数限制", 200, 200);
        LIVE_REPLAY_PERFORMANCE_TEST = new SettingKey("live_replay_performance_test", "回放性能测试开关", r2, r1);
        REPLAY_ENABLE_VIDEO_DOWNLOAD_ENTRANCE = new SettingKey("replay_enable_video_download_entrance", "回放是否打开缓存入口", r1, r1);
        REPLAY_SCHEDULE_CLOSE_TEST = new SettingKey("replay_schedule_close_test", "定时关闭开启测试选项", r2, r2);
        LIVE_REPLAY_VIDEO_RESIZE_ENABLE = new SettingKey("live_replay_video_resize_enable", "横屏场景，播放器缩放时切流触发surfacechange开关", r1, r1);
        REPLAY_LOADING_BG = new SettingKey("replay_loading_bg", "回放横屏加载背景", "https://$objectTosPath/obj/live-android/ttlive_replay_loading_bg.jpg", "https://$objectTosPath/obj/live-android/ttlive_replay_loading_bg.jpg", false);
        LIVE_REPLAY_HDR_GUILD_WEBP = new SettingKey("live_replay_hdr_guild_webp", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/hdr_guide_4.webp", "HDR清晰度的开始介绍动画");
        LIVE_REPLAY_HDR_SUCCESS_WEBP = new SettingKey("live_replay_hdr_success_webp", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/hdr_success_4.webp", "HDR清晰度的切换完成动画动画");
        REPLAY_SHOW_SHADOW_PLAYER_BACKGROUND = new SettingKey("replay_show_shadow_player_background", "展示虚拟播放器背景", r2, r2);
        REPLAY_PAID_CONFIG = new SettingKey("replay_paid_config", "付费回放相关配置", new d(), new d());
        REPLAY_PAID_ANDROID_DOU_PRICE = new SettingKey("replay_paid_android_dou_price", "付费直播客户端展示价格入口显示抖币/钻石", r1, r1);
        Float r3 = Float.valueOf(3.0f);
        REPLAY_FAST_FORWARD_SPEED = new SettingKey("replay_fast_forward_speed", "回放快进倍速", r3, r3);
    }
}
