package com.obric.miniapp.intent;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public final long a;
    public final long b;
    public final int c;
    public final LinkedHashSet<String> d;
    public String e;
    public String f;
    public long g;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "ScopedState(ownedByCard=" + this.a + ", isPlaying=" + this.b + ", currentId=" + this.c + ')';
        }

        public b(boolean r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "currentId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public t() {
        this.a = 4000;
        this.b = 30000;
        this.c = 128;
        this.d = new LinkedHashSet();
    }

    public final synchronized void a(String r3) {
        monitor-enter(this);
        if (r3 == null) goto L9;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.e, r3) == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.e = null;     // Catch: Throwable -> L12
        this.f = null;     // Catch: Throwable -> L12
        this.g = 0;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized boolean b(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "cardId");     // Catch: Throwable -> L11
        boolean r1 = true;
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        if (Intrinsics.areEqual(this.e, r3) == false) goto L8;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(String r3) {
        if (this.d.add(r3) == true) goto L6;
        return;
    L6:
        if (this.d.size() <= RangesKt.coerceAtLeast(this.c, 1)) goto L11;
        Iterator<String> r4 = this.d.iterator();
        if (r4.hasNext() == false) goto L9;
        r4.next();
        r4.remove();
        goto L6
    L9:
        return;
    }

    public final synchronized void d(String r2, boolean r3, long r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "currentId");     // Catch: Throwable -> L6
        h(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void h(String r2, boolean r3, long r4) {
        String r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L11;
        if (Intrinsics.areEqual(r2, r0) == false) goto L11;
        this.g = 0;
        return;
    L11:
        if (r4 >= this.g) goto L13;
        return;
    L13:
        a(null);
    }

    public final synchronized void c(String r3, String r4, boolean r5, long r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "cardId");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r4, "currentId");     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r3) == false) goto L6;
    L20:
        h(r4, r5, r6);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L6:
        if (StringsKt.isBlank(r4) == true) goto L20;
        if (r5 == false) goto L20;
        if (r6 >= this.g) goto L17;
        String r7 = this.e;     // Catch: Throwable -> L23
        if (r7 == null) goto L17;
        if (Intrinsics.areEqual(r7, r3) == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.e = r3;     // Catch: Throwable -> L23
        this.f = r4;     // Catch: Throwable -> L23
        this.g = 0;     // Catch: Throwable -> L23
        e(r3);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized b f(String r6, String r7, boolean r8, long r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "cardId");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r7, "currentId");     // Catch: Throwable -> L35
        boolean r2 = false;
        if ((!StringsKt.isBlank(r6)) == true) goto L6;
    L8:
        boolean r10 = false;
    L9:
        if (r10 == true) goto L14;
        b r11 = new b(false, false, "");     // Catch: Throwable -> L35
        monitor-exit(this);
        return r11;
    L14:
        if (r9 >= this.g) goto L16;
        boolean r12 = true;
    L17:
        if (r8 == true) goto L19;
    L23:
        boolean r13 = false;
    L25:
        if (r12 == true) goto L27;
        if (r13 == true) goto L27;
    L28:
        if (r12 == false) goto L32;
        r7 = this.f;     // Catch: Throwable -> L35
        if (r7 != null) goto L32;
        r7 = "";
    L32:
        b r14 = new b(true, r2, r7);     // Catch: Throwable -> L35
        monitor-exit(this);
        return r14;
    L27:
        r2 = true;
        goto L28
    L19:
        if ((!StringsKt.isBlank(r7)) == false) goto L23;
        if (Intrinsics.areEqual(r7, this.f) == false) goto L23;
        r13 = true;
        goto L25
    L16:
        r12 = false;
        goto L17
    L6:
        if (Intrinsics.areEqual(this.e, r6) == false) goto L8;
        r10 = true;
    L35:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean g(String r3, String r4, boolean r5, Long r6, long r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "cardId");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r4, "musicId");     // Catch: Throwable -> L25
        if (StringsKt.isBlank(r3) == false) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (StringsKt.isBlank(r4) == true) goto L23;
        if (r5 == false) goto L23;
        if (r6 == null) goto L15;
        long r8 = r7 - r6.longValue();     // Catch: Throwable -> L25
        if ((-5000) > r8) goto L15;
        if (r8 > this.b) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L23;
        if (this.d.contains(r3) == true) goto L23;
        e(r3);     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L15:
        r9 = false;
    L25:
        th = move-exception;
        throw th;
    }
}
