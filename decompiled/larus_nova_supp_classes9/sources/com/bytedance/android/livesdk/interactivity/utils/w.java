package com.bytedance.android.livesdk.interactivity.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends c {
    public final String q;

    public w() {
        this.q = "shopping_message";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "statMap");
        r6.put(this.q + this.j, String.valueOf(this.c));
        r6.put(this.q + this.k, "0");
        r6.put(this.q + this.l, String.valueOf(c(this.h, this.c)));
    }
}
