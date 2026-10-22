package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 extends SSettingKey<Boolean> {
    public static final v0 a = null;

    static {
        a = new v0();
    }

    public v0() {
        Boolean r1 = Boolean.TRUE;
        super("live_message_log_link_mic_enable", "评论信息内是否包含多人连麦信息", r1, r1);
    }
}
