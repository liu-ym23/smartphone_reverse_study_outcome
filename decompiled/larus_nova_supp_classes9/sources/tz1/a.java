package tz1;

import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final Map<Integer, Integer> a = null;
    public static final Map<Integer, Integer> b = null;
    public static final Set<Integer> c = null;

    public static String a(int r1) {
        if (r1 != 0) goto L4;
        return "default";
    L4:
        if (r1 != 1) goto L6;
        return "asc";
    L6:
        if (r1 == 2) goto L8;
        return BuildConfig.FLAVOR;
    L8:
        return "desc";
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, 0), TuplesKt.to(0, 1), TuplesKt.to(1, 2)});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, 0), TuplesKt.to(0, 2), TuplesKt.to(2, 1)});
        c = SetsKt.setOf(1);
    }

    public static String b() {
        return a(b.p(b.f()));
    }

    public static int c(int r4) {
        int r0 = ((Number) nz1.a.c.getValue(null, nz1.a.a[1])).intValue();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
        Integer r5 = a.get(Integer.valueOf(r4));
        if (r5 == null) goto L14;
        return r5.intValue();
    L6:
        if (r0 != 2) goto L14;
        Integer r6 = b.get(Integer.valueOf(r4));
        if (r6 == null) goto L14;
        return r6.intValue();
    L14:
        return 0;
    }

    public static boolean d(int r4) {
        if (((Number) nz1.a.c.getValue(null, nz1.a.a[1])).intValue() != 0) goto L5;
    L9:
        return false;
    L5:
        if (c.contains(Integer.valueOf(r4)) == false) goto L9;
        if (u.r() == true) goto L9;
        return true;
    }
}
