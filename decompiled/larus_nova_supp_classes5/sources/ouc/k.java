package ouc;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.m0;
import kotlinx.serialization.json.internal.o0;
import nuc.r0;
import nuc.t0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k {
    public static final r0 a = null;

    static {
        kuc.a.f(StringCompanionObject.INSTANCE);
        a = t0.a("kotlinx.serialization.json.JsonUnquotedLiteral", v2.a);
    }

    public static final g0 a(Boolean r3) {
        if (r3 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r3, false, null);
    }

    public static final g0 b(Number r3) {
        if (r3 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r3, false, null);
    }

    public static final g0 c(String r3) {
        if (r3 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r3, true, null);
    }

    public static final boolean e(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Boolean r0 = o0.b(r2.a());
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        throw new IllegalStateException(r2 + " does not represent a Boolean");
    }

    public static final Boolean f(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return o0.b(r1.a());
    }

    public static final String g(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof a0) == false) goto L6;
        return null;
    L6:
        return r1.a();
    }

    public static final double h(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return CastDoubleProtector.parseDouble(r2.a());
    }

    public static final Double i(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toDoubleOrNull(r1.a());
    }

    public static final Float j(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.toFloatOrNull(r1.a());
    }

    public static final int k(g0 r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        long r0 = new m0(r6.a()).h();     // Catch: JsonDecodingException -> L14
        boolean r4 = false;
        if ((-2147483648L) <= r0) goto L7;
    L9:
        if (r4 == false) goto L13;
        return (int) r0;
    L13:
        throw new NumberFormatException(r6.a() + " is not an Int");
    L7:
        if (r0 > 2147483647L) goto L9;
        r4 = true;
    L14:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());
    }

    public static final Integer l(g0 r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Long r7 = Long.valueOf(new m0(r6.a()).h());     // Catch: JsonDecodingException -> L5
    L6:
        if (r7 == null) goto L16;
        long r1 = r7.longValue();
        boolean r8 = false;
        if ((-2147483648L) <= r1) goto L10;
    L12:
        if (r8 == true) goto L15;
        return null;
    L15:
        return Integer.valueOf((int) r1);
    L10:
        if (r1 > 2147483647L) goto L12;
        r8 = true;
        goto L12
    L16:
        return null;
    L5:
        r7 = null;
        goto L6
    }

    public static final b m(i r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof b) == false) goto L5;
        b r0 = (b) r2;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        d(r2, "JsonArray");
        throw null;
    L5:
        r0 = null;
        goto L6
    }

    public static final d0 n(i r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof d0) == false) goto L5;
        d0 r0 = (d0) r2;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        d(r2, "JsonObject");
        throw null;
    L5:
        r0 = null;
        goto L6
    }

    public static final g0 o(i r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof g0) == false) goto L5;
        g0 r0 = (g0) r2;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        d(r2, "JsonPrimitive");
        throw null;
    L5:
        r0 = null;
        goto L6
    }

    public static final long p(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new m0(r2.a()).h();
    L5:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());
    }

    public static final Long q(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Long.valueOf(new m0(r2.a()).h());
    L5:
        return null;
    }

    public static final void d(i r3, String r4) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(r3.getClass()) + " is not a " + r4);
    }
}
