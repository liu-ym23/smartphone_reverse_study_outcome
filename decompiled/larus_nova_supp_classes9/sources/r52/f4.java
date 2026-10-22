package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f4 extends SettingKey<Boolean> {
    public static final f4 a = null;

    static {
        a = new f4();
    }

    public f4() {
        Boolean r1 = Boolean.FALSE;
        super("live_text_message_log_msg_trace", "直播间公屏区的消息链路日志开关", r1, r1);
    }
}
