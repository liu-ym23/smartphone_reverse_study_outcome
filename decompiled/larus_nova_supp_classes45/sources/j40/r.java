package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends SettingKey<Boolean> {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
        Boolean r1 = Boolean.TRUE;
        super("live_douyin_status_bar_config", "抖音直播间状态栏与主端保持一致", r1, r1);
    }
}
