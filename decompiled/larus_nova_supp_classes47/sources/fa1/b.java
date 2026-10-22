package fa1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o60.e {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;

    public final void onPermissionDenied(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        String r5 = rm3.c.a;
        rm3.c.f(this.a.getContext(), 2131922314, true, 16);
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.a.e(this.b);
    }

    public b(a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
