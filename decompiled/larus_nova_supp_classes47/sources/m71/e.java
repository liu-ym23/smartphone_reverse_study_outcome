package m71;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        return ((n71.a) b.a.getValue()).b();
    }

    public static boolean b() {
        return ((n71.a) b.a.getValue()).c();
    }

    public static boolean d() {
        return ((n71.a) b.a.getValue()).f();
    }

    static {
    }

    public static boolean c(int r6) {
        b r0 = b.a;
        Map<String, Boolean> r1 = ((n71.a) r0.getValue()).i();
        if (r1 != null) goto L5;
    L7:
        Map<String, Boolean> r2 = ((n71.a) r0.getValue()).i();
        if (r2 == null) goto L13;
        Boolean r7 = r2.get(String.valueOf(r6));
        if (r7 != null) goto L12;
        return true;
    L12:
        return r7.booleanValue();
    L13:
        return true;
    L5:
        if (r1.isEmpty() != true) goto L7;
        ((n71.a) r0.getValue()).l(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("10", Boolean.FALSE)}));
        goto L7
    }
}
