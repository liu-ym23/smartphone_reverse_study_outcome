package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d4 extends SettingKey<Boolean> {
    public static final d4 a = null;

    static {
        a = new d4();
    }

    public d4() {
        Boolean r1 = Boolean.TRUE;
        super("live_panel_user_center_npe_dismiss", "获取userCenter npe时关闭面板", r1, r1);
    }
}
