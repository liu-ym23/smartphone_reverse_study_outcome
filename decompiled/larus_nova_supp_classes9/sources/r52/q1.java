package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q1 extends SSettingKey<Boolean> {
    public static final q1 a = null;

    static {
        a = new q1();
    }

    public q1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_extend_height_enable", "边看边聊融合版高度扩展开关", r1, r1);
    }
}
