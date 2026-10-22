package ec2;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.s51;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0 extends SettingKey<s51> {
    public static final u0 a = null;

    static {
        a = new u0();
    }

    public u0() {
        super("live_match_message_config", "节目聚合、对抗消息降级配置", new s51(), new s51());
    }
}
