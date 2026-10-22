package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h2 extends SettingKey<Boolean> {
    public static final h2 a = null;

    static {
        a = new h2();
    }

    public h2() {
        Boolean r1 = Boolean.FALSE;
        super("live_relative_layout_measure_opt", "RelativeLayout measure 优化", r1, r1);
    }
}
