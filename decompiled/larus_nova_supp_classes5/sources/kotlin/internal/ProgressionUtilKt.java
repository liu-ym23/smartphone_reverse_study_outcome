package kotlin.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ProgressionUtilKt {
    private static final long mod(long r3, long r5) {
        long r4 = r3 % r5;
        if (r4 < 0) goto L6;
        return r4;
    L6:
        return r4 + r5;
    }

    private static final int mod(int r0, int r1) {
        int r2 = r0 % r1;
        if (r2 < 0) goto L6;
        return r2;
    L6:
        return r2 + r1;
    }

    private static final int differenceModulo(int r0, int r1, int r2) {
        return mod(mod(r0, r2) - mod(r1, r2), r2);
    }

    public static final long getProgressionLastElement(long r7, long r9, long r11) {
        if (r11 > 0) goto L5;
        if (r11 >= 0) goto L15;
        if (r7 > r9) goto L13;
        return r9;
    L13:
        return r9 + differenceModulo(r7, r9, -r11);
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (r7 < r9) goto L16;
        return r9;
    L16:
        return r9 - differenceModulo(r9, r7, r11);
    }

    private static final long differenceModulo(long r0, long r2, long r4) {
        return mod(mod(r0, r4) - mod(r2, r4), r4);
    }

    public static final int getProgressionLastElement(int r0, int r1, int r2) {
        if (r2 <= 0) goto L6;
        if (r0 < r1) goto L13;
        return r1;
    L13:
        return r1 - differenceModulo(r1, r0, r2);
    L6:
        if (r2 >= 0) goto L12;
        if (r0 > r1) goto L10;
        return r1;
    L10:
        return r1 + differenceModulo(r0, r1, -r2);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }
}
