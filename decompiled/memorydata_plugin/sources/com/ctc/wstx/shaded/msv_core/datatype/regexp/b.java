package com.ctc.wstx.shaded.msv_core.datatype.regexp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes2.dex */
final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f3560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f3561b;
    int c;
    CharacterIterator d;
    String e;
    char[] f;

    public b() {
        this.f3560a = null;
        this.f3561b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public void a(int r4) {
        int r0 = this.c;
        this.c = r4;
        if (r0 <= 0) goto L7;
        if (r0 < r4) goto L7;
        if ((r4 * 2) < r0) goto L7;
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r4) goto L11;
        this.f3560a[r1] = -1;
        this.f3561b[r1] = -1;
        r1 = r1 + 1;
        goto L9
    L11:
        return;
    L7:
        this.f3560a = new int[r4];
        this.f3561b = new int[r4];
        goto L8
    }

    public void a(int r1, int r2) {
        this.f3560a[r1] = r2;
    }

    public void a(String r2) {
        this.d = null;
        this.e = r2;
        this.f = null;
    }

    public void a(CharacterIterator r3) {
        this.d = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        this.e = null;
        this.f = null;
    }

    public void a(char[] r2) {
        this.d = null;
        this.e = null;
        this.f = r2;
    }

    public int b(int r4) {
        int[] r0 = this.f3560a;
        if (r0 == null) goto L12;
        if (r4 < 0) goto L10;
        if (this.c <= r4) goto L10;
        return r0[r4];
    L10:
        throw new IllegalArgumentException("The parameter must be less than " + this.c + ": " + r4);
    L12:
        throw new IllegalStateException("A result is not set.");
    }

    public void b(int r1, int r2) {
        this.f3561b[r1] = r2;
    }

    public int c(int r4) {
        int[] r0 = this.f3561b;
        if (r0 == null) goto L12;
        if (r4 < 0) goto L10;
        if (this.c <= r4) goto L10;
        return r0[r4];
    L10:
        throw new IllegalArgumentException("The parameter must be less than " + this.c + ": " + r4);
    L12:
        throw new IllegalStateException("A result is not set.");
    }

    public synchronized Object clone() {
        monitor-enter(this);
        b r0 = new b();     // Catch: Throwable -> L18
        int r1 = this.c;     // Catch: Throwable -> L18
        if (r1 <= 0) goto L16;
        r0.a(r1);     // Catch: Throwable -> L18
        CharacterIterator r2 = this.d;     // Catch: Throwable -> L18
        if (r2 == null) goto L8;
        r0.a(r2);     // Catch: Throwable -> L18
    L8:
        String r3 = this.e;     // Catch: Throwable -> L18
        if (r3 == null) goto L11;
        r0.a(r3);     // Catch: Throwable -> L18
    L11:
        int r4 = 0;
    L12:
        if (r4 >= this.c) goto L16;
        r0.a(r4, b(r4));     // Catch: Throwable -> L18
        r0.b(r4, c(r4));     // Catch: Throwable -> L18
        r4 = r4 + 1;
    L16:
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }
}
