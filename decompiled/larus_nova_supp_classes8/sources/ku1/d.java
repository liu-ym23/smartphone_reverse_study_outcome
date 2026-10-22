package ku1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends SettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r1 = Boolean.TRUE;
        super("live_strategy_clear_pb", "策略中心Feature接口返回PB原数据", r1, r1);
    }
}
