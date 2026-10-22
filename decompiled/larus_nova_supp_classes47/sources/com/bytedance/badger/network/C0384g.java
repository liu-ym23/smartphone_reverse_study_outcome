package com.bytedance.badger.network;

import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.badger.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0384g extends Lambda implements Function1 {
    final /* synthetic */ int a;
    final /* synthetic */ n0 b;
    final /* synthetic */ Function6 c;

    public C0384g(int r1, n0 r2, Function6 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(1);
    }

    public Object invoke(Object r3) {
        BadgerUpdateInfo r4 = (BadgerUpdateInfo) r3;
        e.f("BadgerNetworkHandler", "collectFullReport - scene complete, status: " + this.a);
        o0.a.c(this.b, this.c);
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
        return Unit.INSTANCE;
    }
}
