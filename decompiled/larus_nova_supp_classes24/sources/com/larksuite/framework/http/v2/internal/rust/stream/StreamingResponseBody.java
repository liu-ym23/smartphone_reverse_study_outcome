package com.larksuite.framework.http.v2.internal.rust.stream;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class StreamingResponseBody extends ResponseBody {
    public final Call a;
    public final LinkedBlockingQueue<a> b;
    public final AtomicReference<IOException> c;
    public final AtomicReference<com.bytedance.lark.sdk.stream.d> d;
    public final AtomicBoolean e;
    public final Lazy f;
    public final AtomicBoolean g;
    public MediaType h;
    public long i;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larksuite.framework.http.v2.internal.rust.stream.StreamingResponseBody$a$a, reason: collision with other inner class name */
        public static final class C0047a extends a {
            public final byte[] a;

            public C0047a(byte[] r2) {
                Intrinsics.checkNotNullParameter(r2, "bytes");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public final class c implements Source {
        public final Buffer a;
        public final /* synthetic */ StreamingResponseBody b;

        public final void close() {
            this.b.close();
        }

        public final j0 timeout() {
            return j0.d;
        }

        public c(StreamingResponseBody r1) {
            this.b = r1;
            this.a = new Buffer();
        }

        public final long read(Buffer r9, long r10) {
            Intrinsics.checkNotNullParameter(r9, "sink");
            if (r10 != 0) goto L6;
            return 0;
        L6:
            if (this.b.e.get() == true) goto L45;
            IOException r2 = this.b.c.get();
            if (r2 == null) goto L10;
            throw r2;
        L10:
            if (this.b.a.isCanceled() == false) goto L12;
            close();
            throw new IOException("Canceled");
        L12:
            if (this.a.size() != 0) goto L39;
            a r3 = this.b.b.poll(50, TimeUnit.MILLISECONDS);
            if (r3 == null) goto L16;
            if ((r3 instanceof a.C0047a) == false) goto L31;
            this.a.write(((a.C0047a) r3).a);
            goto L12
        L31:
            if (Intrinsics.areEqual(r3, a.b.a) == false) goto L38;
            IOException r11 = this.b.c.get();
            if (r11 != null) goto L36;
            return -1;
        L36:
            throw r11;
        L38:
            throw new NoWhenBranchMatchedException();
        L16:
            if (this.b.e.get() == true) goto L26;
            IOException r4 = this.b.c.get();
            if (r4 != null) goto L24;
            if (this.b.a.isCanceled() == false) goto L12;
            close();
            throw new IOException("Canceled");
        L24:
            throw r4;
        L26:
            throw new IOException("closed");
        L39:
            Buffer r0 = this.a;
            return r0.read(r9, Math.min(r10, r0.size()));
        L45:
            throw new IOException("closed");
        }
    }

    static {
    }

    public final void close() {
        if (this.e.compareAndSet(false, true) == true) goto L5;
    L10:
        super.close();
        return;
    L5:
        if (this.g.get() == true) goto L9;
        com.bytedance.lark.sdk.stream.d r0 = this.d.get();
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        this.b.offer(a.b.a);
        goto L10
    }

    public final BufferedSource source() {
        return (BufferedSource) this.f.getValue();
    }

    public final long contentLength() {
        return this.i;
    }

    public final MediaType contentType() {
        return this.h;
    }

    public StreamingResponseBody(Request r2, Call r3, LinkedBlockingQueue<a> r4, AtomicReference<IOException> r5, AtomicReference<com.bytedance.lark.sdk.stream.d> r6) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "call");
        Intrinsics.checkNotNullParameter(r4, "bodyQueue");
        Intrinsics.checkNotNullParameter(r5, "failureRef");
        Intrinsics.checkNotNullParameter(r6, "taskRef");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = new AtomicBoolean(false);
        this.f = LazyKt.lazy(new AnonymousClass2(this));
        this.g = new AtomicBoolean(false);
        this.i = -1;
    }
}
