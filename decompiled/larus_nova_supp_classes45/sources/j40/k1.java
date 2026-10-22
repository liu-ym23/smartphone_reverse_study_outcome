package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.DislikeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k1 extends SettingKey<DislikeConfig> {
    public static final k1 a = null;

    static {
        a = new k1();
    }

    public k1() {
        super("live_long_press_dislike", "直播间满意度反馈相关配置", new DislikeConfig(), new DislikeConfig());
    }
}
