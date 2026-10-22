package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends SSettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_playback_get_right_enable", "付费回放下发试看视频", r1, r1);
    }
}
