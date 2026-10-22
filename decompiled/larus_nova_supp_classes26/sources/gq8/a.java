package gq8;

import aq8.g;
import aq8.h;
import aq8.i;
import java.util.LinkedHashMap;
import java.util.Map;
import juc.c;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.v;
import xt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Map c(String r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        v r1 = d.b;     // Catch: Throwable -> L7
        c r2 = juc.v.c(Reflection.typeOf(i.class));     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");     // Catch: Throwable -> L7
        c r3 = r2;     // Catch: Throwable -> L7
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Object r6 = Result.constructor-impl((i) r1.c(r3, r5));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r6) == false) goto L12;
        r6 = null;
    L12:
        i r7 = (i) r6;
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L17;
        String r9 = r7.a;
        if (r9 == null) goto L17;
        r8.put("1", MapsKt.mapOf(TuplesKt.to("default_select_id", r9)));
    L17:
        if (r7 == null) goto L22;
        String r10 = r7.b;
        if (r10 == null) goto L22;
        r8.put("6", MapsKt.mapOf(TuplesKt.to("default_select_id", r10)));
    L22:
        if ((!r8.isEmpty()) == false) goto L24;
        r4.put("2", r8);
    L24:
        return r4;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static Map a(Integer r7, String r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        v r1 = d.b;     // Catch: Throwable -> L7
        c r2 = juc.v.c(Reflection.typeOf(g.class));     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");     // Catch: Throwable -> L7
        c r3 = r2;     // Catch: Throwable -> L7
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        Object r9 = Result.constructor-impl((g) r1.c(r3, r8));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r9) == false) goto L12;
        r9 = null;
    L12:
        g r10 = (g) r9;
        LinkedHashMap r4 = new LinkedHashMap();
        if (r10 == null) goto L26;
        String r5 = r10.a;
        if (r5 == null) goto L26;
        if (r7 != null) goto L19;
    L21:
        if (r7 == null) goto L26;
        if (r7.intValue() != 28) goto L26;
        r4.put("8", MapsKt.mapOf(TuplesKt.to("6", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", r5)))))));
        goto L26
    L19:
        if (r7.intValue() != 4) goto L21;
        r4.put("11", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", r5)))));
    L26:
        LinkedHashMap r11 = new LinkedHashMap();
        if (r10 == null) goto L31;
        String r6 = r10.b;
        if (r6 == null) goto L31;
        r11.put("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", r6)));
    L31:
        if (r10 == null) goto L36;
        String r12 = r10.d;
        if (r12 == null) goto L36;
        r11.put("30", MapsKt.mapOf(TuplesKt.to("default_select_id", r12)));
    L36:
        if ((!r11.isEmpty()) == false) goto L38;
        r4.put("2", r11);
    L38:
        if (r10 == null) goto L42;
        String r13 = r10.c;
        if (r13 == null) goto L42;
        r4.put("8", MapsKt.mapOf(TuplesKt.to("4", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", r13)))))));
    L42:
        return r4;
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static Map b(Integer r7, String r8, Integer r9) {
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        String r3 = null;
        if (r2 == false) goto L13;
        return null;
    L13:
        if (r7 != null) goto L16;
    L29:
        if (r7 != null) goto L32;
    L33:
        if (r7 != null) goto L36;
    L38:
        if (r7 != null) goto L41;
    L42:
        if (r7 != null) goto L45;
    L47:
        if (r7 != null) goto L50;
    L71:
        return null;
    L50:
        if (r7.intValue() != 1) goto L71;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L53
        v r11 = d.b;     // Catch: Throwable -> L53
        c r12 = juc.v.c(Reflection.typeOf(h.class));     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");     // Catch: Throwable -> L53
        Object r13 = Result.constructor-impl((h) r11.c(r12, r8));     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r13) == false) goto L58;
        r13 = null;
    L58:
        h r14 = (h) r13;
        Pair[] r15 = new Pair[2];
        if (r14 == null) goto L61;
        String r4 = r14.c;
    L62:
        r15[0] = TuplesKt.to("10", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", r4)))));
        Pair[] r16 = new Pair[2];
        if (r14 == null) goto L65;
        String r5 = r14.a;
    L66:
        r16[0] = TuplesKt.to("1", MapsKt.mapOf(TuplesKt.to("default_select_id", r5)));
        if (r14 == null) goto L69;
        r3 = r14.b;
    L69:
        r16[1] = TuplesKt.to("2", MapsKt.mapOf(TuplesKt.to("default_select_id", r3)));
        r15[1] = TuplesKt.to("2", MapsKt.mapOf(r16));
        return MapsKt.mapOf(r15);
    L65:
        r5 = null;
        goto L66
    L61:
        r4 = null;
    L53:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L45:
        if (r7.intValue() != 24) goto L47;
    L73:
        return c(r8);
    L41:
        if (r7.intValue() == 18) goto L73;
    L36:
        if (r7.intValue() != 16) goto L38;
    L75:
        return a(r7, r8);
    L32:
        if (r7.intValue() == 4) goto L75;
    L16:
        if (r7.intValue() != 28) goto L29;
        if (r9 != null) goto L20;
    L23:
        if (r9 == null) goto L71;
        if (r9.intValue() != 18) goto L71;
        return c(r8);
    L20:
        if (r9.intValue() != 4) goto L23;
        return a(r7, r8);
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
