package fsb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ b(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        a r1 = new a();     // Catch: Throwable -> L5
        r1.b = System.nanoTime();     // Catch: Throwable -> L5
        r1.a = r0;     // Catch: Throwable -> L5
        r1.d = ((int) (System.nanoTime() - r1.b)) / 1000000;     // Catch: Throwable -> L5
        Statistics.sendEvent("ee_lark_android_page_load", r1.a());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("PageLoadMonitor", "reportTea failed", th);
    }
}
