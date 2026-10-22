package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 implements h0.b<Object, Object> {
    public g0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revenue.platform.container.impl.h0.b
    public final <W> Map<String, String> b(W r3) {
        if ((r3 instanceof Throwable) == false) goto L6;
        return com.bytedance.platform.aio.d.g((Throwable) r3);
    L6:
        return com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("stackTrace", GsonProtectorUtils.toJsonTree(uh7.b.a, r3).toString())});
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.h0.b
    public final <V> h0.a<Object> a(V r3, BytesContentType r4) {
        Intrinsics.checkNotNullParameter(r4, "preferredContentType");
        if (r3 == null) goto L5;
        BytesContentType r0 = BytesContentType.PROTOBUF;
        if (r4 != r0) goto L11;
        Intrinsics.checkNotNullParameter(KmpEnv.a, "$this$isJsPlatform");
        uh7.c.d.getClass();
        Object r5 = uh7.c.f(r3);
        if (r5 != null) goto L13;
        r5 = uh7.c.e(r3);
    L13:
        if ((r5 instanceof byte[]) == true) goto L17;
        r0 = BytesContentType.JSON;
    L17:
        return new h0.a(r5, r0);
    L11:
        uh7.c.d.getClass();
        r5 = uh7.c.e(r3);
        goto L13
    L5:
        return new h0.a(new JsonObject(), BytesContentType.JSON);
    }
}
