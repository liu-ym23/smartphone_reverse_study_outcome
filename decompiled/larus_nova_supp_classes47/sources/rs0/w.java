package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends SettingKey<Boolean> {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
        Boolean r1 = Boolean.FALSE;
        super("live_profile_mock_ability_enable", "是否开启资料卡Mock能力", r1, r1);
    }
}
