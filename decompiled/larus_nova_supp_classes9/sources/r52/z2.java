package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z2 extends SettingKey<Boolean> {
    public static final z2 a = null;

    static {
        a = new z2();
    }

    public z2() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_ban_request_focus", "公屏屏蔽requestFocus方法开关", r1, r1);
    }
}
