package pa;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f {
    public y36.a a;
    public y36.a b;
    public y36.a c;

    public a() {
    }

    public final void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        y36.a r0 = new y36.a(r10, "enable_prefetch", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        Boolean r11 = Boolean.TRUE;
        y36.a r1 = new y36.a(r10, "enable_model_pre_create", r11);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.b = r1;
        y36.a r12 = new y36.a(r10, "enable_engine_preload", r11);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.c = r12;
    }
}
