package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends SettingKey<String> {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
        super("live_component_strategy_config", "直播组件相关策略集合", BuildConfig.FLAVOR, BuildConfig.FLAVOR, true);
    }
}
