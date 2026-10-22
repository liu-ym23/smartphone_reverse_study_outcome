package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends SettingKey<Boolean> {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
        Boolean r1 = Boolean.TRUE;
        super("live_carnival_auto_test_enable", "活动功能自动化测试开关", r1, r1);
    }
}
