package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h1 extends SettingKey<Boolean> {
    public static final h1 a = null;

    static {
        a = new h1();
    }

    public h1() {
        Boolean r1 = Boolean.FALSE;
        super("live_message_start_before_room_enter", "直播消息建连在进房之前", r1, r1);
    }
}
