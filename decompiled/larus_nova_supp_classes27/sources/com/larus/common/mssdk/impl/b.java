package com.larus.common.mssdk.impl;

import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ b(Ref.BooleanRef r1, CountDownLatch r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Ref.BooleanRef r0 = this.a;
        CountDownLatch r1 = this.b;
        boolean r5 = ((Boolean) r4).booleanValue();
        int r2 = SecurityServiceImpl.l;
        r0.element = r5;
        r1.countDown();
        return Unit.INSTANCE;
    }
}
