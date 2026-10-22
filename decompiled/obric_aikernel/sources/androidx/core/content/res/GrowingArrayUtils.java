package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static int[] append(int[] r10, int r11, int r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        int[] r13 = new int[growSize(r11)];
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static long[] append(long[] r10, int r11, long r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        long[] r13 = new long[growSize(r11)];
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static <T> T[] append(T[] r10, int r11, T r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        Object[] r13 = (Object[]) Array.newInstance(r10.getClass().getComponentType(), growSize(r11));
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = (T[]) r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static boolean[] append(boolean[] r10, int r11, boolean r12) {
        if ((r11 + 1) <= r10.length) goto L5;
        boolean[] r13 = new boolean[growSize(r11)];
        System.arraycopy(r10, 0, r13, 0, r11);
        r10 = r13;
    L5:
        r10[r11] = r12;
        return r10;
    }

    public static int growSize(int r10) {
        if (r10 > 4) goto L6;
        return 8;
    L6:
        return r10 * 2;
    }

    public static int[] insert(int[] r10, int r11, int r12, int r13) {
        if ((r11 + 1) > r10.length) goto L6;
        System.arraycopy(r10, r12, r10, r12 + 1, r11 - r12);
        r10[r12] = r13;
        return r10;
    L6:
        int[] r14 = new int[growSize(r11)];
        System.arraycopy(r10, 0, r14, 0, r12);
        r14[r12] = r13;
        System.arraycopy(r10, r12, r14, r12 + 1, r10.length - r12);
        return r14;
    }

    public static long[] insert(long[] r10, int r11, int r12, long r13) {
        if ((r11 + 1) > r10.length) goto L6;
        System.arraycopy(r10, r12, r10, r12 + 1, r11 - r12);
        r10[r12] = r13;
        return r10;
    L6:
        long[] r14 = new long[growSize(r11)];
        System.arraycopy(r10, 0, r14, 0, r12);
        r14[r12] = r13;
        System.arraycopy(r10, r12, r14, r12 + 1, r10.length - r12);
        return r14;
    }

    public static <T> T[] insert(T[] r10, int r11, int r12, T r13) {
        if ((r11 + 1) > r10.length) goto L6;
        System.arraycopy(r10, r12, r10, r12 + 1, r11 - r12);
        r10[r12] = r13;
        return r10;
    L6:
        T[] r14 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), growSize(r11)));
        System.arraycopy(r10, 0, r14, 0, r12);
        r14[r12] = r13;
        System.arraycopy(r10, r12, r14, r12 + 1, r10.length - r12);
        return r14;
    }

    public static boolean[] insert(boolean[] r10, int r11, int r12, boolean r13) {
        if ((r11 + 1) > r10.length) goto L6;
        System.arraycopy(r10, r12, r10, r12 + 1, r11 - r12);
        r10[r12] = r13;
        return r10;
    L6:
        boolean[] r14 = new boolean[growSize(r11)];
        System.arraycopy(r10, 0, r14, 0, r12);
        r14[r12] = r13;
        System.arraycopy(r10, r12, r14, r12 + 1, r10.length - r12);
        return r14;
    }
}
