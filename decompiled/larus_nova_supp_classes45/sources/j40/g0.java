package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 extends SettingKey<Boolean> {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
        Boolean r1 = Boolean.FALSE;
        super("live_feature_handle_room_report_opt_enable", "直播特征handle room上报优化", r1, r1);
    }
}
