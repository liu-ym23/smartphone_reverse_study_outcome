package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o1 extends SettingKey<Boolean> {
    public static final o1 a = null;

    static {
        a = new o1();
    }

    public o1() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_gift_score_interact_view", "麦位礼物分值是否使用新的互动view兜底开关", r1, r1);
    }
}
