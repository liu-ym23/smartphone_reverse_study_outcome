package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends SettingKey<Long> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        super("live_anchor_public_screen_ai_agent_auto_focus_delay", "ai经纪人ai模式手动滚动后默认回到底部时间", 20000L, 20000L);
    }
}
