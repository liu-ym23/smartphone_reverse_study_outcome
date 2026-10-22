package o48;

import kotlin.jvm.internal.Intrinsics;
import n38.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements p {
    public final /* synthetic */ u64.a a;

    public b(u64.a r1) {
        this.a = r1;
    }

    public final void a(n38.e r2) {
        Intrinsics.checkNotNullParameter(r2, "oouYinTokenResult");
        this.a.a(c.a(r2));
    }

    public final void onFail(int r2) {
        this.a.onFail(r2);
    }
}
