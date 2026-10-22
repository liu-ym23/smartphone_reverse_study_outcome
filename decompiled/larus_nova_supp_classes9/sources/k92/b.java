package k92;

import ak6.g;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import qb2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements e {
    public final /* synthetic */ TextView a;

    public b(TextView r1) {
        this.a = r1;
    }

    @Override // qb2.e
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        this.a.setText(r2.a);
    }
}
