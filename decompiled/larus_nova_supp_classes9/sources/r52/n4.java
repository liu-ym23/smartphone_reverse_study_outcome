package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n4 extends SettingKey<Long> {
    public static final n4 a = null;

    static {
        a = new n4();
    }

    public n4() {
        super("live_batch_action_factor_update_interval", "批量刷新消息因子更新间隔", 3000L, 3000L);
    }
}
