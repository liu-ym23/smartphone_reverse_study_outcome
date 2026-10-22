package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e2 extends SettingKey<Boolean> {
    public static final e2 a = null;

    static {
        a = new e2();
    }

    public e2() {
        Boolean r1 = Boolean.TRUE;
        super("ttlive_public_screen_edge_enable_offscreen_render", "公屏区礼物托盘遮罩启用离屏渲染", r1, r1);
    }
}
