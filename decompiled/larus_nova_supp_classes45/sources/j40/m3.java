package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m3 extends SettingKey<Boolean> {
    public static final m3 a = null;

    static {
        a = new m3();
    }

    public m3() {
        Boolean r1 = Boolean.TRUE;
        super("live_switch_button_no_barriar", "继承LiveSwitchButton的View无障碍适配", r1, r1);
    }
}
