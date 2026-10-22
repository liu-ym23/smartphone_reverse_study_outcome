package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x1 extends SettingKey<LivePlayerSmoothEnterRoomConfig> {
    public static final x1 a = null;

    static {
        a = new x1();
    }

    public x1() {
        super("live_player_smooth_enter_room", "多人场景预览流播放器平滑进房优化", new LivePlayerSmoothEnterRoomConfig(), new LivePlayerSmoothEnterRoomConfig());
    }
}
