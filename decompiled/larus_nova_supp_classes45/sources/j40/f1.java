package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f1 extends SettingKey<Double> {
    public static final f1 a = null;

    static {
        a = new f1();
    }

    public f1() {
        Double r0 = Double.valueOf(-1.0d);
        super("live_landscape_scroll_angle", "直播横屏内流滑动角度调整", r0, r0);
    }
}
