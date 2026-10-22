package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 extends SettingKey<Boolean> {
    public static final c1 a = null;

    static {
        a = new c1();
    }

    public c1() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_degrade_config", "公屏区动画性能降级", r1, r1);
    }
}
