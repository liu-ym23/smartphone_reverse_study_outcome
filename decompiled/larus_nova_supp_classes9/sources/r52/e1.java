package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 extends SettingKey<Integer> {
    public static final e1 a = null;

    public e1() {
        super("live_message_max_buffer_size_when_dispatch_stop", "直播消息StopDispatch时最大缓存数量", 0, 0);
    }

    static {
        a = new e1();
    }
}
