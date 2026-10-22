package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 extends SettingKey<Boolean> {
    public static final e1 a = null;

    static {
        a = new e1();
    }

    public e1() {
        Boolean r1 = Boolean.TRUE;
        super("ttlive_public_screen_fading_edge_enable", "公屏区底部遮罩", r1, r1);
    }
}
