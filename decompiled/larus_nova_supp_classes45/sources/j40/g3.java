package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g3 extends SettingKey<Boolean> {
    public static final g3 a = null;

    static {
        a = new g3();
    }

    public g3() {
        Boolean r1 = Boolean.TRUE;
        super("live_strategy_sdk_enable", "策略SDK是否可用", r1, r1);
    }
}
