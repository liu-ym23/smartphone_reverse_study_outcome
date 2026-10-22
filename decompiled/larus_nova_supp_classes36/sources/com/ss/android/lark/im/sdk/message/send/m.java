package com.ss.android.lark.im.sdk.message.send;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m {
    public static final Object a = null;
    public static final Map<Long, a> b = null;

    public static final class a {
        public long a;
        public long b;
        public boolean c;
        public final TreeMap<Long, Function0<Unit>> d;

        public a() {
            this(null);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            if (this.c == false) goto L5;
            int r4 = 1231;
        L7:
            return ((r2 + r4) * 31) + this.d.hashCode();
        L5:
            r4 = 1237;
            goto L7
        }

        public final String toString() {
            return "QueueState(nextAssignSeq=" + this.a + ", nextRunSeq=" + this.b + ", draining=" + this.c + ", pending=" + this.d + ')';
        }

        public a(Object r3) {
            TreeMap<Long, Function0<Unit>> r4 = new TreeMap();
            Intrinsics.checkNotNullParameter(r4, "pending");
            this.a = 0;
            this.b = 0;
            this.c = false;
            this.d = r4;
        }
    }

    static {
        a = new Object();
        b = new LinkedHashMap();
    }

    public static void b(long r7) {
    L2:
        Object r0 = a;
        monitor-enter(r0);
        a r1 = (a) ((LinkedHashMap) b).get(Long.valueOf(r7));     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        Function0<Unit> r2 = r1.d.remove(Long.valueOf(r1.b));     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        r1.b++;     // Catch: Throwable -> L16
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        r2.invoke();
        goto L2
    L10:
        r1.c = false;     // Catch: Throwable -> L16
        a(r7, r1);     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L6:
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void a(long r4, a r6) {
        if (r6.c == false) goto L5;
        return;
    L5:
        if (r6.d.isEmpty() == true) goto L7;
        return;
    L7:
        if (r6.b != r6.a) goto L12;
        b.remove(Long.valueOf(r4));
        return;
    }
}
