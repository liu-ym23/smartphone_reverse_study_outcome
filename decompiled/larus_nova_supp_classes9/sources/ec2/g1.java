package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 extends SettingKey<Boolean> {
    public static final g1 a = null;

    static {
        a = new g1();
    }

    public g1() {
        Boolean r1 = Boolean.FALSE;
        super("public_screen_heat_print_test_log", "公屏热度打印测试日志（仅在localtest生效）", r1, r1);
    }
}
