package adcpeJava.adcpe;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class e {
    static int a(byte[] r3) {
        if (r3.length == 2) goto L5;
        a("inBytes", 2, r3.length);
    L5:
        ByteBuffer r4 = ByteBuffer.wrap(r3);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        return r4.getShort(0);
    }

    static RealVector a(double r4, byte[] r6, byte[] r7, double r8, int r10) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        r0.update(r6);
        r0.update(r7);
        byte[] r9 = r0.digest();
        if (r9.length != 32) goto L7;
        byte[] r1 = new byte[16];
        byte[] r2 = new byte[16];
        System.arraycopy(r9, 0, r1, 0, 16);
        System.arraycopy(r9, 16, r2, 0, 16);
        double[] r11 = a(r1, r10);
        double r3 = (Constants.f10a * (r4 * r8)) * Math.pow(d(r2), 1.0d / ((double) r10));
        ArrayRealVector r5 = new ArrayRealVector(r11);
        return r5.mapMultiply(r3 / r5.getNorm());
    L7:
        throw new RuntimeException(String.format("the hash output byte cnt should equal to %d", new Object[]{32}));
    }

    static RealVector a(RealMatrix r2, RealVector r3, int r4, int r5) {
        RealMatrix r6 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r2, RealMatrix.class, "com.obric.memorydata.plugin");
        if (r4 != r5) goto L12;
        return r6.operate(r3);
    L12:
        RealVector r1 = r3.getSubVector(0, r4);     // Catch: Exception -> L9
        return r6.operate(r1).append(r3.getSubVector(r4, r5 - r4));
    L9:
        e = move-exception;
        throw new Exception(String.format("there exists an error %s in multiply function", new Object[]{e.getMessage()}));
    }

    static void a(String r2, int r3, int r4) {
        throw new IllegalArgumentException(String.format("the wanted length of %s is %d, not %d", new Object[]{r2, Integer.valueOf(r3), Integer.valueOf(r4)}));
    }

    static boolean a(char r2) {
        if (r2 < '0') goto L8;
        if (r2 > '9') goto L8;
        return true;
    L8:
        if (r2 < 'A') goto L13;
        if (r2 > 'F') goto L13;
        return true;
    L13:
        if (r2 >= 'a') goto L15;
        return false;
    L15:
        if (r2 > 'f') goto L19;
        return true;
    L19:
        return false;
    }

    static byte[] a(double r2) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        r0.putDouble(r2);
        return r0.array();
    }

    static byte[] a(int r0) {
        return com.google.crypto.tink.subtle.d.a(r0);
    }

    static byte[] a(String r8, int r9) {
        int r0 = r8.length();
        if (r0 != r9) goto L15;
        byte[] r10 = new byte[r0 / 2];
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L13;
        if (a(r8.charAt(r3)) == false) goto L12;
        int r4 = r3 + 1;
        if (a(r8.charAt(r4)) == false) goto L12;
        r10[r3 / 2] = (byte) ((Character.digit(r8.charAt(r3), 16) << 4) + Character.digit(r8.charAt(r4), 16));
        r3 = r3 + 2;
    L12:
        throw new IllegalArgumentException(String.format("each character in %s should be a valid hexadecimal character", new Object[]{r8}));
    L13:
        return r10;
    L15:
        throw new IllegalArgumentException(String.format("the size of string s should be equal to %d", new Object[]{Integer.valueOf(r9)}));
    }

    static byte[] a(double[] r7) {
        byte[] r0 = new byte[r7.length * 8];
        int r3 = 0;
    L4:
        if (r3 >= r7.length) goto L6;
        ByteBuffer r4 = ByteBuffer.allocate(8);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        r4.putDouble(r7[r3]);
        System.arraycopy(r4.array(), 0, r0, r3 * 8, 8);
        r3 = r3 + 1;
        goto L4
    L6:
        return r0;
    }

    static double[] a(byte[] r4, int r5) {
        int r0 = r4.length;
        if (r0 == 16) goto L5;
        a("seed", 16, r0);
    L5:
        SecureRandom r1 = new SecureRandom(r4);
        double[] r6 = new double[r5];
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L8;
        r6[r2] = r1.nextGaussian();
        r2 = r2 + 1;
        goto L6
    L8:
        return r6;
    }

    static double[] a(float[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        double[] r0 = new double[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = r4[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static double b(byte[] r3) {
        if (r3.length == 8) goto L5;
        a("inBytes", 8, r3.length);
    L5:
        ByteBuffer r4 = ByteBuffer.wrap(r3);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        return r4.getDouble(0);
    }

    static int b(int r3) {
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(Constants.a.f12a), Integer.valueOf(Constants.KeyType.NOT_SUPPORTED.ordinal()));
        r0.put(Integer.valueOf(Constants.a.f13b), Integer.valueOf(Constants.KeyType.KEY_VERSION_QR.ordinal()));
        r0.put(Integer.valueOf(Constants.a.c), Integer.valueOf(Constants.KeyType.KEY_VERSION_NO_MAT.ordinal()));
        r0.put(Integer.valueOf(Constants.a.d), Integer.valueOf(Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()));
        r0.put(Integer.valueOf(Constants.a.e), Integer.valueOf(Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()));
        if (r0.containsKey(Integer.valueOf(r3)) == false) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r3)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        return Constants.KeyType.NOT_SUPPORTED.ordinal();
    }

    static float[] b(double[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        float[] r0 = new float[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = (float) r4[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static String c(byte[] r6) {
        Formatter r1 = new Formatter(new StringBuilder());
        int r0 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.format("%02x", new Object[]{Byte.valueOf(r6[r3])});
        r3 = r3 + 1;
        goto L3
    L5:
        String r7 = r1.toString();
        r1.close();
        return r7;
    }

    static double d(byte[] r3) {
        int r0 = r3.length;
        if (r0 == 16) goto L6;
        a("seed", 16, r0);
    L6:
        return new SecureRandom(r3).nextDouble();
    }
}
