package com.lynx.tasm;

import android.os.Debug;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n0 {
    public static final n0 c = null;
    public final Set<a> a;
    public f0 b;

    public static final class a extends WeakReference<t0> {
        public final int a;

        public final int hashCode() {
            return this.a;
        }

        public a(t0 r1) {
            super(r1);
            this.a = System.identityHashCode(r1);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L8;
            return false;
        L8:
            t0 r1 = get();
            t0 r5 = ((a) r4).get();
            if (r1 == null) goto L12;
            if (r1 != r5) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        c = new n0();
    }

    public static long a() {
        Debug.MemoryInfo r2 = new Debug.MemoryInfo();     // Catch: Throwable -> L6
        Debug.getMemoryInfo(r2);     // Catch: Throwable -> L6
        return Math.max(0, r2.getTotalPss()) * 1024;
    L6:
        th = move-exception;
        LLog.e("LynxMemoryCollector", "Failed to sample app memory usage: " + th.getMessage());
        return 0;
    }

    public n0() {
        this.a = ConcurrentHashMap.newKeySet();
    }
}
