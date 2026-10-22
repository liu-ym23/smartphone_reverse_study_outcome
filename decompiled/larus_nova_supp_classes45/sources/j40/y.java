package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y extends SettingKey<Boolean> {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
        Boolean r1 = Boolean.TRUE;
        super("live_enter_effect_sync_asset_request_params_fixed", "装扮进场请求assets接口传参问题修复", r1, r1);
    }
}
