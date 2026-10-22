package ta1;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<T> implements o<T> {
    public final Map<String, String> b;

    public a() {
        this.b = Collections.synchronizedMap(new HashMap());
    }

    public final boolean H() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Map<String, String> getMap() {
        return this.b;
    }

    public final void putAll(Map<String, String> r4) {
        TokenCert r0 = j0.c;
        if (H() == true) goto L5;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.b.putAll(r4);
    }

    public final void remove(String r2) {
        this.b.remove(r2);
    }

    public final void c(String r4, String r5) {
        TokenCert r0 = j0.c;
        if (H() == true) goto L5;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L5:
        this.b.put(r4, r5);
    }
}
