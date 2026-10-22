package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.b81;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s2 extends SettingKey<b81> {
    public static final s2 a = null;

    static {
        s2 r0 = new s2();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public s2() {
        super("live_scroll_switch_item", "直播内流滑动期间切换画面调优", new b81(), new b81());
    }
}
