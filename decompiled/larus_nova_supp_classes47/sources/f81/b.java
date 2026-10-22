package f81;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import j40.b1;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    @JvmStatic
    public static final boolean b() {
        return ((e51) b1.a.getValue()).h();
    }

    static {
    }

    @JvmStatic
    public static final boolean a(Room r2) {
        if (r2 == null) goto L12;
        StreamUrl r3 = r2.getStreamUrl();
        if (r3 == null) goto L12;
        int r4 = r3.getStreamOrientation();
        if (r4 <= 0) goto L12;
        if (r4 != 2) goto L16;
        return true;
    L16:
        return false;
    L12:
        ILivePlayerClient r5 = LivePlatformPlayerManager.f();
        if (r5 != null) goto L15;
        return false;
    L15:
        return r5.isVideoHorizontal();
    }
}
