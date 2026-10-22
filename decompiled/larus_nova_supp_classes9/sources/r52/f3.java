package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f3 extends SettingKey<String> {
    public static final f3 a = null;

    static {
        a = new f3();
    }

    public f3() {
        super("live_public_screen_history_dynamic_load_strategy", "公屏观众侧历史评论动态加载速度策略", BuildConfig.FLAVOR, BuildConfig.FLAVOR, false);
    }
}
