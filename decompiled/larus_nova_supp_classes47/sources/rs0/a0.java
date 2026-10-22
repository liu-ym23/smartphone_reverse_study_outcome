package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 extends SettingKey<Integer> {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
        super("live_profile_component_cost_sampling", "资料卡组件耗时监控上报tea采样0-10000", 10, 10);
    }
}
