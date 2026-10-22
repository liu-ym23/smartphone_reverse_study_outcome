package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q1 extends SettingKey<Boolean> {
    public static final q1 a = null;

    static {
        a = new q1();
    }

    public q1() {
        Boolean r1 = Boolean.TRUE;
        super("live_open_asset_use_revenue_utils", "装扮开通特效是否走进场下载器", r1, r1);
    }
}
