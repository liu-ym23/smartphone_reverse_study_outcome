package com.ss.android.lark.optrace.core;

import com.ss.android.lark.optrace.api.TracingCoreSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final TracingCoreSpan a;
    public final a b;

    public a(b r1, TracingCoreSpan r2) {
        this.a = r2;
        this.b = r1.a.get();
        r1.a.set(this);
    }
}
