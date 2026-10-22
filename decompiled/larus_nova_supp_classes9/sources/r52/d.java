package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends SettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r4 = Boolean.FALSE;
        super("live_anchor_contour_enable", "主播端人像算法是否开启", r4, r4, true);
    }
}
