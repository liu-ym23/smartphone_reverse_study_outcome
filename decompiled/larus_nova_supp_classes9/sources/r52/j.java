package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends SettingKey<Boolean> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_public_screen_ai_message_enable_audio", "电台模式是否开启公屏助手", r1, r1);
    }
}
