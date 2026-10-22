package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x0 extends SettingKey<Float> {
    public static final x0 a = null;

    static {
        a = new x0();
    }

    public x0() {
        Float r0 = Float.valueOf(450.0f);
        super("live_open_asset_max_width_dp", "开通特效/入场Type9播放时的最大宽度", r0, r0);
    }
}
