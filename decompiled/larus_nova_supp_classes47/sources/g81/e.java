package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends SSettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r1 = Boolean.TRUE;
        super("live_top_right_row_4_th_placeholder_listen_clear", "TopRightRow4thPlaceHolder是否监听清屏", r1, r1);
    }
}
