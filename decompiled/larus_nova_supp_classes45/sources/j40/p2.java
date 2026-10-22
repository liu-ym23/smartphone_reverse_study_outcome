package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p2 extends SettingKey<Double> {
    public static final p2 a = null;

    static {
        a = new p2();
    }

    public p2() {
        Double r0 = Double.valueOf(-1.0d);
        super("live_scrollable_angle", "直播内流滑动角度调整", r0, r0);
    }
}
