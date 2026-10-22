package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ProgressionUtilKt {
    private static final int differenceModulo(int r5, int r10, int r11) {
        return mod(mod(r5, r11) - mod(r10, r11), r11);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int r5, int r10, int r11) {
        if (r11 <= 0) goto L6;
        if (r5 < r10) goto L13;
        return r10;
    L13:
        return r10 - differenceModulo(r10, r5, r11);
    L6:
        if (r11 >= 0) goto L12;
        if (r5 > r10) goto L10;
        return r10;
    L10:
        return r10 + differenceModulo(r5, r10, -r11);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int r5, int r10) {
        int r11 = r5 % r10;
        if (r11 < 0) goto L6;
        return r11;
    L6:
        return r11 + r10;
    }

    private static final long differenceModulo(long r5, long r10, long r11) {
        return mod(mod(r5, r11) - mod(r10, r11), r11);
    }

    private static final long mod(long r5, long r10) {
        long r11 = r5 % r10;
        if (r11 < 0) goto L6;
        return r11;
    L6:
        return r11 + r10;
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
}
