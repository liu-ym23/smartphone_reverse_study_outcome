package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends SSettingKey<Boolean> {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
        Boolean r1 = Boolean.TRUE;
        super("live_ignore_comment_arg_illegal_check_intercept", "跳过评论非法参数检测", r1, r1);
    }
}
