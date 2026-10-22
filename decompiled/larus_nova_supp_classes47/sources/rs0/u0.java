package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u0 extends SettingKey<Boolean> {
    public static final u0 a = null;

    static {
        a = new u0();
    }

    public u0() {
        Boolean r1 = Boolean.FALSE;
        super("live_user_card_ui_adjustment", "用户资料卡UI调整开关", r1, r1);
    }
}
