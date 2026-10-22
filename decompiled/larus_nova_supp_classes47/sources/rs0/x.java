package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends SettingKey<Boolean> {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
        Boolean r1 = Boolean.TRUE;
        super("live_profile_block_anchor_vs_fans_group_at_button", "VS直播间看主播屏蔽第二个按钮", r1, r1);
    }
}
