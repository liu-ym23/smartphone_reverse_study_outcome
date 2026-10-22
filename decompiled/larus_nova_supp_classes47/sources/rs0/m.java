package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends SettingKey<Boolean> {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
        Boolean r4 = Boolean.FALSE;
        super("live_enable_profile_fans_group_create", "资料卡中是否可展示粉丝群管理和创建", r4, r4, true);
    }
}
