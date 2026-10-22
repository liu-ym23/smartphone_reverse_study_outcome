package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends SettingKey<Boolean> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        Boolean r1 = Boolean.FALSE;
        super("live_sample_room_for_degrade_config", "直播极简模式低端机", r1, r1);
    }
}
