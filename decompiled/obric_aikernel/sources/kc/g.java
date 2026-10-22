package kc;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealInterceptorChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealInterceptorChain.kt\nokhttp3/internal/http/RealInterceptorChain\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n1#2:124\n*E\n"})
public final class g implements t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.internal.connection.e f10167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<t> f10168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.connection.c f10170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x f10171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f10173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f10174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10175i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(okhttp3.internal.connection.e r10, List<? extends t> r11, int r12, okhttp3.internal.connection.c r13, x r14, int r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "interceptors");
        Intrinsics.checkNotNullParameter(r14, "request");
        this.f10167a = r10;
        this.f10168b = r11;
        this.f10169c = r12;
        this.f10170d = r13;
        this.f10171e = r14;
        this.f10172f = r15;
        this.f10173g = r16;
        this.f10174h = r17;
    }

    public static /* synthetic */ g e(g r10, int r11, okhttp3.internal.connection.c r12, x r13, int r14, int r15, int r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.f10169c;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.f10170d;
    L8:
        okhttp3.internal.connection.c r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.f10171e;
    L11:
        x r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.f10172f;
    L14:
        int r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.f10173g;
    L17:
        int r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.f10174h;
    L20:
        int r23 = r11;
        return r10.d(r23, r19, r20, r21, r22, r16);
    }

    @Override // okhttp3.t.a
    public x a() {
        return this.f10171e;
    }

    @Override // okhttp3.t.a
    public z b(x r15) {
        Intrinsics.checkNotNullParameter(r15, "request");
        boolean r10 = false;
        if (this.f10169c >= this.f10168b.size()) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L46;
        this.f10175i++;
        okhttp3.internal.connection.c r12 = this.f10170d;
        if (r12 != null) goto L10;
    L21:
        g r16 = e(this, this.f10169c + 1, null, r15, 0, 0, 0, 58, null);
        t r13 = this.f10168b.get(this.f10169c);
        z r14 = r13.a(r16);
        if (r14 == null) goto L44;
        if (this.f10170d == null) goto L37;
        if ((this.f10169c + 1) < this.f10168b.size()) goto L28;
    L31:
        boolean r17 = true;
    L32:
        if (r17 == true) goto L37;
        throw new IllegalStateException(("network interceptor " + r13 + " must call proceed() exactly once").toString());
    L28:
        if (r16.f10175i == 1) goto L31;
        r17 = false;
    L37:
        if (r14.a() == null) goto L39;
        r10 = true;
    L39:
        if (r10 == false) goto L42;
        return r14;
    L42:
        throw new IllegalStateException(("interceptor " + r13 + " returned a response with no body").toString());
    L44:
        throw new NullPointerException("interceptor " + r13 + " returned null");
    L10:
        if (r12.j().h(r15.l()) == false) goto L20;
        if (this.f10175i != 1) goto L14;
        boolean r18 = true;
    L15:
        if (r18 == true) goto L21;
        throw new IllegalStateException(("network interceptor " + this.f10168b.get(this.f10169c - 1) + " must call proceed() exactly once").toString());
    L14:
        r18 = false;
        goto L15
    L20:
        throw new IllegalStateException(("network interceptor " + this.f10168b.get(this.f10169c - 1) + " must retain the same host and port").toString());
    L46:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // okhttp3.t.a
    public okhttp3.i c() {
        okhttp3.internal.connection.c r10 = this.f10170d;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.h();
    }

    @Override // okhttp3.t.a
    public okhttp3.e call() {
        return this.f10167a;
    }

    public final g d(int r12, okhttp3.internal.connection.c r13, x r14, int r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r14, "request");
        return new g(this.f10167a, this.f10168b, r12, r13, r14, r15, r16, r17);
    }

    public final okhttp3.internal.connection.e f() {
        return this.f10167a;
    }

    public final int g() {
        return this.f10172f;
    }

    public final okhttp3.internal.connection.c h() {
        return this.f10170d;
    }

    public final int i() {
        return this.f10173g;
    }

    public final x j() {
        return this.f10171e;
    }

    public final int k() {
        return this.f10174h;
    }

    public int l() {
        return this.f10173g;
    }
}
