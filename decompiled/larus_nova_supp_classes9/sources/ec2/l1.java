package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l1 extends SettingKey<Boolean> {
    public static final l1 a = null;

    static {
        a = new l1();
    }

    public l1() {
        Boolean r1 = Boolean.FALSE;
        super("live_user_enter_debug_log", "飘屏消息新排队逻辑调试日志开关", r1, r1);
    }
}
