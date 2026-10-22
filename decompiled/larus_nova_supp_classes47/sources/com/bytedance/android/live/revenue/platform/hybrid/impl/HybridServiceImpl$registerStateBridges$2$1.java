package com.bytedance.android.live.revenue.platform.hybrid.impl;

import bz0.l;
import com.bytedance.android.live.revenue.platform.hybrid.impl.state.c;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import cq2.h;
import cq2.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/google/gson/Gson;", "gson", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcq2/i;", "stub", "Lcq2/h;", "invoke", "(Lcom/google/gson/Gson;Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcq2/i;)Lcq2/h;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class HybridServiceImpl$registerStateBridges$2$1 extends Lambda implements Function3<Gson, DataCenter, i, h> {
    final /* synthetic */ l.b $builder;

    public HybridServiceImpl$registerStateBridges$2$1(l.b r1) {
        super(3);
    }

    public final h invoke(Gson r5, DataCenter r6, i r7) {
        Intrinsics.checkNotNullParameter(r5, "gson");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "stub");
        Intrinsics.checkNotNullParameter(r5, "gson");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(null, "builder");
        Intrinsics.checkNotNullParameter(r7, "stub");
        new c.a(r5, r6);
        Intrinsics.checkNotNullParameter(r5, "gson");
        Intrinsics.checkNotNullParameter(r7, "stub");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Gson) r1, (DataCenter) r2, (i) r3);
    }
}
