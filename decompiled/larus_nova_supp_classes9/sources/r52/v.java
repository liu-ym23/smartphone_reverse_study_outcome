package r52;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends SettingKey<Long> {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
        Long r0 = Long.valueOf(RiskAdviseSyncData.PRIORITY);
        super("live_comment_action_factor_update_interval", "发评因子更新间隔", r0, r0);
    }
}
