package kotlinx.serialization.json.internal;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import luc.f;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u {
    public static final p.a<Map<String, Integer>> a = null;

    static {
        a = new p.a();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlinx.serialization.json.internal.t] */
    public static final Map<String, Integer> b(final ouc.a r5, final f r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        p r0 = r5.c;
        p.a<Map<String, Integer>> r2 = a;
        ?? r3 = new t(r6, r5);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        Object r4 = r0.a(r6, r2);
        if (r4 != null) goto L10;
        r4 = r3.invoke();
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        ConcurrentHashMap r7 = (ConcurrentHashMap) r0.a;
        Object r1 = r7.get(r6);
        if (r1 != null) goto L8;
        r1 = new ConcurrentHashMap(2);
        r7.put(r6, r1);
    L8:
        ((Map) r1).put(r2, r4);
    L10:
        return (Map) r4;
    }

    public static final void e(f r1, ouc.a r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "json");
        if (Intrinsics.areEqual(r1.getKind(), luc.p.a.a) == false) goto L6;
        r2.a.getClass();
        return;
    }

    public static final int c(f r3, ouc.a r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, DBDefinition.NAME);
        if (r4.a.m == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L14;
        String r6 = r5.toLowerCase(Locale.ROOT);
        Integer r7 = b(r4, r3).get(r6);
        if (r7 != null) goto L13;
        return -3;
    L13:
        return r7.intValue();
    L14:
        e(r3, r4);
        int r1 = r3.g(r5);
        if (r1 == (-3)) goto L18;
        return r1;
    L18:
        if (r4.a.l == true) goto L20;
        return r1;
    L20:
        Integer r8 = b(r4, r3).get(r5);
        if (r8 != null) goto L23;
        return -3;
    L23:
        return r8.intValue();
    L5:
        if (Intrinsics.areEqual(r3.getKind(), o.b.a) == false) goto L7;
        r0 = true;
        goto L9
    }

    public static final void a(Map<String, Integer> r4, f r5, String r6, int r7) {
        if (Intrinsics.areEqual(r5.getKind(), o.b.a) == false) goto L5;
        String r0 = "enum value";
    L7:
        if (r4.containsKey(r6) == true) goto L11;
        r4.put(r6, Integer.valueOf(r7));
        return;
    L11:
        throw new JsonException("The suggested name '" + r6 + "' for " + r0 + ' ' + r5.b(r7) + " is already one of the names for " + r0 + ' ' + r5.b(((Number) MapsKt.getValue(r4, r6)).intValue()) + " in " + r5);
    L5:
        r0 = "property";
        goto L7
    }

    public static final int d(f r1, ouc.a r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r4, "suffix");
        int r5 = c(r1, r2, r3);
        if (r5 == (-3)) goto L6;
        return r5;
    L6:
        throw new SerializationException(r1.f() + " does not contain element with name '" + r3 + '\'' + r4);
    }
}
