package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u1 extends SettingKey<Boolean> {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
        Boolean r1 = Boolean.TRUE;
        super("ttlive_panel_exception_info_enable", "面板异常信息Id抓捕开关", r1, r1);
    }
}
