package kc;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.a0;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.t;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10160a;

    public b(boolean r10) {
        this.f10160a = r10;
    }

    private final boolean b(int r10) {
        if (r10 != 100) goto L6;
    L13:
        return true;
    L6:
        if (102 <= r10) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L13;
        return false;
    L8:
        if (r10 >= 200) goto L10;
        r11 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22, types: [okhttp3.z$a] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, okhttp3.z$a] */
    /* JADX WARN: Type inference failed for: r9v5, types: [okhttp3.z$a] */
    @Override // okhttp3.t
    public z a(t.a r14) {
        Intrinsics.checkNotNullParameter(r14, "chain");
        g r15 = (g) r14;
        okhttp3.internal.connection.c r10 = r15.h();
        Intrinsics.checkNotNull(r10);
        x r16 = r15.j();
        y r11 = r16.a();
        long r12 = System.currentTimeMillis();
        Long r13 = null;
        r10.u(r16);     // Catch: IOException -> L32
        ?? r17 = f.a(r16.g());     // Catch: IOException -> L32
        if (r17 == 0) goto L23;
        if (r11 == null) goto L23;
        if (StringsKt.equals("100-continue", r16.d("Expect"), true) == false) goto L13;
        r10.f();     // Catch: IOException -> L32
        r17 = r10.q(true);     // Catch: IOException -> L32
        r10.s();     // Catch: IOException -> L11
        boolean r18 = false;
        ?? r19 = r17;
    L14:
        if (r19 == 0) goto L16;
        r10.o();     // Catch: IOException -> L30
        r17 = r19;
        if (r10.h().x() == true) goto L25;
        r10.n();     // Catch: IOException -> L30
        r17 = r19;
    L25:
        if (r11 != null) goto L27;
    L28:
        r10.e();     // Catch: IOException -> L30
    L29:
        e = null;
        ?? r20 = r17;
    L39:
        if (r20 == 0) goto L89;
    L43:
        z r21 = r20.r(r16).i(r10.h().t()).s(r12).q(System.currentTimeMillis()).c();     // Catch: IOException -> L77
        int r110 = r21.k();     // Catch: IOException -> L77
        if (b(r110) == false) goto L49;
        z.a r22 = r10.q(false);     // Catch: IOException -> L77
        Intrinsics.checkNotNull(r22);     // Catch: IOException -> L77
        if (r18 == false) goto L48;
        r10.s();     // Catch: IOException -> L77
    L48:
        r21 = r22.r(r16).i(r10.h().t()).s(r12).q(System.currentTimeMillis()).c();     // Catch: IOException -> L77
        r110 = r21.k();     // Catch: IOException -> L77
    L49:
        r10.r(r21);     // Catch: IOException -> L77
        if (this.f10160a == true) goto L52;
    L55:
        z.a r111 = r21.F().b(r10.p(r21));     // Catch: IOException -> L77
    L54:
        z r112 = r111.c();     // Catch: IOException -> L77
        if (StringsKt.equals("close", r112.K().d("Connection"), true) == false) goto L59;
    L60:
        r10.n();     // Catch: IOException -> L77
    L62:
        if (r110 != 204) goto L64;
    L65:
        a0 r113 = r112.a();     // Catch: IOException -> L77
        if (r113 == null) goto L68;
        long r23 = r113.f();     // Catch: IOException -> L77
    L70:
        if (r23 <= 0) goto L76;
        StringBuilder r24 = new StringBuilder();     // Catch: IOException -> L77
        r24.append("HTTP ");     // Catch: IOException -> L77
        r24.append(r110);     // Catch: IOException -> L77
        r24.append(" had non-zero Content-Length: ");     // Catch: IOException -> L77
        a0 r114 = r112.a();     // Catch: IOException -> L77
        if (r114 == null) goto L74;
        r13 = Long.valueOf(r114.f());     // Catch: IOException -> L77
    L74:
        r24.append(r13);     // Catch: IOException -> L77
        throw new ProtocolException(r24.toString());     // Catch: IOException -> L77
    L77:
        e = move-exception;
        if (e == null) goto L81;
        ExceptionsKt.addSuppressed(e, e);
        throw e;
    L81:
        throw e;
    L76:
        return r112;
    L68:
        r23 = -1;
        goto L70
    L64:
        if (r110 != 205) goto L76;
    L59:
        if (StringsKt.equals("close", z.s(r112, "Connection", null, 2, null), true) == false) goto L62;
    L52:
        if (r110 != 101) goto L55;
        r111 = r21.F().b(hc.e.f9279c);     // Catch: IOException -> L77
        goto L54
    L89:
        r20 = r10.q(false);     // Catch: IOException -> L77
        Intrinsics.checkNotNull(r20);     // Catch: IOException -> L77
        if (r18 == false) goto L43;
        r10.s();     // Catch: IOException -> L77
        r18 = false;
        goto L43
    L27:
        if (r11.e() == true) goto L29;
    L16:
        if (r11.e() == false) goto L18;
        r10.f();     // Catch: IOException -> L30
        r11.g(okio.t.a(r10.c(r16, true)));     // Catch: IOException -> L30
        r17 = r19;
        goto L25
    L18:
        okio.e r115 = okio.t.a(r10.c(r16, false));     // Catch: IOException -> L30
        r11.g(r115);     // Catch: IOException -> L30
        r115.close();     // Catch: IOException -> L30
        r17 = r19;
    L11:
        e = e;
    L34:
        r18 = true;
    L36:
        if ((e instanceof ConnectionShutdownException) == true) goto L83;
        r20 = r17;
        if (r10.k() == true) goto L39;
        throw e;
    L83:
        throw e;
    L13:
        r19 = 0;
        r18 = true;
    L23:
        r10.o();     // Catch: IOException -> L32
        r17 = 0;
        r18 = true;
    L30:
        e = e;
    L32:
        e = e;
        r17 = 0;
        goto L34
    }
}
