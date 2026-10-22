package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.lark.sdk.stream.j;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.Sink;
import okio.d0;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements j {
    public static final CoroutineScope d = null;
    public final C0049f b;
    public final C0049f c;

    public interface a {
        byte[] a(long r1);
    }

    public static final class b implements Sink {
        public final Sink a;
        public final com.larksuite.framework.http.v2.internal.rust.stream.g b;

        public final void close() {
            this.b.a().close();
            this.a.close();
        }

        public final void flush() {
            this.b.a().flush();
            this.a.flush();
        }

        public final j0 timeout() {
            return this.a.timeout();
        }

        public b(d0.a r2, com.larksuite.framework.http.v2.internal.rust.stream.g r3) {
            Intrinsics.checkNotNullParameter(r2, "pipeSink");
            Intrinsics.checkNotNullParameter(r3, "bodyCache");
            this.a = r2;
            this.b = r3;
        }

        public final void write(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "source");
            Buffer r0 = new Buffer();
            r8.copyTo(r0, 0, r9);
            this.b.a().write(r0, r9);
            this.a.write(r8, r9);
        }
    }

    public static final class c implements a {
        public final com.larksuite.framework.http.v2.internal.rust.stream.g a;
        public final Buffer b;
        public boolean c;

        public c(com.larksuite.framework.http.v2.internal.rust.stream.g r2) {
            Intrinsics.checkNotNullParameter(r2, "bodyCache");
            this.a = r2;
            this.b = new Buffer();
        }

        @Override // com.larksuite.framework.http.v2.internal.rust.stream.f.a
        public final byte[] a(long r6) {
            if (this.c == true) goto L28;
            if (r6 <= 0) goto L28;
            long r7 = this.a.source().read(this.b, r6);     // Catch: IOException -> L15
            if (r7 > 0) goto L19;
            this.c = true;     // Catch: IOException -> L15
            this.a.source().close();     // Catch: Throwable -> L12 IOException -> L29
        L12:
            th = move-exception;
            this.a.clean();     // Catch: IOException -> L15
            throw th;     // Catch: IOException -> L15
        L17:
            this.a.clean();     // Catch: IOException -> L15
            return new byte[0];
        L19:
            return this.b.readByteArray(r7);
        L15:
            e = move-exception;
            this.a.source().close();     // Catch: Throwable -> L22 IOException -> L30
        L22:
            th = move-exception;
            this.a.clean();
            throw th;
        L25:
            this.a.clean();
            throw new IllegalStateException("Failed to read request body", e);
        L28:
            return new byte[0];
        }
    }

    public static final class d {
    }

    public static final class e implements a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // com.larksuite.framework.http.v2.internal.rust.stream.f.a
        public final byte[] a(long r1) {
            return new byte[0];
        }
    }

    /* JADX INFO: renamed from: com.larksuite.framework.http.v2.internal.rust.stream.f$f, reason: collision with other inner class name */
    public static final class C0049f {
        public final RequestBody a;
        public final com.larksuite.framework.http.v2.internal.rust.stream.g b;
        public final AtomicBoolean c;
        public final Object d;
        public a e;

        public final byte[] a(long r7) {
            if (this.a == null) goto L27;
            if (r7 <= 0) goto L27;
            Object r0 = this.d;
            monitor-enter(r0);
            a r2 = this.e;     // Catch: Throwable -> L23
            if (r2 != null) goto L20;
            RequestBody r3 = this.a;     // Catch: Throwable -> L23
            com.larksuite.framework.http.v2.internal.rust.stream.g r4 = this.b;     // Catch: Throwable -> L23
            if (r4 != null) goto L16;
            a r1 = e.a;     // Catch: Throwable -> L23
        L14:
            r2 = r1;
            this.e = r2;     // Catch: Throwable -> L23
            goto L20
        L16:
            if (this.c.compareAndSet(false, true) == false) goto L18;
            r1 = new g(r3, r4, RangesKt.coerceAtLeast(r7, 1));     // Catch: Throwable -> L23
            goto L14
        L18:
            r1 = new c(r4);     // Catch: Throwable -> L23
        L20:
            byte[] r8 = r2.a(r7);     // Catch: Throwable -> L23
            monitor-exit(r0);
            return r8;
        L23:
            th = move-exception;
            throw th;
        L27:
            return new byte[0];
        }

        public C0049f(RequestBody r2, com.larksuite.framework.http.v2.internal.rust.stream.g r3, AtomicBoolean r4) {
            Intrinsics.checkNotNullParameter(r4, "writerClaimed");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new Object();
        }
    }

    public static final class g implements a {
        public final RequestBody a;
        public final com.larksuite.framework.http.v2.internal.rust.stream.g b;
        public final AtomicReference<Throwable> c;
        public final AtomicBoolean d;
        public final d0 e;
        public final Buffer f;
        public boolean g;

        @Override // com.larksuite.framework.http.v2.internal.rust.stream.f.a
        public final byte[] a(long r11) {
            if (this.g == false) goto L7;
            return new byte[0];
        L7:
            if (this.d.compareAndSet(false, true) == false) goto L26;
            BuildersKt.launch$default(f.d, null, null, new OkHttpRequestBodyReader$StreamingSource$ensureStarted$1(this, null), 3, null);
        L26:
            long r12 = this.e.h.read(this.f, r11);     // Catch: IOException -> L23
            if (r12 > 0) goto L17;
            this.g = true;     // Catch: IOException -> L23
            Throwable r13 = this.c.get();     // Catch: IOException -> L23
            if (r13 != null) goto L16;
            return new byte[0];
        L16:
            throw new IllegalStateException("Failed to read request body", r13);     // Catch: IOException -> L23
        L17:
            Throwable r1 = this.c.get();     // Catch: IOException -> L23
            if (r1 != null) goto L22;
            return this.f.readByteArray(r12);
        L22:
            throw new IllegalStateException("Failed to read request body", r1);     // Catch: IOException -> L23
        L23:
            e = move-exception;
            throw new IllegalStateException("Failed to read request body", e);
        }

        public g(RequestBody r2, com.larksuite.framework.http.v2.internal.rust.stream.g r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "requestBody");
            Intrinsics.checkNotNullParameter(r3, "bodyCache");
            this.a = r2;
            this.b = r3;
            this.c = new AtomicReference();
            this.d = new AtomicBoolean(false);
            this.e = new d0(r4);
            this.f = new Buffer();
        }
    }

    static {
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public f(Request r5) {
        com.larksuite.framework.http.v2.internal.rust.stream.c.b r0 = new com.larksuite.framework.http.v2.internal.rust.stream.c.b();
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r0, "cacheFactory");
        RequestBody r1 = r5.body();
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r3 = r5.header("X-BaseRequest-ID");
        if (r3 != null) goto L7;
        r3 = "no-request-id";
    L7:
        com.larksuite.framework.http.v2.internal.rust.stream.c r6 = r0.a(new h(r3, r5.url().toString()));
    L9:
        AtomicBoolean r2 = new AtomicBoolean(false);
        this.b = new C0049f(r1, r6, r2);
        this.c = new C0049f(r1, r6, r2);
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final byte[] a(long r2) {
        return this.c.a(r2);
    }

    public final byte[] b(long r2) {
        return this.b.a(r2);
    }
}
