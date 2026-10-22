package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f81 extends SSettingKey<z81> {
    public static final f81 a = null;

    static {
        f81 r0 = new f81();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public f81() {
        super("live_unlogin_scene_guide_config", "未登录用户直播场景引导登录配置", new z81(), new z81());
    }
}
