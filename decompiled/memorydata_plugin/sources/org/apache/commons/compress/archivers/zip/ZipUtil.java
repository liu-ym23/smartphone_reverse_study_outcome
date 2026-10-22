package org.apache.commons.compress.archivers.zip;

import androidx.core.view.InputDeviceCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = null;

    static {
        DOS_TIME_MIN = ZipLong.getBytes(8448);
    }

    public static long adjustToLong(int r4) {
        if (r4 >= 0) goto L6;
        return ((long) r4) + 4294967296L;
    L6:
        return r4;
    }

    static long bigToLong(BigInteger r3) {
        if (r3.bitLength() > 63) goto L7;
        return r3.longValue();
    L7:
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + r3 + "]");
    }

    static boolean canHandleEntryData(ZipArchiveEntry r1) {
        if (supportsEncryptionOf(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (supportsMethodOf(r1) == false) goto L7;
        return true;
    }

    static void checkRequestedFeatures(ZipArchiveEntry r2) {
        if (supportsEncryptionOf(r2) == false) goto L14;
        if (supportsMethodOf(r2) == true) goto L12;
        ZipMethod r0 = ZipMethod.getMethodByCode(r2.getMethod());
        if (r0 != null) goto L11;
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, r2);
    L11:
        throw new UnsupportedZipFeatureException(r0, r2);
    L12:
        return;
    L14:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, r2);
    }

    static void copy(byte[] r2, byte[] r3, int r4) {
        if (r2 == null) goto L5;
        System.arraycopy(r2, 0, r3, r4, r2.length);
        return;
    }

    static byte[] copy(byte[] r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return Arrays.copyOf(r1, r1.length);
    }

    public static long dosToJavaTime(long r7) {
        Calendar r0 = Calendar.getInstance();
        r0.set(1, ((int) ((r7 >> 25) & 127)) + 1980);
        r0.set(2, ((int) ((r7 >> 21) & 15)) - 1);
        r0.set(5, ((int) (r7 >> 16)) & 31);
        r0.set(11, ((int) (r7 >> 11)) & 31);
        r0.set(12, ((int) (r7 >> 5)) & 63);
        r0.set(13, ((int) (r7 << 1)) & 62);
        r0.set(14, 0);
        return r0.getTime().getTime();
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField r4, byte[] r5) {
        if (r4 == null) goto L7;
        CRC32 r0 = new CRC32();
        r0.update(r5);
        if (r0.getValue() != r4.getNameCRC32()) goto L12;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(r4.getUnicodeName());
    L13:
        return null;
    L12:
        return null;
    L7:
        return null;
    }

    static BigInteger longToBig(long r3) {
        if (r3 < (-2147483648L)) goto L11;
        if (r3 >= 0) goto L9;
        if (r3 < (-2147483648L)) goto L9;
        r3 = adjustToLong((int) r3);
    L9:
        return BigInteger.valueOf(r3);
    L11:
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + r3 + "]");
    }

    public static byte[] reverse(byte[] r5) {
        int r0 = r5.length - 1;
        int r1 = 0;
    L4:
        if (r1 >= (r5.length / 2)) goto L6;
        byte r2 = r5[r1];
        int r3 = r0 - r1;
        r5[r1] = r5[r3];
        r5[r3] = r2;
        r1 = r1 + 1;
        goto L4
    L6:
        return r5;
    }

    static void setNameAndCommentFromExtraFields(ZipArchiveEntry r4, byte[] r5, byte[] r6) {
        ZipExtraField r0 = r4.getExtraField(UnicodePathExtraField.UPATH_ID);
        UnicodeCommentExtraField r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, UnicodePathExtraField.class) == false) goto L5;
        UnicodePathExtraField r1 = (UnicodePathExtraField) ZeusTransformUtils.preCheckCast(r0, UnicodePathExtraField.class, "com.obric.memorydata.plugin");
    L6:
        String r7 = getUnicodeStringIfOriginalMatches(r1, r5);
        if (r7 == null) goto L9;
        r4.setName(r7);
        r4.setNameSource(ZipArchiveEntry.NameSource.UNICODE_EXTRA_FIELD);
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.length <= 0) goto L20;
        ZipExtraField r8 = r4.getExtraField(UnicodeCommentExtraField.UCOM_ID);
        if (ZeusTransformUtils.instanceOf(r8, UnicodeCommentExtraField.class) == false) goto L15;
        r3 = (UnicodeCommentExtraField) ZeusTransformUtils.preCheckCast(r8, UnicodeCommentExtraField.class, "com.obric.memorydata.plugin");
    L15:
        String r9 = getUnicodeStringIfOriginalMatches(r3, r6);
        if (r9 == null) goto L21;
        r4.setComment(r9);
        r4.setCommentSource(ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static int signedByteToUnsignedInt(byte r0) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return r0 + 256;
    }

    private static boolean supportsEncryptionOf(ZipArchiveEntry r0) {
        return !r0.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipArchiveEntry r2) {
        if (r2.getMethod() != 0) goto L5;
    L16:
        return true;
    L5:
        if (r2.getMethod() == ZipMethod.UNSHRINKING.getCode()) goto L16;
        if (r2.getMethod() == ZipMethod.IMPLODING.getCode()) goto L16;
        if (r2.getMethod() == 8) goto L16;
        if (r2.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L16;
        if (r2.getMethod() == ZipMethod.BZIP2.getCode()) goto L16;
        return false;
    }

    static void toDosTime(Calendar r3, long r4, byte[] r6, int r7) {
        r3.setTimeInMillis(r4);
        int r5 = r3.get(1);
        if (r5 >= 1980) goto L6;
        copy(DOS_TIME_MIN, r6, r7);
        return;
    L6:
        ZipLong.putLong((r3.get(13) >> 1) | ((((((r5 - 1980) << 25) | ((r3.get(2) + 1) << 21)) | (r3.get(5) << 16)) | (r3.get(11) << 11)) | (r3.get(12) << 5)), r6, r7);
    }

    public static byte unsignedIntToSignedByte(int r3) {
        if (r3 > 255) goto L12;
        if (r3 < 0) goto L12;
        if (r3 >= 128) goto L10;
        return (byte) r3;
    L10:
        return (byte) (r3 + InputDeviceCompat.SOURCE_ANY);
    L12:
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + r3 + "]");
    }
}
