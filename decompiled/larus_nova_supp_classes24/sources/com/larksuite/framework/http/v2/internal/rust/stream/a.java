package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.lark.pb.tool.v1.FetchRequest;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larus.audio.call.dora.CommandStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Interceptor {
    public final Function1<Request, com.bytedance.lark.sdk.stream.c> a;

    /* JADX INFO: renamed from: com.larksuite.framework.http.v2.internal.rust.stream.a$a, reason: collision with other inner class name */
    public static final class C0048a {
    }

    static {
    }

    public a(int r2) {
        CallRustStreamInterceptor$1 r3 = CallRustStreamInterceptor$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "rustFetchClientProvider");
        this.a = r3;
    }

    public final Response intercept(Interceptor.Chain r11) {
        Intrinsics.checkNotNullParameter(r11, "chain");
        if (r11.call().isCanceled() == true) goto L74;
        Request r1 = r11.request();
        Intrinsics.checkNotNull(r1);
        List r3 = r1.headers(HttpHeaders.HEAD_KEY_ACCEPT);
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        String r5 = (String) r4.next();
        Intrinsics.checkNotNull(r5);
        boolean r7 = true;
        if (StringsKt.contains(r5, "text/event-stream", true) == false) goto L11;
    L16:
        if (r7 == false) goto L18;
        i r6 = new i(r1, r11, (com.bytedance.lark.sdk.stream.c) this.a.invoke(r1));
        int r12 = b.a;
        Request r13 = r6.a;
        Interceptor.Chain r2 = r6.b;
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r2, "chain");
        FetchRequest.Builder r0 = new FetchRequest.Builder().retry_num(0).url(r13.url().toString());
        int r8 = Math.max(r2.readTimeoutMillis(), r2.connectTimeoutMillis());
        if (r8 <= 0) goto L22;
        int r9 = (r8 + 999) / CommandStatus.DORA_TRACE;
    L23:
        FetchRequest.Builder r10 = r0.timeout(Integer.valueOf(r9)).is_follow_redirect(Boolean.TRUE);
        String r14 = r13.method().toLowerCase(Locale.ROOT);
        switch(r14.hashCode()) {
            case -1335458389: goto L42;
            case 102230: goto L39;
            case 111375: goto L36;
            case 3198432: goto L33;
            case 3446944: goto L30;
            case 106438728: goto L27;
            default: goto L72;
        };
    L27:
        if (r14.equals("patch") == false) goto L72;
        FetchRequest.Method r15 = FetchRequest.Method.PATCH;
    L44:
        FetchRequest.Builder r16 = r10.method(r15).request_id(0L).priority(FetchRequest.Priority.MEDIUM);
        IntRange r17 = RangesKt.until(0, r13.headers().size());
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        IntIterator r20 = r17.iterator();
    L46:
        if (r20.hasNext() == false) goto L48;
        int r21 = r20.nextInt();
        r19.add(new HttpHeader.Builder().name(r13.headers().name(r21)).value(r13.headers().value(r21)).build());
        goto L46
    L48:
        FetchRequest r110 = r16.headers(r19).enable_complex_connect(Boolean.FALSE).disable_cookie(Boolean.TRUE).isolate_user_id(0L).build();
        StreamingResponseBody r22 = new StreamingResponseBody(r6.a, r6.b.call(), r6.h, r6.f, r6.g);
        com.bytedance.lark.sdk.stream.d r111 = r6.c.a(r110, new i.a(r6, r22));
        r6.g.set(r111);
    L50:
        if (r6.d.await(50, TimeUnit.MILLISECONDS) == true) goto L59;
        if (r6.b.call().isCanceled() == true) goto L57;
        IOException r23 = r6.f.get();
        if (r23 == null) goto L50;
        throw r23;
    L57:
        r111.cancel();
        throw new IOException("Canceled");
    L59:
        IOException r112 = r6.f.get();
        if (r112 != null) goto L70;
        Response.Builder r113 = r6.e.get();
        if (r113 == null) goto L69;
        Response.Builder r114 = r113.body(r22);
        if (r114 == null) goto L69;
        Response r115 = r114.build();
        if (r115 == null) goto L69;
        return r115;
    L69:
        throw new IOException("Rust fetch response header is missing");
    L70:
        throw r112;
    L30:
        if (r14.equals("post") == false) goto L72;
        r15 = FetchRequest.Method.POST;
        goto L44
    L33:
        if (r14.equals("head") == false) goto L72;
        r15 = FetchRequest.Method.HEAD;
        goto L44
    L36:
        if (r14.equals("put") == false) goto L72;
        r15 = FetchRequest.Method.PUT;
        goto L44
    L39:
        if (r14.equals("get") == false) goto L72;
        r15 = FetchRequest.Method.GET;
        goto L44
    L42:
        if (r14.equals("delete") == false) goto L72;
        r15 = FetchRequest.Method.DELETE;
    L72:
        throw new IllegalArgumentException("unsupported method: " + r13.method());
    L22:
        r9 = 60;
        goto L23
    L18:
        return r11.proceed(r1);
    L15:
        r7 = false;
        goto L16
    L7:
        if (r3.isEmpty() == false) goto L9;
    L74:
        throw new IOException("Canceled");
    }
}
