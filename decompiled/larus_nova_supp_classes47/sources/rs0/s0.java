package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0 extends SettingKey<Boolean> {
    public static final s0 a = null;

    static {
        a = new s0();
    }

    public s0() {
        Boolean r1 = Boolean.TRUE;
        super("live_shop_fans_club_jump_setting", "购物粉丝团开启开关", r1, r1);
    }
}
