package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jl extends SSettingKey<String[]> {
    public static final jl a = null;

    static {
        a = new jl();
    }

    public jl() {
        super("live_cloud_game_clear_screen_element_black_list", "直播云游戏清屏功能不生效的element配置", new String[]{"anchorBizPanel"}, new String[]{"anchorBizPanel"});
    }
}
