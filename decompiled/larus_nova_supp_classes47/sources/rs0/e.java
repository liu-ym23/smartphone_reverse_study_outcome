package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends SettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r1 = Boolean.TRUE;
        super("livesdk_profile_parallax_lynx_enabled", "资料卡Lynx层加载开关", r1, r1);
    }
}
