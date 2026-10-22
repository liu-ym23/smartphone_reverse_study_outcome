package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ AggregateFuture a;
    public final /* synthetic */ ImmutableCollection b;

    public /* synthetic */ l(AggregateFuture r1, ImmutableCollection r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AggregateFuture.b(this.a, this.b);
    }
}
