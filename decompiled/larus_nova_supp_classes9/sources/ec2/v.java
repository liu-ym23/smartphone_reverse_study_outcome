package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends SettingKey<Boolean> {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
        Boolean r1 = Boolean.FALSE;
        super("live_debug_contour", "画出人像轮廓", r1, r1);
    }
}
