package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r0 extends SettingKey<Boolean> {
    public static final r0 a = null;

    static {
        a = new r0();
    }

    public r0() {
        Boolean r1 = Boolean.TRUE;
        super("live_interactivity_performance_enable", "互动性能埋点上报", r1, r1);
    }
}
