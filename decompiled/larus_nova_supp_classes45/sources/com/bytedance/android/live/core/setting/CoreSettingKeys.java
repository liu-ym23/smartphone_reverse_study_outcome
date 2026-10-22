package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface CoreSettingKeys {
    public static final SettingKey<Boolean> APPLOG_CORE_V3_ONLY = null;
    public static final SettingKey<zy.a[]> COUNTRY_CODE_LIST = null;
    public static final SettingKey<Integer> ENABLE_ALOG = null;
    public static final SettingKey<Integer> ENABLE_CUSTOM_TTPLAYER = null;
    public static final SettingKey<Integer> ENABLE_MONITOR_TO_ALOG = null;
    public static final SettingKey<Integer> ENABLE_NEW_CHAT_NAME = null;
    public static final SettingKey<Integer> IMAGE_DOWNLOAD_THREAD_SIZE = null;
    public static final SettingKey<Boolean> LIFT_CHAT_RESTRICTION = null;
    public static final SettingKey<com.bytedance.android.live.base.model.feed.a> LIVE_FEED_PRELOAD = null;
    public static final SettingKey<Integer> MAX_CACHE_ASHM_ENTRIES = null;
    public static final SettingKey<Integer> MAX_CACHE_ENTRIES = null;
    public static final SettingKey<Integer> MAX_CACHE_EVICTION_ENTRIES = null;
    public static final SettingKey<Integer> PROFILE_DOWNLOAD_STYLE = null;
    public static final SettingKey<String> REGION = null;
    public static final SettingKey<String> SHARE_DESC_SUFFIX = null;
    public static final SettingKey<String> SHARE_DESC_SUFFIX_URL = null;
    public static final SettingKey<Integer> TEST_FAKE_REGION = null;
    public static final SettingKey<String> TRACKING_CUSTOM_UA = null;

    static {
        Boolean r1 = Boolean.FALSE;
        APPLOG_CORE_V3_ONLY = new SettingKey("applog_core_v3_only", r1, "推荐用核心埋点只发V3", new String[]{"false:双发", "true:只发V3"});
        PROFILE_DOWNLOAD_STYLE = new SettingKey("profile_download_style", 0, "我的 tab 是否显示下载任务", new String[]{"0: 不显示", "1: 显示"});
        ENABLE_NEW_CHAT_NAME = new SettingKey("enable_im_new_name", 0, "私信改名为聊天", new String[]{"0:私信", "1:聊天"});
        LIFT_CHAT_RESTRICTION = new SettingKey("ichat_restrict_range", r1, "是否放开私信开关", new String[]{"true:表示放开限制，关注就能发私信", "false:表示互关才能发私信"});
        COUNTRY_CODE_LIST = new SettingKey("country_code_maps", zy.a[].class, "国家码下发");
        REGION = new SettingKey("region", "");
        IMAGE_DOWNLOAD_THREAD_SIZE = new SettingKey("image_download_thread_size", 8);
        ENABLE_ALOG = new SettingKey("enable_alog", 0, "是否开启ALOG回捞", new String[]{"0:不开启", "1:开启"});
        ENABLE_MONITOR_TO_ALOG = new SettingKey("enable_monitor_to_alog", 0, "是否开启monitor日志输出到ALog", new String[]{"0:默认开启", "1:不开启"});
        ENABLE_CUSTOM_TTPLAYER = new SettingKey("enable_custom_ttplayer", 1, "选择礼物播放器的实现方式", new String[]{"0:使用TTVideoEngine", "1:使用自定义的TTMediaPlayer"});
        MAX_CACHE_EVICTION_ENTRIES = new SettingKey("fresco_mem", 100);
        MAX_CACHE_ASHM_ENTRIES = new SettingKey("MAX_CACHE_ASHM_ENTRIES", 128);
        MAX_CACHE_ENTRIES = new SettingKey("MAX_CACHE_ENTRIES", 2000);
        SHARE_DESC_SUFFIX = new SettingKey("share_desc_suffix", "");
        SHARE_DESC_SUFFIX_URL = new SettingKey("share_desc_suffix_url", "");
        TRACKING_CUSTOM_UA = new SettingKey("tracking_custom_ua_format", "", "自定义 UA");
        TEST_FAKE_REGION = new SettingKey("fake_regions", 0, "local_test fake国家", new String[]{"0:中国", "1:摩洛哥", "2:沙特阿拉伯", "3:法国", "4:阿联酋"}).setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
        LIVE_FEED_PRELOAD = new SettingKey("live_feed_preload", "feed load more配置", new com.bytedance.android.live.base.model.feed.a(), new com.bytedance.android.live.base.model.feed.a());
    }
}
