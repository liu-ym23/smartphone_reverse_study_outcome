package okhttp3;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okio.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12130a = null;

    public static final class a {

        /* JADX INFO: renamed from: okhttp3.y$a$a, reason: collision with other inner class name */
        @SourceDebugExtension({"SMAP\nRequestBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestBody.kt\nokhttp3/RequestBody$Companion$asRequestBody$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,222:1\n1#2:223\n*E\n"})
        public static final class C0272a extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ u f12131b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ File f12132c;

            C0272a(u r10, File r11) {
                this.f12131b = r10;
                this.f12132c = r11;
            }

            @Override // okhttp3.y
            public long a() {
                return this.f12132c.length();
            }

            @Override // okhttp3.y
            public u b() {
                return this.f12131b;
            }

            @Override // okhttp3.y
            public void g(okio.e r10) {
                Intrinsics.checkNotNullParameter(r10, "sink");
                f0 r11 = okio.t.f(this.f12132c);
                r10.y(r11);     // Catch: Throwable -> L6
                CloseableKt.closeFinally(r11, null);
                return;
            L6:
                th = move-exception;
                throw th;     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                CloseableKt.closeFinally(r11, th);
                throw th;
            }
        }

        public static final class b extends y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ u f12133b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f12134c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ byte[] f12135d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f12136e;

            b(u r10, int r11, byte[] r12, int r13) {
                this.f12133b = r10;
                this.f12134c = r11;
                this.f12135d = r12;
                this.f12136e = r13;
            }

            @Override // okhttp3.y
            public long a() {
                return this.f12134c;
            }

            @Override // okhttp3.y
            public u b() {
                return this.f12133b;
            }

            @Override // okhttp3.y
            public void g(okio.e r10) {
                Intrinsics.checkNotNullParameter(r10, "sink");
                r10.write(this.f12135d, this.f12136e, this.f12134c);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ y g(a r10, u r11, byte[] r12, int r13, int r14, int r15, Object r16) {
            if ((r15 & 4) == 0) goto L6;
            r13 = 0;
        L6:
            if ((r15 & 8) == 0) goto L9;
            r14 = r12.length;
        L9:
            return r10.e(r11, r12, r13, r14);
        }

        public static /* synthetic */ y h(a r10, byte[] r11, u r12, int r13, int r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r12 = null;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r13 = 0;
        L9:
            if ((r15 & 4) == 0) goto L12;
            r14 = r11.length;
        L12:
            return r10.f(r11, r12, r13, r14);
        }

        @JvmStatic
        @JvmName(name = "create")
        public final y a(File r10, u r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return new C0272a(r11, r10);
        }

        @JvmStatic
        @JvmName(name = "create")
        public final y b(String r10, u r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Charset r12 = Charsets.UTF_8;
            if (r11 == null) goto L8;
            Charset r13 = u.d(r11, null, 1, null);
            if (r13 != null) goto L7;
            r11 = u.f12046d.b(r11 + "; charset=utf-8");
            goto L8
        L7:
            r12 = r13;
        L8:
            byte[] r14 = r10.getBytes(r12);
            Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).getBytes(charset)");
            return f(r14, r11, 0, r14.length);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final y c(u r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "content");
            return b(r11, r10);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @JvmOverloads
        public final y d(u r10, byte[] r11) {
            Intrinsics.checkNotNullParameter(r11, "content");
            return g(this, r10, r11, 0, 0, 12, null);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @JvmOverloads
        public final y e(u r10, byte[] r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r11, "content");
            return f(r11, r10, r12, r13);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name = "create")
        public final y f(byte[] r10, u r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            hc.e.l(r10.length, r12, r13);
            return new b(r11, r13, r10, r12);
        }
    }

    static {
        f12130a = new a(null);
    }

    public y() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final y c(u r10, String r11) {
        return f12130a.c(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @JvmOverloads
    public static final y d(u r10, byte[] r11) {
        return f12130a.d(r10, r11);
    }

    public long a() {
        return -1;
    }

    public abstract u b();

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract void g(okio.e r10);
}
