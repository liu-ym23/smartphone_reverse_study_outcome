package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x2 extends SettingKey<Boolean> {
    public static final x2 a = null;

    static {
        a = new x2();
    }

    public x2() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_audience_show_order_message", "看播侧公屏展示下单消息", r1, r1);
    }
}
