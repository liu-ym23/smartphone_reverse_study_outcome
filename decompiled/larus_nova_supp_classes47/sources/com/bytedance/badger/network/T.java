package com.bytedance.badger.network;

import com.bytedance.badger.e;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class T extends Lambda implements Function0 {
    final /* synthetic */ b a;
    final /* synthetic */ z64.b b;

    public T(b r1, z64.b r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        e.f("BadgerCustomReportHandler", "uploadReport - scene: " + this.a.a + ", stage: " + this.a.d);
        o0 r0 = o0.a;
        o0.g(this.b, new n0(this.a.b, 30000, TriggerStage.custom, null, 496), true, new S(this));
        return Unit.INSTANCE;
    }
}
