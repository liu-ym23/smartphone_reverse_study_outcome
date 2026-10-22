package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s2 extends SettingKey<com.bytedance.android.livesdk.interactivity.api.settings.config.j0> {
    public static final s2 a = null;

    static {
        s2 r0 = new s2();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s2() {
        int r0 = com.bytedance.android.livesdk.interactivity.api.settings.config.j0.a;
        super("live_public_screen_audience_dynamic_speed_config_v2", "公屏观众侧动态速度配置V2", com.bytedance.android.livesdk.interactivity.api.settings.config.j0.a.a(), com.bytedance.android.livesdk.interactivity.api.settings.config.j0.a.a());
    }
}
