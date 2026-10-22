package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u2 extends SettingKey<Integer> {
    public static final u2 a = null;

    static {
        a = new u2();
    }

    public u2() {
        super("live_public_screen_audience_fold_buffer_size", "公屏观众侧折叠消息缓存量", 32, 32);
    }
}
