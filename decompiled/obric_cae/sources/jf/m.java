package jf;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OutputStream f8857b;

    public m(OutputStream r8, x r10) {
        this.f8856a = r10;
        this.f8857b = r8;
    }

    @Override // jf.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8857b.close();
    }

    @Override // jf.v, java.io.Flushable
    public final void flush() {
        this.f8857b.flush();
    }

    @Override // jf.v
    public final x timeout() {
        return this.f8856a;
    }

    public final String toString() {
        return "sink(" + this.f8857b + ")";
    }

    @Override // jf.v
    public final void write(d r8, long r10) {
        y.a(r8.f8830b, 0, r10);
    L4:
        if (r10 <= 0) goto L8;
        this.f8856a.f();
        s r11 = r8.f8829a;
        int r12 = (int) Math.min(r10, r11.f8872c - r11.f8871b);
        this.f8857b.write(r11.f8870a, r11.f8871b, r12);
        int r13 = r11.f8871b + r12;
        r11.f8871b = r13;
        long r14 = r12;
        r10 = r10 - r14;
        r8.f8830b -= r14;
        if (r13 != r11.f8872c) goto L4;
        r8.f8829a = r11.a();
        t.a(r11);
        goto L4
    }
}
