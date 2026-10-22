package com.bytedance.android.livesdk.chatroom.utils;

import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v3 extends cc2.p<cc2.b> {
    public final Set<cc2.b> f;
    public final Set<cc2.b> g;

    public final Set<cc2.b> b() {
        return this.g;
    }

    public final Set<cc2.b> c() {
        return this.f;
    }

    public v3(w3 r4) {
        super(true, r4);
        this.f = SetsKt.emptySet();
        this.g = SetsKt.setOf(new cc2.b[]{cc2.b.c.c, cc2.b.b.c, cc2.b.a.c});
    }
}
