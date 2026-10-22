package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1 extends SettingKey<Integer> {
    public static final a1 a = null;

    public a1() {
        super("live_privilege_danmaku_emoji_limit", "特权弹幕emoji数量限制", 3, 3);
    }

    static {
        a = new a1();
    }
}
