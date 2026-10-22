package com.larus.agents.impl.webfetch;

import com.larksuite.framework.http.request.HttpHeaders;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k48.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class WebPageFetcher$fetchWebPageHtml$result$1$1$2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ WebPageFetcher d;
    public final /* synthetic */ AtomicReference<String> e;
    public final /* synthetic */ AtomicInteger f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ AtomicReference<t> h;
    public final /* synthetic */ CoroutineScope i;
    public final /* synthetic */ kotlinx.coroutines.i<a> j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ AtomicBoolean m;
    public final /* synthetic */ AtomicBoolean n;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2(int r1, int r2, String r3, WebPageFetcher r4, AtomicReference r5, AtomicInteger r6, boolean r7, AtomicReference r8, CoroutineScope r9, kotlinx.coroutines.j r10, String r11, long r12, AtomicBoolean r14, AtomicBoolean r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r14;
        this.n = r15;
    }

    public final void a() {
        WebPageFetcher.d(this.k, this.l, "worker_start");     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        b(this.m, this.d, this.l);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        if (this.a < 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L104;
        if (this.b < 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L102;
        if ((!StringsKt.isBlank(this.c)) == false) goto L100;
        String r9 = this.c;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        int r10 = 0;
    L17:
        b(this.m, this.d, this.l);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        double r7 = RangesKt.coerceAtLeast(((double) this.d.b) - WebPageFetcher.c(this.l), 0.0d);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.e.set("create_call");     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.f.set(0);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        WebPageFetcher.d(this.k, this.l, "request_create_start hop=" + r10 + " remaining_seconds=" + r7);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        g r14 = this.d.a.a(r9, this.g, RangesKt.coerceAtMost(r7, 60.0d));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.h.set(r14);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Ref.ObjectRef r15 = new Ref.ObjectRef();     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Unit r16 = null;
        b(this.m, this.d, this.l);     // Catch: Throwable -> L84
        this.e.set("execute_call");     // Catch: Throwable -> L84
        WebPageFetcher.d(this.k, this.l, "request_execute_start hop=" + r10);     // Catch: Throwable -> L84
        e r2 = r14.a();     // Catch: Throwable -> L84
        r15.element = r2;     // Catch: Throwable -> L84
        this.f.set(r2.getStatus());     // Catch: Throwable -> L84
        WebPageFetcher.d(this.k, this.l, "response_received hop=" + r10 + " status=" + ((v) r15.element).getStatus());     // Catch: Throwable -> L84
        b(this.m, this.d, this.l);     // Catch: Throwable -> L84
        if (WebPageFetcher.d.contains(Integer.valueOf(((v) r15.element).getStatus())) == false) goto L69;
        this.e.set("validate_redirect");     // Catch: Throwable -> L84
        String r3 = ((v) r15.element).header(HttpHeaders.HEAD_KEY_LOCATION);     // Catch: Throwable -> L84
        if (r3 == null) goto L68;
        if ((!StringsKt.isBlank(r3)) == true) goto L27;
        r3 = null;
    L27:
        if (r3 == null) goto L68;
        if (r10 >= this.a) goto L66;
        URI r8 = new URI(r9);     // Catch: Exception -> L62 Throwable -> L84
        URI r4 = r8.resolve(r3);     // Catch: Exception -> L62 Throwable -> L84
        r9 = r4.toString();     // Catch: Throwable -> L84
        if ((!StringsKt.isBlank(r9)) == false) goto L61;
        if (StringsKt.equals(r8.getScheme(), "https", true) == true) goto L36;
    L40:
        r10 = r10 + 1;     // Catch: Throwable -> L84
        WebPageFetcher.d(this.k, this.l, "redirect_follow next_hop=" + r10);     // Catch: Throwable -> L84
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L46
        v r6 = (v) r15.element;     // Catch: Throwable -> L46
        if (r6 == null) goto L44;
        r6.close();     // Catch: Throwable -> L46
        r16 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.constructor-impl(r16);     // Catch: Throwable -> L46
    L124:
        r14.cancel();     // Catch: Throwable -> L50
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        u.a(this.h, r14);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L50:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L46:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        goto L124
    L36:
        if (StringsKt.equals(r4.getScheme(), "http", true) == false) goto L40;
        throw new IOException("downgrade_redirect");     // Catch: Throwable -> L84
    L61:
        throw new IllegalArgumentException("invalid_url".toString());     // Catch: Throwable -> L84
    L62:
        e = move-exception;
        throw new IOException("invalid_redirect_url", e);     // Catch: Throwable -> L84
    L66:
        throw new IOException("too_many_redirects");     // Catch: Throwable -> L84
    L68:
        throw new IOException("missing_location");     // Catch: Throwable -> L84
    L69:
        this.e.set("read_body");     // Catch: Throwable -> L84
        WebPageFetcher.d(this.k, this.l, "body_read hop=" + r10);     // Catch: Throwable -> L84
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$finish(this.n, this.j, this.m, this.h, this.i, WebPageFetcher.a(this.d, (v) r15.element, r9, r10, this.b, new WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1(this.m, this.d, this.l), new WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2(this.k, this.l)));     // Catch: Throwable -> L84
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L75
        v r17 = (v) r15.element;     // Catch: Throwable -> L75
        if (r17 == null) goto L73;
        r17.close();     // Catch: Throwable -> L75
        r16 = Unit.INSTANCE;     // Catch: Throwable -> L75
    L73:
        Result.constructor-impl(r16);     // Catch: Throwable -> L75
    L131:
        r14.cancel();     // Catch: Throwable -> L79
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L79
    L81:
        u.a(this.h, r14);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.m, this.h, this.i);
        WebPageFetcher.d(this.k, this.l, "worker_exit stage=" + this.e.get());
        return;
    L79:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L75:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L84:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L91
        v r22 = (v) r15.element;     // Catch: Throwable -> L91
        if (r22 == null) goto L89;
        r22.close();     // Catch: Throwable -> L91
        r16 = Unit.INSTANCE;     // Catch: Throwable -> L91
    L89:
        Result.constructor-impl(r16);     // Catch: Throwable -> L91
    L127:
        r14.cancel();     // Catch: Throwable -> L95
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        u.a(this.h, r14);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        throw th;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L95:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L91:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        goto L127
    L100:
        throw new IllegalArgumentException("invalid_url".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L102:
        throw new IllegalArgumentException("invalid_max_bytes".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L11:
        r1 = false;
        goto L12
    L104:
        throw new IllegalArgumentException("invalid_max_redirect".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L6:
        r0 = false;
    L54:
        th = move-exception;
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.m, this.h, this.i);
        WebPageFetcher.d(this.k, this.l, "worker_exit stage=" + this.e.get());
        throw th;
    L58:
        e = move-exception;
        this.j.cancel(e);     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.m, this.h, this.i);
        String r25 = this.k;
        long r26 = this.l;
        StringBuilder r27 = new StringBuilder("worker_exit stage=");
    L118:
        r27.append(this.e.get());
        WebPageFetcher.d(r25, r26, r27.toString());
        return;
    L56:
        e = move-exception;
        if ((e instanceof SocketTimeoutException) == false) goto L109;
        String r29 = "fetch_timeout";
    L114:
        WebPageFetcher.d(this.k, this.l, "fetch_error stage=" + this.e.get() + " reason=" + r29 + " exception_type=" + e.getClass().getSimpleName() + " status=" + this.f.get());     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$finish(this.n, this.j, this.m, this.h, this.i, new a.C0113a(r29, this.f.get()));     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.m, this.h, this.i);
        r25 = this.k;
        r26 = this.l;
        r27 = new StringBuilder("worker_exit stage=");
        goto L118
    L109:
        if (CollectionsKt.contains(WebPageFetcher.c, e.getMessage()) == false) goto L113;
        r29 = e.getMessage();     // Catch: Throwable -> L54
        if (r29 != null) goto L114;
        r29 = "";
        goto L114
    L113:
        r29 = "unexpected_error";
        goto L114
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static final void b(AtomicBoolean r1, WebPageFetcher r2, long r3) {
        if (r1.get() == true) goto L10;
        if (WebPageFetcher.c(r3) >= r2.b) goto L8;
        return;
    L8:
        throw new SocketTimeoutException("fetch_timeout");
    L10:
        throw new CancellationException("fetch_cancelled");
    }
}
