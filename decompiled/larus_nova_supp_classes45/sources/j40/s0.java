package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0 extends SettingKey<Boolean> {
    public static final s0 a = null;

    static {
        a = new s0();
    }

    public s0() {
        Boolean r1 = Boolean.TRUE;
        super("live_inner_linked_background_enable", "锁链直播间内流支持换肤", r1, r1);
    }
}
