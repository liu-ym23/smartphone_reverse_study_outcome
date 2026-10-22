package ka;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class g extends pa.c {
    public static final ha.u A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f8997z = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f8998w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f8999x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ha.p f9000y;

    public class a extends Writer {
        public a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public final void write(char[] r8, int r10, int r11) {
            throw new AssertionError();
        }
    }

    static {
        f8997z = new a();
        A = new ha.u("closed");
    }

    public g() {
        super(f8997z);
        this.f8998w = new ArrayList();
        this.f9000y = ha.r.f8002a;
    }

    @Override // pa.c
    public final void C(double r8) {
        if (this.f9985p == false) goto L5;
    L11:
        c0(new ha.u(Double.valueOf(r8)));
        return;
    L5:
        if (Double.isNaN(r8) == true) goto L10;
        if (Double.isInfinite(r8) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r8);
    }

    @Override // pa.c
    public final void D(long r8) {
        c0(new ha.u(Long.valueOf(r8)));
    }

    @Override // pa.c
    public final void E(Boolean r8) {
        if (r8 != null) goto L5;
        c0(ha.r.f8002a);
        return;
    L5:
        c0(new ha.u(r8));
    }

    @Override // pa.c
    public final void G(Number r8) {
        if (r8 != null) goto L6;
        c0(ha.r.f8002a);
        return;
    L6:
        if (this.f9985p == true) goto L14;
        double r10 = r8.doubleValue();
        if (Double.isNaN(r10) == true) goto L13;
        if (Double.isInfinite(r10) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r8);
    L14:
        c0(new ha.u(r8));
    }

    @Override // pa.c
    public final void H(String r8) {
        if (r8 != null) goto L5;
        c0(ha.r.f8002a);
        return;
    L5:
        c0(new ha.u(r8));
    }

    @Override // pa.c
    public final void I(boolean r8) {
        c0(new ha.u(Boolean.valueOf(r8)));
    }

    public final ha.p K() {
        ArrayList r8 = this.f8998w;
        if (r8.isEmpty() == false) goto L7;
        return this.f9000y;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + r8);
    }

    public final ha.p V() {
        ArrayList r8 = this.f8998w;
        return (ha.p) r8.get(r8.size() - 1);
    }

    public final void c0(ha.p r8) {
        if (this.f8999x == null) goto L11;
        r8.getClass();
        if ((r8 instanceof ha.r) == true) goto L7;
    L8:
        ((ha.s) V()).k(this.f8999x, r8);
    L9:
        this.f8999x = null;
        return;
    L7:
        if (this.f9988s == false) goto L9;
    L11:
        if (this.f8998w.isEmpty() == false) goto L13;
        this.f9000y = r8;
        return;
    L13:
        ha.p r10 = V();
        if ((r10 instanceof ha.m) == false) goto L18;
        ((ha.m) r10).k(r8);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // pa.c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ArrayList r8 = this.f8998w;
        if (r8.isEmpty() == false) goto L7;
        r8.add(A);
        return;
    L7:
        throw new IOException("Incomplete document");
    }

    @Override // pa.c, java.io.Flushable
    public final void flush() {
    }

    @Override // pa.c
    public final void i() {
        ha.m r8 = new ha.m();
        c0(r8);
        this.f8998w.add(r8);
    }

    @Override // pa.c
    public final void k() {
        ha.s r8 = new ha.s();
        c0(r8);
        this.f8998w.add(r8);
    }

    @Override // pa.c
    public final void r() {
        ArrayList r8 = this.f8998w;
        if (r8.isEmpty() == true) goto L13;
        if (this.f8999x != null) goto L13;
        if ((V() instanceof ha.m) == false) goto L11;
        r8.remove(r8.size() - 1);
        return;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // pa.c
    public final void v() {
        ArrayList r8 = this.f8998w;
        if (r8.isEmpty() == true) goto L13;
        if (this.f8999x != null) goto L13;
        if ((V() instanceof ha.s) == false) goto L11;
        r8.remove(r8.size() - 1);
        return;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // pa.c
    public final void w(String r8) {
        Objects.requireNonNull(r8, "name == null");
        if (this.f8998w.isEmpty() == true) goto L13;
        if (this.f8999x != null) goto L13;
        if ((V() instanceof ha.s) == false) goto L11;
        this.f8999x = r8;
        return;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // pa.c
    public final pa.c z() {
        c0(ha.r.f8002a);
        return this;
    }
}
