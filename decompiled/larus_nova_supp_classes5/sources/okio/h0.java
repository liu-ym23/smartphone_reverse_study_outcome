package okio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h0 {
    public static final g0 a = null;
    public static final int b = 0;
    public static final AtomicReference<g0>[] c = null;

    static {
        int r7 = 0;
        a = new g0(new byte[0], 0, 0, false, false);
        int r0 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = r0;
        AtomicReference<g0>[] r1 = new AtomicReference[r0];
    L3:
        if (r7 >= r0) goto L5;
        r1[r7] = new AtomicReference();
        r7 = r7 + 1;
        goto L3
    L5:
        c = r1;
    }

    @JvmStatic
    public static final g0 b() {
        int r1 = (int) (ThreadMethodProxy.currentThread().getId() & (((long) b) - 1));
        AtomicReference<g0> r0 = c[r1];
        g0 r2 = a;
        g0 r3 = r0.getAndSet(r2);
        if (r3 != r2) goto L7;
        return new g0();
    L7:
        if (r3 != null) goto L10;
        r0.set(null);
        return new g0();
    L10:
        r0.set(r3.f);
        r3.f = null;
        r3.c = 0;
        return r3;
    }

    @JvmStatic
    public static final void a(g0 r8) {
        Intrinsics.checkNotNullParameter(r8, "segment");
        if (r8.f == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L25;
        if (r8.d == false) goto L12;
        return;
    L12:
        int r1 = (int) (ThreadMethodProxy.currentThread().getId() & (((long) b) - 1));
        AtomicReference<g0> r2 = c[r1];
        g0 r3 = a;
        g0 r4 = r2.getAndSet(r3);
        if (r4 != r3) goto L15;
        return;
    L15:
        if (r4 == null) goto L17;
        int r5 = r4.c;
    L19:
        if (r5 < 65536) goto L22;
        r2.set(r4);
        return;
    L22:
        r8.f = r4;
        r8.b = 0;
        r8.c = r5 + 8192;
        r2.set(r8);
        return;
    L17:
        r5 = 0;
        goto L19
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r8.g != null) goto L7;
        r0 = true;
        goto L8
    }
}
