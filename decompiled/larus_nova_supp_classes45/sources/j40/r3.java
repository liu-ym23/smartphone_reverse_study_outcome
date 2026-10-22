package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r3 extends SettingKey<LiveUnifyBoxConfig> {
    public static final r3 a = null;

    static {
        a = new r3();
    }

    public r3() {
        super("live_unify_box_setting", "集装箱配置", new LiveUnifyBoxConfig(), new LiveUnifyBoxConfig());
    }
}
