package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends SSettingKey<Boolean> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_card_show_debounce", "修复卡片重复展示时被隐藏的bug", r1, r1);
    }
}
