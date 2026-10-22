package qa;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Closeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Charset f10389p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f10390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f10391b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f10392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10394o;

    public class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f10395a;

        public a(f0 r8, int r10) {
            this.f10395a = r8;
            super(r10);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int r8 = ((ByteArrayOutputStream) this).count;
            if (r8 > 0) goto L5;
        L12:
            return new String(((ByteArrayOutputStream) this).buf, 0, r8, this.f10395a.f10391b.name());
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (((ByteArrayOutputStream) this).buf[r8 - 1] != 13) goto L12;
            r8 = r8 - 1;
            goto L12
        }
    }

    static {
        f10389p = Charset.forName("US-ASCII");
    }

    public f0(FileInputStream r8, Charset r10) {
        if (r10 == null) goto L11;
        if (r10.equals(f10389p) == false) goto L9;
        this.f10390a = r8;
        this.f10391b = r10;
        this.f10392m = new byte[8192];
        return;
    L9:
        throw new IllegalArgumentException("Unsupported encoding");
    L11:
        throw null;
    }

    public final String a() {
        InputStream r8 = this.f10390a;
        monitor-enter(r8);
        byte[] r10 = this.f10392m;     // Catch: Throwable -> L47
        if (r10 == null) goto L46;
        if (this.f10393n < this.f10394o) goto L13;
        int r11 = this.f10390a.read(r10, 0, r10.length);     // Catch: Throwable -> L47
        if (r11 == (-1)) goto L12;
        this.f10393n = 0;     // Catch: Throwable -> L47
        this.f10394o = r11;     // Catch: Throwable -> L47
        goto L13
    L12:
        throw new EOFException();     // Catch: Throwable -> L47
    L13:
        int r12 = this.f10393n;     // Catch: Throwable -> L47
    L15:
        if (r12 == this.f10394o) goto L28;
        byte[] r13 = this.f10392m;     // Catch: Throwable -> L47
        if (r13[r12] == 10) goto L19;
        r12 = r12 + 1;     // Catch: Throwable -> L47
        goto L15
    L19:
        if (r12 == this.f10393n) goto L23;
        int r14 = r12 - 1;     // Catch: Throwable -> L47
        if (r13[r14] != 13) goto L23;
    L24:
        byte[] r15 = this.f10392m;     // Catch: Throwable -> L47
        int r16 = this.f10393n;     // Catch: Throwable -> L47
        String r17 = new String(r15, r16, r14 - r16, this.f10391b.name());     // Catch: Throwable -> L47
        this.f10393n = r12 + 1;     // Catch: Throwable -> L47
        monitor-exit(r8);     // Catch: Throwable -> L47
        return r17;
    L23:
        r14 = r12;
        goto L24
    L28:
        a r18 = new a(this, (this.f10394o - this.f10393n) + 80);     // Catch: Throwable -> L47
    L29:
        byte[] r19 = this.f10392m;     // Catch: Throwable -> L47
        int r20 = this.f10393n;     // Catch: Throwable -> L47
        r18.write(r19, r20, this.f10394o - r20);     // Catch: Throwable -> L47
        this.f10394o = -1;     // Catch: Throwable -> L47
        byte[] r21 = this.f10392m;     // Catch: Throwable -> L47
        int r22 = this.f10390a.read(r21, 0, r21.length);     // Catch: Throwable -> L47
        if (r22 == (-1)) goto L44;
        this.f10393n = 0;     // Catch: Throwable -> L47
        this.f10394o = r22;     // Catch: Throwable -> L47
        int r23 = 0;
    L33:
        if (r23 == this.f10394o) goto L29;
        byte[] r24 = this.f10392m;     // Catch: Throwable -> L47
        if (r24[r23] == 10) goto L36;
        r23 = r23 + 1;     // Catch: Throwable -> L47
        goto L33
    L36:
        int r25 = this.f10393n;     // Catch: Throwable -> L47
        if (r23 == r25) goto L39;
        r18.write(r24, r25, r23 - r25);     // Catch: Throwable -> L47
    L39:
        this.f10393n = r23 + 1;     // Catch: Throwable -> L47
        String r26 = r18.toString();     // Catch: Throwable -> L47
        monitor-exit(r8);     // Catch: Throwable -> L47
        return r26;
    L44:
        throw new EOFException();     // Catch: Throwable -> L47
    L46:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r8 = this.f10390a;
        monitor-enter(r8);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f10392m == null) goto L7;
        this.f10392m = null;     // Catch: Throwable -> L9
        this.f10390a.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
    }
}
