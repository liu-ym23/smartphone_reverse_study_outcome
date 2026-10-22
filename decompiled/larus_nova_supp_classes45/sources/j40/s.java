package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s extends SettingKey<com.bytedance.android.livesdk.config.a3> {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
        super("live_draw_scroll_config", new com.bytedance.android.livesdk.config.a3(), "内流滑动参数调优");
    }
}
