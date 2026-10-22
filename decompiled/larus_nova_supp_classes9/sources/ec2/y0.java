package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0 extends SettingKey<Integer> {
    public static final y0 a = null;

    public y0() {
        super("live_user_enter_effect_pop_count", "入场冲突处理消息丢弃比例（每条）", 1, 1);
    }

    static {
        a = new y0();
    }
}
