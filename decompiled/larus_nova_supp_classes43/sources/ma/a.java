package ma;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f {
    public y36.a a;
    public p b;

    public a() {
    }

    public final void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        y36.a r0 = new y36.a(r10, "enable_blank_detect", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        p r1 = new p(r10, "bdhm_bid", "");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.b = r1;
    }
}
