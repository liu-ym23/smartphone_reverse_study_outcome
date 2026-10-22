package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n2 extends SettingKey<Boolean> {
    public static final n2 a = null;

    static {
        a = new n2();
    }

    public n2() {
        Boolean r1 = Boolean.FALSE;
        super("live_saas_toolbar_interact_entrance_enable", "直播 saas 完全同构适配是否展示互动 toolbar 入口, 不影响非 saas", r1, r1);
    }
}
