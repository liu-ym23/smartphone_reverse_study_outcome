package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends SettingKey<Integer> {
    public static final q a = null;

    public q() {
        super("live_interest_kp_max_select_count", "最多可以选择几个兴趣kp", 3, 3);
    }

    static {
        a = new q();
    }
}
