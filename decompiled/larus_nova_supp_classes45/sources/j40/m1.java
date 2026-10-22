package j40;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m1 extends SSettingKey<Boolean> {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
        Boolean r1 = Boolean.TRUE;
        super("live_mini_game_image_load_fix", "小玩法子线程加载图片修复", r1, r1);
    }
}
