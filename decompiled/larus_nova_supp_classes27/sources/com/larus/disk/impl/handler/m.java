package com.larus.disk.impl.handler;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ FrescoCustomCacheHandler a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ m(FrescoCustomCacheHandler r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return Long.valueOf(this.a.b(this.b));
    }
}
