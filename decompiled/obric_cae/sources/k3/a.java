package k3;

import android.util.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {
    /* JADX INFO: Infinite loop detected, blocks: 43, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
    L25:
        c r8 = (c) b.f8927b.take();     // Catch: Throwable -> L21
        Iterator r10 = b.f8926a.iterator();     // Catch: Throwable -> L21
    L5:
        if (r10.hasNext() == false) goto L25;
        d r11 = (d) r10.next();     // Catch: Throwable -> L21
    L8:
        if (r8.isValid() == true) goto L9;
        if (t2.b.G() == false) goto L5;
        String r12 = "monitorable invalid. ignored. " + r8;     // Catch: Throwable -> L16
        if (t2.b.G() == false) goto L5;
        Log.w("APM-Monitor", r12);     // Catch: Throwable -> L16
        goto L5
    L9:
        r11.a();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        String r13 = "monitorableHandler " + r11 + " handle monitorable " + r8 + "failed.";     // Catch: Throwable -> L21
        if (t2.b.G() == false) goto L5;
        Log.e("APM-Monitor", r13, th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (t2.b.G() == false) goto L25;
        Log.e("APM", "Oh, Damn it!!!", th);
        goto L25
    }
}
