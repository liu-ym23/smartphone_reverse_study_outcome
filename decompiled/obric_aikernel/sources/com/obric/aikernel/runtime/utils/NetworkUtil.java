package com.obric.aikernel.runtime.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkUtil f5399a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5404e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f5405f;

        public a(String r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r10, "activeNetwork");
            this.f5400a = r10;
            this.f5401b = r11;
            this.f5402c = r12;
            this.f5403d = r13;
            this.f5404e = r14;
            this.f5405f = r15;
        }

        public final String a() {
            return this.f5400a;
        }

        public final boolean b() {
            return this.f5401b;
        }

        public final boolean c() {
            return this.f5403d;
        }

        public final boolean d() {
            return this.f5404e;
        }

        public final boolean e() {
            return this.f5402c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f5400a, r11.f5400a) == true) goto L12;
            return false;
        L12:
            if (this.f5401b == r11.f5401b) goto L15;
            return false;
        L15:
            if (this.f5402c == r11.f5402c) goto L18;
            return false;
        L18:
            if (this.f5403d == r11.f5403d) goto L21;
            return false;
        L21:
            if (this.f5404e == r11.f5404e) goto L24;
            return false;
        L24:
            if (this.f5405f == r11.f5405f) goto L26;
            return false;
        L26:
            return true;
        }

        public final boolean f() {
            return this.f5405f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r10 = this.f5400a.hashCode() * 31;
            boolean r11 = this.f5401b;
            ?? r12 = 1;
            ?? r13 = r11;
            if (r11 == false) goto L5;
            r13 = 1;
        L5:
            int r14 = (r10 + r13) * 31;
            boolean r15 = this.f5402c;
            ?? r16 = r15;
            if (r15 == false) goto L8;
            r16 = 1;
        L8:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.f5403d;
            ?? r19 = r18;
            if (r18 == false) goto L11;
            r19 = 1;
        L11:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.f5404e;
            ?? r22 = r21;
            if (r21 == false) goto L14;
            r22 = 1;
        L14:
            int r23 = (r20 + r22) * 31;
            boolean r24 = this.f5405f;
            if (r24 == true) goto L19;
            r12 = r24;
        L19:
            return r23 + r12;
        }

        public String toString() {
            return "DirectNetworkState(activeNetwork=" + this.f5400a + ", hasCapabilities=" + this.f5401b + ", validated=" + this.f5402c + ", internet=" + this.f5403d + ", unmetered=" + this.f5404e + ", wifi=" + this.f5405f + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5407b;

        public b(boolean r10, boolean r11) {
            this.f5406a = r10;
            this.f5407b = r11;
        }

        public final boolean a() {
            return this.f5407b;
        }

        public final boolean b() {
            return this.f5406a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f5406a == r11.f5406a) goto L12;
            return false;
        L12:
            if (this.f5407b == r11.f5407b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r10 = this.f5406a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f5407b;
            if (r14 == true) goto L10;
            r11 = r14;
        L10:
            return r13 + r11;
        }

        public String toString() {
            return "FallbackNetworkState(validated=" + this.f5406a + ", unmetered=" + this.f5407b + ')';
        }
    }

    static {
        f5399a = new NetworkUtil();
    }

    private NetworkUtil() {
    }

    private final a a(Context r10) {
        Object r11 = r10.getSystemService("connectivity");
        NetworkCapabilities r12 = null;
        if ((r11 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r13 = (ConnectivityManager) r11;
    L6:
        if (r13 == null) goto L8;
        Network r14 = r13.getActiveNetwork();
    L9:
        if (r14 == null) goto L12;
        r12 = r13.getNetworkCapabilities(r14);
    L12:
        if (r14 == null) goto L15;
        String r15 = r14.toString();
        if (r15 == null) goto L15;
    L16:
        String r16 = r15;
        if (r12 == null) goto L19;
        boolean r17 = true;
    L20:
        if (r12 != null) goto L22;
    L24:
        boolean r18 = false;
    L25:
        if (r12 != null) goto L27;
    L29:
        boolean r19 = false;
    L30:
        if (r12 != null) goto L32;
    L34:
        boolean r20 = false;
    L35:
        if (r12 != null) goto L37;
    L39:
        boolean r21 = false;
    L41:
        return new a(r16, r17, r18, r19, r20, r21);
    L37:
        if (r12.hasTransport(1) != true) goto L39;
        r21 = true;
        goto L41
    L32:
        if (r12.hasCapability(11) != true) goto L34;
        r20 = true;
        goto L35
    L27:
        if (r12.hasCapability(12) != true) goto L29;
        r19 = true;
        goto L30
    L22:
        if (r12.hasCapability(16) != true) goto L24;
        r18 = true;
        goto L25
    L19:
        r17 = false;
    L15:
        r15 = "null";
        goto L16
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    private final b b() {
        return j(this, null, NetworkUtil$fallbackNetworkState$1.INSTANCE, 1, null);
    }

    public static /* synthetic */ b j(NetworkUtil r10, String r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = "NetworkStateStore";
    L6:
        return r10.i(r11, r12);
    }

    public final b c() {
        f.a r10 = f.f5423a.a().getValue();
        return new b(r10.a(), r10.b());
    }

    public final boolean d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        a r11 = a(r10);
        b r12 = b();
        boolean r13 = g(r11, r12);
        if (r11.b() == true) goto L6;
        d.f5417a.l("NetworkUtil", "isNetNotMetered result=" + r13 + " activeNetwork=" + r11.a() + " capabilities=null fallbackValidated=" + r12.b() + " fallbackUnmetered=" + r12.a());
        return r13;
    L6:
        d.f5417a.c("NetworkUtil", "isNetNotMetered result=" + r13 + " activeNetwork=" + r11.a() + " validated=" + r11.e() + " internet=" + r11.c() + " unmetered=" + r11.d() + " wifi=" + r11.f() + " fallbackValidated=" + r12.b() + " fallbackUnmetered=" + r12.a());
        return r13;
    }

    public final boolean e(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        a r11 = a(r10);
        b r12 = b();
        boolean r13 = h(r11, r12);
        if (r11.b() == true) goto L6;
        d.f5417a.l("NetworkUtil", "isNetSystemUsable result=" + r13 + " activeNetwork=" + r11.a() + " capabilities=null fallbackValidated=" + r12.b() + " fallbackUnmetered=" + r12.a());
        return r13;
    L6:
        d.f5417a.c("NetworkUtil", "isNetSystemUsable result=" + r13 + " activeNetwork=" + r11.a() + " validated=" + r11.e() + " internet=" + r11.c() + " unmetered=" + r11.d() + " wifi=" + r11.f() + " fallbackValidated=" + r12.b() + " fallbackUnmetered=" + r12.a());
        return r13;
    }

    public final boolean f(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        a r11 = a(r10);
        if (r11.b() == true) goto L5;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == true) goto L14;
        d.f5417a.c("NetworkUtil", "isWifiAvail result=false activeNetwork=" + r11.a() + " hasCapabilities=" + r11.b() + " validated=" + r11.e() + " internet=" + r11.c() + " unmetered=" + r11.d() + " wifi=" + r11.f());
    L14:
        return r12;
    L5:
        if (r11.f() == false) goto L11;
        if (r11.c() == false) goto L11;
        if (r11.e() == false) goto L11;
        r12 = true;
        goto L12
    }

    public final boolean g(a r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "direct");
        Intrinsics.checkNotNullParameter(r11, "fallback");
        if (r10.b() == false) goto L6;
        return r10.d();
    L6:
        return r11.a();
    }

    public final boolean h(a r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "direct");
        Intrinsics.checkNotNullParameter(r11, "fallback");
        if (r10.b() == false) goto L6;
        return r10.e();
    L6:
        return r11.b();
    }

    public final b i(String r10, Function0<b> r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "provider");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m32constructorimpl(r11.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L14;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
        d.f5417a.l("NetworkUtil", "fallbackNetworkState unavailable source=" + r10 + " error=" + r14.getClass().getName() + ": " + r14.getMessage() + " using validated=false unmetered=false");     // Catch: Throwable -> L11
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L14:
        if (Result.m35exceptionOrNullimpl(r13) == null) goto L18;
        r13 = new b(false, false);
    L18:
        return (b) r13;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
