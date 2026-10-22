package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t1 extends SettingKey<Boolean> {
    public static final t1 a = null;

    static {
        a = new t1();
    }

    public t1() {
        Boolean r1 = Boolean.TRUE;
        super("live_paid_scope_lazy_init", "付费Scope服务按需加载", r1, r1);
    }
}
