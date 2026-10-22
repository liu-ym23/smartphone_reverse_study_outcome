package okhttp3;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n1#1,321:1\n140#1,11:322\n140#1,11:333\n*S KotlinDebug\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n124#1:322,11\n134#1:333,11\n*E\n"})
public abstract class a0 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11678c = null;

    public static final class a {

        /* JADX INFO: renamed from: okhttp3.a0$a$a, reason: collision with other inner class name */
        public static final class C0257a extends a0 {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ u f11679g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f11680h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ okio.f f11681i;

            C0257a(u r10, long r11, okio.f r12) {
                this.f11679g = r10;
                this.f11680h = r11;
                this.f11681i = r12;
            }

            @Override // okhttp3.a0
            public long f() {
                return this.f11680h;
            }

            @Override // okhttp3.a0
            public u i() {
                return this.f11679g;
            }

            @Override // okhttp3.a0
            public okio.f k() {
                return this.f11681i;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ a0 c(a r10, byte[] r11, u r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r12 = null;
        L6:
            return r10.b(r11, r12);
        }

        @JvmStatic
        @JvmName(name = "create")
        public final a0 a(okio.f r10, u r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return new C0257a(r11, r12, r10);
        }

        @JvmStatic
        @JvmName(name = "create")
        public final a0 b(byte[] r10, u r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return a(new okio.d().X(r10), r11, r10.length);
        }
    }

    static {
        f11678c = new a(null);
    }

    public a0() {
    }

    private final Charset c() {
        u r10 = i();
        if (r10 == null) goto L7;
        Charset r11 = r10.c(Charsets.UTF_8);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return Charsets.UTF_8;
    }

    public final InputStream a() {
        return k().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        hc.e.m(k());
    }

    public abstract long f();

    public abstract u i();

    public abstract okio.f k();

    public final String l() {
        okio.f r10 = k();
        String r11 = r10.w(hc.e.I(r10, c()));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r10, null);
        return r11;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }
}
