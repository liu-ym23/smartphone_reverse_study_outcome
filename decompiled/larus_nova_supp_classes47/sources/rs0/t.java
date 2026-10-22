package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends SettingKey<Boolean> {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_singing_record_ab_config", "KTV演唱沉淀AB实验", r1, r1);
    }
}
