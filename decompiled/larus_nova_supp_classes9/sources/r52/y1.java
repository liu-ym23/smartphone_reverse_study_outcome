package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y1 extends SettingKey<Double> {
    public static final y1 a = null;

    static {
        a = new y1();
    }

    public y1() {
        Double r4 = Double.valueOf(0.25d);
        super("live_performance_min_limit", "实时性能min值", r4, r4, true);
    }
}
