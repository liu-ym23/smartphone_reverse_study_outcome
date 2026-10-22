package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends SSettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_close_live_button_opt", "主播侧关播按钮的优化（调整到右上角）", r1, r1);
    }
}
