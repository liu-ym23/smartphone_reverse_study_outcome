package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1 extends SettingKey<Integer> {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
        super("live_message_display_track_interval", "公屏区消息展现上报埋点时间间隔", 60, 60);
    }
}
