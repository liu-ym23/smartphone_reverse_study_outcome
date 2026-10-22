package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends SSettingKey<Boolean> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Boolean r1 = Boolean.FALSE;
        super("live_user_profile_enable_carousel", "房间标题和主播名字轮播", r1, r1);
    }
}
