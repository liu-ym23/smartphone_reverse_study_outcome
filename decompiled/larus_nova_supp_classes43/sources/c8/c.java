package c8;

import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Runnable {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ b b;

    public c(c0 r1, b r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimeLineEvent.b r0 = new TimeLineEvent.b();     // Catch: Throwable -> L4
        r0.c();     // Catch: Throwable -> L4
        r0.a = "label_pre_call_origin_url";     // Catch: Throwable -> L4
        TimeLineEvent r1 = new TimeLineEvent(r0, null);     // Catch: Throwable -> L4
        ((CopyOnWriteArrayList) this.a.k).add(r1);     // Catch: Throwable -> L4
        this.b.i(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
