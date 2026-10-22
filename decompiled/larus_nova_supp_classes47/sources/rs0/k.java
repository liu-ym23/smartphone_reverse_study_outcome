package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends SettingKey<Boolean> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_mystery_blacklist", "主播资料卡屏蔽拉黑神秘人", r1, r1);
    }
}
