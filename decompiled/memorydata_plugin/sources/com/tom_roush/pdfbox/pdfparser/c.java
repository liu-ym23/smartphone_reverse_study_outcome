package com.tom_roush.pdfbox.pdfparser;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
class c extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16133b;
    private int c;
    private boolean d;

    c(OutputStream r1) {
        super(r1);
        this.f16132a = false;
        this.f16133b = false;
        this.c = 0;
        this.d = true;
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f16132a == true) goto L6;
    L8:
        this.f16132a = false;     // Catch: Throwable -> L11
        this.f16133b = false;     // Catch: Throwable -> L11
        super.flush();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.f16133b == true) goto L8;
        super.write(13);     // Catch: Throwable -> L11
        this.c++;     // Catch: Throwable -> L11
        goto L8
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r8, int r9, int r10) {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (this.c != 0) goto L20;
        if (r10 <= 10) goto L20;
        this.d = false;     // Catch: Throwable -> L48
        int r0 = 0;
    L7:
        if (r0 >= 10) goto L20;
        if (r8[r0] < 9) goto L18;
        if (r8[r0] <= 10) goto L17;
        if (r8[r0] >= 32) goto L17;
        if (r8[r0] != 13) goto L18;
    L17:
        r0 = r0 + 1;     // Catch: Throwable -> L48
    L18:
        this.d = true;     // Catch: Throwable -> L48
    L20:
        if (this.d == true) goto L22;
    L45:
        super.write(r8, r9, r10);     // Catch: Throwable -> L48
        this.c += r10;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L22:
        if (this.f16132a == false) goto L32;
        this.f16132a = false;     // Catch: Throwable -> L48
        if (this.f16133b == true) goto L30;
        if (r10 != 1) goto L30;
        if (r8[r9] != 10) goto L30;
        monitor-exit(this);
        return;
    L30:
        super.write(13);     // Catch: Throwable -> L48
    L32:
        if (this.f16133b == false) goto L34;
        super.write(10);     // Catch: Throwable -> L48
        this.f16133b = false;     // Catch: Throwable -> L48
    L34:
        if (r10 <= 0) goto L45;
        int r1 = (r9 + r10) - 1;     // Catch: Throwable -> L48
        if (r8[r1] != 13) goto L39;
    L37:
        this.f16132a = true;     // Catch: Throwable -> L48
        r10 = r10 - 1;     // Catch: Throwable -> L48
        goto L45
    L39:
        if (r8[r1] != 10) goto L45;
        this.f16133b = true;     // Catch: Throwable -> L48
        r10 = r10 - 1;     // Catch: Throwable -> L48
        if (r10 <= 0) goto L45;
        if (r8[(r9 + r10) - 1] != 13) goto L45;
        goto L45
    }
}
