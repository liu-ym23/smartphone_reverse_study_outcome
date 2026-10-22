package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k2 extends SSettingKey<Boolean> {
    public static final k2 a = null;

    static {
        a = new k2();
    }

    public k2() {
        Boolean r1 = Boolean.TRUE;
        super("live_ai_clone_enable", "ai进公屏功能总开关", r1, r1);
    }
}
