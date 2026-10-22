package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends SettingKey<o72.b> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        super("live_cold_room_message_config", "低热直播间判断条件", new o72.b(), new o72.b());
    }
}
