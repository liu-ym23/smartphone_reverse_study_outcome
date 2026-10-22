package i2;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        e.f8116l.removeCallbacksAndMessages(null);
        e.a r8 = e.f8120p;
        if (r8 != null) goto L5;
        boolean r10 = a8.e.f121a;
    L9:
        e.f8115k.quit();
        e.f8108d = null;
        return;
    L5:
        CopyOnWriteArrayList<a8.a> r11 = a8.e.f123c;
        monitor-enter(r11);
        r11.remove(r8);     // Catch: Throwable -> L11
        b.f8089k.getClass();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
