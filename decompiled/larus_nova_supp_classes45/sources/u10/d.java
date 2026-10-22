package u10;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (r4 == null) goto L10;
        byte[] r1 = new byte[4096];
    L5:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L10;
        r0.write(r1, 0, r2);
    L10:
        return r0.toByteArray();
    }
}
