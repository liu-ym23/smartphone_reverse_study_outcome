package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends SettingKey<Boolean> {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
        Boolean r4 = Boolean.FALSE;
        super("live_enable_perform_accessibility", "在非无障碍模式下，关注按钮被点击了的日志上报兜底开关", r4, r4, true);
    }
}
