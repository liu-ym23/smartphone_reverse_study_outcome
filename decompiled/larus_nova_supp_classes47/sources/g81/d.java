package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends SSettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_room_indicator_countdown", "房间人气加成倒计时", r1, r1);
    }
}
