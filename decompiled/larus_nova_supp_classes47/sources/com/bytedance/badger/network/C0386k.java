package com.bytedance.badger.network;

import com.bytedance.badger.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0386k extends Lambda implements Function0 {
    final /* synthetic */ a0 a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Function6 d;

    public C0386k(a0 r1, int r2, int r3, Function6 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        super(0);
    }

    public Object invoke() {
        e.f("BadgerNetworkRetryHandler", "network is available and callback, execute...");
        u0 r0 = u0.h;
        a0 r1 = this.a;
        int r2 = this.b;
        int r3 = this.c;
        Function6 r4 = this.d;
        com.bytedance.badger.C.a r5 = com.bytedance.badger.C.a.d;
        r0.getClass();
        u0.b(r1, r2, r3, r4, r5);
        return Unit.INSTANCE;
    }
}
