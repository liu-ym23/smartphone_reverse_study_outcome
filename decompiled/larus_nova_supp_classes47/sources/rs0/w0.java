package rs0;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.profile.api.setting.models.ProfileLoginGuideConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w0 extends SettingKey<ProfileLoginGuideConfig> {
    public static final w0 a = null;

    static {
        a = new w0();
    }

    public w0() {
        super("login_guide_config", "登录配置", new ProfileLoginGuideConfig(), new ProfileLoginGuideConfig());
    }
}
