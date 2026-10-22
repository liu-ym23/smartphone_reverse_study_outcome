package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends SettingKey<Boolean> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_profile_owner_center", "资料卡中是否可展示个人中心", r4, r4, true);
    }
}
