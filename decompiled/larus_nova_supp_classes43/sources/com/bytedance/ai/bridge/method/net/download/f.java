package com.bytedance.ai.bridge.method.net.download;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ a.b b;
    public final /* synthetic */ long c;

    public /* synthetic */ f(Ref.LongRef r1, a.b r10, long r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final Object invoke(Object r10) {
        Ref.LongRef r0 = this.a;
        a.b r1 = this.b;
        long r11 = this.c;
        long r12 = ((Long) r10).longValue();
        r0.element = r12;
        r1.d(new a.d.e(r12, r11));
        return Unit.INSTANCE;
    }
}
