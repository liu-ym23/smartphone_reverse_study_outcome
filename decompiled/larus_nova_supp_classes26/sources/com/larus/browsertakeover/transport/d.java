package com.larus.browsertakeover.transport;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements BrowserTransport {
    public final String a;
    public final BrowserTransport.EndpointMode b;
    public final AtomicInteger c;
    public final OkHttpClient d;
    public volatile WebSocket e;
    public volatile boolean f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final synchronized void release() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f = true;     // Catch: Throwable -> L11
        disconnect();     // Catch: Throwable -> L11
        t0.a(new c(this));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void disconnect() {
        this.c.incrementAndGet();
        final WebSocket r0 = this.e;
        this.e = null;
        if (r0 == null) goto L6;
        t0.a(new b(r0));
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.FrameSource a() {
        return BrowserTransport.FrameSource.CDP_SCREENCAST;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.EndpointMode c() {
        return this.b;
    }

    public d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "endpoint");
        this.a = r4;
        this.b = BrowserTransport.EndpointMode.BROWSER;
        this.c = new AtomicInteger();
        this.d = new OkHttpClient.Builder().pingInterval(15, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(false).followSslRedirects(false).build();
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void b(com.larus.browsertakeover.cdp.a r11) {
        Intrinsics.checkNotNullParameter(r11, "listener");
        disconnect();
        if (this.f == false) goto L6;
        r11.onError();
        return;
    L6:
        com.larus.browsertakeover.transport.a r0 = com.larus.browsertakeover.transport.a.a;
        String r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "rawEndpoint");
        String r2 = StringsKt.trim(r1).toString();
        boolean r3 = true;
        if (r2.length() != 0) goto L9;
        boolean r4 = true;
    L10:
        String r5 = null;
        if (r4 == true) goto L120;
        if (r2.length() > 8192) goto L120;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        Object r7 = Result.constructor-impl(new URI(r2));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r7) == false) goto L22;
        r7 = null;
    L22:
        URI r8 = (URI) r7;
        if (r8 == null) goto L120;
        String r9 = r8.getHost();
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == true) goto L120;
        String r12 = r8.getScheme();
        if (r12 == null) goto L37;
        String r13 = r12.toLowerCase(Locale.US);
    L39:
        if (Intrinsics.areEqual(r13, "wss") == true) goto L44;
        if (Intrinsics.areEqual(r13, "ws") == false) goto L120;
    L44:
        if (r8.getUserInfo() != null) goto L120;
        if (r8.getFragment() != null) goto L120;
        Object r14 = Result.constructor-impl(UriProtector.parse(r2));     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r14) == false) goto L55;
        r14 = null;
    L55:
        Uri r15 = (Uri) r14;
        if (r15 == null) goto L120;
        Object r16 = Result.constructor-impl(UriProtector.getQueryParameter(r15, "token"));     // Catch: Throwable -> L60
    L63:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        String r17 = (String) r16;
        if (r17 != null) goto L68;
    L75:
        r17 = null;
    L76:
        String r18 = r8.getPath();
        if (r18 != null) goto L80;
        r18 = "";
    L80:
        if (StringsKt.startsWith$default(r18, "/devtools/browser/", false, 2, null) == false) goto L89;
        int r19 = StringsKt.substringAfterLast$default(r18, '/', null, 2, null).length();
        if (1 <= r19) goto L84;
    L86:
        boolean r20 = false;
    L87:
        if (r20 == false) goto L89;
        boolean r21 = true;
    L90:
        if (r17 != null) goto L93;
        if (r21 == false) goto L120;
    L93:
        if (r17 == null) goto L110;
        int r22 = 0;
    L96:
        if (r22 >= r17.length()) goto L107;
        char r23 = r17.charAt(r22);
        if (r23 != '\r') goto L100;
    L103:
        boolean r24 = true;
    L104:
        if (r24 == true) goto L105;
        r22 = r22 + 1;
        goto L96
    L105:
        boolean r25 = true;
    L108:
        if (r25 != true) goto L110;
        boolean r26 = true;
    L111:
        if (r26 == true) goto L120;
        Uri.Builder r27 = r15.buildUpon().scheme("wss");
        gd9.l r28 = FlowRuntime.a();
        Intrinsics.checkNotNull(r27);
        com.larus.browsertakeover.transport.a.a(r15, r27, "aid", String.valueOf(r28.appId()));
        com.larus.browsertakeover.transport.a.a(r15, r27, "device_id", StringsKt.take(com.larus.platform.service.o.a.getDeviceId(), 256));
        com.larus.browsertakeover.transport.a.a(r15, r27, "platform", "android");
        com.larus.browsertakeover.transport.a.a(r15, r27, "version", StringsKt.take(r28.m(), 256));
        com.larus.browsertakeover.transport.a.a(r15, r27, "use-olympus-account", "1");
        com.larus.browsertakeover.transport.a.a(r15, r27, "webTabId", UUID.randomUUID().toString());
        String r29 = r27.build().toString();
        if (r29.length() <= 8192) goto L117;
        r3 = false;
    L117:
        if (r3 == false) goto L120;
        r5 = r29;
        goto L120
    L100:
        if (r23 == '\n') goto L103;
        r24 = false;
        goto L104
    L107:
        r25 = false;
    L110:
        r26 = false;
        goto L111
    L84:
        if (r19 >= 1025) goto L86;
        r20 = true;
    L89:
        r21 = false;
        goto L90
    L68:
        if ((!StringsKt.isBlank(r17)) == true) goto L70;
    L72:
        boolean r30 = false;
    L73:
        if (r30 == false) goto L75;
    L70:
        if (r17.length() > 1024) goto L72;
        r30 = true;
    L60:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L37:
        r13 = null;
        goto L39
    L28:
        if (StringsKt.isBlank(r9) == true) goto L31;
        r10 = false;
    L17:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L120:
        if (r5 != null) goto L123;
        FLogger.a.e("CloudWebSocketTransport", "Rejected invalid browser endpoint");
        r11.onError();
        return;
    L123:
        int r34 = this.c.incrementAndGet();
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L130
        Request.Builder r36 = new Request.Builder().url(r5);     // Catch: Throwable -> L130
        com.larus.browsertakeover.transport.a.a.getClass();     // Catch: Throwable -> L130
        Iterator r37 = com.larus.browsertakeover.transport.a.b().entrySet().iterator();     // Catch: Throwable -> L130
    L126:
        if (r37.hasNext() == false) goto L128;
        Map.Entry r38 = (Map.Entry) r37.next();     // Catch: Throwable -> L130
        r36.header((String) r38.getKey(), (String) r38.getValue());     // Catch: Throwable -> L130
        goto L126
    L128:
        Object r39 = Result.constructor-impl(r36.build());     // Catch: Throwable -> L130
    L132:
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 != null) goto L136;
        this.e = this.d.newWebSocket((Request) r39, new e(this, r34, r11));
        return;
    L136:
        FLogger.a.e("CloudWebSocketTransport", "Could not create websocket request, type=".concat(r40.getClass().getSimpleName()));
        r11.onError();
        return;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L132
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final boolean send(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (this.f == true) goto L13;
        WebSocket r0 = this.e;
        if (r0 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.send(r4) != true) goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }
}
