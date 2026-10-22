package com.larksuite.framework.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class v<T> {
    public final Object[] a;
    public int b;
    public final Object c;

    public T a(Object... r1) {
        throw null;
    }

    public boolean b(T r1, Object... r2) {
        return true;
    }

    public v(int r2) {
        this.c = new Object();
        this.a = new Object[r2];
        this.b = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T c(Object... r9) {
        Object r0 = this.c;
        monitor-enter(r0);
        int r1 = this.b;     // Catch: Throwable -> L19
        T r2 = null;
        if (r1 <= 0) goto L15;
        int r3 = r1 - 1;     // Catch: Throwable -> L19
        int r4 = r3;
    L7:
        if (r4 < 0) goto L15;
        Object r5 = this.a[r4];     // Catch: Throwable -> L19
        if (b(r5, r9) == true) goto L10;
        r4 = r4 - 1;     // Catch: Throwable -> L19
        goto L7
    L10:
        int r6 = r3 - r4;     // Catch: Throwable -> L19
        if (r6 <= 0) goto L13;
        Object[] r7 = this.a;     // Catch: Throwable -> L19
        System.arraycopy(r7, r4 + 1, r7, r4, r6);     // Catch: Throwable -> L19
    L13:
        this.a[r3] = null;     // Catch: Throwable -> L19
        this.b--;     // Catch: Throwable -> L19
        r2 = (T) r5;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        return r2;
    L18:
        return (T) a(r9);
    L19:
        th = move-exception;
        throw th;
    }

    public final void d(T r7) {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r1 = false;
        int r2 = 0;
    L23:
        int r3 = this.b;     // Catch: Throwable -> L21
        if (r2 >= r3) goto L11;
        if (this.a[r2] == r7) goto L9;
        r2 = r2 + 1;     // Catch: Throwable -> L21
        goto L23
    L9:
        r1 = true;
    L11:
        if (r1 == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L14:
        Object[] r4 = this.a;     // Catch: Throwable -> L21
        if (r3 >= r4.length) goto L17;
        r4[r3] = r7;     // Catch: Throwable -> L21
        this.b = r3 + 1;     // Catch: Throwable -> L21
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
