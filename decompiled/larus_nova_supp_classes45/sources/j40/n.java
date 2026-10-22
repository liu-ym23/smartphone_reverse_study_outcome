package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n extends SettingKey<CommunityFoldFixConfig> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
        super("live_community_fold_fix_config", "折叠屏修复适配社区配置", new CommunityFoldFixConfig(), new CommunityFoldFixConfig());
    }
}
