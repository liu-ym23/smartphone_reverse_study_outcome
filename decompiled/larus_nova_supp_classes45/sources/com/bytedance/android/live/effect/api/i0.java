package com.bytedance.android.live.effect.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 implements p {
    public final LiveEffectContextFactoryDelegate$Type a;

    public final j0 a() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r1 = u.a;
        return new j0(u.b(this.a).b());
    }

    public i0(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }
}
