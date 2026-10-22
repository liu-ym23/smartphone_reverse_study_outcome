package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j1 extends SettingKey<Boolean> {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_camera_extend_enable", "多机位能力", r1, r1);
    }
}
