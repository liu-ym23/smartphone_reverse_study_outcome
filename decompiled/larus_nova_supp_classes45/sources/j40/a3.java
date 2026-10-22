package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a3 extends SettingKey<Map<String, ? extends Map<String, ? extends String>>> {
    public static final a3 a = null;

    static {
        a = new a3();
    }

    public a3() {
        super("live_strategy_filter_config", "策略埋点过滤配置", new HashMap(), new HashMap());
    }
}
