package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s1 extends SSettingKey<Integer> {
    public static final s1 a = null;

    static {
        a = new s1();
    }

    public s1() {
        super("live_new_chat_channel_greeting_emoji_show_duration", "打招呼表情展示时长，单位秒", 20, 20);
    }
}
