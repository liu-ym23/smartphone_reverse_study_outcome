package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 extends SettingKey<Boolean> {
    public static final k0 a = null;

    static {
        a = new k0();
    }

    public k0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_ps_a11y_opt", "公屏消息无障碍朗读优化", r1, r1);
    }
}
