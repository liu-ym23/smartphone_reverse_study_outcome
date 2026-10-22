package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c2 extends SettingKey<String> {
    public static final c2 a = null;

    static {
        a = new c2();
    }

    public c2() {
        super("live_privacy_room_uid_log_prefix", "隐私直播间上报uid埋点前缀", "webcast_");
    }
}
