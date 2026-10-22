package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x1 extends SettingKey<Double> {
    public static final x1 a = null;

    static {
        a = new x1();
    }

    public x1() {
        Double r4 = Double.valueOf(0.55d);
        super("live_performance_max_limit", "实时性能max值", r4, r4, true);
    }
}
