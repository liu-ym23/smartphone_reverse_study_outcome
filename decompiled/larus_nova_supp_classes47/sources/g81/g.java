package g81;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdk.config.UserInfoWidgetDebugConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends SSettingKey<UserInfoWidgetDebugConfig> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        super("live_user_info_widget_debug_config", "左上角主播信息debug配置", new UserInfoWidgetDebugConfig(), new UserInfoWidgetDebugConfig());
    }
}
