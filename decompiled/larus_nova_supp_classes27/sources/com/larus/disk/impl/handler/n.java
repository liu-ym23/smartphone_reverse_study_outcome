package com.larus.disk.impl.handler;

import com.larus.disk.impl.d;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ FrescoCustomCacheHandler a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ n(FrescoCustomCacheHandler r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        FrescoCustomCacheHandler r0 = this.a;
        boolean r1 = this.b;
        ImageLoaderKt.c(r0.a, d.f(r1));
        return Unit.INSTANCE;
    }
}
