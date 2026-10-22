package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r0 extends SettingKey<Boolean> {
    public static final r0 a = null;

    static {
        a = new r0();
    }

    public r0() {
        Boolean r1 = Boolean.TRUE;
        super("live_inner_layout_sei_cache", "布局sei缓存", r1, r1);
    }
}
