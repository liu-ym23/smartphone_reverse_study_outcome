package androidx.core.math;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int r10, int r11) {
        int r12 = r10 + r11;
        if (((r10 ^ r12) & (r11 ^ r12)) < 0) goto L6;
        return r12;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long r10, long r11) {
        long r12 = r10 + r11;
        if (((r10 ^ r12) & (r11 ^ r12)) < 0) goto L6;
        return r12;
    L6:
        throw new ArithmeticException("long overflow");
    }

    public static double clamp(double r10, double r11, double r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 <= r12) goto L8;
        return r12;
    L8:
        return r10;
    }

    public static float clamp(float r10, float r11, float r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 <= r12) goto L8;
        return r12;
    L8:
        return r10;
    }

    public static int clamp(int r10, int r11, int r12) {
        if (r10 >= r11) goto L4;
        return r11;
    L4:
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        return r10;
    }

    public static long clamp(long r10, long r11, long r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 <= r12) goto L8;
        return r12;
    L8:
        return r10;
    }

    public static int decrementExact(int r10) {
        if (r10 == Integer.MIN_VALUE) goto L7;
        return r10 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long r10) {
        if (r10 == Long.MIN_VALUE) goto L7;
        return r10 - 1;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int incrementExact(int r10) {
        if (r10 == Integer.MAX_VALUE) goto L7;
        return r10 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long r10) {
        if (r10 == Long.MAX_VALUE) goto L7;
        return r10 + 1;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int multiplyExact(int r10, int r11) {
        long r12 = ((long) r10) * ((long) r11);
        int r13 = (int) r12;
        if (r13 != r12) goto L6;
        return r13;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long multiplyExact(long r10, long r11) {
        long r12 = r10 * r11;
        if (((Math.abs(r10) | Math.abs(r11)) >>> 31) != 0) goto L5;
    L15:
        return r12;
    L5:
        if (r11 == 0) goto L9;
        if ((r12 / r11) == r10) goto L9;
    L14:
        throw new ArithmeticException("long overflow");
    L9:
        if (r10 != Long.MIN_VALUE) goto L15;
        if (r11 == (-1)) goto L14;
        goto L15
    }

    public static int negateExact(int r10) {
        if (r10 == Integer.MIN_VALUE) goto L7;
        return -r10;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long r10) {
        if (r10 == Long.MIN_VALUE) goto L7;
        return -r10;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int subtractExact(int r10, int r11) {
        int r12 = r10 - r11;
        int r13 = r11 ^ r10;
        if (((r10 ^ r12) & r13) < 0) goto L6;
        return r12;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long r10, long r11) {
        long r12 = r10 - r11;
        long r13 = r11 ^ r10;
        if (((r10 ^ r12) & r13) < 0) goto L6;
        return r12;
    L6:
        throw new ArithmeticException("long overflow");
    }

    public static int toIntExact(long r10) {
        int r11 = (int) r10;
        if (r11 != r10) goto L6;
        return r11;
    L6:
        throw new ArithmeticException("integer overflow");
    }
}
