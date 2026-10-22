package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w2 extends SettingKey<Integer> {
    public static final w2 a = null;

    static {
        a = new w2();
    }

    public w2() {
        super("live_public_screen_audience_list_buffer_size", "公屏观众侧平铺消息缓存量", 100, 100);
    }
}
