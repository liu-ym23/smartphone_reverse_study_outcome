package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends SettingKey<Boolean> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_public_screen_ai_agent_open_setting_pad", "ai经纪人在pad端点击时打开设置面板", r1, r1);
    }
}
