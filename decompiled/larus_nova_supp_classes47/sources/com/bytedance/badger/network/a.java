package com.bytedance.badger.network;

import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class a extends Lambda implements Function0 {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    public a(String r1, String r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        com.bytedance.badger.C.b r0 = x64.b.a;
        x64.b.a(new x64.l(TriggerStage.login_finished, 15, false, null, this.a, this.b, 12), null);
        return Unit.INSTANCE;
    }
}
