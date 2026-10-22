package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends SettingKey<Boolean> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        Boolean r1 = Boolean.FALSE;
        super("live_fans_count_format_enable", "粉丝数格式化开关", r1, r1);
    }
}
