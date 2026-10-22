package yn0;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements l81.k {
    public static final k a = null;

    public k() {
    }

    static {
        a = new k();
    }

    public final ILivePlayerClient getCurrentClient() {
        return LivePlatformPlayerManager.f();
    }
}
