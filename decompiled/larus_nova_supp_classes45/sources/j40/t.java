package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.o11;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends SettingKey<o11> {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
        super("live_draw_touch_event_opt", "touch相关埋点优化", new o11(), new o11());
    }
}
