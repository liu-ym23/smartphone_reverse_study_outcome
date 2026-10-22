package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g3 extends SettingKey<Long> {
    public static final g3 a = null;

    static {
        a = new g3();
    }

    public g3() {
        super("live_public_screen_history_first_fetch_timeout", "公屏历史评论首刷接口超时", 3000L, 3000L);
    }
}
