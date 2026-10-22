package kotlin.internal;

import kotlin.PublishedApi;

/* JADX INFO: loaded from: classes2.dex */
public final class ProgressionUtilKt {
    private static final int differenceModulo(int r10, int r11, int r12) {
        return mod(mod(r10, r12) - mod(r11, r12), r12);
    }

    private static final long differenceModulo(long r10, long r11, long r12) {
        return mod(mod(r10, r12) - mod(r11, r12), r12);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int r10, int r11, int r12) {
        if (r12 <= 0) goto L6;
        if (r10 < r11) goto L13;
        return r11;
    L13:
        return r11 - differenceModulo(r11, r10, r12);
    L6:
        if (r12 >= 0) goto L12;
        if (r10 > r11) goto L10;
        return r11;
    L10:
        return r11 + differenceModulo(r10, r11, -r12);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }

    @PublishedApi
    public static final long getProgressionLastElement(long r10, long r11, long r12) {
        if (r12 > 0) goto L5;
        if (r12 >= 0) goto L15;
        if (r10 > r11) goto L13;
        return r11;
    L13:
        return r11 + differenceModulo(r10, r11, -r12);
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (r10 < r11) goto L16;
        return r11;
    L16:
        return r11 - differenceModulo(r11, r10, r12);
    }

    private static final int mod(int r10, int r11) {
        int r12 = r10 % r11;
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return r12 + r11;
    }

    private static final long mod(long r10, long r11) {
        long r12 = r10 % r11;
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return r12 + r11;
    }
}
