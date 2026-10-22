package tz0;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends a {
    public static final b a = null;

    @Override // tz0.a
    public final List<com.bytedance.android.livesdk.revenue.network.a> a() {
        List r1 = com.bytedance.revenue.platform.api.core.c.a(new c[]{new c()});
        com.bytedance.android.livesdk.revenue.network.a[] r0 = {new vz0.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class))};
        Intrinsics.checkNotNullParameter(r0, "elements");
        List r2 = ArraysKt.toMutableList(r0);
        if (v.a() == false) goto L6;
        r2.add(new vz0.b());
    L6:
        return CollectionsKt.plus(r1, r2);
    }

    static {
        a = new b();
    }

    public b() {
    }

    @Override // tz0.a
    public final INetworkService.Biz b() {
        return INetworkService.Biz.Revenue;
    }
}
