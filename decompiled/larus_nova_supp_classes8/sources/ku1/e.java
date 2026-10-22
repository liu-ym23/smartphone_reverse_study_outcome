package ku1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends SettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r1 = Boolean.FALSE;
        super("live_strategy_response_use_pb", "策略中心Feature接口返回PB原数据", r1, r1);
    }
}
