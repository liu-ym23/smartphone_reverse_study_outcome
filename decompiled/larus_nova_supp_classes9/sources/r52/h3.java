package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h3 extends SettingKey<Boolean> {
    public static final h3 a = null;

    static {
        a = new h3();
    }

    public h3() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_history_preload_opt", "公屏历史评论预加载优化v3", r1, r1);
    }
}
