package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends SettingKey<Boolean> {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
        Boolean r1 = Boolean.TRUE;
        super("live_danmaku_invalidate_after_render", "弹幕render完后invalidate", r1, r1);
    }
}
