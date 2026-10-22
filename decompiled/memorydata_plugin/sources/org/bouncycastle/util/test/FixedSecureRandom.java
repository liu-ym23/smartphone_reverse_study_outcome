package org.bouncycastle.util.test;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class FixedSecureRandom extends SecureRandom {
    private static java.math.BigInteger ANDROID;
    private static java.math.BigInteger CLASSPATH;
    private static java.math.BigInteger REGULAR;
    private static final boolean isAndroidStyle = false;
    private static final boolean isClasspathStyle = false;
    private static final boolean isRegularStyle = false;
    private byte[] _data;
    private int _index;

    public static class BigInteger extends Source {
        public BigInteger(int r1, byte[] r2) {
            super(FixedSecureRandom.access$000(r1, r2));
        }

        public BigInteger(byte[] r1) {
            super(r1);
        }
    }

    public static class Data extends Source {
        public Data(byte[] r1) {
            super(r1);
        }
    }

    private static class DummyProvider extends Provider {
        DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    private static class RandomChecker extends SecureRandom {
        byte[] data;
        int index;

        RandomChecker() {
            super(null, new DummyProvider());
            this.data = Hex.decode("01020304ffffffff0506070811111111");
            this.index = 0;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] r5) {
            System.arraycopy(this.data, this.index, r5, 0, r5.length);
            this.index += r5.length;
        }
    }

    public static class Source {
        byte[] data;

        Source(byte[] r1) {
            this.data = r1;
        }
    }

    static {
        REGULAR = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
        ANDROID = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
        CLASSPATH = new java.math.BigInteger("3020104ffffffff05060708111111", 16);
        java.math.BigInteger r0 = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger r1 = new java.math.BigInteger(120, new RandomChecker());
        isAndroidStyle = r0.equals(ANDROID);
        isRegularStyle = r0.equals(REGULAR);
        isClasspathStyle = r1.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] r3) {
        this(new Source[]{new Data(r3)});
    }

    public FixedSecureRandom(Source[] r10) {
        super(null, new DummyProvider());
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r4 = 0;
        if (isRegularStyle == false) goto L28;
        if (isClasspathStyle == false) goto L22;
    L7:
        if (r4 == r10.length) goto L51;
        if (ZeusTransformUtils.instanceOf(r10[r4], BigInteger.class) == false) goto L17;
        byte[] r1 = r10[r4].data;     // Catch: IOException -> L19
        int r5 = r1.length - (r1.length % 4);     // Catch: IOException -> L19
        int r6 = (r1.length - r5) - 1;     // Catch: IOException -> L19
    L11:
        if (r6 < 0) goto L13;
        r0.write(r1[r6]);     // Catch: IOException -> L19
        r6 = r6 - 1;     // Catch: IOException -> L19
        goto L11
    L13:
        int r7 = r1.length - r5;     // Catch: IOException -> L19
    L15:
        if (r7 >= r1.length) goto L18;
        r0.write(r1, r7, 4);     // Catch: IOException -> L19
        r7 = r7 + 4;     // Catch: IOException -> L19
    L18:
        r4 = r4 + 1;
        goto L7
    L17:
        r0.write(r10[r4].data);     // Catch: IOException -> L19
    L20:
        throw new IllegalArgumentException("can't save value source.");
    L51:
        this._data = r0.toByteArray();
        return;
    L22:
        if (r4 == r10.length) goto L51;
        r0.write(r10[r4].data);     // Catch: IOException -> L25
        r4 = r4 + 1;
    L26:
        throw new IllegalArgumentException("can't save value source.");
    L28:
        if (isAndroidStyle == false) goto L54;
        int r2 = 0;
    L31:
        if (r2 == r10.length) goto L51;
        if (ZeusTransformUtils.instanceOf(r10[r2], BigInteger.class) == false) goto L47;
        byte[] r8 = r10[r2].data;     // Catch: IOException -> L49
        int r9 = r8.length - (r8.length % 4);     // Catch: IOException -> L49
        int r11 = 0;
    L35:
        if (r11 >= r9) goto L38;
        r11 = r11 + 4;     // Catch: IOException -> L49
        r0.write(r8, r8.length - r11, 4);     // Catch: IOException -> L49
        goto L35
    L38:
        if ((r8.length - r9) == 0) goto L43;
        int r12 = 0;
    L41:
        if (r12 == (4 - (r8.length - r9))) goto L43;
        r0.write(0);     // Catch: IOException -> L49
        r12 = r12 + 1;     // Catch: IOException -> L49
    L43:
        int r13 = 0;
    L45:
        if (r13 == (r8.length - r9)) goto L48;
        r0.write(r8[r9 + r13]);     // Catch: IOException -> L49
        r13 = r13 + 1;     // Catch: IOException -> L49
    L48:
        r2 = r2 + 1;
        goto L31
    L47:
        r0.write(r10[r2].data);     // Catch: IOException -> L49
    L50:
        throw new IllegalArgumentException("can't save value source.");
    L54:
        throw new IllegalStateException("Unrecognized BigInteger implementation");
    }

    public FixedSecureRandom(byte[][] r1) {
        this(buildDataArray(r1));
    }

    static /* synthetic */ byte[] access$000(int r0, byte[] r1) {
        return expandToBitLength(r0, r1);
    }

    private static Data[] buildDataArray(byte[][] r4) {
        Data[] r0 = new Data[r4.length];
        int r1 = 0;
    L4:
        if (r1 == r4.length) goto L6;
        r0[r1] = new Data(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static byte[] expandToBitLength(int r4, byte[] r5) {
        int r0 = (r4 + 7) / 8;
        if (r0 <= r5.length) goto L11;
        byte[] r1 = new byte[r0];
        System.arraycopy(r5, 0, r1, r0 - r5.length, r5.length);
        if (isAndroidStyle == false) goto L9;
        int r6 = r4 % 8;
        if (r6 == 0) goto L9;
        Pack.intToBigEndian(Pack.bigEndianToInt(r1, 0) << (8 - r6), r1, 0);
    L9:
        return r1;
    L11:
        if (isAndroidStyle == true) goto L13;
    L17:
        return r5;
    L13:
        if (r4 >= (r5.length * 8)) goto L17;
        int r7 = r4 % 8;
        if (r7 == 0) goto L17;
        Pack.intToBigEndian(Pack.bigEndianToInt(r5, 0) << (8 - r7), r5, 0);
        goto L17
    }

    private int nextValue() {
        byte[] r0 = this._data;
        int r1 = this._index;
        this._index = r1 + 1;
        return r0[r1] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r1) {
        byte[] r2 = new byte[r1];
        nextBytes(r2);
        return r2;
    }

    public boolean isExhausted() {
        if (this._index != this._data.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r5) {
        System.arraycopy(this._data, this._index, r5, 0, r5.length);
        this._index += r5.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int r0 = (((nextValue() << 24) | 0) | (nextValue() << 16)) | (nextValue() << 8);
        return nextValue() | r0;
    }

    @Override // java.util.Random
    public long nextLong() {
        return ((((((((((long) nextValue()) << 56) | 0) | (((long) nextValue()) << 48)) | (((long) nextValue()) << 40)) | (((long) nextValue()) << 32)) | (((long) nextValue()) << 24)) | (((long) nextValue()) << 16)) | (((long) nextValue()) << 8)) | ((long) nextValue());
    }
}
