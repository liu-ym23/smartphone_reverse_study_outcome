package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p1 extends SettingKey<Boolean> {
    public static final p1 a = null;

    static {
        a = new p1();
    }

    public p1() {
        Boolean r1 = Boolean.FALSE;
        super("live_new_panel_switch", "是否使用新面板", r1, r1);
    }
}
