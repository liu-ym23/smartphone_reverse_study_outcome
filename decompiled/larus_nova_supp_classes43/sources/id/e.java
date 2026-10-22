package id;

import com.bytedance.android.chunkstreamprediction.network.i;
import com.bytedance.android.chunkstreamprediction.network.j;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final InputStream a;
    public i b;
    public final StringBuilder c;

    public final void a() throws IOException {
        if (this.a.read() != 13) goto L8;
        if (this.a.read() != 10) goto L8;
        return;
    L8:
        throw new IOException("Chunk data not end with CRLF");
    }

    public final d b() throws IOException {
        this.c.setLength(0);
    L3:
        int r0 = this.a.read();
        if (r0 == (-1)) goto L19;
        if (r0 == 13) goto L8;
        if (Character.digit(r0, 16) == (-1)) goto L17;
        this.c.append((char) r0);
        goto L3
    L17:
        throw new IOException("Chunk header is not hex string");
    L8:
        if (this.a.read() != 10) goto L12;
        int r1 = CastIntegerProtector.parseInt(this.c.toString(), 16);
        this.b.i();
        return new d(r1, this.a);
    L12:
        throw new IOException("Chunk header not end with CRLF");
    L19:
        throw new IOException("Unexpected EOF");
    }

    public e(InputStream r10) {
        this.b = new j();
        this.c = new StringBuilder(10);
        this.a = new BufferedInputStream(r10);
    }
}
