package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1 extends SettingKey<Boolean> {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
        Boolean r1 = Boolean.FALSE;
        super("live_message_support_replay", "直播消息支持replay", r1, r1);
    }
}
