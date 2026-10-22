package r69;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Runnable {
    public /* synthetic */ g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference<u19.f> r0 = i.b;
        u19.f r1 = r0.get();
        if (r1 == null) goto L5;
        r1.dismiss();
    L5:
        g49.d.a("DoraWearToastFactory", "clear toast holder by dismiss");
        r0.set(null);
    }
}
