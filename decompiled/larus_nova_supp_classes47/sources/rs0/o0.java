package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 extends SettingKey<Boolean> {
    public static final o0 a = null;

    static {
        a = new o0();
    }

    public o0() {
        Boolean r1 = Boolean.FALSE;
        super("live_profile_self_group_opt", "公开群列表优化", r1, r1);
    }
}
