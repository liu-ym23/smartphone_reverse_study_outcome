package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t1 extends SSettingKey<Boolean> {
    public static final t1 a = null;

    static {
        a = new t1();
    }

    public t1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_greeting_enable", "边看边聊融合版打个招呼开关", r1, r1);
    }
}
