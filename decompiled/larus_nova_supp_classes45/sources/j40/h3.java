package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h3 extends SettingKey<Boolean> {
    public static final h3 a = null;

    static {
        a = new h3();
    }

    public h3() {
        super("live_strategy_setting", "开启 一种支持直播策略平台因子的SettingKey", Boolean.FALSE, Boolean.TRUE);
    }
}
