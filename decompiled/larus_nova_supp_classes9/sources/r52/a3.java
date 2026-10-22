package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a3 extends SettingKey<Boolean> {
    public static final a3 a = null;

    static {
        a = new a3();
    }

    public a3() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_enable_focus_when_move", "公屏上划停止自动滚动开关", r1, r1);
    }
}
