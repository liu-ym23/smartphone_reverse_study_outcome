package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n2 extends SettingKey<Integer> {
    public static final n2 a = null;

    static {
        a = new n2();
    }

    public n2() {
        super("live_public_screen_anchor_fold_buffer_size", "公屏主播侧折叠消息缓存量", 32, 32);
    }
}
