package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommentTopicConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f2 extends SettingKey<PSHighlightCommentTopicConfig> {
    public static final f2 a = null;

    static {
        a = new f2();
    }

    public f2() {
        super("live_ps_highlight_comment_topic_config", "公屏强调区话题配置", new PSHighlightCommentTopicConfig(), new PSHighlightCommentTopicConfig(), true);
    }
}
