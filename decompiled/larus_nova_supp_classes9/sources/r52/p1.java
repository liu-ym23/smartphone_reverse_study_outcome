package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p1 extends SSettingKey<Boolean> {
    public static final p1 a = null;

    static {
        a = new p1();
    }

    public p1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_enable_greeting_anim", "聊天频道打招呼动画开关", r1, r1);
    }
}
