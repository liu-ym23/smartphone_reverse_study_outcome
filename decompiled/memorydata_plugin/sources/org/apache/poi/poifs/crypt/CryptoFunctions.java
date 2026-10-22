package org.apache.poi.poifs.crypt;

import com.bytedance.crash.npth_repair.utils.RepairState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class CryptoFunctions {
    private static final int[][] ENCRYPTION_MATRIX = null;
    private static final int[] INITIAL_CODE_ARRAY = null;
    static int MAX_RECORD_LENGTH = 100000;
    private static final byte[] PAD_ARRAY = null;

    static {
        INITIAL_CODE_ARRAY = new int[]{57840, 7439, 52380, 33984, 4364, 3600, 61902, 12606, 6258, 57657, 54287, 34041, 10252, 43370, 20163};
        PAD_ARRAY = new byte[]{-69, -1, -1, -70, -1, -1, -71, -128, 0, -66, 15, 0, -65, 15, 0};
        ENCRYPTION_MATRIX = new int[][]{new int[]{44796, 19929, 39858, 10053, 20106, 40212, 10761}, new int[]{31585, 63170, 64933, 60267, 50935, 40399, 11199}, new int[]{17763, 35526, 1453, 2906, 5812, 11624, 23248}, new int[]{885, 1770, 3540, 7080, 14160, 28320, 56640}, new int[]{55369, 41139, 20807, 41614, 21821, 43642, 17621}, new int[]{28485, 56970, 44341, 19019, 38038, 14605, 29210}, new int[]{60195, 50791, 40175, 10751, 21502, 43004, 24537}, new int[]{18387, 36774, 3949, 7898, 15796, 31592, 63184}, new int[]{47201, 24803, 49606, 37805, 14203, 28406, 56812}, new int[]{17824, 35648, 1697, 3394, 6788, 13576, 27152}, new int[]{43601, 17539, 35078, 557, RepairState.STATE_DUMPED, 2228, 4456}, new int[]{30388, 60776, 51953, 34243, 7079, 14158, 28316}, new int[]{14128, 28256, 56512, 43425, 17251, 34502, 7597}, new int[]{13105, 26210, 52420, 35241, 883, 1766, 3532}, new int[]{4129, 8258, 16516, 33032, 4657, 9314, 18628}};
    }

    private CryptoFunctions() {
    }

    public static byte[] createXorArray1(String r7) {
        int r2 = 0;
        if (r7.length() <= 15) goto L5;
        r7 = r7.substring(0, 15);
    L5:
        byte[] r0 = r7.getBytes(StandardCharsets.US_ASCII);
        byte[] r3 = new byte[16];
        System.arraycopy(r0, 0, r3, 0, r0.length);
        byte[] r4 = PAD_ARRAY;
        System.arraycopy(r4, 0, r3, r0.length, (r4.length - r0.length) + 1);
        int r8 = createXorKey1(r7);
        byte[] r5 = {(byte) (r8 & 255), (byte) ((r8 >>> 8) & 255)};
    L6:
        if (r2 >= 16) goto L8;
        r3[r2] = (byte) (r3[r2] ^ r5[r2 & 1]);
        r3[r2] = rotateLeft(r3[r2], 2);
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    public static int createXorKey1(String r0) {
        return createXorVerifier2(r0) >>> 16;
    }

    public static int createXorVerifier1(String r3) {
        if (r3 == null) goto L12;
        byte[] r0 = toAnsiPassword(r3);
        short r1 = 0;
        if (r3.isEmpty() == true) goto L10;
        int r4 = r0.length - 1;
    L6:
        if (r4 < 0) goto L8;
        r1 = (short) (rotateLeftBase15Bit(r1) ^ r0[r4]);
        r4 = r4 - 1;
        goto L6
    L8:
        r1 = (short) (((short) (rotateLeftBase15Bit(r1) ^ r0.length)) ^ 52811);
    L10:
        return 65535 & r1;
    L12:
        throw new IllegalArgumentException("Password cannot be null");
    }

    public static int createXorVerifier2(String r14) {
        if (r14 == null) goto L18;
        byte[] r0 = new byte[4];
        if (r14.isEmpty() == true) goto L16;
        String r15 = r14.substring(0, Math.min(r14.length(), 15));
        byte[] r1 = toAnsiPassword(r15);
        int r4 = INITIAL_CODE_ARRAY[r1.length - 1];
        int r2 = 15 - r1.length;
        int r5 = r1.length;
        int r7 = 0;
    L6:
        if (r7 >= r5) goto L14;
        byte r8 = r1[r7];
        int r10 = r2 + 1;
        int[] r3 = ENCRYPTION_MATRIX[r2];
        int r9 = r3.length;
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L13;
        int r12 = r3[r11];
        if ((r8 & 1) != 1) goto L12;
        r4 = r4 ^ r12;
    L12:
        r8 = (byte) (r8 >>> 1);
        r11 = r11 + 1;
        goto L8
    L13:
        r7 = r7 + 1;
        r2 = r10;
        goto L6
    L14:
        LittleEndian.putShort(r0, 0, (short) createXorVerifier1(r15));
        LittleEndian.putShort(r0, 2, (short) r4);
    L16:
        return LittleEndian.getInt(r0);
    L18:
        throw new IllegalArgumentException("Password cannot be null");
    }

    public static byte[] generateIv(HashAlgorithm r0, byte[] r1, byte[] r2, int r3) {
        if (r2 == null) goto L5;
        MessageDigest r4 = getMessageDigest(r0);
        r4.update(r1);
        r1 = r4.digest(r2);
    L5:
        return getBlock36(r1, r3);
    }

    public static byte[] generateKey(byte[] r0, HashAlgorithm r1, byte[] r2, int r3) {
        MessageDigest r4 = getMessageDigest(r1);
        r4.update(r0);
        return getBlock36(r4.digest(r2), r3);
    }

    public static byte[] getBlock0(byte[] r1, int r2) {
        return getBlockX(r1, r2, (byte) 0);
    }

    private static byte[] getBlock36(byte[] r1, int r2) {
        return getBlockX(r1, r2, (byte) 54);
    }

    private static byte[] getBlockX(byte[] r2, int r3, byte r4) {
        if (r2.length != r3) goto L5;
        return r2;
    L5:
        byte[] r5 = IOUtils.safelyAllocate(r3, MAX_RECORD_LENGTH);
        Arrays.fill(r5, r4);
        System.arraycopy(r2, 0, r5, 0, Math.min(r5.length, r2.length));
        return r5;
    }

    public static Cipher getCipher(Key r3, CipherAlgorithm r4, ChainingMode r5, byte[] r6, int r7, String r8) {
        Key r9 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        int r0 = r9.getEncoded().length;
        if (r8 != null) goto L29;
        r8 = "NoPadding";
    L29:
    L26:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    L6:
        if (Cipher.getMaxAllowedKeyLength(r4.jceId) < (r0 * 8)) goto L25;
        if (r4 != CipherAlgorithm.rc4) goto L13;
        String r10 = r4.jceId;     // Catch: GeneralSecurityException -> L26
    L10:
        Cipher r11 = Cipher.getInstance(r10);     // Catch: GeneralSecurityException -> L26
    L16:
        if (r6 != null) goto L19;
        r11.init(r7, r9);     // Catch: GeneralSecurityException -> L26
    L23:
        return r11;
    L19:
        if (r4 != CipherAlgorithm.rc2) goto L21;
        AlgorithmParameterSpec r12 = new RC2ParameterSpec(r9.getEncoded().length * 8, r6);     // Catch: GeneralSecurityException -> L26
    L22:
        r11.init(r7, r9, r12);     // Catch: GeneralSecurityException -> L26
        goto L23
    L21:
        r12 = new IvParameterSpec(r6);     // Catch: GeneralSecurityException -> L26
        goto L22
    L13:
        if (r4.needsBouncyCastle == false) goto L15;
        registerBouncyCastle();     // Catch: GeneralSecurityException -> L26
        r11 = Cipher.getInstance(r4.jceId + "/" + r5.jceId + "/" + r8, BouncyCastleProvider.PROVIDER_NAME);     // Catch: GeneralSecurityException -> L26
        goto L16
    L15:
        r10 = r4.jceId + "/" + r5.jceId + "/" + r8;     // Catch: GeneralSecurityException -> L26
        goto L10
    L25:
        throw new EncryptedDocumentException("Export Restrictions in place - please install JCE Unlimited Strength Jurisdiction Policy files");     // Catch: GeneralSecurityException -> L26
    }

    public static Cipher getCipher(SecretKey r6, CipherAlgorithm r7, ChainingMode r8, byte[] r9, int r10) {
        return getCipher((SecretKey) ZeusTransformUtils.wrapperContextForParams(r6, SecretKey.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, null);
    }

    public static MessageDigest getMessageDigest(HashAlgorithm r2) {
    L8:
        e = move-exception;
        throw new EncryptedDocumentException("hash algo not supported", e);
    L3:
        if (r2.needsBouncyCastle == false) goto L7;
        registerBouncyCastle();     // Catch: GeneralSecurityException -> L8
        return MessageDigest.getInstance(r2.jceId, BouncyCastleProvider.PROVIDER_NAME);
    L7:
        return MessageDigest.getInstance(r2.jceId);
    }

    public static byte[] hashPassword(String r1, HashAlgorithm r2, byte[] r3, int r4) {
        return hashPassword(r1, r2, r3, r4, true);
    }

    public static byte[] hashPassword(String r4, HashAlgorithm r5, byte[] r6, int r7, boolean r8) {
        if (r4 != null) goto L4;
        r4 = "VelvetSweatshop";
    L4:
        MessageDigest r9 = getMessageDigest(r5);
        r9.update(r6);
        byte[] r10 = r9.digest(StringUtil.getToUnicodeLE(r4));
        byte[] r11 = new byte[4];
        if (r8 == false) goto L7;
        byte[] r0 = r11;
    L8:
        if (r8 == false) goto L10;
        byte[] r12 = r10;
    L11:
        int r2 = 0;
    L12:
        if (r2 >= r7) goto L17;
        LittleEndian.putInt(r11, 0, r2);     // Catch: DigestException -> L15
        r9.reset();     // Catch: DigestException -> L15
        r9.update(r0);     // Catch: DigestException -> L15
        r9.update(r12);     // Catch: DigestException -> L15
        r9.digest(r10, 0, r10.length);     // Catch: DigestException -> L15
        r2 = r2 + 1;
    L16:
        throw new EncryptedDocumentException("error in password hashing");
    L17:
        return r10;
    L10:
        r12 = r11;
        goto L11
    L7:
        r0 = r10;
        goto L8
    }

    public static void registerBouncyCastle() {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) goto L10;
        return;
    L10:
        Security.addProvider((Provider) ZeusTransformUtils.preCheckCast(CryptoFunctions.class.getClassLoader().loadClass("org.bouncycastle.jce.provider.BouncyCastleProvider").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Provider.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new EncryptedDocumentException("Only the BouncyCastle provider supports your encryption settings - please add it to the classpath.", e);
    }

    private static byte rotateLeft(byte r1, int r2) {
        int r3 = r1 & 255;
        int r0 = r3 << r2;
        return (byte) ((r3 >>> (8 - r2)) | r0);
    }

    private static short rotateLeftBase15Bit(short r2) {
        if ((r2 & 16384) != 0) goto L5;
        int r0 = 0;
    L7:
        return (short) (((short) ((r2 << 1) & 32767)) | ((short) r0));
    L5:
        r0 = 1;
        goto L7
    }

    private static byte[] toAnsiPassword(String r4) {
        byte[] r0 = new byte[r4.length()];
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L10;
        char r2 = r4.charAt(r1);
        byte r3 = (byte) (r2 & 255);
        byte r5 = (byte) ((r2 >>> '\b') & 255);
        if (r3 != 0) goto L9;
        r3 = r5;
    L9:
        r0[r1] = r3;
        r1 = r1 + 1;
        goto L4
    L10:
        return r0;
    }
}
