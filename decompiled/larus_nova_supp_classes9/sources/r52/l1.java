package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l1 extends SettingKey<Boolean> {
    public static final l1 a = null;

    static {
        a = new l1();
    }

    public l1() {
        Boolean r1 = Boolean.FALSE;
        super("live_my_live_avatar_show_privilege_status", "我的直播头像入口是否展示特权状态", r1, r1);
    }
}
