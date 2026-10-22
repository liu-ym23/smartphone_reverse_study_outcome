package qp9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements j.b {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // qp9.j.b
    public final boolean a(View r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "detector");
        i r4 = this.a.a;
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.d(r3);
    }

    @Override // qp9.j.b
    public final boolean b(View r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "detector");
        i r4 = this.a.a;
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.c(r3);
    }

    @Override // qp9.j.b
    public final void c(View r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "detector");
        i r4 = this.a.a;
        if (r4 == null) goto L6;
        r4.b(r3);
        return;
    }
}
