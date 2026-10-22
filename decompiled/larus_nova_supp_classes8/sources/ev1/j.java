package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends SettingKey<Integer> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        super("live_ecommerce_nickname_count", "电商直播间昵称长度字数", 8, 8);
    }
}
