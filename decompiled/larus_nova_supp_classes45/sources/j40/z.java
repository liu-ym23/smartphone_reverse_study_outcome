package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends SettingKey<Boolean> {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
        Boolean r1 = Boolean.TRUE;
        super("live_enter_effect_use_lynx_player", "是否启用Lynx的进场特效", r1, r1);
    }
}
