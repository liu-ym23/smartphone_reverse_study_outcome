package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k3 extends SettingKey<Boolean> {
    public static final k3 a = null;

    static {
        a = new k3();
    }

    public k3() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_lite_interaction_enable", "公屏轻交互框架开关", r1, r1);
    }
}
