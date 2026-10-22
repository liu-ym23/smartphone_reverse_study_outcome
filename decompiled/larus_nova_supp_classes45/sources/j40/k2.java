package j40;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k2 extends SSettingKey<Boolean> {
    public static final k2 a = null;

    static {
        a = new k2();
    }

    public k2() {
        Boolean r1 = Boolean.TRUE;
        super("live_resource_balance_opt", "指标资源平衡框架整体优化开关", r1, r1);
    }
}
