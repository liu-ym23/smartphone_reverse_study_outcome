package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g4 extends SettingKey<Integer> {
    public static final g4 a = null;

    static {
        a = new g4();
    }

    public g4() {
        super("live_text_widget_scroll_speed", "设置评论区默认滑动速度", 100, 100);
    }
}
