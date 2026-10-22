package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a2 extends SettingKey<Float> {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
        Float r0 = Float.valueOf(0.85f);
        super("live_popup_perf_optimize_hide_percent", "面板对比公屏高度百分比", r0, r0);
    }
}
