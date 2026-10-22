package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l3 extends SettingKey<Boolean> {
    public static final l3 a = null;

    static {
        a = new l3();
    }

    public l3() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_margin_bottom_processor_strict_mode", "公屏BottomMarginPostProcessor启用严格模式", r1, r1);
    }
}
