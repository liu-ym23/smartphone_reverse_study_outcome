package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public final Request a;
    public final Interceptor.Chain b;
    public final com.bytedance.lark.sdk.stream.c c;
    public final CountDownLatch d;
    public final AtomicReference<Response.Builder> e;
    public final AtomicReference<IOException> f;
    public final AtomicReference<com.bytedance.lark.sdk.stream.d> g;
    public final LinkedBlockingQueue<StreamingResponseBody.a> h;

    public final class a implements com.bytedance.lark.sdk.stream.f {
        public final StreamingResponseBody a;
        public final /* synthetic */ i b;

        public final void b(OnFetchResponse.OnProgressResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
        }

        public final void a(OnFetchResponse.OnErrorResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            String r3 = r2.message;
            if (r3.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            r3 = "Rust fetch failed";
        L8:
            h(new IOException(r3));
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void c(OnFetchResponse.OnSuccessResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            this.a.g.set(true);
            this.b.h.offer(StreamingResponseBody.a.b.a);
        }

        public final void d(LarkResponse r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            if (r3.b != LarkResponse.ResponseStatus.ERROR) goto L14;
            LarkResponse.d r1 = r3.e;
            if (r1 == null) goto L8;
            String r2 = r1.b;
            if (r2 == null) goto L8;
        L12:
            h(new IOException(r2));
            return;
        L8:
            LarkResponse.b r4 = r3.d;
            if (r4 == null) goto L11;
            r2 = r4.b;
            goto L12
        L11:
            r2 = "Rust fetch failed";
            goto L12
        }

        public final void e(OnFetchResponse.OnHeaderResponse r9) {
            Intrinsics.checkNotNullParameter(r9, "response");
            i r0 = this.b;
            AtomicReference<Response.Builder> r1 = r0.e;
            r0.getClass();
            Response.Builder r2 = new Response.Builder().request(r0.a);
            int r3 = b.a[r9.protocol.ordinal()];
            if (r3 != 1) goto L5;
            Protocol r4 = Protocol.HTTP_1_1;
        L12:
            Response.Builder r5 = r2.protocol(r4).code(r9.status_code.intValue()).message("");
            Iterator r6 = r9.headers.iterator();
        L14:
            if (r6.hasNext() == false) goto L21;
            HttpHeader r7 = (HttpHeader) r6.next();
            String r8 = r7.name.toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual(r8, "content-encoding") == false) goto L20;
            if (StringsKt.equals(r7.value, "gzip", true) == true) goto L14;
        L20:
            r5.addHeader(r8, r7.value);
            goto L14
        L21:
            Intrinsics.checkNotNull(r5);
            r1.set(r5);
            StreamingResponseBody r10 = this.a;
            List r11 = r9.headers;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "headers");
            List r12 = r11;
            Iterator r13 = r12.iterator();
        L22:
            Object r14 = null;
            if (r13.hasNext() == false) goto L27;
            Object r15 = r13.next();
            if (StringsKt.equals(((HttpHeader) r15).name, "content-type", true) == false) goto L22;
        L28:
            HttpHeader r16 = (HttpHeader) r15;
            if (r16 == null) goto L33;
            String r17 = r16.value;
            if (r17 == null) goto L33;
            MediaType r19 = MediaType.get(r17);
        L34:
            r10.h = r19;
            Iterator r20 = r12.iterator();
        L36:
            if (r20.hasNext() == false) goto L40;
            Object r21 = r20.next();
            if (StringsKt.equals(((HttpHeader) r21).name, "content-length", true) == false) goto L36;
            r14 = r21;
        L40:
            HttpHeader r22 = (HttpHeader) r14;
            if (r22 == null) goto L47;
            String r23 = r22.value;
            if (r23 == null) goto L47;
            Long r24 = StringsKt.toLongOrNull(r23);
            if (r24 == null) goto L47;
            long r25 = r24.longValue();
        L48:
            r10.i = r25;
            this.b.d.countDown();
            return;
        L47:
            r25 = -1;
        L33:
            r19 = null;
            goto L34
        L27:
            r15 = null;
            goto L28
        L5:
            if (r3 != 2) goto L7;
            r4 = Protocol.HTTP_2;
            goto L12
        L7:
            if (r3 == 3) goto L9;
            r4 = Protocol.HTTP_1_0;
            goto L12
        L9:
            r4 = Protocol.QUIC;
            goto L12
        }

        public final void f(OnFetchResponse.OnBodyResponse r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            byte[] r4 = r3.body.toByteArray();
            if (r4.length != 0) goto L5;
            boolean r0 = true;
        L7:
            if ((!r0) == false) goto L10;
            this.b.h.offer(new StreamingResponseBody.a.C0047a(r4));
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L7
        }

        public final void g(OnFetchResponse.OnCancelResponse r2) {
            Intrinsics.checkNotNullParameter(r2, "response");
            h(new IOException("Canceled"));
        }

        public final void h(IOException r3) {
            AtomicReference<IOException> r0 = this.b.f;
        L4:
            if (r0.compareAndSet(null, r3) == true) goto L8;
            if (r0.get() == null) goto L4;
        L8:
            this.a.g.set(true);
            this.b.h.offer(StreamingResponseBody.a.b.a);
            this.b.d.countDown();
        }

        public a(i r2, StreamingResponseBody r3) {
            Intrinsics.checkNotNullParameter(r3, "body");
            this.b = r2;
            this.a = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OnFetchResponse.OnHeaderResponse.Protocol.values().length];
            r0[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_1_1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OnFetchResponse.OnHeaderResponse.Protocol.HTTP_2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OnFetchResponse.OnHeaderResponse.Protocol.QUIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public i(Request r2, Interceptor.Chain r3, com.bytedance.lark.sdk.stream.c r4) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "chain");
        Intrinsics.checkNotNullParameter(r4, "rustFetchClient");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CountDownLatch(1);
        this.e = new AtomicReference();
        this.f = new AtomicReference();
        this.g = new AtomicReference();
        this.h = new LinkedBlockingQueue();
    }
}
