package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 extends SettingKey<Boolean> {
    public static final e0 a = null;

    static {
        a = new e0();
    }

    public e0() {
        Boolean r1 = Boolean.FALSE;
        super("live_feature_handle_room_clear_real_time_data_enable", "直播策略handle room清除实时特征数据", r1, r1);
    }
}
