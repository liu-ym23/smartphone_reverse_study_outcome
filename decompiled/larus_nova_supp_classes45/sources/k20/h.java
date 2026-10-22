package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        int r0 = q.a;
        q.i((Throwable) r3, "XplayTerminateService", "on app stop fail");
    }
}
