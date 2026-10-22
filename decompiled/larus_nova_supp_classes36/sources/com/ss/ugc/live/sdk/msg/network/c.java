package com.ss.ugc.live.sdk.msg.network;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements amc.d {
    public c() {
    }

    @Override // amc.d
    public final Map<String, String> a() {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("compress", "gzip")});
    }

    @Override // amc.d
    public final byte[] b(tlc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        byte[] r0 = r3.e;
        if (Intrinsics.areEqual(com.ss.ugc.live.sdk.msg.utils.h.a(r3), "gzip") == true) goto L5;
        return r0;
    L5:
        return com.ss.ugc.live.sdk.msg.utils.b.a(r0);
    }
}
