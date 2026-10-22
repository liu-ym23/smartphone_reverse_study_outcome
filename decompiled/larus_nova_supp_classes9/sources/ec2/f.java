package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends SettingKey<Boolean> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_emoji_comment", "是否开启表情评论", r1, r1);
    }
}
