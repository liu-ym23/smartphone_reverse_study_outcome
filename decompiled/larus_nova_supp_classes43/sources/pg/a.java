package pg;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public a() {
    }

    @Override // pg.c
    public final void b() {
        Intrinsics.checkNotNullParameter("intention_category", "featureName");
        Intrinsics.checkNotNullParameter("ecom_feature_infra", "businessName");
    }

    @Override // pg.c
    public final void init() {
    }

    @Override // pg.c
    public final void a(Function1 r10) {
        Intrinsics.checkNotNullParameter("product_list_for_live_room_last_1cl_concat", "featureName");
        Intrinsics.checkNotNullParameter("ecom_feature_infra", "businessName");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r10.invoke(null);
    }
}
