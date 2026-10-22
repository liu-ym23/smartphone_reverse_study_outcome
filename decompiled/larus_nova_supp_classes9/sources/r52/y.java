package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends SettingKey<Integer> {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
        super("live_component_strategy_experiment", "组件加载策略实验", 0, 0, true);
    }
}
