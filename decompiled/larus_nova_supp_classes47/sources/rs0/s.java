package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends SettingKey<Boolean> {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_profile_launcher_memory_leak_enable", "是否修复资料卡launcher内存泄漏", r1, r1);
    }
}
