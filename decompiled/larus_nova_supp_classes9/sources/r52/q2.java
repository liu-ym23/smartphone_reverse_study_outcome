package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q2 extends SettingKey<Boolean> {
    public static final q2 a = null;

    static {
        a = new q2();
    }

    public q2() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_anchor_show_order_message", "主播侧公屏展示下单消息", r1, r1);
    }
}
