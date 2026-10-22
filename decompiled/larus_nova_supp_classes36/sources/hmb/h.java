package hmb;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.w;
import uy4.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static synchronized void a(Context r4) {
        monitor-enter(h.class);
        boolean r1 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).isEnable("ccm.resupdate.disable_gecko_download");     // Catch: Throwable -> L7
        StringBuilder r2 = new StringBuilder("useNewResUpdate: ");     // Catch: Throwable -> L7
        r2.append(!r1);     // Catch: Throwable -> L7
        tt5.a.h("ResourceImpl", r2.toString());     // Catch: Throwable -> L7
        if (r1 == false) goto L9;
        w r3 = w.e.a;     // Catch: Throwable -> L7
    L10:
        r3.c(r4);     // Catch: Throwable -> L7
        monitor-exit(h.class);
        return;
    L9:
        r3 = s.a.a;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
