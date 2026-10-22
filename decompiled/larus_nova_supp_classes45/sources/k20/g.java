package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        BaseResponse r4 = (BaseResponse) r3;
        int r5 = q.a;
        q.f("XplayTerminateService", new Object[]{"on app stop success"});
    }
}
