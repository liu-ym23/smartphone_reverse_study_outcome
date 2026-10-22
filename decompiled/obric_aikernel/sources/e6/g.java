package e6;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.google.gson.stream.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Writer f8653u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final com.google.gson.m f8654v = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List<com.google.gson.i> f8655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f8656s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.google.gson.i f8657t;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] r10, int r11, int r12) {
            throw new AssertionError();
        }
    }

    static {
        f8653u = new a();
        f8654v = new com.google.gson.m("closed");
    }

    public g() {
        super(f8653u);
        this.f8655r = new ArrayList();
        this.f8657t = com.google.gson.j.f4273a;
    }

    private com.google.gson.i f0() {
        List<com.google.gson.i> r10 = this.f8655r;
        return r10.get(r10.size() - 1);
    }

    private void g0(com.google.gson.i r10) {
        if (this.f8656s == null) goto L11;
        if (r10.j() == true) goto L7;
    L8:
        ((com.google.gson.k) f0()).m(this.f8656s, r10);
    L9:
        this.f8656s = null;
        return;
    L7:
        if (p() == false) goto L9;
    L11:
        if (this.f8655r.isEmpty() == false) goto L13;
        this.f8657t = r10;
        return;
    L13:
        com.google.gson.i r11 = f0();
        if ((r11 instanceof com.google.gson.f) == false) goto L18;
        ((com.google.gson.f) r11).m(r10);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a B() {
        g0(com.google.gson.j.f4273a);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a P(double r10) {
        if (s() == false) goto L5;
    L11:
        g0(new com.google.gson.m(Double.valueOf(r10)));
        return this;
    L5:
        if (Double.isNaN(r10) == true) goto L10;
        if (Double.isInfinite(r10) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r10);
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Q(long r10) {
        g0(new com.google.gson.m(Long.valueOf(r10)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a V(Boolean r10) {
        if (r10 == null) goto L4;
        g0(new com.google.gson.m(r10));
        return this;
    L4:
        return B();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a X(Number r10) {
        if (r10 != null) goto L6;
        return B();
    L6:
        if (s() == true) goto L14;
        double r11 = r10.doubleValue();
        if (Double.isNaN(r11) == true) goto L13;
        if (Double.isInfinite(r11) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r10);
    L14:
        g0(new com.google.gson.m(r10));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a0(String r10) {
        if (r10 == null) goto L4;
        g0(new com.google.gson.m(r10));
        return this;
    L4:
        return B();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a c0(boolean r10) {
        g0(new com.google.gson.m(Boolean.valueOf(r10)));
        return this;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8655r.isEmpty() == false) goto L7;
        this.f8655r.add(f8654v);
        return;
    L7:
        throw new IOException("Incomplete document");
    }

    public com.google.gson.i e0() {
        if (this.f8655r.isEmpty() == false) goto L7;
        return this.f8657t;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + this.f8655r);
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a f() {
        com.google.gson.f r10 = new com.google.gson.f();
        g0(r10);
        this.f8655r.add(r10);
        return this;
    }

    @Override // com.google.gson.stream.a, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a i() {
        com.google.gson.k r10 = new com.google.gson.k();
        g0(r10);
        this.f8655r.add(r10);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a l() {
        if (this.f8655r.isEmpty() == true) goto L13;
        if (this.f8656s != null) goto L13;
        if ((f0() instanceof com.google.gson.f) == false) goto L11;
        List<com.google.gson.i> r10 = this.f8655r;
        r10.remove(r10.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a o() {
        if (this.f8655r.isEmpty() == true) goto L13;
        if (this.f8656s != null) goto L13;
        if ((f0() instanceof com.google.gson.k) == false) goto L11;
        List<com.google.gson.i> r10 = this.f8655r;
        r10.remove(r10.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a v(String r10) {
        Objects.requireNonNull(r10, "name == null");
        if (this.f8655r.isEmpty() == true) goto L13;
        if (this.f8656s != null) goto L13;
        if ((f0() instanceof com.google.gson.k) == false) goto L11;
        this.f8656s = r10;
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }
}
