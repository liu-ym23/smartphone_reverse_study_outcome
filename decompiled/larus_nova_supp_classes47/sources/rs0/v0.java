package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0 extends SettingKey<Boolean> {
    public static final v0 a = null;

    static {
        a = new v0();
    }

    public v0() {
        Boolean r4 = Boolean.FALSE;
        super("live_user_profile_request_retrofit_opt", "user/profile接口retrofit优化", r4, r4, true);
    }
}
