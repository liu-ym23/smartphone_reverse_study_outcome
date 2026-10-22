package n7;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends w7.a {
    public final /* synthetic */ com.bytedance.geckox.c d;
    public final /* synthetic */ c e;

    public b(c r5, long r10, com.bytedance.geckox.c r11) {
        this.e = r5;
        this.d = r11;
        super(r10, 0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r5 = this.e;
        if (td.b.f22124a == false) goto L7;
        String r10 = "[" + r5.y() + "]: cool down task run, is back?: false";
        if (td.b.f22124a == false) goto L7;
        Log.i("APM-CPU", r10);
    L7:
        com.bytedance.geckox.c r11 = this.d;
        monitor-enter(r11);
        r11.b((d) r11.e);     // Catch: Throwable -> L12
        monitor-exit(r11);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
