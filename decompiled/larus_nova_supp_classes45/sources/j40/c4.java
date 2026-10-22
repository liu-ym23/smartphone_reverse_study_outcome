package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c4 extends SettingKey<Boolean> {
    public static final c4 a = null;

    static {
        a = new c4();
    }

    public c4() {
        Boolean r1 = Boolean.TRUE;
        super("live_panel_user_center_npe", "获取userCenter npe问题修复", r1, r1);
    }
}
