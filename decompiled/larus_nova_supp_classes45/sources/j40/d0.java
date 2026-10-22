package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureEventFilterConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 extends SettingKey<LiveFeatureEventFilterConfig> {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
        super("live_feature_event_filter_config", "直播特征包埋点过滤配置", new LiveFeatureEventFilterConfig(), new LiveFeatureEventFilterConfig());
    }
}
