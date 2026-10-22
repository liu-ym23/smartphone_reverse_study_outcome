package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d2 extends SettingKey<Boolean> {
    public static final d2 a = null;

    static {
        a = new d2();
    }

    public d2() {
        super("live_use_privilege_danmaku", Boolean.FALSE, "特权弹幕开关");
    }
}
