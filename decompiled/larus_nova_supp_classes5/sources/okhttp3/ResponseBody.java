package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class ResponseBody implements Closeable {

    @Nullable
    private Reader reader;

    public static class a extends ResponseBody {
        public final /* synthetic */ MediaType a;
        public final /* synthetic */ long b;
        public final /* synthetic */ BufferedSource c;

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.b;
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public final MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.c;
        }

        public a(MediaType r1, long r2, BufferedSource r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public ResponseBody() {
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final Reader charStream() {
        Reader r0 = this.reader;
        if (r0 != null) goto L7;
        b r1 = new b(source(), charset());
        this.reader = r1;
        return r1;
    L7:
        return r0;
    }

    private Charset charset() {
        MediaType r0 = contentType();
        if (r0 == null) goto L6;
        return r0.charset(cvc.c.j);
    L6:
        return cvc.c.j;
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long r0 = contentLength();
        if (r0 > 2147483647L) goto L18;
        BufferedSource r2 = source();
        byte[] r3 = r2.readByteArray();     // Catch: Throwable -> L14
        cvc.c.e(r2);
        if (r0 != (-1)) goto L9;
    L13:
        return r3;
    L9:
        if (r0 == r3.length) goto L13;
        throw new IOException("Content-Length (" + r0 + ") and stream length (" + r3.length + ") disagree");
    L14:
        th = move-exception;
        cvc.c.e(r2);
        throw th;
    L18:
        throw new IOException("Cannot buffer entire body for content length: " + r0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        cvc.c.e(source());
    }

    public final String string() throws IOException {
        BufferedSource r0 = source();
        String r1 = r0.readString(cvc.c.b(r0, charset()));     // Catch: Throwable -> L6
        cvc.c.e(r0);
        return r1;
    L6:
        th = move-exception;
        cvc.c.e(r0);
        throw th;
    }

    public static ResponseBody create(@Nullable MediaType r2, String r3) {
        Charset r0 = cvc.c.j;
        if (r2 == null) goto L8;
        Charset r1 = r2.charset();
        if (r1 != null) goto L7;
        r2 = MediaType.parse(r2 + "; charset=utf-8");
        goto L8
    L7:
        r0 = r1;
    L8:
        Buffer r4 = new Buffer().writeString(r3, r0);
        return create(r2, r4.size(), r4);
    }

    public static ResponseBody create(@Nullable MediaType r3, ByteString r4) {
        return create(r3, r4.size(), new Buffer().write(r4));
    }

    public static ResponseBody create(@Nullable MediaType r3, byte[] r4) {
        return create(r3, r4.length, new Buffer().write(r4));
    }

    public static ResponseBody create(@Nullable MediaType r1, long r2, BufferedSource r4) {
        if (r4 == null) goto L6;
        return new a(r1, r2, r4);
    L6:
        throw new NullPointerException("source == null");
    }
}
