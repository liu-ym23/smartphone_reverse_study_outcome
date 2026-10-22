package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z1 extends SettingKey<Boolean> {
    public static final z1 a = null;

    static {
        a = new z1();
    }

    public z1() {
        Boolean r4 = Boolean.TRUE;
        super("live_popup_strategy_setting_enable", "直播气泡管理策略添加功能开关", r4, r4, new String[]{"true:开启", "false:关闭"});
    }
}
