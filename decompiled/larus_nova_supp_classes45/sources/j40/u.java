package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u extends SettingKey<Boolean> {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_team_fight_audio_toolbar", "语音团战toolbar入口开关", r1, r1);
    }
}
