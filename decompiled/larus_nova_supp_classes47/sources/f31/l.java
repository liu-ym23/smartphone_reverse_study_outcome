package f31;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final int a(List<k> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$height");
        Intrinsics.checkNotNullParameter(r4, "$this$endY");
        Iterator<T> r0 = r4.iterator();
        if (r0.hasNext() == false) goto L13;
        k r1 = (k) r0.next();
        int r2 = r1.d + r1.f;
    L6:
        if (r0.hasNext() == false) goto L11;
        k r3 = (k) r0.next();
        int r5 = r3.d;
        int r6 = r3.f + r5;
        if (r2 >= r6) goto L6;
        r2 = r6;
        goto L6
    L11:
        return r2 - d(r4);
    L13:
        throw new NoSuchElementException();
    }

    public static final boolean b(f r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isGameLink");
        List<k> r4 = r3.a;
        boolean r0 = false;
        if (r4 == null) goto L10;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((k) r5.next()).a, "mock_game_uid") == false) goto L6;
        r0 = true;
    L10:
        return r0;
    }

    public static final int c(List<k> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$startX");
        Iterator<T> r3 = r2.iterator();
        if (r3.hasNext() == false) goto L12;
        int r0 = ((k) r3.next()).c;
    L6:
        if (r3.hasNext() == false) goto L10;
        int r1 = ((k) r3.next()).c;
        if (r0 <= r1) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    public static final int d(List<k> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$startY");
        Iterator<T> r3 = r2.iterator();
        if (r3.hasNext() == false) goto L12;
        int r0 = ((k) r3.next()).d;
    L6:
        if (r3.hasNext() == false) goto L10;
        int r1 = ((k) r3.next()).d;
        if (r0 <= r1) goto L6;
        r0 = r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    public static final int e(List<k> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$width");
        Intrinsics.checkNotNullParameter(r4, "$this$endX");
        Iterator<T> r0 = r4.iterator();
        if (r0.hasNext() == false) goto L13;
        k r1 = (k) r0.next();
        int r2 = r1.c + r1.e;
    L6:
        if (r0.hasNext() == false) goto L11;
        k r3 = (k) r0.next();
        int r5 = r3.c;
        int r6 = r3.e + r5;
        if (r2 >= r6) goto L6;
        r2 = r6;
        goto L6
    L11:
        return r2 - c(r4);
    L13:
        throw new NoSuchElementException();
    }
}
