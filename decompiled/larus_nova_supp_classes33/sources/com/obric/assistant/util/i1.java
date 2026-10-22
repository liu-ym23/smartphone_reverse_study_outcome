package com.obric.assistant.util;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i1 implements Function0 {
    public final /* synthetic */ KeepScreenOnDelegate a;
    public final /* synthetic */ KeepScreenOnDelegate.KeepScreenOnReason b;

    public /* synthetic */ i1(KeepScreenOnDelegate r1, KeepScreenOnDelegate.KeepScreenOnReason r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        KeepScreenOnDelegate r0 = this.a;
        KeepScreenOnDelegate.KeepScreenOnReason r1 = this.b;
        r0.f.put(r1, Long.valueOf(SystemClock.uptimeMillis() + 30000));
        r0.j();
        return Unit.INSTANCE;
    }
}
