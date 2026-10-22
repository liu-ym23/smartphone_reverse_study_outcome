package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k1 extends SettingKey<Boolean> {
    public static final k1 a = null;

    static {
        a = new k1();
    }

    public k1() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_camera_vr_enable", "VR多机位", r1, r1);
    }
}
