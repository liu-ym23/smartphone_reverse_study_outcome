package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 extends SettingKey<Boolean> {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
        Boolean r4 = Boolean.TRUE;
        super("live_external_force_remove_container", "强制移除容器", r4, r4, true);
    }
}
