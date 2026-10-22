package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends SettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.FALSE;
        super("live_ai_auto_reply_msg_show_single_line", "AI回复的消息展示单行的开关", r1, r1);
    }
}
