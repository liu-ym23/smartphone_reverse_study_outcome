package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0 extends SettingKey<Boolean> {
    public static final k0 a = null;

    static {
        a = new k0();
    }

    public k0() {
        Boolean r1 = Boolean.FALSE;
        super("live_follow_anchorself_enable", "主播观看自己直播间，不展示关注按钮", r1, r1);
    }
}
