package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 extends SettingKey<Boolean> {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
        Boolean r1 = Boolean.FALSE;
        super("live_danmaku_add_lottery_setting_config", "是否开启横屏屏蔽福袋弹幕能力", r1, r1);
    }
}
