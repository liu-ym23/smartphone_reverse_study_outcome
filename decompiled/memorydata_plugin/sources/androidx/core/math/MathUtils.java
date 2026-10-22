package androidx.core.math;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int r4, int r5) {
        int r0 = r4 + r5;
        boolean r1 = true;
        if (r4 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r5 < 0) goto L8;
        boolean r6 = true;
    L9:
        if (r3 != r6) goto L20;
        if (r4 < 0) goto L12;
        boolean r7 = true;
    L13:
        if (r0 >= 0) goto L16;
        r1 = false;
    L16:
        if (r7 == r1) goto L20;
        throw new ArithmeticException("integer overflow");
    L12:
        r7 = false;
    L20:
        return r0;
    L8:
        r6 = false;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public static long addExact(long r6, long r8) {
        long r0 = r6 + r8;
        boolean r7 = true;
        if (r6 < 0) goto L5;
        boolean r5 = true;
    L7:
        if (r8 < 0) goto L9;
        boolean r9 = true;
    L10:
        if (r5 != r9) goto L22;
        if (r6 < 0) goto L13;
        boolean r10 = true;
    L15:
        if (r0 >= 0) goto L18;
        r7 = false;
    L18:
        if (r10 == r7) goto L22;
        throw new ArithmeticException("integer overflow");
    L13:
        r10 = false;
    L22:
        return r0;
    L9:
        r9 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public static double clamp(double r1, double r3, double r5) {
        if (r1 >= r3) goto L6;
        return r3;
    L6:
        if (r1 <= r5) goto L8;
        return r5;
    L8:
        return r1;
    }

    public static float clamp(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        if (r1 <= r3) goto L8;
        return r3;
    L8:
        return r1;
    }

    public static int clamp(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    public static long clamp(long r1, long r3, long r5) {
        if (r1 >= r3) goto L6;
        return r3;
    L6:
        if (r1 <= r5) goto L8;
        return r5;
    L8:
        return r1;
    }

    public static int decrementExact(int r1) {
        if (r1 == Integer.MIN_VALUE) goto L7;
        return r1 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long r2) {
        if (r2 == Long.MIN_VALUE) goto L7;
        return r2 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int r1) {
        if (r1 == Integer.MAX_VALUE) goto L7;
        return r1 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long r2) {
        if (r2 == Long.MAX_VALUE) goto L7;
        return r2 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int r2, int r3) {
        int r0 = r2 * r3;
        if (r2 == 0) goto L12;
        if (r3 == 0) goto L12;
        if ((r0 / r2) != r3) goto L11;
        if ((r0 / r3) == r2) goto L12;
    L11:
        throw new ArithmeticException("integer overflow");
    L12:
        return r0;
    }

    public static long multiplyExact(long r5, long r7) {
        long r0 = r5 * r7;
        if (r5 != 0) goto L5;
    L13:
        return r0;
    L5:
        if (r7 == 0) goto L13;
        if ((r0 / r5) != r7) goto L12;
        if ((r0 / r7) == r5) goto L13;
    L12:
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int r1) {
        if (r1 == Integer.MIN_VALUE) goto L7;
        return -r1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long r2) {
        if (r2 == Long.MIN_VALUE) goto L7;
        return -r2;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int r4, int r5) {
        int r0 = r4 - r5;
        boolean r1 = true;
        if (r4 >= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r5 >= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r3 == r6) goto L20;
        if (r4 >= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r0 < 0) goto L16;
        r1 = false;
    L16:
        if (r7 == r1) goto L20;
        throw new ArithmeticException("integer overflow");
    L12:
        r7 = false;
    L20:
        return r0;
    L8:
        r6 = false;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public static long subtractExact(long r6, long r8) {
        long r0 = r6 - r8;
        boolean r7 = true;
        if (r6 >= 0) goto L5;
        boolean r5 = true;
    L7:
        if (r8 >= 0) goto L9;
        boolean r9 = true;
    L10:
        if (r5 == r9) goto L22;
        if (r6 >= 0) goto L13;
        boolean r10 = true;
    L15:
        if (r0 < 0) goto L18;
        r7 = false;
    L18:
        if (r10 == r7) goto L22;
        throw new ArithmeticException("integer overflow");
    L13:
        r10 = false;
    L22:
        return r0;
    L9:
        r9 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public static int toIntExact(long r2) {
        if (r2 > 2147483647L) goto L9;
        if (r2 < (-2147483648L)) goto L9;
        return (int) r2;
    L9:
        throw new ArithmeticException("integer overflow");
    }
}
