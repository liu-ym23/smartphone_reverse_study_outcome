package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0 extends SSettingKey<Boolean> {
    public static final n0 a = null;

    static {
        a = new n0();
    }

    public n0() {
        Boolean r1 = Boolean.FALSE;
        super("live_interaction_msg_enable_click", "是否开启点击交互", r1, r1);
    }
}
