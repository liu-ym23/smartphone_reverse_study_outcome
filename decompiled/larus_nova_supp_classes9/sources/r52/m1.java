package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1 extends SettingKey<Boolean> {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
        Boolean r1 = Boolean.FALSE;
        super("live_my_live_enabled", "打开当前用户的资料卡展示我的直播", r1, r1);
    }
}
