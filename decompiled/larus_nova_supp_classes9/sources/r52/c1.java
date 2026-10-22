package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 extends SettingKey<Long> {
    public static final c1 a = null;

    static {
        a = new c1();
    }

    public c1() {
        super("live_mention_msg_show_factor_update_interval", "mention消息展示因子更新间隔，单位ms", 3000L, 3000L);
    }
}
