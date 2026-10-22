package kc;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.l;
import okhttp3.m;
import okhttp3.r;
import okhttp3.s;
import okhttp3.z;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "HttpHeaders")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f10164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f10165b = null;

    static {
        ByteString.a r10 = ByteString.Companion;
        f10164a = r10.d("\"\\");
        f10165b = r10.d("\t ,=");
    }

    public static final List<okhttp3.g> a(r r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "headerName");
        ArrayList r12 = new ArrayList();
        int r13 = r10.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L12;
        if (StringsKt.equals(r11, r10.c(r14), true) == false) goto L11;
        c(new okio.d().l0(r10.i(r14)), r12);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        okhttp3.internal.platform.h.f11979a.g().j("Unable to parse challenge", 5, e);
    L11:
        r14 = r14 + 1;
        goto L3
    L12:
        return r12;
    }

    public static final boolean b(z r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.K().g(), "HEAD") == false) goto L5;
        return false;
    L5:
        int r11 = r10.k();
        if (r11 < 100) goto L10;
        if (r11 >= 200) goto L10;
    L15:
        if (hc.e.v(r10) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (StringsKt.equals("chunked", z.s(r10, "Transfer-Encoding", null, 2, null), true) == true) goto L20;
        return false;
    L10:
        if (r11 == 204) goto L15;
        if (r11 == 304) goto L15;
        return true;
    }

    private static final void c(okio.d r10, List<okhttp3.g> r11) {
    L3:
        String r12 = null;
    L4:
        if (r12 != null) goto L8;
        g(r10);
        r12 = e(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        boolean r13 = g(r10);
        String r14 = e(r10);
        if (r14 == null) goto L11;
        int r15 = hc.e.L(r10, Base64.padSymbol);
        boolean r16 = g(r10);
        if (r13 == true) goto L21;
        if (r16 == true) goto L20;
        if (r10.n() == false) goto L21;
    L20:
        Map r17 = Collections.singletonMap(null, r14 + StringsKt.repeat("=", r15));
        Intrinsics.checkNotNullExpressionValue(r17, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
        r11.add(new okhttp3.g(r12, r17));
    L21:
        LinkedHashMap r18 = new LinkedHashMap();
        int r19 = r15 + hc.e.L(r10, Base64.padSymbol);
    L22:
        if (r14 != null) goto L26;
        r14 = e(r10);
        if (g(r10) == true) goto L48;
        r19 = hc.e.L(r10, Base64.padSymbol);
    L48:
        r11.add(new okhttp3.g(r12, r18));
        r12 = r14;
    L26:
        if (r19 == 0) goto L48;
        if (r19 > 1) goto L29;
        if (g(r10) == true) goto L32;
        if (h(r10, (byte) 34) == false) goto L36;
        String r20 = d(r10);
    L37:
        if (r20 == null) goto L38;
        if (((String) r18.put(r14, r20)) != null) goto L41;
        if (g(r10) == true) goto L47;
        if (r10.n() == true) goto L47;
        return;
    L47:
        r14 = null;
        goto L22
    L41:
        return;
    L38:
        return;
    L36:
        r20 = e(r10);
        goto L37
    L32:
        return;
    L29:
        return;
    L11:
        if (r10.n() == true) goto L13;
        return;
    L13:
        r11.add(new okhttp3.g(r12, MapsKt.emptyMap()));
    }

    private static final String d(okio.d r12) {
        if (r12.readByte() != 34) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L20;
        okio.d r11 = new okio.d();
    L8:
        long r13 = r12.u(f10164a);
        if (r13 == (-1)) goto L10;
        if (r12.r(r13) == 34) goto L13;
        if (r12.M() == (r13 + 1)) goto L17;
        r11.x(r12, r13);
        r12.readByte();
        r11.x(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r11.x(r12, r13);
        r12.readByte();
        return r11.J();
    L10:
        return null;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r10 = false;
        goto L6
    }

    private static final String e(okio.d r10) {
        long r11 = r10.u(f10165b);
        if (r11 != (-1)) goto L6;
        r11 = r10.M();
    L6:
        if (r11 != 0) goto L10;
        return null;
    L10:
        return r10.e(r11);
    }

    public static final void f(m r10, s r11, r r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "headers");
        if (r10 != m.f12010a) goto L5;
        return;
    L5:
        List<l> r13 = l.f11996j.e(r11, r12);
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        r10.a(r11, r13);
    }

    private static final boolean g(okio.d r10) {
        boolean r11 = false;
    L4:
        if (r10.n() == true) goto L17;
        byte r12 = r10.r(0);
        if (r12 == 44) goto L7;
        if (r12 != 32) goto L12;
    L10:
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        r10.readByte();
        goto L4
    L12:
        if (r12 == 9) goto L10;
        r13 = false;
        goto L15
    L7:
        r10.readByte();
        r11 = true;
    L17:
        return r11;
    }

    private static final boolean h(okio.d r10, byte r11) {
        if (r10.n() == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.r(0) != r11) goto L7;
        return true;
    }
}
