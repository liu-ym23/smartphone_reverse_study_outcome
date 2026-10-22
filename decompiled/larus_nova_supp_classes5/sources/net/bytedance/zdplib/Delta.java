package net.bytedance.zdplib;

import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Delta {
    public final byte[] a;
    public final long b;
    public final a c;

    public class a extends ThreadLocal<MessageDigest> {
        @Override // java.lang.ThreadLocal
        public final MessageDigest initialValue() {
            return MessageDigest.getInstance("SHA-256");
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public a() {
        }
    }

    private static native int decrypt(byte[] r0, byte[] r1, byte[] r2);

    private static native int encrypt(byte[] r0, byte[] r1, byte[] r2);

    private static native void free(long r0);

    private static native int generateAesKey(byte[] r0, long r1, long r3);

    private static native int generatePrivateKey(byte[] r0);

    private static native int getDecryptedLen(int r0);

    private static native int getEncryptedLen(int r0);

    private static native int getPublicKey(byte[] r0, long r1);

    private static native long initPrivateKey(byte[] r0);

    private static native long initPubKey(byte[] r0);

    static {
        Intrinsics.checkNotNullParameter("delta", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> delta");
        com.bytedance.librarian.a.c("delta");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> delta");
    }

    public final String c() throws Exception {
        byte[] r0 = new byte[33];
        int r1 = getPublicKey(r0, this.b);
        if (r1 != 0) goto L7;
        return d(r0);
    L7:
        throw new Exception("getPublicKey error " + r1);
    }

    public static String d(byte[] r6) {
        char[] r0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] r1 = new char[r6.length * 2];
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L7;
        int r3 = r6[r2] & UByte.MAX_VALUE;
        int r4 = r2 * 2;
        r1[r4] = r0[r3 >>> 4];
        r1[r4 + 1] = r0[r3 & 15];
        r2 = r2 + 1;
        goto L4
    L7:
        return new String(r1);
    }

    public static byte[] e(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2 / 2] = (byte) ((Character.digit(r7.charAt(r2), 16) << 4) + Character.digit(r7.charAt(r2 + 1), 16));
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }

    public final byte[] a(byte[] r4) throws Exception {
        if (this.a == null) goto L14;
        int r0 = getDecryptedLen(r4.length);
        if (r0 < 0) goto L12;
        byte[] r1 = new byte[r0];
        int r5 = decrypt(r1, r4, this.a);
        if (r5 < 0) goto L10;
        return r1;
    L10:
        throw new Exception("decrypt error " + r5);
    L12:
        throw new Exception("encryptedMessage is too short");
    L14:
        throw new Exception("invalid aes key");
    }

    public final byte[] b(byte[] r4) throws Exception {
        if (this.a == null) goto L13;
        int r0 = getEncryptedLen(r4.length);
        byte[] r1 = new byte[r0];
        int r5 = encrypt(r1, r4, this.a);
        if (r5 < 0) goto L11;
        if (r5 != r0) goto L9;
        return r1;
    L9:
        throw new Exception("data length error");
    L11:
        throw new Exception("encrypt error " + r5);
    L13:
        throw new Exception("invalid aes key");
    }

    public Delta(byte[] r5, String r6) throws Exception {
        this.c = new a();
        byte[] r7 = e(r6);
        if (r7.length != 33) goto L5;
    L9:
        long r0 = initPubKey(r7);
        if (r0 == 0) goto L17;
        long r8 = initPrivateKey(r5);
        this.b = r8;
        byte[] r2 = new byte[32];
        this.a = r2;
        int r9 = generateAesKey(r2, r8, r0);
        if (r9 != 0) goto L15;
        return;
    L15:
        throw new Exception("generateAesKey error " + r9);
    L17:
        throw new Exception("other public key invalid");
    L5:
        if (r7.length == 65) goto L9;
        throw new Exception("other public key length error");
    }
}
