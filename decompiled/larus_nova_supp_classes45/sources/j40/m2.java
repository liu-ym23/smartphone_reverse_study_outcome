package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m2 extends SettingKey<Boolean> {
    public static final m2 a = null;

    static {
        a = new m2();
    }

    public m2() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_realtime_data_moveto_2nd_player_enable", "房间一期实时特征迁移二期", r1, r1);
    }
}
