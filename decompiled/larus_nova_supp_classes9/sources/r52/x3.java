package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x3 extends SettingKey<Boolean> {
    public static final x3 a = null;

    static {
        a = new x3();
    }

    public x3() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_use_custom_item_animator", "公屏是否使用自定义ItemAnimator", r1, r1);
    }
}
