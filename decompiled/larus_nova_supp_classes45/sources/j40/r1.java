package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r1 extends SettingKey<Boolean> {
    public static final r1 a = null;

    static {
        a = new r1();
    }

    public r1() {
        Boolean r1 = Boolean.FALSE;
        super("ttlive_pad_opt_disable_control", "兜底关掉直播pad优化的开关，默认关着的，打开了就回滚", r1, r1);
    }
}
