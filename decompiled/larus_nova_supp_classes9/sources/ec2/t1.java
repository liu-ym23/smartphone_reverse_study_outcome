package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t1 extends SettingKey<Integer> {
    public static final t1 a = null;

    static {
        a = new t1();
    }

    public t1() {
        super("vslive_comment_scroll_speed", "vs滚动速度配置", 550, 550);
    }
}
