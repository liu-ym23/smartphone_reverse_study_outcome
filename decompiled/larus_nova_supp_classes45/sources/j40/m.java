package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.CoinConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m extends SettingKey<CoinConfig> {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
        super("live_coin_config", "货币单位", new CoinConfig(), new CoinConfig());
    }
}
