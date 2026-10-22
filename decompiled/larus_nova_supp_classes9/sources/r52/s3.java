package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s3 extends SettingKey<Boolean> {
    public static final s3 a = null;

    static {
        a = new s3();
    }

    public s3() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_show_new_hot_msg_tray", "公屏展示新热评托盘开关", r1, r1);
    }
}
