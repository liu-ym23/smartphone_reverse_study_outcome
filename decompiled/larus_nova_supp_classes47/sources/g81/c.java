package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends SSettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_components_inner_subload", "组件内部分批加载", r1, r1);
    }
}
