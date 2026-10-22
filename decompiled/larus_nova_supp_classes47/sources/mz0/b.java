package mz0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements a {
    public final com.bytedance.android.livesdk.revenue.log.b a;

    @Override // mz0.a
    public final void g() {
        this.a.g();
    }

    @Override // mz0.a
    public final void i() {
        this.a.i();
    }

    @Override // mz0.a
    public final void k() {
        this.a.k();
    }

    public b(com.bytedance.android.livesdk.revenue.log.b r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorLinkLog");
        this.a = r2;
    }

    @Override // mz0.a
    public final void b(String r2) {
        this.a.b(r2);
    }

    @Override // mz0.a
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "connectionType");
        this.a.c(r2);
    }

    @Override // mz0.a
    public final void d(long r2) {
        this.a.d(r2);
    }

    @Override // mz0.a
    public final void e(String r2) {
        this.a.e(r2);
    }

    @Override // mz0.a
    public final void f(String r2) {
        this.a.f(r2);
    }

    @Override // mz0.a
    public final void h(boolean r2) {
        this.a.h(r2);
    }

    @Override // mz0.a
    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inviteeList");
        this.a.j(r2);
    }
}
