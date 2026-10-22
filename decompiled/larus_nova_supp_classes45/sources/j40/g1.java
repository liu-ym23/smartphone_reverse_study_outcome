package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g1 extends SettingKey<Boolean> {
    public static final g1 a = null;

    static {
        a = new g1();
    }

    public g1() {
        super("live_landscape_sensor_enable", "直播间横屏状态下是否适配重力感应", Boolean.FALSE, Boolean.TRUE, true);
    }
}
