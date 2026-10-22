package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1 extends SettingKey<Integer> {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
        super("live_user_enter_queue_max_count", "飘屏消息新逻辑队列最大长度", 100, 100);
    }
}
