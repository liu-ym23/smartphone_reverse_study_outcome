package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends SettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_perception_of_fans_badge_enable", "主播粉丝看播感知-是否展示朋友/粉丝勋章", r1, r1);
    }
}
