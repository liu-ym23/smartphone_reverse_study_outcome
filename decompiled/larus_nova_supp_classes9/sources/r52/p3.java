package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p3 extends SettingKey<Boolean> {
    public static final p3 a = null;

    static {
        a = new p3();
    }

    public p3() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_post_processor_enable", "公屏宽高调整启用PostProcessor", r1, r1);
    }
}
