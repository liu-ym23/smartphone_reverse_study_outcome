package iv8;

import android.os.SystemClock;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ BrowserCdpClient a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ BrowserCdpClient.k e;
    public final /* synthetic */ long f;

    public /* synthetic */ s(BrowserCdpClient r1, int r2, int r3, int r4, BrowserCdpClient.k r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BrowserCdpClient r1 = this.a;
        int r2 = this.b;
        int r3 = this.c;
        int r0 = this.d;
        BrowserCdpClient.k r5 = this.e;
        long r6 = this.f;
        Object r4 = r1.m;
        monitor-enter(r4);
        String r8 = r5.b;     // Catch: Throwable -> L29
        if (r8 != null) goto L9;
        monitor-exit(r4);
        return;
    L9:
        if (r1.l.get(Integer.valueOf(r3)) == r5) goto L11;
    L27:
        monitor-exit(r4);
        return;
    L11:
        if (r5.c != r1.h.get()) goto L27;
        if (r1.w(r8, r2) == false) goto L27;
        if (SystemClock.elapsedRealtime() >= r6) goto L27;
        int r9 = r1.f.getAndIncrement();     // Catch: Throwable -> L29
        Set<Integer> r10 = r5.f;     // Catch: Throwable -> L29
        if (r10 == null) goto L20;
        r10.add(Integer.valueOf(r9));     // Catch: Throwable -> L29
    L20:
        r1.l.put(Integer.valueOf(r9), r5);     // Catch: Throwable -> L29
        monitor-exit(r4);
        FLogger.a.i("BrowserCdpClient", "client=" + r1.o + " generation=" + r2 + " event=page_enable_retry originalId=" + r3 + " id=" + r9 + " attempt=" + r0);
        JSONObject r7 = new JSONObject().put("id", r9).put("method", "Page.enable").put("params", new JSONObject());
        Intrinsics.checkNotNull(r7);
        if (r1.d0(r9, "Page.enable", r7, r5) == true) goto L25;
        return;
    L25:
        if (r0 >= 4) goto L35;
        r1.d.postDelayed(new s(r1, r2, r3, r0 + 1, r5, r6), 1000);
        return;
    L35:
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
