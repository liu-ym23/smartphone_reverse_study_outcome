package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 extends SettingKey<Boolean> {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
        Boolean r1 = Boolean.TRUE;
        super("live_input_panel_enable_activity_emoji", "输入面板是否支持活动表情", r1, r1);
    }
}
