package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p3 extends SettingKey<Boolean> {
    public static final p3 a = null;

    static {
        a = new p3();
    }

    public p3() {
        Boolean r1 = Boolean.FALSE;
        super("live_tool_bar_load_opt", "LiveToolbarWidget加载耗时优化", r1, r1);
    }
}
