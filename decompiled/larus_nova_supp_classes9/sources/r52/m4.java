package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m4 extends SSettingKey<Boolean> {
    public static final m4 a = null;

    static {
        a = new m4();
    }

    public m4() {
        Boolean r1 = Boolean.TRUE;
        super("local_gift_intercept", "礼物消息拦截控制", r1, r1);
    }
}
