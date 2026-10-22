package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends SettingKey<fv1.c> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        super("live_force_degrade_config", "直播间强制降级", new fv1.c(), new fv1.c(), true);
    }
}
