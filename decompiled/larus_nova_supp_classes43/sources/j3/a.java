package j3;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final int a;
    public final long b;
    public final ArrayDeque<Long> c;

    public static boolean a(a r10) {
        long r0 = System.currentTimeMillis();
        monitor-enter(r10);
        long r11 = r0 - r10.b;     // Catch: Throwable -> L18
    L6:
        if ((!r10.c.isEmpty()) == false) goto L11;
        if (r10.c.peekFirst().longValue() > r11) goto L11;
        r10.c.pollFirst();     // Catch: Throwable -> L18
    L11:
        if (r10.c.size() < r10.a) goto L14;
        monitor-exit(r10);
        return true;
    L14:
        r10.c.addLast(Long.valueOf(r0));     // Catch: Throwable -> L18
        monitor-exit(r10);
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    public a(int r1, long r10) {
        this.a = r1;
        this.b = r10;
        this.c = new ArrayDeque();
    }
}
