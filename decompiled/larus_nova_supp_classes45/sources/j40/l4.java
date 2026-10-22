package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l4 extends SettingKey<Integer> {
    public static final l4 a = null;

    public l4() {
        super("live_red_dot_show_count", 3, "黄点规范，展示n次数后消失，0代表仅展示不会消失");
    }

    static {
        a = new l4();
    }
}
