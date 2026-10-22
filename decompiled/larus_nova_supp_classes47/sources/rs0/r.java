package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends SettingKey<Boolean> {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_profile_dialog_memory_leak_enable", "是否修复资料卡面板内存泄漏", r1, r1);
    }
}
