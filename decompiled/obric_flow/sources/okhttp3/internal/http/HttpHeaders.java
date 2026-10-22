package okhttp3.internal.http;

import ai.j0;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import nu.j;
import nu.m;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.l;
import okhttp3.r;
import okhttp3.s;
import okhttp3.s0;
import okhttp3.z;
import okio.ByteString;
import sj.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lokhttp3/c0;", "", "headerName", "", "Lokhttp3/l;", "parseChallenges", "(Lokhttp3/c0;Ljava/lang/String;)Ljava/util/List;", "Lnu/j;", "", "result", "", "readChallengeHeader", "(Lnu/j;Ljava/util/List;)V", "", "skipCommasAndWhitespace", "(Lnu/j;)Z", "", "prefix", "startsWith", "(Lnu/j;B)Z", "readQuotedString", "(Lnu/j;)Ljava/lang/String;", "readToken", "Lokhttp3/s;", "Lokhttp3/e0;", "url", "headers", "receiveHeaders", "(Lokhttp3/s;Lokhttp3/e0;Lokhttp3/c0;)V", "Lokhttp3/s0;", "promisesBody", "(Lokhttp3/s0;)Z", "response", "hasBody", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "HttpHeaders")
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = null;
    private static final ByteString TOKEN_DELIMITERS = null;

    static {
        ByteString.Companion.getClass();
        QUOTED_STRING_DELIMITERS = m.c("\"\\");
        TOKEN_DELIMITERS = m.c("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        return promisesBody(r5);
    }

    public static final List<l> parseChallenges(c0 r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$parseChallenges");
        Intrinsics.checkNotNullParameter(r11, "headerName");
        ArrayList r5 = new ArrayList();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        if (StringsKt.l(r11, r10.c(r13)) == false) goto L11;
        j r14 = new j();
        r14.b0(r10.e(r13));
        readChallengeHeader(r14, r5);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        Platform.Companion.get().log("Unable to parse challenge", 5, e);
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return r5;
    }

    public static final boolean promisesBody(s0 r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$promisesBody");
        if (Intrinsics.areEqual(r10.f20746b.method(), "HEAD") == false) goto L5;
        return false;
    L5:
        int r5 = r10.e;
        if (r5 < 100) goto L10;
        if (r5 >= 200) goto L10;
    L15:
        if (Util.headersContentLength(r10) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (StringsKt.l("chunked", r10.d("Transfer-Encoding", null)) == true) goto L20;
        return false;
    L10:
        if (r5 == 204) goto L15;
        if (r5 == 304) goto L15;
        return true;
    }

    private static final void readChallengeHeader(j r10, List<l> r11) throws EOFException {
    L3:
        String r5 = null;
    L4:
        if (r5 != null) goto L8;
        skipCommasAndWhitespace(r10);
        r5 = readToken(r10);
        if (r5 != null) goto L8;
        return;
    L8:
        boolean r12 = skipCommasAndWhitespace(r10);
        String r13 = readToken(r10);
        if (r13 == null) goto L11;
        byte r14 = (byte) 61;
        int r15 = Util.skipAll(r10, r14);
        boolean r16 = skipCommasAndWhitespace(r10);
        if (r12 == true) goto L21;
        if (r16 == true) goto L20;
        if (r10.y() == false) goto L21;
    L20:
        StringBuilder r17 = j0.u(r13);
        r17.append(StringsKt.D(r15, "="));
        r11.add(new l(r5, Collections.singletonMap(null, r17.toString())));
    L21:
        LinkedHashMap r18 = new LinkedHashMap();
        int r19 = Util.skipAll(r10, r14) + r15;
    L22:
        if (r13 != null) goto L27;
        r13 = readToken(r10);
        if (skipCommasAndWhitespace(r10) == true) goto L28;
        r19 = Util.skipAll(r10, r14);
    L28:
        r11.add(new l(r5, r18));
        r5 = r13;
    L27:
        if (r19 == 0) goto L28;
        if (r19 > 1) goto L31;
        if (skipCommasAndWhitespace(r10) == true) goto L34;
        if (startsWith(r10, (byte) 34) == false) goto L38;
        String r20 = readQuotedString(r10);
    L39:
        if (r20 == null) goto L49;
        if (((String) r18.put(r13, r20)) != null) goto L42;
        if (skipCommasAndWhitespace(r10) == true) goto L48;
        if (r10.y() == true) goto L48;
        return;
    L48:
        r13 = null;
        goto L22
    L42:
        return;
    L49:
        return;
    L38:
        r20 = readToken(r10);
        goto L39
    L34:
        return;
    L31:
        return;
    L11:
        if (r10.y() == true) goto L13;
        return;
    L13:
        r11.add(new l(r5, MapsKt.emptyMap()));
    }

    private static final String readQuotedString(j r12) throws EOFException {
        byte r5 = (byte) 34;
        if (r12.readByte() != r5) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L20;
        j r11 = new j();
    L8:
        long r13 = r12.p(QUOTED_STRING_DELIMITERS);
        if (r13 == (-1)) goto L10;
        if (r12.m(r13) == r5) goto L13;
        if (r12.f20328b == (r13 + 1)) goto L17;
        r11.write(r12, r13);
        r12.readByte();
        r11.write(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r11.write(r12, r13);
        r12.readByte();
        return r11.M();
    L10:
        return null;
    L20:
        throw new IllegalArgumentException("Failed requirement.");
    L5:
        r10 = false;
        goto L6
    }

    private static final String readToken(j r5) {
        long r10 = r5.p(TOKEN_DELIMITERS);
        if (r10 != (-1)) goto L6;
        r10 = r5.f20328b;
    L6:
        if (r10 != 0) goto L10;
        return null;
    L10:
        return r5.L(r10, Charsets.UTF_8);
    }

    public static final void receiveHeaders(s r10, e0 r11, c0 r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$receiveHeaders");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "headers");
        if (r10 != s.f20744j1) goto L5;
        return;
    L5:
        Pattern r5 = r.f20726j;
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "headers");
        List r13 = r12.f("Set-Cookie");
        int r14 = r13.size();
        ArrayList r15 = null;
        int r16 = 0;
    L6:
        if (r16 >= r14) goto L13;
        String r17 = (String) r13.get(r16);
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r17, "setCookie");
        r r18 = z.k(System.currentTimeMillis(), r11, r17);
        if (r18 == null) goto L12;
        if (r15 != null) goto L11;
        r15 = new ArrayList();
    L11:
        r15.add(r18);
    L12:
        r16 = r16 + 1;
        goto L6
    L13:
        if (r15 == null) goto L15;
        List r19 = Collections.unmodifiableList(r15);
    L17:
        if (r19.isEmpty() == false) goto L19;
        return;
    L19:
        ((e) r10).getClass();
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r19, "cookies");
        return;
    L15:
        r19 = CollectionsKt.emptyList();
        goto L17
    }

    private static final boolean skipCommasAndWhitespace(j r5) {
        boolean r10 = false;
    L4:
        if (r5.y() == true) goto L14;
        byte r11 = r5.m(0);
        if (r11 == 9) goto L13;
        if (r11 == 32) goto L13;
        if (r11 != 44) goto L14;
        r5.readByte();
        r10 = true;
    L13:
        r5.readByte();
    L14:
        return r10;
    }

    private static final boolean startsWith(j r5, byte r10) {
        if (r5.y() == false) goto L5;
    L7:
        return false;
    L5:
        if (r5.m(0) != r10) goto L7;
        return true;
    }
}
