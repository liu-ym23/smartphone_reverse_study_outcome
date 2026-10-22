package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends SettingKey<Boolean> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Boolean r1 = Boolean.FALSE;
        super("live_block_code_opt", "比较零散的耗时逻辑优化", r1, r1);
    }
}
