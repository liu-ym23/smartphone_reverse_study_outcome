package net.bytedance.zdplib;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DeltaSignerVerifier {
    public final long a;
    public final byte[] b;

    private static native void free(long r0);

    private static native int generatePrivateKey(byte[] r0);

    private static native int getPublicKey(byte[] r0, long r1);

    private static native int getPublicKeyUncompressed(byte[] r0, long r1);

    private static native long initPrivateKey(byte[] r0);

    private static native int sign(byte[] r0, long r1, byte[] r3);

    private static native int verify(byte[] r0, byte[] r1, byte[] r2);

    static {
        Intrinsics.checkNotNullParameter("delta", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> delta");
        a.c("delta");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> delta");
    }

    public static String a() throws Exception {
        byte[] r0 = new byte[32];
        int r1 = generatePrivateKey(r0);
        if (r1 < 0) goto L7;
        return Delta.d(r0);
    L7:
        throw new Exception("GeneratePrivateKey  error " + r1);
    }

    public final String c() throws Exception {
        byte[] r0 = new byte[65];
        int r1 = getPublicKeyUncompressed(r0, this.a);
        if (r1 != 0) goto L7;
        return Delta.d(r0);
    L7:
        throw new Exception("getPublicKey error " + r1);
    }

    public DeltaSignerVerifier(String r4) throws Exception {
        byte[] r0 = Delta.e(r4);
        if (r0.length != 32) goto L7;
        this.a = initPrivateKey(r0);
        this.b = r0;
        return;
    L7:
        throw new Exception("invalid private key :".concat(r4));
    }

    public final byte[] b(byte[] r4) throws Exception {
        byte[] r0 = new byte[72];
        int r5 = sign(r0, this.a, r4);
        if (r5 < 0) goto L7;
        return Arrays.copyOfRange(r0, 0, r5);
    L7:
        throw new Exception(String.format("sign error ret=%d", new Object[]{Integer.valueOf(r5)}));
    }
}
