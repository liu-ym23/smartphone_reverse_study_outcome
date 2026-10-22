package j4a;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static String a(String r6) throws IOException {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        PolarisFileInputStreamWrapper r7 = new PolarisFileInputStreamWrapper(r0);
        long r1 = r0.length();
        if (r1 > 2147483647L) goto L19;
        int r2 = (int) r1;
        byte[] r3 = new byte[r2];
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L9;
        int r5 = r7.read(r3, r4, r2 - r4);
        if (r5 < 0) goto L9;
        r4 = r4 + r5;
    L9:
        if (r4 < r2) goto L20;
        r7.close();
        return new String(Base64.encode(r3, 0));
    L20:
        r7.close();     // Catch: Exception -> L14
    L17:
        throw new IOException("Could not completely read file " + r0.getName());
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        throw new IOException("File is too large: " + r0.getName());
    }
}
