package uga;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public final String a;
    public final Object b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;

    public final boolean c() {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.f == true) goto L10;
        this.f = true;     // Catch: Throwable -> L12
        if (this.c == true) goto L10;
        r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        this.a = r2;
        this.b = new Object();
    }

    public final void a(boolean r4) {
        Object r0 = this.b;
        monitor-enter(r0);
        if (r4 == false) goto L19;
    L17:
        monitor-exit(r0);
        return;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f == true) goto L17;
        int r5 = this.e + 1;     // Catch: Throwable -> L14
        this.e = r5;     // Catch: Throwable -> L14
        if (r5 >= RangesKt.coerceAtLeast(3, 1)) goto L11;
        this.d = false;     // Catch: Throwable -> L14
    L11:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    public final boolean b(boolean r4) {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r1 = false;
        if (r4 == true) goto L19;
    L17:
        monitor-exit(r0);
        return r1;
    L19:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f == true) goto L17;
        this.c = true;     // Catch: Throwable -> L14
        if (this.d == true) goto L17;
        this.d = true;     // Catch: Throwable -> L14
        r1 = true;
        goto L17
    }
}
