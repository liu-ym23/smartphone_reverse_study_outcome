package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 extends SettingKey<Long> {
    public static final g1 a = null;

    static {
        a = new g1();
    }

    public g1() {
        super("live_message_replay_max_duration", "直播消息支持replay的最长时间", 0L, 0L);
    }
}
