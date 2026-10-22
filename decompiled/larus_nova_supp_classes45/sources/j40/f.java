package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends SettingKey<LivePreviewWormholePredictConfig> {
    public static final f a = null;

    static {
        f r0 = new f();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public f() {
        super("live_ai_preview_wormhole_config", "直播端智能外流预拉流配置", new LivePreviewWormholePredictConfig(), new LivePreviewWormholePredictConfig());
    }
}
