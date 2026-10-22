package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m2 extends SettingKey<String> {
    public static final m2 a = null;

    static {
        a = new m2();
    }

    public m2() {
        super("live_public_screen_anchor_dynamic_speed_strategy", "公屏主播侧动态速度策略V2", BuildConfig.FLAVOR, BuildConfig.FLAVOR, false);
    }
}
