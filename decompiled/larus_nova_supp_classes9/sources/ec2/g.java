package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends SettingKey<Integer> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        super("hot_live_message_size", "高热直播间消息数", 80, 80);
    }
}
