package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends SettingKey<Boolean> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        Boolean r1 = Boolean.FALSE;
        super("live_dsl_ignore_debug_view", "隐藏dsl debug view", r1, r1);
    }
}
