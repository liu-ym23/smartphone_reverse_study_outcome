package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends SSettingKey<Boolean> {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
        Boolean r1 = Boolean.TRUE;
        super("live_enter_anim_text_v2_support_aggregate", "进场动画text_v2支持聚合", r1, r1);
    }
}
