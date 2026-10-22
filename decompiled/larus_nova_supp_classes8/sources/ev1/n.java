package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends SettingKey<Boolean> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
        Boolean r4 = Boolean.FALSE;
        super("more_panel_enable_follower_share", "更多面板推荐按钮", r4, r4, false);
    }
}
