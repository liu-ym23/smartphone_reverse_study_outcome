package com.ctc.wstx.d;

import com.ctc.wstx.exc.WstxIOException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Writer f3503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3504b;
    final boolean c;
    final boolean d;
    int e;
    int f;

    public void a(char r2) {
        if (this.e > 0) goto L10;
        return;
    L10:
        this.f3503a.write(r2);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new WstxIOException(e);
    }

    public void a(int r2) {
        this.e++;
        this.f = r2;
    }

    public void a(String r2) {
        if (this.e > 0) goto L10;
        return;
    L10:
        this.f3503a.write(r2);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new WstxIOException(e);
    }

    public void a(char[] r4, int r5) {
        int r0 = this.f;
        if (r0 < r5) goto L5;
        return;
    L5:
        if (this.e > 0) goto L13;
    L11:
        this.f = r5;
        return;
    L13:
        this.f3503a.write(r4, r0, r5 - r0);     // Catch: IOException -> L8
    L8:
        e = move-exception;
        throw new WstxIOException(e);
    }

    public boolean a() {
        return this.f3504b;
    }

    public void b(int r1) {
        this.f = r1;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public void d() {
        this.e--;
    }
}
