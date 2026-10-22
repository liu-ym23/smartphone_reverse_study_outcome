package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x2 extends SettingKey<Boolean> {
    public static final x2 a = null;

    static {
        a = new x2();
    }

    public x2() {
        Boolean r1 = Boolean.FALSE;
        super("live_strategy_async_log_setting", "策略SDK发送异步log", r1, r1);
    }
}
