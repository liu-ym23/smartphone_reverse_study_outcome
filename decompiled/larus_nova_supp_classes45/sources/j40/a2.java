package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a2 extends SettingKey<LivePostClientSequenceConfig> {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
        super("live_post_client_sequence_config", "客户端实时特征序列上报配置", new LivePostClientSequenceConfig(), new LivePostClientSequenceConfig());
    }
}
