package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w3 extends SettingKey<Boolean> {
    public static final w3 a = null;

    static {
        a = new w3();
    }

    public w3() {
        Boolean r1 = Boolean.FALSE;
        super("live_vs_alog_opt", "高频alog优化", r1, r1);
    }
}
