package m61;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends SSettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r1 = Boolean.TRUE;
        super("live_player_seek_normal_room", "看播侧的普通直播间是否支持时移能力", r1, r1);
    }
}
