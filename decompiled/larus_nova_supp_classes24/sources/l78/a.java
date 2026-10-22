package l78;

import c68.b;
import m58.h;
import m58.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static long a;
    public static long b;
    public static long c;
    public static int d;
    public static int e;
    public static String f;
    public static String g;
    public static volatile int h;
    public static volatile int i;
    public static volatile long j;

    static {
        f = "";
        g = "";
    }

    public static long a() {
        if (h > 0) goto L5;
    L11:
        return 0;
    L5:
        if (h != i) goto L11;
        int r0 = b.a;
        b.d("FlowTtsLagTraceHelper", "[onAudioData] stuck happens. stuckCount: " + d + ", chunkStartCount: " + h + ", lastChunkFinishTime: " + j);
        d = d + 1;
        long r1 = System.currentTimeMillis() - j;
        c = c + r1;
        int r2 = e;
        w r3 = h.f;
        if (r3 == null) goto L9;
        int r4 = r3.o();
    L10:
        e = r2 + r4;
        return r1;
    L9:
        r4 = 0;
        goto L10
    }
}
