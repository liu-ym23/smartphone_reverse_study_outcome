package ia8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.a0;
import ouc.d0;
import ouc.g0;
import ouc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final Object a(i r2) {
        if ((r2 instanceof d0) == false) goto L6;
        return c((d0) r2);
    L6:
        if ((r2 instanceof ouc.b) == false) goto L13;
        Iterable r3 = (Iterable) r2;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L40;
        r0.add(a((i) r4.next()));
        goto L9
    L40:
        return r0;
    L13:
        if ((r2 instanceof g0) == false) goto L36;
        g0 r5 = (g0) r2;
        if (r5.c() == true) goto L41;
        Boolean r1 = ouc.k.f(r5);
        if (r1 != null) goto L42;
        Long r6 = ouc.k.q(r5);
        if (r6 != null) goto L43;
        Integer r7 = ouc.k.l(r5);
        if (r7 != null) goto L44;
        Double r8 = ouc.k.i(r5);
        if (r8 != null) goto L45;
        Float r9 = ouc.k.j(r5);
        if (r9 != null) goto L46;
        String r10 = ouc.k.g(r5);
        if (r10 != null) goto L48;
        return "";
    L48:
        return r10;
    L46:
        return Float.valueOf(r9.floatValue());
    L45:
        return Double.valueOf(r8.doubleValue());
    L44:
        return Integer.valueOf(r7.intValue());
    L43:
        return Long.valueOf(r6.longValue());
    L42:
        return Boolean.valueOf(r1.booleanValue());
    L41:
        return r5.a();
    L36:
        Intrinsics.areEqual(r2, a0.INSTANCE);
        return null;
    }

    public static final Map<String, Object> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        d0 r3 = ouc.a.d.e(r2);     // Catch: Throwable -> L9
        if ((r3 instanceof d0) == false) goto L6;
        d0 r4 = r3;     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L15;
        r0 = r5;
    L15:
        d0 r6 = (d0) r0;
        if (r6 != null) goto L20;
        return MapsKt.emptyMap();
    L20:
        return c(r6);
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final Map<String, Object> c(d0 r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Set r4 = r3.entrySet();
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getKey();
        Object r6 = a((i) r1.getValue());
        if (r6 == null) goto L8;
        Pair r7 = TuplesKt.to(r2, r6);
    L9:
        if (r7 == null) goto L4;
        r0.add(r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    L12:
        return MapsKt.toMap(r0);
    }
}
