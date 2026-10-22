package n4a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u0 extends b1 {
    public ByteArrayOutputStream c;

    public u0(z0 r1) {
        super(r1);
        this.c = new ByteArrayOutputStream();
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r2) {
        byte[] r3 = this.c.toByteArray();
        this.c.close();     // Catch: IOException -> L5
    L7:
        this.c = new ByteArrayOutputStream();
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // n4a.b1
    public final void c(byte[] r2) {
        this.c.write(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
