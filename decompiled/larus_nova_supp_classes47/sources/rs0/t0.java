package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 extends SettingKey<Boolean> {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
        Boolean r1 = Boolean.TRUE;
        super("live_unified_head_border", "加载统一头像框配置", r1, r1);
    }
}
