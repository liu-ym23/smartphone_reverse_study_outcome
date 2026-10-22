package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 extends SettingKey<LiveFeatureConfig> {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
        super("live_feature_config", "直播特征包配置", new LiveFeatureConfig(), new LiveFeatureConfig());
    }
}
