package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o1 extends SSettingKey<Boolean> {
    public static final o1 a = null;

    static {
        a = new o1();
    }

    public o1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_enable", "边看边聊融合版总开关", r1, r1);
    }
}
