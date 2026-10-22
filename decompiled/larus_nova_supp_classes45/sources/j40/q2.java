package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q2 extends SettingKey<Boolean> {
    public static final q2 a = null;

    static {
        a = new q2();
    }

    public q2() {
        Boolean r1 = Boolean.TRUE;
        super("live_scrollable_angle_offset", "直播内流滑动角度热区调整开关", r1, r1);
    }
}
