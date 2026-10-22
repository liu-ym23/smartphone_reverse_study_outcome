package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends SSettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_anchor_info_flip_element", "左上角使用新轮播组件", r1, r1);
    }
}
