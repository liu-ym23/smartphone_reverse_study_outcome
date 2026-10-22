package ku1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends SettingKey<Boolean> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        Boolean r1 = Boolean.FALSE;
        super("live_strategy_write_sp_optimize", "存SP放到异步线程", r1, r1);
    }
}
