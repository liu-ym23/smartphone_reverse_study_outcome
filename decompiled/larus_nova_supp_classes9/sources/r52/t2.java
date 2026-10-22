package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t2 extends SettingKey<String> {
    public static final t2 a = null;

    static {
        a = new t2();
    }

    public t2() {
        super("live_public_screen_audience_dynamic_speed_strategy_v2", "公屏观众侧动态速度策略V2", BuildConfig.FLAVOR, BuildConfig.FLAVOR, false);
    }
}
