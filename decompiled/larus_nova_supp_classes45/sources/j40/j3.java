package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j3 extends SettingKey<Boolean> {
    public static final j3 a = null;

    static {
        a = new j3();
    }

    public j3() {
        Boolean r1 = Boolean.FALSE;
        super("live_strategy_update_report_enable", "策略平台监听日志上报", r1, r1);
    }
}
