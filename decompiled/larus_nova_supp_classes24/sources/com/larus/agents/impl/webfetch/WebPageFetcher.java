package com.larus.agents.impl.webfetch;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class WebPageFetcher {
    public static final Set<String> c = null;
    public static final Set<Integer> d = null;
    public static final Regex e = null;
    public final w a;
    public final int b;

    public static final class a {
    }

    public WebPageFetcher() {
        this(0);
    }

    static {
        c = SetsKt.setOf(new String[]{"invalid_max_redirect", "invalid_max_bytes", "invalid_url", "missing_location", "too_many_redirects", "invalid_redirect_url", "downgrade_redirect", "unsupported_charset", "fetch_timeout"});
        d = SetsKt.setOf(new Integer[]{301, 302, 303, 307, 308});
        e = new Regex("(?:^|;)\\s*charset\\s*=\\s*(?:\"([^\"]*)\"|([^;\\s]*))", RegexOption.IGNORE_CASE);
    }

    public WebPageFetcher(int r2) {
        f r3 = new f();
        Intrinsics.checkNotNullParameter(r3, "transport");
        this.a = r3;
        this.b = 180;
    }

    public static final double c(long r3) {
        return (System.nanoTime() - r3) / TimeUnit.SECONDS.toNanos(1);
    }

    public static final void d(String r3, long r4, String r6) {
        FLogger.a.i("WebPageFetch", "command_id=" + r3 + ' ' + r6 + " elapsed_seconds=" + c(r4));
    }

    public final Object b(String r29, String r210, boolean r30, int r31, int r32, Continuation<? super k48.a> r33) {
        if ((r33 instanceof WebPageFetcher$fetchWebPageHtml$1) == false) goto L7;
        WebPageFetcher$fetchWebPageHtml$1 r2 = (WebPageFetcher$fetchWebPageHtml$1) r33;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        WebPageFetcher$fetchWebPageHtml$1 r14 = r2;
        Object r1 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r14.J$0;
        String r6 = (String) r14.L$2;
        AtomicInteger r7 = (AtomicInteger) r14.L$1;
        AtomicReference r8 = (AtomicReference) r14.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: CancellationException -> L14
        String r24 = " status=";
    L78:
        Object r9 = (k48.a) r1;     // Catch: CancellationException -> L49
        if (r9 != null) goto L40;
        r9 = new k48.a.C0113a("fetch_timeout", r7.get());     // Catch: CancellationException -> L49
    L40:
        if ((r9 instanceof k48.a.b) == false) goto L43;
        StringBuilder r0 = new StringBuilder("outcome=html status=");
        k48.a.b r10 = (k48.a.b) r9;
        r0.append(r10.e);
        r0.append(" redirects=");
        r0.append(r10.b);
        r0.append(" limit_reached=");
        r0.append(r10.d);
        String r11 = r0.toString();
    L45:
        d(r6, r5, "fetch_complete " + r11);
        return r9;
    L43:
        if ((r9 instanceof k48.a.C0113a) == false) goto L48;
        StringBuilder r12 = new StringBuilder("outcome=fail stage=");
        r12.append((String) r8.get());
        r12.append(" reason=");
        k48.a.C0113a r13 = (k48.a.C0113a) r9;
        r12.append(r13.a);
        r12.append(r24);
        r12.append(r13.b);
        r11 = r12.toString();
        goto L45
    L48:
        throw new NoWhenBranchMatchedException();
    L49:
        e = e;
        String r16 = r24;
    L66:
        d(r6, r5, "fetch_cancelled stage=" + ((String) r8.get()) + r16 + r7.get());
        throw e;
    L14:
        e = e;
        r16 = " status=";
        goto L66
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        long r17 = System.nanoTime();
        AtomicReference r19 = new AtomicReference("validate_input");
        AtomicInteger r20 = new AtomicInteger();
        String r21 = k.a(r210);
        d(r21, r17, "fetch_start send_cookie=" + r30 + " max_redirect=" + r31 + " max_bytes=" + r32 + " timeout_seconds=" + this.b);
        long r22 = TimeUnit.SECONDS.toMillis(this.b);     // Catch: CancellationException -> L63
        if (r30 == false) goto L22;
        boolean r23 = true;
    L23:
        r24 = " status=";
        WebPageFetcher$fetchWebPageHtml$result$1 r25 = new WebPageFetcher$fetchWebPageHtml$result$1(r19, r20, r21, r17, r31, r32, r29, this, r23, null);     // Catch: CancellationException -> L59
        AtomicReference r26 = r19;
        r14.L$0 = r26;     // Catch: CancellationException -> L57
        AtomicInteger r27 = r20;
        r14.L$1 = r27;     // Catch: CancellationException -> L55
        String r34 = r21;
        r14.L$2 = r34;     // Catch: CancellationException -> L53
        long r35 = r17;
        r14.J$0 = r35;     // Catch: CancellationException -> L51
        r14.label = 1;     // Catch: CancellationException -> L51
        Object r36 = TimeoutKt.c(r22, r25, r14);     // Catch: CancellationException -> L51
        if (r36 != r15) goto L35;
        return r15;
    L35:
        r8 = r26;
        r1 = r36;
        r7 = r27;
        r6 = r34;
        r5 = r35;
    L51:
        e = e;
    L62:
        r16 = r24;
    L65:
        r8 = r26;
        long r211 = r35;
        r7 = r27;
        r6 = r34;
        r5 = r211;
    L53:
        e = e;
    L61:
        r35 = r17;
    L55:
        e = e;
        r34 = r21;
    L57:
        e = e;
        r34 = r21;
        r27 = r20;
    L59:
        e = e;
        r34 = r21;
        r27 = r20;
        r26 = r19;
        goto L61
    L22:
        r23 = false;
    L63:
        e = e;
        r34 = r21;
        r27 = r20;
        r26 = r19;
        r35 = r17;
        r16 = " status=";
    L7:
        r2 = new WebPageFetcher$fetchWebPageHtml$1(this, r33);
        goto L8
    }

    public static final k48.a a(WebPageFetcher r23, v r24, String r25, int r26, int r27, Function0 r29, Function1 r210) {
        r23.getClass();
        int r0 = r24.getStatus();
        boolean r3 = true;
        if (200 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L103;
        if (r24.getStatus() == 204) goto L103;
        if (r24.getStatus() == 205) goto L103;
        String r2 = r24.header(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
        String r5 = "";
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        String r7 = null;
        String r6 = StringsKt.trim(StringsKt.substringBefore$default(r2, ';', null, 2, null)).toString();
        if (StringsKt.equals(r6, "text/html", true) == false) goto L20;
    L28:
        MatchResult r4 = Regex.find$default(e, r2, 0, 2, null);
        if (r4 != null) goto L31;
        Charset r8 = Charsets.UTF_8;
    L44:
        StringBuilder r9 = new StringBuilder("charset_selected charset=");
        r9.append(r8.name());
        r9.append(" source=");
        if (r4 != null) goto L47;
        String r10 = "default";
    L48:
        r9.append(r10);
        r210.invoke(r9.toString());
        InputStream r11 = r24.C4();
        if (r11 == null) goto L115;
        if (r27 != 0) goto L53;
        int r12 = 1048576;
    L54:
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();
        byte[] r14 = new byte[8192];
    L56:
        if (r13.size() >= r12) goto L61;
        r29.invoke();
        int r15 = r11.read(r14, 0, Math.min(8192, r12 - r13.size()));
        if (r15 < 0) goto L61;
        if (r15 <= 0) goto L56;
        r13.write(r14, 0, r15);
    L61:
        r29.invoke();
        String r16 = r13.toString(r8.name());
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNullParameter(r16, "html");
        int r17 = 0;
        int r19 = 0;
    L63:
        if (r17 >= r16.length()) goto L85;
        int r20 = r16.codePointAt(r17);
        if (r20 > 127) goto L68;
    L77:
        int r110 = 1;
    L83:
        if (r110 > (r12 - r19)) goto L85;
        r19 = r19 + r110;
        r17 = r17 + Character.charCount(r20);
        goto L63
    L68:
        if (r20 > 2047) goto L71;
        r110 = 2;
        goto L83
    L71:
        if (55296 <= r20) goto L73;
    L75:
        boolean r111 = false;
    L76:
        if (r111 == true) goto L77;
        if (r20 > 65535) goto L81;
        r110 = 3;
        goto L83
    L81:
        r110 = 4;
        goto L83
    L73:
        if (r20 >= 57344) goto L75;
        r111 = true;
    L85:
        String r112 = r16.substring(0, r17);
        r29.invoke();
        if (r13.size() != r12) goto L88;
    L91:
        boolean r113 = true;
    L116:
        return new k48.a.b(r25, r26, r112, r113, r24.getStatus());
    L88:
        if (r112.length() < r16.length()) goto L91;
        r113 = false;
        goto L116
    L53:
        r12 = r27;
        goto L54
    L115:
        return new k48.a.C0113a("empty_body", r24.getStatus());
    L47:
        r10 = "http_header";
        goto L48
    L31:
        MatchGroup r21 = r4.getGroups().get(1);
        if (r21 == null) goto L37;
        String r22 = r21.getValue();
        if (r22 == null) goto L37;
        r5 = r22;
    L104:
        r8 = Charset.forName(r5);     // Catch: IllegalArgumentException -> L93
    L93:
        e = move-exception;
        String r30 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r5, 64), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r30.length() == 0) goto L98;
        r3 = false;
    L98:
        if (r3 == false) goto L100;
        r30 = "empty";
    L100:
        r210.invoke("charset_unsupported charset=" + r30 + " status=" + r24.getStatus());
        throw new IOException("unsupported_charset", e);
    L37:
        MatchGroup r31 = r4.getGroups().get(2);
        if (r31 == null) goto L40;
        r7 = r31.getValue();
    L40:
        if (r7 == null) goto L104;
        r5 = r7;
        goto L104
    L20:
        if (StringsKt.equals(r6, "application/xhtml+xml", true) == true) goto L28;
        String r32 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r6, 128), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r32.length() == 0) goto L25;
        r3 = false;
    L25:
        if (r3 == false) goto L27;
        r32 = "missing";
    L27:
        r210.invoke("body_rejected reason=not_html media_type=" + r32 + " status=" + r24.getStatus());
        return new k48.a.C0113a("not_html", r24.getStatus());
    L103:
        return new k48.a.C0113a("http_status", r24.getStatus());
    L5:
        if (r0 >= 300) goto L7;
        r1 = true;
        goto L8
    }
}
