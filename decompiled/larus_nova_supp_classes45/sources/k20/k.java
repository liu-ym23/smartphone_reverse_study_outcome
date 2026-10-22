package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Consumer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r3) {
        int r0 = q.a;
        q.i((Throwable) r3, "XplayTerminateService", "on game_stop fail");
    }
}
