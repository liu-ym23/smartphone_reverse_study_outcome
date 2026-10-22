package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class RequestBody {

    public static class b extends RequestBody {
        public final /* synthetic */ MediaType a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ int d;

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return this.b;
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public final MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink r4) throws IOException {
            r4.write(this.c, this.d, this.b);
        }

        public b(MediaType r1, int r2, byte[] r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public RequestBody() {
    }

    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink r1) throws IOException;

    public static RequestBody create(@Nullable MediaType r2, String r3) {
        Charset r0 = cvc.c.j;
        if (r2 == null) goto L9;
        Charset r1 = r2.charset();
        if (r1 != null) goto L7;
        r2 = MediaType.parse(r2 + "; charset=utf-8");
        goto L9
    L7:
        r0 = r1;
    L9:
        return create(r2, r3.getBytes(r0));
    }

    public static RequestBody create(@Nullable MediaType r1, File r2) {
        if (r2 == null) goto L6;
        return new c(r1, r2);
    L6:
        throw new NullPointerException("file == null");
    }

    public static RequestBody create(@Nullable MediaType r2, byte[] r3) {
        return create(r2, r3, 0, r3.length);
    }

    public static RequestBody create(@Nullable MediaType r1, ByteString r2) {
        return new a(r1, r2);
    }

    public static RequestBody create(@Nullable MediaType r11, byte[] r12, int r13, int r14) {
        if (r12 == null) goto L14;
        long r0 = r12.length;
        long r2 = r13;
        long r4 = r14;
        byte[] r6 = cvc.c.a;
        if ((r2 | r4) < 0) goto L12;
        if (r2 > r0) goto L12;
        if ((r0 - r2) < r4) goto L12;
        return new b(r11, r14, r12, r13);
    L12:
        throw new ArrayIndexOutOfBoundsException();
    L14:
        throw new NullPointerException("content == null");
    }
}
