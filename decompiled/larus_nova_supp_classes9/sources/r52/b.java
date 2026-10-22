package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends SettingKey<Long> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        super("live_ai_action_factor_update_interval", "ai回复因子更新间隔", 3000L, 3000L);
    }
}
