package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveAudioTagConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends SettingKey<LiveAudioTagConfig> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        super("live_audiotag_config", "直播audiotag配置", new LiveAudioTagConfig(), new LiveAudioTagConfig());
    }
}
