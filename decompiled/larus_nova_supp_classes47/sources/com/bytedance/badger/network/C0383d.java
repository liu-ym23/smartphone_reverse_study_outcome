package com.bytedance.badger.network;

import com.bytedance.badger.e;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.f;

/* JADX INFO: renamed from: com.bytedance.badger.network.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0383d extends Lambda implements Function1 {
    final /* synthetic */ TriggerStage a;
    final /* synthetic */ f b;

    public C0383d(TriggerStage r1, f r2) {
        this.a = r1;
        this.b = r2;
        super(1);
    }

    public Object invoke(Object r20) {
        Throwable r1 = (Throwable) r20;
        e.c("BadgerNetworkHandler", "sendFollowUpRequest - failed to send follow-up request", r1);
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.c, this.a, r1, 0, null, 0, 0, 0, this.b, null, false, 0, null, null, 7948);
        return Unit.INSTANCE;
    }
}
