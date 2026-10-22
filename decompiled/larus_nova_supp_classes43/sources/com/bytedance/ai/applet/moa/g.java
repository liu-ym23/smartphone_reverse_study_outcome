package com.bytedance.ai.applet.moa;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final i a;
    public final m b;
    public final u2.e c;
    public final List<u2.f> d;
    public final boolean e;
    public volatile f f;
    public int g;

    public final u2.f a() {
        return (u2.f) CollectionsKt.getOrNull(this.d, this.g);
    }

    public g(i r10, m r11, u2.e r12, List r13, boolean r14, com.bytedance.applet.impl.moa.a r15) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "grantingData");
        Intrinsics.checkNotNullParameter(r13, "grantingItems");
        Intrinsics.checkNotNullParameter(r15, "callback");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
