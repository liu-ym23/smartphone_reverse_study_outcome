package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u1 extends SSettingKey<Boolean> {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_hide_gift_enable", "边看边聊融合版屏蔽礼物开关", r1, r1);
    }
}
