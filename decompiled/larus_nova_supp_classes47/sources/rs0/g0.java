package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 extends SettingKey<Boolean> {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
        Boolean r1 = Boolean.TRUE;
        super("live_profile_horizontal_no_change_level", "横屏不修改层级", r1, r1);
    }
}
