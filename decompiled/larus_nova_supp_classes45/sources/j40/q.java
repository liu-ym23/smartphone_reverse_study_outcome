package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q extends SettingKey<Boolean> {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
        Boolean r4 = Boolean.TRUE;
        super("live_display_text_view_invalidate", "高级消息是否开启刷新", r4, r4, false);
    }
}
