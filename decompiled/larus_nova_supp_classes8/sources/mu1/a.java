package mu1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ju1.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nu1.d;
import nu1.e;
import ou1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final Map<String, l> a = null;
    public static final List<e> b = null;
    public static final List<d> c = null;

    static {
        a = new LinkedHashMap();
        b = new ArrayList();
        ArrayList r0 = new ArrayList();
        c = r0;
        nu1.a r2 = nu1.a.a;
        r0.add(new c());
    }

    @JvmStatic
    public static final boolean a(l r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "stateMap");
        Iterator<T> r0 = c.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        d r1 = (d) r0.next();
        if (r1.b(r3) == false) goto L4;
        return r1.a(r3, r4);
    L10:
        return r3.a();
    }
}
