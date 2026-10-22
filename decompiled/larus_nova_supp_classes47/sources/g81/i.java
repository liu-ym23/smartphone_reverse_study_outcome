package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends SSettingKey<Boolean> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_ec_rank_card_keyboard_show", "修复带货榜键盘展示问题", r1, r1);
    }
}
