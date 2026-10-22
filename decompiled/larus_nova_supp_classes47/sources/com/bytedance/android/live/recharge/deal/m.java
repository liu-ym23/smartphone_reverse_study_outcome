package com.bytedance.android.live.recharge.deal;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final Map<String, String> a;
    public final Map<String, Object> b;
    public final long c;
    public final Entrance d;
    public final FetchFrom e;

    public m(long r2, Entrance r4, FetchFrom r5) {
        Intrinsics.checkNotNullParameter(r4, "entrance");
        Intrinsics.checkNotNullParameter(r5, "fetchFrom");
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.a = new HashMap();
        this.b = new HashMap();
    }
}
