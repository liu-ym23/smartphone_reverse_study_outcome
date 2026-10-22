package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import cc2.p;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends p<cc2.k> {
    public final Set<cc2.k> f;
    public final Set<cc2.k> g;

    @Override // cc2.p
    public final Set<cc2.k> b() {
        return this.f;
    }

    @Override // cc2.p
    public final Set<cc2.k> c() {
        return this.g;
    }

    public h(k r4) {
        super(true, r4);
        this.f = SetsKt.setOf(new cc2.k[]{cc2.k.b.c, cc2.k.a.c});
        this.g = SetsKt.emptySet();
    }
}
