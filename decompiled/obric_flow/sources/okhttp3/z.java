package okhttp3;

import androidx.room.writer.DaoWriter;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    public static final String a(String r5, String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r5, "username");
        Intrinsics.checkNotNullParameter(r10, "password");
        Intrinsics.checkNotNullParameter(r11, "charset");
        String r12 = r5 + ':' + r10;
        ByteString.Companion.getClass();
        Intrinsics.checkNotNullParameter(r12, "$this$encode");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return ai.j0.C("Basic ", new ByteString(r12.getBytes(r11)).base64());
    }

    public static void b(String r5) {
        if (r5.length() <= 0) goto L15;
        int r10 = r5.length();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L13;
        char r12 = r5.charAt(r11);
        if ('!' > r12) goto L12;
        if ('~' < r12) goto L12;
        r11 = r11 + 1;
    L12:
        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r12), Integer.valueOf(r11), r5}).toString());
    L13:
        return;
    L15:
        throw new IllegalArgumentException("name is empty");
    }

    public static void c(String r5, String r10) {
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L19;
        char r13 = r5.charAt(r12);
        if (r13 == '\t') goto L18;
        if (' ' > r13) goto L12;
        if ('~' >= r13) goto L18;
    L12:
        StringBuilder r14 = new StringBuilder();
        r14.append(Util.format("Unexpected char %#04x at %d in %s value", new Object[]{Integer.valueOf(r13), Integer.valueOf(r12), r10}));
        if (Util.isSensitiveHeader(r10) == false) goto L15;
        String r15 = "";
    L16:
        r14.append(r15);
        throw new IllegalArgumentException(r14.toString().toString());
    L15:
        r15 = ": ".concat(r5);
    L18:
        r12 = r12 + 1;
        goto L3
    }

    public static int d(String r5, int r10, int r11, boolean r12) {
    L2:
        if (r10 >= r11) goto L30;
        char r13 = r5.charAt(r10);
        if (r13 >= ' ') goto L8;
        if (r13 == '\t') goto L8;
    L25:
        boolean r14 = true;
    L27:
        if (r14 == (!r12)) goto L28;
        r10 = r10 + 1;
        goto L2
    L28:
        return r10;
    L8:
        if (r13 >= 127) goto L25;
        if ('0' > r13) goto L14;
        if ('9' >= r13) goto L25;
    L14:
        if ('a' > r13) goto L18;
        if ('z' >= r13) goto L25;
    L18:
        if ('A' > r13) goto L22;
        if ('Z' >= r13) goto L25;
    L22:
        if (r13 == ':') goto L25;
        r14 = false;
        goto L27
    L30:
        return r11;
    }

    public static a0 e(SSLSession r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$handshake");
        String r10 = r5.getCipherSuite();
        if (r10 == null) goto L38;
        int r11 = r10.hashCode();
        if (r11 == 1019404634) goto L13;
        if (r11 == 1208658923) goto L10;
    L14:
        m r12 = m.f20711t.e(r10);
        String r13 = r5.getProtocol();
        if (r13 == null) goto L34;
        if (Intrinsics.areEqual("NONE", r13) == true) goto L32;
        TlsVersion.Companion.getClass();
        TlsVersion r14 = y0.a(r13);
        Certificate[] r15 = r5.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L24
        if (r15 == null) goto L22;
        final List r16 = Util.immutableListOf((Certificate[]) Arrays.copyOf(r15, r15.length));     // Catch: SSLPeerUnverifiedException -> L24
    L39:
    L25:
        Certificate[] r17 = r5.getLocalCertificates();
        if (r17 == null) goto L28;
        List r18 = Util.immutableListOf((Certificate[]) Arrays.copyOf(r17, r17.length));
    L30:
        return new a0(r14, r12, r18, new Handshake$Companion$handshake$1(r16));
    L28:
        r18 = CollectionsKt.emptyList();
        goto L30
    L22:
        r16 = CollectionsKt.emptyList();     // Catch: SSLPeerUnverifiedException -> L24
    L24:
        r16 = CollectionsKt.emptyList();
        goto L25
    L32:
        throw new IOException("tlsVersion == NONE");
    L34:
        throw new IllegalStateException("tlsVersion == null");
    L10:
        if (r10.equals("SSL_NULL_WITH_NULL_NULL") == false) goto L14;
    L36:
        throw new IOException("cipherSuite == ".concat(r10));
    L13:
        if (r10.equals("TLS_NULL_WITH_NULL_NULL") == true) goto L36;
    L38:
        throw new IllegalStateException("cipherSuite == null");
    }

    public static h0 f(String r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$toMediaType");
        Matcher r5 = h0.e.matcher(r11);
        if (r5.lookingAt() == false) goto L40;
        String r10 = r5.group(1);
        Locale r12 = Locale.US;
        if (r10 == null) goto L38;
        String r13 = r10.toLowerCase(r12);
        String r14 = r5.group(2);
        if (r14 == null) goto L36;
        String r15 = r14.toLowerCase(r12);
        ArrayList r16 = new ArrayList();
        Matcher r17 = h0.f.matcher(r11);
        int r18 = r5.end();
    L10:
        if (r18 >= r11.length()) goto L29;
        r17.region(r18, r11.length());
        if (r17.lookingAt() == false) goto L28;
        String r19 = r17.group(1);
        if (r19 == null) goto L15;
        String r20 = r17.group(2);
        if (r20 != null) goto L20;
        r20 = r17.group(3);
    L26:
        r16.add(r19);
        r16.add(r20);
        r18 = r17.end();
        goto L10
    L20:
        if (StringsKt.P(r20, "'") == false) goto L26;
        if (StringsKt.k(r20, "'") == false) goto L26;
        if (r20.length() <= 2) goto L26;
        r20 = androidx.constraintlayout.motion.widget.a.n(r20, 1, 1);
        goto L26
    L15:
        r18 = r17.end();
        goto L10
    L28:
        throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + r11.substring(r18) + "\" for: \"" + r11 + Typography.quote).toString());
    L29:
        Object[] r21 = r16.toArray(new String[0]);
        if (r21 == null) goto L34;
        return new h0(r11, r13, r15, (String[]) r21);
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L40:
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.p("No subtype found for: \"", Typography.quote, r11).toString());
    }

    public static String g(e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        nu.m r10 = ByteString.Companion;
        String r11 = r5.f20644j;
        r10.getClass();
        return nu.m.c(r11).md5().hex();
    }

    public static c0 h(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "namesAndValues");
        if ((r5.length % 2) != 0) goto L29;
        Object r10 = r5.clone();
        if (r10 == null) goto L27;
        String[] r11 = (String[]) r10;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L16;
        String r14 = r11[r13];
        if (r14 == null) goto L15;
        if (r14 == null) goto L13;
        r11[r13] = StringsKt.trim(r14).toString();
        r13 = r13 + 1;
        goto L7
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L15:
        throw new IllegalArgumentException("Headers cannot be null");
    L16:
        IntProgression r15 = RangesKt.step(ArraysKt.getIndices(r11), 2);
        int r16 = r15.getFirst();
        int r17 = r15.getLast();
        int r18 = r15.getStep();
        if (r18 < 0) goto L20;
        if (r16 <= r17) goto L21;
    L25:
        return new c0(r11);
    L21:
        String r19 = r11[r16];
        String r20 = r11[r16 + 1];
        b(r19);
        c(r20, r19);
        if (r16 == r17) goto L25;
        r16 = r16 + r18;
        goto L21
    L20:
        if (r16 < r17) goto L25;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    L29:
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    public static h i(c0 r25) {
        c0 r5 = r25;
        Intrinsics.checkNotNullParameter(r5, "headers");
        int r10 = r25.size();
        int r11 = 0;
        boolean r12 = true;
        String r13 = null;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = -1;
        int r17 = -1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r110 = false;
        int r111 = -1;
        int r112 = -1;
        boolean r113 = false;
        boolean r114 = false;
        boolean r20 = false;
    L3:
        if (r11 >= r10) goto L92;
        String r21 = r5.c(r11);
        String r22 = r5.e(r11);
        if (StringsKt.l(r21, "Cache-Control") == false) goto L10;
        if (r13 == null) goto L8;
    L7:
        r12 = false;
    L12:
        int r23 = 0;
    L14:
        if (r23 >= r22.length()) goto L88;
        int r24 = r22.length();
        int r26 = r23;
    L16:
        if (r26 >= r24) goto L21;
        int r27 = r10;
        if (StringsKt.f("=,;", r22.charAt(r26)) == true) goto L22;
        r26 = r26 + 1;
        r10 = r27;
    L22:
        String r28 = r22.substring(r23, r26);
        if (r28 == null) goto L87;
        String r29 = StringsKt.trim(r28).toString();
        if (r26 != r22.length()) goto L27;
    L30:
        boolean r210 = r12;
        int r30 = r26 + 1;
        String r31 = null;
    L50:
        if (StringsKt.l("no-cache", r29) == false) goto L53;
        r14 = true;
    L85:
        r23 = r30;
        r10 = r27;
        r12 = r210;
        goto L14
    L53:
        if (StringsKt.l("no-store", r29) == false) goto L56;
        r15 = true;
        goto L85
    L56:
        if (StringsKt.l("max-age", r29) == false) goto L59;
        r16 = Util.toNonNegativeInt(r31, -1);
        goto L85
    L59:
        if (StringsKt.l("s-maxage", r29) == false) goto L62;
        r17 = Util.toNonNegativeInt(r31, -1);
        goto L85
    L62:
        if (StringsKt.l("private", r29) == false) goto L65;
        r18 = true;
        goto L85
    L65:
        if (StringsKt.l("public", r29) == false) goto L68;
        r19 = true;
        goto L85
    L68:
        if (StringsKt.l("must-revalidate", r29) == false) goto L71;
        r110 = true;
        goto L85
    L71:
        if (StringsKt.l("max-stale", r29) == false) goto L74;
        r111 = Util.toNonNegativeInt(r31, Integer.MAX_VALUE);
        goto L85
    L74:
        if (StringsKt.l("min-fresh", r29) == false) goto L77;
        r112 = Util.toNonNegativeInt(r31, -1);
        goto L85
    L77:
        if (StringsKt.l("only-if-cached", r29) == false) goto L80;
        r113 = true;
        goto L85
    L80:
        if (StringsKt.l("no-transform", r29) == false) goto L83;
        r114 = true;
        goto L85
    L83:
        if (StringsKt.l("immutable", r29) == false) goto L85;
        r20 = true;
        goto L85
    L27:
        if (r22.charAt(r26) == ',') goto L30;
        if (r22.charAt(r26) == ';') goto L30;
        int r32 = Util.indexOfNonWhitespace(r22, r26 + 1);
        if (r32 < r22.length()) goto L34;
    L36:
        int r33 = r22.length();
        int r34 = r32;
    L37:
        if (r34 >= r33) goto L42;
        int r211 = r33;
        r210 = r12;
        if (StringsKt.f(",;", r22.charAt(r34)) == true) goto L43;
        r34 = r34 + 1;
        r33 = r211;
        r12 = r210;
    L43:
        String r35 = r22.substring(r32, r34);
        if (r35 == null) goto L47;
        r31 = StringsKt.trim(r35).toString();
        r30 = r34;
        goto L50
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L42:
        r210 = r12;
        r34 = r22.length();
        goto L43
    L34:
        if (r22.charAt(r32) != '\"') goto L36;
        int r36 = r32 + 1;
        int r37 = StringsKt.q(r22, Typography.quote, r36, 4);
        r31 = r22.substring(r36, r37);
        r30 = r37 + 1;
        r210 = r12;
        goto L50
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L21:
        r27 = r10;
        r26 = r22.length();
        goto L22
    L88:
        int r212 = r10;
    L91:
        r11 = r11 + 1;
        r5 = r25;
        r10 = r212;
        goto L3
    L8:
        r13 = r22;
        goto L12
    L10:
        if (StringsKt.l(r21, "Pragma") == true) goto L7;
        r212 = r10;
        goto L91
    L92:
        if (r12 == true) goto L94;
        String r213 = null;
    L96:
        return new h(r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r213);
    L94:
        r213 = r13;
        goto L96
    }

    public static h0 j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toMediaTypeOrNull");
        return f(r5);
    L5:
        return null;
    }

    public static r k(long r26, e0 r28, String r29) {
        Intrinsics.checkNotNullParameter(r28, "url");
        Intrinsics.checkNotNullParameter(r29, "setCookie");
        int r5 = Util.delimiterOffset$default(r29, ';', 0, 0, 6, null);
        int r10 = Util.delimiterOffset$default(r29, '=', 0, r5, 2, null);
        if (r10 != r5) goto L5;
        return null;
    L5:
        String r11 = Util.trimSubstring$default(r29, 0, r10, 1, null);
        if (r11.length() != 0) goto L9;
    L10:
        return null;
    L9:
        if (Util.indexOfControlOrNonAscii(r11) != (-1)) goto L10;
        String r12 = Util.trimSubstring(r29, r10 + 1, r5);
        if (Util.indexOfControlOrNonAscii(r12) == (-1)) goto L14;
        return null;
    L14:
        int r13 = r5 + 1;
        int r14 = r29.length();
        String r19 = null;
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
        boolean r18 = true;
        long r110 = -1;
        long r20 = DatesKt.MAX_DATE;
        String r21 = null;
    L15:
        long r22 = Long.MAX_VALUE;
        long r24 = Long.MIN_VALUE;
        if (r13 >= r14) goto L63;
        int r23 = Util.delimiterOffset(r29, ';', r13, r14);
        int r25 = Util.delimiterOffset(r29, '=', r13, r23);
        String r27 = Util.trimSubstring(r29, r13, r25);
        if (r25 >= r23) goto L20;
        String r30 = Util.trimSubstring(r29, r25 + 1, r23);
    L22:
        if (StringsKt.l(r27, "expires") == false) goto L26;
        r20 = l(r30.length(), r30);     // Catch: Throwable -> L114
    L24:
        r17 = true;
    L61:
        r13 = r23 + 1;
        goto L15
    L26:
        if (StringsKt.l(r27, "max-age") == false) goto L42;
        long r111 = Long.parseLong(r30);     // Catch: NumberFormatException -> L33
        if (r111 <= 0) goto L32;
        r24 = r111;
    L32:
        r110 = r24;
    L33:
        e = move-exception;
        if (new Regex("-?\\d+").matches(r30) == false) goto L40;
        if (StringsKt.P(r30, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L39;
        r22 = Long.MIN_VALUE;
    L39:
        r110 = r22;
        goto L24
    L40:
        throw e;
    L42:
        if (StringsKt.l(r27, "domain") == false) goto L53;
        if (StringsKt.k(r30, ".") == true) goto L51;
        String r31 = HostnamesKt.toCanonicalHost(StringsKt.A(r30, "."));     // Catch: Throwable -> L114
        if (r31 == null) goto L49;
        r21 = r31;
        r18 = false;
        goto L61
    L49:
        throw new IllegalArgumentException();     // Catch: Throwable -> L114
    L51:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L114
    L53:
        if (StringsKt.l(r27, SVGRenderEngine.PATH) == false) goto L56;
        r19 = r30;
        goto L61
    L56:
        if (StringsKt.l(r27, "secure") == false) goto L59;
        r15 = true;
        goto L61
    L59:
        if (StringsKt.l(r27, "httponly") == false) goto L61;
        r16 = true;
        goto L61
    L20:
        r30 = "";
        goto L22
    L63:
        if (r110 != Long.MIN_VALUE) goto L66;
        long r32 = Long.MIN_VALUE;
    L78:
        String r33 = r28.e;
        if (r21 != null) goto L82;
        String r112 = r33;
    L92:
        if (r33.length() != r112.length()) goto L94;
    L97:
        String r34 = "/";
        String r35 = r19;
        if (r35 != null) goto L100;
    L103:
        String r36 = r28.b();
        int r37 = StringsKt.t(r36, '/', 0, 6);
        if (r37 == 0) goto L109;
        if (r36 == null) goto L108;
        r34 = r36.substring(0, r37);
        goto L109
    L108:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L109:
        String r113 = r34;
    L111:
        return new r(r11, r12, r32, r112, r113, r15, r16, r17, r18);
    L100:
        if (StringsKt.P(r35, "/") == false) goto L103;
        r113 = r35;
        goto L111
    L94:
        if (PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(r112) != null) goto L97;
        return null;
    L82:
        if (Intrinsics.areEqual(r33, r21) == false) goto L85;
    L90:
        r112 = r21;
        goto L92
    L85:
        if (StringsKt.k(r33, r21) == true) goto L87;
        return null;
    L87:
        if (r33.charAt((r33.length() - r21.length()) - 1) == '.') goto L89;
        return null;
    L89:
        if (Util.canParseAsIpAddress(r33) == false) goto L90;
        return null;
    L66:
        if (r110 != (-1)) goto L68;
        r32 = r20;
        goto L78
    L68:
        if (r110 > 9223372036854775L) goto L70;
        r22 = r110 * ((long) 1000);
    L70:
        long r38 = r26 + r22;
        if (r38 >= r26) goto L73;
    L76:
        r32 = 253402300799999L;
        goto L78
    L73:
        if (r38 > DatesKt.MAX_DATE) goto L76;
        r32 = r38;
        goto L78
    }

    public static long l(int r13, String r14) {
        int r5 = d(r14, 0, r13, false);
        Matcher r10 = r.f20729m.matcher(r14);
        int r11 = -1;
        int r12 = -1;
        int r15 = -1;
        int r16 = -1;
        int r17 = -1;
        int r18 = -1;
    L4:
        if (r5 >= r13) goto L28;
        int r19 = d(r14, r5 + 1, r13, true);
        r10.region(r5, r19);
        if (r12 == (-1)) goto L8;
    L10:
        if (r15 == (-1)) goto L12;
    L14:
        if (r16 != (-1)) goto L22;
        Pattern r20 = r.f20727k;
        if (r10.usePattern(r20).matches() == false) goto L22;
        String r21 = r10.group(1);
        Locale r110 = Locale.US;
        if (r21 == null) goto L21;
        r16 = StringsKt.r(r21.toLowerCase(r110), 0, 6, r20.pattern()) / 4;
    L26:
        r5 = d(r14, r19 + 1, r13, false);
        goto L4
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        if (r11 != (-1)) goto L26;
        if (r10.usePattern(r.f20726j).matches() == false) goto L26;
        r11 = Integer.parseInt(r10.group(1));
        goto L26
    L12:
        if (r10.usePattern(r.f20728l).matches() == false) goto L14;
        r15 = Integer.parseInt(r10.group(1));
        goto L26
    L8:
        if (r10.usePattern(r.f20729m).matches() == false) goto L10;
        r12 = Integer.parseInt(r10.group(1));
        r17 = Integer.parseInt(r10.group(2));
        r18 = Integer.parseInt(r10.group(3));
        goto L26
    L28:
        if (70 <= r11) goto L31;
    L33:
        if (r11 < 0) goto L39;
        if (69 < r11) goto L39;
        r11 = r11 + 2000;
    L39:
        if (r11 < 1601) goto L41;
        boolean r111 = true;
    L43:
        if (r111 == false) goto L69;
        if (r16 == (-1)) goto L67;
        if (1 > r15) goto L65;
        if (31 < r15) goto L65;
        if (r12 < 0) goto L63;
        if (23 < r12) goto L63;
        if (r17 < 0) goto L61;
        if (59 < r17) goto L61;
        if (r18 < 0) goto L59;
        if (59 < r18) goto L59;
        GregorianCalendar r112 = new GregorianCalendar(Util.UTC);
        r112.setLenient(false);
        r112.set(1, r11);
        r112.set(2, r16 - 1);
        r112.set(5, r15);
        r112.set(11, r12);
        r112.set(12, r17);
        r112.set(13, r18);
        r112.set(14, 0);
        return r112.getTimeInMillis();
    L59:
        throw new IllegalArgumentException("Failed requirement.");
    L61:
        throw new IllegalArgumentException("Failed requirement.");
    L63:
        throw new IllegalArgumentException("Failed requirement.");
    L65:
        throw new IllegalArgumentException("Failed requirement.");
    L67:
        throw new IllegalArgumentException("Failed requirement.");
    L69:
        throw new IllegalArgumentException("Failed requirement.");
    L41:
        r111 = false;
        goto L43
    L31:
        if (99 < r11) goto L33;
        r11 = r11 + 1900;
        goto L33
    }

    public static String m(X509Certificate r5) {
        Intrinsics.checkNotNullParameter(r5, "certificate");
        if (r5 == null) goto L7;
        StringBuilder r10 = new StringBuilder("sha256/");
        Intrinsics.checkNotNullParameter(r5, "$this$sha256Hash");
        r10.append(nu.m.d(ByteString.Companion, r5.getPublicKey().getEncoded()).sha256().base64());
        return r10.toString();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static int n(nu.x r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        long r10 = r5.e();     // Catch: NumberFormatException -> L11
        String r11 = r5.c(Long.MAX_VALUE);     // Catch: NumberFormatException -> L11
        if (r10 < 0) goto L14;
        if (r10 > Integer.MAX_VALUE) goto L14;
        if (r11.length() > 0) goto L14;
        return (int) r10;
    L14:
        throw new IOException("expected an int but was \"" + r10 + r11 + Typography.quote);     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    public static Set o(c0 r10) {
        int r5 = r10.size();
        TreeSet r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L19;
        if (StringsKt.l("Vary", r10.c(r12)) == false) goto L18;
        String r13 = r10.e(r12);
        if (r11 != null) goto L10;
        r11 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
    L10:
        Iterator r14 = StringsKt.J(r13, new char[]{','}, 0, 6).iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        String r15 = (String) r14.next();
        if (r15 == null) goto L17;
        r11.add(StringsKt.trim(r15).toString());
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L18:
        r12 = r12 + 1;
        goto L3
    L19:
        if (r11 == null) goto L22;
        return r11;
    L22:
        return SetsKt.emptySet();
    }
}
