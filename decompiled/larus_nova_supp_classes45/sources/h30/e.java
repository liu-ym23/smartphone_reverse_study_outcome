package h30;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements a {
    public final /* synthetic */ f.a a;

    public e(f.a r1) {
        this.a = r1;
    }

    @Override // h30.a
    public final void a(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        f.a r3 = this.a;
        String r0 = f.c;
        r3.getClass();
        r3.finishWithResult(f.a.j(r0));
    }

    @Override // h30.a
    public final void onPermissionDenied(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        f.a r3 = this.a;
        String r0 = f.d;
        r3.getClass();
        r3.finishWithResult(f.a.j(r0));
    }

    @Override // h30.a
    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        f.a r3 = this.a;
        String r0 = f.b;
        r3.getClass();
        r3.finishWithResult(f.a.j(r0));
    }
}
