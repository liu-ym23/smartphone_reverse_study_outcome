package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends SettingKey<Boolean> {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
        Boolean r1 = Boolean.FALSE;
        super("live_carnival_message_frequncy_debug", "狂欢消息和弹幕频率调试开关", r1, r1);
    }
}
