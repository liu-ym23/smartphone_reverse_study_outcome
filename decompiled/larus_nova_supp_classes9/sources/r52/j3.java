package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j3 extends SettingKey<Boolean> {
    public static final j3 a = null;

    static {
        a = new j3();
    }

    public j3() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_ignore_shrink_notify", "公屏高度变小时，不调用notify方法", r1, r1);
    }
}
