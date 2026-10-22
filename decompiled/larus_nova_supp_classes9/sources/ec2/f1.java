package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 extends SettingKey<Boolean> {
    public static final f1 a = null;

    static {
        a = new f1();
    }

    public f1() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_full_screen_judge_opt", "公屏判断满屏条件优化开关", r1, r1);
    }
}
