package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 extends SettingKey<Boolean> {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
        Boolean r4 = Boolean.TRUE;
        super("live_user_card_honor_wall_show", "荣誉墙展示判断非电商和生服", r4, r4, true);
    }
}
