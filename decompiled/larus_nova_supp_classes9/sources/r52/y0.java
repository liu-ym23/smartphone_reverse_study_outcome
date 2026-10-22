package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0 extends SettingKey<String> {
    public static final y0 a = null;

    static {
        a = new y0();
    }

    public y0() {
        super("live_danmaku_dynamic_speed_strategy", "横屏接入动态策略", BuildConfig.FLAVOR, BuildConfig.FLAVOR, false);
    }
}
