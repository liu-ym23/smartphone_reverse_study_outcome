package androidx.core.math;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int r5, int r10) {
        int r11 = r5 + r10;
        boolean r12 = false;
        if (r5 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r10 < 0) goto L8;
        boolean r14 = true;
    L9:
        if (r13 != r14) goto L19;
        if (r5 < 0) goto L12;
        boolean r15 = true;
    L13:
        if (r11 < 0) goto L15;
        r12 = true;
    L15:
        if (r15 == r12) goto L19;
        throw new ArithmeticException("integer overflow");
    L12:
        r15 = false;
    L19:
        return r11;
    L8:
        r14 = false;
        goto L9
    L5:
        r13 = false;
        goto L6
    }

    public static double clamp(double r5, double r10, double r11) {
        if (r5 >= r10) goto L6;
        return r10;
    L6:
        if (r5 <= r11) goto L8;
        return r11;
    L8:
        return r5;
    }

    public static int decrementExact(int r5) {
        if (r5 == Integer.MIN_VALUE) goto L7;
        return r5 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int r5) {
        if (r5 == Integer.MAX_VALUE) goto L7;
        return r5 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int r5, int r10) {
        int r11 = r5 * r10;
        if (r5 == 0) goto L12;
        if (r10 == 0) goto L12;
        if ((r11 / r5) != r10) goto L11;
        if ((r11 / r10) == r5) goto L12;
    L11:
        throw new ArithmeticException("integer overflow");
    L12:
        return r11;
    }

    public static int negateExact(int r5) {
        if (r5 == Integer.MIN_VALUE) goto L7;
        return -r5;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int r5, int r10) {
        int r11 = r5 - r10;
        boolean r12 = false;
        if (r5 >= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r10 >= 0) goto L8;
        boolean r14 = true;
    L9:
        if (r13 == r14) goto L19;
        if (r5 >= 0) goto L12;
        boolean r15 = true;
    L13:
        if (r11 >= 0) goto L15;
        r12 = true;
    L15:
        if (r15 == r12) goto L19;
        throw new ArithmeticException("integer overflow");
    L12:
        r15 = false;
    L19:
        return r11;
    L8:
        r14 = false;
        goto L9
    L5:
        r13 = false;
        goto L6
    }

    public static int toIntExact(long r5) {
        if (r5 > 2147483647L) goto L9;
        if (r5 < (-2147483648L)) goto L9;
        return (int) r5;
    L9:
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long r10, long r11) {
        long r5 = r10 + r11;
        boolean r12 = false;
        if (r10 < 0) goto L5;
        boolean r13 = true;
    L7:
        if (r11 < 0) goto L9;
        boolean r14 = true;
    L10:
        if (r13 != r14) goto L21;
        if (r10 < 0) goto L13;
        boolean r15 = true;
    L15:
        if (r5 < 0) goto L17;
        r12 = true;
    L17:
        if (r15 == r12) goto L21;
        throw new ArithmeticException("integer overflow");
    L13:
        r15 = false;
    L21:
        return r5;
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public static float clamp(float r5, float r10, float r11) {
        if (r5 >= r10) goto L6;
        return r10;
    L6:
        if (r5 <= r11) goto L8;
        return r11;
    L8:
        return r5;
    }

    public static long decrementExact(long r5) {
        if (r5 == Long.MIN_VALUE) goto L7;
        return r5 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long r5) {
        if (r5 == Long.MAX_VALUE) goto L7;
        return r5 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long r5) {
        if (r5 == Long.MIN_VALUE) goto L7;
        return -r5;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long r10, long r11) {
        long r5 = r10 - r11;
        boolean r12 = false;
        if (r10 >= 0) goto L5;
        boolean r13 = true;
    L7:
        if (r11 >= 0) goto L9;
        boolean r14 = true;
    L10:
        if (r13 == r14) goto L21;
        if (r10 >= 0) goto L13;
        boolean r15 = true;
    L15:
        if (r5 >= 0) goto L17;
        r12 = true;
    L17:
        if (r15 == r12) goto L21;
        throw new ArithmeticException("integer overflow");
    L13:
        r15 = false;
    L21:
        return r5;
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public static int clamp(int r5, int r10, int r11) {
        if (r5 >= r10) goto L4;
        return r10;
    L4:
        if (r5 <= r11) goto L6;
        return r11;
    L6:
        return r5;
    }

    public static long multiplyExact(long r5, long r10) {
        long r11 = r5 * r10;
        if (r5 != 0) goto L5;
    L13:
        return r11;
    L5:
        if (r10 == 0) goto L13;
        if ((r11 / r5) != r10) goto L12;
        if ((r11 / r10) == r5) goto L13;
    L12:
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long r5, long r10, long r11) {
        if (r5 >= r10) goto L6;
        return r10;
    L6:
        if (r5 <= r11) goto L8;
        return r11;
    L8:
        return r5;
    }
}
