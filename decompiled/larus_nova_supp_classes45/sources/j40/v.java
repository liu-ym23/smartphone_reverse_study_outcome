package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v extends SettingKey<Boolean> {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_loading_new_animation", "直播是否使用新的双色球动画", r1, r1);
    }
}
