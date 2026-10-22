package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface PerformanceTestSettings {
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_BANNER = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_BARRAGE = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_CAMERA_CAPTURE = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_COMMENT_AREA = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_DIGG = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_DOUBLE_COLOR_BALL = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_EFFECT = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_ENTER_ANIM = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_INTERACTION = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_LIVE_CORE = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_LIVE_PLAYER = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_LONG_TOUCH = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_NORMAL_GIFT = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_NOTIFY = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_PUSH_STREAM = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_SHORT_TOUCH = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_STREAM_PREVIEW = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VIDEO_GIFT = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_BOTTOM = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_DANMU = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_DIGG = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_INTERACTION = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_INTERACTIVE = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_LOADING = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_PLAYER = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_DISABLE_VS_EPISODE_RIGHT_BANNER = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_ENTER_DURATION_OUTPUT = null;
    public static final PerformanceTestSettingKey<Boolean> TEST_LOCAL_MEMORY_ANALYSE_SWITCH = null;
    public static final PerformanceTestSettingKey<Integer> TEST_PK_MIX_CONFIG = null;
    public static final PerformanceTestSettingKey<Integer> TEST_SCREEN_BRIGHTNESS = null;
    public static final PerformanceTestSettingKey<m81> TEST_STREAM_CONFIG = null;

    static {
        Boolean r1 = Boolean.FALSE;
        TEST_DISABLE_PUSH_STREAM = new PerformanceTestSettingKey("test_disable_push_stream", "屏蔽推流", r1, r1);
        TEST_DISABLE_STREAM_PREVIEW = new PerformanceTestSettingKey("test_disable_stream_preview", "屏蔽预览", r1, r1);
        TEST_DISABLE_CAMERA_CAPTURE = new PerformanceTestSettingKey("test_disable_camera_capture", "屏蔽采集", r1, r1);
        TEST_DISABLE_LIVE_CORE = new PerformanceTestSettingKey("test_disable_live_core", "屏蔽LiveCore", r1, r1);
        TEST_DISABLE_LIVE_PLAYER = new PerformanceTestSettingKey("test_disable_live_player", "屏蔽播放器", r1, r1);
        TEST_DISABLE_EFFECT = new PerformanceTestSettingKey("test_disable_effect", "屏蔽effect", r1, r1);
        TEST_STREAM_CONFIG = new PerformanceTestSettingKey("test_stream_config", "推流配置", new m81(), new m81());
        TEST_SCREEN_BRIGHTNESS = new PerformanceTestSettingKey("test_screen_brightness", "屏幕亮度", -1, -1);
        TEST_DISABLE_VIDEO_GIFT = new PerformanceTestSettingKey("test_disable_video_gift", "屏蔽大礼物", r1, r1);
        TEST_DISABLE_INTERACTION = new PerformanceTestSettingKey("test_disable_interaction", "屏蔽交互层", r1, r1);
        TEST_DISABLE_COMMENT_AREA = new PerformanceTestSettingKey("test_disable_comment_area", "屏蔽消息区", r1, r1);
        TEST_DISABLE_BARRAGE = new PerformanceTestSettingKey("test_disable_barrage", "屏蔽弹幕", r1, r1);
        TEST_DISABLE_ENTER_ANIM = new PerformanceTestSettingKey("test_disable_enter_anim", "屏蔽入场动画", r1, r1);
        TEST_DISABLE_NORMAL_GIFT = new PerformanceTestSettingKey("test_disable_normal_gift", "屏蔽小礼物", r1, r1);
        TEST_DISABLE_NOTIFY = new PerformanceTestSettingKey("test_disable_notify", "屏蔽全服广播", r1, r1);
        TEST_DISABLE_DIGG = new PerformanceTestSettingKey("test_disable_digg", "屏蔽飘赞", r1, r1);
        TEST_DISABLE_SHORT_TOUCH = new PerformanceTestSettingKey("test_disable_short_touch", "屏蔽短触区", r1, r1);
        TEST_DISABLE_LONG_TOUCH = new PerformanceTestSettingKey("test_disable_long_touch", "屏蔽长触区", r1, r1);
        TEST_DISABLE_BANNER = new PerformanceTestSettingKey("test_disable_banner", "屏蔽活动banner", r1, r1);
        TEST_DISABLE_DOUBLE_COLOR_BALL = new PerformanceTestSettingKey("test_disable_double_color_ball", "屏蔽双色球", r1, r1);
        TEST_PK_MIX_CONFIG = new PerformanceTestSettingKey("test_pk_mix_config", "PK合流配置, 0:端；1:server", -1, -1);
        TEST_ENTER_DURATION_OUTPUT = new PerformanceTestSettingKey("test_enter_duration_output", "输出进房耗时分段时间", r1, r1);
        TEST_DISABLE_VS_EPISODE_INTERACTION = new PerformanceTestSettingKey("test_disable_vs_episode_interaction", "屏蔽vs录播交互层", r1, r1);
        TEST_DISABLE_VS_EPISODE_PLAYER = new PerformanceTestSettingKey("test_disable_vs_episode_player", "屏蔽vs录播播放器", r1, r1);
        TEST_DISABLE_VS_EPISODE_DANMU = new PerformanceTestSettingKey("test_disable_rvs_episode_danmu", "屏蔽vs录播弹幕", r1, r1);
        TEST_DISABLE_VS_EPISODE_DIGG = new PerformanceTestSettingKey("test_disable_vs_episode_digg", "屏蔽vs录播点赞", r1, r1);
        TEST_DISABLE_VS_EPISODE_LOADING = new PerformanceTestSettingKey("test_disable_vs_episode_loading", "屏蔽vs录播loading", r1, r1);
        TEST_DISABLE_VS_EPISODE_RIGHT_BANNER = new PerformanceTestSettingKey("test_disable_vs_episode_right_banner", "屏蔽vs录播右侧banner", r1, r1);
        TEST_DISABLE_VS_EPISODE_INTERACTIVE = new PerformanceTestSettingKey("test_disable_vs_episode_interactive", "屏蔽vs录播互动组件", r1, r1);
        TEST_DISABLE_VS_EPISODE_BOTTOM = new PerformanceTestSettingKey("test_disable_vs_episode_bottom", "屏蔽vs录播底部话题", r1, r1);
        Boolean r2 = Boolean.TRUE;
        TEST_LOCAL_MEMORY_ANALYSE_SWITCH = new PerformanceTestSettingKey("test_local_memory_analyse_switch", "retal debug包内存泄漏检测", r2, r2);
    }
}
