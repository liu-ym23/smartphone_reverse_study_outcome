package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.settings.config.LiveAnchorTopicConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends SettingKey<LiveAnchorTopicConfig> {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
        super("live_anchor_topic_config", "主播侧话题挂载需求开关", new LiveAnchorTopicConfig(), new LiveAnchorTopicConfig(), true);
    }
}
