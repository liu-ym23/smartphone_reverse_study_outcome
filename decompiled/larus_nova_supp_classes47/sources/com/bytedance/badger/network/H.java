package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.ReportStage;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class H extends Lambda implements Function0 {
    final /* synthetic */ J a;

    public H(J r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        z0 r0 = d0.a;
        b r1 = this.a.a;
        ReportStage r2 = ReportStage.FINAL;
        BadgerCore.Companion.getClass();
        j.a().addSceneCompletionCallback(r1.a, new Q(false, r1, r2));
        return Unit.INSTANCE;
    }
}
