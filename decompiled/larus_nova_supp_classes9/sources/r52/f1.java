package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 extends SettingKey<Integer> {
    public static final f1 a = null;

    public f1() {
        super("live_message_replay_buffer_size", "直播消息支持replay", 0, 0);
    }

    static {
        a = new f1();
    }
}
