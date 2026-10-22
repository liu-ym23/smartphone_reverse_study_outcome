package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z3 extends SettingKey<VSOptimizeConfig> {
    public static final z3 a = null;

    static {
        a = new z3();
    }

    public z3() {
        super("live_vs_optimize_config", "节目直播体验优化", new VSOptimizeConfig(), new VSOptimizeConfig());
    }
}
