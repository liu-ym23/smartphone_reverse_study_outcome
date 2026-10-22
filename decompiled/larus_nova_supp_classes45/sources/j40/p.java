package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p extends SettingKey<Boolean> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_image_monitor_helper", "移除ImageMonitorHelper", r1, r1);
    }
}
