package okhttp3.internal.http;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0006\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", "prefix", "", "okhttp"}, k = 2, mv = {1, 1, 15})
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = null;
    private static final ByteString TOKEN_DELIMITERS = null;

    static {
        QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(Response r1) {
        Intrinsics.checkParameterIsNotNull(r1, ChatMessage.TYPE_RESPONSE);
        return promisesBody(r1);
    }

    public static final List<Challenge> parseChallenges(Headers r8, String r9) {
        Intrinsics.checkParameterIsNotNull(r8, "$this$parseChallenges");
        Intrinsics.checkParameterIsNotNull(r9, "headerName");
        List<Challenge> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = r8.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        if (StringsKt.equals(r9, r8.name(r3), true) == false) goto L11;
        readChallengeHeader(new Buffer().writeUtf8(r8.value(r3)), r0);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        Platform.Companion.get().log(5, "Unable to parse challenge", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return r0;
    }

    public static final boolean promisesBody(Response r8) {
        Intrinsics.checkParameterIsNotNull(r8, "$this$promisesBody");
        if (Intrinsics.areEqual(r8.request().method(), HttpMethodContrants.HEAD) == false) goto L5;
        return false;
    L5:
        int r0 = r8.code();
        if (r0 < 100) goto L10;
        if (r0 >= 200) goto L10;
    L15:
        if (Util.headersContentLength(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (StringsKt.equals("chunked", Response.header$default(r8, "Transfer-Encoding", null, 2, null), true) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }

    private static final void readChallengeHeader(Buffer r8, List<Challenge> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Class<String> r0 = String.class;
    L3:
        String r1 = (String) ZeusTransformUtils.preCheckCast(null, r0, "com.obric.memorydata.plugin");
    L4:
        if (r1 != null) goto L8;
        skipCommasAndWhitespace(r8);
        r1 = readToken(r8);
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r3 = skipCommasAndWhitespace(r8);
        String r4 = readToken(r8);
        if (r4 == null) goto L11;
        byte r5 = (byte) 61;
        int r6 = Util.skipAll(r8, r5);
        boolean r7 = skipCommasAndWhitespace(r8);
        if (r3 == true) goto L21;
        if (r7 == true) goto L20;
        if (r8.exhausted() == false) goto L21;
    L20:
        Map r11 = Collections.singletonMap(null, r4 + StringsKt.repeat((CharSequence) ZeusTransformUtils.preCheckCast("=", CharSequence.class, "com.obric.memorydata.plugin"), r6));
        Intrinsics.checkExpressionValueIsNotNull(r11, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
        r10.add(new Challenge(r1, r11));
        r0 = String.class;
    L21:
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r13 = r6 + Util.skipAll(r8, r5);
    L22:
        if (r4 != null) goto L27;
        r4 = readToken(r8);
        if (skipCommasAndWhitespace(r8) == true) goto L28;
        r13 = Util.skipAll(r8, r5);
    L28:
        r10.add(new Challenge(r1, r12));
        r1 = r4;
    L27:
        if (r13 == 0) goto L28;
        if (r13 > 1) goto L31;
        if (skipCommasAndWhitespace(r8) == true) goto L34;
        if (startsWith(r8, (byte) 34) == false) goto L38;
        String r14 = readQuotedString(r8);
    L39:
        if (r14 == null) goto L49;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r12.put(r4, r14), String.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L42;
        if (skipCommasAndWhitespace(r8) == true) goto L48;
        if (r8.exhausted() == true) goto L48;
        return;
    L48:
        r4 = r16;
        goto L22
    L42:
        return;
    L49:
        return;
    L38:
        r14 = readToken(r8);
        goto L39
    L34:
        return;
    L31:
        return;
    L11:
        if (r8.exhausted() == true) goto L13;
        return;
    L13:
        r10.add(new Challenge(r1, MapsKt.emptyMap()));
    }

    private static final String readQuotedString(Buffer r12) {
        byte r1 = (byte) 34;
        if (r12.readByte() != r1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        Buffer r2 = new Buffer();
    L8:
        long r3 = r12.indexOfElement(QUOTED_STRING_DELIMITERS);
        if (r3 == (-1)) goto L10;
        if (r12.getByte(r3) == r1) goto L13;
        if (r12.size() == (r3 + 1)) goto L17;
        r2.write(r12, r3);
        r12.readByte();
        r2.write(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r2.write(r12, r3);
        r12.readByte();
        return r2.readUtf8();
    L10:
        return null;
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    private static final String readToken(Buffer r4) {
        long r0 = r4.indexOfElement(TOKEN_DELIMITERS);
        if (r0 != (-1)) goto L6;
        r0 = r4.size();
    L6:
        if (r0 != 0) goto L10;
        return null;
    L10:
        return r4.readUtf8(r0);
    }

    public static final void receiveHeaders(CookieJar r2, HttpUrl r3, Headers r4) {
        CookieJar r5 = (CookieJar) ZeusTransformUtils.wrapperContextForParams(r2, CookieJar.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "$this$receiveHeaders");
        Intrinsics.checkParameterIsNotNull(r3, "url");
        Intrinsics.checkParameterIsNotNull(r4, "headers");
        if (r5 != CookieJar.NO_COOKIES) goto L5;
        return;
    L5:
        List<Cookie> r6 = Cookie.Companion.parseAll(r3, r4);
        if (r6.isEmpty() == false) goto L8;
        return;
    L8:
        r5.saveFromResponse(r3, r6);
    }

    private static final boolean skipCommasAndWhitespace(Buffer r3) {
        boolean r0 = false;
    L4:
        if (r3.exhausted() == true) goto L14;
        byte r1 = r3.getByte(0);
        if (r1 == 9) goto L13;
        if (r1 == 32) goto L13;
        if (r1 != 44) goto L14;
        r3.readByte();
        r0 = true;
    L13:
        r3.readByte();
    L14:
        return r0;
    }

    private static final boolean startsWith(Buffer r2, byte r3) {
        if (r2.exhausted() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.getByte(0) != r3) goto L7;
        return true;
    }
}
