package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends p0 {
    @Override // com.google.common.util.concurrent.p0
    public final boolean a(o r5, c r10, c r11) {
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r5.f9425b != r10) goto L11;
        r5.f9425b = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return false;
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean b(o r5, Object r10, Object r11) {
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r5.f9424a != r10) goto L11;
        r5.f9424a = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return false;
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean c(o r5, n r10, n r11) {
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r5.f9426c != r10) goto L11;
        r5.f9426c = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return false;
    }

    @Override // com.google.common.util.concurrent.p0
    public final c e(o r5) {
        c r10 = c.d;
        monitor-enter(r5);
        c r11 = r5.f9425b;     // Catch: Throwable -> L9
        if (r11 == r10) goto L7;
        r5.f9425b = r10;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.util.concurrent.p0
    public final n f(o r5) {
        n r10 = n.f9421c;
        monitor-enter(r5);
        n r11 = r5.f9426c;     // Catch: Throwable -> L9
        if (r11 == r10) goto L7;
        r5.f9426c = r10;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.util.concurrent.p0
    public final void i(n r5, n r10) {
        r5.f9423b = r10;
    }

    @Override // com.google.common.util.concurrent.p0
    public final void j(n r5, Thread r10) {
        r5.f9422a = r10;
    }
}
