package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v1 extends SSettingKey<Boolean> {
    public static final v1 a = null;

    static {
        a = new v1();
    }

    public v1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_mention_enable", "边看边聊融合版Mention开关", r1, r1);
    }
}
