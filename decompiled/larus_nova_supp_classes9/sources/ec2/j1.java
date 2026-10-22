package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j1 extends SettingKey<Boolean> {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
        Boolean r1 = Boolean.FALSE;
        super("live_render_opt", "直播绘制优化", r1, r1);
    }
}
