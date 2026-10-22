package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends c {
    public final String q;

    public m() {
        this.q = "highlevel_or_fans_enter";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "statMap");
        r6.put(this.q + this.j, String.valueOf(this.c));
        r6.put(this.q + this.o, String.valueOf(c(this.f, this.c)));
        r6.put(this.q + this.k, String.valueOf(c(this.g, this.c)));
        r6.put(this.q + this.l, String.valueOf(c(this.h, this.c)));
        r6.put(this.q + this.m, String.valueOf(this.d));
        r6.put(this.q + this.n, String.valueOf(this.e));
    }
}
