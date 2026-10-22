package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.j31;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0 extends SettingKey<j31> {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
        super("live_fresco_config_key", "fresco图片库缓存key优化", new j31(), new j31());
    }
}
