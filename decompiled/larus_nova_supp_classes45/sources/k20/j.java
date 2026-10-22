package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        int r5 = q.a;
        q.f("XplayTerminateService", new Object[]{"on game_stop success"});
    }
}
