package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends SettingKey<Boolean> {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
        Boolean r1 = Boolean.TRUE;
        super("live_danmaku_setting_enable", "横屏弹幕模式是否开启弹幕设置开关", r1, r1);
    }
}
