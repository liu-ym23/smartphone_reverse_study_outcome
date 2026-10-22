package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 extends SettingKey<Boolean> {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_carnival_monitor", "狂欢监控开关", r1, r1);
    }
}
