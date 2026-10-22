package r2;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.chromium.wschannel.TrafficChangedObservable;

/* JADX INFO: loaded from: classes.dex */
public class j extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f12656a;

    public j() {
    }

    public static j a() {
        if (f12656a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12656a != null) goto L9;
        f12656a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f12656a;
    }

    private void b(Map<String, Object> r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(String r10, long r11, long r12, String r13, String r14) {
        HashMap r15 = new HashMap();
        r15.put("url", r10);
        r15.put(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES, Long.valueOf(r11));
        r15.put(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES, Long.valueOf(r12));
        r15.put("content_type", r13);
        r15.put(ICronetClient.KEY_REQUEST_LOG, r14);
        b(r15);
    }
}
