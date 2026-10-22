package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q3 extends SettingKey<Boolean> {
    public static final q3 a = null;

    static {
        a = new q3();
    }

    public q3() {
        Boolean r1 = Boolean.TRUE;
        super("live_touch_conflict", "直播内流滑动冲突", r1, r1);
    }
}
