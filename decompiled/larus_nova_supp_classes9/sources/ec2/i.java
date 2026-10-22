package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends SettingKey<Integer> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        super("live_message_voice_comment_duration", "直播间语音评论配置", 15, 15);
    }
}
