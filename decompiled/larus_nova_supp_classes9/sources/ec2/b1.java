package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1 extends SettingKey<Long> {
    public static final b1 a = null;

    static {
        a = new b1();
    }

    public b1() {
        super("live_privilege_enter_delay", "他见特权进场的延迟时长单位ms", 3000L, 3000L);
    }
}
