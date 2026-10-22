package n12;

import com.bytedance.android.livesdk.gift.configmodel.k1;
import kotlin.collections.ArraysKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements f {
    public static final Integer[] a = null;
    public static final Long[] b = null;
    public static final Integer[] c = null;
    public static final Integer[] d = null;

    public static final class a {
    }

    public c() {
    }

    static {
        a = new Integer[]{200, 700, 6000, 10000};
        b = new Long[]{1000L, 1500L, 1500L, 1500L, 2000L};
        c = new Integer[]{2131249612, 2131249617, 2131249622, 2131249627, 2131249632};
        d = new Integer[]{2131249615, 2131249620, 2131249625, 2131249630, 2131249635};
    }

    public static int m(long r4) {
        int r5 = n(r4);
        ReadOnlyProperty r6 = com.bytedance.android.livesdk.gift.platform.business.e.t;
        KProperty[] r0 = com.bytedance.android.livesdk.gift.platform.business.e.a;
        if (r5 > ((k1) r6.getValue(null, r0[18])).b().length) goto L7;
        Integer r7 = (Integer) ArraysKt.getOrNull(((k1) r6.getValue(null, r0[18])).b(), r5);
        if (r7 == null) goto L7;
        return r7.intValue();
    L7:
        return 0;
    }

    public static int n(long r5) {
        Integer[] r0 = a;
        int r1 = 0;
        if (r5 >= r0[0].intValue()) goto L6;
        return 0;
    L6:
        if (r1 >= 4) goto L11;
        if (r5 < r0[r1].intValue()) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return 4;
    }

    @Override // n12.f
    public final int b(long r1) {
        int r2 = n(r1);
        if (r2 < 5) goto L7;
        return 2131249612;
    L7:
        return c[r2].intValue();
    }

    @Override // n12.f
    public final int c(long r1) {
        int r2 = n(r1);
        if (r2 < 5) goto L7;
        return 2131249615;
    L7:
        return d[r2].intValue();
    }

    @Override // n12.f
    public final long i(long r4, float r6) {
        if (r6 > 0.0f) goto L6;
        r6 = 1.0f;
    L6:
        if (r4 < 28888) goto L9;
        long r5 = 7975;
    L22:
        return RangesKt.coerceAtLeast((long) (r5 / r6), 1000);
    L9:
        if (r4 < 10001) goto L12;
        r5 = 6975;
        goto L22
    L12:
        if (r4 < 3000) goto L15;
        r5 = 5975;
        goto L22
    L15:
        if (r4 < 399) goto L18;
        r5 = 3975;
        goto L22
    L18:
        if (r4 < 66) goto L20;
        r5 = 2975;
        goto L22
    L20:
        r5 = 1975;
        goto L22
    }

    @Override // n12.f
    public final long k(long r3, float r5) {
        Long[] r0 = b;
        int r4 = m(r3);
        if (r4 >= 5) goto L5;
        Long r6 = r0[r4];
    L7:
        if (r6 == null) goto L9;
        long r7 = r6.longValue();
    L11:
        return RangesKt.coerceAtLeast((long) (r7 / r5), 1000);
    L9:
        r7 = 1000;
        goto L11
    L5:
        r6 = null;
        goto L7
    }
}
