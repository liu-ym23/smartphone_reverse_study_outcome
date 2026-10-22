package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vn extends SSettingKey<Boolean> {
    public static final vn a = null;

    static {
        a = new vn();
    }

    public vn() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_enter_anchor_identity_param", "关闭进房接口的anchor_identity参数透传", r1, r1);
    }
}
