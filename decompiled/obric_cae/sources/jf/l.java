package jf;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f8852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f8853b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8855n;

    public l(r r8, Inflater r10) {
        this.f8852a = r8;
        this.f8853b = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f8855n == false) goto L5;
        return;
    L5:
        this.f8853b.end();
        this.f8855n = true;
        this.f8852a.close();
    }

    @Override // jf.w
    public final x timeout() {
        return this.f8852a.timeout();
    }

    @Override // jf.w
    public final long u(d r8, long r10) {
        if (r10 < 0) goto L52;
        if (this.f8855n == true) goto L50;
        if (r10 != 0) goto L8;
        return 0;
    L8:
        Inflater r11 = this.f8853b;
        boolean r12 = r11.needsInput();
        f r13 = this.f8852a;
        if (r12 == false) goto L21;
        int r14 = this.f8854m;
        if (r14 == 0) goto L16;
        int r15 = r14 - r11.getRemaining();
        this.f8854m -= r15;
        r13.skip(r15);
    L16:
        if (r11.getRemaining() != 0) goto L48;
        if (r13.U() == false) goto L20;
        boolean r16 = true;
    L53:
        s r17 = r8.C(1);     // Catch: DataFormatException -> L44
        int r18 = r11.inflate(r17.f8870a, r17.f8872c, (int) Math.min(r10, 8192 - r17.f8872c));     // Catch: DataFormatException -> L44
        if (r18 > 0) goto L24;
        if (r11.finished() == true) goto L35;
        if (r11.needsDictionary() == true) goto L35;
        if (r16 == false) goto L8;
        throw new EOFException("source exhausted prematurely");     // Catch: DataFormatException -> L44
    L35:
        int r19 = this.f8854m;     // Catch: DataFormatException -> L44
        if (r19 == 0) goto L40;
        int r20 = r19 - r11.getRemaining();     // Catch: DataFormatException -> L44
        this.f8854m -= r20;     // Catch: DataFormatException -> L44
        r13.skip(r20);     // Catch: DataFormatException -> L44
    L40:
        if (r17.f8871b != r17.f8872c) goto L59;
        r8.f8829a = r17.a();     // Catch: DataFormatException -> L44
        t.a(r17);     // Catch: DataFormatException -> L44
        return -1;
    L59:
        return -1;
    L24:
        r17.f8872c += r18;     // Catch: DataFormatException -> L44
        long r21 = r18;
        r8.f8830b += r21;     // Catch: DataFormatException -> L44
        return r21;
    L44:
        e = move-exception;
        throw new IOException(e);
    L20:
        s r22 = r13.b().f8829a;
        int r23 = r22.f8872c;
        int r24 = r22.f8871b;
        int r25 = r23 - r24;
        this.f8854m = r25;
        r11.setInput(r22.f8870a, r24, r25);
        goto L21
    L48:
        throw new IllegalStateException("?");
    L21:
        r16 = false;
        goto L53
    L50:
        throw new IllegalStateException("closed");
    L52:
        throw new IllegalArgumentException(android.aimedia.a.d("byteCount < 0: ", r10));
    }
}
