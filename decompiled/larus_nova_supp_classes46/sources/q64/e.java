package q64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e extends InputStream {
    public final String a;
    public final long b;
    public final InputStream c;
    public boolean d;
    public boolean e;
    public long f;
    public byte[] g;
    public String h;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e = true;
        this.c.close();
    }

    public byte[] a() {
        byte[] r0 = this.g;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        if (isClosed() == true) goto L9;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L16
    L11:
        int r3 = read(r2);     // Catch: Throwable -> L16
        if (r3 <= 0) goto L14;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L16
        goto L11
    L14:
        this.g = r1.toByteArray();     // Catch: Throwable -> L16
    L15:
        e();
        if (this.g != null) goto L22;
        this.g = new byte[0];
    L22:
        byte[] r4 = this.g;
        Intrinsics.checkNotNull(r4);
        return r4;
    L16:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        e();
        throw th;
    L9:
        return new byte[0];
    }

    public String f() {
        String r0 = this.h;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        String r1 = new String(a(), Charsets.UTF_8);
        this.h = r1;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r0 = this.c.read();
        if (r0 == (-1)) goto L5;
        this.f++;
    L6:
        return r0;
    L5:
        this.d = true;
        goto L6
    }

    public final String toString() {
        return "BdpResponseBody(contentType='" + this.a + "', contentLength=" + this.b + ", finished=" + this.d + ", closed=" + this.e + ", readLength=" + this.f + ')';
    }

    public boolean e() {
        close();     // Catch: Throwable -> L4
        return true;
    L4:
        th = move-exception;
        th.getMessage();
        return false;
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.d;
    }

    public boolean isClosed() {
        return this.e;
    }

    public e(String r2, long r3, InputStream r5) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        Intrinsics.checkNotNullParameter(r5, "real");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
