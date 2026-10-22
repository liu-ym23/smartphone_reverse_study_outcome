package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 extends SettingKey<Integer> {
    public static final d0 a = null;

    public d0() {
        super("live_input_activity_emoji_max_count", "输入框内最多存在多少个活动表情", 3, 3);
    }

    static {
        a = new d0();
    }
}
