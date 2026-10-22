package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends SettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.FALSE;
        super("disable_enter_effect_in_pk_mode", "PK场景下是否禁用进场特效", r1, r1);
    }
}
