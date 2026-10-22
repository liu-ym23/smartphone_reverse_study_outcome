package rp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        ALogger.d("VSVideoProgressUtil", "leave success");
    }
}
