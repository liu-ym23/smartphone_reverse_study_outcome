package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0 extends SettingKey<Boolean> {
    public static final z0 a = null;

    static {
        a = new z0();
    }

    public z0() {
        Boolean r4 = Boolean.TRUE;
        super("live_pk_mode_contour_enable", "PK模式下是否绘制人像", r4, r4, true);
    }
}
