package hf;

import com.bytedance.geckox.logger.GeckoLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f17307b;

    public /* synthetic */ b(c r5, int r10) {
        this.f17306a = r10;
        this.f17307b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f17306a;
        c r10 = this.f17307b;
        switch(r5) {
            case 0: goto L30;
            default: goto L28;
        };
    L28:
    L7:
        th = move-exception;
        GeckoLogger.b("download onSuccess exception: " + th.getMessage());
        return;
    L5:
        if (r10.e == null) goto L9;
        r10.f.getPack();     // Catch: Throwable -> L7
    L9:
        Iterator r11 = pa.b.f21323a.iterator();     // Catch: Throwable -> L7
    L10:
        if (r11.hasNext() == false) goto L34;
        pa.a r12 = (pa.a) r11.next();     // Catch: Throwable -> L7
        r10.f.getPack();     // Catch: Throwable -> L7
        r12.getClass();     // Catch: Throwable -> L7
        goto L10
    L34:
        return;
    L30:
    L19:
        th = move-exception;
        GeckoLogger.b("download onFailed exception: " + th.getMessage());
        return;
    L17:
        if (r10.e == null) goto L21;
        r10.f.getPack();     // Catch: Throwable -> L19
    L21:
        Iterator r13 = pa.b.f21323a.iterator();     // Catch: Throwable -> L19
    L22:
        if (r13.hasNext() == false) goto L35;
        pa.a r14 = (pa.a) r13.next();     // Catch: Throwable -> L19
        r10.f.getPack();     // Catch: Throwable -> L19
        r14.getClass();     // Catch: Throwable -> L19
        goto L22
    }
}
