package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static <T> T[] append(T[] r5, int r10, T r11) {
        if ((r10 + 1) <= r5.length) goto L5;
        Object[] r12 = (Object[]) Array.newInstance(r5.getClass().getComponentType(), growSize(r10));
        System.arraycopy(r5, 0, r12, 0, r10);
        r5 = (T[]) r12;
    L5:
        r5[r10] = r11;
        return r5;
    }

    public static int growSize(int r5) {
        if (r5 > 4) goto L6;
        return 8;
    L6:
        return r5 * 2;
    }

    public static <T> T[] insert(T[] r5, int r10, int r11, T r12) {
        if ((r10 + 1) > r5.length) goto L6;
        System.arraycopy(r5, r11, r5, r11 + 1, r10 - r11);
        r5[r11] = r12;
        return r5;
    L6:
        T[] r13 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), growSize(r10)));
        System.arraycopy(r5, 0, r13, 0, r11);
        r13[r11] = r12;
        System.arraycopy(r5, r11, r13, r11 + 1, r5.length - r11);
        return r13;
    }

    public static int[] append(int[] r5, int r10, int r11) {
        if ((r10 + 1) <= r5.length) goto L5;
        int[] r12 = new int[growSize(r10)];
        System.arraycopy(r5, 0, r12, 0, r10);
        r5 = r12;
    L5:
        r5[r10] = r11;
        return r5;
    }

    public static int[] insert(int[] r5, int r10, int r11, int r12) {
        if ((r10 + 1) > r5.length) goto L6;
        System.arraycopy(r5, r11, r5, r11 + 1, r10 - r11);
        r5[r11] = r12;
        return r5;
    L6:
        int[] r13 = new int[growSize(r10)];
        System.arraycopy(r5, 0, r13, 0, r11);
        r13[r11] = r12;
        System.arraycopy(r5, r11, r13, r11 + 1, r5.length - r11);
        return r13;
    }

    public static long[] append(long[] r5, int r10, long r11) {
        if ((r10 + 1) <= r5.length) goto L5;
        long[] r12 = new long[growSize(r10)];
        System.arraycopy(r5, 0, r12, 0, r10);
        r5 = r12;
    L5:
        r5[r10] = r11;
        return r5;
    }

    public static boolean[] append(boolean[] r5, int r10, boolean r11) {
        if ((r10 + 1) <= r5.length) goto L5;
        boolean[] r12 = new boolean[growSize(r10)];
        System.arraycopy(r5, 0, r12, 0, r10);
        r5 = r12;
    L5:
        r5[r10] = r11;
        return r5;
    }

    public static long[] insert(long[] r5, int r10, int r11, long r12) {
        if ((r10 + 1) > r5.length) goto L6;
        System.arraycopy(r5, r11, r5, r11 + 1, r10 - r11);
        r5[r11] = r12;
        return r5;
    L6:
        long[] r13 = new long[growSize(r10)];
        System.arraycopy(r5, 0, r13, 0, r11);
        r13[r11] = r12;
        System.arraycopy(r5, r11, r13, r11 + 1, r5.length - r11);
        return r13;
    }

    public static boolean[] insert(boolean[] r5, int r10, int r11, boolean r12) {
        if ((r10 + 1) > r5.length) goto L6;
        System.arraycopy(r5, r11, r5, r11 + 1, r10 - r11);
        r5[r11] = r12;
        return r5;
    L6:
        boolean[] r13 = new boolean[growSize(r10)];
        System.arraycopy(r5, 0, r13, 0, r11);
        r13[r11] = r12;
        System.arraycopy(r5, r11, r13, r11 + 1, r5.length - r11);
        return r13;
    }
}
